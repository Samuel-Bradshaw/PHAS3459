package module1;

public class AlgorithmControl {
	
	static void loop() {
		int i = 1;
		int maxN = 20;
		for (i = 1; i <= maxN; i++){
			System.out.println(i);}
				}
	static void decrement(){
		int j = 8;
		int k = -10;
		for(j = 10; j >= k; j--){
			System.out.println(j);
		}
	}
	
	static void increment(){
		double ix = 1.2;
		double iy = 10.8;
		double inc1 = 0.4;
		for(ix = 1.2; ix <= iy; ix = ix+inc1){
			System.out.println(ix);
		}
	}

	//// initializing variables for timer function 
	//int loopcount = 0;
	//long timeNow = System.currentTimeMillis();
	//long timeEnd = timeNow + 5000; 	
	//int loopPoint = 1;
	//int loopmark = 200;
	
	//void timer(){
	//	while(System.currentTimeMillis() < timeEnd){
	//		if (loopPoint < loopmark){ 
	//			loopPoint = loopPoint + 1;} //  - Counting how many times the while loop has run by tracking it as "loopPoint" variable.
	//		else if(loopPoint == loopmark){ //  - Each time the while loop is run 200 times,
	//			loopPoint  = 1;        //   	  reset the loop point back to the start,
	//			loopcount = loopcount + 1; // and add 1 to the loop count and print the loop count
	//			System.out.println(loopcount);}
	//
	//			}
	//		}
	
	int timer(long maxTime, int loopsteps){
		int loopcount = 0;                          //initialising the variables inside the method. 
		long timeNow = System.currentTimeMillis();
		int loopPoint = 1;
		while(System.currentTimeMillis() < timeNow + maxTime){
			if (loopPoint < loopsteps){ 
				loopPoint = loopPoint + 1;} //  - Counting how many times the while loop has run by tracking it as "loopPoint" variable.
			else if(loopPoint == loopsteps){ //  - Each time the while loop is run loopsteps times,
				loopPoint  = 1;        //   	  reset the loop point back to the start,
				loopcount = loopcount + 1; // and add 1 to the loop count and print the loop count
				System.out.println(loopcount);}
				}
			return loopcount;
			}
	
		
	
	public static void main(String[] args) {
		
		//invoking the loop function defined above
		System.out.println("loop function:");
		loop();
		//invoking the decrement function defined above
		System.out.println("\ndecrement function");
		decrement();
		//invoking the increment function defined above
		System.out.println("\nincrement function");
		increment();
		
		//Invoking the timing function
		System.out.println("\ntimer function");
		AlgorithmControl ac1 = new AlgorithmControl(); 
		int loops1 = ac1.timer(10000, 500); // running the timer for 10 seconds and printing every 500 loops
		int loops2 = ac1.timer(10000, 50000); // running the timer for 10 seconds and printing every 50000 loops
		System.out.println("500 loop counts: "+loops1);
		System.out.println("50,000 loop counts: "+loops2);		
		}

	}

