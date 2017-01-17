package examII1213;

public class HiggsEvent {

	String channel;
	double eventEnergy;
	
	HiggsEvent(String c, double EE){
		channel = c;
		eventEnergy = EE;
	}
	
	String getChannel(){
		return channel;
	}
	
	double getEEnergy(){
		return eventEnergy;
	}
	
	public String toString(){
		return "Channel: "+channel+" , energy: "+eventEnergy+" GeV";
	}
	
}
