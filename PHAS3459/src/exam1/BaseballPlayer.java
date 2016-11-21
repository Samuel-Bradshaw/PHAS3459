package exam1;

public class BaseballPlayer {
	
	//member variables
	String name;
	String team;
	String Position;
	int games;
	int atBats;
	int runs;
	int hits;
	int doubles;
	int triples;
	int homeRuns;
	int runsBattedIn;
	double battingAverage;
	double onBasePercentage;
	
	//constructor
	BaseballPlayer(String player, String Team, String Pos, int G, int AB, int R, int H, int secb, int thirdb, int HR, int RBI, double AVG, double OBP){
		name = player;
		team = Team;
		Position = Pos;
		games = G;
		atBats = AB;
		runs = R;
		hits = H;
		doubles = secb;
		triples = thirdb;
		homeRuns = HR;
		runsBattedIn = RBI;
		battingAverage = AVG;
		onBasePercentage = OBP;
		
	}
	
	//presents data in readable form
		public String toString(){
			String playerString = "\n Name: "+name+"\n Team: "+team+"\n Position: "+Position+
					"\n Games: "+games+"\n At-bats: "+atBats+"\n Runs: "+runs+", Hits: "+hits+
					", Doubles: "+doubles+", Triples: "+triples+"\n Home Runs: "+homeRuns+ 
					"\n Runs Batted In: "+runsBattedIn+"\n Batting Average: "+battingAverage+
					"\n On-Base Percentage: "+onBasePercentage;
			return playerString;
		}
		
		
		public int getHomeruns(){
			return homeRuns;
		}
		
		public int getAtBats(){
			return atBats;
		}
	
		public int getHits(){
			return hits;
		}
		public int getDoubles(){
			return doubles;
		}
		public int getTriples(){
			return triples;
		}
		

}
