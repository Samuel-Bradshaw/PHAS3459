package module4; 

/** 
 * Reads data from an online document, 
 * prints it to the screen and writes it to a .txt document. 
 * @author zcapscb
 */

import java.io.*; 
import java.net.*; 
import java.util.*;

public class NumericalReader { 

	//Member variables
	private double minValue; 
	private double maxValue; 
	private int nValues; 
	private double sumOfValues;
	private String dataFile1;
	private static String filename1 = "numbers1.txt";
	private static String filename2 = "numbers2.txt";

	//Asks user to enter a string and stores the entered string. 
	public static String getStringFromKeyboard() throws IOException{ 
		System.out.println("Please specify the directory to store the data file in:"); 
		InputStreamReader input1 = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(input1); 
		String string1 = br.readLine(); 
		return string1; 
	} 

	//Reads an online document and returns the resulting BufferedReader
	public BufferedReader brFromURL(String urlName) throws IOException{ 
		URL url = new URL(urlName); 
		InputStream istream = url.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 
		return buffr; 
	} 

	//Creates a data file  and initialises values for minValue, MaxValue, nValues, sumOfValues
	void analysisStart(String dataFile) throws IOException{ 
		//datafile represents the Directory where we want the file to be stored and the file name
		File outputfile = new File(dataFile); 
		outputfile.getParentFile().mkdirs();
		outputfile.createNewFile();
		System.out.println("File "+dataFile+" created.");

		//Initialising for use in analyseData method
		dataFile1 = dataFile;

		//Initialising values 
		minValue = 100000.0; //this needs to be large so that the actual minValue in the file is smaller than the initialised value 
		maxValue = 0.0; 
		nValues = 0; 
		sumOfValues = 0.0; 
	} 

	//Looks at each line in turn, rejects comment lines, prints data values to screen and to a txt. document, while updating minValue, maxValue etc.
	void analyseData(String line) throws IOException { 
		//Initialising the scanner and necessary objects for reading document and writing to a file: 
		try(Scanner sc1 = new Scanner(line);
				FileWriter fw = new FileWriter(dataFile1, true); //dataFile1 was initialised in analysisStart method above. The second argument, true, assures that each time we add data value to file it doesn't overwrite previous one.
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				){

			if(line.trim().isEmpty() || Character.isLetter(line.trim().charAt(0)) ){ //-ignoring blank and comment lines.
				//In the second If condition above^, the argument to isLetter, line.trim().charAt(0), isolates the first character of line to see if line is a comment. 
			} 

			//For lines containing numbers: write these numbers 
			//one per line to the screen AND to a file; 
			else{ 	

				double currentLineTotal = 0;//Initialising counting of data values in each line
				int currentnValuesLine = 0;

				while(sc1.hasNextDouble()){ 
					Double token = sc1.nextDouble(); 
					System.out.println(token);//-Prints each data file read in to the screen.
					//Write these data values to a file using PrintWriter, pw: 
					pw.println(token);
					//using number read in, update minValue, maxValue, nValues, sumofValues 
					if (token < minValue){
						minValue = token;
					}
					if(token > maxValue){
						maxValue = token;
					}
					currentLineTotal = currentLineTotal + token;
					currentnValuesLine++; 
				}
				nValues = currentnValuesLine + nValues;
				sumOfValues = currentLineTotal + sumOfValues; 
			} 
		} 
	} 

	// Prints the minimum value, the maximum value, the average value and the total number of values read. 
	void analysisEnd(){ 
		System.out.println("minValue: "+minValue); 
		System.out.println("maxValue: "+maxValue); 
		System.out.println("nValues: "+nValues); 
		System.out.println("sumOfValues: "+sumOfValues+"\n"); 
	} 

	public static void main(String[] args) throws IOException { 

		//Manually enter the directory where we want resulting txt files to be stored:
		String directory = NumericalReader.getStringFromKeyboard();

		/** Document 1:**/

		//Create new NumericalReader object:
		NumericalReader nr = new NumericalReader();
		//Takes data from online document and converts to Buffered Reader:
		BufferedReader reader1 = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		//Initialise line:
		String line = "";

		//Concatenate the resulting String with the name of the specific file in which to store the data 
		String saveFile1 = (directory + File.separator + filename1);
		String saveFile2 = (directory + File.separator + filename2);

		//Pass this String saveFile through analysis start
		nr.analysisStart(saveFile1); // initialise minValue etc.
		System.out.println("Data Values from http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt:");

		while ((line = reader1.readLine()) != null) {
			nr.analyseData(line); // analyze lines, check for comments etc.
		}
		nr.analysisEnd(); // print min, max, etc.

		/** Document 2:**/ 

		//Following same procedure as above ^:
		NumericalReader nr2 = new NumericalReader();
		BufferedReader reader2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		String line2 = "";

		nr2.analysisStart(saveFile2);
		System.out.println("Data Values from http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt:");

		while ((line2 = reader2.readLine()) != null) {
			nr2.analyseData(line2); // analyze lines, check for comments etc.
		}
		nr2.analysisEnd(); // print min, max, etc.
	} 
}



