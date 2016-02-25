package com.sbiao360.cms.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
   
@Repository 
public class BaseDaoMyBatis extends SqlSessionDaoSupport implements BaseDao{
             
		@SuppressWarnings("unchecked")
		public <T> T selectByPrimaryKey(String key, Serializable id) {
	
			return (T) getSqlSession().selectOne(key, id);
		} 
	   
		@SuppressWarnings("unchecked")
		public <T> T get(String key, Object params) {
	
			return (T) getSqlSession().selectOne(key, params);
		}
	  
		public <T> List<T> getList(String key) {
	
			return getSqlSession().selectList(key);
		}
	
		public <T> List<T> getList(String key, Object params) {
	
			return getSqlSession().selectList(key, params);
		}
		
		public int save(String key, Object object) {
	
			return getSqlSession().insert(key, object);
		}
	
		public int delete(String key, Serializable id) {
	
			return getSqlSession().delete(key, id);
		}
	
		public int delete(String key, Object object) {
	
			return getSqlSession().delete(key, object);
		}
		
		public int update(String key, Object object){
			
			return getSqlSession().update(key, object);
		}
		
		public int getCount(String key){
			
			return getSqlSession().selectOne(key);
		}
		
		@SuppressWarnings("unchecked")
		public <T>  T selectOne(String key,Object params){
			
			return (T) getSqlSession().selectOne(key,params);
		}
		
		
		@Resource
		public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
			super.setSqlSessionFactory(sqlSessionFactory);
		}

		@Override
		public int getCount(String key, Object params) {
			return getSqlSession().selectOne(key,params);
		}

		@Override
		public Map<String, Object> get(String key) {
			return getSqlSession().selectOne(key);
		}

}
