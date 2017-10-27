package com.java.learning.memory;

public class Balloon {

	private String  color;
	private Integer size;

	public Balloon() {
		// Default constructor
	}
	
	public Balloon(String pColor, Integer pSize) {
		super();
		color = pColor;
		size = pSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String pColor) {
		color = pColor;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer pSize) {
		size = pSize;
	}

	@Override
	public String toString() {
		StringBuilder velocity = new StringBuilder("Balloon");
		velocity.append(": {")
			.append("color=").append(color)
			.append(", size=").append(size)
			.append("}");
		return velocity.toString();
	}
}
