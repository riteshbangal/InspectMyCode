package com.java.learning.concurrency.atpapproach.second;

public class Input {
	
	private long numOne;
	private long numTwo;
	private String operation;

	public Input() {
		super();
	}
	
	public Input(long numOne, long numTwo, String operation) {
		super();
		this.numOne = numOne;
		this.numTwo = numTwo;
		this.operation = operation;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Input: [")
		.append(numOne).append(" ").append(operation).append(" ").append(numTwo)
		.append("]");
		return result.toString();
	}

	public long getNumOne() {
		return this.numOne;
	}

	public void setNumOne(long numOne) {
		this.numOne = numOne;
	}

	public long getNumTwo() {
		return this.numTwo;
	}

	public void setNumTwo(long numTwo) {
		this.numTwo = numTwo;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
