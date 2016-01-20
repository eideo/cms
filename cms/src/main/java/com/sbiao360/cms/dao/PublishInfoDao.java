package com.sbiao360.cms.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.PublishInfo;

@Repository
public class PublishInfoDao{
	
	@Resource
	private BaseDao baseDao;

	
	public PublishInfo selectByPrimaryKey(String id){
		return this.baseDao.get("publishInfo.selectByPrimaryKey",id);
	}
	public PublishInfo selectByZBGGPrimaryKey(String id){
		return this.baseDao.get("publishInfo.selectByZBGGPrimaryKey",id);
	}
	public PublishInfo selectByZBGSPrimaryKey(String id){
		return this.baseDao.get("publishInfo.selectByZBGSPrimaryKey",id);
	}
	
	public List<Map<String,Object>> selectGroupByArea(Map<String,Object> params){
		return this.baseDao.getList("publishInfo.selectGroupByArea", params);
	}
	public List<Map<String,Object>> selectGroupByIndustry(Map<String,Object> params){
		return this.baseDao.getList("publishInfo.selectGroupByIndustry", params);
	}
	public List<Map<String,Object>> selectGroupByTypeAndTime(Map<String,Object> params){
		return this.baseDao.getList("publishInfo.selectGroupByTypeAndTime", params);
	}

	public List<Map<String, Object>> selectGroupByMonth(Map<String, Object> params) {
		return this.baseDao.getList("publishInfo.selectGroupByMonth", params);
	}
	public PublishInfo selectByCGGXXPrimaryKey(String string) {
		return this.baseDao.get("publishInfo.selectByCGXXPrimaryKey",string);
	}
}
