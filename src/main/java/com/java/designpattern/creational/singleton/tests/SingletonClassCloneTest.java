/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is responsible to test singleton class using 'Clone'.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClassCloneTest extends BasicTest {

	@SuppressWarnings({ })
	public static void main(String[] args) throws CloneNotSupportedException {
		
		SingletonClass sc2 = SingletonClass.getInstance();
		print("sc2" , sc2);
		SingletonClass sc3 = SingletonClass.getInstance();
		print("sc3" , sc3);
		
		// Clone
		SingletonClass sc1 = (SingletonClass) sc2.clone();
		print("sc1" , sc1);
		SingletonClass sc4 = (SingletonClass) sc2.clone();
		print("sc4" , sc4);
	}
}
