package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {

	ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public void run() {
		
		//Integer that we want to test to see if its prime
		int i = 2;
		
		//runs until the thread is interrupted 
		while(true){

			if (Thread.currentThread().isInterrupted()){ 
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
			
			i = i + 1;
		}
	}
	

}
