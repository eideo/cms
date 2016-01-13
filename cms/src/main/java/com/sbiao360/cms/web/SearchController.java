package com.sbiao360.cms.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.base.cons.CommonConstants;
import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.domain.KeywordsException;
import com.sbiao360.cms.service.CodeService;
import com.sbiao360.cms.service.CustomerBehaviorService;
import com.sbiao360.cms.service.CustomerKeywordsService;
import com.sbiao360.cms.service.IndexInfoService;
import com.sbiao360.cms.service.PublishInfoService;
import com.sbiao360.cms.zutil.DateTime;
import com.sbiao360.cms.zutil.IpTool;
import com.sbiao360.cms.zutil.SearchResultCompare;
import com.sbiao360.cms.zutil.StringUtil;


/**
 * 搜索控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class SearchController extends BaseController{
	
	
	@Resource
	private IndexInfoService indexInfoService;
	
	@Resource
	private CustomerKeywordsService customerKeywordsService;
	
	@Resource
	private PublishInfoService publishInfoService;
	
	@Resource
	private CustomerBehaviorService customerBehaviorService;
	
	@Resource
	private CodeService codeService;
	
	/**
	 * 跳转至首页
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/homepage","/"})
	public String toHomePage(HttpServletRequest request,HttpServletResponse response){
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("hotKeyWords", customerKeywordsService.getHotKeyWordsList());
		return "/index";
	}
	
	/**
	 * 跳转至搜索页
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/search"})
	public String toSearchPage(HttpServletRequest request,HttpServletResponse response){
		if(StringUtil.isNotBlank(request.getParameter("keywords"))&&StringUtil.StringFilter(request.getParameter("keywords"))){
			return null;
		}
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		
		
		request.setAttribute("keyword", request.getParameter("keyword"));
		request.setAttribute("area", request.getParameter("area"));
		request.setAttribute("hotKeyWords", customerKeywordsService.getHotKeyWordsList());
		request.setAttribute("industry", request.getParameter("industry"));
		request.setAttribute("industryId", request.getParameter("industryId"));
		request.setAttribute("type", request.getParameter("type"));
		return "/searchResult";
	}
	
	
	/**
	 * ajax查询
	 * @param request
	 * @param response
	 */
	@RequestMapping({"/ajaxsearch"})
	public void ajaxSearch(HttpServletRequest request,HttpServletResponse response){
		if(StringUtil.isNotBlank(request.getParameter("keywords"))&&StringUtil.StringFilter(request.getParameter("keywords"))){
			return ;
		}
		@SuppressWarnings("unchecked")
		Map<String, String[]> map = request.getParameterMap();
		String searchString = getSearchString(map,IpTool.getClientAddress(request));
		
		String pageNo = map.get("pageNo")!=null?map.get("pageNo")[0]:"";
		int start = -1;
		if(!StringUtil.isBlank(pageNo)){
			start = (Integer.parseInt(pageNo)-1)*CommonConstants.PAGE_SIZE;
		}else{
			pageNo = "1";
		}
		Map<String, Object> indexMap = indexInfoService.queryIndexInfo(searchString,start,-1);
		
		JSONObject json = new JSONObject();
		json.put("listIndex", indexMap.get("result"));
		Long count = Long.parseLong((String)indexMap.get("num"));
		Long num = count%CommonConstants.PAGE_SIZE==0?count/CommonConstants.PAGE_SIZE:count/CommonConstants.PAGE_SIZE+1;
		json.put("num", num );
		json.put("count", count);
		json.put("pageNo",pageNo);
		json.put("time", Float.parseFloat((String)indexMap.get("time"))/1000);
		
		json.put("status", true);
		ajaxJson(json.toJSONString(), response);
		
		customerKeywordsService.checkKeyWordsDict(request.getParameter("keywords"));
		if(Float.parseFloat((String)indexMap.get("maxScore"))<2){
			newKyException(request.getParameter("area"),request.getParameter("industry"),"noresult"
					,IpTool.setIP(IpTool.getClientAddress(request)),request.getParameter("keywords"),
					(String)indexMap.get("time"),searchString
					);
		}
		if(Long.parseLong((String)indexMap.get("time"))>1000){
			newKyException(request.getParameter("area"),request.getParameter("industry"),"timeout"
					,IpTool.setIP(IpTool.getClientAddress(request)),request.getParameter("keywords"),
					(String)indexMap.get("time"),searchString
					);
		}
	}
	
	/**
	 * 保存关键词异常
	 * @param areaId	地区id
	 * @param industry2Id	行业id
	 * @param exceptionType	异常类型
	 * @param ip	ip
	 * @param ky	关键词
	 * @param time	时间
	 * @param record	查询语句
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private void newKyException(String areaId,String industry2Id,String exceptionType,Long ip,String ky,String time,String record){
		KeywordsException exception = new KeywordsException();
		exception.setRecordId(java.util.UUID.randomUUID().toString().replaceAll("-",""));
		exception.setAreaId(areaId);
		exception.setIndustry2Id(industry2Id);
		exception.setConfirmDate(new Date());
		exception.setExceptionType(exceptionType);
		exception.setIp(ip);
		exception.setKeywords(ky);
		exception.setKeywordsType("custKeywords");
		exception.setQueryTime(time);
		exception.setSqlRecord(record);
		customerKeywordsService.insertKeywordsException(exception);
	}
	
	
	/**
	 * 获取热词
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/gethotkeywords"})
	public void getHotKeywords(HttpServletRequest request,HttpServletResponse response){
		String keyword = request.getParameter("keyword");
		JSONObject json = new JSONObject();
		
		json.put("hotKeywords", customerKeywordsService.selectLikeKeywordsDic(keyword));
		json.put("status", true);
		ajaxJson(json.toJSONString(), response);
	}

	
	/**
	 * 搜索图形数据提取
	 * @param request
	 * @param response
	 * @throws SolrServerException
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping({"/getsearchstatistics"})
	public void getSearchStatistics(HttpServletRequest request,HttpServletResponse response) throws SolrServerException{
		String area = request.getParameter("area");
		String industry = request.getParameter("industry");
		String type = request.getParameter("type");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String industryId = request.getParameter("industryId");
		Map<String, String[]> map = new HashMap<>();
		map.putAll(request.getParameterMap());
		
		map.remove("industry");
		map.remove("industryId");
		String searchString  = getSearchString(map);
		List<Map<String,Object>> listIndustryGroup = indexInfoService.getFacetIndustryNum(searchString);
		
		map.remove("area");
		map.put("industry",new String[]{industry});
		map.put("industryId",new String[]{industryId});
		searchString = getSearchString(map);
		List<Map<String,Object>> listAreaGroup = indexInfoService.getFacetAreaNum(searchString);
		
		map.put("area", new String []{area});
		map.remove("type");
		List<Map<String,Object>>  listTypeGroup= new ArrayList<>();
		if(StringUtil.isBlank(type)){
			type="项目招标中标";
		}
		Map<String,Object> mapXMTypeGroup = new HashMap<>();
		Map<String,Object> mapZBGSTypeGroup = new HashMap<>();
		Map<String,Object> mapZBXXTypeGroup = new HashMap<>();
		Set<String > keySet = new HashSet<>();
		if(StringUtil.contains(type, "项目")){
			map.put("type", new String []{"项目"});
			searchString = getSearchString(map);
			mapXMTypeGroup = indexInfoService.getFacetMonthNum(searchString, startDate, endDate);
			keySet.addAll(mapXMTypeGroup.keySet());
		}
		if(StringUtil.contains(type, "中标")){
			map.put("type", new String []{ "中标"});
			searchString = getSearchString(map);
			mapZBGSTypeGroup = indexInfoService.getFacetMonthNum(searchString, startDate, endDate);
			keySet.addAll(mapZBGSTypeGroup.keySet());
		}
		if(StringUtil.contains(type, "招标")){
			map.put("type", new String []{"招标"});
			searchString = getSearchString(map);
			mapZBXXTypeGroup = indexInfoService.getFacetMonthNum(searchString, startDate, endDate);
			keySet.addAll(mapZBXXTypeGroup.keySet());
		}
		for (String key : keySet) {
			Map<String,Object> maps = new HashMap<>();
			maps.put("bid", mapZBGSTypeGroup.get(key)==null?0:mapZBGSTypeGroup.get(key));
			maps.put("tender", mapZBXXTypeGroup.get(key)==null?0:mapZBXXTypeGroup.get(key));
			maps.put("project",  mapXMTypeGroup.get(key)==null?0: mapXMTypeGroup.get(key));
			maps.put("time", key);
			listTypeGroup.add(maps);
		}
		//
		JSONObject json = new JSONObject();
		listTypeGroup.sort(new SearchResultCompare());
		json.put("dataTimeo", listTypeGroup);
		json.put("dataArea", get5AreaNum(listAreaGroup,area));
		json.put("dataIndustry", get5Industry(listIndustryGroup,industry));
		JSONArray jsonar = new JSONArray();
		jsonar.add(json);
		ajaxJson(jsonar.toJSONString(), response);
	}
	
	
	/**
	 * 根据业务规则获取5个地区数据
	 * @param listAreaGroup
	 * @param area
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private List<Map<String,Object>> get5AreaNum(List<Map<String,Object>> listAreaGroup,String area ){
		//如果只有五个或者不足五个以下省有数据，直接返回
		if(listAreaGroup.size()<=5){
			return listAreaGroup;
		}
		List<Map<String,Object>> listAreaResult = new ArrayList<Map<String,Object>>();
		//如果选择不限，取前五位，别的作为不限
		if(StringUtil.isBlank(area)){
			Map<String,Object> map =  new HashMap<String, Object>();
			for (int i = 0,b=0;i< listAreaGroup.size();i++) {
				if(i-b<5){
					if(!"".equals(listAreaGroup.get(i).get("area"))){
						listAreaResult.add(listAreaGroup.get(i));
					}else{
						if(!map.isEmpty()){
							map.put("area","其他");
							map.put("nums",Integer.parseInt(String.valueOf(map.get("nums")))+Integer.parseInt(String.valueOf(listAreaGroup.get(i).get("nums"))));
						}else{
							map.put("area","其他");
							map.put("nums",Integer.parseInt(String.valueOf(listAreaGroup.get(i).get("nums"))));
						}
						b++;
					}
				}else{
					if(!map.isEmpty()){
						map.put("area","其他");
						map.put("nums",Integer.parseInt(String.valueOf(map.get("nums")))+Integer.parseInt(String.valueOf(listAreaGroup.get(i).get("nums"))));
					}else{
						map.put("area","其他");
						map.put("nums",Integer.parseInt(String.valueOf(listAreaGroup.get(i).get("nums"))));
					}
				}
			}
			if(!map.isEmpty()){
				listAreaResult.add(map);
			}
		}
		//如果选择有地区
		else{
			//切分地区，确认地区
			String areas [] = area.split(",");
			Map<String,Object> hasAdd = new HashMap<String ,Object>();
			//取出结果集中有的前五地区，若没有五个则下一步补充
			int iForIter = areas.length>5?5:areas.length;
			for(int i=0;i<iForIter;i++){
				for(Map<String,Object> map:listAreaGroup){
					if(map.get("area").equals(areas[i])&&!"".equals(areas[i])){
						listAreaResult.add(map);
						hasAdd.put(areas[i], "");
					}
				}
			}
			int nowsize = listAreaResult.size();
			//取个数多的补充不足五个的地区
			for(int i=0,b=0;i<5-nowsize;){
				if(!area.contains((String)listAreaGroup.get(b+i).get("area"))&&!"".equals(listAreaGroup.get(b+i).get("area"))){
					listAreaResult.add(listAreaGroup.get(b+i));
					hasAdd.put((String)listAreaGroup.get(b+i).get("area"), "");
					i++;
				}else{
					b++;
				}
			}
			Map<String,Object> mapElse = new HashMap<String,Object>();
			//将其他地区放入其他里面
			for(Map<String,Object> map:listAreaGroup){
				if(!hasAdd.containsKey((String)map.get("area"))){
					if(mapElse.isEmpty()){
						mapElse.put("area","其他");
						mapElse.put("nums",Integer.parseInt(String.valueOf(map.get("nums"))));
					}else{
						mapElse.put("nums",(Integer.parseInt(String.valueOf(mapElse.get("nums")))+Integer.parseInt(String.valueOf(map.get("nums")))));
					}
				}
			}
			listAreaResult.add(mapElse);
		}
		return listAreaResult;
	}
	
	
	/**
	 * 根据业务规则获取5个行业数据
	 * @param listIndustryGroup
	 * @param industry
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private List<Map<String,Object>> get5Industry(List<Map<String,Object>> listIndustryGroup ,String industry){
		//如果只有五个或者不足五个以下行业有数据，直接返回
		if(listIndustryGroup.size()<=5){
			return listIndustryGroup;
		}
		List<Map<String,Object>> listIndustryResult = new ArrayList<Map<String,Object>>();
		//如果选择不限，取前五位，缺失不补，多的不要
		if(StringUtil.isBlank(industry)){
			for (int i = 0;i< 5;i++) {
				listIndustryResult.add(listIndustryGroup.get(i));
			}
		}
		//如果选择有地区，取前五位，缺失不补，多的不要
		else{
			//切分地区，确认地区
			String industrys [] = industry.substring(0, industry.length()).split(",");
			//取出结果集中有的前五地区，若没有五个则下一步补充
			int iForIter = industrys.length>5?5:industrys.length;
			String has = ",";
			for(int i=0;i<iForIter;i++){
				for(Map<String,Object> map:listIndustryGroup){
					if(map.get("industry").equals(industrys[i])){
						listIndustryResult.add(map);
						has+=industrys[i]+",";
					}
				}
			}
			for(int i=0;i<iForIter;i++){
				if(!has.contains(industrys[i])){
					Map<String,Object> map = new HashMap<>();
					map.put("industry",industrys[i] );
					map.put("nums",0 );
					listIndustryResult.add(map);
				}
			}
			//取个数多的补充不足五个的地区
			for(int i=listIndustryResult.size(),b=0;i<5;){
				if(!industry.contains((String)listIndustryGroup.get(b+i).get("industry"))){
					listIndustryResult.add(listIndustryGroup.get(b+i));
					has+=listIndustryGroup.get(b+i).get("industry")+",";
					i++;
				}else{
					b++;
				}
			}
		}
		return listIndustryResult;
	}
	
	/**
	 * 获取检索建议
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping(value="/getSuggest",method =RequestMethod.POST)
	public void getSuggest(HttpServletRequest request,HttpServletResponse response){
		String keyword = request.getParameter("name");
		List<String> listOfSuggest = indexInfoService.getSpellCheckFromSolr(keyword);
		JSONObject json = new JSONObject();
		json.put("status", true);
		json.put("datas", (listOfSuggest!=null&&listOfSuggest.size()>5)?listOfSuggest.subList(0, 5):listOfSuggest);
		ajaxJson(JSON.toJSONString(json),response);
	}
	
	/**
	 * 根据参数组装查询语句
	 * @param map
	 * @return
	 */
	private String getSearchString(Map<String,String[]> map,String ip){
		String str = map.get("keyword")!=null?map.get("keyword")[0]:"";
		List<String> escapedKw = new ArrayList<String>();
		if(StringUtil.isBlank(str)){
			escapedKw.add("(titleForIndex:*)");
		}else{
			insertCustBehavior(str,ip);
			String searchStr = ClientUtils.escapeQueryChars(str);
			escapedKw.add("(titleForIndex:\""+searchStr+"\"^4 description:\""+searchStr+"\"^3 titleForIndex:"+searchStr+"^2 description:"+searchStr+"^1)^2");
		}
		String area = map.get("area")!=null?map.get("area")[0]:"";
		
		if(!StringUtil.isBlank(area)){
			area = getAreaNames(area);
			escapedKw.add(" (area_name:"+ClientUtils.escapeQueryChars(area).substring(0, ClientUtils.escapeQueryChars(area).length()-1).replace(",", " area_name:")+")");
		}
		String industry =  map.get("industry")!=null?map.get("industry")[0]:"";
		
		if(!StringUtil.isBlank(industry)){
			escapedKw.add( " (category:"+ClientUtils.escapeQueryChars(industry).substring(0, ClientUtils.escapeQueryChars(industry).length()-1).replace(",", " category:")+")");
		}
		String industryId =  map.get("industryId")!=null?map.get("industryId")[0]:"";
		
		if(!StringUtil.isBlank(industryId)){
			escapedKw.add( " (category:"+codeService.getIndustryName(industryId)+")");
		}
		String type =  map.get("type")!=null?map.get("type")[0]:"";
		
		String typeSearch = "";
		if(!StringUtil.isBlank(type)){
			if(StringUtil.contains(type, "项目")){
				typeSearch += " table_name:XMXX";
			}
			if(StringUtil.contains(type, "中标")){
				typeSearch += " (table_name:ZBXX AND table_name2:ZBGS )";
			}
			if(StringUtil.contains(type, "招标")){
				typeSearch += " (table_name:ZBXX -table_name2:ZBGS )";
			}
			escapedKw.add(" ("+typeSearch+")");
		}
		
		String circle =  map.get("circle")!=null?map.get("circle")[0]:""; 
		if(StringUtil.isNotBlank(circle)){
			String datequery = getDateQuery(circle);
			escapedKw.add(" "+datequery);
		}
		
		String searchString="";
		for(String s:escapedKw){
			searchString+="".equals(searchString)?s:" AND"+s;
		}
		return searchString;
	}
	
	/**
	 * 设置排行榜查询时间参数
	 * @param map
	 * @param circle
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private String getDateQuery(String circle){
		String str = "";
		Calendar now = Calendar.getInstance();
		//今天
		if(circle.equals("1")){
			String endDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			String startDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			str = "publish_date:["+startDate+" TO "+endDate+"]";
		}
		//本周
		else if(circle.equals("2")){
			String endDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
			String startDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			str = "publish_date:["+startDate+" TO "+endDate+"]";
		}
		//本月
		else{
			String endDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			now.set(Calendar.DAY_OF_MONTH, 1); 
			String startDate = DateTime.toDate("yyyy-MM-dd'T'HH:mm:ss'Z'", now.getTime());
			str = "publish_date:["+startDate+" TO "+endDate+"]";
		}
		return str;
	}
	
	/**
	 * 搜集用户数据
	 * @param str
	 * @param ip
	 * @author 廖得宇
	 * 	2016年1月5日
	 */
	private void insertCustBehavior(String str,String ip){
		Assertion assertion = AssertionHolder.getAssertion();
		CustBehavior custBehavior = new CustBehavior();
		if(assertion!=null){
			custBehavior.setUserId(Long.parseLong( (String) assertion.getPrincipal().getAttributes().get("id")));
			custBehavior.setCustName( (String) assertion.getPrincipal().getAttributes().get("name"));
			custBehavior.setLoginId(assertion.getPrincipal().getName());
		}else{
			custBehavior.setUserId((long) 0);
		}
		custBehavior.setActionDate(new Date());
		custBehavior.setIp(IpTool.setIP(ip));
		custBehavior.setActionType((short) 6);
		custBehavior.setColumnLevelOne("搜索");
		custBehavior.setKeywords(str);
		custBehavior.setInfoValid((short) 1);
		customerKeywordsService.insertKeyWords(custBehavior);
		
		// start add by yujw 20150922
		String area = ip.contains("192.168")?"北京":customerBehaviorService.getAreaByIp(custBehavior
				.getIp());
		JSONObject hotword = new JSONObject();
		hotword.put("hotWord", str);
		hotword.put("areaName", area);
		customerBehaviorService.setHotword(hotword.toString());
		// end add by yujw 20150922
	}
	/**
	 * 根据参数组装查询语句
	 * @param map
	 * @return
	 */
	private String getSearchString(Map<String,String[]> map){
		String str = map.get("keywords")!=null?map.get("keywords")[0]:"";
		List<String> escapedKw = new ArrayList<String>();
		if(StringUtil.isBlank(str)){
			escapedKw.add("(titleForIndex:*)");
		}else{
			String searchStr = ClientUtils.escapeQueryChars(str);
			escapedKw.add("(titleForIndex:\""+searchStr+"\" description:\""+searchStr+"\" titleForIndex:"+searchStr+" description:"+searchStr+")");
		}
		String area = map.get("area")!=null?map.get("area")[0]:"";
		
		if(!StringUtil.isBlank(area)){
//			area = getAreaNames(area);
			escapedKw.add(" (area_name:"+ClientUtils.escapeQueryChars(area).replace(",", " area_name:")+")");
		}
		String industry =  map.get("industry")!=null?map.get("industry")[0]:"";
		
		if(!StringUtil.isBlank(industry)){
			escapedKw.add( " (category:"+ClientUtils.escapeQueryChars(industry).replace(",", " category:")+")");
		}
		String industryId =  map.get("industryId")!=null?map.get("industryId")[0]:"";
		
		if(!StringUtil.isBlank(industryId)){
			escapedKw.add( " (category:"+codeService.getIndustryName(industryId)+")");
		}
		String type =  map.get("type")!=null?map.get("type")[0]:"";
		
		String typeSearch = "";
		if(!StringUtil.isBlank(type)){
			if(StringUtil.contains(type, "项目")){
				typeSearch += " table_name:XMXX";
			}
			if(StringUtil.contains(type, "中标")){
				typeSearch += " (table_name:ZBXX AND table_name2:ZBGS )";
			}
			if(StringUtil.contains(type, "招标")){
				typeSearch += " (table_name:ZBXX -table_name2:ZBGS )";
			}
			escapedKw.add(" ("+typeSearch+")");
		}
		
		String circle =  map.get("circle")!=null?map.get("circle")[0]:""; 
		if(StringUtil.isNotBlank(circle)){
			String datequery = getDateQuery(circle);
			escapedKw.add(" "+datequery);
		}
		
		String searchString="";
		for(String s:escapedKw){
			searchString+="".equals(searchString)?s:" AND"+s;
		}
		return searchString;
	}
	
	
	/**
	 * 根据id获取地区名称
	 * @param area
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private String getAreaNames(String area){
		String [] areas = area.split(",");
		String areaNames = "";
		for (String string : areas) {
			areaNames+=codeService.getPlaceName(string)+",";
		}
		return areaNames;
	}
	
}
