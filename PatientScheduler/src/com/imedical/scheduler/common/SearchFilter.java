package com.imedical.scheduler.common;

import java.io.Serializable;

public class SearchFilter implements Serializable {

	private final String term;
	private final Object propertyId;
	private String searchName;

	public SearchFilter(Object propertyId, String searchTerm, String name) {
		this.term = searchTerm;
		this.propertyId = propertyId;
		this.searchName = name;
	}

	public String getTerm() {
		return term;
	}

	public Object getPropertyId() {
		return propertyId;
	}

	public String getSearchName() {
		return searchName;
	}
	
	@Override
	public String toString() {
		
		return getSearchName();
	}
}
