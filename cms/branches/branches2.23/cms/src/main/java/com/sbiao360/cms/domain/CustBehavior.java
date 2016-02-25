package com.sbiao360.cms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为实体类
 * 
 * @author yujunwei
 */
public class CustBehavior implements Serializable {

	private static final long serialVersionUID = 2015110514443580363L;

	private Long id;

	private Long userId;

	private String loginId;

	private String custId;

	private String custName;

	private Long ip;

	private Short actionType;

	private String infoType;

	private Long infoId;

	private String infoName;

	private Short infoValid;

	private Date actionDate;

	private String columnLevelOne;

	private String columnLevelTwo;

	private String url;

	private String parameter;

	private Long consumeTime;

	private String remoteAddr;

	private String keywordsType;

	private String keywords;

	private Short shareType;

	private String shareSys;

	private String shareTarget;

	private String shareMessage;

	private Short clickType;

	private String clickContent;

	private String objectKey = "CustBehavior";

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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId == null ? null : loginId.trim();
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	public Long getIp() {
		return ip;
	}

	public void setIp(Long ip) {
		this.ip = ip;
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
		this.infoType = infoType == null ? null : infoType.trim();
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
		this.infoName = infoName == null ? null : infoName.trim();
	}

	public Short getInfoValid() {
		return infoValid;
	}

	public void setInfoValid(Short infoValid) {
		this.infoValid = infoValid;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getColumnLevelOne() {
		return columnLevelOne;
	}

	public void setColumnLevelOne(String columnLevelOne) {
		this.columnLevelOne = columnLevelOne == null ? null : columnLevelOne
				.trim();
	}

	public String getColumnLevelTwo() {
		return columnLevelTwo;
	}

	public void setColumnLevelTwo(String columnLevelTwo) {
		this.columnLevelTwo = columnLevelTwo == null ? null : columnLevelTwo
				.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter == null ? null : parameter.trim();
	}

	public Long getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(Long consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
	}

	public String getKeywordsType() {
		return keywordsType;
	}

	public void setKeywordsType(String keywordsType) {
		this.keywordsType = keywordsType == null ? null : keywordsType.trim();
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords == null ? null : keywords.trim();
	}

	public Short getShareType() {
		return shareType;
	}

	public void setShareType(Short shareType) {
		this.shareType = shareType;
	}

	public String getShareSys() {
		return shareSys;
	}

	public void setShareSys(String shareSys) {
		this.shareSys = shareSys == null ? null : shareSys.trim();
	}

	public String getShareTarget() {
		return shareTarget;
	}

	public void setShareTarget(String shareTarget) {
		this.shareTarget = shareTarget == null ? null : shareTarget.trim();
	}

	public String getShareMessage() {
		return shareMessage;
	}

	public void setShareMessage(String shareMessage) {
		this.shareMessage = shareMessage == null ? null : shareMessage.trim();
	}

	public Short getClickType() {
		return clickType;
	}

	public void setClickType(Short clickType) {
		this.clickType = clickType;
	}

	public String getClickContent() {
		return clickContent;
	}

	public void setClickContent(String clickContent) {
		this.clickContent = clickContent == null ? null : clickContent.trim();
	}

	public String getObjectKey() {
		return objectKey;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

}