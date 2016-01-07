package com.sbiao360.cmsadmin.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.DepartmentParameter;

/**
 * 部门的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Department extends DepartmentParameter {

	private static final long serialVersionUID = 2015102015305549934L;

	private Long id;

	private String companyName;

	private String deptKey;

	private String deptName;

	private String parentDeptKey;

	private Date createDate;

	private Long createUserId;

	private String note;

	public Department() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDeptKey() {
		return deptKey;
	}

	public void setDeptKey(String deptKey) {
		this.deptKey = deptKey;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getParentDeptKey() {
		return parentDeptKey;
	}

	public void setParentDeptKey(String parentDeptKey) {
		this.parentDeptKey = parentDeptKey;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Department other = (Department) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.companyName, other.companyName)
				&& Objects.equal(this.deptKey, other.deptKey)
				&& Objects.equal(this.deptName, other.deptName)
				&& Objects.equal(this.parentDeptKey, other.parentDeptKey)
				&& Objects.equal(this.createDate, other.createDate)
				&& Objects.equal(this.createUserId, other.createUserId)
				&& Objects.equal(this.note, other.note);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.companyName, this.deptKey,
				this.deptName, this.parentDeptKey, this.createDate,
				this.createUserId, this.note);
	}
}
