/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.designpattern.creational.singleton.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java.designpattern.creational.singleton.SingletonClass;

/**
 * DESCRIPTION - This class is responsible to test singleton class using 'Serialization/Deserialization'.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <14-September-2017>
 */
public class SingletonClassSerializationTest extends BasicTest {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		SingletonClass sc2 = SingletonClass.getInstance();
		print("sc2" , sc2);
		SingletonClass sc3 = SingletonClass.getInstance();
		print("sc3" , sc3);
		
		// Serialization and Deserialization 
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getSerializedFile()));
		outputStream.writeObject(sc2);
		
		for (int i = 0; i < 4; i++) {
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(getSerializedFile()));
			SingletonClass sc1 = (SingletonClass) inputStream.readObject();
			print("sc1" , sc1);
		}
		
		outputStream.close();
	}
}
