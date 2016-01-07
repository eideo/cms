package com.sbiao360.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
	protected static Logger logger = LoggerFactory.getLogger(SmsService.class);
	
	private static String sendurl="http://yunpian.com/v1/sms/send.json";
	
	
	private static String apikey="ace3fcb5f39cc215465132aa1b3ca4d7";
	

	/*
	 * 随机生成短信验证码
	 * 
	 * */
	public  String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}
	
	
	public boolean sendSmsNewGateWay(String mobiles, String content)
			throws Exception {		
		boolean sendResult = false;	
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(sendurl);
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("apikey", apikey));
		nvps.add(new BasicNameValuePair("mobile", mobiles));
		nvps.add(new BasicNameValuePair("text", content));
		
		logger.debug("发送短信 content : "+content);
		httpPost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
		HttpResponse response = httpclient.execute(httpPost);
		try {
			logger.debug("发送短信 statusCode : "+response.getStatusLine().getStatusCode());
			HttpEntity entity = response.getEntity();			
			if(200 == response.getStatusLine().getStatusCode()){		
				String reciveStr = EntityUtils.toString(entity);
				logger.debug("发送短信 reciveCode : "+reciveStr);
				/*int recive = Integer.parseInt(reciveStr);
				if(recive>0){
					sendResult = true;
				}*/
			}			
			EntityUtils.consume(entity);
		} finally {
			httpPost.releaseConnection();
		}

		return sendResult;
	}
}
