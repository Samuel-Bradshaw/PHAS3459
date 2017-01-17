package examII1213Higgs;

import java.util.ArrayList;

public class GaussianDistribution implements PredictionFromDistribution {
	
	double N;
	double HiggsMass;
	double width;
	
	GaussianDistribution(double n, double mH, double w){
		N = n;
		HiggsMass = mH;
		width = w;
	}

	/**
	 * Returns the Gaussian Distribution for a given Energy
	 * @param Energy
	 * @return the distribution for the given Energy
	 */
	double f(double Energy){
		return (this.N/(this.width*Math.sqrt(Math.PI*2)))*Math.pow(Math.E, -(Math.pow((Energy-this.HiggsMass)/this.width, 2))/2); 
	}
	
	/**
	 * Uses trapezium rule to calculate the number of Higg's predicted to fall in a 1 GeV range
	 * starting from the @param Elow. 
	 */
	public double CalculatePredictionforSingleBin(double Elow){
		double Ehigh = Elow + 1; 
		double NoOfEvents = 0.5*(f(Ehigh)+f(Elow))* (Ehigh - Elow);
		
		return NoOfEvents;
	}
	
	public ArrayList<Double> ListOfSignalCountPredictions() {
		ArrayList<Double> distribution = new ArrayList<Double>();
		for(int Elow = 100; Elow < 200; Elow++){
			distribution.add(CalculatePredictionforSingleBin(Elow));
		}
		return distribution;
	}
}
