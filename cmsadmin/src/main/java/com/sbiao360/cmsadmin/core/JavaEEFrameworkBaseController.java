package com.sbiao360.cmsadmin.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.core.controller.ExtJSBaseController;
import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * @author yujunwei
 */
public abstract class JavaEEFrameworkBaseController<E extends ExtJSBaseParameter>
		extends ExtJSBaseController<E> implements Constant {

	public SysUser getCurrentSysUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return (SysUser) request.getSession().getAttribute(SESSION_SYS_USER);
	}

}
