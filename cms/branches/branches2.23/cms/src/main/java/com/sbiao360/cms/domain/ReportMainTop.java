package com.sbiao360.cms.domain;

/**
 * 行业报告的实体类
 * 
 * @author yujunwei
 */
public class ReportMainTop {

	private Long id;

	private String reportInduxtry;

	private String reportTitle;

	private String reportAbstract;

	private String subReportTitle;

	private String subReportAbstract;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReportInduxtry() {
		return reportInduxtry;
	}

	public void setReportInduxtry(String reportInduxtry) {
		this.reportInduxtry = reportInduxtry;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReportAbstract() {
		return reportAbstract;
	}

	public void setReportAbstract(String reportAbstract) {
		this.reportAbstract = reportAbstract;
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

}