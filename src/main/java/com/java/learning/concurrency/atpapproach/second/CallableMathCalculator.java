package com.java.learning.concurrency.atpapproach.second;

import java.util.concurrent.Callable;

public class CallableMathCalculator implements Callable<Output> {

	private Input input;

	public CallableMathCalculator(Input input) {
		this.input = input;
	}

	@Override
	public Output call() throws Exception {
		return MathCalculator.calculate(input);
	}
}
