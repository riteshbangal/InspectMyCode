package com.java.learning.concurrency;

public class TaskTwo implements Runnable {
	@Override
	public void run() {
		System.out.println("Executing Task Two");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}