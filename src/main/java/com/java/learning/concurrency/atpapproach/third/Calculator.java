package com.java.learning.concurrency.atpapproach.third;

public class Calculator {

	public static Result calculateNumberOfDivisible(long first, long last, long divisor) {

		long amount = 0;

		for (long i = first; i <= last; i++) {
			if (i % divisor == 0) {
				amount++;
			}
		}
		Result result = new Result("[" + first + ", " + last + "] / " + divisor, amount);
		return result;
	}
}
