package module8;

/**
 * Main class for testing the CountdownTask and PrimeNumberTask classes.
 * Sees how many prime numbers PrimeNumberTask can find in a given time window. 
 * @author zcapscb
 */

public class ThreadsMain {

	public static void main(String[] args) {

		//Creating 2 new separate threads to run simultaneously:
		Thread countdown10 = new Thread(new CountdownTask(10));
		Thread primeNumbers10 = new Thread(new PrimeNumberTask());

		countdown10.start();
		primeNumbers10.start();

		try{					
			countdown10.join(); // When the count-down has finished...
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		primeNumbers10.interrupt(); //...Interrupt the primeNumberTask. 

	}

}
