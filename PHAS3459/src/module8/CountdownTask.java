package module8;

/**
 * A class representing a count-down (in steps of -1 second), printing the number of 
 * seconds remaining in the count-down to screen. 
 * 
 * Implements Runnable.
 * @author zcapscb
 *
 */

public class CountdownTask implements Runnable {

	//Member variable - represents the number we want to count-down from. 
	int countdownFrom;

	/**
	 * Constructor creating a CountdownTask object  
	 * @param seconds 
	 */
	CountdownTask(int seconds){
		this.countdownFrom = seconds;
	}
	
	
	/**
	 * Method part of Runnable interface.
	 * Outlines the count-down process, printing each decrement in the time to the screen. 
	 */
	public void run() {
		System.out.println("Starting Countdown...");
		for(int i = countdownFrom; i > 0; i--){
			System.out.println(i);
			try {
				Thread.sleep(1000);//Pause for a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(0);
		System.out.println("Countdown complete.");
		return;
	}

}
