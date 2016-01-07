package com.sbiao360.cmsadmin.model.param;

import java.util.List;

import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 资源的参数类
 * 
 * @author yujunwei
 */
public class ResourcesParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 201510221005283165L;

	private String resourceTypeCn;

	private String statusCn;

	private String eqResourceCode;

	private String likeResourceName;

	private List<Resources> subAuthorityList;

	public String getResourceTypeCn() {
		return resourceTypeCn;
	}

	public void setResourceTypeCn(String resourceTypeCn) {
		this.resourceTypeCn = resourceTypeCn;
	}

	public String getStatusCn() {
		return statusCn;
	}

	public void setStatusCn(String statusCn) {
		this.statusCn = statusCn;
	}

	public String getEqResourceCode() {
		return eqResourceCode;
	}

	public void setEqResourceCode(String eqResourceCode) {
		this.eqResourceCode = eqResourceCode;
	}

	public String getLikeResourceName() {
		return likeResourceName;
	}

	public void setLikeResourceName(String likeResourceName) {
		this.likeResourceName = likeResourceName;
	}

	public List<Resources> getSubAuthorityList() {
		return subAuthorityList;
	}

	public void setSubAuthorityList(List<Resources> subAuthorityList) {
		this.subAuthorityList = subAuthorityList;
	}

}
