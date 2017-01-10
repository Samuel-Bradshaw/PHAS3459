package examII201516;

import java.io.*;
import java.net.URL;
import java.util.*;

public class ExperimentDataMainPart2 {

	static String SignalsURL = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/signals.txt";

	static ArrayList<CompletePulse> CompleteDataFromURL(String url) throws IOException{

		//Reading in data from URL:

		URL url1 = new URL(url); 
		try(	
				InputStream istream = url1.openStream(); 
				InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr);
				Scanner scanner = new Scanner(buffr);
				){

			//Sort data read in into an ArrayList of pulses:

			//Initialise ArrayList
			ArrayList<CompletePulse> signals = new ArrayList<CompletePulse>();

			while(scanner.hasNext()){

				//First token of each line is the detector ID:
				String detectorID = scanner.next(); 

				//Initialise the ArrayList for each PulseData object: 
				ArrayList<Double> signalData = new ArrayList<Double>();

				while(scanner.hasNextDouble()){		
					try{									  
						signalData.add(scanner.nextDouble()); 
					}
					catch(InputMismatchException e){
						System.out.println("problem with entry:"+scanner.next());
					}
				}

				CompletePulse PulseData = new CompletePulse(detectorID, signalData);
				signals.add(PulseData);
			} 

			return signals;
		}
	}

	static double CalculateAmplitude(CompletePulse pulse){

		ArrayList<Double> pulseData = pulse.getSignal();
		double amp = Collections.max(pulseData);
		return amp;	

	}

	public static void main(String[] args) {

		try {

			HashMap<String, Detector> detectors = ExperimentDataMain.DetectorsFromURL(ExperimentDataMain.DetectorURL);

			ArrayList<CompletePulse> CompleteData = CompleteDataFromURL(SignalsURL);

			ArrayList<Signals> signalsList = new ArrayList<Signals>();

			//Using Threshold method to find amplitude:

			for(CompletePulse pulse: CompleteData){

				String detector = pulse.getDetector();

				double amplitude = CalculateAmplitude(pulse);

				ThresholdArrivalTime TAT = new ThresholdArrivalTime();
				int AT = TAT.CalculateArrivalTime(pulse, 1.0);

				Signals signal = new Signals(detector, amplitude, AT);
				signalsList.add(signal);


			}

			//Calculate the speed of the particles for this alternate way of looking at particles:

			Iterator<Signals> it1 = signalsList.iterator();

			while(it1.hasNext()){
				Signals sig1 = it1.next();
				String detectorID = sig1.getDetector();
				double amp = sig1.getAmplitude();
				int atime = sig1.getArrivalTime(); 

				Detector det = detectors.get(detectorID);
				det.incrementPulseCount();
				det.incrementTotalAmpCount(amp);
				det.incrementTotalArrivalTime(atime);

				detectors.put(detectorID, det);	
			}

			for(Detector d : detectors.values()){
				System.out.println("Detector ID: "+d.getID());
				System.out.println("Average speed of particle at detector:"+d.getMeanSpeed()+" m/ns\n");
			}


			//Using Max method

			HashMap<String, Detector> Detectors = ExperimentDataMain.DetectorsFromURL(ExperimentDataMain.DetectorURL);

			ArrayList<Signals> SignalsList = new ArrayList<Signals>();
			
			for(CompletePulse pulse: CompleteData){

				String detector = pulse.getDetector();

				double amplitude = CalculateAmplitude(pulse);

				MaximumVoltageArrivalTime MV = new MaximumVoltageArrivalTime();
				int AT = MV.CalculateArrivalTime(pulse, 1.0);

				Signals signal = new Signals(detector, amplitude, AT);
				SignalsList.add(signal);


			}

			Iterator<Signals> it2 = SignalsList.iterator();
			while(it2.hasNext()){
				Signals sig1 = it2.next();
				String detectorID = sig1.getDetector();
				double amp = sig1.getAmplitude();
				int atime = sig1.getArrivalTime(); 

				Detector det = Detectors.get(detectorID);
				det.incrementPulseCount();
				det.incrementTotalAmpCount(amp);
				det.incrementTotalArrivalTime(atime);

				Detectors.put(detectorID, det);	
			}
			
			//Part 3
			double maxSpeedDiff = 0.0;
			String maxdiffDet = "";
			for(Detector d : detectors.values()){
				String ID = d.getID();
				double speed1 = d.getMeanSpeed();
				
				Detector D =  Detectors.get(ID);
				double speed2 = D.getMeanSpeed();
				double speedDifference = speed1 - speed2;
				
				if(speedDifference > maxSpeedDiff){
					maxSpeedDiff = speedDifference;
					maxdiffDet = ID;
				}
			}
		System.out.println("Detector with largest speed difference is " +maxdiffDet+ " with speed difference: "+maxSpeedDiff+" m/ns difference.");
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
