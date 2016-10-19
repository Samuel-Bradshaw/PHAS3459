package module3;

//Produced a string of random letters and digits 

import java.util.Random;

public class Alphabet {


	static Random random1 = new Random();

	//Method that produced a random character from 128 possibilities. 
	static char randomCharacter(){
		int randomint = random1.nextInt(127); //Producing a random character between 0 and 127
		char b = (char) (randomint); //Casting the random integer as a character. 
		return b;
	}

	//Defining a Stringbuilder object used below in main method section. 
	static StringBuilder word = new StringBuilder();


	public static void main(String[] args) {

		//Defining the variables used to track the total of the integers in the StringBuilder 'word'
		int total = 0;
		int exceptioncount = 0;

		for(int i = 0; i < 400; i++){
			//Each time the for loop is run, a random character is produced
			char c = randomCharacter();

			if(Character.isLetter(c) || Character.isDigit(c)){
				// If the character is a letter or digit, append it to our string called 'word'.
				word.append(c);
				// Convert the character to a string so we can pass it through Integer.parseInt(c).
				String s = Character.toString(c);
				try{ int n = Integer.parseInt(s);
				total = total + n;} // If the character is a digit, add it to the total.
				//If the parse.Int function throws an exception (i.e. c is a letter) add 1 to the exception count
				catch (Exception e){
					exceptioncount = exceptioncount + 1;
				}
			}
		}

		System.out.println(word);
		System.out.println("Length of string: "+word.length()+" characters");
		System.out.println("Total (sum of digits in string) = "+total);
		System.out.println("Exception count (number of letters in string) = "+exceptioncount);

	}






}
