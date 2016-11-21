package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
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

		ArrayList<DataPoint> data;
		try {
			data = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");

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

			//We want to create a ChiSquared Object
			ChiSquared chisq = new ChiSquared();


			Theory besttheory = bestTheory(data, theories, chisq);
			System.out.println("The best theory is "+besttheory);


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}