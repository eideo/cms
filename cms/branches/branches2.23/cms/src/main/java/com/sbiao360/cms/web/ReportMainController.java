package com.sbiao360.cms.web;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.domain.ReportDirectory;
import com.sbiao360.cms.domain.ReportMain;
import com.sbiao360.cms.domain.ReportMainTop;
import com.sbiao360.cms.service.ReportDirectoryService;
import com.sbiao360.cms.service.ReportMainService;

/**
 * 行业报告的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping
public class ReportMainController extends BaseController {

	@Resource
	private ReportMainService reportMainService;

	@Resource
	private ReportDirectoryService reportDirectoryService;

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String reportPage(HttpServletRequest request,
			HttpServletResponse response) {
		ReportMain reportMain = new ReportMain();
		doReportPage(request, reportMain);

		return "report";
	}

	@RequestMapping(value = "/report/{induxtry}", method = RequestMethod.GET)
	public String reportPage(@PathVariable String induxtry,
			HttpServletRequest request, HttpServletResponse response) {
		ReportMain reportMain = new ReportMain();
		if (!"".equals(induxtry)) {
			reportMain.setReportInduxtry(induxtry);
		}
		doReportPage(request, reportMain);

		return "report";
	}

	public void doReportPage(HttpServletRequest request, ReportMain reportMain) {
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			request.setAttribute("username", assertion.getPrincipal().getName());
		}

		// 当前页数
		int currentPage = 1;
		// 每页显示数目
		int pageSize = 10;

		int totalCount = reportMainService.getCount(reportMain);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		List<ReportMain> reportMainList = reportMainService.getList(
				currentPage, pageSize, reportMain);
		List<ReportMain> reportMainListTop10 = reportMainService.getListTop10();
		List<ReportMain> reportMainListCarousel = reportMainService
				.getListCarousel();

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("reportMainList", reportMainList);
		request.setAttribute("reportMainListTop10", reportMainListTop10);
		request.setAttribute("reportMainListCarousel", reportMainListCarousel);
		// request.setAttribute("notSearch", "true");
		request.setAttribute("induxtryId", reportMain.getReportInduxtry());
	}

	@RequestMapping(value = "/report/ajaxReport", method = RequestMethod.POST)
	public void ajaxReport(
			@RequestParam(value = "currentPage", required = false) int currentPage,
			@RequestParam(value = "induxtry", required = false) String induxtry,
			HttpServletRequest request, HttpServletResponse response) {
		// 每页显示数目
		int pageSize = 10;
		ReportMain reportMain = new ReportMain();
		reportMain.setReportInduxtry(induxtry);
		int totalCount = reportMainService.getCount(reportMain);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		List<ReportMain> reportMainList = reportMainService.getList(
				currentPage, pageSize, reportMain);

		JSONObject result = new JSONObject();
		result.put("currentPage", currentPage);
		result.put("totalCount", totalCount);
		result.put("totalPage", totalPage);
		result.put("reportMainList", reportMainList);
		result.put("success", true);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/reportdetail/{id}", method = RequestMethod.GET)
	public String reportDetail(@PathVariable Long id,
			HttpServletRequest request, HttpServletResponse response) {
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			request.setAttribute("username", assertion.getPrincipal().getName());
		}

		ReportMain reportMain = reportMainService.getByPrimaryKey(id);
		reportMain.setReportUrl(URLEncoder.encode(reportMain.getReportUrl()));
		List<ReportMain> reportMainListTop10 = reportMainService.getListTop10();
		reportMainService.updateReportHits(reportMain);

		List<ReportDirectory> reportDirectoryListOne = reportDirectoryService
				.getListByReportId(id);
		for (ReportDirectory reportDirectoryOne : reportDirectoryListOne) {
			List<ReportDirectory> reportDirectoryListTwo = reportDirectoryService
					.getListByDirParentId(reportDirectoryOne.getId());
			for (ReportDirectory reportDirectoryTwo : reportDirectoryListTwo) {
				List<ReportDirectory> reportDirectoryListThree = reportDirectoryService
						.getListByDirParentId(reportDirectoryTwo.getId());
				reportDirectoryTwo
						.setReportDirectoryList(reportDirectoryListThree);
			}
			reportDirectoryOne.setReportDirectoryList(reportDirectoryListTwo);
		}
		reportMain.setReportDirectoryList(reportDirectoryListOne);

		request.setAttribute("reportMain", reportMain);
		request.setAttribute("reportMainListTop10", reportMainListTop10);
		request.setAttribute("notSearch", "true");

		return "reportDetail";
	}

	@RequestMapping(value = "/report/getListTop5", method = RequestMethod.POST)
	public void getListTop5(
			@RequestParam(value = "induxtry", required = false) String induxtry,
			HttpServletRequest request, HttpServletResponse response) {
		// 行业指数底部热门报告显示条数
		int totalReport = 5;
		List<ReportMainTop> lessResult = new ArrayList<ReportMainTop>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		ReportMainTop reportMainTop = new ReportMainTop();
		reportMainTop.setReportInduxtry(induxtry);
		List<ReportMainTop> reportList = reportMainService
				.getListTop5(reportMainTop);
		if (null != reportList) {
			if (reportList.size() == 0) {
				paraMap.put("num", 5);
				reportList = reportMainService.getListTop5Default(paraMap);
			} else {
				int lessNum = totalReport - reportList.size();
				paraMap.put("reportInduxtry", induxtry);
				paraMap.put("num", lessNum);
				lessResult = reportMainService.getListTop5Default(paraMap);
				reportList.addAll(lessResult);
			}
		}

		JSONObject result = new JSONObject();
		result.put("reportList", reportList);
		result.put("success", true);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/report/getSuggest", method = RequestMethod.POST)
	public void getSuggest(
			@RequestParam(value = "keywords", required = false) String keywords,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("keywords", keywords);
		List<String> resultList = reportMainService.getListSuggest(paraMap);

		JSONObject result = new JSONObject();
		result.put("status", true);
		result.put("resultList", resultList);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/report/searchReport", method = RequestMethod.POST)
	public void searchReport(
			@RequestParam(value = "currentPage", required = false) int currentPage,
			@RequestParam(value = "searchWords", required = false) String searchWords,
			HttpServletRequest request, HttpServletResponse response) {
		// 每页显示数目
		int pageSize = 10;
		ReportMain reportMain = new ReportMain();
		reportMain.setReportTitle(searchWords);
		int totalCount = reportMainService.getCountSearch(reportMain);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		List<ReportMain> reportMainList = reportMainService.getListSearch(
				currentPage, pageSize, reportMain);

		JSONObject result = new JSONObject();
		result.put("currentPage", currentPage);
		result.put("totalCount", totalCount);
		result.put("totalPage", totalPage);
		result.put("reportMainList", reportMainList);
		result.put("success", true);

		ajaxJson(result.toJSONString(), response);
	}

}
