package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 行业报告的参数类
 * 
 * @author yujunwei
 */
public class ReportMainParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 2015111913402765627L;

	private String reportHisFlagCn;

	private String reportOnlineFlagCn;

	private String createTimeCn;

	private String updateTimeCn;

	private String reportInduxtryCn;

	private String likeReportName;

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

	public String getReportInduxtryCn() {
		return reportInduxtryCn;
	}

	public void setReportInduxtryCn(String reportInduxtryCn) {
		this.reportInduxtryCn = reportInduxtryCn;
	}

	public String getLikeReportName() {
		return likeReportName;
	}

	public void setLikeReportName(String likeReportName) {
		this.likeReportName = likeReportName;
	}

}
