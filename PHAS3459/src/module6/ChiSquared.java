package module6;

import java.util.ArrayList;
import java.util.Collection;

public class ChiSquared implements GoodnessOfFitCalculator{


	// Returns the X^2 (chi squared) statistic, where X^2 is 
	// the sum over all data points of the quantity (ymeasured - ytheory)^2/ey^2
	public double goodnessOfFit(Collection<DataPoint> data, Theory theory) {
		//Initialise chiSquared:
		double XSquared = 0.0;
		//Summing over all data points:
		for(DataPoint p : data){
			double ymeasuredi = p.gety();
			double ytheoryi = theory.y(p.getx());
			double eyi = p.getey();
			double XSquaredi = Math.pow( ((ymeasuredi - ytheoryi)/eyi) , 2);
			XSquared = XSquared + XSquaredi;
		}
		return XSquared;
	}



}


