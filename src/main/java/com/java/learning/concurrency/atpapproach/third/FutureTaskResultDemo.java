package com.java.learning.concurrency.atpapproach.third;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTaskResultDemo {

	// Maximum number to check
	public static final long MAX_NUMBER = 300000003;

	// DIVISOR to be used in calculation
	private static final long DIVISOR = 3;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Sequential execution
		sequentialCalculation();

		// Parallel execution - 
		parallelCalculation(6);
		/*parallelCalculation(3);
		parallelCalculation(4);
		parallelCalculation(5);
		parallelCalculation(6);
		parallelCalculation(7);
		parallelCalculation(8);
		parallelCalculation(9);
		parallelCalculation(100);*/
	}

	private static void parallelCalculation(int pSegments) throws InterruptedException, ExecutionException {
		System.out.println("\nStarting parallel execution with segment = " + pSegments + "....");
		long timeStartFuture = System.currentTimeMillis();
		
		Set<Callable<Result>> callables = getAllCallables(pSegments);

		// Create a new ExecutorService with 2 thread to execute and store the Futures
		ExecutorService executorService = Executors.newFixedThreadPool(callables.size());
		List<Future<Result>> futures = executorService.invokeAll(callables);

		for (Future<Result> future : futures) {
			System.out.println("Result (Future): future.get = " + future.get());
		}

		// Shutdown the ExecutorService
		executorService.shutdown();

		long timeEndFuture = System.currentTimeMillis();
		long timeNeededFuture = timeEndFuture - timeStartFuture;
		System.out.println("Result (Future) calculated in " + timeNeededFuture + " ms");
	}

	@SuppressWarnings("unchecked")
	private static Set<Callable<Result>> getAllCallables(int pSegments) {
		Set<Callable<Result>> callables = new HashSet<Callable<Result>>();
		for (int i = 0; i < pSegments; i++) {
			long j = 1;
			if (i == 0) {
				j = 0;
			}
			
			callables.add(new CallableCalculator(i * MAX_NUMBER / pSegments + j, (i+1) * MAX_NUMBER / pSegments, DIVISOR));
		}
		return callables;
	}

	private static void sequentialCalculation() {
		System.out.println("Starting sequential execution ....");
		long timeStart = System.currentTimeMillis();
		Result result = Calculator.calculateNumberOfDivisible(0, MAX_NUMBER, DIVISOR);
		long timeEnd = System.currentTimeMillis();
		long timeNeeded = timeEnd - timeStart;
		System.out.println("Result         : " + result);
		System.out.println("Result calculated in " + timeNeeded + " ms");
	}
}
