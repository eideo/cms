package com.sbiao360.cmsadmin.model;

import com.sbiao360.cmsadmin.model.param.CustBrowseUrlParameter;

/**
 * 用户浏览轨迹的实体类
 * 
 * @author yujunwei
 */
public class CustBrowseUrl extends CustBrowseUrlParameter {

	private static final long serialVersionUID = 2015111311313438106L;

	private String ip;

	private String accesstime;

	private String urlConsumetime;

	private String objectKey = "CustBrowseUrl";

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAccesstime() {
		return accesstime;
	}

	public void setAccesstime(String accesstime) {
		this.accesstime = accesstime;
	}

	public String getUrlConsumetime() {
		return urlConsumetime;
	}

	public void setUrlConsumetime(String urlConsumetime) {
		this.urlConsumetime = urlConsumetime;
	}

	public String getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

}
