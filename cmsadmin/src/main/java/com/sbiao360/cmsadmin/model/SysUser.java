package com.sbiao360.cmsadmin.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.SysUserParameter;

/**
 * 用户的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class SysUser extends SysUserParameter {

	private static final long serialVersionUID = 2015102110090460928L;

	private Long id;

	private String loginId;

	private String custName;

	private String sex;

	private Short isAdmin;

	private Short belong;

	private String mobilePhone;

	private String custEmail;

	private String custStatus;

	private Date custBirthday;

	private Date lastLoginTime;

	private String loginPasswd;

	private Date registerDate;

	private Long deptId;

	private Role role;

	public SysUser() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Short getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Short isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Short getBelong() {
		return belong;
	}

	public void setBelong(Short belong) {
		this.belong = belong;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public Date getCustBirthday() {
		return custBirthday;
	}

	public void setCustBirthday(Date custBirthday) {
		this.custBirthday = custBirthday;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginPasswd() {
		return loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SysUser other = (SysUser) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.loginId, other.loginId)
				&& Objects.equal(this.custName, other.custName)
				&& Objects.equal(this.sex, other.sex)
				&& Objects.equal(this.isAdmin, other.isAdmin)
				&& Objects.equal(this.belong, other.belong)
				&& Objects.equal(this.mobilePhone, other.mobilePhone)
				&& Objects.equal(this.custEmail, other.custEmail)
				&& Objects.equal(this.custStatus, other.custStatus)
				&& Objects.equal(this.deptId, other.deptId)
				&& Objects.equal(this.custBirthday, other.custBirthday)
				&& Objects.equal(this.lastLoginTime, other.lastLoginTime)
				&& Objects.equal(this.loginPasswd, other.loginPasswd)
				&& Objects.equal(this.registerDate, other.registerDate)
				&& Objects.equal(this.role, other.role);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.loginId, this.custName, this.sex,
				this.isAdmin, this.belong, this.mobilePhone, this.custEmail,
				this.custStatus, this.deptId, this.custBirthday,
				this.lastLoginTime, this.loginPasswd, this.registerDate,
				this.role);
	}

}