package com.sbiao360.cmsadmin.controller;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbiao360.cmsadmin.core.Constant;
import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.CustBrowseUrl;
import com.sbiao360.cmsadmin.service.CustBrowseUrlService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 用户浏览轨迹的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/custbrowseurl")
public class CustBrowseUrlController extends
		JavaEEFrameworkBaseController<CustBrowseUrl> implements Constant {

	@Resource
	private CustBrowseUrlService custBrowseUrlService;

	// 查询状态监控的表格，包括分页
	@RequestMapping(value = "/getCustBrowseUrl", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getCustBrowseUrl(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		CustBrowseUrl custBrowseUrl = new CustBrowseUrl();
		long start = (page - 1) * rows;
		long end = page * rows - 1;
		Long totalCount = custBrowseUrlService.getCount(custBrowseUrl
				.getObjectKey());
		List<CustBrowseUrl> queryResult = custBrowseUrlService.getList(
				custBrowseUrl.getObjectKey(), start, end);
		JqGridPageView<CustBrowseUrl> custBrowseUrlListView = new JqGridPageView<CustBrowseUrl>();
		custBrowseUrlListView.setMaxResults(rows);
		custBrowseUrlListView.setRows(queryResult);
		custBrowseUrlListView.setRecords(totalCount);
		writeJSON(response, custBrowseUrlListView);
	}

	// 操作状态监控的导出Excel
	@RequestMapping(value = "/operateCustBrowseUrl", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateCustBrowseUrl(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=custbrowseurl.xls");
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

}
