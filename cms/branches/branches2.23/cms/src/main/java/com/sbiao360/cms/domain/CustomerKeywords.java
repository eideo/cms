package com.sbiao360.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class CustomerKeywords  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6436743941149089190L;

	private String recordId;
	
	private Integer custId;
	
	private String loginName;
	
	private String custName;
	
	private String keywordsType;
	
	private String keywords;
	
	private String note;

	private Date confirmDate;
	
	private Long ip;
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getKeywordsType() {
		return keywordsType;
	}
	public void setKeywordsType(String keywordsType) {
		this.keywordsType = keywordsType;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	public Long getIp() {
		return ip;
	}
	public void setIp(Long ip) {
		this.ip = ip;
	}
	
	
	
}
