package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * Tests three theories against data found at a URL using Chi Squared analysis
 * and returns the theory that best fits the data. 
 **/

public class DataAnalysis {

	static String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";

	//Takes an ArrayList of the data points as an argument and an ArrayList 
	//of theories that we want to test against the data and returns the theory that
	//best fits the data specified by the Goodness of fit calculator given in the third argument.

	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		//Initialising variables
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		//Looping over the theories we want to test:
		for (Theory theory : theories) {						   //Calling the goodnessOfFit
			double gof = gofCalculator.goodnessOfFit(data, theory);//calculator method from a class
			if (first) {										   //belonging to the interface GoodnessOfFitCalculator
				bestTheory = theory;	 						   
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		return bestTheory;
	}


	public static void main(String[] args) {

		//Initialise the ArrayList of DataPoint 
		ArrayList<DataPoint> data;

		try {
			System.out.println("Testing data found at "+dataURL+" using Chi Squared analysis.\n");

			data = TestDataPoints.dataFromURL(dataURL);

			//Creating an ArrayList of all the theories we want to test
			ArrayList<Theory> theories = new ArrayList<Theory>(); 

			//Testing y = x^2
			PowerLawTheory plt1 = new PowerLawTheory(2);
			theories.add(plt1);

			//Testing y = x^2.05
			PowerLawTheory plt2 = new PowerLawTheory(2.05);
			theories.add(plt2);

			//Testing y = x^2 + 10 x
			QuadraticTheory qt1 = new QuadraticTheory(1, 1, 0);
			theories.add(qt1);

			//Create a ChiSquared Object
			ChiSquared chisq = new ChiSquared();

			//Test the data against the three theories using bestTheory method above.
			Theory besttheory = bestTheory(data, theories, chisq);

			System.out.println("Theories being tested: "+plt1+"; "+plt2+"; "+qt1+"\n");
			System.out.println("The theory that best fits the data is: "+besttheory);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}