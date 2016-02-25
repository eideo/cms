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
import com.sbiao360.cms.zutil.CutTitle;
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
				publishInfo = publishInfoService.selectByCGXXPrimaryKey(idtype[1]);
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
			String title= CutTitle.cutXMXXTitle(publishInfo.getTitle());
			result = getRecomm(publishInfo,title,showType);
		}else{
			String []idtype = id.split("-");
			//中标公示
			if(idtype[0].equals("zbgs")){
				publishInfo = publishInfoService.selectByZBGSPrimaryKey(idtype[1]);
				String title= CutTitle.cutZBGSTitle(publishInfo.getTitle());
				result = getRecomm(publishInfo,title,showType);
			}
			//招标公告
			else if(idtype[0].equals("zbgg")){
				publishInfo = publishInfoService.selectByZBGGPrimaryKey(idtype[1]);
				String title= CutTitle.cutZBGGTitle(publishInfo.getTitle());
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
	
	
	
	
}
