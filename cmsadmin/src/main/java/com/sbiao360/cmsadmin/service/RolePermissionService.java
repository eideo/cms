package com.sbiao360.cmsadmin.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.RoleDao;
import com.sbiao360.cmsadmin.dao.RolePermissionDao;
import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.cmsadmin.model.RolePermission;

/**
 * 角色权限的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class RolePermissionService {

	@Resource
	private RoleDao roleDao;

	@Resource
	private RolePermissionDao rolePermissionDao;

	public int save(RolePermission rolePermission) {
		return this.rolePermissionDao.save(rolePermission);
	}

	public int deleteByRoleId(Long id) {
		return this.rolePermissionDao.deleteByRoleId(id);
	}

	public int deleteLikeResourceCode(String resourceCode) {
		return this.rolePermissionDao.deleteLikeResourceCode(resourceCode);
	}

	// 保存角色权限
	public void saveRolePermissionList(String roleKey,
			Map<String, String> rolePermissionsMap) {
		Role role = roleDao.getByRoleKey(roleKey);
		Long roleId = role.getId();
		rolePermissionDao.deleteByRoleId(roleId);
		for (Map.Entry<String, String> entry : rolePermissionsMap.entrySet()) {
			String permissions = roleKey + ":" + entry.getKey() + ":"
					+ entry.getValue();
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissions(permissions);
			rolePermissionDao.save(rolePermission);
		}
	}
}
