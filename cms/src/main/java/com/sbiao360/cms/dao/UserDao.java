package com.sbiao360.cms.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cms.domain.User;

@Repository
public class UserDao {
	 
	@Resource
	private BaseDao baseDao;
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public User selectByPrimaryKey(int id){
		
		return this.baseDao.selectByPrimaryKey("userMapper.selectByPrimaryKey",id);
	}
	
	public List<User> getList(){
		return this.baseDao.getList("userMapper.selectList");
	}
	 
	public int save(User user) {
		
		return this.baseDao.save("userMapper.insert", user);
	}	 

	public int getCount() {
		
		return this.baseDao.getCount("userMapper.countAll");
	}
	
	public int delete(int id) {
		
		return this.baseDao.delete("userMapper.delete",id);
	}
	
	public int update(User user) {
		
		return this.baseDao.update("userMapper.update", user);
	}	 
	
	public User loginCheck(String loginStr) {
		
		return this.baseDao.selectOne("userMapper.selectByStr", loginStr);
	}
	
	public void insertLogin_logInfo(Integer user_id,String ip,Date login_date){
		 String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_date)values(?,?,?)";
         Object[] args={user_id,ip,login_date};
		 jdbcTemplate.update(sqlStr, args);
	}
	
	
}
