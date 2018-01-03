package com.java.learning.concurrency.atpapproach.second;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CalculatorDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<Input> inputs = prepareinputs();
		
		// Sequential execution
		sequentialCalculation(inputs);
		sequentialCalculation(inputs);

		// Clear cache
		MathCalculator.cachedClient.flushAll();
		MathCalculator.ehcache.flush();
		
		// Parallel execution - 
		parallelCalculation(2, inputs);
		parallelCalculation(2, inputs);
		/*parallelCalculation(3, inputs);
		parallelCalculation(4, inputs);
		parallelCalculation(5, inputs);
		parallelCalculation(6, inputs);
		parallelCalculation(7);
		parallelCalculation(8);
		parallelCalculation(9);
		parallelCalculation(100);*/
		
		MathCalculator.cacheManager.shutdown();
	}

	private static List<Input> prepareinputs() {
		List<Input> inputs = new ArrayList<>();
		inputs.add(new Input(40, 20, "+"));
		inputs.add(new Input(40, 20, "-"));
		inputs.add(new Input(40, 20, "*"));
		inputs.add(new Input(40, 20, "/"));
		/*inputs.add(new Input(80, 50, "+"));
		inputs.add(new Input(80, 50, "-"));
		inputs.add(new Input(80, 50, "*"));
		inputs.add(new Input(80, 50, "/"));*/
		return inputs;
	}

	private static void parallelCalculation(int pSegments, List<Input> pInputs) 
			throws InterruptedException, ExecutionException {
		
		System.out.println("\nStarting parallel execution with segment = " + pSegments + "....");
		long timeStartFuture = System.currentTimeMillis();
		
		Set<Callable<Output>> callables = getAllCallables(pInputs);

		//ExecutorService executorService = Executors.newFixedThreadPool(pSegments);
		ExecutorService executorService = Executors.newFixedThreadPool(callables.size());
		List<Future<Output>> futures = executorService.invokeAll(callables);
		Set<Output> outputs = futures.parallelStream()
				.map(future -> {
					try {
						Output output = future.get();
						return output;
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
					return null;
				})
				.collect(Collectors.toSet());
		
		outputs.parallelStream().forEach(output -> System.out.println("Output (Future): future.get = " + output));
		
		// Shutdown the ExecutorService
		executorService.shutdown();

		long timeEndFuture = System.currentTimeMillis();
		long timeNeededFuture = timeEndFuture - timeStartFuture;
		System.out.println("Result (Future) calculated in " + timeNeededFuture + " ms");
	}

	private static void sequentialCalculation(List<Input> pInputs) {
		System.out.println("Starting sequential execution ....");
		long timeStart = System.currentTimeMillis();
		for (Input input : pInputs) {
			Output output = MathCalculator.calculate(input);
			System.out.println("Output         : " + output);
		}
		
		long timeEnd = System.currentTimeMillis();
		long timeNeeded = timeEnd - timeStart;
		System.out.println("Result calculated in " + timeNeeded + " ms");
	}

	private static Set<Callable<Output>> getAllCallables(List<Input> pInputs) {
		Set<Callable<Output>> callables = new HashSet<Callable<Output>>();
		for (Input input : pInputs) {
			callables.add(new CallableMathCalculator(input));
		}
		return callables;
	}
}
