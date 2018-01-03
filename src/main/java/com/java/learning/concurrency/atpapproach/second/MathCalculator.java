package com.java.learning.concurrency.atpapproach.second;

public class MathCalculator {

	public static long calculateNumberOfDivisible(long first, long last, long divisor) {
		long amount = 0;
		for (long i = first; i <= last; i++) {
			if (i % divisor == 0) {
				amount++;
			}
		}
		return amount;
	}
	
	public static Output calculate(Input pInput) {

		long result = 0;
		sleep();
		
		switch (pInput.getOperation()) {
		case "+":
			result = pInput.getNumOne() + pInput.getNumTwo();
			break;
		case "-":
			result = pInput.getNumOne() - pInput.getNumTwo();
			break;
		case "*":
			result = pInput.getNumOne() * pInput.getNumTwo();
			break;
		case "/":
			result = pInput.getNumOne() / pInput.getNumTwo();
			break;
		default:
			break;
		}
		
		return new Output(pInput, result);
	}

	private static void sleep() {
		//calculateNumberOfDivisible(0, 300000003, 3);
		try {
			Thread.sleep(1 * 1000);
			//Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
