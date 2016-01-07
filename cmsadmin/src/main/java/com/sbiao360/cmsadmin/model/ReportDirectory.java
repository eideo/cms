package com.sbiao360.cmsadmin.model;

/**
 * 行业报告目录的实体类
 * 
 * @author yujunwei
 */
public class ReportDirectory {

	private Long id;

	private Long reportId;

	private Integer dirIndex;

	private Integer dirHierachy;

	private Long dirParentId;

	private String dirConext;

	private Integer dirPage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	public Integer getDirIndex() {
		return dirIndex;
	}

	public void setDirIndex(Integer dirIndex) {
		this.dirIndex = dirIndex;
	}

	public Integer getDirHierachy() {
		return dirHierachy;
	}

	public void setDirHierachy(Integer dirHierachy) {
		this.dirHierachy = dirHierachy;
	}

	public Long getDirParentId() {
		return dirParentId;
	}

	public void setDirParentId(Long dirParentId) {
		this.dirParentId = dirParentId;
	}

	public String getDirConext() {
		return dirConext;
	}

	public void setDirConext(String dirConext) {
		this.dirConext = dirConext == null ? null : dirConext.trim();
	}

	public Integer getDirPage() {
		return dirPage;
	}

	public void setDirPage(Integer dirPage) {
		this.dirPage = dirPage;
	}
}