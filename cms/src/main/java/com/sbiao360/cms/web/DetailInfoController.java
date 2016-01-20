package com.sbiao360.cms.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.sbiao360.cms.domain.IndexInfo;
import com.sbiao360.cms.domain.PublishInfo;
import com.sbiao360.cms.service.CustomerKeywordsService;
import com.sbiao360.cms.service.IndexInfoService;
import com.sbiao360.cms.service.PublishInfoService;
import com.sbiao360.cms.zutil.StringUtil;

@Controller
public class DetailInfoController extends BaseController{

	@Resource
	private PublishInfoService publishInfoService;

	@Resource
	private CustomerKeywordsService customerKeywordsService;

	@Resource
	private IndexInfoService indexInfoService;
	/**
	 * 查看详情
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/detail/{id}", method = {RequestMethod.GET})
	public String getDetailInfo(HttpServletRequest request,
			HttpServletResponse response,@PathVariable(value="id")String id) {
		PublishInfo publishInfo = null;
		if(!id.contains("-")){
			publishInfo = publishInfoService.selectByPrimaryKey(id);
			request.setAttribute("infoType", "xmxx");
		}else{
			String []idtype = id.split("-");
			//中标公示
			if(idtype[0].equals("zbgs")){
				publishInfo = publishInfoService.selectByZBGSPrimaryKey(idtype[1]);
			}
			//招标公告
			else if(idtype[0].equals("zbgg")){
				publishInfo = publishInfoService.selectByZBGGPrimaryKey(idtype[1]);
			}
			else if(idtype[0].equals("cgxx")){
				publishInfo = publishInfoService.selectByCGGXXPrimaryKey(idtype[1]);
			}
		}
		
		//验证是否是html
		String description = publishInfo.getDescription();
		if (!(description.indexOf("<")==0&&description.lastIndexOf(">")==(description.length()-1))) {
			
			description = "<p style=\"font-size:14px;\">"
					+ description.replaceAll("\r\n",
							"</p><p style=\"font-size:14px;\">") + "</p>";
			publishInfo.setDescription(description);
		}
		request.setAttribute("publishInfo", publishInfo);
		request.setAttribute("hotKeyWords",
				customerKeywordsService.getHotKeyWordsList());
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("notSearch", "true");
		return "/detail";
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getRecomInfo")
	public void getRecomInfo(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("infoid");
		String showType = request.getParameter("showType");
		PublishInfo publishInfo = null;
		List<IndexInfo> result = new ArrayList<>();
		if(!id.contains("-")){
			publishInfo = publishInfoService.selectByPrimaryKey(id);
			String title= cutXMXXTitle(publishInfo.getTitle());
			result = getRecomm(publishInfo,title,showType);
		}else{
			String []idtype = id.split("-");
			//中标公示
			if(idtype[0].equals("zbgs")){
				publishInfo = publishInfoService.selectByZBGSPrimaryKey(idtype[1]);
				String title= cutZBGSTitle(publishInfo.getTitle());
				result = getRecomm(publishInfo,title,showType);
			}
			//招标公告
			else if(idtype[0].equals("zbgg")){
				publishInfo = publishInfoService.selectByZBGGPrimaryKey(idtype[1]);
				String title= cutZBGGTitle(publishInfo.getTitle());
				result = getRecomm(publishInfo,title,showType);
			}
			else if(idtype[0].equals("cgxx")){
				publishInfo = new PublishInfo();
			}
		}
		ajaxJson(JSON.toJSONString(result), response);
	}
	
	public List<IndexInfo> getRecomm(PublishInfo publishInfo,String title,String showType){
		
		String typeSearch = "";
		if(showType.equals("0")){
			typeSearch=" table_name:XMXX";
		}
		else if(showType.equals("1")){
			typeSearch += " (table_name:ZBXX -table_name2:ZBGS )";
		}
		else if(showType.equals("2")){
			typeSearch += " (table_name:ZBXX AND table_name2:ZBGS )";
		}
		else if(showType.equals("3")){
			typeSearch += " (table_name:ZFCG)";
		}
		
		String areaName = publishInfo.getAreaName().indexOf(",")==0?publishInfo.getAreaName().substring(1).replaceAll(","," "):publishInfo.getAreaName().replaceAll(","," ");
		String areaSearch = "((area_name:"+areaName+")^10000 or (-area_name:"+areaName+")^1)";
		
		String industryName = publishInfo.getIndustryName().indexOf(",")==0?publishInfo.getIndustryName().substring(1).replaceAll(","," "):publishInfo.getIndustryName().replaceAll(","," ");
		String industrySearch = "((category:"+industryName.replace(" "," or  category:" )+")^1000 or (-category:"+industryName.replace(" "," or -category:" )+")^1)";
		
		String titleSearch = "titleForIndex:\""+title+"\"";
		
		
		String searchString = titleSearch+" AND "+typeSearch+" AND "+areaSearch+" AND "+industrySearch;
		
		Map<String, Object> s = indexInfoService.queryIndexInfo(searchString, 0, 5);
		List<IndexInfo> result = (List<IndexInfo>) s.get("result");
		if(result.size()<5){
			searchString = "titleForIndex:"+title+" AND "+typeSearch+" AND "+areaSearch+" AND "+industrySearch;
			List<IndexInfo> reList = (List<IndexInfo>) indexInfoService.queryIndexInfo(searchString, 0, 5-result.size()).get("result");
			result.addAll(reList);
		}
		for (IndexInfo indexInfo : result) {
			indexInfo.setTitle(indexInfo.getTitle().replaceAll("<[^>]*>",""));
		}
		return result;
	}
	
	
	private String cutXMXXTitle(String title){
		title = title.replace("的", "").replace("项目", "").replace("工程", "").replace("（", "(").replace("）", ")");
		while(title.indexOf("(")!=-1){
			title =title.replace(title.substring(title.indexOf("("),title.indexOf(")")==-1?title.length():(title.indexOf(")")+1)), "");
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
	private String cutZBGGTitle(String title){
		String word = "评标、招标、变更、资格预审、补充、延期开标、延长报名时间、竞争性谈判、比选、单一来源采购";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|总承包的|公告|二次|【变更】|重新招标]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
	private String cutZBGSTitle(String title){
		String word = "中标、评标、变更、补充、竞争性谈判、比选";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|结果公示|总承包的|公告|二次]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
	
}
