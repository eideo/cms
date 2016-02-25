package com.sbiao360.cms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 行业报告的实体类
 * 
 * @author yujunwei
 */
public class ReportMain {

	private Long id;

	private String reportName;

	private String reportUrl;

	private String reportImage;

	private BigDecimal reportPrice;

	private BigDecimal reportTprice;

	private String reportInduxtry;

	private Integer reportPages;

	private Integer reportWords;

	private Integer reportAttentions;

	private Integer reportHits;

	private Integer reportSales;

	private Long createUserId;

	private Date createTime;

	private Long updateUserId;

	private Date updateTime;

	private Byte reportHisFlag;

	private Byte reportOnlineFlag;

	private String reportTag;

	private String reportTitle;

	private String reportAbstract;

	private String reportHisFlagCn;

	private String reportOnlineFlagCn;

	private String createTimeCn;

	private String updateTimeCn;

	public String updateDate;

	private String induxtryName;

	private String subReportTitle;

	private String subReportAbstract;

	private Byte isCarousel;

	private String imageIndex;

	private List<ReportDirectory> reportDirectoryList = new ArrayList<ReportDirectory>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName == null ? null : reportName.trim();
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl == null ? null : reportUrl.trim();
	}

	public String getReportImage() {
		return reportImage;
	}

	public void setReportImage(String reportImage) {
		this.reportImage = reportImage == null ? null : reportImage.trim();
	}

	public BigDecimal getReportPrice() {
		return reportPrice;
	}

	public void setReportPrice(BigDecimal reportPrice) {
		this.reportPrice = reportPrice;
	}

	public BigDecimal getReportTprice() {
		return reportTprice;
	}

	public void setReportTprice(BigDecimal reportTprice) {
		this.reportTprice = reportTprice;
	}

	public String getReportInduxtry() {
		return reportInduxtry;
	}

	public void setReportInduxtry(String reportInduxtry) {
		this.reportInduxtry = reportInduxtry == null ? null : reportInduxtry
				.trim();
	}

	public Integer getReportPages() {
		return reportPages;
	}

	public void setReportPages(Integer reportPages) {
		this.reportPages = reportPages;
	}

	public Integer getReportWords() {
		return reportWords;
	}

	public void setReportWords(Integer reportWords) {
		this.reportWords = reportWords;
	}

	public Integer getReportAttentions() {
		return reportAttentions;
	}

	public void setReportAttentions(Integer reportAttentions) {
		this.reportAttentions = reportAttentions;
	}

	public Integer getReportHits() {
		return reportHits;
	}

	public void setReportHits(Integer reportHits) {
		this.reportHits = reportHits;
	}

	public Integer getReportSales() {
		return reportSales;
	}

	public void setReportSales(Integer reportSales) {
		this.reportSales = reportSales;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Byte getReportHisFlag() {
		return reportHisFlag;
	}

	public void setReportHisFlag(Byte reportHisFlag) {
		this.reportHisFlag = reportHisFlag;
	}

	public Byte getReportOnlineFlag() {
		return reportOnlineFlag;
	}

	public void setReportOnlineFlag(Byte reportOnlineFlag) {
		this.reportOnlineFlag = reportOnlineFlag;
	}

	public String getReportTag() {
		return reportTag;
	}

	public void setReportTag(String reportTag) {
		this.reportTag = reportTag == null ? null : reportTag.trim();
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle == null ? null : reportTitle.trim();
	}

	public String getReportAbstract() {
		return reportAbstract;
	}

	public void setReportAbstract(String reportAbstract) {
		this.reportAbstract = reportAbstract == null ? null : reportAbstract
				.trim();
	}

	public String getReportHisFlagCn() {
		return reportHisFlagCn;
	}

	public void setReportHisFlagCn(String reportHisFlagCn) {
		this.reportHisFlagCn = reportHisFlagCn;
	}

	public String getReportOnlineFlagCn() {
		return reportOnlineFlagCn;
	}

	public void setReportOnlineFlagCn(String reportOnlineFlagCn) {
		this.reportOnlineFlagCn = reportOnlineFlagCn;
	}

	public String getCreateTimeCn() {
		return createTimeCn;
	}

	public void setCreateTimeCn(String createTimeCn) {
		this.createTimeCn = createTimeCn;
	}

	public String getUpdateTimeCn() {
		return updateTimeCn;
	}

	public void setUpdateTimeCn(String updateTimeCn) {
		this.updateTimeCn = updateTimeCn;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getInduxtryName() {
		return induxtryName;
	}

	public void setInduxtryName(String induxtryName) {
		this.induxtryName = induxtryName;
	}

	public String getSubReportTitle() {
		return subReportTitle;
	}

	public void setSubReportTitle(String subReportTitle) {
		this.subReportTitle = subReportTitle;
	}

	public String getSubReportAbstract() {
		return subReportAbstract;
	}

	public void setSubReportAbstract(String subReportAbstract) {
		this.subReportAbstract = subReportAbstract;
	}

	public Byte getIsCarousel() {
		return isCarousel;
	}

	public void setIsCarousel(Byte isCarousel) {
		this.isCarousel = isCarousel;
	}

	public String getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(String imageIndex) {
		this.imageIndex = imageIndex;
	}

	public List<ReportDirectory> getReportDirectoryList() {
		return reportDirectoryList;
	}

	public void setReportDirectoryList(List<ReportDirectory> reportDirectoryList) {
		this.reportDirectoryList = reportDirectoryList;
	}

}