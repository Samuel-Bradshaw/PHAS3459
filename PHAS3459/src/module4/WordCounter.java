package module4; 
//Counts the number of words in an online document 
import java.io.*; 
import java.net.*; 
import java.util.*; 
public class WordCounter { 
	//Returns a buffered reader of an online file.
	public static BufferedReader brFromURL(String urlName) throws IOException{ 
		URL url = new URL(urlName); 
		InputStream istream = url.openStream(); 
		InputStreamReader isr = new InputStreamReader(istream); 
		BufferedReader buffr = new BufferedReader(isr); 
		return buffr;} 
	//Returns a buffered reader of a local file. 
	public static BufferedReader brFromFile(String fileName) throws IOException{ 
		FileReader fr = new FileReader("filename"); 
		BufferedReader br = new BufferedReader(fr); 
		return br; 
	} 
	public static int countWordsInResource(BufferedReader dataAsBR) throws IOException { 
		try(Scanner scanner1 = new Scanner(dataAsBR);
				){
			int wordcount = 0; // initialising word count 
			while (scanner1.hasNext()){ //As long as there is a word after the current position in document... 
				wordcount++; //...increment the word count.
				scanner1.next(); //...and shift position to next word in document 
			}

			return wordcount;
		}
	}



	public static void main(String[] args){ 
		try { 
			BufferedReader br = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt"); 
			int count = countWordsInResource(br); 
			System.out.println("Wordcount:"+count);
		}
		catch (IOException e) { 
			e.printStackTrace();
		}
	}

} 