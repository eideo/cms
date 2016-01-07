package com.sbiao360.cmsadmin.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.ResourcesDao;
import com.sbiao360.cmsadmin.dao.RolePermissionDao;
import com.sbiao360.cmsadmin.dao.RoleResourcesDao;
import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.cmsadmin.model.RolePermission;
import com.sbiao360.cmsadmin.model.RoleResources;

/**
 * 资源的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class ResourcesService {

	@Resource
	private ResourcesDao resourcesDao;

	@Resource
	private RoleResourcesDao roleResourcesDao;

	@Resource
	private RolePermissionDao rolePermissionDao;

	public int save(Resources resources, String roleKey) {
		int i = 0;
		i += this.resourcesDao.save(resources);
		RoleResources roleResources = new RoleResources();
		roleResources.setRoleKey("ROLE_ADMIN");
		roleResources.setResourceCode(resources.getResourceCode());
		String permissions = null;
		if (resources.getResourceType() == 0) {
			permissions = resources.getOperAuthority();
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(1L);
			rolePermission.setPermissions("ROLE_ADMIN:"
					+ resources.getResourceCode() + ":"
					+ resources.getOperAuthority());
			i += this.rolePermissionDao.save(rolePermission);
		}
		roleResources.setPermissions(permissions);
		i += roleResourcesDao.save(roleResources);
		if ("ROLE_RESTRICTED_ADMIN".equals(roleKey)) {
			roleResources.setRoleKey(roleKey);
			roleResources.setResourceCode(resources.getResourceCode());
			if (resources.getResourceType() == 0) {
				permissions = resources.getOperAuthority();
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleId(2L);
				rolePermission.setPermissions(roleKey + ":"
						+ resources.getResourceCode() + ":"
						+ resources.getOperAuthority());
				i += this.rolePermissionDao.save(rolePermission);
			}
			roleResources.setPermissions(permissions);
			i += roleResourcesDao.save(roleResources);
		}
		return i;
	}

	public int update(Resources resources) {
		return this.resourcesDao.update(resources);
	}

	public Long getCount(Resources resources) {
		return this.resourcesDao.getCount(resources);
	}

	public List<Resources> getList(Resources resources) {
		return this.resourcesDao.getList(resources);
	}

	public Resources getByPrimaryKey(Long id) {
		return this.resourcesDao.getByPrimaryKey(id);
	}

	public Resources getByResourceCode(String resourceCode) {
		return this.resourcesDao.getByResourceCode(resourceCode);
	}

	public List<Resources> getListByMainMenu() {
		return this.resourcesDao.getListByMainMenu();
	}

	public List<Resources> getListtByParentResourceCode(
			String parentResourceCode) {
		return this.resourcesDao
				.getListtByParentResourceCode(parentResourceCode);
	}

	public List<Resources> getListAll() {
		return this.resourcesDao.getListAll();
	}

	public int delete(Long[] ids) {
		return this.resourcesDao.delete(ids);
	}

	public int delete(Long id) {
		return this.resourcesDao.deleteByPrimaryKey(id);
	}

	public boolean existResourceCode(String resourceCode) {
		return this.resourcesDao.existResourceCode(resourceCode);
	}

	public boolean existParentResourceCode(String parentResourceCode) {
		return this.resourcesDao.existParentResourceCode(parentResourceCode);
	}

	// 获取一级菜单和二级菜单
	public List<Resources> getListMainMenu(String globalRoleKey,
			List<Resources> mainMenuList) {
		List<RoleResources> roleAuthorityList = roleResourcesDao
				.getListByRoleKey(globalRoleKey);
		List<String> menuCodeList = new ArrayList<String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			menuCodeList.add(roleAuthorityList.get(j).getResourceCode());
		}
		List<Resources> authorityList = new ArrayList<Resources>();
		for (Resources entity : mainMenuList) {
			Resources authority = new Resources();
			authority.setId(entity.getId());
			authority.setResourceCode(entity.getResourceCode());
			authority.setResourceName(entity.getResourceName());
			authority.setResourceClass(entity.getResourceClass());
			authority.setResourceUrl(entity.getResourceUrl());
			authority.setSequence(entity.getSequence());
			authority.setParentResourceCode(entity.getParentResourceCode());
			authority.setResourceType(entity.getResourceType());
			authority.setResourceTypeCn(entity.getResourceTypeCn());
			authority.setStatus(entity.getStatus());
			authority.setStatusCn(entity.getStatusCn());
			List<Resources> subAuthorityList = resourcesDao
					.getListtByParentResourceCode(entity.getResourceCode());
			List<Resources> resultSubAuthorityList = new ArrayList<Resources>();
			for (int i = 0; i < subAuthorityList.size(); i++) {
				if (menuCodeList.contains(subAuthorityList.get(i)
						.getResourceCode())) {
					Resources subAuthority = subAuthorityList.get(i);
					resultSubAuthorityList.add(subAuthority);
				}
			}
			authority.setSubAuthorityList(resultSubAuthorityList);
			if (subAuthorityList.size() == 0) {
				authorityList.add(null);
			} else {
				authorityList.add(authority);
			}
		}
		return authorityList;
	}

}
