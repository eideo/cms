package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 用户的参数类
 * 
 * @author yujunwei
 */
public class SysUserParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015102110012182866L;

	private String sexCn;

	private String isAdminCn;

	private String belongCn;

	private String custStatusCn;

	private String custBirthdayCn;

	private String lastLoginTimeCn;

	private String registerDateCn;

	private String deptName;

	private String roleKey;

	private String roleName;

	private String filePath;

	private boolean rememberMe;

	private String likeLoginId;

	private String likeCustName;

	private String eqBelong;

	private String ticket;

	public String getSexCn() {
		return sexCn;
	}

	public void setSexCn(String sexCn) {
		this.sexCn = sexCn;
	}

	public String getIsAdminCn() {
		return isAdminCn;
	}

	public void setIsAdminCn(String isAdminCn) {
		this.isAdminCn = isAdminCn;
	}

	public String getBelongCn() {
		return belongCn;
	}

	public void setBelongCn(String belongCn) {
		this.belongCn = belongCn;
	}

	public String getCustStatusCn() {
		return custStatusCn;
	}

	public void setCustStatusCn(String custStatusCn) {
		this.custStatusCn = custStatusCn;
	}

	public String getCustBirthdayCn() {
		return custBirthdayCn;
	}

	public void setCustBirthdayCn(String custBirthdayCn) {
		this.custBirthdayCn = custBirthdayCn;
	}

	public String getLastLoginTimeCn() {
		return lastLoginTimeCn;
	}

	public void setLastLoginTimeCn(String lastLoginTimeCn) {
		this.lastLoginTimeCn = lastLoginTimeCn;
	}

	public String getRegisterDateCn() {
		return registerDateCn;
	}

	public void setRegisterDateCn(String registerDateCn) {
		this.registerDateCn = registerDateCn;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public String getLikeLoginId() {
		return likeLoginId;
	}

	public void setLikeLoginId(String likeLoginId) {
		this.likeLoginId = likeLoginId;
	}

	public String getLikeCustName() {
		return likeCustName;
	}

	public void setLikeCustName(String likeCustName) {
		this.likeCustName = likeCustName;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getEqBelong() {
		return eqBelong;
	}

	public void setEqBelong(String eqBelong) {
		this.eqBelong = eqBelong;
	}

}
