package examII201314plants;

import java.util.ArrayList;
import java.util.List;

/**
 *  Create an interface with a method that will take a container of specimens and return a container that only includes the
 *  subset of the specimens that were found within some specific region. 
 * @author Samuel Bradshaw
 *
 */

public interface Regional {
	
	//represents the maximum value the latitude and longitude can take
	double maxLat = 90;
	double minLat = -90;
	double maxLon = 180;
	double minLon = -180;

	/**
	 * Takes a container of specimens and return a container that only includes the
	 * subset of the specimens that were found within some specific region defined by the
	 * class implementing the interface.
	 * @param plantSurvey - the Plant Data to draw from
	 * @return An ArrayList of PlantSpecimen in a given region.
	 */
	ArrayList<Specimen> returnSpecimenInRegion(ArrayList<Specimen> Survey);

}
