package com.sbiao360.cmsadmin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.core.dao.BaseDao;

/**
 * 角色的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class RoleDao {

	@Resource
	private BaseDao baseDao;

	public int save(Role role) {
		return this.baseDao.save("RoleMapper.insert", role);
	}

	public int update(Role role) {
		return this.baseDao.update("RoleMapper.update", role);
	}

	public Role getByPrimaryKey(Long id) {
		return this.baseDao.get("RoleMapper.getByPrimaryKey", id);
	}

	public Role getByRoleKey(String roleKey) {
		return this.baseDao.get("RoleMapper.getByRoleKey", roleKey);
	}

	public boolean existRoleKey(String roleKey) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleKey", roleKey);
		Long num = this.baseDao.getCount("RoleMapper.getCountByRoleKey",
				paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
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
		i += this.baseDao.delete("SysUserMapper.updateRoleUserByRoleid", id);
		i += this.baseDao.delete("RoleResourcesMapper.deleteByRoleId", id);
		i += this.baseDao.delete("RolePermissionMapper.deleteByRoleId", id);
		i += this.baseDao.delete("RoleMapper.deleteByPrimaryKey", id);
		return i;
	}

	public Long getCount(Role role) {
		return this.baseDao.getCount("RoleMapper.getCount", role);
	}

	public List<Role> getList(Role role) {
		PageHelper.startPage(role.getPage(), role.getRows());
		return this.baseDao.getList("RoleMapper.getList", role);
	}

	public List<Role> getDropDownList() {
		return this.baseDao.getList("RoleMapper.getDropDownList");
	}

}
