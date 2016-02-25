package com.sbiao360.cms.domain;

import java.io.Serializable;
import java.util.List;

public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7475688478964357248L;

	private String id;
	
	private String projectName;
	
	private String projectAlias;
	
	private String abroad;
	
	private String areaId;
	
	private String industryId;
	
	private String phazeId;
	
	private String facility;
	
	private Double totalInvest;
	
	private String introduction;
	
	private String projectTheme;
	
	private String projectSourceId;
	
	private String resourceDescription;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAlias() {
		return projectAlias;
	}

	public void setProjectAlias(String projectAlias) {
		this.projectAlias = projectAlias;
	}

	public String getAbroad() {
		return abroad;
	}

	public void setAbroad(String abroad) {
		this.abroad = abroad;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getPhazeId() {
		return phazeId;
	}

	public void setPhazeId(String phazeId) {
		this.phazeId = phazeId;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getProjectTheme() {
		return projectTheme;
	}

	public void setProjectTheme(String projectTheme) {
		this.projectTheme = projectTheme;
	}

	public String getProjectSourceId() {
		return projectSourceId;
	}

	public void setProjectSourceId(String projectSourceId) {
		this.projectSourceId = projectSourceId;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public Double getTotalInvest() {
		return totalInvest;
	}

	public void setTotalInvest(Double totalInvest) {
		this.totalInvest = totalInvest;
	}


	
}
