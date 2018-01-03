package com.java.learning.inheritance.diamondproblem;

public interface FirstInterface {

	void test();

	default void test(int age) {
		System.out.println("FirstInterface.test(age) | age = " + age);
	}
	
	default void test(int age, long phnNum) {
		System.out.println("FirstInterface.test(age, phnNum) | age = " + age + " and phnNum = " + phnNum);
	}

	static void test(String name) {
		System.out.println("FirstInterface.test(name) | name = " + name);
	}

	/*
	 * Illegal combination of modifiers for the interface method test; 
	 * only one of abstract, default, or static permitted
	 */
	/*default static void test(String name, int age) {
		System.out.println("FirstInterface.test(name, age) | name = " + name + " and age = " + age);
	}*/
}