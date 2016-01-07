package com.sbiao360.cms.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class ExponentDao {

	@Resource
	private BaseDao baseDao;
	
	
	public List<Map<String,Object>> primaryIndustry (Map<String,Object> params){
		return this.baseDao.getList("exponentMapper.primaryIndustry", params);
	}
	public List<Map<String,Object>> informationDist (Map<String,Object> params){
		return this.baseDao.getList("exponentMapper.informationDist", params);
	}
	public List<Map<String,Object>> userSegm (Map<String,Object> params){
		return this.baseDao.getList("exponentMapper.userSegm", params);
	}
	public List<Map<String,Object>> industryAccounted (Map<String,Object> params){
		return this.baseDao.getList("exponentMapper.industryAccounted", params);
	}
	public Map<String,Object> informationType (Map<String,Object> params){
		return this.baseDao.get("exponentMapper.informationType", params);
	}

	public Map<String, Object> getProjectCount(Map<String, Object> params) {
		return this.baseDao.get("exponentMapper.getProjectCount", params);
	}

	public Map<String, Object> getCompanyCount(Map<String, Object> params) {
		return this.baseDao.get("exponentMapper.getCompanyCount", params);
	}

	public Map<String, Object> competeAccounted(Map<String, Object> params) {
		return this.baseDao.get("exponentMapper.competeAccounted", params);
	}
	
	
	
}
