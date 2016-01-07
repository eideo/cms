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
import com.sbiao360.cmsadmin.model.SysStatusMonitor;
import com.sbiao360.cmsadmin.service.SysStatusMonitorService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 状态监控的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/sysstatusmonitor")
public class SysStatusMonitorController extends
		JavaEEFrameworkBaseController<SysStatusMonitor> implements Constant {

	@Resource
	private SysStatusMonitorService sysStatusMonitorService;

	// 查询状态监控的表格，包括分页
	@RequestMapping(value = "/getSysStatusMonitor", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getSysStatusMonitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		SysStatusMonitor sysStatusMonitor = new SysStatusMonitor();
		long start = (page - 1) * rows;
		long end = page * rows - 1;
		Long totalCount = sysStatusMonitorService.getCount(sysStatusMonitor
				.getObjectKey());
		List<SysStatusMonitor> queryResult = sysStatusMonitorService.getList(
				sysStatusMonitor.getObjectKey(), start, end);
		JqGridPageView<SysStatusMonitor> sysStatusMonitorListView = new JqGridPageView<SysStatusMonitor>();
		sysStatusMonitorListView.setMaxResults(rows);
		sysStatusMonitorListView.setRows(queryResult);
		sysStatusMonitorListView.setRecords(totalCount);
		writeJSON(response, sysStatusMonitorListView);
	}

	// 操作状态监控的导出Excel
	@RequestMapping(value = "/operateSysStatusMonitor", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateSysStatusMonitor(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=sysstatusmonitor.xls");
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
