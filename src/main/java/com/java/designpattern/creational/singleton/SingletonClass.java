/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton;

import java.io.Serializable;

/**
 * DESCRIPTION - This class is a singleton class.
 * 
 * Singleton design pattern is not as simple as you thought.
 * There are many ways you can break a singleton implementation and hence it is very hard to get right. 
 * 
 * Why hard and where it could be broken?
 * 	1.	Reflection
 * 	2. 	Serialization/Deserialization 
 * 	3.	Clone
 * 	4. 	Multi threaded access
 * 	5. 	Multiple class loader. Can't be tested. When multiple server instances are running, then this issue will occure.
 * 	6.	Garbage collection. - Automatically taken care after Java-1.2
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClass implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private static SingletonClass soloInstance; // = new SingletonClass(); // Instance creation with eager loading approach
	
	private SingletonClass() {
		// Restrict instantiation
		System.out.println("SingletonClass constructor...");
	}
	
	public static SingletonClass getInstance() {
		if (null == soloInstance) {
			// Instance creation with lazy loading approach
			soloInstance = new SingletonClass();
		}
		return soloInstance;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
