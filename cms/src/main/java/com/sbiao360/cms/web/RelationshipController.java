package com.sbiao360.cms.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.common.util.Hash;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.sbiao360.cms.domain.Company;
import com.sbiao360.cms.domain.Project;
import com.sbiao360.cms.domain.ProjectCompany;
import com.sbiao360.cms.domain.ProjectContacts;
import com.sbiao360.cms.service.CodeService;
import com.sbiao360.cms.service.RelationService;
import com.sbiao360.cms.zutil.DateTime;
import com.sbiao360.cms.zutil.StringUtil;
import com.sbiao360.cms.zutil.Tools;

/**
 * 关系网控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class RelationshipController extends BaseController{

	@Resource
	private RelationService relationService;
	
	@Resource
	private CodeService codeService;
	
	/**
	 * 获取关系网初始化数据
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/getRelation"})
	public void getRelation(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String companyRole = request.getParameter("companyRole");
		String personRole = request.getParameter("personRole");
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		String jsonString = null;
		Map<String,List<Map<String,String>>> map = new HashMap<>();
		//组装后的result开始遍历
		List<Map<String,String>> objectList = new ArrayList<>();
		List<Map<String,String>> linkList = new ArrayList<>();
		Set<String> allKey = new HashSet<>();
		map.put("objectList", objectList);
		map.put("linkList", linkList);
		Map<String,Object> params = new HashMap<>();
		if(StringUtil.isNotBlank(startDate)){
			params.put("startDate", startDate+"01");
		}
		if(StringUtil.isNotBlank(endDate)){
			Date end = DateTime.parseDate(endDate+"01", "yyyyMMdd");
			end.setMonth(end.getMonth()+1);
			params.put("endDate", DateTime.toDate("yyyyMMdd", end));
		}
		
			
		//取出根项目
		Project project = relationService.getProjectByName(name,params);
		if(project==null){
			//单位
			Company company = relationService.getCompanyByName(name);
			if(company==null){
				ajaxJson(JSON.toJSONString(map), response);
				return;
			}
			Map<String,String> mapChild = new HashMap<>();
			mapChild.put("name", company.getCompanyName());
			mapChild.put("type", "company");
			mapChild.put("dataId",company.getId());
			mapChild.put("uniqId", "0");
			objectList.add(mapChild);
			getAllRelation(map, allKey, companyRole, personRole, 0,0,params,0);
		}else{
			Map<String,String> mapChild = new HashMap<>();
			mapChild.put("name", project.getProjectName());
			mapChild.put("type", "project");
			mapChild.put("dataId",project.getId());
			mapChild.put("uniqId", "0");
			objectList.add(mapChild);
			getAllRelation(map, allKey, companyRole, personRole, 0,0,params,0);
		}
			
			
		jsonString = JSON.toJSONString(map);
		ajaxJson(jsonString, response);
	}
	
	/**
	 * 递归查询出关系网子节点与连接
	 * @param result
	 * @param allKey
	 * @param companyRole
	 * @param personRole
	 * @param lastSize
	 */
	private void getAllRelation(Map<String,List<Map<String,String>>> result,Set<String> allKey,String companyRole,String personRole,int lastSize,int baseuniqId,Map<String,Object> params,int level){
		//组装后的result开始遍历
		List<Map<String,String>> objectList = result.get("objectList");
		List<Map<String,String>> linkList = result.get("linkList");
		int k = lastSize;
		int nowSize = objectList.size();
		for (int j=lastSize;j<nowSize;j++) {
			Map<String, String> map  = objectList.get(j);
			String type = map.get("type");
			String dataId = map.get("dataId");
			String uniqId = map.get("uniqId");
			allKey.add(type+dataId);
			if(type.equals("company")){
				//取出根单位的项目
				List<Project> listProject = relationService.selectProjectFromCompany(map.get("name"),companyRole,params);
				for (Project project : listProject) {
					if(allKey.contains("project"+project.getId())){
						continue;
					}else{
						allKey.add("project"+project.getId());
					}
					Map<String,String> mapChild = new HashMap<>();
					mapChild.put("name", project.getProjectName());
					mapChild.put("type", "project");
					mapChild.put("dataId",project.getId());
					mapChild.put("uniqId", objectList.size()+baseuniqId+"");
					objectList.add(mapChild);
					Map<String,String> mapLink= new HashMap<String,String>();
					mapLink.put("source", uniqId);
					mapLink.put("target",mapChild.get("uniqId") );
					linkList.add(mapLink);
				}
				//取出根单位的人
				List<ProjectContacts> listContacts = relationService.selectProjectContacts(map.get("name"),personRole);
				for (ProjectContacts contacts : listContacts) {
					if(allKey.contains("person"+contacts.getContactsId())){
						continue;
					}else{
						allKey.add("person"+contacts.getContactsId());
					}
					Map<String,String> mapChild = new HashMap<>();
					mapChild.put("name", contacts.getContactsName());
					mapChild.put("type", "person");
					mapChild.put("dataId",contacts.getContactsId());
					mapChild.put("uniqId", objectList.size()+baseuniqId+"");
					objectList.add(mapChild);
					Map<String,String> mapLink= new HashMap<String,String>();
					mapLink.put("source", uniqId);
					mapLink.put("target",mapChild.get("uniqId") );
					linkList.add(mapLink);
				}
			}else if(type.equals("project")){
				//取出根项目的所有单位
				List<ProjectCompany> listCompanys = relationService.selectProjectCompany(dataId,companyRole);
				for (ProjectCompany company : listCompanys) {
					if(allKey.contains("company"+company.getCompanyId())){
						continue;
					}else{
						allKey.add("company"+company.getCompanyId());
					}
					Map<String,String> mapChild = new HashMap<>();
					mapChild.put("name", company.getCompanyName());
					mapChild.put("type", "company");
					mapChild.put("dataId",company.getCompanyId());
					mapChild.put("uniqId", objectList.size()+"");
					objectList.add(mapChild);
					Map<String,String> mapLink= new HashMap<String,String>();
					mapLink.put("source", uniqId);
					mapLink.put("target",mapChild.get("uniqId") );
					linkList.add(mapLink);
				}
			}else{
				//取出人的所有单位
				List<ProjectCompany> listCompanys =  relationService.getCompanyByContact(dataId, companyRole);
				for (ProjectCompany company : listCompanys) {
					if(allKey.contains("company"+company.getCompanyId())){
						continue;
					}else{
						allKey.add("company"+company.getCompanyId());
					}
					Map<String,String> mapChild = new HashMap<>();
					mapChild.put("name", company.getCompanyName());
					mapChild.put("type", "company");
					mapChild.put("dataId",company.getCompanyId());
					mapChild.put("uniqId", objectList.size()+baseuniqId+"");
					objectList.add(mapChild);
					Map<String,String> mapLink= new HashMap<String,String>();
					mapLink.put("source", uniqId);
					mapLink.put("target",mapChild.get("uniqId") );
					linkList.add(mapLink);
				}
			}
		}
		if(nowSize==objectList.size()||objectList.size()>100){
			return;
		}
		getAllRelation(result, allKey, personRole, personRole, nowSize,baseuniqId,params,level+1);
	}
	
	
	/**
	 * 根据节点ID查询出关系网数据
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/getRelationByNode"})
	public void getRelationByNode(HttpServletRequest request,HttpServletResponse response){
		String nodeId = request.getParameter("dataId");
		String type = request.getParameter("type");
		String companyRole = request.getParameter("companyRole");
		String personRole = request.getParameter("personRole");
		String lastUniqId = request.getParameter("lastUniqId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int i = Integer.parseInt(lastUniqId);
		Map<String,List<Map<String,String>>> map = new HashMap<>();
		//组装后的result开始遍历
		List<Map<String,String>> objectList = new ArrayList<>();
		List<Map<String,String>> linkList = new ArrayList<>();
		Set<String> allKey = new HashSet<>();
		map.put("objectList", objectList);
		map.put("linkList", linkList);
		
		Map<String,Object> params = new HashMap<>();
		if(StringUtil.isNotBlank(startDate)){
			params.put("startDate", startDate+"01");
		}
		if(StringUtil.isNotBlank(endDate)){
			Date end = DateTime.parseDate(endDate+"01", "yyyyMMdd HH:mm:ss");
			end.setMonth(end.getMonth()+1);
			params.put("endDate", DateTime.toDate("yyyyMMdd HH:mm:ss", end));
		}
		//项目
		if(type.equals("0")){
			Project project = relationService.getProjectById(nodeId);
			Map<String,String> mapChild = new HashMap<>();
			mapChild.put("name", project.getProjectName());
			mapChild.put("type", "project");
			mapChild.put("dataId",project.getId());
			mapChild.put("uniqId", i+"");
			objectList.add(mapChild);
			getAllRelation(map, allKey, companyRole, personRole, 0,i,params,0);
		}
		//单位
		else if(type.equals("1")){
			Company company = relationService.getCompanyById(nodeId);
			Map<String,String> mapChild = new HashMap<>();
			mapChild.put("name", company.getCompanyName());
			mapChild.put("type", "company");
			mapChild.put("dataId",company.getId());
			mapChild.put("uniqId", i+"");
			objectList.add(mapChild);
			getAllRelation(map, allKey, companyRole, personRole, 0,i,params,0);
		}
		//个人
		else{
			Map<String, Object> map1 = relationService.getContactsById(nodeId);
			Map<String,String> mapChild = new HashMap<>();
			mapChild.put("name", (String)map1.get("name"));
			mapChild.put("type", "person");
			mapChild.put("dataId",nodeId);
			mapChild.put("uniqId", i+"");
			objectList.add(mapChild);
			getAllRelation(map, allKey, companyRole, personRole, 0,i,params,0);
		}
		objectList.remove(0);
		ajaxJson(JSON.toJSONString(map), response);
	}
	
	
	/**
	 * 获取节点详情
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/getRelationDetail"})
	public void getRelationDetail(HttpServletRequest request,HttpServletResponse response){
		String dataId =request.getParameter("id");
		String type = request.getParameter("type");
		Map<String, Object> map = new HashMap<>();
		//项目
		if(type.equals("project")){
			Project project = relationService.getProjectById(dataId);
			map.put("name", project.getProjectName());
			map.put("alias", project.getProjectAlias());
			map.put("address",codeService.getPlaceName(StringUtil.indexOf(project.getAreaId(),"-")<0?"":project.getAreaId().split("-")[0].replace(",", "")));
			 DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
			map.put("total",project.getTotalInvest()==null?"":decimalFormat.format(project.getTotalInvest()));
		}
		//单位
		else if(type.equals("company")){
			Company company = relationService.getCompanyById(dataId);
			map.put("name", company.getCompanyName());
			map.put("address",Tools.getAreaByLocation(company.getAddress())+"XXXXXXXXXXXXXXXX");
			map.put("phone", StringUtil.isBlank(company.getPhone())?"":(company.getPhone().length()>6?company.getPhone().substring(0, 6)+"XXXXX":"XXXXXXXX"));
		}
		//个人
		else{
			Map<String,Object> mapPerson = relationService.getContactsById(dataId);
			String name = (String) mapPerson.get("name");
			String cellphone = (String) mapPerson.get("cellphone");
			cellphone = StringUtil.isBlank(cellphone)?"":(cellphone.length()>2?cellphone.substring(0, 3):cellphone);
			String address = (String)mapPerson.get("address");
			String email = (String)mapPerson.get("email");
			String service = (StringUtil.isNotBlank(email)&&email.indexOf("@")>0)?email.split("@")[1]:"";
			email = StringUtil.isBlank(email)?"":(email.length()>2?email:email.substring(0, 3));

			map.put("name", name);
			map.put("cellphone",cellphone+"XXXXXXXX");
			map.put("address", Tools.getAreaByLocation(address)+"XXXXXXXXXXXXXXXX");
			map.put("email", email+"XXXXXXX"+service);
		}
		ajaxJson(JSON.toJSONString(map), response);
	}
	
	
	/**
	 * 跳转至关系网页面
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/relation"})
	public String toRelation(HttpServletRequest request,HttpServletResponse response){
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			request.setAttribute("username", assertion.getPrincipal().getName());
		}
		request.setAttribute("notSearch", "true");
		request.setAttribute("notFooter", "true");
		return "relation";
	}
	
	
	/**
	 * 关系网检索建议
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/relationSuggest"})
	public void getRelationSuggest(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		Map<String,Object> params = new HashMap<>();
		if(StringUtil.isNotBlank(startDate)){
			params.put("startDate", startDate+"01");
		}
		if(StringUtil.isNotBlank(endDate)){
			Date end = DateTime.parseDate(endDate+"01", "yyyyMMdd HH:mm:ss");
			end.setMonth(end.getMonth()+1);
			params.put("endDate", DateTime.toDate("yyyyMMdd HH:mm:ss", end));
		}
		params.put("name", name);
		List<Map<String, String>> s = relationService.relationSuggest(params);
		ajaxJson(JSON.toJSONString(s), response);
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月5日
	 */
	@RequestMapping({"/getRelationRoles"})
	public void getRelationRoles(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		if("company".equals(type)){
			Map<String,List<Map<String,String>>> map =  relationService.getCompanyRoles(name);
			ajaxJson(JSON.toJSONString(map), response);
		}else if("project".equals(type)){
			Map<String,List<Map<String,String>>> map =  relationService.getProjectRoles(name);
			ajaxJson(JSON.toJSONString(map), response);
		}
		
	}
	
	/**
	 * 获取推荐行业项目名称
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"/getRecommProject"})
	public void selectRecommProject(HttpServletRequest request,HttpServletResponse response){
		String industry = request.getParameter("industryId");
		Map<String,String> map = relationService.selectRecommProject(industry);
		ajaxJson(JSON.toJSONString(map), response);
	}
}
