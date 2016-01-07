package com.sbiao360.cms.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sbiao360.cms.base.cons.CommonConstants;

import freemarker.template.Template;

/**
 * 邮件发送服务层
 * 
 * @author yujunwei
 */
@Service
public class MailSendService {

	private static final Log MailSendServiceLog = LogFactory
			.getLog(MailSendService.class);

	@Resource
	private JavaMailSenderImpl mailSender;

	@Resource
	private FreeMarkerConfigurer freeMarkerConfigurer;

	/**
	 * 发送纯文本格式邮件
	 * 
	 * @param to
	 *            收件人
	 * @param subject
	 *            邮件标题
	 * @param text
	 *            邮件内容
	 * */
	public boolean sendSimpleMail(String to, String subject, String text) {
		boolean flag = false;
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			// 设置发送人
			simpleMailMessage.setFrom(CommonConstants.MAIL_FROM);
			// 设置收件人
			simpleMailMessage.setTo(to);
			// 设置发送日期
			simpleMailMessage.setSentDate(new Date());
			// 设置主题
			simpleMailMessage.setSubject(subject);
			// 设置邮件内容
			simpleMailMessage.setText(text);
			// 将邮件发送
			mailSender.send(simpleMailMessage);
			flag = true;
			// System.out.println("纯文本格式邮件发送成功...");
		} catch (Exception e) {
			flag = false;
			MailSendServiceLog.error("纯文本格式邮件发送异常: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 发送HTML格式邮件
	 * 
	 * @param to
	 *            收件人
	 * @param subject
	 *            邮件标题
	 * @param htmlText
	 *            邮件内容
	 * */
	public boolean sendHtmlMail(String to, String subject, String htmlText) {
		boolean flag = false;
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "utf-8");
			// 设置发送人
			messageHelper.setFrom(CommonConstants.MAIL_FROM);
			// 设置收件人
			messageHelper.setTo(to);
			// 设置发送日期
			messageHelper.setSentDate(new Date());
			// 设置主题
			messageHelper.setSubject(subject);
			// 设置邮件内容为HTML超文本格式 true
			messageHelper.setText(htmlText, true);
			// 将邮件发送
			mailSender.send(mimeMessage);
			flag = true;
			// System.out.println("HTML格式邮件发送成功...");
		} catch (Exception e) {
			flag = false;
			MailSendServiceLog.error("HTML格式邮件发送异常: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 发送基于模板格式邮件
	 * 
	 * @param to
	 *            收件人
	 * @param subject
	 *            邮件标题
	 * @param templateFtl
	 *            邮件模板
	 * @param map
	 *            模板参数
	 * */
	public boolean sendTemplateMail(String to, String subject,
			String templateFtl, Map<String, Object> map) {
		boolean flag = false;
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(
					mimeMessage, true, "utf-8");
			// 设置发送人
			messageHelper.setFrom(CommonConstants.MAIL_FROM);
			// 设置收件人
			messageHelper.setTo(to);
			// 设置发送日期
			messageHelper.setSentDate(new Date());
			// 设置主题
			messageHelper.setSubject(subject);
			String htmlText = getMailText(templateFtl, map);
			// 设置邮件内容
			messageHelper.setText(htmlText, true);
			// 将邮件发送
			mailSender.send(mimeMessage);
			flag = true;
			// System.out.println("基于模板格式邮件发送成功...");
		} catch (Exception e) {
			flag = false;
			MailSendServiceLog.error("基于模板邮件发送异常: " + e.getMessage());
			e.printStackTrace();
		}
		return flag;
	}

	private String getMailText(String templateFtl, Map<String, Object> map) {
		String htmlText = "";
		try {
			Template template = freeMarkerConfigurer.getConfiguration()
					.getTemplate(templateFtl);
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(
					template, map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return htmlText;
	}

}
