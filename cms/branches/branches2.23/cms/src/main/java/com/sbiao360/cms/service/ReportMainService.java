package com.sbiao360.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.ReportMainDao;
import com.sbiao360.cms.domain.ReportInduxtry;
import com.sbiao360.cms.domain.ReportMain;
import com.sbiao360.cms.domain.ReportMainTop;

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

	public int updateReportHits(ReportMain reportMain) {
		return this.reportMainDao.updateReportHits(reportMain);
	}

	public int updateReportAttentions(Map<String, Object> paraMap) {
		return this.reportMainDao.updateReportAttentions(paraMap);
	}

	public ReportMain getByPrimaryKey(Long id) {
		return this.reportMainDao.getByPrimaryKey(id);
	}

	public int getCount(ReportMain reportMain) {
		return this.reportMainDao.getCount(reportMain);
	}

	public List<ReportMain> getList(int pageNum, int pageSize,
			ReportMain reportMain) {
		return this.reportMainDao.getList(pageNum, pageSize, reportMain);
	}

	public int getCountSearch(ReportMain reportMain) {
		return this.reportMainDao.getCountSearch(reportMain);
	}

	public List<ReportMain> getListSearch(int pageNum, int pageSize,
			ReportMain reportMain) {
		return this.reportMainDao.getListSearch(pageNum, pageSize, reportMain);
	}

	public List<ReportMain> getListTop10() {
		return this.reportMainDao.getListTop10();
	}

	public List<String> getListSuggest(Map<String, Object> paraMap) {
		return this.reportMainDao.getListSuggest(paraMap);
	}

	public List<ReportMainTop> getListTop5(ReportMainTop reportMainTop) {
		return this.reportMainDao.getListTop5(reportMainTop);
	}

	public List<ReportMainTop> getListTop5Default(Map<String, Object> paraMap) {
		return this.reportMainDao.getListTop5Default(paraMap);
	}

	public List<ReportMain> getListCarousel() {
		return this.reportMainDao.getListCarousel();
	}

	public int delete(Long[] ids) {
		return this.reportMainDao.delete(ids);
	}

	public int delete(Long id) {
		return this.reportMainDao.deleteByPrimaryKey(id);
	}

	public List<ReportInduxtry> getReportInduxtryList() {
		return this.reportMainDao.getReportInduxtryList();
	}

}
