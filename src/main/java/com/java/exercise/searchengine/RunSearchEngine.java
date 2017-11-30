/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine;

import java.util.ArrayList;
import java.util.List;

import com.java.exercise.searchengine.parser.InputParser;

/**
 * DESCRIPTION - This class is responsible to test Lengaburu Traffic problem 1.
 * 
 * A group of web pages has been classified by associating a list of keywords, given in decreasing order of relevance. 
 * With each page (i.e., the order of keywords is from the most specific keyword to the least specific). 
 * Queries also include a list of keywords, again from most to least relevant. 
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <30-November-2017>
 */
public class RunSearchEngine {

	public static void main(String[] args) {
		
		List<String> inputs = new ArrayList<>();
		inputs.add("P Ford Car Review");
		inputs.add("P Review Car");
		inputs.add("P Review Ford");
		inputs.add("P Toyota Car");
		inputs.add("P Honda Car");
		inputs.add("P Car");
		inputs.add("Q Ford");
		inputs.add("Q Car");
		inputs.add("Q Review");
		inputs.add("Q Ford Review");
		inputs.add("Q Ford Car");
		inputs.add("Q cooking French");
		
		InputParser.parseAndSearch(inputs);
	}
}
