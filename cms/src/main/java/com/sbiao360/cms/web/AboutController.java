package com.sbiao360.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于页面控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class AboutController {
	/**
	 * 跳转至关于界面
	 * @param request
	 * @param response
	 * @return 
	 * 		String 
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"about"})
	public String toAbout(HttpServletRequest request,HttpServletResponse response){
		return "about";
		
	}
	
	/**
	 * 建设中
	 * @param request
	 * @param response
	 * @return 
	 * 		String 
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping({"construction"})
	public String toConstruction(HttpServletRequest request,HttpServletResponse response){
		return "construction";
		
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"topservice"})
	public String topService(HttpServletRequest request,HttpServletResponse response){
		return "topService";
		
	}
}
