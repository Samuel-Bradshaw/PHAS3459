package examII201516Particle;

public class Signals {
	
	String detector;
	double Amplitude;
	int ArrivalTime;
	
	Signals(String de, double amp,  int at){
		detector  = de;
		Amplitude = amp;
		ArrivalTime = at;
	}

	public String toString(){
		return "Detector: "+ detector+", Amplitude: "+Amplitude+", Arrival Time: "+ArrivalTime;
	}
	
	double getAmplitude(){
		return Amplitude;
	}
	
	String getDetector(){
		return detector;
	}
	
	int getArrivalTime(){
		return ArrivalTime;
	}
	

}
