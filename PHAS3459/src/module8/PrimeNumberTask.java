package module8;

import java.util.ArrayList;

/**
 * A class that forms a list of prime numbers, only stopping when 
 * the thread is interrupted. 
 * Implements Runnable.
 * @author zcapscb
 */

public class PrimeNumberTask implements Runnable {

	
	//Member variable
	ArrayList<Integer> primes = new ArrayList<Integer>();

	
	/**Method part of Runnable interface.
	 * Contributed to the list of Prime number integers,
	 * only stopping when the thread is interrupted. 
	 */
	public void run() {

		//Initiating the integer that we want to test to see if its prime:
		int i = 2;
		
		while(true){	 									// Let the method run 
			if (Thread.currentThread().isInterrupted()){ 	// until the thread is interrupted.
				System.out.println("Largest Integer checked by PrimeNumberTask: "+i);
				System.out.println("Largest prime number found: "+primes.get( primes.size()-1 ));
				System.out.println("Number of prime numbers found: "+primes.size());
				return;
			}

			//Divides the integer we are testing by the integers beneath it, starting at 2
			for(int j = 2; j <= i; j++){
				int remainderj = i % j;
				if(remainderj == 0 && i != 2){  // if the number is divisible by one of the integers below it
					break;						// discount it from the primes list.					
				}
				if(j > i/2){		//if the number we are testing goes above half of that integer 
					primes.add(i);	//without throwing a remainder of 0 we know that the number is prime/
					break;
				}
			}		
			
			i = i + 1; //Test the next integer for primeness 
		}
	}


}
