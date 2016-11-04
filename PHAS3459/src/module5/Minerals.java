package module5;


import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class Minerals {

	private static String mineralMassURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt"; 
	private static String mineralLocationURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";

	//Create a HashMap that reads the data from a URL and creates an object where the Key is the 
	//sample Key Code and the Value is the mass of the sample
	static HashMap<Integer, Double> mineralMass(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<Integer, Double> mineralmass = new HashMap<Integer, Double>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr);
				){ 
			while (scanner1.hasNext()){  		 
				int codenumber = scanner1.nextInt();	//Adding each entrySet to the HashMap
				double mass = scanner1.nextDouble();	//one at a time.
				mineralmass.put(codenumber, mass);
			}
		}
		return mineralmass;
	}

	//Create a HashMap that reads the data from a URL and creates an object where the Key is the 
	//sample Key Code and the Value is the location where the sample was found.
	static HashMap<Integer, String> mineralLocation(String url) throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		HashMap<Integer, String> minerallocation = new HashMap<Integer, String>(); //Initialising HashMap

		try(Scanner scanner1 = new Scanner(buffr);
				){ 
			while (scanner1.hasNext()){  		 
				String location = scanner1.next();	
				int code = scanner1.nextInt();
				minerallocation.put(code, location);
			}
		}
		return minerallocation;
	}

	//getsKeysByValue finds the corresponding Key Code for a given Value.
	//- As we later use this to find the Key of the Max and Min values in the data, we assume that there
	//is only one key code for the given values (i.e. that for the given values, it is a one-to-one map.)
	public static <K, V> K getKeysByValue(Map<K, V> map, V value) {
		//Set<K> keys = new HashSet<K>();						
		for (Entry<K, V> entry : map.entrySet()) {				//(If we want to alter this method for
			if (Objects.equals(value, entry.getValue())) {		//a many-to-one mapping, returning a set of keys
				return entry.getKey();// 						//instead of a single key, change return type from K to Set<K>,
				//keys.add(entry.getKey());						//"uncomment" //-lines  and remove lines ending with -//.)
			}
		}
		return null;//
		//return keys;
	}

	public static void main(String[] args) {

		try {
			//mineralmass is a HashMap where the Key is the sample key code and the value is the mass of the sample.
			HashMap<Integer, Double> mineralmass = mineralMass(mineralMassURL);
			System.out.println(mineralmass.entrySet());

			//mineralloc is a HashMap where the Key is the sample key code and the value is the location where the sample was found.
			HashMap<Integer, String> mineralloc = mineralLocation(mineralLocationURL);
			System.out.println(mineralloc.entrySet());

			//Maximum mass
			double maxMass = Collections.max(mineralmass.values());
			int maxMassKey = getKeysByValue(mineralmass, maxMass);
			String maxMassLoc = mineralloc.get(maxMassKey);

			System.out.println("\nKey code of sample with max mass: "+ maxMassKey);
			System.out.println("Max sample mass: "+maxMass+ " g");
			System.out.println("Location of max mass sample: "+maxMassLoc+"\n");

			//Minimum mass		
			double minMass = Collections.min(mineralmass.values());
			int minMassKey = getKeysByValue(mineralmass, minMass);
			String minMassLoc = mineralloc.get(minMassKey);

			System.out.println("Key Code of sample with min mass: "+ minMassKey);
			System.out.println("Min sample mass: "+minMass+ " g");
			System.out.println("Location of min mass sample: "+minMassLoc);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
