package module6;

/**
 * A class of dataPoint objects containing three pieces of information:
 * x measurement, y measurement and y error (ey). 
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
	
	public double getx(){
		return x;
	}
	
	public double gety(){
		return y;
	}
	
	public double getey(){
		return ey;
	}
	
	
}
