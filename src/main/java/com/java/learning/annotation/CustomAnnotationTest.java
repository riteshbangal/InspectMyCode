package com.java.learning.annotation;

public class CustomAnnotationTest {

	public static void main(String[] args) throws Exception {

		MyAnnotationHanlder parser = new MyAnnotationHanlder();
		Person person = new Person();
		person.setName("CONCRETEPAGE");
		//person.setName("RCB");
		parser.handle(person);
	}
}
