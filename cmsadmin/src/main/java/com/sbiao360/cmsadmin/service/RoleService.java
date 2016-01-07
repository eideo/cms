package com.sbiao360.cmsadmin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.RoleDao;
import com.sbiao360.cmsadmin.model.Role;

/**
 * 角色的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class RoleService {

	@Resource
	private RoleDao roleDao;

	public int save(Role role) {
		return this.roleDao.save(role);
	}

	public int update(Role role) {
		return this.roleDao.update(role);
	}

	public Role getByPrimaryKey(Long id) {
		return this.roleDao.getByPrimaryKey(id);
	}

	public Role getByRoleKey(String roleKey) {
		return this.roleDao.getByRoleKey(roleKey);
	}

	public boolean existRoleKey(String roleKey) {
		return this.roleDao.existRoleKey(roleKey);
	}

	public Long getCount(Role role) {
		return this.roleDao.getCount(role);
	}

	public List<Role> getList(Role role) {
		return this.roleDao.getList(role);
	}

	public int delete(Long[] ids) {
		return this.roleDao.delete(ids);
	}

	public int delete(Long id) {
		return this.roleDao.deleteByPrimaryKey(id);
	}

	public List<Role> getDropDownList() {
		return this.roleDao.getDropDownList();
	}
}
