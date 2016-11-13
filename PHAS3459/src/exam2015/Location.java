package exam2015;

/**
 * Create Location objects containing information on
 * latitude and longitude so that we are not passing too many 
 * arguments into the Earthquake object. 
 */

public class Location {

	//Member variables
	public double latitude;
	public double longitude;
	
	//Constructor
	Location(double LAT, double LON){
		latitude = LAT;
		longitude = LON;
	}
	
	//Define methods that return the required member variables:
	double getLat(){
		return latitude;
	}
	
	double getLon(){
		return longitude;
	}
	
	//Represent the printed data in a readable form:
	public String toString(){
		return "Latitude/Longitude (degrees): "+latitude+"/"+longitude;
	}
}
