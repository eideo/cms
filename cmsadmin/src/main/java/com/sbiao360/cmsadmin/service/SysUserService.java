package com.sbiao360.cmsadmin.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.AttachmentDao;
import com.sbiao360.cmsadmin.dao.DepartmentDao;
import com.sbiao360.cmsadmin.dao.RoleDao;
import com.sbiao360.cmsadmin.dao.RolePermissionDao;
import com.sbiao360.cmsadmin.dao.SysUserDao;
import com.sbiao360.cmsadmin.model.Attachment;
import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.cmsadmin.model.RolePermission;
import com.sbiao360.cmsadmin.model.SysUser;

/**
 * 用户的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class SysUserService {

	@Resource
	private SysUserDao sysUserDao;

	@Resource
	private AttachmentDao attachmentDao;

	@Resource
	private DepartmentDao departmentDao;

	@Resource
	private RoleDao roleDao;

	@Resource
	private RolePermissionDao rolePermissionDao;

	public int save(SysUser sysUser) {
		return this.sysUserDao.save(sysUser);
	}

	public SysUser getByPrimaryKey(Long id) {
		SysUser sysUser = this.sysUserDao.getByPrimaryKey(id);
		if (null != sysUser) {
			setRole(sysUser);
		}
		return sysUser;
	}

	public SysUser getByLoginId(String loginId) {
		SysUser sysUser = this.sysUserDao.getByLoginId(loginId);
		if (null != sysUser) {
			setRole(sysUser);
		}
		return sysUser;
	}

	public SysUser getByCustEmail(String custEmail) {
		SysUser sysUser = this.sysUserDao.getByCustEmail(custEmail);
		if (null != sysUser) {
			setRole(sysUser);
		}
		return sysUser;
	}

	public boolean existLoginId(String loginId) {
		return this.sysUserDao.existLoginId(loginId);
	}

	public boolean existCustEmail(String custEmail) {
		return this.sysUserDao.existCustEmail(custEmail);
	}

	public boolean existMobilePhone(String mobilePhone) {
		return this.sysUserDao.existMobilePhone(mobilePhone);
	}

	public int update(SysUser sysUser) {
		return this.sysUserDao.update(sysUser);
	}

	public int updateByProperties(Map<String, Object> paramMap) {
		return this.sysUserDao.updateByProperties(paramMap);
	}

	public Long getCount(SysUser sysUser) {
		return this.sysUserDao.getCount(sysUser);
	}

	public List<SysUser> getList(SysUser sysUser) {
		return this.sysUserDao.getList(sysUser);
	}

	public int delete(Long[] ids) {
		return this.sysUserDao.delete(ids);
	}

	public int delete(Long id) {
		return this.sysUserDao.deleteByPrimaryKey(id);
	}

	public void setFilePath(SysUser sysuser) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("type", (short) 1);
		paramMap.put("typeId", sysuser.getId());
		Attachment attachment = attachmentDao.getByProperties(paramMap);
		if (null != attachment && !"".equals(attachment.getFilePath())) {
			sysuser.setFilePath(attachment.getFilePath());
		} else {
			sysuser.setFilePath("/static/assets/avatars/profile-pic.jpg");
		}

	}

	public void setRole(SysUser sysUser) {
		Set<String> permissions = new HashSet<String>();
		Role role = this.roleDao.getByRoleKey(sysUser.getRoleKey());
		if (null != role) {
			List<RolePermission> rolePermissionList = rolePermissionDao
					.getListByRoleKey(sysUser.getRoleKey());
			for (RolePermission rolePermission : rolePermissionList) {
				permissions.add(rolePermission.getPermissions());
			}
			role.setPermissions(permissions);
			sysUser.setRole(role);
		}
	}

}
