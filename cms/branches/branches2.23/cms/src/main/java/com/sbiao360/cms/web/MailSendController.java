package com.sbiao360.cms.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.domain.MemberInfo;
import com.sbiao360.cms.service.MailSendService;
import com.sbiao360.cms.service.MemberInfoService;
import com.sbiao360.cms.zutil.StringUtil;

/**
 * 邮件发送控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping
public class MailSendController extends BaseController {

	@Resource
	private MailSendService mailSendService;
	
	@Resource
	private MemberInfoService memberInfoService;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate01;
	
	private MemberInfo memberInfo;
	

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String reportPage(HttpServletRequest request,
			HttpServletResponse response) {

		return "mail";
	}

	@RequestMapping(value = "/mail/sendsimple", method = RequestMethod.POST)
	public void sendSimpleMail(
			@RequestParam(value = "to", required = false) String to,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String subject = "纯文本格式邮件发送";
		String text = "恭喜！您在CMS已经注册成功，您的用户ID为：1";
		boolean flag = mailSendService.sendSimpleMail(to, subject, text);
		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/mail/sendhtml", method = RequestMethod.POST)
	public void sendHtmlMail(
			@RequestParam(value = "to", required = false) String to,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();

		String subject = "HTML格式邮件发送";
		String htmlText = "<html><head>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">"
				+ "</head><body>"
				+ "欢迎访问CMS首页！<a href=\"http://101.200.0.81\">CMS首页</a>"
				+ "</body></html>";

		boolean flag = mailSendService.sendHtmlMail(to, subject, htmlText);
		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/mail/sendtemplate", method = RequestMethod.POST)
	public void sendTemplateMail(
			@RequestParam(value = "to", required = false) String to,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();

		String subject = "基于模板邮件发送";
		String templateFtl = "mail.ftl";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mailContent", "您的邮箱验证码是：<span>666666</span>");
		boolean flag = mailSendService.sendTemplateMail(to, subject,
				templateFtl, map);
		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}
	
	@RequestMapping(value="/mail/sendPassResetMail")
	public void sendPassResetMail(@RequestParam(value = "to", required = false) String to,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		JSONObject result = new JSONObject();
		memberInfo = new MemberInfo();
		memberInfo.setLoginId(to);
		memberInfo.setCustEmail(to);
		memberInfo = memberInfoService.getMemberByPhone(memberInfo);
		if(memberInfo==null){
			result.put("success", false);
			result.put("message", "没有该用户");
		}else{
			String pd = java.util.UUID.randomUUID().toString().replace("-","").toUpperCase();
			redisTemplate01.execute(new RedisCallback<Long>() {  
	            public Long doInRedis(RedisConnection connection)  
	                    throws DataAccessException {  
	                byte[] keyb = ("checkpass"+pd).getBytes();  
	                byte[] valueb = toByteArray(memberInfo.getId());  
	                connection.set(keyb, valueb);  
	                connection.expire(keyb, 300);  
	                return 1L;  
	            }  
	        });
			String subject = "cms-密码重置";
			String templateFtl = "mail.ftl";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("mailContent", "与该电子邮件地址关联的需要设定一个新的密码，点击此链接并按照说明完成操作：<a href='http://192.168.8.129/resetpwdmail?pd="+pd+"'>重置密码</a>。如果当前操作请求不是您发出的，请忽略此邮件 ");
			boolean flag = mailSendService.sendTemplateMail(to, subject,
					templateFtl, map);
			result.put("success", flag);
		}

		ajaxJson(result.toJSONString(), response);
	}

	
	/** 
     * 描述 : <byte[]转Object>. <br> 
     * <p> 
     * <使用方法说明> 
     * </p> 
     *  
     * @param bytes 
     * @return 
     */  
    private Object toObject(byte[] bytes) {  
        Object obj = null;  
        try {  
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);  
            ObjectInputStream ois = new ObjectInputStream(bis);  
            obj = ois.readObject();  
            ois.close();  
            bis.close();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } catch (ClassNotFoundException ex) {  
            ex.printStackTrace();  
        }  
        return obj;  
    }  
    

    /** 
     * 描述 : <Object转byte[]>. <br> 
     * <p> 
     * <使用方法说明> 
     * </p> 
     *  
     * @param obj 
     * @return 
     */  
    private byte[] toByteArray(Object obj) {  
        byte[] bytes = null;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        try {  
            ObjectOutputStream oos = new ObjectOutputStream(bos);  
            oos.writeObject(obj);  
            oos.flush();  
            bytes = bos.toByteArray();  
            oos.close();  
            bos.close();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
        return bytes;  
    }  
}
