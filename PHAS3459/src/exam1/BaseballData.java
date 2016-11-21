package exam1;

import java.io.*;
import java.net.URL;
import java.util.*;


public class BaseballData {

	public static String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/MLB2001Hitting.txt";

	/**Method reading in all the players Individually
	 * returning an ArrayList of all the players
	 */
	static ArrayList<BaseballPlayer> players(String url) throws IOException {

		//Reading the data from url and creating buffered reader.
		URL url1 = new URL(url); 
		try(	InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr).useDelimiter("\t|\n");
				){

			//Initialise the HashMap
			ArrayList<BaseballPlayer> playersAL = new ArrayList<BaseballPlayer>();

			//Skipping the first two lines of document:
			int n = 0;
			while(n < 2){ 
				scanner.nextLine();
				n = n + 1;
			}

			while(scanner.hasNext()){
				try{
					//Reading in data:
					String name = scanner.next();
					String teamname = scanner.next();
					String pos = scanner.next();
					int games = scanner.nextInt();
					int ab = scanner.nextInt();
					int r = scanner.nextInt();
					int h = scanner.nextInt();
					int secb = scanner.nextInt();
					int thirdb = scanner.nextInt();
					int hr = scanner.nextInt();
					int rbi = scanner.nextInt();
					double avg = scanner.nextDouble();
					double obp = scanner.nextDouble();
					//Create new BaseballPlayer Object from data:
					BaseballPlayer player = new BaseballPlayer(name, teamname, pos, games, ab, r, h, secb, thirdb, hr, rbi, avg, obp);
					playersAL.add(player);
				}
				catch(InputMismatchException e){
					System.out.println("problem with entry:"+scanner.next());
					System.out.println(e.getMessage());
				}
			}
			return playersAL;
		}
	}


	/**Method sorts players according to the team they play for. Forming a HashMap of the teams:
	 */
	static HashMap<String, Team> teams(String url) throws IOException {

		//Reading the data from url and creating buffered reader.
		URL url1 = new URL(url); 
		try(
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr).useDelimiter("\t|\n");){

			//Initialise the HashMap
			HashMap<String, Team> teamHM = new HashMap<String, Team>();

			//Skipping the first two lines of document:
			int n = 0;
			while(n < 2){ 
				scanner.nextLine();
				n = n + 1;
			}

			while(scanner.hasNext()){
				try{
					//Reading in data:
					String name = scanner.next();
					String teamname = scanner.next();
					String pos = scanner.next();
					int games = scanner.nextInt();
					int ab = scanner.nextInt();
					int r = scanner.nextInt();
					int h = scanner.nextInt();
					int secb = scanner.nextInt();
					int thirdb = scanner.nextInt();
					int hr = scanner.nextInt();
					int rbi = scanner.nextInt();
					double avg = scanner.nextDouble();
					double obp = scanner.nextDouble();
					//Create new BaseballPlayer Object from data:
					BaseballPlayer player = new BaseballPlayer(name, teamname, pos, games, ab, r, h, secb, thirdb, hr, rbi, avg, obp);

					//If the team does not exist, create a new team and adds player to team. 
					if(teamHM.containsKey(teamname) == false){
						Team team1 = new Team(teamname,  player);
						//add team to HashMap
						teamHM.put(teamname, team1);
					}
					//If the team already exists, add the player to the team.
					else{
						Team teamExisting = teamHM.get(teamname);
						teamExisting.addPlayer(player);
						//add updated team to HashMap
						teamHM.put(teamname, teamExisting);
					}
				}
				catch(InputMismatchException e){
					System.out.println("problem with entry:"+scanner.next());
					System.out.println(e.getMessage());
				}
			}
			return teamHM;
		}
	}

	public static void main(String[] args) {

		System.out.println("Analysing Baseball data from 2001 found at: "+dataURL+"\n");

		try{

			ArrayList<BaseballPlayer> players = players(dataURL);
			System.out.println("Total number of players recorded in file: "+players.size());


			//Printing details of the player with the most home runs:

			BaseballPlayer mostHomeRuns = (null);
			int MaxhomeRuns = 0;

			for(BaseballPlayer bp : players){
				int PlayershomeRuns = bp.getHomeruns();
				// If the player has scored the mist home runs, update the player 
				// with the most home runs to be this player and the MaxhomeRuns value.
				if(PlayershomeRuns > MaxhomeRuns){
					MaxhomeRuns = PlayershomeRuns;
					mostHomeRuns = bp;
				}
			}
			System.out.println("\nPlayer with most home runs: "+mostHomeRuns);

		}
		catch (IOException e) {
			e.printStackTrace();
		}


		try {
			HashMap<String, Team> teamData = teams(dataURL);
			//For each team print:
			//	- the number of players with at least 10 At-bats
			//	- the plyer with =>10 at bats with highest slg value


			System.out.println("\nPlayer with 10 or more At-Bats for each team: \n");

			Iterator<Team> it2 = teamData.values().iterator();
			while(it2.hasNext()){
				Team teami = it2.next();
				String tname = teami.getName();

				double slgMax = 0;
				BaseballPlayer slgMaxPlayer = (null);
				
				Iterator<BaseballPlayer> it3 = teami.getPlayers().iterator();
				int TeamAtBatsCount = 0;


				while(it3.hasNext()){
					BaseballPlayer bbp = it3.next();
					int atbats = bbp.getAtBats();
					if(atbats >= 10){
						TeamAtBatsCount = TeamAtBatsCount + 1;

						//Update slg values
						double slg = (bbp.getHits() + 2*bbp.getDoubles() + 3*bbp.getTriples() + 4*bbp.getHomeruns())/atbats;

						if(slg >= slgMax){
							slgMax = slg;
							slgMaxPlayer = bbp;
						}
					}

				}
				System.out.println(tname+" has "+TeamAtBatsCount+" players with 10 or more at bats");
				System.out.println("Player with highest slg for on team "+tname+": "+slgMaxPlayer+"\n");
			}

		} 
		catch (IOException e) {
			e.printStackTrace();
		}



	}

}
