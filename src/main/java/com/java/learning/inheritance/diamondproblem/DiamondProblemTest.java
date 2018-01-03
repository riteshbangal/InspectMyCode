package com.java.learning.inheritance.diamondproblem;

public class DiamondProblemTest implements SecondInterface {

	@Override
	public void test() {
		System.out.println("FirstInterface.test() called.");
	}
	
	
	public static void main(String[] args) {
		// test("rcb"); // Compilation Error: The method test(int) in the type DiamondProblemTest is not applicable for the arguments (String)
		new DiamondProblemTest().callMethods();
	}


	private void callMethods() {
		test();
		test(10);
		//test("rcb"); // Compilation Error: The method test(int) in the type DiamondProblemTest is not applicable for the arguments (String)
		SecondInterface.test("yui"); 
	}
	
	public void test(int age) {
		System.out.println("DiamondProblemTest.test(age) | age = " + age);
	}
}