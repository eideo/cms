package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.CustBehavior;
import com.sbiao360.core.dao.BaseDao;

/**
 * 用户行为的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class CustBehaviorDao {

	@Resource
	private BaseDao baseDao;

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	public Long getCount(CustBehavior custBehavior) {
		return this.baseDao.getCount("CustBehaviorMapper.getCount",
				custBehavior);
	}

	public List<CustBehavior> getList(CustBehavior custBehavior) {
		PageHelper.startPage(custBehavior.getPage(), custBehavior.getRows());
		return this.baseDao.getList("CustBehaviorMapper.getList", custBehavior);
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
		return this.baseDao.delete("CustBehaviorMapper.deleteByPrimaryKey", id);
	}

	public List<Object> getListRedis(String key, long start, long end) {
		List<Object> list = this.redisTemplate.opsForList().range(key, start,
				end);
		return list;
	}

}
