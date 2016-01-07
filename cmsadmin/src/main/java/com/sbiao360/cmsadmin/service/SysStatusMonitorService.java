package com.sbiao360.cmsadmin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.SysStatusMonitorDao;
import com.sbiao360.cmsadmin.model.SysStatusMonitor;

/**
 * 状态监控的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class SysStatusMonitorService {

	@Resource
	private SysStatusMonitorDao sysStatusMonitorDao;

	public Long getCount(String key) {
		return this.sysStatusMonitorDao.lLen(key);
	}

	// 获取Redis缓存服务器 状态监控列表
	public List<SysStatusMonitor> getList(String key, long start, long end) {
		List<SysStatusMonitor> list = new ArrayList<SysStatusMonitor>();
		List<Object> objectList = this.sysStatusMonitorDao.getListRedis(key,
				start, end);
		for (Object o : objectList) {
			SysStatusMonitor sysStatusMonitor = transToSysStatusMonitor(o);
			list.add(sysStatusMonitor);
		}

		return list;
	}

	public SysStatusMonitor transToSysStatusMonitor(Object o) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(SysStatusMonitor.class);
		SysStatusMonitor sysStatusMonitor = new SysStatusMonitor();
		String jsonStr = (String) o;
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		sysStatusMonitor = (SysStatusMonitor) JSONObject.toBean(jsonObject,
				jsonConfig);
		/*if (jsonObject.has("ip")) {
			sysStatusMonitor.setIp(jsonObject.getString("ip"));
		}
		if (jsonObject.has("accesstime")) {
			sysStatusMonitor.setAccesstime(jsonObject.getString("accesstime"));
		}
		if (jsonObject.has("url")) {
			sysStatusMonitor.setUrl(jsonObject.getString("url"));
		}
		if (jsonObject.has("statuscode")) {
			sysStatusMonitor.setStatuscode(jsonObject.getString("statuscode"));
		}*/

		return sysStatusMonitor;
	}

}
