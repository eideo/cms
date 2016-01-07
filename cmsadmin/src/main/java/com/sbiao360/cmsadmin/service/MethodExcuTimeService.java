package com.sbiao360.cmsadmin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.MethodExcuTimeDao;
import com.sbiao360.cmsadmin.model.MethodExcuTime;

/**
 * 服务方法执行时间的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class MethodExcuTimeService {

	@Resource
	private MethodExcuTimeDao methodExcuTimeDao;

	public Long getCount(MethodExcuTime methodExcuTime) {
		return this.methodExcuTimeDao.getCount(methodExcuTime);
	}

	public List<MethodExcuTime> getList(MethodExcuTime methodExcuTime) {
		return this.methodExcuTimeDao.getList(methodExcuTime);
	}

	public int delete(Long[] ids) {
		return this.methodExcuTimeDao.delete(ids);
	}

	public int delete(Long id) {
		return this.methodExcuTimeDao.deleteByPrimaryKey(id);
	}
}
