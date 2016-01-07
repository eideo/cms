package com.sbiao360.cmsadmin.model;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.RoleResourcesParameter;

/**
 * 角色资源的实体类
 * 
 * @author yujunwei
 */
public class RoleResources extends RoleResourcesParameter {

	private static final long serialVersionUID = 2015102210250044195L;

	private String roleKey;

	private String resourceCode;

	private String permissions;

	public RoleResources() {

	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final RoleResources other = (RoleResources) obj;
		return Objects.equal(this.roleKey, other.roleKey)
				&& Objects.equal(this.resourceCode, other.resourceCode)
				&& Objects.equal(this.permissions, other.permissions);
	}

	public int hashCode() {
		return Objects.hashCode(this.roleKey, this.resourceCode,
				this.permissions);
	}

}
