package com.java.learning.concurrency.atpapproach.third;

import java.util.concurrent.Callable;

@SuppressWarnings("rawtypes")
public class CallableCalculator implements Callable {

	private long first;
	private long last;
	private long divisor;

	/**
	 * Instantiates a new callable calculater.
	 *
	 * @param first
	 *            the first
	 * @param last
	 *            the last
	 * @param divisor
	 *            the divisor
	 */
	public CallableCalculator(long first, long last, long divisor) {
		this.first = first;
		this.last = last;
		this.divisor = divisor;
	}

	@Override
	public Result call() throws Exception {
		return Calculator.calculateNumberOfDivisible(first, last, divisor);
	}
}
