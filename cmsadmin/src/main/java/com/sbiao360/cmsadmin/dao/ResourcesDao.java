package com.sbiao360.cmsadmin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.core.dao.BaseDao;

/**
 * 资源的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class ResourcesDao {

	@Resource
	private BaseDao baseDao;

	public int save(Resources resources) {
		return this.baseDao.save("ResourcesMapper.insert", resources);
	}

	public int update(Resources resources) {
		return this.baseDao.update("ResourcesMapper.update", resources);
	}

	public Long getCount(Resources resources) {
		return this.baseDao.getCount("ResourcesMapper.getCount", resources);
	}

	public List<Resources> getList(Resources resources) {
		PageHelper.startPage(resources.getPage(), resources.getRows());
		return this.baseDao.getList("ResourcesMapper.getList", resources);
	}

	public Resources getByPrimaryKey(Long id) {
		return this.baseDao.get("ResourcesMapper.getByPrimaryKey", id);
	}

	public Resources getByResourceCode(String resourceCode) {
		return this.baseDao.get("ResourcesMapper.getByResourceCode",
				resourceCode);
	}

	public List<Resources> getListByMainMenu() {
		return this.baseDao.getList("ResourcesMapper.getListByMainMenu");
	}

	public List<Resources> getListtByParentResourceCode(
			String parentResourceCode) {
		return this.baseDao.getList(
				"ResourcesMapper.getListtByParentResourceCode",
				parentResourceCode);
	}

	public List<Resources> getListAll() {
		return this.baseDao.getList("ResourcesMapper.getListAll");
	}

	public int delete(Long[] ids) {
		int i = 0;
		for (Long id : ids) {
			i += deleteByPrimaryKey(id);
		}
		return i;
	}

	public int deleteByPrimaryKey(Long id) {
		int i = 0;
		i += this.baseDao.delete("RoleResourcesMapper.deleteByResourceId", id);
		i += this.baseDao.delete("RolePermissionMapper.deleteByResourceId", id);
		i += this.baseDao.delete("ResourcesMapper.deleteByPrimaryKey", id);
		return i;
	}

	public boolean existResourceCode(String resourceCode) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("resourceCode", resourceCode);
		Long num = this.baseDao.getCount(
				"ResourcesMapper.getCountByResourceCode", paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean existParentResourceCode(String parentResourceCode) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("parentResourceCode", parentResourceCode);
		Long num = this.baseDao.getCount(
				"ResourcesMapper.getCountByParentResourceCode", paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}
}
