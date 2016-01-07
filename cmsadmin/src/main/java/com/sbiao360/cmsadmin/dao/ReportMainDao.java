package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.ReportInduxtry;
import com.sbiao360.cmsadmin.model.ReportMain;
import com.sbiao360.core.dao.BaseDao;

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

	public int updateEdit(ReportMain reportMain) {
		return this.baseDao.update("ReportMainMapper.updateEdit", reportMain);
	}

	public ReportMain getByPrimaryKey(Long id) {
		return this.baseDao.get("ReportMainMapper.getByPrimaryKey", id);
	}

	public Long getCount(ReportMain reportMain) {
		return this.baseDao.getCount("ReportMainMapper.getCount", reportMain);
	}

	public List<ReportMain> getList(ReportMain reportMain) {
		PageHelper.startPage(reportMain.getPage(), reportMain.getRows());
		return this.baseDao.getList("ReportMainMapper.getList", reportMain);
	}

	public List<ReportInduxtry> getReportInduxtrySelectList() {
		return this.baseDao.getList("ReportMainMapper.getReportInduxtryList");
	}

	public int delete(Long[] ids) {
		int i = 0;
		for (Long id : ids) {
			i += deleteByPrimaryKey(id);
			;
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
