package module8;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Class which generates an estimated value for pi using the Monte Carlo method,
 * where the member variable (n_points) represents the number of points used in 
 * generating the estimate.  
 * @author Samuel Bradshaw
 */

public class MonteCarloPiCalculatorTask implements Callable<Double> { 

	//Member variable
	private final long n_points; 

	//Constructor
	public MonteCarloPiCalculatorTask(long nPoints) {    
		this.n_points = nPoints;  
	} 

	/** Method (implementing Callable interface) generating an estimated value of pi
	 *  by finding the ratio of points randomly distributed in a unit square that 
	 *  lie inside a (quarter-)circular radius of the origin. 
	 */
	public Double call() {   

		Random rand = new Random();
		long n_in  = 0; 

		//Generate n_points amount of random points inside a unit square, 
		// between x,y = 0 and x,y = 1 
		for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			double x = rand.nextDouble();
			double y = rand.nextDouble();
			//Calculate the distance of each random point to the origin (0,0):
			double r2 = x*x + y*y; 
			if (r2 < 1.0){		  // If the distance is less than 1 away from origin 
				n_in = n_in + 1;  // add the point to the count of points inside the 
			}					  // circular radius of the origin,
		}  
		//Return the estimated value of pi:
		return 4.0 * n_in / n_points; 
	} 

}
