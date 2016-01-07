package com.sbiao360.core.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author yujunwei
 */
public interface Dao {

	public int save(String key);

	public int save(String key, Object object);

	public int delete(String key);

	public int deleteByPrimaryKey(String key, Serializable id);

	public int delete(String key, Object object);

	public int update(String key);

	public int update(String key, Object object);

	public <T> T getByPrimaryKey(String key, Serializable id);

	public <T> T get(String key);

	public <T> T get(String key, Object params);

	public <T> List<T> getList(String key);

	public <T> List<T> getList(String key, Object params);

	public Long getCount(String key);

	public Long getCount(String key, Object params);

}
