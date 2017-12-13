/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.parser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.java.exercise.searchengine.SearchConstants;
import com.java.exercise.searchengine.keywordbased.KeywordBasedSearchEngine;
import com.java.exercise.searchengine.keywordbased.KeywordQuery;
import com.java.exercise.searchengine.keywordbased.Page;

/**
 * DESCRIPTION - This utility class is responsible to parse inputs into Map<String, List<Keyword>> 
 * 				 and do search with search engine.
 *
 * Note: Input data consist of one line for each web page and query.
 * 		 A line consists of a code letter followed by a list of keywords. 
 * 		 Code letters P and Q denote a page and a query. 
 * 		 Code letters and keywords are separated by at least one space. 
 * 		 Ps and Qs may occur in any order.
 * 
 * @author - Ritesh
 * @version 1.0
 * @since <30-November-2017>
 */
public class InputParser {

	public static void parseAndSearch(List<String> inputs) {

		// Create an instance of SearchEngine, which will calculate optimum time.
		KeywordBasedSearchEngine searchEngine = KeywordBasedSearchEngine.getInstance();
		
		Map<String, String> searchEntries = new LinkedHashMap<>();		
		Map<String, Page> pageEntries = new LinkedHashMap<>();

		populateSearchAndPageEntries(inputs, searchEntries, pageEntries);
		
		// For each query, identify the 5 (or fewer) pages stored that are the most relevant to the query.
		searchEntries.entrySet().stream().forEach(searchEntry -> System.out
				.println(searchEngine.search(searchEntry.getKey(), searchEntry.getValue(), 5, pageEntries)));
	}

	public static void populateSearchAndPageEntries(List<String> inputs, 
			Map<String, String> searchEntries, Map<String, Page> pageEntries) {

		AtomicInteger searchIndex = new AtomicInteger(1);
		AtomicInteger pageIndex = new AtomicInteger(1);
		AtomicInteger nestedPageIndex = new AtomicInteger(1);
		for (String input : inputs) {

			if (input.startsWith("Q")) {
				searchEntries.put("Q" + searchIndex.getAndIncrement(),
						input.replaceFirst("Q", SearchConstants.EMPTY_STRING));
			}
			if (input.startsWith("PP")) { 
				// TODO: if depth is more than 2
				Page nestedPage = new Page(
						new KeywordQuery(input.replaceFirst("PP", SearchConstants.EMPTY_STRING)).getKeywords(), null);

				Page parentPage = pageEntries.get("P" + (pageIndex.get() - 1));
				parentPage.getNestedPages().add(nestedPage);

			} else if (input.startsWith("P")) {
				Page page = new Page();
				page.setKeywords(new KeywordQuery(input.replaceFirst("P", SearchConstants.EMPTY_STRING)).getKeywords());
				nestedPageIndex.set(1);
				pageEntries.put("P" + pageIndex.getAndIncrement(), page);
			}

			

		}
	}
}
