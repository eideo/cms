package com.sbiao360.cms.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sbiao360.cms.base.cons.CommonConstants;
import com.sbiao360.cms.domain.User;
import com.sbiao360.cms.service.UserService;
import com.sbiao360.cms.zutil.MD5;
import com.sbiao360.cms.zutil.WebUtil;

@Controller
@RequestMapping("/cms")
public class AdminLoginController extends BaseController {
	
	@Resource
	private UserService userService;

	@RequestMapping({"/","/index"})
	public String tobaseindex(HttpServletRequest request,Model model) {
		User user = userService.selectByPrimaryKey(1);
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value ="/logout",method = RequestMethod.POST)
	public void toLogOut(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(false); 
		if (session != null){
			session.removeAttribute(CommonConstants.USER_SESSION); 
			session.invalidate();
		}
		JSONObject object = new JSONObject(); 
		LOG.info("Admin logout ");
		object.put("valid", "0");
		object.put("message","注销成功！");
		object.put("redirectUrl","login");
		renderData(response, object.toJSONString());
	}
	
	@RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
	public void  loginCheck(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String login  = request.getParameter("login");
		String pass = request.getParameter("pass");
		String a = request.getParameter("a");
		Integer keep_logged = Integer.valueOf(request.getParameter("keep-logged"));

	    JSONObject object = new JSONObject();  
	    
	    User sUser= userService.loginCheck(login);
	    if ( sUser == null){   
	    	object.put("valid", "1");
	    	object.put("message", "无效的用户名/邮箱/手机信息, 请重新输入再试!");	
	    }else {  
	    	if (sUser.getEnabled()==0){
			    	if (MD5.MD5Encode(pass).equals(sUser.getPassword())){  
	                     ///** 处理登录请求，记录登录过的user id */
						 Integer userID =(Integer)WebUtils.getSessionAttribute(request,CommonConstants.USER_SESSION);
						 if(userID!=null){
							 request.getSession().removeAttribute(CommonConstants.USER_SESSION);
						 }
						 request.getSession().setAttribute(CommonConstants.USER_SESSION,sUser.getId());
					     //记住我
						if (keep_logged==1) 
						  WebUtil.addCookie(response,CommonConstants.COOKIE_USER_NAME,login, request.getPathInfo());
						
						object.put("valid", "0");
						object.put("message","成功！");
						LOG.info("getPathInfo:"+request.getPathInfo());
						LOG.info("getRequestURI:"+request.getRequestURI());
						
						object.put("redirectUrl","index?uid="+sUser.getId());
						 sUser.setLastip(request.getRemoteHost());
						 sUser.setLastvisit(new Date());
						 sUser.setLoginNum(sUser.getLoginNum()+1);
					    userService.update(sUser);  //登陆成功后记录用户登陆信息
					    userService.insertLogin_logInfo(sUser.getId(),sUser.getLastip(),sUser.getLastvisit());
					    
						 //添加日志处理过程
			    	}else {
						object.put("valid", "2");
						object.put("message","密码错误, 请重新输入再试!");
			    	}
		    	
	    	}else {
	    		object.put("valid", "4");
				object.put("message","此用户已经被锁住！");
	    	}
	    }
		renderData(response, object.toJSONString());
	}
	
	@RequestMapping(value = "/loginRegister",method = RequestMethod.POST)
	public void  loginRegister(HttpServletRequest request,HttpServletResponse response) {
		String name  = request.getParameter("name");
		String mail = request.getParameter("mail");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
	    JSONObject object = new JSONObject();  
	    User sUser= null;
	    
	    sUser =userService.loginCheck(name);
	    if (sUser != null){   
	    	object.put("valid", "1");
	    	object.put("message", "此用户名已经使用了, 请重新输入再试!");
	    	renderData(response, object.toJSONString());
	    	return;
	    }
	    sUser =userService.loginCheck(mail);
	    if (sUser != null){   
	    	object.put("valid", "2");
	    	object.put("message", "此邮件已经使用了, 请重新输入再试!");
	    	renderData(response, object.toJSONString());
	    	return;
	    }
	   
	    sUser =userService.loginCheck(login);
	    if (sUser != null){   
	    	object.put("valid", "3");
	    	object.put("message", "此手机号已经使用了, 请重新输入再试!");
	    	renderData(response, object.toJSONString());
	    	return;
	    }
	    sUser = new User();
	    sUser.setUsername(name);
	    sUser.setEmail(mail);
	    sUser.setMobile(login);
	    sUser.setPassword(MD5.MD5Encode(pass));
		userService.save(sUser);	
		
		object.put("valid", "0");
		object.put("message","注册成功！");
		renderData(response, object.toJSONString());
	}
	
