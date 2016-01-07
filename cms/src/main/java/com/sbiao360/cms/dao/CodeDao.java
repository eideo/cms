package com.sbiao360.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.Code;

@Repository
public class CodeDao {
	
	
	@Resource
	private BaseDao baseDao;
	
	public List<Code> getCodeList(String type,String parentCode){
		Map<String,Object> params = new HashMap<>();
		params.put("type", type);
		params.put("parentCode", parentCode);
		return baseDao.getList("CodeMapper.getCodeList", params);
		
	}

	public String getCodeName(String code) {
		return baseDao.get("CodeMapper.getCodeName", code);
	}
}
