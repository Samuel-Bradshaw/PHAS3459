package examII1213;

import java.io.*;
import java.net.URL;
import java.util.*;

public class HiggsData {

	static String GGBackgroundDataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundGG.txt"; 
	static String ZZBackgroundDataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/backgroundZZ.txt";
	static String HiggsEventsURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/higgsData.txt";

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
	 * Method which takes a single line of a Buffered Reader and creates an EnergyBin Object.
	 * 
	 * @param line A BufferedReader string line with the tokens separated by whitespace  
	 * @return EnergyBin object
	 * @throws IOException
	 */
	static EnergyBin EnergyBinFromBR(String line) throws IOException{
		try(Scanner scanner = new Scanner(line)){
			//Initialise EnergyBin Object:
			EnergyBin EB = new EnergyBin();

			try{
				if(scanner.hasNextInt()){
					int LEE = scanner.nextInt();
					int HEE = scanner.nextInt();
					double PNE = scanner.nextDouble();
					EB = new EnergyBin(LEE, HEE, PNE);
				}

			} catch(InputMismatchException e){
				System.out.println("Problem with entry:"+scanner.next());
			}
			return EB;
		}
	}

	/**
	 * Forms a complete ArrayList of HiggsEvents given a URL web address of the data. 
	 * The data is assumed to take the format of the first token of each line being the Channel
	 * and the second token the event energy. The first line of the online document are headings.
	 * 
	 * @param url The web address where the data is to be found
	 * @return ArrayList<HiggsEvent>
	 * @throws IOException
	 */
	ArrayList<HiggsEvent> HiggsDataFromURL(String url) throws IOException{
		//Reading in data from URL:
		URL url1 = new URL(url);
		try(
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr);
				){

			//Initialise ArrayList:
			ArrayList<HiggsEvent> HElist = new ArrayList<HiggsEvent>();

			//Skip first line of document:
			scanner.nextLine();

			while(scanner.hasNext()){
				try{
					String channel = scanner.next();
					double energy = scanner.nextDouble();

					//Create new HiggsEvent Object and add it to ArrayList:
					HiggsEvent HE = new HiggsEvent(channel, energy);
					HElist.add(HE);

				} catch(InputMismatchException e){
					System.out.println("Problem with entry:"+scanner.next());
				}
			}
			return HElist;
		}

	}
	/**
	 * Returns the Log Likelihood measurement of an event occurring.
	 * @param background An ArrayList of expected Background events for each 1 GeV energy bin 
	 * @param signal An ArrayList of recorded events for each 1 GeV energy Bin
	 * @return The Log Likelihood
	 */
	static double LogLikelihood(ArrayList<Double> background, ArrayList<Double> signal){
		double logLikelihood = 0;
		for(int i = 0; i < background.size(); i++){
			double ni =  signal.get(i);
			double yi = background.get(i);
			logLikelihood = logLikelihood + (yi - ni) + ni*Math.log(ni/yi);
		}
		return logLikelihood;
	}
	/**
	 * Method overloading - Returns the Log Likelihood measurement of an event occurring.
	 * @param bg  An ArrayList of expected Background events for each 1 GeV energy bin in Energy Bin form
	 * @param signals A HashMap of Higgs Signals where the Key is the Lower Bound of the energy bin - thus it
	 * ranges from 100 - 199. 
	 * @return Log Likelihood.
	 */
	static double LogLikelihood(ArrayList<EnergyBin> bg, HashMap<Integer, HiggsEnergyBin> signals){
		double logLikelihood = 0;
		for(int i = 0; i < bg.size(); i++){
			if(signals.containsKey(i+100)){
				double ni =  signals.get(i+100).getEventsCount();
				double yi = bg.get(i).getEventsCount();
				logLikelihood = logLikelihood + (yi - ni) + ni*Math.log(ni/yi);
			}
		}
		return logLikelihood;
	}

	
	public static void main(String[] args) {
		try{
			HiggsData HD = new HiggsData();

			//Reading in the data and storing it as BufferedReader
			BufferedReader BRforGG = HD.brFromURL(GGBackgroundDataURL);
			BufferedReader BRforZZ = HD.brFromURL(ZZBackgroundDataURL);

			//Initialise separate ArrayList of EnergyBins for the ZZ and GG channels:
			ArrayList<EnergyBin> GGchannel = new ArrayList<EnergyBin>();
			ArrayList<EnergyBin> ZZchannel = new ArrayList<EnergyBin>();

			//Add EneryBins to ArrayLists:
			String line = "";	//-initialise line. 
			while((line = BRforGG.readLine()) != null){
				EnergyBin EB = EnergyBinFromBR(line);
				GGchannel.add(EB);
			}

			while((line = BRforZZ.readLine()) != null){
				EnergyBin EB = EnergyBinFromBR(line);
				ZZchannel.add(EB);
			}

			// The first Line of the BufferedReader are headings. 
			// Remove the blank EnergyBins created by these lines from each ArrayList:
			GGchannel.remove(0);
			ZZchannel.remove(0);

			// Determine the number of expected background events for the two channels 
			// in the range 120-140 GeV:

			//GG channel:

			double GGpredictedEventsInRangeCount = 0;

			for(EnergyBin EB : GGchannel){
				int LowEE = EB.getLowEE();
				int HighEE = EB.getHighEE();
				if(120 <= LowEE && HighEE <= 140){
					double PE = EB.getEventsCount();
					GGpredictedEventsInRangeCount = GGpredictedEventsInRangeCount + PE;
				}
			}

			System.out.println("Number of expected events in range 120-140 GeV for GG channel: "+GGpredictedEventsInRangeCount);

			//ZZ channel:

			double ZZpredictedEventsInRangeCount = 0;

			for(EnergyBin EB : ZZchannel){
				int LowEE = EB.getLowEE();
				int HighEE = EB.getHighEE();
				if(120 <= LowEE && HighEE <= 140){
					double PE = EB.getEventsCount();
					ZZpredictedEventsInRangeCount = ZZpredictedEventsInRangeCount + PE;
				}
			}

			System.out.println("Number of expected events in range 120-140 GeV for ZZ channel: "+ZZpredictedEventsInRangeCount);


			// Read in and Store the data for the Higgs Events:

			ArrayList<HiggsEvent> HiggsEventsList = HD.HiggsDataFromURL(HiggsEventsURL);

			// Create a HashMap where the Higgs Events are sorted into EnergyBins for each channel
			// the key is the Lower bound energy of the bin. 

			HashMap<Integer, HiggsEnergyBin> HiggsGGchannel = new HashMap<Integer,  HiggsEnergyBin>();
			HashMap<Integer,  HiggsEnergyBin> HiggsZZchannel = new HashMap<Integer,  HiggsEnergyBin>();

			for(HiggsEvent HE : HiggsEventsList){
				try{
					String channel = HE.getChannel();
					if(channel.equals("GG")){
						//If the HashMap does not yet contain an energy bin corresponding to the 
						//Higgs event, create a new HiggsEnergyBin and add it to HashMap:
						
						int key = (int) Math.floor(HE.getEEnergy());
						//In the cases where the Energy is exactly 200GeV we want these to
						//be a part of the 199-200GeV bin instead of a new 200-201GeV bin:
						if(key == 200){key = 199;}

						if(HiggsGGchannel.containsKey(key) == false){
							HiggsEnergyBin HEB = new HiggsEnergyBin(HE.getEEnergy());
							HiggsGGchannel.put(key, HEB);
						}
						//else if the HashMap does contain an energy bin corresponding to the Higgs event
						//simply update the noOfEvents count:
						if(HiggsGGchannel.containsKey(key)) {
							HiggsEnergyBin HEB = HiggsGGchannel.get(key);
							HEB.incrementEventCount();
							HiggsGGchannel.put(key, HEB);	
						}
					}
					else if(channel.equals("ZZ")){
						//If the HashMap does not yet contain an energy bin corresponding to the 
						//Higgs event, create a new HiggsEnergyBin and add it to HashMap:
						int key = (int) Math.floor(HE.getEEnergy());
						if(key == 200){key = 199;}
						if(HiggsZZchannel.containsKey(key) == false){
							HiggsEnergyBin HEB = new HiggsEnergyBin(HE.getEEnergy());
							HiggsZZchannel.put(key, HEB);
						}
						//else if the HashMap does contain an energy bin corresponding to the Higgs event
						//simply update the noOfEvents count:
						else{
							HiggsEnergyBin HEB = HiggsZZchannel.get(key);
							HEB.incrementEventCount();
							HiggsZZchannel.put(key, HEB);	
						}
					}
				} catch(NullPointerException e){
					System.out.println("Problem with entry: "+HE);
				}
			}
			
			
			for(int i = 100; i < 200; i++){
				if(HiggsZZchannel.containsKey(i) == false){
					HiggsEnergyBin heb = new HiggsEnergyBin();
					HiggsZZchannel.put(i, heb);
				}
			}
			

			// For each of the channels, determine the number of candidate events in the 
			// energy range 120-140 GeV:

			//GG channel
			int higgsGGeventsCount = 0;
			for(int i = 120; i < 140; i++){
				double eventsCount = HiggsGGchannel.get(i).getEventsCount();
				higgsGGeventsCount = higgsGGeventsCount + (int) eventsCount;
			}
			System.out.println("Number of Higg's events found in GG channel in 120-140 GeV range: "+higgsGGeventsCount);

			//ZZ channel
			int higgsZZeventsCount = 0;
			for(int i = 120; i < 140; i++){
				if(HiggsZZchannel.containsKey(i)){
					double eventsCount = HiggsZZchannel.get(i).getEventsCount();
					higgsZZeventsCount = higgsZZeventsCount + (int) eventsCount;
				}
			}
			System.out.println("Number of Higg's events found in ZZ channel in 120-140 GeV range: "+higgsZZeventsCount);

			//Calculate the log-likelihood for each of the channels:

			//GG
			double logLikelihoodGG = LogLikelihood(GGchannel, HiggsGGchannel);
			System.out.println("Log Likelihood for GG channel: "+logLikelihoodGG);

			//ZZ
			double logLikelihoodZZ =  LogLikelihood(ZZchannel, HiggsZZchannel);;
			System.out.println("Log Likelihood for ZZ channel: "+logLikelihoodZZ);


			/** PART 2 **/

			//Use the Gaussian implementation to produce 80 signal predictions for the gg channel 
			//for mH between  110.5GeV and 179.5GeV in 1GeV steps with N = 100 and σH = 2. 
			double N = 100;
			double σH = 2;

			ArrayList<ArrayList<Double>> GDsgg = new ArrayList<ArrayList<Double>>();

			for(double mH = 110.5; mH <= 179.5; mH++){
				//Create new GaussianDistribution object:
				GaussianDistribution GD = new GaussianDistribution(N, mH,σH);
				//Create an ArrayList of predictions for the number of Higs expected to fall in each bin
				ArrayList<Double> Dists = GD.ListOfSignalCountPredictions();
				//Add to the ArrayList of predictions for varying values of mH:
				GDsgg.add(Dists);
			}

			//Use the Gaussian implementation to produce 80 signal predictions for the zz channel 
			//for mH between  110.5GeV and 179.5GeV in 1GeV steps with N = 6 and σH = 1. 
			double Nz = 6;
			double σHz = 1;

			ArrayList<ArrayList<Double>> GDszz = new ArrayList<ArrayList<Double>>();

			for(double mH = 110.5; mH <= 179.5; mH++){
				//Create new GaussianDistribution object:
				GaussianDistribution GD = new GaussianDistribution(Nz, mH, σHz);
				//Create an ArrayList of predictions for the number of Higgs expected to fall in each bin
				ArrayList<Double> Dists = GD.ListOfSignalCountPredictions();
				//Add to the ArrayList of predictions for varying values of mH:
				GDszz.add(Dists);
			}
			
			/**PART 3 **/

			// For each channel and for each of the 80 values of the Higgs mass, mH,
			// determine the sum of the expected number background (from Part 1) 
			// and signal (from Part 2) events in each bin. 

			//GG channel

			//Initialise ArrayList
			ArrayList<ArrayList<Double>> GGsumOfExpectedBackgroundAndHiggsSignalforVariedmH = new ArrayList<ArrayList<Double>>();

			//Iterate over each prediction set where mH is varied: 
			for(int j = 0; j < GDsgg.size(); j++){
				ArrayList<Double> HiggsPredictionCount = GDsgg.get(j);
				
				//Initialise ArrayList for each sum of each variation:
				ArrayList<Double> GGsumOfExpectedBGandHiggs = new ArrayList<Double>();
				
				for(int i = 0; i < HiggsPredictionCount.size(); i++){
					double signal = HiggsPredictionCount.get(i);
					double background = GGchannel.get(i).getEventsCount();
					double sum = signal + background;
					//Add summed valued to new ArrayList of BG and Signal prediction sums:
					GGsumOfExpectedBGandHiggs.add(i,sum);
				}
				GGsumOfExpectedBackgroundAndHiggsSignalforVariedmH.add(GGsumOfExpectedBGandHiggs);
			}
			

			//ZZ channel
			
			//Initialise ArrayList
			ArrayList<ArrayList<Double>> ZZsumOfExpectedBackgroundAndHiggsSignalforVariedmH = new ArrayList<ArrayList<Double>>();

			//Iterate over each prediction set where mH is varied: 
			for(int j = 0; j < GDszz.size(); j++){
				ArrayList<Double> HiggsPredictionCount = GDszz.get(j);
				
				//Initialise ArrayList for each sum of each variation:
				ArrayList<Double> ZZsumOfExpectedBGandHiggs = new ArrayList<Double>();
				
				for(int i = 0; i < HiggsPredictionCount.size(); i++){
					double signal = HiggsPredictionCount.get(i);
					double background = ZZchannel.get(i).getEventsCount();
					double sum = signal + background;
					//Add summed valued to new ArrayList of BG and Signal prediction sums:
					ZZsumOfExpectedBGandHiggs.add(i,sum);
				}
				ZZsumOfExpectedBackgroundAndHiggsSignalforVariedmH.add(ZZsumOfExpectedBGandHiggs);
			}

			//Create an ArrayList of Higg's events to pass through LogLikelihood method
			ArrayList<Double> HiggsResultsBinCountGG = new ArrayList<Double>();
			for(HiggsEnergyBin HEB: HiggsGGchannel.values()){
				double binCount = HEB.getEventsCount();
				HiggsResultsBinCountGG.add(binCount);
			}
			ArrayList<Double> HiggsResultsBinCountZZ = new ArrayList<Double>();
			for(HiggsEnergyBin HEB: HiggsZZchannel.values()){
				double binCount = HEB.getEventsCount();
				HiggsResultsBinCountZZ.add(binCount);
			}
			
			//Create an arrayList of the different LogLikelihoods
			
			//GG
			ArrayList<Double> logLikelihoodsGG = new ArrayList<Double>();
			
			for(ArrayList<Double> GGpredictions: GGsumOfExpectedBackgroundAndHiggsSignalforVariedmH){
				double ll = LogLikelihood(GGpredictions, HiggsResultsBinCountGG);
				logLikelihoodsGG.add(ll);
			}
			
			//ZZ
			ArrayList<Double> logLikelihoodsZZ = new ArrayList<Double>();
			
			for(ArrayList<Double> ZZpredictions: ZZsumOfExpectedBackgroundAndHiggsSignalforVariedmH){
				double ll = LogLikelihood(ZZpredictions, HiggsResultsBinCountZZ);
				System.out.println(ll);
				logLikelihoodsZZ.add(ll);
			}
			
			//Print mass with lowest LogLikelihood: 
			
			double lowestLLforGG = Collections.min(logLikelihoodsGG);
			double HiggsMassForGG = logLikelihoodsGG.indexOf(lowestLLforGG) + 110.5;
			System.out.println("Lowest LL for GG was "+lowestLLforGG+" and was for a Higgs Mass of "+HiggsMassForGG+" GeV");
			
			double lowestLLforZZ = Collections.min(logLikelihoodsZZ);
			double HiggsMassForZZ = logLikelihoodsZZ.indexOf(lowestLLforZZ) + 110.5;
			System.out.println(ZZsumOfExpectedBackgroundAndHiggsSignalforVariedmH.get(0));
			System.out.println("Lowest LL for ZZ was "+lowestLLforZZ+" and was for a Higgs Mass of "+HiggsMassForZZ+" GeV");
			
			
			
			





		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
