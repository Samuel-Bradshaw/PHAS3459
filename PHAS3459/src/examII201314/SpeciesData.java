package examII201314;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class SpeciesData {

	static String PlantSurveyURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-plants.txt";
	static String PlantSpeciesURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-plants.txt";

	/**
	 * Reads data from an online document and returns the resulting BufferedReader.
	 * 
	 * @param urlName - the web address containing the data
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
	 * Method designed to be passed a single line of a BufferedReaded and
	 * create a PlantSpecimen Object from the data in the line.
	 *  
	 * @param line - line from a BufferedReader
	 * @return Specimen - Created from the data in the line
	 * @throws IOException
	 */
	static Specimen SpecimenFromBR(String line) throws IOException {
		try(Scanner scanner = new Scanner(line)){

			//Initialise new Specimen Object
			Specimen Specimen = new Specimen();

			try{
				double lat = scanner.nextDouble();
				double lon = scanner.nextDouble();
				String ID = scanner.next();
				if(scanner.hasNextDouble()){
					double height = scanner.nextDouble();

					Specimen = new PlantSpecimen(lat, lon, ID, height);
					Specimen = (PlantSpecimen) Specimen;
				}
				else{
					Specimen = new Specimen(lat, lon, ID);
				}

			} catch(InputMismatchException e){
				System.out.println("problem with entry:"+scanner.next());
				System.out.println(e.getMessage());
			}
			return Specimen;
		}
	}

	/**
	 * Reads in data from an online document and creates a HashMap where the key is the Species
	 * ID and the Value is the full scientific name of the species.
	 * 
	 * @param url - The URL web address of the online data document in String form
	 * @return A HashMap where the key is the Species ID and the Value is the full scientific name
	 * of the species.
	 * @throws IOException
	 */
	HashMap<String, Species> SpeciesFromURL(String url) throws IOException{
		//Reading in data from URL:
		URL url1 = new URL(url); 
		try(	
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);
				Scanner scanner = new Scanner(buffr);
				){
			//Initialise HashMap:
			HashMap<String, Species> Species = new HashMap<String, Species>();
			try{
				while(scanner.hasNextLine()){
					String IDkey = scanner.next();
					String FullName = scanner.nextLine().trim();
					Species spec = new Species(IDkey, FullName);
					Species.put(IDkey, spec);
				}
			}catch(InputMismatchException e){
				System.out.println("problem with entry:"+scanner.next());
				System.out.println(e.getMessage());
			}
			return Species;
		}
	}

	/**
	 * Finds the Key for a given Value in a Map Container.
	 * @param map - the Map we want to find the key in.
	 * @param value - the value inside the Map we want to find the key for
	 * @return the key ID for the value
	 */
	public static <K, V> K getKeysByValue(Map<K, V> map, V value) {
		for (Entry<K, V> entry : map.entrySet()) {				
			if (Objects.equals(value, entry.getValue())) {		
				return entry.getKey();										 
			}													
		}
		return null;
	}

	/**
	 * 
	 * @param plants - an ArrayList of Plants  
	 * @param plantID - the ID code of the particular Species we want to find the mean of
	 * @return
	 */
	static double calculateMeanHeightofSpecies(ArrayList<Specimen> plants, String plantID){

		int count = 0;
		double heightCount = 0;

		//Iterate through values to find the total count and heightCount of particular species:
		for(Specimen PS: plants){
			if(PS.getID().equals(plantID)){
				count = count+ 1;
				heightCount = heightCount + ((PlantSpecimen) PS).getHeight();
			}		
		}
		double mean = heightCount/(double)count;
		return mean;
	}

	public static void main(String[] args) {

		SpeciesData PD = new SpeciesData();
		try {
			//Reading in and storing species data in a HashMap:
			HashMap<String, Species> SpeciesHM = PD.SpeciesFromURL(PlantSpeciesURL);

			//Initialise ArrayList of PlantSpecimen :
			ArrayList<Specimen> PlantSpecimens = new ArrayList<Specimen>();

			//Reading in plant survey data:
			BufferedReader PlantBR = PD.brFromURL(PlantSurveyURL);

			//Initialise line:
			String line = "";

			//Adding PlantSpecimen to ArrayList:
			while((line = PlantBR.readLine()) != null){
				PlantSpecimen PS =  (PlantSpecimen) SpecimenFromBR(line);
				PlantSpecimens.add(PS);
			}

			//For each of the species print 
			// - the scientific name 
			// - the number of specimens found
			// - their mean height 

			//Iterate through ArrayList of plant data:
			for(Specimen PS: PlantSpecimens){
				String ID = PS.getID();
				Species spec = SpeciesHM.get(ID);
				//Update the data of each species contained in HashMap:
				spec.AddToHeightCount(((PlantSpecimen) PS).getHeight());
				spec.AddToSpeciesCount();
			}

			//Printing values for each species:
			for(Species spec : SpeciesHM.values()){
				System.out.println("Species ID code: "+spec.getID());
				System.out.println("Scientific Name: "+spec.getName());
				System.out.println("Number of species found: "+spec.getCount());
				System.out.println("Mean height: "+spec.getMean()+" cm\n");
			}

			//Print the scientific names of the species with the highest and lowest mean height.

			Species maxMeanSpec = new Species();
			Species minMeanSpec = new Species();
			int n = 0;

			for(Species spec : SpeciesHM.values()){
				if(n == 0){					
					n = 1;					
					maxMeanSpec = spec;
					minMeanSpec = spec;
				}
				if(spec.getMean() > maxMeanSpec.getMean()){
					maxMeanSpec = spec;
				}
				if(spec.getMean() < minMeanSpec.getMean()){
					minMeanSpec = spec;
				}
			}

			System.out.println("\nSpecies with smallest mean height is "+SpeciesHM.get(minMeanSpec.getID()).getName()+
					" with a mean height of "+SpeciesHM.get(minMeanSpec.getID()).getMean()+" cm");
			System.out.println("Species with largest mean height is "+SpeciesHM.get(maxMeanSpec.getID()).getName()+
					" with a mean height of "+SpeciesHM.get(maxMeanSpec.getID()).getMean()+" cm");

			/**PART 2**/

			//Calculate the mean height of the species Urtica dioica for specimens found 
			// North of latitude -30;
			// South of latitude -30;

			System.out.println(SpeciesHM.entrySet());

			SpecimenWithinLatitudeBounds AboveMinusThirty = new SpecimenWithinLatitudeBounds(-30, Regional.maxLat);
			SpecimenWithinLatitudeBounds BelowMinusThirty = new SpecimenWithinLatitudeBounds(Regional.minLat, -30);

			ArrayList<Specimen> PlantsAboveMinusThirty = AboveMinusThirty.returnSpecimenInRegion(PlantSpecimens);
			ArrayList<Specimen> PlantsBelowMinusThirty = BelowMinusThirty.returnSpecimenInRegion(PlantSpecimens);
			for(Specimen s: PlantsAboveMinusThirty){
				s = (PlantSpecimen) s;
			}

			//Above -30:
			double meanNTAboveMinus30 = calculateMeanHeightofSpecies(PlantsAboveMinusThirty, "NT");
			System.out.println("Average size of Urtica dioica above a latitude of -30: "+meanNTAboveMinus30+" cm");

			//Similarly for Below -30:
			double meanNTBelowMinus30 = calculateMeanHeightofSpecies(PlantsBelowMinusThirty, "NT");
			System.out.println("Average size of Urtica dioica below a latitude of -30: "+meanNTBelowMinus30+" cm");

			/*
			 * Calculate the mean height of species Solanum carolinense for 
			 * specimens found within 50 km of the summit of the island’s highest mountain,
			 * which is located at latitude -30.967◦ and longitude 75.430◦:
			 */

			SpecimenWithinDistanceOfPoint mountain = new SpecimenWithinDistanceOfPoint(-30.967, 75.430, 50);

			ArrayList<Specimen> MountainPlants = mountain.returnSpecimenInRegion(PlantSpecimens);

			double meanMount = calculateMeanHeightofSpecies(MountainPlants, "BN");
			System.out.println("\nAverage size of Solanum carolinense for specimens found" +
					"\nwithin 50 km of the summit of the island’s highest mountain: "+meanMount+" cm");


		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try{
			/**PART 3**/

			//Read in animal data:

			HashMap<String, Species> AHM = PD.SpeciesFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/species-animals.txt");

			BufferedReader ABR = PD.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2013-14/survey-animals.txt");

			ArrayList<Specimen> ASpecimens = new ArrayList<Specimen>();

			String line = "";
			while((line = ABR.readLine()) != null){
				Specimen AS = SpecimenFromBR(line);
				ASpecimens.add(AS);
			}

			/*  List the scientific names of all animal species that are exclusively 
			 *  found within 100 km of the mountain summit at latitude -30.967◦ and 
			 *  longitude 75.430.
			 */
			
			SpecimenWithinDistanceOfPoint mountain = new SpecimenWithinDistanceOfPoint(-30.967, 75.430, 100);

			ArrayList<Specimen> MountainAnimals =  mountain.returnSpecimenInRegion(ASpecimens);

			for(Specimen s :MountainAnimals){
				String key = s.getID();
				AHM.get(key).AddToSpeciesCount();
			}
			
			System.out.println("\nAnimal Species within 100km of mountain:");
			for(Species s: AHM.values()){
				if(s.getCount()>0){
					System.out.println(s.getName());
				}
			}


		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