	@RequestMapping("/profile")
	public String toProfile(HttpServletRequest request,Model model) {
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		User user = userService.selectByPrimaryKey(uid);
		model.addAttribute("user", user);
		return "cloudadmin/profile";
	}
	
	@RequestMapping(value ="/profile-edit",method = RequestMethod.GET)
	public String toProfileEdit(HttpServletRequest request,Model model) {
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		User useredit = userService.selectByPrimaryKey(uid);
		model.addAttribute("useredit", useredit);
		return "cloudadmin/profile-edit";
	}
	
	@RequestMapping(value = "/user-index",method = RequestMethod.GET)
	public String toUserPage(HttpServletRequest request, Model model) {
		return "cloudadmin/buser-index";
	}
	
	@RequestMapping(value = "/user-index",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUserlist(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String str_pageNum = request.getParameter("pageNum");
        String str_pageSize = request.getParameter("pageSize");
        String table_search = request.getParameter("table_search");
        int pageNum = 0,
            pageSize = 0;
        try {
            pageNum = Integer.parseInt(str_pageNum);
        } catch (NumberFormatException e) {
        	request.setAttribute("err", "页码只能是大于0的整数，请重新输入!");
        }
        try {
            pageSize = Integer.parseInt(str_pageSize);
        } catch (NumberFormatException e) {
        	request.setAttribute("err", "页面大小只能是大于0的整数，请重新输入!");
        }
        try {
        	if (pageSize==0){
        		pageSize =8;
        	}
			PageHelper.startPage(pageNum, pageSize);
			List<User> pageList = userService.getList();
			 PageInfo<User> page = new PageInfo(pageList,5);
			 modelMap.put("page", page);
        } catch (Exception e) {
        	LOG.error(e.getMessage());
        }
		modelMap.put("success", "true");
		return modelMap;
	}
	
	@RequestMapping(value = "/useradd",method = RequestMethod.GET)
	public String toUserAdd(HttpServletRequest request, Model model) {
		int flag  = Integer.parseInt(request.getParameter("flag"));
		if (flag!=0){
			User user = userService.selectByPrimaryKey(flag);
			LOG.info("----Flag="+JSON.toJSONString(user));
		    model.addAttribute("user", user);
		}
		LOG.info("----Flag="+flag);
		model.addAttribute("flag", flag);
		return "cloudadmin/buser-add";
	}
	
	@RequestMapping(value = "/useradd",method = RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object> addUser(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		User user= new User();
		int flag  = Integer.parseInt(request.getParameter("flag"));
		    String username = request.getParameter("username");
			String mobile  = request.getParameter("mobile");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			user.setUsername(username);	
			user.setMobile(mobile);	
			user.setEmail(email);
			user.setSex(sex);
			if (flag!=0){
				user.setId(flag);
				userService.update(user);
			}else {
			  String password = MD5.MD5Encode("tankula1010");		
			  user.setPassword(password);	
			  userService.save(user);
			}  
		    modelMap.put("success", "true");
		    modelMap.put("status", "操作成功!");
		return modelMap;
		
	}
	
	@RequestMapping(value = "/delUser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delUser(HttpServletRequest request) {
		
		int uid  = Integer.parseInt(request.getParameter("id"));
		userService.delete(uid);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		 modelMap.put("success", "true");
	    return  modelMap;
	}
	
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateExpo(HttpServletRequest request) {
		
		int uid  = Integer.parseInt(request.getParameter("id"));
		User user = userService.selectByPrimaryKey(uid);
		user.setEnabled((user.getEnabled()==1)?0:1 );
		userService.update(user);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", "true");
	    return  modelMap;
	}

}
