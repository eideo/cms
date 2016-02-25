package com.sbiao360.cms.domain;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class IndexInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 749412125768454083L;
	
	@Field
	private String id;
	
	@Field
	private String last_modify;
	
	private String tableName;
	
	private String tableName2;
	
	@Field
	private String cust_id;
	
	@Field
	private String cust_name;
	
	@Field
	private String no;
	
	@Field
	private String title;
	
	@Field
	private String key_word;
	
	@Field
	private String publishDate;
	
	@Field
	private String publish_end_date;
	
	@Field
	private String 	category;
	
	@Field
	private String 	category_id;
	
	@Field
	private String 	classa_id;
	
	@Field
	private String 	classa_name;
	
	@Field
	private String 	classb_id;
	
	@Field
	private String 	classb_name;
	
	@Field
	private String 	classc_id;
	
	@Field
	private String 	classc_name;
	
	@Field
	private String 	classd_id;
	
	@Field
	private String 	classd_name;
	
	@Field
	private String 	inta;
	
	@Field
	private String 	intb;
	
	@Field
	private String 	intc;
	
	@Field
	private String 	intd;
	
	@Field
	private String 	numa;
	
	@Field
	private String 	numb;
	
	@Field
	private String 	numc;
	
	@Field
	private String 	numd;
	
	@Field
	private String 	area_id;
	
	private String 	areaName;
	
	private String projectName;
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName2() {
		return tableName2;
	}

	public void setTableName2(String tableName2) {
		this.tableName2 = tableName2;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Field
	private String 	topic_id;
	
	@Field
	private String 	topic_name;
	
	private String type;
	
	private String infoType;
	
	private int clickCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLast_modify() {
		return last_modify;
	}

	public void setLast_modify(String last_modify) {
		this.last_modify = last_modify;
	}


	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey_word() {
		return key_word;
	}

	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}


	public String getPublish_end_date() {
		return publish_end_date;
	}

	public void setPublish_end_date(String publish_end_date) {
		this.publish_end_date = publish_end_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getClassa_id() {
		return classa_id;
	}

	public void setClassa_id(String classa_id) {
		this.classa_id = classa_id;
	}

	public String getClassa_name() {
		return classa_name;
	}

	public void setClassa_name(String classa_name) {
		this.classa_name = classa_name;
	}

	public String getClassb_id() {
		return classb_id;
	}

	public void setClassb_id(String classb_id) {
		this.classb_id = classb_id;
	}

	public String getClassb_name() {
		return classb_name;
	}

	public void setClassb_name(String classb_name) {
		this.classb_name = classb_name;
	}

	public String getClassc_id() {
		return classc_id;
	}

	public void setClassc_id(String classc_id) {
		this.classc_id = classc_id;
	}

	public String getClassc_name() {
		return classc_name;
	}

	public void setClassc_name(String classc_name) {
		this.classc_name = classc_name;
	}

	public String getClassd_id() {
		return classd_id;
	}

	public void setClassd_id(String classd_id) {
		this.classd_id = classd_id;
	}

	public String getClassd_name() {
		return classd_name;
	}

	public void setClassd_name(String classd_name) {
		this.classd_name = classd_name;
	}

	public String getInta() {
		return inta;
	}

	public void setInta(String inta) {
		this.inta = inta;
	}

	public String getIntb() {
		return intb;
	}

	public void setIntb(String intb) {
		this.intb = intb;
	}

	public String getIntc() {
		return intc;
	}

	public void setIntc(String intc) {
		this.intc = intc;
	}

	public String getIntd() {
		return intd;
	}

	public void setIntd(String intd) {
		this.intd = intd;
	}

	public String getNuma() {
		return numa;
	}

	public void setNuma(String numa) {
		this.numa = numa;
	}

	public String getNumb() {
		return numb;
	}

	public void setNumb(String numb) {
		this.numb = numb;
	}

	public String getNumc() {
		return numc;
	}

	public void setNumc(String numc) {
		this.numc = numc;
	}

	public String getNumd() {
		return numd;
	}

	public void setNumd(String numd) {
		this.numd = numd;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}


	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCheap_policy() {
		return cheap_policy;
	}

	public void setCheap_policy(String cheap_policy) {
		this.cheap_policy = cheap_policy;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Field
	private String 	description;
	
	@Field
	private String 	cheap_policy;
	
}
