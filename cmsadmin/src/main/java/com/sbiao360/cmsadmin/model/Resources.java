package com.sbiao360.cmsadmin.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.ResourcesParameter;

/**
 * 资源的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Resources extends ResourcesParameter {

	private static final long serialVersionUID = 2015102210092278031L;

	private Long id;

	private String resourceUrl;

	private String resourceClass;

	private String resourceCode;

	private String resourceName;

	private String parentResourceCode;

	private Integer sequence;

	private Short resourceType;

	private Short status;

	private String operAuthority;

	public Resources() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getResourceClass() {
		return resourceClass;
	}

	public void setResourceClass(String resourceClass) {
		this.resourceClass = resourceClass;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getParentResourceCode() {
		return parentResourceCode;
	}

	public void setParentResourceCode(String parentResourceCode) {
		this.parentResourceCode = parentResourceCode;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Short getResourceType() {
		return resourceType;
	}

	public void setResourceType(Short resourceType) {
		this.resourceType = resourceType;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getOperAuthority() {
		return operAuthority;
	}

	public void setOperAuthority(String operAuthority) {
		this.operAuthority = operAuthority;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Resources other = (Resources) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.resourceUrl, other.resourceUrl)
				&& Objects.equal(this.resourceClass, other.resourceClass)
				&& Objects.equal(this.resourceCode, other.resourceCode)
				&& Objects.equal(this.resourceName, other.resourceName)
				&& Objects.equal(this.parentResourceCode,
						other.parentResourceCode)
				&& Objects.equal(this.sequence, other.sequence)
				&& Objects.equal(this.resourceType, other.resourceType)
				&& Objects.equal(this.status, other.status)
				&& Objects.equal(this.operAuthority, other.operAuthority);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.resourceUrl, this.resourceClass,
				this.resourceCode, this.resourceName, this.parentResourceCode,
				this.sequence, this.resourceType, this.status,
				this.operAuthority);
	}

}
