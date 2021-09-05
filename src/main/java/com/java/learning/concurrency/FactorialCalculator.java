package com.java.learning.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

	private Integer number;

	public FactorialCalculator(Integer number) {
		this.number = number;
	}
	
	Callable<String> callable = () -> {
		// Perform some computation
		Thread.sleep(2000);
		return "Return some result";
	};

	@Override
	public Integer call() throws Exception {
		int result = 1;
		if ((number == 0) || (number == 1)) {
			//result = 1;
			System.out.println("Number is 0 or 1. Creating an exception programmatically!");
			TimeUnit.MILLISECONDS.sleep(2000);
			throw new Exception("Number is 0 or 1. Creating an exception programmatically!");
		} else {
			for (int i = 2; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		System.out.println("Result for number - " + number + " -> " + result);
		return result;
	}
}
