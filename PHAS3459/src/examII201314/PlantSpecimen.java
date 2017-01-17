package examII201314;

public class PlantSpecimen extends Specimen{
	
	//Member variables:
	double height; //in cm 
	
	//Constructors
	PlantSpecimen(){super();}
	
	PlantSpecimen(double lat, double lon, String ID, double h){
		super(lat, lon, ID);
		height = h;		
	}
	
	public String toString(){
		return "Species ID: "+speciesID+
				"\nLocation (latitude, longitude): ("+latitude+", "+longitude+")"
						+ "\nHeight: "+height+" cm\n";
	}
	
	double getHeight(){
		return height;
	}
}
