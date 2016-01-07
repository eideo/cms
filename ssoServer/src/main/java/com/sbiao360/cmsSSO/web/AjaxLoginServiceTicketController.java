package com.sbiao360.cmsSSO.web;

import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.AuthenticationException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.Ticket;
import org.jasig.cas.ticket.TicketException;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.jasig.cas.ticket.registry.TicketRegistry;
import org.jasig.cas.web.support.CookieRetrievingCookieGenerator;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.google.common.collect.Maps;

public class AjaxLoginServiceTicketController extends AbstractController  {
	
    private CookieRetrievingCookieGenerator tgtCookieGenerator;
    private TicketRegistry ticketRegistry;
    public CookieRetrievingCookieGenerator getTgtCookieGenerator() {
		return tgtCookieGenerator;
	}
	public void setTgtCookieGenerator(CookieRetrievingCookieGenerator tgtCookieGenerator) {
		this.tgtCookieGenerator = tgtCookieGenerator;
	}
	public TicketRegistry getTicketRegistry() {
		return ticketRegistry;
	}
	public void setTicketRegistry(TicketRegistry ticketRegistry) {
		this.ticketRegistry = ticketRegistry;
	}
	public CentralAuthenticationService getCentralAuthenticationService() {
		return centralAuthenticationService;
	}
	public void setCentralAuthenticationService(CentralAuthenticationService centralAuthenticationService) {
		this.centralAuthenticationService = centralAuthenticationService;
	}
	public String getDEFAULT_SERVICE() {
		return DEFAULT_SERVICE;
	}
	public void setDEFAULT_SERVICE(String dEFAULT_SERVICE) {
		DEFAULT_SERVICE = dEFAULT_SERVICE;
	}
	private CentralAuthenticationService centralAuthenticationService;
	 private String DEFAULT_SERVICE;
		@Override
		protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
				{
			String username = request.getParameter("user");
			String password = request.getParameter("passwd");
			String service = request.getParameter("service");
			String jsonp = request.getParameter("jsoncallback");
			String tgtId = tgtCookieGenerator.retrieveCookieValue(request);
	        final Map<String,Object> result = Maps.newHashMap();
	        Ticket ticket = null;
	        if(hasText(tgtId)) {
	            ticket = ticketRegistry.getTicket(tgtId);
	        }
	        try {
	            if(ticket != null && !ticket.isExpired() && ticket instanceof TicketGrantingTicket) {
	                ServiceTicket st = centralAuthenticationService.grantServiceTicket(tgtId, getService(service));
	                tgtCookieGenerator.addCookie(request, response, tgtId);
	                result.put("result", true);
	                result.put("st", st.toString());
	                result.put("message", "authentication success");
	            }else if(hasText(username) && hasText(password)) {
	                tgtId = centralAuthenticationService.createTicketGrantingTicket(new UsernamePasswordCredential(username, password)).getId();
	                ServiceTicket st = centralAuthenticationService.grantServiceTicket(tgtId, getService(service));
	                tgtCookieGenerator.addCookie(request, response, tgtId);
	                result.put("result", true);
	                result.put("st", st.toString());
	                result.put("message", "authentication success");
	               
	            }else {
	                //验证出现异常，用户名密码错误
	                result.put("result", false);
	                result.put("message", "验证失败");
	            }
	        } catch ( AuthenticationException  e) {
	            logger.error("tgt "+tgtId+" user"+username+" 验证失败,{}",  e);
	            if(e.getHandlerErrors().get("AcceptUsersAuthenticationHandler").equals(AccountNotFoundException.class)){
	            	result.put("result", false);
	            	result.put("message", "用户名不存在");
	            }else{
	            	result.put("result", false);
	            	result.put("message", "密码错误");
	            	
	            }
	        }catch(TicketException e){
	        	result.put("result", false);
	            result.put("message", "stoken失效");
	        }
	        ajaxJson(jsonp+"("+JSONObject.toJSONString(result)+")",response);
			return null;
		}
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
		        	logger.error("ajax", e);
		        }
		        return null;
		    }
		 private Service getService(String service) {
		        if(isEmpty(service)) {
		            service = DEFAULT_SERVICE;
		        }
		        return new SimpleWebApplicationServiceImpl(service);
		    }
}
