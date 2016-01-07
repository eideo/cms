package com.sbiao360.cmsSSO.service;

import java.util.List;

import com.sbiao360.cmsSSO.dao.UserDao;
import com.sbiao360.cmsSSO.domain.User;

public class UserService {

	private UserDao userDao;

	
	public List<User> getUserByAccount(String key){
		return  userDao.getUserByAccount(key);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
