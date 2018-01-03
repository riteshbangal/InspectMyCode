package com.java.learning.concurrency.atpapproach.second;

public class Output {
	
	private Input input;
	private long result;

	public Output() {
		super();
	}
	
	public Output(Input input, long result) {
		super();
		this.input = input;
		this.result = result;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Output: [")
		.append(input).append(" = ").append(result)
		.append("]");
		return output.toString();
	}

	public Input getInput() {
		return this.input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public long getResult() {
		return this.result;
	}

	public void setResult(long result) {
		this.result = result;
	}
}
