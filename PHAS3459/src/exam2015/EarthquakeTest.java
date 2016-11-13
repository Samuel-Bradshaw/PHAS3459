package exam2015;

/**
 * Analyses data on earthquakes by forming a HashMap out of the data found at
 * http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt.
 * Prints the info on the earthquake with the largest magnitude,
 * and for each month prints: the number of earthquakes for that month; the deepest earthquake; 
 * and the earthquake with the most accurately measured depth.
 */

import java.io.*;
import java.net.URL;
import java.util.*;

public class EarthquakeTest{

	public static String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/earthquakesCA1989.txt";

	static HashMap<String, Earthquake> EarthquakeData(String url) throws IOException{
		//Reading the data
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr);

		//Initialise the HashMap
		HashMap<String, Earthquake> earthquakes = new HashMap<String, Earthquake>();

		try(Scanner scanner = new Scanner(buffr);
				){ 
			//skip the first two lines of document:
			int n = 0;
			while(n < 2){ 
				scanner.nextLine();
				n = n + 1;
			}
			//Adding each earthquake to the HashMap:
			while(scanner.hasNext()){
				int year = scanner.nextInt();
				int month = scanner.nextInt();
				int day = scanner.nextInt();
				Date date = new Date(year, month, day);

				int hour = scanner.nextInt();
				int minute = scanner.nextInt();
				double seconds = scanner.nextDouble();
				Time time = new Time(hour, minute, seconds);

				double lat = scanner.nextDouble();
				double lon = scanner.nextDouble();
				Location loc = new Location(lat, lon);

				double depth = scanner.nextDouble();
				double eh1 = scanner.nextDouble();
				double eh2 = scanner.nextDouble();
				double az = scanner.nextDouble();
				double deptherror = scanner.nextDouble();
				double magnitude = scanner.nextDouble();
				String id = scanner.next();
				//create new Earthquake object out of constituent variables
				Earthquake earthquake = new Earthquake(date, time, loc, depth, eh1, eh2, az, deptherror, magnitude, id);
				//add Earthquake object to HashMap with the key being its unique ID code.
				earthquakes.put(id, earthquake);
			}
		}
		return earthquakes;
	}


	public static void main(String[] args) {
		try {
			//Create new HashMap from data in online document:
			HashMap<String, Earthquake> earthquakes = EarthquakeData(dataURL);

			System.out.println("Analysing earthquake data from: "+dataURL);
			System.out.println("Number of earthquakes in data set: "+earthquakes.size());


			//Print details of earthquake with largest magnitude:

			//Initialise earthquake with maximum magnitude variables
			double maxMag = 0;
			Earthquake maxMagEarthquake = (null);

			Iterator<Earthquake> iterator =  earthquakes.values().iterator();
			while(iterator.hasNext()){
				Earthquake eq = iterator.next();
				double mag = eq.getMagnitude();
				if(mag > maxMag){ 
					maxMag = mag; //updating maxMag value if the value exceeds current maxValue
					maxMagEarthquake = eq;
				}
			}
			System.out.println("\nEarthquake with largest magnitude:\n"+maxMagEarthquake);

			//For each month, print: 
			//	-the number of earthquakes measured
			//	-full details of the deepest earthquake
			//	-full details of the earthquake whose depth is most accurately known

			System.out.println("Printing data for each month");

			//Running through each month (1-12) in turn:
			for(int i = 1; i <=12; i++){
				//initialising variables for each month:
				double maxDepth = 0;
				int monthCount = 0;
				double smallesterror = 10000.0;//This needs to be a large value. 
				Earthquake Mostaccuratelyknown = (null);
				Earthquake deepest = (null);
				//run the Iterator for each month.
				Iterator<Earthquake> iterator2 =  earthquakes.values().iterator();
				while(iterator2.hasNext()){
					Earthquake eq = iterator2.next();
					int month = eq.getDate().getMonth();
					if(i == month){ 				  //If the month of the earthquake in the iterator
						double depth = eq.getDepth(); //matches the current month we are looking at...
						double ez = eq.getError();
						monthCount = monthCount + 1;
						if(depth > maxDepth){ //update the earthquake with the maximum depth for that month
							maxDepth = depth;
							deepest = eq;
						}
						if( ez <  smallesterror){ //and update the the "smallest error" earthquake for that month.
							smallesterror = ez;
							Mostaccuratelyknown = eq;
						}
					}
				}
				//printing out the required values (see above^) for each month
				System.out.println("\nMonth: "+i+"\n");
				System.out.println("Total earthquakes in month:"+monthCount);
				System.out.println("\nDetails of deepest earthquake: \n"+deepest);
				System.out.println("Details of earthquake with most accurately known depth: \n"+Mostaccuratelyknown);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
