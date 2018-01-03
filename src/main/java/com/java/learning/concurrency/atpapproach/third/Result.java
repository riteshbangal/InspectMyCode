package com.java.learning.concurrency.atpapproach.third;

public class Result {

	private String expression;
	private long value;

	public Result() {
		super();
	}

	public Result(String expression, long value) {
		super();
		this.expression = expression;
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Result : [")
		.append("expression=").append(expression)
		.append(", value=").append(value)
		.append("]");
		return result.toString();
	}
	
	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public long getValue() {
		return this.value;
	}

	public void setValue(long value) {
		this.value = value;
	}
}
