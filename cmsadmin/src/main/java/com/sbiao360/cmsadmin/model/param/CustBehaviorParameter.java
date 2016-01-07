package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 用户行为的参数类
 * 
 * @author yujunwei
 */
public class CustBehaviorParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015110608275882296L;

	private String likeLoginId;

	private String likeCustName;

	private String actionTypeCn;

	private String infoValidCn;

	private String shareTypeCn;

	private String clickTypeCn;

	private String actionDateCn;

	public String getLikeLoginId() {
		return likeLoginId;
	}

	public void setLikeLoginId(String likeLoginId) {
		this.likeLoginId = likeLoginId;
	}

	public String getLikeCustName() {
		return likeCustName;
	}

	public void setLikeCustName(String likeCustName) {
		this.likeCustName = likeCustName;
	}

	public String getActionTypeCn() {
		return actionTypeCn;
	}

	public void setActionTypeCn(String actionTypeCn) {
		this.actionTypeCn = actionTypeCn;
	}

	public String getInfoValidCn() {
		return infoValidCn;
	}

	public void setInfoValidCn(String infoValidCn) {
		this.infoValidCn = infoValidCn;
	}

	public String getShareTypeCn() {
		return shareTypeCn;
	}

	public void setShareTypeCn(String shareTypeCn) {
		this.shareTypeCn = shareTypeCn;
	}

	public String getClickTypeCn() {
		return clickTypeCn;
	}

	public void setClickTypeCn(String clickTypeCn) {
		this.clickTypeCn = clickTypeCn;
	}

	public String getActionDateCn() {
		return actionDateCn;
	}

	public void setActionDateCn(String actionDateCn) {
		this.actionDateCn = actionDateCn;
	}

}
