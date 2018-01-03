package com.java.learning.concurrency.atpapproach.first;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@SuppressWarnings("rawtypes")
public class FutureTaskDemo {

	// Maximum number to check
	public static final long MAX_NUMBER = 300000003;

	// DIVISOR to be used in calculation
	private static final long DIVISOR = 3;

	public static void main(String[] args) {

		// Sequential execution
		sequentialCalculation();

		// Parallel execution - 
		parallelCalculation(2);
		parallelCalculation(3);
		parallelCalculation(4);
		parallelCalculation(5);
		parallelCalculation(6);
		parallelCalculation(7);
		parallelCalculation(8);
		parallelCalculation(9);
		parallelCalculation(100);
	}

	private static void parallelCalculation(int pSegments) {
		System.out.println("Starting parallel execution with segment = " + pSegments + "....");
		long timeStartFuture = System.currentTimeMillis();

		List<FutureTask> taskList = splitAndGetTaskList(pSegments);
		
		// Create a new ExecutorService with 2 thread to execute and store the Futures
		ExecutorService executor = Executors.newFixedThreadPool(taskList.size());
		for (FutureTask futureTask : taskList) {
			executor.execute(futureTask);
		}

		long resultFuture = 0;
		// Wait until all results are available and combine them at the same time
		for (FutureTask futureTask : taskList) {
			try {
				resultFuture += (long) futureTask.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		// Shutdown the ExecutorService
		executor.shutdown();

		long timeEndFuture = System.currentTimeMillis();
		long timeNeededFuture = timeEndFuture - timeStartFuture;
		System.out.println("Result (Future): " + resultFuture + " calculated in " + timeNeededFuture + " ms");
	}

	@SuppressWarnings("unchecked")
	private static List<FutureTask> splitAndGetTaskList(int pSegments) {
		List<FutureTask> taskList = new ArrayList<FutureTask>();
		/*
		// Start thread for the first half of the numbers
		FutureTask futureTask_1 = new FutureTask(new CallableCalculater(0 * MAX_NUMBER / pSegments + 1, 1 * MAX_NUMBER / pSegments, DIVISOR));
		taskList.add(futureTask_1);
		
		// Start thread for the second half of the numbers
		FutureTask futureTask_2 = new FutureTask(new CallableCalculater(1 * MAX_NUMBER / pSegments + 1, 2 * MAX_NUMBER / pSegments, 3));
		taskList.add(futureTask_2);
		
		FutureTask futureTask_3 = new FutureTask(new CallableCalculater(2 * MAX_NUMBER / pSegments + 1, 3 * MAX_NUMBER / pSegments, 3));
		taskList.add(futureTask_3);
		*/
		
		for (int i = 0; i < pSegments; i++) {
			long j = 1;
			if (i == 0) {
				j = 0;
			}
			
			FutureTask futureTask = new FutureTask(new CallableCalculater(i * MAX_NUMBER / pSegments + j, (i+1) * MAX_NUMBER / pSegments, DIVISOR));
			taskList.add(futureTask);
		}
		return taskList;
	}

	private static void sequentialCalculation() {
		System.out.println("Starting sequential execution ....");
		long timeStart = System.currentTimeMillis();
		long result = Calculater.calculateNumberOfDivisible(0, MAX_NUMBER, DIVISOR);
		long timeEnd = System.currentTimeMillis();
		long timeNeeded = timeEnd - timeStart;
		System.out.println("Result         : " + result + " calculated in " + timeNeeded + " ms");
	}
}
