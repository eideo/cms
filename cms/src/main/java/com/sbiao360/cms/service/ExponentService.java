package com.sbiao360.cms.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.ExponentDao;
import com.sbiao360.cms.zutil.ExpontCompare;

@Service("exponentService")
public class ExponentService {

	
	@Resource
	private ExponentDao exponentDao;
	
	/**
	 * 获取各行业数量
	 * @param params
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> primaryIndustry (Map<String,Object> params){
		return exponentDao.primaryIndustry(params);
	}
	
	/**
	 * 根据条件获取行业区间数量
	 * @param params
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> informationDist (Map<String,Object> params){
		return exponentDao.informationDist(params);
	}
	
	/**
	 * 根据条件获取用户关注的项目地区分布
	 * @param params
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> userSegm (Map<String,Object> params){
		return exponentDao.userSegm(params);
	}
	
	/**
	 * 根据条件获取行业关注度
	 * @param params
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> industryAccounted (Map<String,Object> params){
		return exponentDao.industryAccounted(params);
	}

	/**
	 * 根据条件获取行业竞争力比例
	 * @param params
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> competeAccounted(Map<String,Object> params){
		List<Map<String,Object>> resultList = new ArrayList<>();
		
		Map<String,Object> map = exponentDao.getProjectCount(params);
		if(map==null){
			return resultList;
		}
		int projectCount = ((BigDecimal) map.get("projectCount")).intValue();
		Map<String,Object> map1 = exponentDao.getCompanyCount(params);
		if(map1==null){
			return resultList;
		}
		int companyCount = ((BigDecimal)map1.get("companyCount")).intValue();
		double maxNum = (double)companyCount/projectCount*18/10;
		double minNum = (double)companyCount/projectCount*9/10;
		params.put("maxNum", maxNum);
		params.put("minNum", minNum);
		Map<String,Object> result = exponentDao.competeAccounted(params);
		
		Map<String,Object> mapStrong = new HashMap<>();
		mapStrong.put("type", "强");
		mapStrong.put("value", result.get("strong"));
		resultList.add(mapStrong);
		
		Map<String,Object> mapMiddle = new HashMap<>();
		mapMiddle.put("type", "中");
		mapMiddle.put("value", result.get("middle"));
		resultList.add(mapMiddle);
		
		Map<String,Object> mapWeak = new HashMap<>();
		mapWeak.put("type", "弱");
		mapWeak.put("value", result.get("weak"));
		resultList.add(mapWeak);
		return resultList;
	}
	
	/**
	 * 景气
	 * @param list
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Map<String,Object>> boomIndex(List<Map<String,Object>> list,String startDate,String endDate){
		List<Map<String,Object>> result = new ArrayList<>();
		List<Map<String,Object>> leftResult = new ArrayList<>();
		List<Map<String,Object>> rightResult = new ArrayList<>();
		String lastTime = "";
		int a = 0;
		for (int i=0;i<list.size();i++) {
			Map<String, Object> map  = list.get(i);
			int value = ((BigDecimal) map.get("value")).intValue();
			String time = ((Integer) map.get("time"))+"";
			int m =0;
			if(!lastTime.equals("")){
				int lastInt = Integer.parseInt(lastTime);
				int now = Integer.parseInt(time);
				int year = now/100-lastInt/100;
				int month = now%100-lastInt%100;
				 m = year*12+month;
			}
			if(m!=0&&m!=1){
				addDataCenter(a, value, lastTime, time, result);
			}
			//验证左侧数据
			if(i==0){
				//左侧数据不存在
				if(!time.equals(startDate)){
					addDataLeft(value,time,startDate,leftResult);
				}
			}
			else if(i==list.size()-1){
				if(!time.equals(endDate)){
					addDataRight(value, time, endDate, rightResult);
				}
			}
			
			Map<String,Object> mapBoom = new HashMap<>();
			mapBoom.put("time", Integer.parseInt(time));
			mapBoom.put("value", value);
			lastTime = time;
			a = value;
			result.add(mapBoom);
		}
		Collections.reverse(leftResult);
		leftResult.addAll(result);
		leftResult.addAll(rightResult);
		return leftResult;
	}
	
	/**
	 * 关注
	 * @param list
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<Map<String,Object>> concernedIndex(List<Map<String,Object>> list,String startDate,String endDate){
		
		List<Map<String,Object>> result = new ArrayList<>();
		List<Map<String,Object>> leftResult = new ArrayList<>();
		List<Map<String,Object>> rightResult = new ArrayList<>();
		String lastTime = "";
		int a = 0;
		for (int i=0;i<list.size();i++) {
			Map<String, Object> map  = list.get(i);
			int value = ((BigDecimal) map.get("value")).intValue();
			int time = (Integer) map.get("time");
			value = (int) (0.7*(1+Math.sin((time%100)*Math.PI/24))*value);
			int m =0;
			if(!lastTime.equals("")){
				int lastInt = Integer.parseInt(lastTime);
				int now = time;
				int year = now/100-lastInt/100;
				int month = now%100-lastInt%100;
				 m = year*12+month;
			}
			if(m!=0&&m!=1){
				addDataCenter(a, value, lastTime, time+"", result);
			}
			//验证左侧数据
			if(i==0){
				//左侧数据不存在
				if(!(time+"").equals(startDate)){
					addDataLeft(value,time+"",startDate,leftResult);
				}
			}
			else if(i==list.size()-1){
				if(!(time+"").equals(endDate)){
					addDataRight(value, time+"", endDate, rightResult);
				}
			}
			
			Map<String,Object> mapBoom = new HashMap<>();
			mapBoom.put("time", time);
			mapBoom.put("value", value);
			lastTime = time+"";
			a = value;
			result.add(mapBoom);
		}
		Collections.reverse(leftResult);
		leftResult.addAll(result);
		leftResult.addAll(rightResult);
		return leftResult;
	}
	
	/**
	 * 补充左侧为0数据
	 * @param value
	 * @param nowMonth
	 * @param startMonth
	 * @param result
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void addDataLeft(int value,String nowMonth,String startMonth,List<Map<String,Object>> result){
		
		int nowInt = Integer.parseInt(nowMonth);
		int startInt = Integer.parseInt(startMonth);
		while(startInt<nowInt){
			int month = nowInt%100;
			if(month!=1){
				nowInt--;
			}else{
				nowInt = nowInt+11-100;
			}
			month =nowInt%100;
			Map<String, Object> map = new HashMap<>();
			map.put("time", nowInt);
			value = (int) (value*(1+Math.sin(month*Math.PI/8)*15/100));
			map.put("value", value);
			result.add(map);
		}
		
	}
	
	/**
	 * 补充中间为0数据
	 * @param a
	 * @param b
	 * @param startMonth
	 * @param endMonth
	 * @param result
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void addDataCenter(int a,int b,String startMonth,String endMonth,List<Map<String,Object>> result){
		int startInt = Integer.parseInt(startMonth);
		int endInt = Integer.parseInt(endMonth);
		int year = endInt/100-startInt/100;
		int month = endInt%100-startInt%100;
		int m = year*12+month-1;
		for(int k=1;k<=m;k++){
			Map<String, Object> map = new HashMap<>();
			int year1 = k/12+(k%12+startInt%100)/12;
			int month1 = (k%12+startInt%100)%12;
			map.put("time", (startInt/100+year1)*100+month1);
			int value = (int) (a+(b-a)*k/(m+1)*(1+Math.sin(month1*Math.PI/8)*15/100));
			map.put("value", value);
			result.add(map);
		}
	}
	
	/**
	 * 补充右侧为0数据
	 * @param value
	 * @param nowMonth
	 * @param endMonth
	 * @param result
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void addDataRight(int value,String nowMonth,String endMonth,List<Map<String,Object>> result){
		int nowInt = Integer.parseInt(nowMonth);
		int endInt = Integer.parseInt(endMonth);
		while(nowInt<endInt){
			int month = nowInt%100;
			if(month!=12){
				nowInt++;
			}else{
				nowInt = nowInt-11+100;
			}
			month = nowInt%100;
			Map<String, Object> map = new HashMap<>();
			map.put("time", nowInt);
			value = (int) (value*(1+Math.sin(month*Math.PI/8)*15/100));
			map.put("value", value);
			result.add(map);
		}
	}

	/**
	 * 根据条件获取数据类型数据
	 * @param map
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String, Object>> informationType(Map<String, Object> map) {
		Map<String,Object> re = exponentDao.informationType(map);
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String,Object> map1 = new HashMap<>();
		map1.put("name", "项目");
		map1.put("value", re.get("project")==null?0:re.get("project"));
		list.add(map1);
		Map<String,Object> map2 = new HashMap<>();
		map2.put("name", "招标");
		map2.put("value", re.get("zbgg")==null?0:re.get("zbgg"));
		list.add(map2);
		Map<String,Object> map3 = new HashMap<>();
		map3.put("name", "中标");
		map3.put("value", re.get("zbgs")==null?0:re.get("zbgs"));
		list.add(map3);
		return list;
	}
	
	
	/**
	 * 行业区间值补充0
	 * @param list
	 * @param startDate
	 * @param endDate
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> setZeroTime(List<Map<String,Object>> list,String startDate,String endDate){
		String lastTime = "";
		List<Map<String,Object>> listre = new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			Map<String, Object> map  = list.get(i);
			int value = ((BigDecimal) map.get("value")).intValue();
			int time = (Integer) map.get("time");
			value = (int) (0.7*(1+Math.sin((time%100)*Math.PI/24))*value);
			int m =0;
			if(!lastTime.equals("")){
				int lastInt = Integer.parseInt(lastTime);
				int now = time;
				int year = now/100-lastInt/100;
				int month = now%100-lastInt%100;
				m = year*12+month;
			}
			if(m!=0&&m!=1){
				//中间数据不存在
				int startInt = Integer.parseInt(lastTime);
				int endInt = time;
				int year = endInt/100-startInt/100;
				int month = endInt%100-startInt%100;
				int mm = year*12+month-1;
				for(int k=1;k<=mm;k++){
					Map<String, Object> mapc = new HashMap<>();
					int year1 = k/12+(k%12+startInt%100)/12;
					int month1 = (k%12+startInt%100)%12;
					mapc.put("time", (startInt/100+year1)*100+month1);
					mapc.put("value", 0);
					listre.add(mapc);
				}
			}
			//验证左侧数据
			if(i==0){
				//左侧数据不存在
				if(!(time+"").equals(startDate)){
					int nowInt = time;
					int startInt = Integer.parseInt(startDate);
					while(startInt<nowInt){
						int month = nowInt%100;
						if(month!=1){
							nowInt--;
						}else{
							nowInt = nowInt+11-100;
						}
						month =nowInt%100;
						Map<String, Object> mapl = new HashMap<>();
						mapl.put("time", nowInt);
						mapl.put("value", 0);
						listre.add(mapl);
					}
				}
			}
			else if(i==list.size()-1){
				//右侧数据
				if(!(time+"").equals(endDate)){
					int nowInt = time;
					int endInt = Integer.parseInt(endDate);
					while(nowInt<endInt){
						int month = nowInt%100;
						if(month!=12){
							nowInt++;
						}else{
							nowInt = nowInt-11+100;
						}
						month = nowInt%100;
						Map<String, Object> mapr = new HashMap<>();
						mapr.put("time", nowInt);
						mapr.put("value", 0);
						listre.add(mapr);
					}
				}
			}
			listre.add(map);
			lastTime = time+"";
		}
		Collections.sort(listre, new ExpontCompare());
		return listre;
	}
}
