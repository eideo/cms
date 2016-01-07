package com.sbiao360.cms.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sbiao360.cms.domain.Code;
import com.sbiao360.cms.service.CodeService;
import com.sbiao360.cms.service.ExponentService;
import com.sbiao360.cms.zutil.StringUtil;

/**
 * 指数控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class ExponentController extends BaseController{
	
	
	@Resource
	private ExponentService exponentService;
	
	@Resource
	private CodeService codeService;
	
	/**
	 * 跳转至指数
	 * @param request
	 * @param response
	 * @return
	 * 		String
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/industry"})
	public String toIndustruyIndex(HttpServletRequest request,HttpServletResponse response){
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("notSearch", "true");
		return "industry";
	}
	
	/**
	 * 指数页数据获取接口（除行业数量外）
	 * @param request
	 * @param response
	 * @authorAdministrator
	 * 	2016年1月4日
	 */
	@RequestMapping({"/industryInformation"})
	public void industryInformation (HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		String informationT = request.getParameter("informationType");
		
		String industryType = request.getParameter("id");
		if(StringUtil.isBlank(industryType)){
			industryType="2108";
		}
		String startDate =request.getParameter("startDate");
		String endDate =request.getParameter("endDate");
		map.put("industryType", industryType);
		map.put("startDate",startDate+"01");
		map.put("endDate", endDate+"01");
		if(StringUtil.isNotBlank(informationT)){
			map.put("informationType", informationT);
		}else{
			map.put("informationType", "项目");
		}
		List<Map<String,Object>> informationDistList = exponentService.informationDist(map);
		for (Map<String, Object> map2 : informationDistList) {
			map2.put("time", ((Double)map2.get("time")).intValue());
		}
		List<Map<String,Object>> boomIndex = exponentService.boomIndex(informationDistList,startDate,endDate);
		List<Map<String,Object>> concernedIndex = exponentService.concernedIndex(informationDistList,startDate,endDate);
		List<Map<String,Object>> userSegm = exponentService.userSegm(map);
		List<Map<String,Object>> industryAccounted = exponentService.industryAccounted(map);
		List<Map<String,Object>> informationType = exponentService.informationType(map);
		List<Map<String,Object>> competeAccounted = exponentService.competeAccounted(map);
		informationDistList = exponentService.setZeroTime(informationDistList, startDate, endDate);
		
		Map<String,Object> result = new HashMap<>();
		result.put("informationDist", informationDistList);
		result.put("boomIndex", boomIndex);
		result.put("concernedIndex", concernedIndex);
		result.put("userSegm", userSegm);
		result.put("industryAccounted", industryAccounted);
		result.put("informationType", informationType);
		result.put("competeAccounted", competeAccounted);
		ajaxJson(JSON.toJSONString(result), response);
	} 
	
	/**
	 * 获取行业数量
	 * @param request
	 * @param response
	 * @authorAdministrator
	 * 	2016年1月4日
	 */
	@RequestMapping({"/primaryIndustry"})
	public void  primaryIndustry (HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<>();
		String startDate =request.getParameter("startDate");
		String endDate =request.getParameter("endDate");
		String informationType =request.getParameter("informationType");
		map.put("startDate",startDate+"01");
		map.put("endDate",endDate+"01");
		map.put("informationType",StringUtil.isBlank(informationType)?"项目":informationType);
		List<Map<String,Object>> primaryIndustry = exponentService.primaryIndustry(map);

		List<Code> list = codeService.getCodeList("行业_一级", null);
		for(Code code:list){
			boolean f = false;
			l:for(int i=0;i<primaryIndustry.size();i++){
				Map<String,Object> child = primaryIndustry.get(i);
				String name = (String) child.get("type");
				if(name==null){
					primaryIndustry.remove(i);
					i--;
					continue;
				}
				if(code.getName().equals(name)){
					f=true;
					break l;
				}
				
			}
			if(!f){
				Map<String,Object> mapAdd = new HashMap<>();
				mapAdd.put("id",code.getCode());
				mapAdd.put("type",code.getName());
				mapAdd.put("value",0);
				primaryIndustry.add(Integer.parseInt(code.getCode())%100-1, mapAdd);
			}
			
		}
		
		ajaxJson(JSON.toJSONString(primaryIndustry), response);
	}
}
