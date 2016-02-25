package com.sbiao360.sys.performance.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.zutil.PropertiesUtil;
import com.sbiao360.sys.performance.dao.MethodTimeDao;
import com.sbiao360.sys.performance.domain.SysMethodTimeLog;

/**
 * 监控方法执行时间服务层
 * 
 * @author yujunwei
 */

@Service("methodTimeService")
public class MethodTimeService {

	public static Long timeThreshold;

	static {
		String timeThresholdStr = PropertiesUtil.getProperties(
				"behavior.properties").getProperty("timeThreshold");
		timeThreshold = Long.parseLong(timeThresholdStr);
	}

	@Resource
	private MethodTimeDao methodTimeDao;

	public void insertSysMethodTimeLog(SysMethodTimeLog sysMethodTimeLog) {
		this.methodTimeDao.insertSysMethodTimeLog(sysMethodTimeLog);
	}

}
