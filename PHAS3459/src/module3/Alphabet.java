package module3;

import java.util.Random;
import java.lang.Character;
import java.lang.Integer;
import java.lang.Math;

public class Alphabet {
	
	
	static Random random1 = new Random();
	
	static char randomCharacter(){
		int randomint = random1.nextInt(127);
		char b = (char) (randomint); 
		return b;
	}
	
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char b = randomCharacter();
		System.out.println(b);
		

		
		
	}

}
