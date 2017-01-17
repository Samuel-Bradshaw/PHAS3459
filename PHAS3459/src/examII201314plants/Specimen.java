package examII201314plants;

public class Specimen {

	//Member variables
	double latitude;
	double longitude;
	String speciesID;

	//Constructors
	Specimen(){};

	Specimen(double lat, double lon, String id){
		latitude = lat;
		longitude = lon;
		speciesID = id;
	}
	
	public double getLat(){
		return latitude;
	}
	
	public double getLon(){
		return longitude;
	}
	
	public String getID(){
		return speciesID;
	}
	
	public String toString(){
		return "Species ID: "+speciesID+
				"\nLocation (latitude, longitude): ("+latitude+", "+longitude+")";
	}
}
