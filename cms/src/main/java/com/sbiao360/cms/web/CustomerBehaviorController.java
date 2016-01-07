package com.sbiao360.cms.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.domain.HotwordMap;
import com.sbiao360.cms.service.CustomerBehaviorService;
import com.sbiao360.cms.service.ReportMainService;
import com.sbiao360.cms.zutil.DateTime;
import com.sbiao360.cms.zutil.IpTool;

/**
 * 用户行为控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping(value = "/customerBehavior")
public class CustomerBehaviorController extends BaseController {

	private static final Log CustBehaviorLog = LogFactory
			.getLog(CustomerBehaviorController.class);

	@Resource
	private CustomerBehaviorService customerBehaviorService;

	@Resource
	private ReportMainService reportMainService;

	// 用户行为-热词
	@RequestMapping(value = "/getHotword", method = RequestMethod.GET)
	public void getHotword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String hotword = customerBehaviorService.getHotword();

		/*
		 * if (null == hotword || "".equals(hotword)) { hotword =
		 * customerBehaviorService.getHotwordInit();
		 * customerBehaviorService.setHotword(hotword); }
		 */

		ajaxJson(hotword, response);
	}

	// 用户行为-热词搜索列表
	@RequestMapping(value = "/getHotwordMap", method = RequestMethod.GET)
	public void getHotwordMap(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<HotwordMap> hotwordMapList = customerBehaviorService
				.getHotwordMapList();
		JSONArray jsonArray = JSONArray.fromObject(hotwordMapList);

		ajaxJson(jsonArray.toString(), response);
	}

	// 用户行为-关注项目
	@RequestMapping(value = "/attention", method = RequestMethod.POST)
	public void customerAttention(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") short infoValid)
			throws IOException {
		JSONObject result = new JSONObject();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		Assertion assertion = AssertionHolder.getAssertion();

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();

			Long ip = 0L;
			String ipStr = IpTool.getClientAddress(request);
			if (null != ipStr && !"".equals(ipStr)) {
				ip = IpTool.setIP(ipStr);
			}

			CustBehavior custBehavior = new CustBehavior();
			custBehavior.setUserId(userId);
			custBehavior.setCustName(custName);
			custBehavior.setLoginId(loginId);
			custBehavior.setIp(ip);
			custBehavior.setActionType(actionType);
			custBehavior.setActionDate(new Date());
			custBehavior.setInfoType(infoType);
			custBehavior.setInfoId(infoId);
			custBehavior.setInfoName(infoName);
			custBehavior.setInfoValid(infoValid);
			custBehavior.setColumnLevelOne("搜索");
			if ("11506".equals(infoType)) {
				custBehavior.setColumnLevelOne("行业报告");
			}
			custBehavior.setColumnLevelTwo("详细页");

			// 个人中心我的足迹关注
			if (infoValid == 3) {
				Map<String, Object> paraMap = new HashMap<String, Object>();
				paraMap.put("userId", userId);
				paraMap.put("actionType", 2);
				paraMap.put("infoType", infoType);
				paraMap.put("infoId", infoId);
				paraMap.put("actionTypeNew", actionType);
				paraMap.put("infoValid", 1);
				paraMap.put("actionDate", new Date());
				customerBehaviorService.updateByFoot(paraMap);
			} else {
				boolean existAttention = customerBehaviorService
						.exist(custBehavior);
				if (existAttention) {
					customerBehaviorService.updateByProperties(custBehavior);
				} else {
					customerBehaviorService
							.insertCustomerAttention(custBehavior);
				}

				if ("11506".equals(infoType)) {
					Map<String, Object> paraMap = new HashMap<String, Object>();
					paraMap.put("infoValid", infoValid);
					paraMap.put("id", infoId);
					reportMainService.updateReportAttentions(paraMap);
				}
			}

			result.put("status", 0);

			if (userId.longValue() != 0) {
				CustBehaviorLog.info(userId
						+ ","
						+ request.getSession().getId()
						+ ","
						+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
								custBehavior.getActionDate()) + ","
						+ "attention");
			}
		} else {
			// 未登录
			result.put("status", -1);
		}

		ajaxJson(result.toString(), response);
	}

	// 用户行为-收藏项目
	@RequestMapping(value = "/collection", method = RequestMethod.POST)
	public void customerCollection(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") short infoValid)
			throws IOException {
		JSONObject result = new JSONObject();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		Assertion assertion = AssertionHolder.getAssertion();

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();

			Long ip = 0L;
			String ipStr = IpTool.getClientAddress(request);
			if (null != ipStr && !"".equals(ipStr)) {
				ip = IpTool.setIP(ipStr);
			}

			CustBehavior custBehavior = new CustBehavior();
			custBehavior.setUserId(userId);
			custBehavior.setCustName(custName);
			custBehavior.setLoginId(loginId);
			custBehavior.setIp(ip);
			custBehavior.setActionType(actionType);
			custBehavior.setActionDate(new Date());
			custBehavior.setInfoType(infoType);
			custBehavior.setInfoId(infoId);
			custBehavior.setInfoName(infoName);
			custBehavior.setInfoValid(infoValid);
			custBehavior.setColumnLevelOne("搜索");
			if ("11506".equals(infoType)) {
				custBehavior.setColumnLevelOne("行业报告");
			}
			custBehavior.setColumnLevelTwo("详细页");

			// 个人中心我的足迹收藏
			if (infoValid == 4) {
				Map<String, Object> paraMap = new HashMap<String, Object>();
				paraMap.put("userId", userId);
				paraMap.put("actionType", 2);
				paraMap.put("infoType", infoType);
				paraMap.put("infoId", infoId);
				paraMap.put("actionTypeNew", actionType);
				paraMap.put("infoValid", 1);
				paraMap.put("actionDate", new Date());
				customerBehaviorService.updateByFoot(paraMap);
			} else {
				boolean existCollection = customerBehaviorService
						.exist(custBehavior);
				if (existCollection) {
					customerBehaviorService.updateByProperties(custBehavior);
				} else {
					customerBehaviorService
							.insertCustomerCollection(custBehavior);
				}
			}

			result.put("status", 0);

			if (userId.longValue() != 0) {
				CustBehaviorLog.info(userId
						+ ","
						+ request.getSession().getId()
						+ ","
						+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
								custBehavior.getActionDate()) + ","
						+ "collection");
			}
		} else {
			// 未登录
			result.put("status", -1);
		}

		ajaxJson(result.toString(), response);
	}

	// 用户行为-取消关注/收藏
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public void customerCancel(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") short infoValid)
			throws IOException {
		JSONObject result = new JSONObject();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		Assertion assertion = AssertionHolder.getAssertion();

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();

			Long ip = 0L;
			String ipStr = IpTool.getClientAddress(request);
			if (null != ipStr && !"".equals(ipStr)) {
				ip = IpTool.setIP(ipStr);
			}

			CustBehavior custBehavior = new CustBehavior();
			custBehavior.setUserId(userId);
			custBehavior.setCustName(custName);
			custBehavior.setLoginId(loginId);
			custBehavior.setIp(ip);
			custBehavior.setActionType(actionType);
			custBehavior.setActionDate(new Date());
			custBehavior.setInfoType(infoType);
			custBehavior.setInfoId(infoId);
			custBehavior.setInfoName(infoName);
			custBehavior.setInfoValid(infoValid);

			customerBehaviorService.updateByProperties(custBehavior);

			if ("11506".equals(infoType) && actionType.shortValue() == 3) {
				Map<String, Object> paraMap = new HashMap<String, Object>();
				paraMap.put("infoValid", infoValid);
				paraMap.put("id", infoId);
				reportMainService.updateReportAttentions(paraMap);
			}

			result.put("status", 0);

			if (userId.longValue() != 0) {
				CustBehaviorLog.info(userId
						+ ","
						+ request.getSession().getId()
						+ ","
						+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
								custBehavior.getActionDate()) + "," + "cancel");
			}
		} else {
			// 未登录
			result.put("status", -1);
		}

		ajaxJson(result.toString(), response);
	}

	// 用户行为-分享项目
	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public void customerShare(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") String shareTarget)
			throws IOException {
		Long ip = 0L;
		String ipStr = IpTool.getClientAddress(request);
		if (null != ipStr && !"".equals(ipStr)) {
			ip = IpTool.setIP(ipStr);
		}

		Assertion assertion = AssertionHolder.getAssertion();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();
		}

		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setUserId(userId);
		custBehavior.setCustName(custName);
		custBehavior.setLoginId(loginId);
		custBehavior.setIp(ip);
		custBehavior.setActionType(actionType);
		custBehavior.setActionDate(new Date());
		custBehavior.setInfoType(infoType);
		custBehavior.setInfoId(infoId);
		custBehavior.setInfoName(infoName);
		custBehavior.setInfoValid((short) 1);
		custBehavior.setShareType((short) 1);
		custBehavior.setShareSys("win7");
		custBehavior.setShareTarget(shareTarget);
		custBehavior.setShareMessage("");
		custBehavior.setColumnLevelOne("搜索");
		if ("11506".equals(infoType)) {
			custBehavior.setColumnLevelOne("行业报告");
		}
		custBehavior.setColumnLevelTwo("详细页");

		customerBehaviorService.insertCustomerShare(custBehavior);

		if (userId.longValue() != 0) {
			CustBehaviorLog.info(userId
					+ ","
					+ request.getSession().getId()
					+ ","
					+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
							custBehavior.getActionDate()) + "," + "share");
		}
	}

	// 用户行为-点击详细页
	@RequestMapping(value = "/detailPage", method = RequestMethod.POST)
	public void customerDetailPage(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") short infoValid)
			throws IOException {
		Long ip = 0L;
		String ipStr = IpTool.getClientAddress(request);
		if (null != ipStr && !"".equals(ipStr)) {
			ip = IpTool.setIP(ipStr);
		}

		Assertion assertion = AssertionHolder.getAssertion();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();
		}

		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setUserId(userId);
		custBehavior.setCustName(custName);
		custBehavior.setLoginId(loginId);
		custBehavior.setIp(ip);
		custBehavior.setInfoType(infoType);
		custBehavior.setActionType(actionType);
		custBehavior.setActionDate(new Date());
		custBehavior.setInfoId(infoId);
		custBehavior.setInfoName(infoName);
		custBehavior.setInfoValid(infoValid);
		custBehavior.setColumnLevelOne("搜索");
		if ("11506".equals(infoType)) {
			custBehavior.setColumnLevelOne("行业报告");
		}
		custBehavior.setColumnLevelTwo("详细页");

		customerBehaviorService.insertCustomerClickDetailPage(custBehavior);

		if (userId.longValue() != 0) {
			CustBehaviorLog.info(userId
					+ ","
					+ request.getSession().getId()
					+ ","
					+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
							custBehavior.getActionDate()) + "," + "detailPage");
		}

	}

	// 用户行为-点击关系网
	@RequestMapping(value = "/relNetwork", method = RequestMethod.POST)
	public void customerRelNetwork(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") String infoType,
			@RequestParam(required = false, defaultValue = "") Long infoId,
			@RequestParam(required = false, defaultValue = "") String infoName,
			@RequestParam(required = false, defaultValue = "") short infoValid)
			throws IOException {
		Long ip = 0L;
		String ipStr = IpTool.getClientAddress(request);
		if (null != ipStr && !"".equals(ipStr)) {
			ip = IpTool.setIP(ipStr);
		}

		Assertion assertion = AssertionHolder.getAssertion();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();
		}

		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setUserId(userId);
		custBehavior.setCustName(custName);
		custBehavior.setLoginId(loginId);
		custBehavior.setIp(ip);
		custBehavior.setInfoType(infoType);
		custBehavior.setActionType(actionType);
		custBehavior.setActionDate(new Date());
		custBehavior.setInfoId(infoId);
		custBehavior.setInfoName(infoName);
		custBehavior.setInfoValid(infoValid);
		custBehavior.setColumnLevelOne("搜索");
		custBehavior.setColumnLevelTwo("关系网");

		customerBehaviorService.insertCustomerClickRelNetwork(custBehavior);

		if (userId.longValue() != 0) {
			CustBehaviorLog.info(userId
					+ ","
					+ request.getSession().getId()
					+ ","
					+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
							custBehavior.getActionDate()) + "," + "relNetwork");
		}
	}

	// 用户行为-点击搜索条件
	@RequestMapping(value = "/topClick", method = RequestMethod.POST)
	public void customerTopClick(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "") Short actionType,
			@RequestParam(required = false, defaultValue = "") Short clickType,
			@RequestParam(required = false, defaultValue = "") String clickContent)
			throws IOException {
		Long ip = 0L;
		String ipStr = IpTool.getClientAddress(request);
		if (null != ipStr && !"".equals(ipStr)) {
			ip = IpTool.setIP(ipStr);
		}

		Assertion assertion = AssertionHolder.getAssertion();
		Long userId = 0L;
		String custName = "";
		String loginId = "";

		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			loginId = assertion.getPrincipal().getName();
		}

		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setUserId(userId);
		custBehavior.setCustName(custName);
		custBehavior.setLoginId(loginId);
		custBehavior.setIp(ip);
		custBehavior.setActionType(actionType);
		custBehavior.setActionDate(new Date());
		custBehavior.setClickType(clickType);
		custBehavior.setClickContent(clickContent);

		customerBehaviorService.insertCustomerTopClick(custBehavior);

		if (userId.longValue() != 0) {
			CustBehaviorLog.info(userId
					+ ","
					+ request.getSession().getId()
					+ ","
					+ DateTime.toDate("yyyy-MM-dd HH:mm:ss",
							custBehavior.getActionDate()) + "," + "topClick");
		}
	}

}
