package com.sbiao360.cms.base.interceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.service.CustomerBehaviorService;
import com.sbiao360.cms.zutil.IpTool;

public class CustomerBehaviorInterceptor implements HandlerInterceptor {

	@Resource
	private CustomerBehaviorService customerBehaviorService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long ip = 0L;
		String ipStr = IpTool.getClientAddress(request);
		if (null != ipStr && !"".equals(ipStr)) {
			ip = IpTool.setIP(ipStr);
		}

		Date endDate = new Date();

		Assertion assertion = AssertionHolder.getAssertion();
		Long userId = 0L;
		String custName = "";
		String loginId = "";
		
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();
		}

		if (null != request.getSession().getAttribute("lastDate")
				&& userId.longValue() != 0) {
			Date lastDate = (Date) request.getSession()
					.getAttribute("lastDate");
			String url = (String) request.getSession().getAttribute("lastURL");
			String parameter = (String) request.getSession().getAttribute(
					"lastParameter");
			Long consumeTime = endDate.getTime() - lastDate.getTime();
			String remoteAddr = (String) request.getSession().getAttribute(
					"remoteAddr");

			CustBehavior custBehavior = new CustBehavior();
			custBehavior.setUserId(userId);
			custBehavior.setCustName(custName);
			custBehavior.setLoginId(loginId);
			custBehavior.setIp(ip);
			custBehavior.setActionType((short) 1);
			custBehavior.setActionDate(endDate);
			custBehavior.setUrl(url);
			custBehavior.setParameter(parameter);
			custBehavior.setConsumeTime(consumeTime);
			custBehavior.setRemoteAddr(remoteAddr);
			custBehavior.setInfoValid((short) 1);

			customerBehaviorService.insertCustomerAccessLog(custBehavior);
		}

		request.getSession().setAttribute("lastURL",
				request.getRequestURL().toString());
		request.getSession().setAttribute("lastParameter",
				request.getParameterMap().toString());
		request.getSession().setAttribute("lastDate", endDate);
		request.getSession()
				.setAttribute("remoteAddr", request.getRemoteAddr());
		request.getSession()
				.setAttribute("remoteHost", request.getRemoteHost());
	}
}
