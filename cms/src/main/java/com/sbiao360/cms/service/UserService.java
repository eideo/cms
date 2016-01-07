package com.sbiao360.cms.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.UserDao;
import com.sbiao360.cms.domain.User;

@Service("userService")  
public class UserService {
	
	@Resource
	private UserDao userDao;
 
 
	public User selectByPrimaryKey(int id){
			
		return userDao.selectByPrimaryKey(id);	
	}
	
	public List<User> getList(){
		
		return userDao.getList();		
	}
	 
	public int save(User user) {
		
		return userDao.save(user);
	}	 

	public int getCount() {
		
		return userDao.getCount();
	}
	
	public int delete(int id) {
		
		return userDao.delete(id);
	}
	
	public int update(User user) {
		
		return userDao.update(user);
	}	 

	public User loginCheck(String loginStr) {
		
		return userDao.loginCheck(loginStr);
	}
	
	public void insertLogin_logInfo(Integer user_id,String ip,Date login_date){
		
		userDao.insertLogin_logInfo(user_id, ip, login_date);
	}
}
