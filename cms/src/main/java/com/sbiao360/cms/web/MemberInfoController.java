package com.sbiao360.cms.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbiao360.cms.domain.MemberInfo;
import com.sbiao360.cms.service.MemberInfoService;
import com.sbiao360.cms.service.SmsSendService;
import com.sbiao360.cms.service.SmsService;
import com.sbiao360.cms.zutil.PwdStuff;
import com.sbiao360.cms.zutil.StringUtil;

/**
 * 用户关系控制层
 * @author 廖得宇
 *	2016年1月4日
 */
@Controller
public class MemberInfoController extends BaseController{
	
	@Resource
	private MemberInfoService memberInfoService;
	
	@Resource
	private SmsSendService smsSendService;
	
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/registerMember")
	public void registerMember(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		String vCode = request.getParameter("v-code");
		String mCode = request.getParameter("m-code");
		String password = request.getParameter("password");
		
		String companyname = request.getParameter("companyname");
		String userMobile = request.getParameter("user-mobile");
		String password2 = request.getParameter("password2");
		PwdStuff pwdStuff = new PwdStuff();
		//企业注册
		if(StringUtil.isBlank(username)){
			MemberInfo member = new MemberInfo();
			member.setCompanyName(companyname);
			member.setLoginPassword(pwdStuff.convertPassword(password2));
			member.setMobilePhone(userMobile);
			member.setLoginId(userMobile);
			member.setBelong(0);
			member.setUserType(1);
			memberInfoService.insertMemberInfo(member);
		}
		//普通用户注册
		else if(StringUtil.isBlank(companyname)){
			
			MemberInfo member = new MemberInfo();
			if(isMobileNO(username)){
				if(!mCode.equals((String)request.getSession().getAttribute("mobileMessage"))){
					ajaxJson("{status:"+false+",message:'验证码过期！'}", response);
					return;
				}
				member.setMobilePhone(username);
			}else if(isEmail(username)){
				if(!vCode.equals((String)request.getSession().getAttribute("certCode"))){
					ajaxJson("{status:"+false+",message:'验证码过期！'}", response);
					return;
				}
				member.setCustEmail(username);
			}
			member.setLoginId(username);
			member.setLoginPassword(pwdStuff.convertPassword(password));
			member.setBelong(0);
			memberInfoService.insertMemberInfo(member);
		}else{
			ajaxJson("{status:"+false+",message:'违法的注册条件！'}", response);
		}
		ajaxJson("{status:"+true+"}", response);
	}
	
	/**
	 * 检查用户名
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/checkUserName")
	public void checkUserName(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setLoginId(username);
		memberInfo.setCustEmail(username);
		memberInfo.setMobilePhone(username);
		memberInfo.setCompanyName(username);
		boolean b = memberInfoService.checkMember(memberInfo);
		ajaxJson("{status:"+b+"}", response);
	}
	
	
	/**
	 * 发送手机验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/sendmes")
	public void sendMessage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String mobile = request.getParameter("mobile");
		String contentPrefix = "您的手机动态验证码为：";
		String contentSuffix = "。该码5分钟内有效，若5分钟内未输入，需要重新获取。验证码转发无效。";
		String randStr  =smsSendService.createIdentifyingCode(true, 4);
		request.getSession().setAttribute("mobileMessage", randStr);
		String b = smsSendService.smsSend(mobile, contentPrefix + randStr + contentSuffix);
		ajaxJson("{status:"+b+"}", response);
	}
	
	
	/**
	 * 检查手机验证码
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/checkmes")
	public void checkMessage(HttpServletRequest request,HttpServletResponse response){
		String mobileMessage=request.getParameter("mobileMessage");
		String sysNum = (String)request.getSession().getAttribute("mobileMessage");
		if(StringUtil.isNotBlank(sysNum)&&mobileMessage.equals(sysNum))
			ajaxJson("{status:"+true+"}", response);
		else
			ajaxJson("{status:"+false+"}", response);
	}
	
	
	/**
	 * 检查是否手机号
	 * @param mobiles
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private boolean isMobileNO(String mobiles){  
		  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");  
			  
		Matcher m = p.matcher(mobiles);  
		  
		return m.matches();  
	}  
	
	
	/**
	 * 检查是否邮箱
	 * @param email
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	
	/**
	 * 跳转至注册页面
	 * @param request
	 * @param response
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/register")
	public String toRegister(HttpServletRequest request,HttpServletResponse response){
		return "/register";
	}
	
	
	/**
	 * 验证图片验证码状态
	 * @param request
	 * @param response
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@RequestMapping("/getCertCodeStatus")
	public void getCertCodeStatus(HttpServletRequest request,HttpServletResponse response){
		String certCode=request.getParameter("certCode");
		if(certCode.equals((String)request.getSession().getAttribute("certCode")))
			ajaxJson("{status:"+true+"}", response);
		else
			ajaxJson("{status:"+false+"}", response);
	}
	
	
}
