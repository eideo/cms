package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * 行为序列的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class BehaviorSequenceDao {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	// 返回key对应list的长度
	public Long lLen(String key) {
		return this.redisTemplate.opsForList().size(key);
	}

	// 返回key指定范围内元素的列表
	public List<Object> getListRedis(String key, long start, long end) {
		List<Object> list = this.redisTemplate.opsForList().range(key, start,
				end);
		return list;
	}

}
