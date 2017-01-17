package examII201415tides;

import java.io.*;
import java.net.URL;
import java.util.*;

public class TidesData {

	static String tidesURL1999 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt";
	static String tidesURL2000 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt";
	static String tidesURL2001 = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt";
	static String sitesURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt";

	/**
	 * Reads data from an online document and returns the resulting BufferedReader.
	 * 
	 * @param urlName the web address containing the data
	 * @return BufferedReader
	 * @throws IOException
	 */
	public BufferedReader brFromURL(String urlName) throws IOException{ 
		URL url = new URL(urlName); 
		InputStream istream = url.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 
		return buffr; 
	} 

	/**
	 * Method designed to read a single line of a BufferedReaded and
	 * create a tides Object from the data in the line.
	 *  
	 * @param line
	 * @return tides
	 * @throws IOException
	 */
	static tides tideFromBufferedReaderLine(String line) throws IOException {
		try(Scanner scanner = new Scanner(line)){

			//Initialise tides Object
			tides tide = new tides();

			try{
				//Reading in data from line:
				while(scanner.hasNext()){
					//The way we interpret BufferedReader depends on format of input:
					//for 1999-2001 data the port ID comes first in each line,
					//for 2004-2006 data the data comes first in each line.
					if(scanner.hasNextDouble() == false){
						String ID = scanner.next();
						int yr = scanner.nextInt();
						int mon = scanner.nextInt();
						int day = scanner.nextInt();
						int hour = scanner.nextInt();
						int min = scanner.nextInt();
						double level = scanner.nextDouble();
						double pLevel = scanner.nextDouble();
						tide = new tides(ID, yr, mon, day, hour, min, level, pLevel);
					}
					else {
						int yr = scanner.nextInt();
						int mon = scanner.nextInt();
						int day = scanner.nextInt();
						int hour = scanner.nextInt();
						int min = scanner.nextInt();
						String ID = scanner.next();
						double level = scanner.nextDouble();
						double pLevel = scanner.nextDouble();
						tide = new tides(ID, yr, mon, day, hour, min, level, pLevel);
					}
				}
			} catch(InputMismatchException e){
				System.out.println("problem with entry:"+scanner.next());
				System.out.println(e.getMessage());
			}

			return tide;
		}
	}

	/**
	 * Reads in data from online document and forms a HashMap of sites.
	 * @param url
	 * @return HashMap where the key is the Site ID and the value is a Site Object. 
	 * @throws IOException
	 */
	HashMap<String, Site> sitesFromURL(String url) throws IOException{
		//Reading in data from URL:
		URL url1 = new URL(url); 
		try(	
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr);
				){

			//Initialise HashMap:
			HashMap<String, Site> sites = new HashMap<String, Site>();

			//Skip first line of document:
			scanner.nextLine();	

			while (scanner.hasNext()){
				String name = scanner.next();					
				String ID = scanner.next();				
				Site site = new Site(name, ID);
				sites.put(ID, site);
			}
			return sites;
		}
	}

	public static void main(String[] args) {

		try {

			TidesData TD = new TidesData();

			//Create a HashMap where the Site ID is the key
			HashMap<String, Site> sites =  TD.sitesFromURL(sitesURL);

			//Read in data:
			BufferedReader reader1999 = TD.brFromURL(tidesURL1999);
			BufferedReader reader2000 = TD.brFromURL(tidesURL2000);
			BufferedReader reader2001 = TD.brFromURL(tidesURL2001);

			//Initialise ArrayList of tide measurements
			ArrayList<tides> tidesList = new ArrayList<tides>();

			//Initialise line:
			String line = "";

			//Add tides to 'tidesList' ArrayList:
			while ((line = reader1999.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line);
				tidesList.add(tidei);
			}
			while ((line = reader2000.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line);
				tidesList.add(tidei);
			}
			while ((line = reader2001.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line);
				tidesList.add(tidei);
			}

			//Print the details of the highest sea Level reading:

			double maxLevel = 0;
			tides maxTide = new tides();
			Site maxSite = new Site();

			for(tides t : tidesList){
				double level = t.getLevel();
				if(level > maxLevel){
					//Update values of maxLevel and the tides Object it corresponds to:
					maxLevel = level;
					maxTide = t;
					String id = t.getID();
					maxSite = sites.get(id);
				}
			}

			System.out.println("Reading with highest measurement:\n" +maxTide+
					"\nName of site: "+maxSite.getName()+"\n");

			// For each site print:
			// - The mean sea Level reading
			// - The tidal range at the site

			for(Site s: sites.values()){
				System.out.println(s);

				MeanCalculator meanCalc = new MeanCalculator();
				double mean = meanCalc.CalculateStat(tidesList, s);
				System.out.println("Mean reading at site: "+mean+" m");

				RangeCalculator rangeCalc = new RangeCalculator();
				double range = rangeCalc.CalculateStat(tidesList, s);
				System.out.println("Tidal range at site: "+range+" m\n");

			}	

			/**PART 3**/

			// Print details of the largest tidal surge:

			double MaxSurge = 0;
			tides maxSurgeTide = new tides();
			int count = 0;

			for(tides t: tidesList){
				double l = t.getLevel();
				double pl = t.getPredictedLevel();
				double surge = l - pl;
				if(count == 0){
					MaxSurge = surge;
					count = 1;
				}
				if(surge > MaxSurge){
					//Update values of MaxSurge and maxSurgeTide
					MaxSurge = surge;
					maxSurgeTide = t;
				}
			}

			System.out.println("Tide with largest Surge in 1999-2001 data:\n"+maxSurgeTide);
			System.out.println("Surge: "+MaxSurge+" m");

			//Read in data from new links:
			BufferedReader reader2004 = TD.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt");
			BufferedReader reader2005 = TD.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt");
			BufferedReader reader2006 = TD.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt");

			//Initialise ArrayList of tide measurements for 2004-2006:
			ArrayList<tides> tidesList2 = new ArrayList<tides>();

			//Add tides to 'tidesList2' ArrayList for 2004-2006 data:
			while ((line = reader2004.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line); //See below for tideFromBufferedReaderLine2(line) method,
				tidesList2.add(tidei);							 //adapted from tideFromBufferedReaderLine2(line).
			}
			while ((line = reader2005.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line);
				tidesList2.add(tidei);
			}
			while ((line = reader2006.readLine()) != null){
				tides tidei = tideFromBufferedReaderLine(line);
				tidesList2.add(tidei);
			}

			// Print details of the largest tidal surge for 2004-2006 data:

			double MaxSurge2 = 0;
			tides maxSurgeTide2 = new tides();
			int count2 = 0;

			for(tides t: tidesList2){
				double l = t.getLevel();
				double pl = t.getPredictedLevel();
				double surge = l - pl;
				if(count2 == 0){
					MaxSurge2 = surge;
					count2 = 1;
				}
				if(surge > MaxSurge2){
					//Update values of MaxSurge and maxSurgeTide
					MaxSurge2 = surge;
					maxSurgeTide2 = t;
				}
			}

			System.out.println("\nTide with largest Surge in 2004-2006 data:\n"+maxSurgeTide2);
			System.out.println("Surge: "+MaxSurge2+" m");


		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
