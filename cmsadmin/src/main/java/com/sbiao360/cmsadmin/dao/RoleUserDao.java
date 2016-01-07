package com.sbiao360.cmsadmin.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cmsadmin.model.RoleUser;
import com.sbiao360.core.dao.BaseDao;

/**
 * 角色用户的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class RoleUserDao {

	@Resource
	private BaseDao baseDao;

	public int save(RoleUser roleUser) {
		return this.baseDao.save("RoleUserMapper.insert", roleUser);
	}

	public int deleteByUserId(RoleUser roleUser) {
		return this.baseDao.delete("RoleUserMapper.deleteByPrimaryKey",
				roleUser);
	}
}
