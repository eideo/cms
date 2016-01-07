package com.sbiao360.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.CustomerBehaviorDao;
import com.sbiao360.cms.dao.CustomerClickLogDao;
import com.sbiao360.cms.domain.CustBehavior;

@Service("customerClickLogService")
public class CustomerClickLogService {

	@Resource
	private CustomerClickLogDao customerClickLogDao;

	@Resource
	private CustomerBehaviorDao customerBehaviorDao;

	public int getCustomerClickCount(int itemId) {
		return customerClickLogDao.getCount(itemId);
	}

	public int save(CustBehavior custBehavior) {
		return customerBehaviorDao.save(custBehavior);
	}
}
