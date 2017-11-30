/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.keywordbased;

/**
 * DESCRIPTION - Represents an searching keywords, 
 * which holds a keyword (part of search text) and it's weight in that query.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <29-November-2017>
 */
public class Keyword {

	private String keyText;
	private int weight;

	public Keyword(String keyText, int weight) {
		super();
		this.keyText = keyText;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "Keyword: {keyText=" + keyText + ", weight=" + weight + "}"; 
	}
	
	public String getKeyText() {
		return this.keyText;
	}

	public void setKeyText(String keyText) {
		this.keyText = keyText;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
