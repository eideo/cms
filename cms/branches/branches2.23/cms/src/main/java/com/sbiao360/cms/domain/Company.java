package com.sbiao360.cms.domain;

import java.io.Serializable;

public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5760710952479819058L;
	private String id;
	private String companyName;
	private String companyAlias;
	private String address;
	private String zipcode;
	private String phone;
	private String fax;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAlias() {
		return companyAlias;
	}
	public void setCompanyAlias(String companyAlias) {
		this.companyAlias = companyAlias;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
}
