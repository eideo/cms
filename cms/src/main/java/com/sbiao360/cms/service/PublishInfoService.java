package com.sbiao360.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.PublishInfoDao;
import com.sbiao360.cms.domain.PublishInfo;

@Service("publishInfoService")
public class PublishInfoService {

	@Resource
	private PublishInfoDao publishInfoDao;
	
	public PublishInfo selectByPrimaryKey(String id){
		return publishInfoDao.selectByPrimaryKey(id);
	}
	
	public PublishInfo selectByZBGGPrimaryKey(String id){
		return publishInfoDao.selectByZBGGPrimaryKey(id);
	}
	public PublishInfo selectByZBGSPrimaryKey(String id){
		return publishInfoDao.selectByZBGSPrimaryKey(id);
	}
	
	public List<Map<String,Object>> selectGroupByArea(Map<String,Object> params){
		return publishInfoDao.selectGroupByArea(params);
	}
	
	
	public List<Map<String,Object>> selectGroupByIndustry(Map<String,Object> params){
		return publishInfoDao.selectGroupByIndustry(params);
	}
	
	@Cacheable(value = "commonCache", key = "'homePageChart'")
	public List<Map<String,Object>> selectHomepageGroupByIndustry(Map<String,Object> params){
		return publishInfoDao.selectGroupByIndustry(params);
	}
	
	public List<Map<String,Object>> selectGroupByTypeAndTime(Map<String,Object> params){
		return publishInfoDao.selectGroupByTypeAndTime(params);
	}

	public List<Map<String, Object>> selectGroupByMonth(Map<String, Object> params) {
		return publishInfoDao.selectGroupByMonth(params);
	}
}
