package com.java.learning.error;

public class TestError {

	public static void main(String[] args) {
		try {
			// Why does it not access TestExceptions.test-method in the class?
			test("Hi! RCB.");
			test(null);
		} catch (Error a) {
			System.out.println("Working Status: " + a.getMessage());
		}
	}

	static void test(String message) throws Error {
		if (null == message) {
			throw new Error("Empty message");
		}
		System.out.println(message);
	}
}