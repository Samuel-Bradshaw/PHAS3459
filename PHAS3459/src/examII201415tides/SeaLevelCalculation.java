package examII201415tides;

import java.util.ArrayList;

/**
 * Interface representing the calculation of an arbitrary statistic 
 * from a set of sea-level data, i.e. defines a function that takes a list 
 * of sea-level readings (in some suitable form) as input and returns a real number.
 * @author Samuel Bradshaw
 */

public interface SeaLevelCalculation {

	/**
	 * @param tidesList - the tides data we want to analyse
	 * @param site - the Site we want to find the data for
	 * @return double - the stat we want to calculate
	 */
	double CalculateStat(ArrayList<tides> tidesList, Site site);
	
}
