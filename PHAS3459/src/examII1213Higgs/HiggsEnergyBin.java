package examII1213Higgs;

public class HiggsEnergyBin extends EnergyBin {

	HiggsEnergyBin(double EventEnergy){
		super((int) Math.floor(EventEnergy),(int) Math.floor(EventEnergy) + 1, 1);
		
	}
	
	HiggsEnergyBin(){super();}
	
	void incrementEventCount(){
		this.noOfEvents = this.noOfEvents + 1;
	}

	public String toString(){
		return "Range of events in bin: "+lowEdgeEnergy+"-"+highEdgeEnergy+" GeV, Number of events counted: "+noOfEvents;
	}
	
}
