package com.sbiao360.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.sbiao360.cms.base.cons.CommonConstants;

/**
 * 短信发送服务层
 * 
 * @author yujunwei
 */
@Service
public class SmsSendService {

	private static final Log SmsSendServiceLog = LogFactory
			.getLog(SmsSendService.class);

	/**
	 * 短信验证码发送
	 * 
	 * @param phone
	 *            手机号码
	 * @param numberFlag
	 *            是否数字格式
	 * @param length
	 *            验证码长度
	 * */
	public boolean sendIdentifyingCode(String phone, boolean numberFlag,
			int length) {
		String contentPrefix = "您的手机动态验证码为：";
		// String contentSuffix = "。该码5分钟内有效，若5分钟内未输入，需要重新获取。验证码转发无效。";
		String contentSuffix = "";
		boolean flag = false;
		String identifyingCode = createIdentifyingCode(numberFlag, length);
		String content = contentPrefix + identifyingCode + contentSuffix;
		String flagStr = smsSend(phone, content);
		if ("true".equals(flagStr)) {
			flag = true;
			SmsSendServiceLog.info(phone + " 的手机动态验证码为：" + identifyingCode);
		}
		return flag;
	}

	/**
	 * 随机生成指定长度的短信验证码
	 * 
	 * @param numberFlag
	 *            是否数字格式
	 * @param length
	 *            验证码长度
	 * */
	public String createIdentifyingCode(boolean numberFlag, int length) {
		String identifyingCode = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			identifyingCode = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				identifyingCode += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return identifyingCode;
	}

	/**
	 * 短信发送
	 * 
	 * @param phone
	 *            手机号码
	 * @param content
	 *            短信内容
	 * */
	public String smsSend(String phone, String content) {
		String result = "false";
		String contentTemplate = "【国信创新】客户您好，" + content;
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(CommonConstants.SMS_TARGETS);
		try {
			// 短信发送入参
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			// 手机号码
			nvps.add(new BasicNameValuePair("phone", phone));
			// 发送短信内容
			// 内容请暂以【国信创新】开头 ，随着运营商的变化此值也会变，到时会通知。
			// 这是通道要求的，且会经常无理变化，之所以不在服务器端设置，
			// 原因是服务器端的重启会影响所有用到的客户端，短信发送的服务器兼顾了所有通道的短信发送，
			// 不止长沙畅蓝一家，所以请自行在客户端做处理。也有好处也有坏处吧，请知悉。
			nvps.add(new BasicNameValuePair("content", contentTemplate));
			// guanzhulog 空值即可
			nvps.add(new BasicNameValuePair("guanzhulog", ""));
			// 用于记录此短信是由哪个系统发出，请一定赋值，值为 4，表示CMS系统
			nvps.add(new BasicNameValuePair("send_type", "4"));

			httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));

			HttpResponse httpResponse = httpClient.execute(httpPost);

			if (httpResponse != null) {
				HttpEntity httpEntity = httpResponse.getEntity();
				if (httpEntity != null) {
					result = EntityUtils.toString(httpEntity, "UTF-8");
				}
			}
		} catch (Exception e) {
			SmsSendServiceLog.error("发送短信异常: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (httpPost != null) {
				httpPost.releaseConnection();
			}
		}
		// System.out.println("result = " + result);
		return result;
	}

	public static void main(String[] args) {
		SmsSendService smsSendService = new SmsSendService();
		System.out.println(smsSendService.sendIdentifyingCode("18660391341",
				true, 6));
	}
}
