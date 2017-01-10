package examII201516;

public class Detector {
	
	String identifier;
	double distance;
	int pulseCount;
	double ampCountTotal;
	int totalArrivalTime;
	
	
	Detector(String id, double dis){
		identifier = id;
		distance = dis;
	}
	
	String getID(){
		return identifier;
	}
	
	void incrementPulseCount(){
		pulseCount = pulseCount + 1;
	}
	
	void incrementTotalAmpCount(double amp){
		ampCountTotal = ampCountTotal + amp;
	}
	
	int getPulseCount(){
		return pulseCount;
	}
	
	double getMeanAmp(){
		return (double) ampCountTotal/ (double) pulseCount;
	}
	
	void incrementTotalArrivalTime(int at){
		totalArrivalTime = totalArrivalTime + at;
	}
	
	double getMeanAT(){
		return (double)totalArrivalTime/(double)pulseCount;
	}

	double getMeanSpeed(){
		return distance/this.getMeanAT();
	}
}
