package examII201415;

import java.util.ArrayList;

/**
 * Class defining the method used to calculate the range for a given site.
 * Implements SeaLevelCalculation.
 * @author Samuel Bradshaw
 *
 */

public class RangeCalculator implements SeaLevelCalculation {


	/**
	 * Calculates the range for a given Site given the data of tide-readings in ArrayForm
	 * where the range is defined as the maximum sea-level reading minus the minimum sea-level reading.
	 * @param ArrayList<tides>, Site s
	 * @return double 
	 */
	public double CalculateStat(ArrayList<tides> tidesList, Site site) {

		int count = 0;
		double levelMin = 0.0;
		double levelMax = 0.0;

		for(tides t : tidesList){
			if(t.getID().equals(site.getID())){

				if(count == 0){
					levelMin = t.getLevel();
					levelMax = t.getLevel();
					count = 1;
				}
				if(t.getLevel() < levelMin){
					levelMin = t.getLevel();
				}
				if(t.getLevel() > levelMax){
					levelMax = t.getLevel();
				}
			}
		}
		double range = levelMax-levelMin;
		return range;
	}

}
