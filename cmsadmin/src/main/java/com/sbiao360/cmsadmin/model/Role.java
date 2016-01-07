package com.sbiao360.cmsadmin.model;

import java.util.Date;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.RoleParameter;

/**
 * 角色的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Role extends RoleParameter {

	private static final long serialVersionUID = 2015102210351438894L;

	private Long id;

	private String roleKey;

	private String roleName;

	private String parentRoleKey;

	private Short status;

	private Date createDate;

	private Long createUserId;

	private Date updateDate;

	private Long updateUserId;

	private String note;

	private Set<String> permissions;

	public Role() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getParentRoleKey() {
		return parentRoleKey;
	}

	public void setParentRoleKey(String parentRoleKey) {
		this.parentRoleKey = parentRoleKey;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Role other = (Role) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.roleKey, other.roleKey)
				&& Objects.equal(this.roleName, other.roleName)
				&& Objects.equal(this.status, other.status)
				&& Objects.equal(this.createDate, other.createDate)
				&& Objects.equal(this.createUserId, other.createUserId)
				&& Objects.equal(this.updateDate, other.updateDate)
				&& Objects.equal(this.updateUserId, other.updateUserId)
				&& Objects.equal(this.note, other.note)
				&& Objects.equal(this.permissions, other.permissions);
	}

	public int hashCode() {
		return Objects
				.hashCode(this.id, this.roleKey, this.roleName, this.status,
						this.createDate, this.createUserId, this.updateDate,
						this.updateUserId, this.note, this.permissions);
	}

}
