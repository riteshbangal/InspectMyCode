package com.java.learning.annotation;

public class Person {

	@MyAnnotation(maxLength = 10)
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
