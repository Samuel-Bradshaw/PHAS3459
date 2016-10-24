package module4; 

import java.io.*; 
import java.net.*; 
import java.util.*; 
/** 
 * 
 * @author zcapscb
 *
 */
public class NumericalReader { 

	//Member variables
	private double minValue; 
	private double maxValue; 
	private double nValues; 
	private double sumOfValues;
	private String dataFile1;
	private static String filename = "numbers.txt";

	//Asks user to enter a string and stores the entered string. 
	public static String getStringFromKeyboard() throws IOException{ 
		System.out.println("Please specify the directory to store the data file in:"); 
		InputStreamReader input1 = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(input1); 
		String string1 = br.readLine(); 
		return string1; 
	} 

	//Reads an online document and returns the resulting 
	public BufferedReader brFromURL(String urlName) throws IOException{ 
		URL url = new URL(urlName); 
		InputStream istream = url.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 
		return buffr; 
	} 

	//Creates a data file 
	void analysisStart(String dataFile) throws IOException{ 
		//datafile represents the Directory where we want the file to be stored and the file name
		File outputfile = new File(dataFile); 
		outputfile.mkdirs();
		outputfile.createNewFile();
		System.out.println("File "+dataFile+" created.");

		//Initialising for use in analyseData method
		dataFile1 = dataFile;

		//Initialising values 
		minValue = 0.0; 
		maxValue = 0.0; 
		nValues = 0.0; 
		sumOfValues = 0.0;  
	} 

	void analyseData(String line) throws IOException { 

		char firstCharacterOfLine = line.trim().charAt(0);//isolating the first character of string to see if line is a comment. 
		if(line.trim().isEmpty() || Character.isLetter(firstCharacterOfLine) ){ //-ignoring blank and comment lines.
		}  
		//For lines containing numbers: write these numbers  
		//one per line to the screen AND to a file; 
		else{ 
			try(Scanner sc1 = new Scanner(line);
					){

				double currentLineTotal = 0;
				int currentnValuesLine = 0;

				while(sc1.hasNextDouble()){ 
					Double token = sc1.nextDouble(); 
					System.out.println(token); 
					//WRITE THESE NUMBERS TO A FILE 
					FileWriter fw = new FileWriter(dataFile1);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					pw.println(token); 
					//using number read in, update minValue, maxValue, nValues, sumofValues 
					if (token < minValue){
						minValue = token;
					}
					if(token >maxValue){
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
	// Prints  the minimum value, the maximum value, the average value and the total number of values read. 
	void analysisEnd(){ 
		System.out.println("minValue: "+minValue); 
		System.out.println("maxValue: "+maxValue); 
		System.out.println("nValues: "+nValues); 
		System.out.println("sumOfValues: "+sumOfValues); 
	} 

	public static void main(String[] args) throws IOException {  
		//Create new NumericalReader object:
		NumericalReader nr = new NumericalReader();

		BufferedReader reader = nr.brFromURL("http://foo/bar/");
		//Initialise line:
		String line = "";

		//Manually enter the directory as a string
		String directory = NumericalReader.getStringFromKeyboard();
		//Concatenate the resulting String with the name of the specific file in which to store the data 
		String saveFile = (directory + File.separator + filename);
		//Pass this String saveFile thorugh analysis start
		nr.analysisStart(saveFile); // initialize minValue etc.
		while ((line = reader.readLine()) != null) {
			nr.analyseData(line); // analyze lines, check for comments etc.
		}
		nr.analysisEnd(); // print min, max, etc.

	} 
} 


