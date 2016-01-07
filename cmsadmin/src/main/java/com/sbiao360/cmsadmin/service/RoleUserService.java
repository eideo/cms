package com.sbiao360.cmsadmin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.RoleUserDao;
import com.sbiao360.cmsadmin.model.RoleUser;

/**
 * 角色用户的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class RoleUserService {

	@Resource
	private RoleUserDao roleUserDao;

	public int save(RoleUser roleUser) {
		return this.roleUserDao.save(roleUser);
	}

	public int deleteByUserId(RoleUser roleUser) {
		return this.roleUserDao.deleteByUserId(roleUser);
	}
}
