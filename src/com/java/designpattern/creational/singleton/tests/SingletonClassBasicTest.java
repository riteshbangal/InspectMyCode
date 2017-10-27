/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is responsible to test singleton class.
 * 
 * Singleton design pattern is not as simple as you thought.
 * There are many ways you can break a singleton implementation and hence it is very hard to get right. 
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClassBasicTest extends BasicTest {

	public static void main(String[] args) {
		
		
		// SingletonClass sc1 = new SingletonClass() // Not allowed 
		SingletonClass sc2 = SingletonClass.getInstance();
		print("sc2" , sc2);
		SingletonClass sc3 = SingletonClass.getInstance();
		print("sc3" , sc3);
	}
}
