package com.java.learning.inheritance.diamondproblem;

public interface SecondInterface {

	void test();

	default void test(int age) {
		System.out.println("SecondInterface.test(age) | age = " + age);
	}
	
	default void test(int age, long phnNum) {
		System.out.println("SecondInterface.test(age, phnNum) | age = " + age + " and phnNum = " + phnNum);
	}

	static void test(String name) {
		System.out.println("SecondInterface.test(name) | name = " + name);
	}

	static void test(String name, int age) {
		System.out.println("FirstInterface.test(name, age) | name = " + name + " and age = " + age);
	}
}