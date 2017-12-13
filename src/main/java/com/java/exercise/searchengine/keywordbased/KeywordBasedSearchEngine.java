/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.keywordbased;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * DESCRIPTION - Determine the top five (or fewer) pages that match each of an arbitrary number of queries.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <30-November-2017>
 */
public class KeywordBasedSearchEngine {
	
	// Create an object of SingleObject
	private static KeywordBasedSearchEngine searchEngineInstance = new KeywordBasedSearchEngine();
	
	private KeywordBasedSearchEngine() {
		// Make the constructor private so that this class cannot be instantiated
	}

	// Get the only object available
	public static KeywordBasedSearchEngine getInstance(){
		return searchEngineInstance;
	}
	
	public String search(String searchQueryName, String searchText, int searchLimit, Map<String, Page> pageEntries) {
		List<SearchResult> searchResults = getSearchResults(searchText, searchLimit, pageEntries);
		// Returns output
		return searchQueryName + ": " + searchResults.stream()
				.map(SearchResult::getPageName).collect(Collectors.joining(" "));
	}

	private List<SearchResult> getSearchResults(String searchText, final int searchLimit, Map<String, Page> pageEntries) {
		List<SearchResult> searchResults = new ArrayList<>();
		KeywordQuery searchKeywordQuery = new KeywordQuery(searchText);
		pageEntries.entrySet().stream()
	     	.forEach(pageEntry -> {
	     		int strength = getRootPageStrength(searchKeywordQuery.getKeywords(), pageEntry.getValue());
	     		// Do not list pages that have no relationship (zero strength), even if fewer than five pages are identified.
	     		if (strength > 0) {
	     			SearchResult searchResult = new SearchResult();
	     			searchResult.setPageName(pageEntry.getKey());
	     			//searchResult.setPageKeywords(pageEntry.getValue());
	     			searchResult.setSearchKeywords(searchKeywordQuery.getKeywords());
	     			searchResult.setStreangth(strength);
	     			
	     			searchResults.add(searchResult);
	     		}
	     	});
		
		// Sort this searchResults based on strength
		searchResults.sort((sr1, sr2) -> Integer.compare(sr2.getStreangth(), sr1.getStreangth()));
		
		// For each query, identify the searchLimit: 5 (or fewer) pages stored that are the most relevant to the query.
		if (searchResults.size() <= searchLimit) {
			return searchResults;
		}
		return searchResults.subList(0, searchLimit);
	}

	private int getRootPageStrength(List<Keyword> searchKeywords, Page page) {
		
		List<Keyword> pageKeywords = page.getKeywords();
		AtomicInteger pageStrength = new AtomicInteger(0);
		searchKeywords.stream()
			.forEach(searchKeyword -> pageKeywords.stream()
					.forEach(pageKeyword -> {
						if (pageKeyword.getKeyText().equalsIgnoreCase(searchKeyword.getKeyText())) {
							pageStrength.set(pageStrength.get() + searchKeyword.getWeight() * pageKeyword.getWeight());
						}
					})
			);
		
		AtomicInteger nestedPageStrength = new AtomicInteger(0);
		List<Page> nestedPages = page.getNestedPages();
		nestedPages.stream()
			.forEach(nestedPage -> nestedPageStrength.getAndAdd(getRootPageStrength(searchKeywords, nestedPage)));
		return (int) (pageStrength.get() + (nestedPageStrength.get() * 0.1));
	}

	/*@SuppressWarnings("unused")
	private int getStrength(List<Keyword> searchKeywords, Page page) {
		
		List<Keyword> pageKeywords = page.getKeywords();
		AtomicInteger pageStrength = new AtomicInteger(0);
		searchKeywords.stream()
			.forEach(searchKeyword -> pageKeywords.stream()
					.forEach(pageKeyword -> {
						if (pageKeyword.getKeyText().equalsIgnoreCase(searchKeyword.getKeyText())) {
							pageStrength.set(pageStrength.get() + searchKeyword.getWeight() * pageKeyword.getWeight());
						}
					})
			);
		
		
		return pageStrength.get();
	}

	@SuppressWarnings("unused")
	private int getStrength(List<Keyword> searchKeywords, List<Keyword> pageKeywords) {
		AtomicInteger strength = new AtomicInteger(0);
		searchKeywords.stream()
			.forEach(searchKeyword -> pageKeywords.stream()
					.forEach(pageKeyword -> {
						if (pageKeyword.getKeyText().equalsIgnoreCase(searchKeyword.getKeyText())) {
							strength.set(strength.get() + searchKeyword.getWeight() * pageKeyword.getWeight());
						}
					})
			);
		return strength.get();
	}*/
}
