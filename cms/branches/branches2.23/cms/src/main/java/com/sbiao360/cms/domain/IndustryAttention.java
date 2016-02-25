package com.sbiao360.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class IndustryAttention implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6844309143065012305L;

	private Integer id;
	
	private String industry1Id;
	
	private String industry1Name;
	private String industry2Id;
	private String industry2Name;
	private String area1Id;
	private String area1Name;
	private String area2Id;
	private String area2Name;
	private Integer ipi;
	private Date dataDate;
	private Date updateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIndustry1Id() {
		return industry1Id;
	}
	public void setIndustry1Id(String industry1Id) {
		this.industry1Id = industry1Id;
	}
	public String getIndustry1Name() {
		return industry1Name;
	}
	public void setIndustry1Name(String industry1Name) {
		this.industry1Name = industry1Name;
	}
	public String getIndustry2Id() {
		return industry2Id;
	}
	public void setIndustry2Id(String industry2Id) {
		this.industry2Id = industry2Id;
	}
	public String getIndustry2Name() {
		return industry2Name;
	}
	public void setIndustry2Name(String industry2Name) {
		this.industry2Name = industry2Name;
	}
	public String getArea1Id() {
		return area1Id;
	}
	public void setArea1Id(String area1Id) {
		this.area1Id = area1Id;
	}
	public String getArea1Name() {
		return area1Name;
	}
	public void setArea1Name(String area1Name) {
		this.area1Name = area1Name;
	}
	public String getArea2Id() {
		return area2Id;
	}
	public void setArea2Id(String area2Id) {
		this.area2Id = area2Id;
	}
	public String getArea2Name() {
		return area2Name;
	}
	public void setArea2Name(String area2Name) {
		this.area2Name = area2Name;
	}
	public Integer getIpi() {
		return ipi;
	}
	public void setIpi(Integer ipi) {
		this.ipi = ipi;
	}
	public Date getDataDate() {
		return dataDate;
	}
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	

}
