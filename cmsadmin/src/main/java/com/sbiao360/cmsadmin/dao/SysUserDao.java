package com.sbiao360.cmsadmin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.core.dao.BaseDao;

/**
 * 用户的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class SysUserDao {

	@Resource
	private BaseDao baseDao;

	public int save(SysUser sysUser) {
		int i = 0;
		i += this.baseDao.save("SysUserMapper.insert", sysUser);
		i += this.baseDao.save("SysUserMapper.insertRoleUser", sysUser);
		return i;
	}

	public SysUser getByPrimaryKey(Long id) {
		return this.baseDao.get("SysUserMapper.getByPrimaryKey", id);
	}

	public SysUser getByLoginId(String loginId) {
		return this.baseDao.get("SysUserMapper.getByLoginId", loginId);
	}

	public SysUser getByCustEmail(String custEmail) {
		return this.baseDao.get("SysUserMapper.getByCustEmail", custEmail);
	}

	public boolean existLoginId(String loginId) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginId", loginId);
		Long num = this.baseDao.getCount("SysUserMapper.getCountByLoginId",
				paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean existCustEmail(String custEmail) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custEmail", custEmail);
		Long num = this.baseDao.getCount("SysUserMapper.getCountByCustEmail",
				paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean existMobilePhone(String mobilePhone) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mobilePhone", mobilePhone);
		Long num = this.baseDao.getCount("SysUserMapper.getCountByMobilePhone",
				paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	public int update(SysUser sysUser) {
		int i = 0;
		i += this.baseDao.update("SysUserMapper.update", sysUser);
		i += this.baseDao.update("SysUserMapper.updateRoleUser", sysUser);
		return i;
	}

	public int updateByProperties(Map<String, Object> paramMap) {
		return this.baseDao
				.update("SysUserMapper.updateByProperties", paramMap);
	}

	public Long getCount(SysUser sysUser) {
		return this.baseDao.getCount("SysUserMapper.getCount", sysUser);
	}

	public List<SysUser> getList(SysUser sysUser) {
		PageHelper.startPage(sysUser.getPage(), sysUser.getRows());
		return this.baseDao.getList("SysUserMapper.getList", sysUser);
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
		i += this.baseDao.delete("SysUserMapper.deleteRoleUserByUserid", id);
		i += this.baseDao.delete("SysUserMapper.deleteByPrimaryKey", id);
		return i;
	}

}
