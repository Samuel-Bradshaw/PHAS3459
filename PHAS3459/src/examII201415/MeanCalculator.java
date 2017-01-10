package examII201415;

import java.util.ArrayList;

/**
 * Class defining the method used to calculate the mean for a given site.
 * Implements SeaLevelCalculation.
 * @author Samuel Bradshaw
 *
 */

public class MeanCalculator implements SeaLevelCalculation {

	/**
	 * Calculates the mean sea-level reading for a given Site given the data of tide-readings in ArrayForm.
	 * @param ArrayList<tides> - the data we are to analyse
	 * @param Site s - the site we want to find the mean for
	 * @return double - the mean
	 */
	public double CalculateStat(ArrayList<tides> tidesList, Site site){
		double count = 0.0;
		double readingTotal = 0.0;

		for(tides t : tidesList){
			
			if(t.getID().equals(site.getID())){
				double reading = t.getLevel();
				readingTotal = readingTotal + reading;
				count = count + 1;
			}
		}
		double mean = readingTotal/count;
		return mean;
	}

}
