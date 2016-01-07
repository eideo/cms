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
import com.sbiao360.cmsadmin.model.BehaviorSequence;
import com.sbiao360.cmsadmin.service.BehaviorSequenceService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 行为序列的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/behaviorsequence")
public class BehaviorSequenceController extends
		JavaEEFrameworkBaseController<BehaviorSequence> implements Constant {

	@Resource
	private BehaviorSequenceService behaviorSequenceService;

	// 查询状态监控的表格，包括分页
	@RequestMapping(value = "/getBehaviorSequence", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getBehaviorSequence(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		BehaviorSequence behaviorSequence = new BehaviorSequence();
		long start = (page - 1) * rows;
		long end = page * rows - 1;
		Long totalCount = behaviorSequenceService.getCount(behaviorSequence
				.getObjectKey());
		List<BehaviorSequence> queryResult = behaviorSequenceService.getList(
				behaviorSequence.getObjectKey(), start, end);
		JqGridPageView<BehaviorSequence> behaviorSequenceListView = new JqGridPageView<BehaviorSequence>();
		behaviorSequenceListView.setMaxResults(rows);
		behaviorSequenceListView.setRows(queryResult);
		behaviorSequenceListView.setRecords(totalCount);
		writeJSON(response, behaviorSequenceListView);
	}

	// 操作状态监控的导出Excel
	@RequestMapping(value = "/operateBehaviorSequence", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateBehaviorSequence(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=behaviorsequence.xls");
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
