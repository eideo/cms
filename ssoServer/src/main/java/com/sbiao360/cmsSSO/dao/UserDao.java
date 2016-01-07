package com.sbiao360.cmsSSO.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sbiao360.cmsSSO.domain.User;


public class UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public List<User> getUserByAccount(String key){
		String sql = "SELECT concat(T.MOBILE_PHONE,'') as tel,T.CUST_NAME as name,T.CUST_EMAIL as mail,T.LOGIN_PASSWD as password,Concat(T.ID,'') as id FROM CMS_MEMBER_INFO T WHERE T.MOBILE_PHONE=? OR T.LOGIN_ID=? OR T.CUST_EMAIL=?";
		List<Map<String, Object>> listResult =  jdbcTemplate.queryForList(sql,   
                new Object[]{key,key,key} );
		List<User> list = new ArrayList<User>();
		for(Map<String,Object> map:listResult){
			User user = new User();
			user.setId((String)map.get("id"));
			user.setName((String)map.get("name"));
			user.setMail((String)map.get("mail"));
			user.setPassword((String)map.get("password"));
			user.setTel((String)map.get("tel"));
			list.add(user);
		}
		return  list;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
