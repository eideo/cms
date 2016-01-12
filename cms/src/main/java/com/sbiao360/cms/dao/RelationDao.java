package com.sbiao360.cms.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.Company;
import com.sbiao360.cms.domain.Project;
import com.sbiao360.cms.domain.ProjectCompany;
import com.sbiao360.cms.domain.ProjectContacts;
import com.sbiao360.cms.zutil.DateTime;

@Repository
public class RelationDao {

	@Resource
	private BaseDao baseDao;
	
	public Project getProjectByResourceId(String id){
		return this.baseDao.get("relationMapper.getProjectByResourceId", id);
	}
	
	public List<ProjectCompany> selectProjectCompany(Map<String, Object> map){
		return this.baseDao.getList("relationMapper.selectProjectCompany", map);
	}
	
	public List<ProjectContacts> selectProjectContacts(Map<String, Object> map){
		return this.baseDao.getList("relationMapper.selectProjectContacts", map);
	}
	
	public List<Project> selectProjectFromCompany(Map<String, Object> map){
		return this.baseDao.getList("relationMapper.selectProjectFromCompany", map);
	}
	
	public List<Map<String,Object>> selectProjectIndustry1Group(){
		return this.baseDao.getList("relationMapper.selectProjectIndustry1Group");
	}
	public List<Map<String,Object>> selectProjectIndustry2Group(String industryId){
		return this.baseDao.getList("relationMapper.selectProjectIndustry2Group",industryId);
	}
	public List<Map<String,Object>> selectProjectArea1Group(){
		return this.baseDao.getList("relationMapper.selectProjectArea1Group");
	}
	public List<Map<String,Object>> selectProjectArea2Group(){
		return this.baseDao.getList("relationMapper.selectProjectArea2Group");
	}
	public List<Map<String,Object>> selectProjectCompanyTypeGroup(){
		return this.baseDao.getList("relationMapper.selectProjectCompanyTypeGroup");
	}

	public List<Project> selectInitProjects() {
		 return this.baseDao.getList("relationMapper.selectInitProjects");
	}
	
	public Project getProjectById(String projectId){
		return this.baseDao.get("relationMapper.getProjectById", projectId);
	}

	public Project getProjectByName(Map<String, Object> params) {
		return this.baseDao.get("relationMapper.getProjectByName", params);
	}

	public Company getCompanyByName(String name) {
		return this.baseDao.get("relationMapper.getCompanyByName", name);
	}

	public List<ProjectCompany> selectCompanyByContact(Map<String, Object> map) {
		return this.baseDao.getList("relationMapper.selectCompanyByContact", map);
	}

	public Map<String, Object> getContactsById(String id) {
		return this.baseDao.get("relationMapper.getContactsById", id);
	}

	public Company getCompanyById(String id) {
		return this.baseDao.get("relationMapper.getCompanyById", id);
	}
	public List<Map<String,String>> relationSuggestCompany(Map<String, Object> params) {
		return this.baseDao.getList("relationMapper.relationSuggestCompany", params);
	}
	public List<Map<String,String>> relationSuggestProject(Map<String, Object> params) {
		return this.baseDao.getList("relationMapper.relationSuggestProject", params);
	}
	
	public List<Map<String,String>> projectCompanyTypes(String name){
		
		return this.baseDao.getList("relationMapper.projectCompanyTypes", name);
	}
	public List<Map<String,String>> projectPersonRoles(String name){
		
		return this.baseDao.getList("relationMapper.projectPersonRoles", name);
	}
	public List<Map<String,String>> companyProjectType(String name){
		
		return this.baseDao.getList("relationMapper.companyProjectType", name);
	}
	public List<Map<String,String>> companyPersonRoles(String name){
		return this.baseDao.getList("relationMapper.companyPersonRoles", name);
	}
	
	public Map<String,String> selectRecommProject(String industryId){
		Map<String,String > map = new HashMap<>();
		map.put("industryId", industryId);
		Date d = new Date();
		d.setYear(d.getYear()-1);
		map.put("startDate", DateTime.toDate(null,d));
		return this.baseDao.get("relationMapper.selectRecommProject",map);
	}
}
