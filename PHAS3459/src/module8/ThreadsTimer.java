package module8;

import java.util.*;
import java.util.concurrent.*;

/** 
 * Measures how the time taken to run a calculated estimate for pi 
 * depends on the number of threads used (1 or 4 threads) using the 
 * Monte Carlo method.
 * @author Samuel Bradshaw
 */

public class ThreadsTimer {

	public static void main(String[] args) {

		/**Calculate an estimate for pi using a single thread */

		//Begin timer for calculation 
		long startTime1 = System.currentTimeMillis();

		long nPoints = 10000000L;
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints); 
		double pi = task.call(); 
		System.out.println("Estimate of pi using a single thread: "+pi);

		//End timer for calculation
		long endTime1 = System.currentTimeMillis();
		long timeTaken1 = endTime1 - startTime1;
		System.out.println("Time taken using a single thread: "+timeTaken1+" mS\n");


		/**Calculate an estimate for pi using four threads */

		//Begin timer for second calculation
		long startTime2 = System.currentTimeMillis();

		int  nThreads = 4;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>(); // Use the Future class to represent the 
		for (int iThread = 0; iThread < nThreads; ++iThread) {			// result of each of the parallel calculations
			MonteCarloPiCalculatorTask task2 = new MonteCarloPiCalculatorTask(nPoints/nThreads);  
			Future<Double> future = threadPool.submit(task2);
			futures.add(future);  
		} 

		try {
			double sum = 0.0;
			for (int iThread = 0; iThread < nThreads; ++iThread) {  
				double result;
				result = futures.get(iThread).get();
				sum += result; //The sum of all four separate threads' calculation of pi.
			}
			
			threadPool.shutdown();
			double pi4 = sum/nThreads;
			System.out.println("Estimate of pi using four threads: "+pi4);

		//End timer for  second calculation 
		long endTime2 = System.currentTimeMillis();
		long timeTaken2 = endTime2 - startTime2;
		System.out.println("Time taken using four threads: "+timeTaken2+" mS");
			
			System.out.println("\nAs one can see, using four threads is faster than \n"
					+ "using one thread to perform the calculation.");

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
