package com.sbiao360.cms.zexception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver{

	@Override 
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if(ex instanceof NumberFormatException){
			return new ModelAndView("number");
		}else if (ex instanceof NullPointerException) {
			return new ModelAndView("null");
		}
		return new ModelAndView("exception");
	}

}
