package com.sbiao360.cmsadmin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sbiao360.cmsadmin.core.Constant;
import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.CustBehavior;
import com.sbiao360.cmsadmin.service.CustBehaviorService;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 用户行为-实时展示的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/custbehavior")
public class CustBehaviorController extends
		JavaEEFrameworkBaseController<CustBehavior> implements Constant {

	@Resource
	private CustBehaviorService custBehaviorService;

	// Redis缓存服务器查询用户行为列表
	@RequestMapping(value = "/getCustBehaviorRedis", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getCustBehaviorRedis(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int rows = 10;
		// 0表示链表头部的第一个元素
		Long start = 0L;
		// -1将表示链表中的最后一个元素，即尾部元素
		Long end = -1L;
		List<CustBehavior> queryResult = custBehaviorService.getListRedis(
				CustBehavior.OBJECT_KEY, start, end);
		Long totalCount = (long) queryResult.size();
		JqGridPageView<CustBehavior> custBehaviorListView = new JqGridPageView<CustBehavior>();
		custBehaviorListView.setMaxResults(rows);
		custBehaviorListView.setRows(queryResult);
		custBehaviorListView.setRecords(totalCount);
		writeJSON(response, custBehaviorListView);
	}

}
