package examII1213Higgs;

public class EnergyBin {
	
	int lowEdgeEnergy;
	int highEdgeEnergy;
	double noOfEvents;
	
	EnergyBin(){}
	
	EnergyBin(int LEE, int HEE, double PNE){
		lowEdgeEnergy = LEE;
		highEdgeEnergy = HEE;
		noOfEvents = PNE;
	}
	
	int getLowEE(){
		return lowEdgeEnergy;
	}
	
	int getHighEE(){
		return highEdgeEnergy;
	}
	
	double getEventsCount(){
		return noOfEvents;
	}
	
	public String toString(){
		return "Range of events in bin: "+lowEdgeEnergy+"-"+highEdgeEnergy+" GeV, Number of predicted events: "+noOfEvents;
	}

}
