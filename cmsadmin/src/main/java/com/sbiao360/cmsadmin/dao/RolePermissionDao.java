package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cmsadmin.model.RolePermission;
import com.sbiao360.core.dao.BaseDao;

/**
 * 角色权限的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class RolePermissionDao {

	@Resource
	private BaseDao baseDao;

	public int save(RolePermission rolePermission) {
		return this.baseDao.save("RolePermissionMapper.insert", rolePermission);
	}

	public int deleteByRoleId(Long id) {
		return this.baseDao.delete("RolePermissionMapper.deleteByRoleId", id);
	}

	public int deleteLikeResourceCode(String resourceCode) {
		return this.baseDao.delete(
				"RolePermissionMapper.deleteLikeResourceCode", resourceCode);
	}

	public List<RolePermission> getListByRoleKey(String roleKey) {
		return this.baseDao.getList("RolePermissionMapper.getListByRoleKey",
				roleKey);
	}

}
