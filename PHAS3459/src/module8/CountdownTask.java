package module8;

public class CountdownTask implements Runnable {

	int countdown;

	CountdownTask(int seconds){
		this.countdown = seconds;
	}

	@Override
	public void run() {
		for(int i = countdown; i > 0; i--){
			//System.out.println(i);
			try {
				Thread.sleep(1000);//Pause for a second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(0);
		return;
	}

}
