package com.java.learning.annotation;

import java.lang.reflect.Field;

public class MyAnnotationHanlder {
	
	public void handle(Object ob) throws Exception {
	
		Field[] fields = ob.getClass().getFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(MyAnnotation.class)) {

				MyAnnotation myAnn = field.getAnnotation(MyAnnotation.class);
				int maxLen = myAnn.maxLength();
				System.out.println("Max length is:" + maxLen);
				if (maxLen < field.get(ob).toString().length()) {
					throw new Exception("You have eneterd string greater than max length." + maxLen);
				}
			}
		}
	}
}
