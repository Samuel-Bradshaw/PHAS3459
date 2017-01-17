package examII201516Particle;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThresholdArrivalTime implements ArrivalTimeCalculator {

	public int CalculateArrivalTime(CompletePulse pulse, double threshold) {
		ArrayList<Double> pulseData = pulse.getSignal();
		
		int time = 0;
		int arrivalTime = 0;
		for(Double reading: pulseData){
			if(reading > threshold){
				arrivalTime = time;
				break;
			}
			time = time + 1;
		}
		return arrivalTime;	
	}
	
}
