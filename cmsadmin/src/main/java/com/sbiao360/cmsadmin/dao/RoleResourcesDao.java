package com.sbiao360.cmsadmin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cmsadmin.model.RoleResources;
import com.sbiao360.core.dao.BaseDao;

/**
 * 角色权限的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class RoleResourcesDao {

	@Resource
	private BaseDao baseDao;

	public int save(RoleResources roleResources) {
		return this.baseDao.save("RoleResourcesMapper.insert", roleResources);
	}

	public List<RoleResources> getListByRoleKey(String roleKey) {
		return this.baseDao.getList("RoleResourcesMapper.getListByRoleKey",
				roleKey);
	}

	public int deleteByRoleKey(String roleKey) {
		return this.baseDao.delete("RoleResourcesMapper.deleteByRoleKey",
				roleKey);
	}
}
