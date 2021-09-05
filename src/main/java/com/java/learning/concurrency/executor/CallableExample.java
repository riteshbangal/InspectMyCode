package com.java.learning.concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import com.java.learning.concurrency.FactorialCalculator;

public class CallableExample {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		//scheduledExecutorService.schedule(new FactorialCalculator(5), 15, TimeUnit.SECONDS);
		//scheduledExecutorService.scheduleAtFixedRate(new Processor(), 5, 10, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Processor(), 5, 10, TimeUnit.SECONDS);

	}

	private static class Processor implements Runnable {
		@Override
		public void run() {
			System.out.println("****** Start: Processor execution ******");
			int coreCount = Runtime.getRuntime().availableProcessors(); // If your task is CPU intensive, not IO intensive.
			System.out.println("Number of Cores: " + coreCount);
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(coreCount);

			List<Future<Integer>> resultList = new ArrayList<>();

			Random random = new Random();

			for (int i = 0; i < 4; i++) {
				Integer number = random.nextInt(10);
				FactorialCalculator calculator = new FactorialCalculator(number);
				Future<Integer> result = executor.submit(calculator);
				resultList.add(result);

				//CompletableFuture.
			}
			// System.out.println("Result has been prepared.");

			for (Future<Integer> future : resultList) {
				try {
					System.out.println("Future result is - " + " " + future.get(5, TimeUnit.SECONDS)
											+ "; And Task done is " + future.isDone());
				} catch (InterruptedException | ExecutionException | TimeoutException e) {
					future.cancel(false);
					System.out.println("future.isCancelled(): " + future.isCancelled());

					//e.printStackTrace();
				}
			}

			// shut down the executor service now
			//executor.shutdown();
			executor.shutdownNow();
			System.out.println("executor.isShutdown(): " + executor.isShutdown());
			System.out.println("executor.isTerminated(): " + executor.isTerminated());

			System.out.println("****** End: Processor execution ******");
		}
	}
}
