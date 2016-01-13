package com.sbiao360.cms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao{
      
	public <T> T selectByPrimaryKey(String key, Serializable id);
	   
	public <T> T get(String key, Object params);
	
	public <T> List<T> getList(String key);
	
	public <T> List<T> getList(String key, Object params);
	
	public int save(String key, Object object);
	
	public int delete(String key, Serializable id);
	
	public int delete(String key, Object object);
	
	public int update(String key, Object object);
	
	public int getCount(String key);
	
	public int getCount(String key,Object object);
	
	public <T>  T selectOne(String key,Object params);

	public Map<String, Object> get(String string);
}
