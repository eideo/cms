package com.sbiao360.cmsadmin.model;

import com.sbiao360.cmsadmin.model.param.CustBehaviorParameter;

/**
 * 状态监控的实体类
 * 
 * @author yujunwei
 */
public class SysStatusMonitor extends CustBehaviorParameter {

	private static final long serialVersionUID = 2015111311280660970L;

	private String ip;

	private String accesstime;

	private String url;

	private String statuscode;

	private String objectKey = "SysStatusMonitor";

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

}
