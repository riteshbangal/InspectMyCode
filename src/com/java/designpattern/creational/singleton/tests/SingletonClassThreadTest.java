/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is responsible to test singleton class using 'Multi threaded access'.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClassThreadTest extends BasicTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		for (int i = 0; i < 10; i++) {
			createSingleton();
			createSingleton();
			
			// Multi threaded access
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			executorService.submit(SingletonClassThreadTest::createSingleton);
			executorService.submit(SingletonClassThreadTest::createSingleton);
		}

	}
	
	static void createSingleton() {
		for (int i = 0; i < 10; i++) {
			SingletonClass singletonClass = SingletonClass.getInstance();
			print("singletonClass" , singletonClass);
		}
	}
}
