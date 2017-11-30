/*
* Copyright (c) 2017, Ritesh. All rights reserved.
*
*/
package com.java.exercise.searchengine.keywordbased;

import java.util.List;

/**
 * DESCRIPTION - Represents SearchResult bean.
 * 
 * @author - Ritesh Bangal
 * @version 1.0
 * @since <30-November-2017>
 */
public class SearchResult {

	private String pageName;
	private List<Keyword> pageKeywords;
	private List<Keyword> searchKeywords;
	private int streangth;
	
	@Override
	public String toString() {
		return "SearchResult: {pageName=" + pageName + ", pageKeywords=" + pageKeywords 
				+ ", searchKeywords=" + searchKeywords + ", streangth=" + streangth + "}"; 
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<Keyword> getPageKeywords() {
		return this.pageKeywords;
	}

	public void setPageKeywords(List<Keyword> pageKeywords) {
		this.pageKeywords = pageKeywords;
	}

	public List<Keyword> getSearchKeywords() {
		return this.searchKeywords;
	}

	public void setSearchKeywords(List<Keyword> searchKeywords) {
		this.searchKeywords = searchKeywords;
	}

	public int getStreangth() {
		return this.streangth;
	}

	public void setStreangth(int streangth) {
		this.streangth = streangth;
	}
}
