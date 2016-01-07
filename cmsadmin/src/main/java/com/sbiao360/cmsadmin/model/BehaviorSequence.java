package com.sbiao360.cmsadmin.model;

import com.sbiao360.cmsadmin.model.param.BehaviorSequenceParameter;

/**
 * 行为序列的实体类
 * 
 * @author yujunwei
 */
public class BehaviorSequence extends BehaviorSequenceParameter {

	private static final long serialVersionUID = 2015111311220135581L;

	private String userId;

	private String sessionId;

	private String actionTime;

	private String actionsequence;

	private String objectKey = "BehaviorSequence";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getActionsequence() {
		return actionsequence;
	}

	public void setActionsequence(String actionsequence) {
		this.actionsequence = actionsequence;
	}

	public String getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

}
