package module5;

/**
 * A class that creates Theory objects where the value of n 
 * in the theory y = x^n is set. 
 * aReturns the value of y for a given x for a particular theory. 
 */

import java.lang.Math;

public class Theory {

	//Member variables
	private double n;

	//Constructor
	Theory(double n1){
		n = n1;
	}
	
	// returns x^n for given x and n. 
	public double y(double x){
		double y = Math.pow(x, n);
		return y;
	}
	
	public String toString(){
		return "x^"+n;
	}

}
