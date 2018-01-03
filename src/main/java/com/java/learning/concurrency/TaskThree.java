package com.java.learning.concurrency;

public class TaskThree implements Runnable {
	@Override
	public void run() {
		System.out.println("Executing Task Three");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}