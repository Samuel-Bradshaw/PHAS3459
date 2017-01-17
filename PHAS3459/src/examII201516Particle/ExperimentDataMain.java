package examII201516Particle;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ExperimentDataMain {

	static String DetectorURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/detectors.txt";
	static String SignalsURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";

	/**
	 * Arranges the Detectors into a HashMap to be easily accessed later
	 * @param url
	 * @return HashMap where the Key is the detector ID code and the Value is Detector Object.
	 * @throws IOException
	 */
	static HashMap<String, Detector> DetectorsFromURL(String url) throws IOException{
		//Reading in data from URL:
		URL url1 = new URL(url); 
		try(	
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr);
				){
			
			//Initialise HashMap:
			HashMap<String, Detector> detectors = new HashMap<String, Detector>();
			
			while (scanner.hasNext()){
				String DetectorID = scanner.next();					//First token of each line give the detector ID.
				Double distance = scanner.nextDouble();				//Second token gives distance of detector to source.
				Detector det = new Detector(DetectorID, distance);
				detectors.put(DetectorID, det);
			}
			return detectors;
		}
	}

	/**
	 * Reads in Signals data from URL address and arranges it into an ArrayList of Signals. 
	 * @param url
	 * @return ArrayList<Signals>
	 * @throws IOException
	 */

	static ArrayList<Signals> SignalFromURL(String url) throws IOException{
		//Reading in data from URL:
		URL url1 = new URL(url); 
		try(	
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);

				Scanner scanner = new Scanner(buffr);
				){

			//Initialise ArrayList
			ArrayList<Signals> signals = new ArrayList<Signals>();

			while(scanner.hasNext()){
				
				String detectorID = scanner.next(); //First token of each line is the detector ID.

				//Initialise values for the amplitude and Arrival time of each Signal
				double amp = 0.0;
				int time = 0; 
				int arrivalTime = 0;

				while(scanner.hasNextDouble()){		 		 //The following tokens in each line are a series of 
					try{									 //numbers separated by white space, representing the 
						double nextV = scanner.nextDouble(); //voltage (in volts) at intervals of 1 nanosecond.
						if(nextV > amp){
							amp = nextV; 		//Amplitude is maximum voltage at any time during the pulse.
							arrivalTime = time;	
						}
						time = time + 1;
					}
					catch(InputMismatchException e){
						System.out.println("problem with entry:"+scanner.next());
					}
				}

				Signals signal = new Signals(detectorID, amp, arrivalTime);
				signals.add(signal);
			} 
			return signals;
		}
	}

	public static void main(String[] args) {

		try {
			HashMap<String, Detector> Detectors = DetectorsFromURL(DetectorURL);
			//System.out.println(Detectors.entrySet());

			ArrayList<Signals> SignalsList = SignalFromURL(SignalsURL); 
			
			System.out.println("No. of signals in data: "+SignalsList.size());
			
			//Finding the mean amplitude:
			double total = 0;
			for(Signals sig: SignalsList){
				total = total + sig.getAmplitude();
			}
			double mean = total / SignalsList.size();
			System.out.println("Mean amplitude: "+mean+"\n");

			//For each detector print
			//-number of signals
			//-mean amplitude of pulses from this detector
			//-mean arrival time of pulses at this detector
			//-the speed of the particles
			
			Iterator<Signals> it1 = SignalsList.iterator();
			while(it1.hasNext()){
				Signals sig1 = it1.next();
				String detectorID = sig1.getDetector();
				double amp = sig1.getAmplitude();
				int atime = sig1.getArrivalTime(); 
				
				Detector det = Detectors.get(detectorID);
				det.incrementPulseCount();
				det.incrementTotalAmpCount(amp);
				det.incrementTotalArrivalTime(atime);
				
				Detectors.put(detectorID, det);	
			}
			
			for(Detector d : Detectors.values()){
				System.out.println("Detector ID: "+d.getID());
				System.out.println("Number of signals detected: "+d.getPulseCount());
				System.out.println("Mean Amplitude: "+d.getMeanAmp());
				System.out.println("Mean Arrival Time: "+d.getMeanAT()+" ns");
				System.out.println("Average speed of particle at detector:"+d.getMeanSpeed()+" m/ns\n");
			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
