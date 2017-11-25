/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is responsible to test singleton class using 'Reflection'.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClassReflectionTest extends BasicTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		SingletonClass sc2 = SingletonClass.getInstance();
		print("sc2" , sc2);
		SingletonClass sc3 = SingletonClass.getInstance();
		print("sc3" , sc3);
		
		// Reflection 
		Class classObject = Class.forName("com.java.designpatterns.singleton.SingletonClass");
		Constructor<SingletonClass> constructor = classObject.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingletonClass sc1 = constructor.newInstance();
		print("sc1" , sc1);
	}
}
