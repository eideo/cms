package com.sbiao360.cmsadmin.app.bean;

/**
 * APP接口的实体Bean的请求端的父类
 * 
 * @author yujunwei
 */
public class BaseRequestBean {

	private String actionCode; // Key（唯一）

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

}
