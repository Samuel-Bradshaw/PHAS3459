package examII201314;

import java.util.ArrayList;

public class SpecimenWithinLatitudeBounds implements Regional {

	double minLatitude;
	double maxLatitude;
	
	//Constructor:
	SpecimenWithinLatitudeBounds(double minLat, double maxLat){
		minLatitude = minLat;
		maxLatitude = maxLat;
	}
	
	 /**
	  * Returns an ArrayList of plants within a region specified by a maximum and minimum latitude
	  * @param plantSurvey - the complete ArrayList of plants 
	  */
	public ArrayList<Specimen> returnSpecimenInRegion(ArrayList<Specimen> Survey){
		//Initialise new ArrayList:
		ArrayList<Specimen> SpecimenInLatitudeBounds = new ArrayList<Specimen>();
		
		for(Specimen PS: Survey){
			double lat = PS.getLat();
			if(minLatitude <= lat && lat <= maxLatitude){
				SpecimenInLatitudeBounds.add(PS);
			}
		}
		return SpecimenInLatitudeBounds;
	}

}
