package com.sbiao360.cms.domain;

import java.io.Serializable;

public class Code implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7605598693699724304L;

	private String code;
	
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
