package examII201314;

import java.util.ArrayList;

public class SpecimenWithinDistanceOfPoint implements Regional{

	static double r = 6371; //The radius of the earth in km
	double latitude;
	double longitude;
	double distance;  //The radius we want to find the plants in in Km.

	SpecimenWithinDistanceOfPoint(double lat, double lon, double d){
		latitude = lat;
		longitude = lon;
		distance = d;
	}
	
	/**
	 * Returns the haverSin value at a given point.
	 * @param theta
	 * @return 0.5*(1 - Math.cos(theta))
	 */
	static double haverSin(double theta){
		double hs = 0.5*(1 - Math.cos(theta));
		return hs;
	}

	public ArrayList<Specimen> returnSpecimenInRegion(ArrayList<Specimen> Survey) {
		//Initialise new ArrayList:
		ArrayList<Specimen> SpecimenWithinDistance = new ArrayList<Specimen>();

		for(Specimen PS: Survey){

			double h = haverSin((this.latitude - PS.getLat())) + (Math.cos(PS.getLat())*Math.cos(this.latitude)*haverSin((this.longitude - PS.getLon())));
			double d = 2*r*Math.asin(Math.sqrt(h));

			if(d <= this.distance){
				SpecimenWithinDistance.add(PS);
			}
		}
		return SpecimenWithinDistance;
	}

}