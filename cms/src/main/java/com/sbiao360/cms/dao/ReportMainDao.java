package com.sbiao360.cms.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cms.domain.ReportInduxtry;
import com.sbiao360.cms.domain.ReportMain;
import com.sbiao360.cms.domain.ReportMainTop;

/**
 * 行业报告的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class ReportMainDao {

	@Resource
	private BaseDao baseDao;

	public int save(ReportMain reportMain) {
		return this.baseDao.save("ReportMainMapper.insert", reportMain);
	}

	public int update(ReportMain reportMain) {
		return this.baseDao.update("ReportMainMapper.update", reportMain);
	}

	public int updateReportHits(ReportMain reportMain) {
		return this.baseDao.update("ReportMainMapper.updateReportHits",
				reportMain);
	}

	public int updateReportAttentions(Map<String, Object> paraMap) {
		return this.baseDao.update("ReportMainMapper.updateReportAttentions",
				paraMap);
	}

	public ReportMain getByPrimaryKey(Long id) {
		return this.baseDao.get("ReportMainMapper.getByPrimaryKey", id);
	}

	public int getCount(ReportMain reportMain) {
		return this.baseDao.getCount("ReportMainMapper.getCount", reportMain);
	}

	public List<ReportMain> getList(int pageNum, int pageSize,
			ReportMain reportMain) {
		PageHelper.startPage(pageNum, pageSize);
		return this.baseDao.getList("ReportMainMapper.getList", reportMain);
	}

	public int getCountSearch(ReportMain reportMain) {
		return this.baseDao.getCount("ReportMainMapper.getCountSearch",
				reportMain);
	}

	public List<ReportMain> getListSearch(int pageNum, int pageSize,
			ReportMain reportMain) {
		PageHelper.startPage(pageNum, pageSize);
		return this.baseDao.getList("ReportMainMapper.getListSearch",
				reportMain);
	}

	public List<ReportMain> getListTop10() {
		return this.baseDao.getList("ReportMainMapper.getListTop10");
	}

	public List<String> getListSuggest(Map<String, Object> paraMap) {
		return this.baseDao.getList("ReportMainMapper.getListSuggest", paraMap);
	}

	public List<ReportMainTop> getListTop5(ReportMainTop reportMainTop) {
		return this.baseDao.getList("ReportMainMapper.getListTop5",
				reportMainTop);
	}

	public List<ReportMainTop> getListTop5Default(Map<String, Object> paraMap) {
		return this.baseDao.getList("ReportMainMapper.getListTop5Default", paraMap);
	}

	public List<ReportMain> getListCarousel() {
		return this.baseDao.getList("ReportMainMapper.getListCarousel");
	}

	public List<ReportInduxtry> getReportInduxtryList() {
		return this.baseDao.getList("ReportMainMapper.getReportInduxtryList");
	}

	public int delete(Long[] ids) {
		int i = 0;
		for (Long id : ids) {
			i += deleteByPrimaryKey(id);
		}
		return i;
	}

	public int deleteByPrimaryKey(Long id) {
		int i = 0;
		i += this.baseDao.delete("ReportMainMapper.deleteByPrimaryKey", id);
		i += this.baseDao.delete("ReportDirectoryMapper.deleteByReportId", id);
		return i;
	}

}
