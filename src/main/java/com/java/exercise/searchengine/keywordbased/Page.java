/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.keywordbased;

import java.util.ArrayList;
import java.util.List;

public class Page {

	private List<Keyword> keywords;
	private List<Page> nestedPages;

	public Page() {
		
	}
	
	public Page(List<Keyword> keywords, List<Page> nestedPages) {
		super();
		if (null == nestedPages) {
			nestedPages = new ArrayList<>();
		}
		this.keywords = keywords;
		this.nestedPages = nestedPages;
	}

	@Override
	public String toString() {
		return "Page: {keywords=" + keywords + ", nestedPages=" + nestedPages + "}"; 
	}


	public List<Keyword> getKeywords() {
		return keywords;
	}


	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}


	public List<Page> getNestedPages() {
		if (null == nestedPages) {
			nestedPages = new ArrayList<>();
		}
		return nestedPages;
	}


	public void setNestedPages(List<Page> nestedPages) {
		this.nestedPages = nestedPages;
	}
	

}
