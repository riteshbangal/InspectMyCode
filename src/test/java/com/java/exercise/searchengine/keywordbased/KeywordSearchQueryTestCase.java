/*
 * Copyright (c) 2017, Ritesh. All rights reserved.
 *
 */
package com.java.exercise.searchengine.keywordbased;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * DESCRIPTION - This class is responsible to test Keyword-SearchQuery.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <30-November-2017>
 */
@RunWith(JUnit4.class)
public class KeywordSearchQueryTestCase {

	private KeywordQuery keywordQuery = new KeywordQuery();

	@Before
	public void setUp() throws Exception {
		keywordQuery.setQueryText("Ferrari ,  Car");
	}

	@Test
	public void testGetKeywords() {
		List<Keyword> keywords = keywordQuery.getKeywords();
		
		assertEquals("Ferrari", keywords.get(0).getKeyText());
		assertEquals(8, keywords.get(0).getWeight());
		assertEquals("Car", keywords.get(1).getKeyText());
		assertEquals(7, keywords.get(1).getWeight());
	}
}
