package com.sbiao360.cms.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.domain.HotwordMap;
import com.sbiao360.cms.zutil.DateJsonValueProcessor;
import com.sbiao360.cms.zutil.PropertiesUtil;

/**
 * 用户行为数据层
 * 
 * @author yujunwei
 */

@Repository
public class CustomerBehaviorDao {

	public static Long listSize;

	static {
		String listSizeStr = PropertiesUtil
				.getProperties("behavior.properties").getProperty("listSize");
		listSize = Long.parseLong(listSizeStr);
	}

	@Resource
	private BaseDao baseDao;

	@Resource
	private RedisTemplate<String, Object> redisTemplate01;

	// 用户行为-保存
	public int save(CustBehavior custBehavior) {
		int i = 0;
		i += this.baseDao.save("CustBehaviorMapper.insert", custBehavior);
		saveRedis(custBehavior);
		return i;
	}

	// 用户行为-更新
	public int updateByProperties(CustBehavior custBehavior) {
		int i = 0;
		i += this.baseDao.save("CustBehaviorMapper.updateByProperties",
				custBehavior);
		saveRedis(custBehavior);
		return i;
	}

	// 用户行为-更新
	public int updateByFoot(Map<String, Object> paraMap) {
		int i = 0;
		i += this.baseDao.save("CustBehaviorMapper.updateByFoot", paraMap);
		return i;
	}

	public boolean exist(CustBehavior custBehavior) {
		boolean flag = false;
		int num = this.baseDao.getCount(
				"CustBehaviorMapper.getCountByProperties", custBehavior);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	// 用户行为-热词搜索
	public List<HotwordMap> getHotwordMapList() {
		return this.baseDao.getList("HotwordMapMapper.select");
	}

	// IP对应地址
	public String getLocation(Long ip) {
		return this.baseDao.get("HotwordMapMapper.selectLocation", ip);
	}

	// 初始化取最新热词
	public HotwordMap getInitHotwordMap() {
		return (HotwordMap) this.baseDao.getList("HotwordMapMapper.selectInit")
				.get(0);
	}

	// 在key对应list的头部添加value元素
	public Long lPush(String key, Object value) {
		this.redisTemplate01.setValueSerializer(new StringRedisSerializer());
		return this.redisTemplate01.opsForList().leftPush((String) key, value);
	}

	// 返回key对应list的长度
	public Long lLen(String key) {
		return this.redisTemplate01.opsForList().size(key);
	}

	// 从key对应list的尾部删除元素，并返回删除元素
	public Object rPop(String key) {
		this.redisTemplate01.setValueSerializer(new StringRedisSerializer());
		return this.redisTemplate01.opsForList().rightPop(key);
	}

	// 返回list中指定位置(index)的元素，index=0，表示头部元素，index=-1，表示尾部元素
	public Object lIndex(String key, Long index) {
		this.redisTemplate01.setValueSerializer(new StringRedisSerializer());
		return this.redisTemplate01.opsForList().index(key, index);
	}

	public void saveRedis(CustBehavior custBehavior) {
		// System.out.println("into CustomerBehaviorDao.saveRedis ......");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		JSONObject jsonObject = JSONObject.fromObject(custBehavior, jsonConfig);
		String jsonString = jsonObject.toString();
		Long size = lPush(custBehavior.getObjectKey(), jsonString);

		if (size > listSize) {
			// System.out.println("into custBehaviorCache.rPop ......");
			rPop(custBehavior.getObjectKey());
		}
	}

	public static void main(String[] args) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jsonConfig.setRootClass(CustBehavior.class);
		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setActionDate(new Date());
		custBehavior.setActionType((short) 1);
		custBehavior.setUserId(100L);
		custBehavior.setCustName("于俊伟");
		JSONObject jsonObject = JSONObject.fromObject(custBehavior, jsonConfig);
		String jsonString = jsonObject.toString();
		System.out.println(jsonString);
		JSONObject jsonBean = JSONObject.fromObject(jsonString, jsonConfig);
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpher(new String[] { "yyyy-MM-dd HH:mm:ss" }));
		CustBehavior bean = (CustBehavior) JSONObject.toBean(jsonBean,
				jsonConfig);
		System.out.println(bean.getObjectKey());
	}

}
