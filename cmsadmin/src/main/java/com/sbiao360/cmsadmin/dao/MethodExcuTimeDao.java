package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.MethodExcuTime;
import com.sbiao360.core.dao.BaseDao;

/**
 * 服务方法执行时间的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class MethodExcuTimeDao {

	@Resource
	private BaseDao baseDao;

	public Long getCount(MethodExcuTime methodExcuTime) {
		return this.baseDao.getCount("MethodExcuTimeMapper.getCount",
				methodExcuTime);
	}

	public List<MethodExcuTime> getList(MethodExcuTime methodExcuTime) {
		PageHelper.startPage(methodExcuTime.getPage(), methodExcuTime.getRows());
		return this.baseDao.getList("MethodExcuTimeMapper.getList",
				methodExcuTime);
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
		return this.baseDao.delete("MethodExcuTimeMapper.deleteByPrimaryKey",
				id);
	}
}
