package com.sbiao360.sys.cache;

import java.util.List;
import java.util.Timer;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;

import com.github.pagehelper.PageInfo;
import com.sbiao360.cms.domain.Code;
import com.sbiao360.cms.domain.KeywordsDict;
import com.sbiao360.cms.domain.Project;
import com.sbiao360.cms.service.CodeService;
import com.sbiao360.cms.service.CustomerKeywordsService;
import com.sbiao360.cms.service.RelationService;
import com.sbiao360.sys.cache.base.RedisCache;

import org.springframework.context.annotation.Lazy;

@Lazy(true)
public class CacheInitListener implements InitializingBean {

	@Resource
	private RelationService projectService;
	
	@Resource
	private CustomerKeywordsService customerKeywordsService;
	
	@Resource
	private CodeService codeService;
	
	private RedisCache cache;
	
	private MapTimer mapTimer;
	
	@Override
	public void afterPropertiesSet() throws Exception {
//		PageInfo<Project> page= projectService.initAllProjectCache(0,1000);
//		putAllProjectCache(page);
		List<KeywordsDict> listKeywords = customerKeywordsService.getHotKeyWordsList();
		cache.put("hotwords", listKeywords);
//		putPlaceCodeList();
		Timer timer = new Timer(); 
	    timer.schedule(getMapTimer(), 800,800);
	}
	
	private void putPlaceCodeList(){
		List<Code> list = codeService.getPlaceByParentCode(null);
		cache.put("nullplaceList", list);
		list.parallelStream().forEach(code->{
			cache.put(code.getCode()+"placeInfo", code.getName());
			List<Code> listChild = codeService.getPlaceByParentCode(null);
			cache.put(code.getCode()+"placeList", listChild);
			listChild.parallelStream().forEach(code1->cache.put(code1.getCode()+"placeInfo", code1.getName()));
			});
	}
	private void putAllProjectCache(PageInfo<Project> page){
		List<Project> list = page.getList();
		list.parallelStream().forEach(project->cache.put(project.getId()+"project", project));
		if(!page.isIsLastPage()){
			PageInfo<Project> pageNext= projectService.initAllProjectCache(page.getNextPage(),1000);
			putAllProjectCache(pageNext);
		}
	}
	
	
	public RelationService getProjectService() {
		return projectService;
	}

	public void setProjectService(RelationService projectService) {
		this.projectService = projectService;
	}


	public RedisCache getCache() {
		return cache;
	}

	public void setCache(RedisCache cache) {
		this.cache = cache;
	}

	public MapTimer getMapTimer() {
		return mapTimer;
	}

	public void setMapTimer(MapTimer mapTimer) {
		this.mapTimer = mapTimer;
	}
	
}
