package com.sbiao360.cms.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerClickLogDao {

	@Resource
	private BaseDao baseDao;

	public int getCount(Object itemId) {
		return this.baseDao.getCount("customerClickLog.countAll", itemId);
	}

}
