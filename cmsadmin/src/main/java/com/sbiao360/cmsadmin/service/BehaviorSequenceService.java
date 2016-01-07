package com.sbiao360.cmsadmin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.BehaviorSequenceDao;
import com.sbiao360.cmsadmin.model.BehaviorSequence;

/**
 * 行为序列的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class BehaviorSequenceService {

	@Resource
	private BehaviorSequenceDao behaviorSequenceDao;

	public Long getCount(String key) {
		return this.behaviorSequenceDao.lLen(key);
	}

	// 获取Redis缓存服务器 状态监控列表
	public List<BehaviorSequence> getList(String key, long start, long end) {
		List<BehaviorSequence> list = new ArrayList<BehaviorSequence>();
		List<Object> objectList = this.behaviorSequenceDao.getListRedis(key,
				start, end);
		for (Object o : objectList) {
			BehaviorSequence behaviorSequence = transToBehaviorSequence(o);
			list.add(behaviorSequence);
		}

		return list;
	}

	public BehaviorSequence transToBehaviorSequence(Object o) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(BehaviorSequence.class);
		BehaviorSequence behaviorSequence = new BehaviorSequence();
		String jsonStr = (String) o;
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		behaviorSequence = (BehaviorSequence) JSONObject.toBean(jsonObject,
				jsonConfig);
		/*if (jsonObject.has("userId")) {
			behaviorSequence.setUserId(jsonObject.getString("userId"));
		}
		if (jsonObject.has("sessionId")) {
			behaviorSequence.setSessionId(jsonObject.getString("sessionId"));
		}
		if (jsonObject.has("actionTime")) {
			behaviorSequence.setActionTime(jsonObject.getString("actionTime"));
		}
		if (jsonObject.has("actionsequence")) {
			behaviorSequence.setActionsequence(jsonObject
					.getString("actionsequence"));
		}*/

		return behaviorSequence;
	}

}
