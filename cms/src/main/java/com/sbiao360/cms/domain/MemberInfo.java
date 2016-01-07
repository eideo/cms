package com.sbiao360.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6602927880081003414L;

	private String id;
	
	private String recordId;
	
	private String custId;
	
	private String custProvince;
	
	private String custCity;
	
	private String custBirthday;
	
	private String lostpassQuestion;
	
	private String lostpassAnswer;
	
	private String loginId;
	
	private String loginPassword;
	
	private String sex;
	
	private String companyName;
	
	private String address;
	
	private String zipcode;
	
	private String custEmail;
	
	private String phone;
	
	private String fax;
	
	private Date registerDate;
	
	private String custName;
	
	private String custStatus;
	
	private String mobilePhone;
	
	private Integer isAdmin;
	
	private Integer belong;
	
	private String deptId;
	
	private Integer userType;
	
	private String avatarPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCustProvince() {
		return custProvince;
	}

	public void setCustProvince(String custProvince) {
		this.custProvince = custProvince;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public String getCustBirthday() {
		return custBirthday;
	}

	public void setCustBirthday(String custBirthday) {
		this.custBirthday = custBirthday;
	}

	public String getLostpassQuestion() {
		return lostpassQuestion;
	}

	public void setLostpassQuestion(String lostpassQuestion) {
		this.lostpassQuestion = lostpassQuestion;
	}

	public String getLostpassAnswer() {
		return lostpassAnswer;
	}

	public void setLostpassAnswer(String lostpassAnswer) {
		this.lostpassAnswer = lostpassAnswer;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getBelong() {
		return belong;
	}

	public void setBelong(Integer belong) {
		this.belong = belong;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
}
