package examII201516Particle;

import java.util.ArrayList;
import java.util.Collections;

public class CompletePulse {
	
	String detector;
	ArrayList<Double> completeSignal = new ArrayList<Double>();
	
	CompletePulse(String det, ArrayList<Double> data){
		detector = det;
		completeSignal = data;
	}
	
	ArrayList<Double> getSignal(){
		return completeSignal;
	}
	
	String getDetector(){
		return detector;
	}
	

}
