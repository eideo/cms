package com.sbiao360.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDao extends SqlSessionDaoSupport implements Dao {

	@Override
	public int save(String key) {
		return getSqlSession().insert(key);
	}

	@Override
	public int save(String key, Object object) {
		return getSqlSession().insert(key, object);
	}

	@Override
	public int delete(String key) {
		return getSqlSession().delete(key);
	}

	@Override
	public int deleteByPrimaryKey(String key, Serializable id) {
		return getSqlSession().delete(key, id);
	}

	@Override
	public int delete(String key, Object object) {
		return getSqlSession().delete(key, object);
	}

	@Override
	public int update(String key) {
		return getSqlSession().update(key);
	}

	@Override
	public int update(String key, Object object) {
		return getSqlSession().update(key, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getByPrimaryKey(String key, Serializable id) {
		return (T) getSqlSession().selectOne(key, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key) {
		return (T) getSqlSession().selectOne(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}

	@Override
	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	@Override
	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}

	@Override
	public Long getCount(String key) {
		return getSqlSession().selectOne(key);
	}

	@Override
	public Long getCount(String key, Object params) {
		return getSqlSession().selectOne(key, params);
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
