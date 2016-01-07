package com.sbiao360.cmsadmin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.ResourcesDao;
import com.sbiao360.cmsadmin.dao.RoleResourcesDao;
import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.cmsadmin.model.RoleResources;

/**
 * 角色资源的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class RoleResourcesService {

	@Resource
	private RoleResourcesDao roleResourcesDao;

	@Resource
	private ResourcesDao resourcesDao;

	public List<RoleResources> getListByRoleKey(String roleKey) {
		return this.roleResourcesDao.getListByRoleKey(roleKey);
	}

	public int deleteByRoleKey(String roleKey) {
		return this.roleResourcesDao.deleteByRoleKey(roleKey);
	}

	public void saveRoleResourcesList(String roleKey,
			Map<String, String> roleResourcesMap) {

		roleResourcesDao.deleteByRoleKey(roleKey);

		for (Map.Entry<String, String> entry : roleResourcesMap.entrySet()) {
			Resources resources = resourcesDao
					.getByResourceCode(entry.getKey());
			if (resources.getResourceType().shortValue() == 0
					&& "".equals(entry.getValue()))
				continue;
			RoleResources roleResources = new RoleResources();
			roleResources.setRoleKey(roleKey);
			roleResources.setResourceCode(entry.getKey());
			roleResources.setPermissions("".equals(entry.getValue()) ? null
					: entry.getValue());

			roleResourcesDao.save(roleResources);
		}
	}

}
