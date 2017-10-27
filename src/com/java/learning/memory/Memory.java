package com.java.learning.memory;
public class Memory {

	public static void main(String[] args) { // Line 1
		int i = 0;
		Balloon red = new Balloon("Red", 222);
		Balloon blue = new Balloon("Blue", 444);
	
		System.out.println("Red Object: " + red);
		System.out.println("Blue Object: " + blue);
		swap(red, blue);
		System.out.println("Red Object: " + red);
		System.out.println("Blue Object: " + blue);
		
		foo(red);
		System.out.println("Red Object: " + red);
	}
	
	private static void swap(Balloon pBalloon1, Balloon pBalloon2) {
		Balloon temp = pBalloon1;
		pBalloon1 = pBalloon2;
		pBalloon2 = temp;
	}

	private static void foo(Balloon pBalloon) {
		pBalloon.setColor("lol");
		Balloon balloon = new Balloon("kala", 000);
		balloon.setColor("kolo");
	}
}