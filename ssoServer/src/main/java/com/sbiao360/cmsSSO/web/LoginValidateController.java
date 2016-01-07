package com.sbiao360.cmsSSO.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LoginValidateController  extends AbstractController{
	
	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginValidateController.class);
	
	
	
	 /**AJAX输出json，返回null**/
    public String ajaxJson(String json, HttpServletResponse response) {
        return ajax(json, "application/json", response);
    }
    
	 public String ajax(String content, String type, HttpServletResponse response) {
	        try {
	            response.setContentType(type + ";charset=UTF-8");
	            response.setHeader("Pragma", "No-cache");
	            response.setHeader("Cache-Control", "no-cache");
	            response.setDateHeader("Expires", 0);
	            response.getWriter().write(content);
	            response.getWriter().flush();
	        } catch (IOException e) {
	        	LOGGER.error("ajax", e);
	        }
	        return null;
	    }

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String certCode=request.getParameter("certCode");
		if(certCode.equals((String)request.getSession().getAttribute("certCode")))
			ajaxJson("{status:"+true+"}", response);
		else
			ajaxJson("{status:"+false+"}", response);
		return null;
	}
}
