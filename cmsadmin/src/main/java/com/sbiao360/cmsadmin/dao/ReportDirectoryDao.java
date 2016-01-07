package com.sbiao360.cmsadmin.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cmsadmin.model.ReportDirectory;
import com.sbiao360.core.dao.BaseDao;

/**
 * 行业报告目录的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class ReportDirectoryDao {

	@Resource
	private BaseDao baseDao;

	public int save(ReportDirectory reportDirectory) {
		return this.baseDao.save("ReportDirectoryMapper.insert",
				reportDirectory);
	}

	public int update(ReportDirectory reportDirectory) {
		return this.baseDao.update("ReportDirectoryMapper.update",
				reportDirectory);
	}

	public ReportDirectory getByPrimaryKey(Long id) {
		return this.baseDao.get("ReportDirectoryMapper.getByPrimaryKey", id);
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
		return this.baseDao.delete("ReportDirectoryMapper.deleteByPrimaryKey",
				id);
	}

	public int deleteByReportId(Long reportId) {
		return this.baseDao.delete("ReportDirectoryMapper.deleteByReportId",
				reportId);
	}

	public List<ReportDirectory> getReportDirectory(Long reportId) {
		return this.baseDao.getList("ReportDirectoryMapper.getByReportId",
				reportId);
	}

	public int updateByProperties(Map<String, Object> paramMap) {
		return this.baseDao.update("ReportDirectoryMapper.updateByProperties",
				paramMap);
	}
}
