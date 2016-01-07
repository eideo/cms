package com.sbiao360.cmsadmin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.ReportMainDao;
import com.sbiao360.cmsadmin.model.ReportInduxtry;
import com.sbiao360.cmsadmin.model.ReportMain;

/**
 * 行业报告的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class ReportMainService {

	@Resource
	private ReportMainDao reportMainDao;

	public int save(ReportMain reportMain) {
		return this.reportMainDao.save(reportMain);
	}

	public int update(ReportMain reportMain) {
		return this.reportMainDao.update(reportMain);
	}

	public int updateEdit(ReportMain reportMain) {
		return this.reportMainDao.updateEdit(reportMain);
	}

	public ReportMain getByPrimaryKey(Long id) {
		return this.reportMainDao.getByPrimaryKey(id);
	}

	public Long getCount(ReportMain reportMain) {
		return this.reportMainDao.getCount(reportMain);
	}

	public List<ReportMain> getList(ReportMain reportMain) {
		return this.reportMainDao.getList(reportMain);
	}

	public int delete(Long[] ids) {
		return this.reportMainDao.delete(ids);
	}

	public int delete(Long id) {
		return this.reportMainDao.deleteByPrimaryKey(id);
	}

	public List<ReportInduxtry> getReportInduxtrySelectList() {
		return this.reportMainDao.getReportInduxtrySelectList();
	}

}
