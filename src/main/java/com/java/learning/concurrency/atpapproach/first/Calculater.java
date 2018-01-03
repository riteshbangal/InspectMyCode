package com.java.learning.concurrency.atpapproach.first;

public class Calculater {

	/**
	 * Calculate number of divisible.
	 * 
	 * Returns the amount of numbers that can be divided by the divisor without
	 * remainder.
	 *
	 * @param first
	 *            the first
	 * @param last
	 *            the last
	 * @param divisor
	 *            the divisor
	 * @return the int
	 */
	public static long calculateNumberOfDivisible(long first, long last, long divisor) {

		//System.out.println("first: " + first + ", last: " + last);
		long amount = 0;

		for (long i = first; i <= last; i++) {
			if (i % divisor == 0) {
				amount++;
			}
		}
		return amount;
	}

}
