package exam1Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class exam2014 {

	public static String exoplanetURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/exoplanets.txt";

	//Creates a Hashmap of the planet name and the year of discovery
	static HashMap<String, Integer> PlanetYear(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<String, Integer> discoveryYear = new HashMap<String, Integer>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr).useDelimiter(",");
				){ 
			int n = 0;

			if (n == 0){   //Skipping the Header
				n = n + 1;
				scanner1.nextLine();
			}

			while (scanner1.hasNext()){  	
				String planetname = scanner1.next();	//Adding each entrySet to the HashMap
				int year = scanner1.nextInt();	//one at a time.
				discoveryYear.put(planetname, year);
				scanner1.nextLine();
			}
		}
		return discoveryYear;
	}

	//Returns a hashmap of the planet name and its method of discovery. 
	static HashMap<String, String> PlanetMethod(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<String, String> discoveryMethod = new HashMap<String, String>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr).useDelimiter(",");
				){ 
			int n = 0;

			if (n == 0){   //Skipping the Header
				n = n + 1;
				scanner1.nextLine();
			}

			while (scanner1.hasNext()){  	
				String planetname = scanner1.next();	//Adding each entrySet to the HashMap
				scanner1.nextInt();//skipping the discovery year
				String method = scanner1.next();	
				discoveryMethod.put(planetname, method);
				scanner1.nextLine();
			}
		}
		return discoveryMethod;
	}

	//Creates a Hashmap of the planet name and its mass
	static HashMap<String, Double> PlanetMass(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<String, Double> planetMass = new HashMap<String, Double>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr).useDelimiter(",");
				){ 
			int n = 0;

			if (n == 0){   //Skipping the Header
				n = n + 1;
				scanner1.nextLine();
			}

			while (scanner1.hasNext()){  	
				String planetname = scanner1.next();	//Adding each entrySet to the HashMap
				scanner1.nextInt();//skipping the discovery year
				scanner1.next();//skipping method discovery
				double mass = scanner1.nextDouble();	
				planetMass.put(planetname, mass);
				scanner1.nextLine();
			}
		}
		return planetMass;
	}

	//creates a hashmap if the planet name and its separation in a.u. from its star
	static HashMap<String, Double> PlanetSeparation(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<String, Double> planetSeparation = new HashMap<String, Double>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr).useDelimiter(",");
				){ 
			int n = 0;

			if (n == 0){   //Skipping the Header
				n = n + 1;
				scanner1.nextLine();
			}

			while (scanner1.hasNext()){  	
				String planetname = scanner1.next();	//Adding each entrySet to the HashMap
				scanner1.nextInt();//skipping the discovery year
				scanner1.next();//skipping method discovery
				scanner1.nextDouble();//skipping the mass
				double separation = scanner1.nextDouble();	
				planetSeparation.put(planetname, separation);
				scanner1.nextLine();
			}
		}
		return planetSeparation;
	}


	//creates a hashmap if the planet name and its distance in parsecs from earth
	static HashMap<String, Double> PlanetDistance(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<String, Double> planetDistance = new HashMap<String, Double>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr);
				){ 

			int n = 0;
			if (n == 0){   //Skipping the Header
				n = n + 1;
				scanner1.nextLine();
			}
			
			scanner1.useDelimiter(",");
			while(scanner1.hasNext()){
				String planetname = scanner1.next();//Adding each entrySet to the HashMap
				scanner1.next();//skip year
				scanner1.next();//skip method
				scanner1.next();//skip mass
				scanner1.next();//skip separation
				if (scanner1.hasNextDouble()){
					double distance = scanner1.nextDouble();
					System.out.println(planetname +": "+distance);
					planetDistance.put(planetname, distance);
					}
				else{
					System.out.println(planetname +": "+null);
					planetDistance.put(planetname, null);
				}

			}

		}
		return planetDistance;
	}
/**/
	public static void main(String[] args){
		try{
			HashMap<String, Integer> planetYear = PlanetYear(exoplanetURL); 
			HashMap<String, String> planetDiscoveryMethod = PlanetMethod(exoplanetURL);  
			HashMap<String, Double> planetMass = PlanetMass(exoplanetURL);
			HashMap<String, Double> planetSeparation = PlanetSeparation(exoplanetURL);

			System.out.println("Year discovered: "+planetYear.entrySet());
			System.out.println("method disocvered: "+planetDiscoveryMethod.entrySet());
			System.out.println("masses: "+planetMass.entrySet());
			System.out.println("exoplanet separation from star: "+planetSeparation.entrySet());

		  HashMap<String, Double> planetDistance = PlanetDistance(exoplanetURL);

			System.out.println(planetDistance.entrySet());

			
			

			
		}

		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
