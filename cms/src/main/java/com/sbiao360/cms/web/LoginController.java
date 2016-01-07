package com.sbiao360.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 登录登出（本地）控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class LoginController extends BaseController{
	
	
	/**
	 * ajax登录后的iframe取值
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"toLoginIframe"})
	public String toLoginIframe(HttpServletRequest request,HttpServletResponse response){
		Assertion assertion = AssertionHolder.getAssertion();
		if(assertion!=null){
			String userName = (String) assertion.getPrincipal().getName();
			request.setAttribute("userName", userName);
		}
		return "dialogLogin/loginIframe";
	}
	
	/**
	 * ajax本地退出
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"ajaxLogout"})
	public void ajaxLogout(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION, null);
		request.getSession().setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION, null);
	}
}
