package com.sbiao360.cmsadmin.security;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.SysUserService;

@Component
public class ShiroSecurityRealm extends AuthorizingRealm {

	@Resource
	private SysUserService sysUserService;

	public ShiroSecurityRealm() {
		setName("ShiroSecurityRealm"); // This name must match the name in the
										// SysUser class's getPrincipals()
										// method
		setCredentialsMatcher(new CustomCredentialsMatcher());
	}

	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		SysUser user = sysUserService.getByLoginId(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getId(),
					user.getLoginPasswd(), getName());
		} else {
			return null;
		}
	}

	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Long userId = (Long) principals.fromRealm(getName()).iterator().next();
		SysUser user = sysUserService.getByPrimaryKey(userId);
		Role role = user.getRole();
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRole(user.getRoleKey());
			info.addStringPermissions(role.getPermissions());
			return info;
		} else {
			return null;
		}
	}

}
