package com.sbiao360.cms.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.sbiao360.cms.domain.RankingData;
import com.sbiao360.cms.service.RankingService;
import com.sbiao360.cms.zutil.DateTime;
import com.sbiao360.cms.zutil.RankingPMCompare;
import com.sbiao360.cms.zutil.StringUtil;


/**
 * 排行榜控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class RankingController extends BaseController{
	
	@Resource
	private RankingService rankingService;
	
	
	/**
	 * 跳转至排行榜页面
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/ranking"})
	public String toRanking(HttpServletRequest request,HttpServletResponse response){ 
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("notSearch", "true");
		return "ranking";
	}
	
	
	/**
	 * 获取排行信息
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/getRanking"})
	public void getRanking(HttpServletRequest request,HttpServletResponse response){
		// 行业指数底部热门单位显示条数
		int totalCompany = 6;
		String type = request.getParameter("type"); 
		String circle = request.getParameter("circle"); 
//		circle = circle==null?"1":circle;
		String industry = request.getParameter("industry");
		String area = request.getParameter("areaCode");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String sort = request.getParameter("sort");
		Map<String,Object> map = new HashMap<>();
		List<RankingData> result = new ArrayList<>();
		List<RankingData> lessResult = new ArrayList<>();
		//关键词
		if(type.equals("1")){
			map.put("type", "搜索");
			map.put("areaCode", area);
			setDateParamter(map,circle);
			result = rankingService.selectKeywordsRanking(map,circle);
			resetCount(result);
		}
		//关系网
		else if(type.equals("2")){
			map.put("areaCode", area);
			map.put("type", "关系网");
			setDateParamter(map,circle);
			result = rankingService.selectKeywordsRanking(map,circle);
			resetCount(result);
			if (null != result && result.size() == 0) {
				map.put("industry", industry);
				result = rankingService.selectKeywordsRankingDefault(map);
			}
		}
		//信息
		else if(type.equals("3")){
			map.put("areaCode",area);
			map.put("industry",industry);
			setDateParamter(map,circle);
			result = rankingService.selectInfoRanking(map,circle);
			resetCount(result);
			if (null != result && result.size() == 0) {
				result = rankingService.selectInfoRankingDefault(map);
			}
		}
		//公司
		else if(type.equals("4")){
			map.put("industry",industry);
			map.put("areaCode",area);
			if(StringUtil.isBlank(sort)){
				map.put("startDate", startDate);
				map.put("endDate", endDate);
				map.put("num", totalCompany);
			}else{
				setDateParamter(map,circle);
			}
			result = rankingService.selectCompanyRanking(map,circle);
			resetCount(result);
			if (result.size()>0) {
				if (StringUtil.isBlank(sort) && result.size() < totalCompany) {
					int lessNum = totalCompany - result.size();
					map.put("num", lessNum);
					lessResult = rankingService.selectCompanyRankingDefault(map);
					result.addAll(lessResult);
				} 
			}else {
				result = rankingService.selectCompanyRankingDefault(map);
			}
		}
		//报告
		else if (type.equals("5")) {
			map.put("industry", industry);
			map.put("areaCode", area);
			setDateParamter(map, circle);
			result = rankingService.selectReportRanking(map, circle);
			resetCount(result);
			if (null != result && result.size() == 0) {
				result = rankingService.selectReportRankingDefault(map);
			}
		}
		
		String asc = request.getParameter("asc");
		if(!StringUtil.isBlank(sort)&&!sort.equals("1")){
			Collections.sort(result, new RankingPMCompare());
		}
		if(!StringUtil.isBlank(sort)&&!asc.equals("1")){
			Collections.reverse(result);
		}
		for(RankingData rank:result){
			String industrys = rank.getIndustry();
			if(industrys!=null){
				String[] strs=industrys.split(",");
				l:for(String str:strs){
					if(StringUtil.isNotBlank(str)){
						rank.setIndustry(str.substring(0,4));
						break l;
					}
				}
			}else{
				rank.setIndustry("");
			}
		}
		Map<String ,Object> map1 = new HashMap<>();
		map1.put("status", true);
		int num = result.size()%20==0?result.size()/20:(result.size()/20+1);
		map1.put("num", num);
		map1.put("rankingDatas", result);
		
		ajaxJson(JSON.toJSONString(map1), response);
	}
	
	/**
	 * 重置排行榜数量
	 * @param result
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void resetCount(List<RankingData> result){
		for(int i=0;i<result.size();i++){
			RankingData ranking = result.get(i);
			ranking.setCountNow(ranking.getCountNow()+100-i-1);
		}
	}
	
	/**
	 * 设置排行榜查询时间参数
	 * @param map
	 * @param circle
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void setDateParamter(Map<String,Object> map,String circle){
		Calendar now = Calendar.getInstance();
		if(circle==null){
			return;
		}
		//今天
		if(circle.equals("1")){
			map.put("endDate", DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			map.put("startDate",DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
		}
		//本周
		else if(circle.equals("2")){
			map.put("endDate", DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
			map.put("startDate",DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
		}
		//本月
		else{
			map.put("endDate", DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.set(Calendar.DAY_OF_MONTH, 1); 
			map.put("startDate",DateTime.toDate("yyyy-MM-dd HH:mm:ss", now.getTime()));
		}
	}
	
	
}
