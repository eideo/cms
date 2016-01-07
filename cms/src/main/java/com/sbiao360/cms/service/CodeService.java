package com.sbiao360.cms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.CodeDao;
import com.sbiao360.cms.domain.Code;
import com.sbiao360.cms.zutil.StringUtil;

/**
 * 基础表服务层
 * @author 廖得宇
 *	2016年1月4日
 */
@Service
public class CodeService {
	
	@Resource
	private CodeDao codeDao;
	
	/**
	 * 根据地区id获取子级
	 * @param placeCode 父地区id，为NULL获取全部一级
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Code> getPlaceByParentCode(String placeCode){
		if(StringUtil.isBlank(placeCode)){
			return codeDao.getCodeList("地区_一级", null);
		}
		return codeDao.getCodeList("地区_二级", placeCode);
	}
	
	/**
	 * 根据地区编码获取地区名称
	 * @param code 地区编码
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@Cacheable(key="'area'+#code",value="commonCache")
	public String getPlaceName(String code){
		return codeDao.getCodeName(code);
	}

	/**
	 * 获取所有地区
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> getAllPlace() {
		List<Code> list = codeDao.getCodeList("地区_一级", null);
		return list.parallelStream().map(code->{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", code.getCode());
			map.put("name", code.getName());
			map.put("children",  codeDao.getCodeList("地区_二级", code.getCode()));
			return map;
		}).collect(Collectors.toList());
	}
	
	
	/**
	 * 根据类型和父编码获取子数据
	 * @param type
	 * @param parentCode
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@Cacheable(key="'industry'+#type+#parentCode",value="commonCache")
	public List<Code> getCodeList(String type,String parentCode){
		return codeDao.getCodeList(type, parentCode);
	}
}
