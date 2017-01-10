package examII201516;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaximumVoltageArrivalTime implements ArrivalTimeCalculator {

	public int CalculateArrivalTime(CompletePulse pulse, double threshold) {
		ArrayList<Double> pulseData = pulse.getSignal();
		
		double amp = 0.0;
		int time = 0;
		int arrivalTime = 0;
		for(Double reading: pulseData){
			if(reading > amp){
				amp = reading;
				arrivalTime = time;
			}
			time = time + 1;
		}
		return arrivalTime;	
	}
}