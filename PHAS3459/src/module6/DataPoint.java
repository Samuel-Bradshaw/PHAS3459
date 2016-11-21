package module6;

/**
 * A class of dataPoint objects containing three pieces of information:
 * x measurement, y measurement and y error (ey). Used in Chi Squared data analysis
 */

public class DataPoint {
	
	//Member variables:
	protected double x;
	protected double y;
	protected double ey;
	
	//Constructor:
	public DataPoint(double x1, double y1, double errory){
		x = x1;
		y = y1;
		ey = errory;
	}
	
	//If we need to print DataPoints, presents them in readable form:
	public String toString(){
		return "x = "+x+", y = "+y+" +- "+ey;
	}
	
	//Methods returning x, y and ey:
	
	double getx(){
		return x;
	}
	
	double gety(){
		return y;
	}
	
	double getey(){
		return ey;
	}
	
	
}
