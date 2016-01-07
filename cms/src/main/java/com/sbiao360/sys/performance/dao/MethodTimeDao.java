package com.sbiao360.sys.performance.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.dao.BaseDao;
import com.sbiao360.sys.performance.domain.SysMethodTimeLog;

/**
 * 监控方法执行时间数据层
 * 
 * @author yujunwei
 */

@Repository("methodTimeDao")
public class MethodTimeDao {

	@Resource
	private BaseDao baseDao;

	public void insertSysMethodTimeLog(SysMethodTimeLog sysMethodTimeLog) {
		this.baseDao.save("SysMethodTimeLogMapper.insert", sysMethodTimeLog);
	}
}
