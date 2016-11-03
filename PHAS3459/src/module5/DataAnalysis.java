package module5;

/**
 * Takes data points from an online document and
 * tests them for goodness of fit using chi squared analysis
 * against a theory y = x^n for varying values of n
 * by using the ArrayList class. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

	//Takes data points from an online document and creates an ArrayList out of them.
	static ArrayList dataFromURL(String url)throws IOException{ 
		URL url1 = new URL(url); 
		InputStream istream = url1.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 

		ArrayList<DataPoint> list = new ArrayList<DataPoint>(); //Initialising ArrayList

		try(Scanner scanner1 = new Scanner(buffr);
				){ 
			while (scanner1.hasNextDouble()){  			 //Create a DataPoint object from each line
				double x = scanner1.nextDouble();		 //in the online document, where the first double 
				double y = scanner1.nextDouble();		 //in each line is x, the second double is y, 
				double ey = scanner1.nextDouble();		 //and the third is ey.
				DataPoint datapoint = new DataPoint(x,y,ey); 
				list.add(datapoint);
			}
		}
		return list; 
	}

	//Returns the X^2 (chi squared) statistic, where X^2 is the sum 
	// over all data points of the quantity (ymeasured - ytheory)^2/ey^2
	static double goodnessOfFit(Theory theory, ArrayList<DataPoint> data){
		//Initialise chiSquared:
		double XSquared = 0.0;
		//Summing over all data points:
		for(int i = 0; i < data.size(); i++){
			double ymeasuredi = data.get(i).y;
			double ytheoryi = theory.y(data.get(i).x);
			double eyi = data.get(i).ey;
			double XSquaredi = Math.pow(((ymeasuredi - ytheoryi)/eyi), 2);
			XSquared = XSquared + XSquaredi;
		}
		return XSquared;
	}

	public static void main(String[] args) {
		try {
			ArrayList<DataPoint> list = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			System.out.println("Analysing data from: http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
			System.out.println("Testing how well this data fits the Theory: y = x^n");
			System.out.println("Comparing chi Squared for n = 2 and n = 4:");

			Theory tn2 = new Theory(2); //testing for goodness of fit for n = 2
			double chisquared2 =  goodnessOfFit(tn2, list);
			System.out.println("X^2 for n = 2: "+chisquared2);

			Theory tn4 = new Theory(4); //testing for goodness of fit for n = 4
			double chisquared4 = goodnessOfFit(tn4, list);
			System.out.println("X^2 for n = 4: "+chisquared4);

			boolean betterfit = (chisquared2 < chisquared4);
			System.out.println("Is n = 2 a better fit than n = 4?: "+betterfit );
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
