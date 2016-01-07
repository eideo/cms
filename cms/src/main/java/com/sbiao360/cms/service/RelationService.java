package com.sbiao360.cms.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbiao360.cms.dao.RelationDao;
import com.sbiao360.cms.domain.Company;
import com.sbiao360.cms.domain.Project;
import com.sbiao360.cms.domain.ProjectCompany;
import com.sbiao360.cms.domain.ProjectContacts;
import com.sbiao360.cms.zutil.StringUtil;

@Service("projectService")
public class RelationService {

	@Resource
	private RelationDao relationDao;
	
	public Project getProjectByResourceId(String id){
		return relationDao.getProjectByResourceId(id);
	}
	public Project getProjectByName(String name, Map<String, Object> params){
		params.put("name", name);
		return relationDao.getProjectByName(params);
	}
	public Company getCompanyByName(String name){
		return relationDao.getCompanyByName(name);
	}
	public List<ProjectCompany> selectProjectCompany(String projectId, String companyRole){
		Map<String,Object> map = new HashMap<>();
		map.put("projectId", projectId);
		map.put("companyRole",StringUtil.isBlank(companyRole)?null:companyRole.split(","));
		return relationDao.selectProjectCompany(map);
	}
	
	public List<ProjectContacts> selectProjectContacts(String companyName, String personRole){
		Map<String,Object> map = new HashMap<>();
		map.put("companyName", companyName);
		map.put("personRole", StringUtil.isBlank(personRole)?null:personRole.replaceAll(",", "|"));
		return relationDao.selectProjectContacts(map);
	}
	public List<Project> selectProjectFromCompany(String companyName, String companyRole, Map<String, Object> params){
		params.put("companyName", companyName);
		params.put("companyRole", StringUtil.isBlank(companyRole)?null:companyRole.split(","));
		return relationDao.selectProjectFromCompany(params);
	}
	public PageInfo<Project> initAllProjectCache(int page,int size){
		PageHelper.startPage(page, size);
		List<Project> list = relationDao.selectInitProjects();
		return new PageInfo<Project>(list);
	}
	
	
	@Cacheable(key="#projectId+'project'",value="commonCache")
	public Project getProjectById(String projectId){
		return relationDao.getProjectById(projectId);
	}
	
	public List<ProjectCompany> getCompanyByContact(String contactId,String companyRole){
		Map<String,Object> map = new HashMap<>();
		map.put("contactId", contactId);
		map.put("companyRole", StringUtil.isBlank(companyRole)?null:companyRole.split(","));
		return relationDao.selectCompanyByContact(map);
	}
	
	public Company getCompanyById(String id){
		
		return relationDao.getCompanyById(id);
	}
	public Map<String,Object> getContactsById(String id){
		return relationDao.getContactsById(id);
	}
	
	public List<Map<String,String>> relationSuggest(Map<String, Object> params) {
		List<Map<String,String>> list1= relationDao.relationSuggestCompany(params) ;
		for(Map<String,String> s:list1){
			s.put("type","company");
		}
		List<Map<String,String>> list2= relationDao.relationSuggestProject(params) ;
		for(Map<String,String> s:list2){
			s.put("type","project");
		}
		list1.addAll(list2);
		list1.sort(new MapCompare());
		return (list1!=null&&list1.size()>5)?list1.subList(0, 5):list1;
	}
	
	class MapCompare  implements Comparator<Map<String,String>>{
		@Override
		public int compare(Map<String, String> o1, Map<String, String> o2) {
			return o1.get("name").compareTo(o2.get("name"));
		}
		
	}

	
	/**
	 * 
	 * @param name
	 * @return
	 * @author 廖得宇
	 * 	2016年1月6日
	 */
	public Map<String, List<Map<String, String>>> getCompanyRoles(String name) {
		List<Map<String, String>> personRoles = relationDao.companyPersonRoles(name);
		personRoles = getPersonRoleSingle(personRoles);
		List<Map<String, String>> companyRoles = relationDao.companyProjectType(name);
		Map<String,List<Map<String, String>>> map = new HashMap<>();
		map.put("personRoles", personRoles);
		map.put("companyRoles", companyRoles);
		return map;
	}
	
	
	/**
	 * 
	 * @param name
	 * @return
	 * @author 廖得宇
	 * 	2016年1月6日
	 */
	public Map<String, List<Map<String, String>>> getProjectRoles(String name) {
		List<Map<String, String>> personRoles = relationDao.projectPersonRoles(name);
		personRoles = getPersonRoleSingle(personRoles);
		List<Map<String, String>> companyRoles = relationDao.projectCompanyTypes(name);
		Map<String,List<Map<String, String>>> map = new HashMap<>();
		map.put("personRoles", personRoles);
		map.put("companyRoles", companyRoles);
		return map;
	}
	
	private List<Map<String,String>> getPersonRoleSingle(List<Map<String, String>> personRoles){
		Set<String> s = new HashSet<>();
		for(Map<String, String> m:personRoles){
			String role = m.get("role");
			if(role.contains(",")){
				String []roles = role.split(",");
				for(String r:roles){
					if(StringUtil.isNotBlank(r)){
						s.add(r);
					}
				}
			}else{
				s.add(role);
			}
		}
		List<Map<String,String>> result = new ArrayList<>();
		for(String role:s){
			Map<String,String> m = new HashMap<>();
			m.put("role", role);
			result.add(m);
		}
		return result;
	}
}
