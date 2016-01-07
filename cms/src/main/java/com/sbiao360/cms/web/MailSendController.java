package com.sbiao360.cms.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.service.MailSendService;

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

}
