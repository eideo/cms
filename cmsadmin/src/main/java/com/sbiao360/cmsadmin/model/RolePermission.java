package com.sbiao360.cmsadmin.model;

/**
 * 角色权限的实体类
 * 
 * @author yujunwei
 */
public class RolePermission {

	private Long roleId;

	private String permissions;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions == null ? null : permissions.trim();
	}
}