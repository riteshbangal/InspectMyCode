package com.java.learning.inheritance.diamondproblem;

public interface ThirdInterface extends FirstInterface, SecondInterface {

	void test();

	default void test(int age) {
		//test("RCB"); 
		/*
		 * If ThirdInterface.test() is not present it throws following error.
		 * The method test(int) in the type ThirdInterface is not applicable for the arguments (String)
		 */

		System.out.println("ThirdInterface.test(age) | age = " + age);
	}

	/**
	 * Duplicate default methods named test with the parameters (int, long) and (int, long)
	 * are inherited from the types SecondInterface and FirstInterface
	 */
	@Override
	default void test(int age, long phnNum) {
		FirstInterface.super.test(age, phnNum);
	}

	/*static void test(String name) {
		System.out.println("ThirdInterface.test(name) | name = " + name);
	}*/
}