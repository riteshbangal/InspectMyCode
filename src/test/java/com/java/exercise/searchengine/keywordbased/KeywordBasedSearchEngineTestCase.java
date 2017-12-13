/*
 * Copyright (c) 2017, Ritesh. All rights reserved.
 *
 */
package com.java.exercise.searchengine.keywordbased;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.java.exercise.searchengine.parser.InputParser;

/**
 * DESCRIPTION - This class is responsible to test KeywordBased-SearchEngine.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <30-November-2017>
 */
@RunWith(JUnit4.class)
public class KeywordBasedSearchEngineTestCase {

	private KeywordBasedSearchEngine searchEngine = KeywordBasedSearchEngine.getInstance();

	Map<String, String> searchEntries = new LinkedHashMap<>();		
	Map<String, Page> pageEntries = new LinkedHashMap<>();
	
	List<String> inputs = new ArrayList<>();
	List<String> outputs = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
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
		
		outputs.add("Q1: P1 P3");
		outputs.add("Q2: P6 P1 P2 P4 P5");
		outputs.add("Q3: P2 P3 P1");
		outputs.add("Q4: P3 P1 P2");
		outputs.add("Q5: P1 P3 P6 P2 P4");
		outputs.add("Q6: ");
		
		InputParser.populateSearchAndPageEntries(inputs, searchEntries, pageEntries);
	}

	@Test
	public void testSearch() {
		
		AtomicInteger outputIndex = new AtomicInteger(0);
		// For each query, identify the 5 (or fewer) pages stored that are the most relevant to the query.
		searchEntries.entrySet().stream()
			.forEach(searchEntry -> {
				assertEquals(outputs.get(outputIndex.getAndIncrement()), 
						searchEngine.search(searchEntry.getKey(), searchEntry.getValue(), 5, pageEntries));
			});
	}
}
