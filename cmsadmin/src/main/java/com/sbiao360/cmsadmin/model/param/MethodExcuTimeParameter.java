package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 服务方法执行时间的参数类
 * 
 * @author yujunwei
 */
public class MethodExcuTimeParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015111014222822073L;

	private String likeExecMethod;

	private Long geExecTime;

	private String insertDateCn;

	public String getLikeExecMethod() {
		return likeExecMethod;
	}

	public void setLikeExecMethod(String likeExecMethod) {
		this.likeExecMethod = likeExecMethod;
	}

	public Long getGeExecTime() {
		return geExecTime;
	}

	public void setGeExecTime(Long geExecTime) {
		this.geExecTime = geExecTime;
	}

	public String getInsertDateCn() {
		return insertDateCn;
	}

	public void setInsertDateCn(String insertDateCn) {
		this.insertDateCn = insertDateCn;
	}

}
