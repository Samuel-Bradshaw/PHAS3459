package exam2015;

/**
 * Earthquake constructor and method which passes as arguments all the data
 * on each earthquake
 * @author samuel
 */

public class Earthquake {

	//Member Variables
	public Date date;
	public Time time;
	public Location location;
	public double depth;
	public double EH1;
	public double EH2;
	public double AZ;
	public double depthError;
	public double magnitude;
	public String ID;

	//Constructor 
	Earthquake(Date d, Time t, Location coords, double dep, double eh1, double eh2, double az, double ez, double mag, String id){
		if(ez == -1){	//If ez == -1, we do not have the data for the depth error for this earthquake.
			depthError = Double.NaN; //Do not assign depthError anything if ez is -1. 
			date = d;
			time = t;
			location = coords;
			depth = dep;
			EH1 = eh1;
			EH2 = eh2;
			AZ = az;
			magnitude = mag;
			ID = id;
		}
		else{
			date = d;
			time = t;
			location = coords;
			depth = dep;
			EH1 = eh1;
			EH2 = eh2;
			AZ = az;
			depthError = ez;
			magnitude = mag;
			ID = id;
		}
	}

	//Define methods that return the required member variables:
	double getMagnitude(){
		return magnitude;
	}

	Date getDate(){
		return date;
	}

	double getDepth(){
		return depth;
	}
	
	public double getError() {
		return depthError;
	}

	//Represent the printed data in a readable form:
	public String toString(){
		String earthquake = "Earthquake ID:"+ID+"\n"+date+"\n"+time+"\n"+location+"\ndepth: "+depth+
				" km\nEH1/EHZ/AZ (km): "+EH1+"/ "+EH2+"/ "+AZ+"\ndepth error: "+depthError+" km\nmagnitude: "+magnitude+"\n";
		return earthquake;
	}




}
