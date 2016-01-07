package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 角色的参数类
 * 
 * @author yujunwei
 */
public class RoleParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015111014231050044L;

	private String statusCn;

	private String createDateCn;

	private String updateDateCn;

	private String createUser;

	private String updateUser;

	private String eqRoleKey;

	private String likeRoleName;

	public String getStatusCn() {
		return statusCn;
	}

	public void setStatusCn(String statusCn) {
		this.statusCn = statusCn;
	}

	public String getCreateDateCn() {
		return createDateCn;
	}

	public void setCreateDateCn(String createDateCn) {
		this.createDateCn = createDateCn;
	}

	public String getUpdateDateCn() {
		return updateDateCn;
	}

	public void setUpdateDateCn(String updateDateCn) {
		this.updateDateCn = updateDateCn;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getEqRoleKey() {
		return eqRoleKey;
	}

	public void setEqRoleKey(String eqRoleKey) {
		this.eqRoleKey = eqRoleKey;
	}

	public String getLikeRoleName() {
		return likeRoleName;
	}

	public void setLikeRoleName(String likeRoleName) {
		this.likeRoleName = likeRoleName;
	}

}
