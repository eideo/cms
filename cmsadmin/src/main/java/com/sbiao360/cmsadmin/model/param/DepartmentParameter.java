package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 部门的参数类
 * 
 * @author yujunwei
 */
public class DepartmentParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015111014220652593L;

	private String parentDeptName;

	private String createDateCn;

	private String createUser;

	private String eqDeptKey;

	private String likeDeptName;

	public String getParentDeptName() {
		return parentDeptName;
	}

	public void setParentDeptName(String parentDeptName) {
		this.parentDeptName = parentDeptName;
	}

	public String getCreateDateCn() {
		return createDateCn;
	}

	public void setCreateDateCn(String createDateCn) {
		this.createDateCn = createDateCn;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getEqDeptKey() {
		return eqDeptKey;
	}

	public void setEqDeptKey(String eqDeptKey) {
		this.eqDeptKey = eqDeptKey;
	}

	public String getLikeDeptName() {
		return likeDeptName;
	}

	public void setLikeDeptName(String likeDeptName) {
		this.likeDeptName = likeDeptName;
	}

}
