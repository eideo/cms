package com.sbiao360.cms.domain;

/**
 * 个人中心用户行为实体类
 * 
 * @author yujunwei
 */
public class PersonalCustBehavior {

	private Long id;

	private Long userId;

	private Short actionType;

	private String infoType;

	private Long infoId;

	private String infoName;

	private Short infoValid;

	private String actionDateCn;

	private String introduction;

	private String subInfoName;

	private String infoTypeCn;

	private String subIntroduction;

	private Short enabledFlag;

	private String styleClassLi;

	private String styleClassBorder;

	private String styleClassCheck;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Short getActionType() {
		return actionType;
	}

	public void setActionType(Short actionType) {
		this.actionType = actionType;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public Short getInfoValid() {
		return infoValid;
	}

	public void setInfoValid(Short infoValid) {
		this.infoValid = infoValid;
	}

	public String getActionDateCn() {
		return actionDateCn;
	}

	public void setActionDateCn(String actionDateCn) {
		this.actionDateCn = actionDateCn;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSubInfoName() {
		return subInfoName;
	}

	public void setSubInfoName(String subInfoName) {
		this.subInfoName = subInfoName;
	}

	public String getInfoTypeCn() {
		return infoTypeCn;
	}

	public void setInfoTypeCn(String infoTypeCn) {
		this.infoTypeCn = infoTypeCn;
	}

	public String getSubIntroduction() {
		return subIntroduction;
	}

	public void setSubIntroduction(String subIntroduction) {
		this.subIntroduction = subIntroduction;
	}

	public Short getEnabledFlag() {
		return enabledFlag;
	}

	public void setEnabledFlag(Short enabledFlag) {
		this.enabledFlag = enabledFlag;
	}

	public String getStyleClassLi() {
		return styleClassLi;
	}

	public void setStyleClassLi(String styleClassLi) {
		this.styleClassLi = styleClassLi;
	}

	public String getStyleClassBorder() {
		return styleClassBorder;
	}

	public void setStyleClassBorder(String styleClassBorder) {
		this.styleClassBorder = styleClassBorder;
	}

	public String getStyleClassCheck() {
		return styleClassCheck;
	}

	public void setStyleClassCheck(String styleClassCheck) {
		this.styleClassCheck = styleClassCheck;
	}

}