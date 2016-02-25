package com.sbiao360.sys.cache;

import java.util.TimerTask;


import com.sbiao360.cms.service.CustomerBehaviorService;

public class MapTimer extends TimerTask{
	
	private CustomerBehaviorService  customerBehaviorService;
	
	@Override
	public void run() {
		customerBehaviorService.setHotwordRandom();
	}

	public CustomerBehaviorService getCustomerBehaviorService() {
		return customerBehaviorService;
	}

	public void setCustomerBehaviorService(CustomerBehaviorService customerBehaviorService) {
		this.customerBehaviorService = customerBehaviorService;
	}

}
