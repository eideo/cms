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
import com.sbiao360.cmsadmin.model.MethodExcuTime;
import com.sbiao360.cmsadmin.service.MethodExcuTimeService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 服务方法执行时间的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/methodexcutime")
public class MethodExcuTimeController extends
		JavaEEFrameworkBaseController<MethodExcuTime> implements Constant {

	@Resource
	private MethodExcuTimeService methodExcuTimeService;

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("execTime", "EXEC_TIME");
		sortedMap.put("insertDate", "INSERT_DATE");
	}

	// 查询服务方法执行时间页面的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getMethodExcuTime", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getMethodExcuTime(HttpServletRequest request,
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
		MethodExcuTime methodExcuTime = new MethodExcuTime();
		methodExcuTime.setSortedObject(sortedMap.get(sortedObject));
		methodExcuTime.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("execTime")
						&& result.getString("op").equals("ge")) {
					Long execTime = 0L;
					String execTimeStr = result.getString("data").trim();
					if (null != execTimeStr && !"".equals(execTimeStr)) {
						execTime = Long.parseLong(execTimeStr);
					}
					methodExcuTime.setGeExecTime(execTime);
				}
				if (result.getString("field").equals("execMethod")
						&& result.getString("op").equals("cn")) {
					methodExcuTime.setLikeExecMethod(result.getString("data")
							.trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				methodExcuTime.setFlag("OR");
			} else {
				methodExcuTime.setFlag("AND");
			}
		}
		methodExcuTime.setPage(page);
		methodExcuTime.setRows(rows);
		Long totalCount = methodExcuTimeService.getCount(methodExcuTime);
		List<MethodExcuTime> queryResult = methodExcuTimeService
				.getList(methodExcuTime);
		JqGridPageView<MethodExcuTime> methodExcuTimeListView = new JqGridPageView<MethodExcuTime>();
		methodExcuTimeListView.setMaxResults(rows);
		methodExcuTimeListView.setRows(queryResult);
		methodExcuTimeListView.setRecords(totalCount);
		writeJSON(response, methodExcuTimeListView);
	}

	// 操作服务方法执行时间页面的删除、导出Excel
	@RequestMapping(value = "/operateMethodExcuTime", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateMethodExcuTime(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteMethodExcuTime(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=sysmethodtime.xls");
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

	// 删除服务方法执行时间记录
	@RequestMapping("/deleteMethodExcuTime")
	public void deleteMethodExcuTime(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = methodExcuTimeService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

}
