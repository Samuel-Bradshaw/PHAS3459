package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/** Tests the subclass extension of the DataPoint class by reading in data from a URL 
 *  and creates either a DataPoint or - if the data also has a label - a
 *  LabelledDataPoint object (an extension of the DataPoint class) and forms an ArrayList.
 **/

public class TestDataPoints {

	static String dataURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt";

	//Takes data points from an online document and creates an ArrayList out of them.
	static ArrayList<DataPoint> dataFromURL(String url) throws IOException{ 
		//Initialise ArrayList of DataPoints:
		ArrayList<DataPoint> list = new ArrayList<DataPoint>(); 

		//Reading data from URL:
				URL url1 = new URL(url); 
				InputStream istream = url1.openStream();
		try(	InputStreamReader isr = new InputStreamReader(istream); 
				BufferedReader buffr = new BufferedReader(isr); 
				
				Scanner scanner1 = new Scanner(buffr);
				){ 

			while (scanner1.hasNextDouble()){  		  //Create a DataPoint object from each line
				double x = scanner1.nextDouble();	  //in the online document, where the first double 
				double y = scanner1.nextDouble();	  //in each line is x, the second double is y, 
				double ey = scanner1.nextDouble();	  //and the third is ey. 
				if(scanner1.hasNextDouble()){
					DataPoint point = new DataPoint(x,y,ey); 
					list.add(point);
				}
				else if(scanner1.hasNext()){ 			//If the line has a 'label' in the form of a String
					String label = scanner1.next();		// Create a LabelledDataPoint and add it to ArrayList.
					LabelledDataPoint point2 = new LabelledDataPoint(x, y, ey, label);
					list.add(point2);
				}
			}
		}
		return list; 
	}


	public static void main(String[] args) {

		try {
			
			ArrayList<DataPoint> datapoints = dataFromURL(dataURL);
			
			//Loop over ArrayList and print each DataPoint:
			
			for(DataPoint p : datapoints){
				System.out.println(p);
			}

		} 

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
