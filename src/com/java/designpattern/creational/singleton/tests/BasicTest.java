/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import java.io.File;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is super class for all singleton classes.
 * 
 * Singleton design pattern is not as simple as you thought.
 * There are many ways you can break a singleton implementation and hence it is very hard to get right. 
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class BasicTest {

	protected static void print(String pName, SingletonClass pSingletonObject) {
		System.out.println(String.format("Object: %s, Hashcode: %d", pName, pSingletonObject.hashCode()));
	}
	
	protected static File getSerializedFile() {
		String projectPath = System.getProperty("user.dir");
		// Create file
		File file = new File(projectPath + "/resources/singleton.ser");
		return file;
	}
}
