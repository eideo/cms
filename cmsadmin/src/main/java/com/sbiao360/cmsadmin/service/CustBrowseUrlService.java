package com.sbiao360.cmsadmin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.CustBrowseUrlDao;
import com.sbiao360.cmsadmin.model.CustBrowseUrl;

/**
 * 用户浏览轨迹的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class CustBrowseUrlService {

	@Resource
	private CustBrowseUrlDao custBrowseUrlDao;

	public Long getCount(String key) {
		return this.custBrowseUrlDao.lLen(key);
	}

	// 获取Redis缓存服务器 状态监控列表
	public List<CustBrowseUrl> getList(String key, long start, long end) {
		List<CustBrowseUrl> list = new ArrayList<CustBrowseUrl>();
		List<Object> objectList = this.custBrowseUrlDao.getListRedis(key,
				start, end);
		for (Object o : objectList) {
			CustBrowseUrl custBrowseUrl = transToCustBrowseUrl(o);
			list.add(custBrowseUrl);
		}

		return list;
	}

	public CustBrowseUrl transToCustBrowseUrl(Object o) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(CustBrowseUrl.class);
		CustBrowseUrl custBrowseUrl = new CustBrowseUrl();
		String jsonStr = (String) o;
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		custBrowseUrl = (CustBrowseUrl) JSONObject.toBean(jsonObject,
				jsonConfig);
		/*if (jsonObject.has("ip")) {
			custBrowseUrl.setIp(jsonObject.getString("ip"));
		}
		if (jsonObject.has("accesstime")) {
			custBrowseUrl.setAccesstime(jsonObject.getString("accesstime"));
		}
		if (jsonObject.has("urlConsumetime")) {
			custBrowseUrl.setUrlConsumetime(jsonObject
					.getString("urlConsumetime"));
		}*/

		return custBrowseUrl;
	}

}
