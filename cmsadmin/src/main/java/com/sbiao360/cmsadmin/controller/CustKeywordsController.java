package com.sbiao360.cmsadmin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbiao360.cmsadmin.core.Constant;
import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.CustBehavior;
import com.sbiao360.cmsadmin.service.CustBehaviorService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 用户行为-搜索关键词的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/custkeywords")
public class CustKeywordsController extends
		JavaEEFrameworkBaseController<CustBehavior> implements Constant {

	@Resource
	private CustBehaviorService custBehaviorService;

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("userId", "USER_ID");
		sortedMap.put("infoId", "INFO_ID");
		sortedMap.put("actionDate", "ACTION_DATE");
	}

	// 查询用户搜索关键词页面的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getCustKeywords", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getCustKeywords(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		String sortedObject = request.getParameter("sidx");
		String sortedValue = request.getParameter("sord");
		String filters = request.getParameter("filters");
		if (null != filters) {
			filters = URLDecoder.decode(request.getParameter("filters"),
					"UTF-8");
		}
		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setActionType((short) 6);
		custBehavior.setSortedObject(sortedMap.get(sortedObject));
		custBehavior.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("loginId")
						&& result.getString("op").equals("cn")) {
					custBehavior
							.setLikeLoginId(result.getString("data").trim());
				}
				if (result.getString("field").equals("custName")
						&& result.getString("op").equals("cn")) {
					custBehavior.setLikeCustName(result.getString("data")
							.trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				custBehavior.setFlag("OR");
			} else {
				custBehavior.setFlag("AND");
			}
		}
		custBehavior.setPage(page);
		custBehavior.setRows(rows);
		Long totalCount = custBehaviorService.getCount(custBehavior);
		List<CustBehavior> queryResult = custBehaviorService
				.getList(custBehavior);
		JqGridPageView<CustBehavior> custBehaviorListView = new JqGridPageView<CustBehavior>();
		custBehaviorListView.setMaxResults(rows);
		custBehaviorListView.setRows(queryResult);
		custBehaviorListView.setRecords(totalCount);
		writeJSON(response, custBehaviorListView);
	}

	// 操作用户搜索关键词页面的删除、导出Excel
	@RequestMapping(value = "/operateCustKeywords", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateCustKeywords(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteCustKeywords(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=custkeywords.xls");
				OutputStream out = response.getOutputStream();
				out.write(URLDecoder.decode(request.getParameter("csvBuffer"),
						"UTF-8").getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

		}
	}

	// 删除用户搜索关键词记录
	@RequestMapping("/deleteCustKeywords")
	public void deleteCustKeywords(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = custBehaviorService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

}
