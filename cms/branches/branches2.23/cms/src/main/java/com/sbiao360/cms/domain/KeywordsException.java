package com.sbiao360.cms.domain;

import java.util.Date;

public class KeywordsException {
	
	//信息id
	private String recordId;
	
	//用户id
	private String custId;
	
	//登录名
	private String loginName;
	
	//用户名
	private String custName;
	
	//用户ip
	private Long ip;
	
	//用户查询地区
	private String areaTailId;
	
	//用户查询地区
	private String areaId;
	
	//用户查询行业
	private String industry1Id;
	
	//用户查询行业
	private String industry2Id;
	
	//关键字类型
	private String keywordsType;
	
	//关键字
	private String keywords;
	
	//查询语句
	private String sqlRecord;
	
	//查询历时
	private String queryTime;
	
	//异常时间
	private String exceptionType;

	//提交时间
	private Date confirmDate;

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
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

	public Long getIp() {
		return ip;
	}

	public void setIp(Long ip) {
		this.ip = ip;
	}

	public String getAreaTailId() {
		return areaTailId;
	}

	public void setAreaTailId(String areaTailId) {
		this.areaTailId = areaTailId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getIndustry1Id() {
		return industry1Id;
	}

	public void setIndustry1Id(String industry1Id) {
		this.industry1Id = industry1Id;
	}

	public String getIndustry2Id() {
		return industry2Id;
	}

	public void setIndustry2Id(String industry2Id) {
		this.industry2Id = industry2Id;
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

	public String getSqlRecord() {
		return sqlRecord;
	}

	public void setSqlRecord(String sqlRecord) {
		this.sqlRecord = sqlRecord;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}
	
	
}
