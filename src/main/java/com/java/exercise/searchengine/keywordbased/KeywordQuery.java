/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.keywordbased;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.java.exercise.searchengine.SearchConstants;

/**
 * DESCRIPTION - This is responsible to generates keywords (Keyword: text and weight) from a simple input text.
 * 
 * Note: Assuming the keywords for each query are assigned integer weights, in descending order. 
 * 		 It's starting with N, where N is the maximum number of keywords allowed for a web page and query.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <30-November-2017>
 */
public class KeywordQuery {
	
	public static final int DEFAULT_STARTING_WEIGHT = 8;
	
	private String queryText;
	
	public KeywordQuery() {
		super();
	}

	public KeywordQuery(String queryText) {
		super();
		this.queryText = queryText;
	}

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public List<Keyword> getKeywords() {
		AtomicInteger startingWeight = new AtomicInteger(DEFAULT_STARTING_WEIGHT);
		return Arrays.asList(queryText.trim().split(SearchConstants.KEYWORD_SPLITTER_REGEX)).stream()
			.map(literal -> {
				int weight = startingWeight.getAndDecrement();
				return new Keyword(literal, weight);
			}).collect(toList());
	}
}
