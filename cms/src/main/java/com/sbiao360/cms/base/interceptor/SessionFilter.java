package com.sbiao360.cms.base.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sbiao360.cms.base.cons.CommonConstants;

/**
 * 登录请求拦截器，所有请求都将经过这里
 * 创建人：Marlon Li <br>
 * 创建时间：2015-1-7 <br>
 */
public class SessionFilter implements Filter {

 @Override
 public void destroy() {}

 @Override
 public void doFilter(ServletRequest re, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
  HttpServletRequest request = (HttpServletRequest) re;
  HttpSession session = request.getSession();
  if( session == null || session.getAttribute(CommonConstants.USER_SESSION) == null){
   //不对这些请求进行过滤
   String [] file = new String[]{".js",".css",".jpg",".gif","login.jsp","/admin/login",".html",".png",".svg"};
   String path = request.getServletPath();
   boolean bool = false;
   for (String key : file) {
    if(path.toLowerCase().endsWith( key.toLowerCase() )){
     bool = true;
     break;
    }
   }
   if(bool){
    filterChain.doFilter(re, response);
   }else{
    request.getSession().invalidate();
    request.getRequestDispatcher("/login").forward(request, response);
    return;
   }
  }else{
   filterChain.doFilter(re, response);
  }
 }

 @Override
 public void init(FilterConfig arg0) throws ServletException {}


}
