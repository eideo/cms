package com.sbiao360.cms.domain;

import java.io.Serializable;

public class KeywordsDict implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8753145218852953165L;

	private String recordId;
	
	private String keywords;
	
	private Integer clickCount;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
}
