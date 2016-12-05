package module8;


public class ThreadsMain {

	
	
	public static void main(String[] args) {
		Thread countdown10 = new Thread(new CountdownTask(1));
		Thread primeNumbers10 = new Thread(new PrimeNumberTask());
		
		countdown10.start();
		primeNumbers10.start();
		try{
			countdown10.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		primeNumbers10.interrupt();
		
	}

}
