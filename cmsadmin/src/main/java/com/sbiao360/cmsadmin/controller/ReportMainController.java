package com.sbiao360.cmsadmin.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.RequestContext;

import com.sbiao360.cmsadmin.core.Constant;
import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.ReportDirectory;
import com.sbiao360.cmsadmin.model.ReportInduxtry;
import com.sbiao360.cmsadmin.model.ReportMain;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.ReportDirectoryService;
import com.sbiao360.cmsadmin.service.ReportMainService;
import com.sbiao360.core.support.ExtJSBaseParameter;
import com.sbiao360.core.support.JqGridPageView;
import com.sbiao360.core.util.DateUtil;
import com.sbiao360.core.util.JavaEEFrameworkUtils;
import com.sbiao360.core.util.WordUtil;
import com.sbiao360.fd.ext.EntityStorer;
import com.sbiao360.fd.ext.FdfsStoreEntity;

/**
 * 行业报告的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/reportmain")
public class ReportMainController extends
		JavaEEFrameworkBaseController<ReportMain> implements Constant {

	@Resource
	private ReportMainService reportMainService;

	@Resource
	private ReportDirectoryService reportDirectoryService;

	private EntityStorer audioStorer;

	@Resource(name = "audioStorer")
	public void setAudioStorer(EntityStorer audioStorer) {
		this.audioStorer = audioStorer;
	}

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("updateTime", "UPDATE_TIME");
		sortedMap.put("reportPrice", "REPORT_PRICE");
		sortedMap.put("reportDiscount", "REPORT_DISCOUNT");
	}

	// 查询行业报告的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getReportMain", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getReportMain(HttpServletRequest request,
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
		ReportMain reportMain = new ReportMain();
		reportMain.setSortedObject(sortedMap.get(sortedObject));
		reportMain.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("reportName")
						&& result.getString("op").equals("cn")) {
					reportMain.setLikeReportName(result.getString("data")
							.trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				reportMain.setFlag("OR");
			} else {
				reportMain.setFlag("AND");
			}
		}
		reportMain.setPage(page);
		reportMain.setRows(rows);
		Long totalCount = reportMainService.getCount(reportMain);
		List<ReportMain> queryResult = reportMainService.getList(reportMain);
		JqGridPageView<ReportMain> reportMainListView = new JqGridPageView<ReportMain>();
		reportMainListView.setMaxResults(rows);
		reportMainListView.setRows(queryResult);
		reportMainListView.setRecords(totalCount);
		writeJSON(response, reportMainListView);
	}

	// 保存行业报告的实体
	@RequestMapping(value = "/saveReportMain", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doSave(ReportMain entity, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
		JSONObject result = new JSONObject();
		if (CMD_EDIT.equals(parameter.getCmd())) {
			reportMainService.updateEdit(entity);
		} else if (CMD_NEW.equals(parameter.getCmd())) {
			reportMainService.save(entity);
		}
		// parameter.setSuccess(true);
		// writeJSON(response, parameter);
		result.put("success", true);
		result.put("id", entity.getId());
		result.put("cmd", entity.getCmd());
		writeJSON(response, result.toString());
	}

	// 操作行业报告的删除、导出Excel、字段判断和保存
	@RequestMapping(value = "/operateReportMain", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateReportMain(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteReportMain(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=reportmain.xls");
				OutputStream out = response.getOutputStream();
				out.write(URLDecoder.decode(request.getParameter("csvBuffer"),
						"UTF-8").getBytes());
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			// String reportTitle = request.getParameter("reportTitle");
			String reportAbstract = request.getParameter("reportAbstract");
			String reportPrice = request.getParameter("reportPrice");
			String reportDiscount = request.getParameter("reportDiscount");
			String reportInduxtry = request.getParameter("reportInduxtryCn");
			String reportOnlineFlag = request
					.getParameter("reportOnlineFlagCn");
			// String reportTag = request.getParameter("reportTag");
			String reportTag = "";
			/*
			 * if (StringUtils.isBlank(reportTitle)) {
			 * response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
			 * result.put("message", "请填写标题"); writeJSON(response, result); }
			 * else
			 */
			if (StringUtils.isBlank(reportAbstract)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写摘要");
				writeJSON(response, result);
			} else if (StringUtils.isBlank(reportPrice)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写价格");
				writeJSON(response, result);
			} else {
				ReportMain entity = new ReportMain();
				// entity.setReportTitle(reportTitle.trim());
				entity.setReportAbstract(reportAbstract.trim());
				BigDecimal reportPriceBd = new BigDecimal(reportPrice);
				reportPriceBd.setScale(2, BigDecimal.ROUND_HALF_UP);
				entity.setReportPrice(reportPriceBd);
				if (null != reportDiscount && !"".equals(reportDiscount)) {
					BigDecimal reportDiscountBd = new BigDecimal(reportDiscount);
					BigDecimal reportTpriceBd = getMultiplyVal(reportPriceBd,
							reportDiscountBd);
					entity.setReportTprice(reportTpriceBd);
					entity.setReportDiscount(reportDiscountBd);
				} else {
					entity.setReportTprice(reportPriceBd);
					entity.setReportDiscount(null);
				}
				entity.setReportInduxtry(reportInduxtry);
				entity.setReportPages(0);
				entity.setReportWords(0);
				entity.setReportAttentions(0);
				entity.setReportHits(0);
				entity.setReportSales(0);
				entity.setReportHisFlag((byte) 0);
				entity.setReportOnlineFlag(Byte.parseByte(reportOnlineFlag));
				entity.setReportTag(reportTag);
				SysUser sysUser = (SysUser) request.getSession().getAttribute(
						SESSION_SYS_USER);
				if (oper.equals("edit")) {
					entity.setId(Long.valueOf(id));
					entity.setCmd("edit");
					entity.setUpdateTime(new Date());
					entity.setUpdateUserId(sysUser.getId());
					doSave(entity, request, response);
				} else if (oper.equals("add")) {
					entity.setCmd("new");
					entity.setCreateTime(new Date());
					entity.setCreateUserId(sysUser.getId());
					entity.setUpdateTime(new Date());
					entity.setUpdateUserId(sysUser.getId());
					doSave(entity, request, response);
				}
			}
		}
	}

	// 删除行业报告
	@RequestMapping("/deleteReportMain")
	public void deleteReportMain(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = reportMainService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

	// 上传文件
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFile(MultipartHttpServletRequest multipartRequest,
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "cmd", required = false) String cmd,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject result = new JSONObject();
		RequestContext requestContext = new RequestContext(request);
		Iterator<String> iterator = multipartRequest.getFileNames();
		ReportMain reportMain = reportMainService.getByPrimaryKey(id);
		if ("new".equals(cmd)) {
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				MultipartFile fileDetail = multipartRequest.getFile(key);

				if ((fileDetail != null) && (fileDetail.getSize() > 0)) {
					/*
					 * String subFilePath = "report/"; if
					 * ("reportImage".equals(key)) { subFilePath += "image/" +
					 * id + "/"; } else if ("reportName".equals(key)) {
					 * subFilePath += "doc/" + id + "/"; } else if
					 * ("reportUrl".equals(key)) { subFilePath += "pdf/" + id +
					 * "/"; }
					 */
					try {
						/*
						 * String fileName = DateUtil.formatDateToStr(
						 * "yyyyMMddHHmmssSSS", new Date()) +
						 * JavaEEFrameworkUtils.getRandomString(3) +
						 * originalFilename.substring(originalFilename
						 * .lastIndexOf("."));
						 * 
						 * String filePathName = request.getServletContext()
						 * .getRealPath( "/static/upload/" + subFilePath +
						 * DateFormatUtils.format( new Date(), "yyyyMM"));
						 * filePathName = URLDecoder.decode(filePathName,
						 * "UTF-8");
						 * 
						 * File filePath = new File(filePathName); if
						 * (!filePath.exists()) { filePath.mkdirs(); }
						 * 
						 * String path = filePath.getAbsolutePath() + "/" +
						 * fileName; fileDetail.transferTo(new File(path));
						 * 
						 * String destinationFilePath = "/static/upload/" +
						 * subFilePath + DateFormatUtils.format(new Date(),
						 * "yyyyMM") + "/" + fileName;
						 */

						if ("reportImage".equals(key)) {
							String destinationFilePath = audioStorer
									.store(new FdfsStoreEntity(fileDetail));
							reportMain.setReportImage(destinationFilePath);
						} else if ("reportName".equals(key)) {
							String originalFilename = fileDetail
									.getOriginalFilename();
							String subFilePath = "report/doc/" + id + "/";
							String fileName = DateUtil.formatDateToStr(
									"yyyyMMddHHmmssSSS", new Date())
									+ JavaEEFrameworkUtils.getRandomString(3)
									+ originalFilename
											.substring(originalFilename
													.lastIndexOf("."));

							String filePathName = request.getServletContext()
									.getRealPath(
											"/static/upload/"
													+ subFilePath
													+ DateFormatUtils.format(
															new Date(),
															"yyyyMM"));
							filePathName = URLDecoder.decode(filePathName,
									"UTF-8");

							File filePath = new File(filePathName);
							if (!filePath.exists()) {
								filePath.mkdirs();
							}

							String path = filePath.getAbsolutePath() + "/"
									+ fileName;
							fileDetail.transferTo(new File(path));

							reportMain.setReportName(originalFilename);
							String reportTitle = originalFilename.substring(0,
									originalFilename.lastIndexOf("."));
							reportMain.setReportTitle(reportTitle);
							Map<String, Integer> map = null;
							map = WordUtil.getWordProperties(path);
							if (null != map && !map.isEmpty()) {
								reportMain.setReportPages(map
										.get("reportPages"));
								reportMain.setReportWords(map
										.get("reportWords"));
							}

							LinkedHashMap<String, LinkedHashMap<String, List<String>>> catalogMap = null;
							catalogMap = WordUtil.getWordCatalog(path);
							reportDirectoryService.save(id, catalogMap);
						} else if ("reportUrl".equals(key)) {
							String destinationFilePath = audioStorer
									.store(new FdfsStoreEntity(fileDetail));
							reportMain.setReportUrl(destinationFilePath);
						}
					} catch (Exception e) {
						reportMainService.delete(id);
						e.printStackTrace();
						result.put("success", false);
						result.put("message", "上传文件失败");
						writeJSON(response, result.toString());
						return;
					}
				} else {
					reportMainService.delete(id);
					String message = "请选择需要上传的图片";
					if ("reportName".equals(key)) {
						message = "请选择需要上传的报告";
					}
					result.put("success", "checkFalse");
					result.put("message", message);
					writeJSON(response, result.toString());
					return;
				}
			}

			reportMainService.update(reportMain);
			result.put("success", true);
			result.put("message", requestContext.getMessage("g_uploadSuccess"));
			writeJSON(response, result.toString());
		} else if ("edit".equals(cmd)) {
			while (iterator.hasNext()) {
				String key = (String) iterator.next();
				MultipartFile fileDetail = multipartRequest.getFile(key);

				if ((fileDetail != null) && (fileDetail.getSize() > 0)) {
					try {
						if ("reportImage".equals(key)) {
							String destinationFilePath = audioStorer
									.store(new FdfsStoreEntity(fileDetail));
							reportMain.setReportImage(destinationFilePath);
						}
					} catch (Exception e) {
						e.printStackTrace();
						result.put("success", false);
						result.put("message", "上传文件失败");
						writeJSON(response, result.toString());
						return;
					}
				}
			}

			reportMainService.updateEdit(reportMain);
			result.put("success", true);
			result.put("message", requestContext.getMessage("g_uploadSuccess"));
			writeJSON(response, result.toString());
		}

	}

	// 获取行业下拉框
	@RequestMapping(value = "/getReportInduxtrySelectList", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getReportMainSelectList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<ReportInduxtry> reportInduxtryList = reportMainService
				.getReportInduxtrySelectList();
		StringBuilder builder = new StringBuilder();
		builder.append("<select>");
		for (int i = 0; i < reportInduxtryList.size(); i++) {
			ReportInduxtry reportInduxtry = reportInduxtryList.get(i);
			builder.append("<option value='" + reportInduxtry.getCode() + "'>"
					+ reportInduxtry.getValue() + "</option>");
		}
		builder.append("</select>");
		writeJSON(response, builder.toString());
	}

	// 获取报告对应的目录结构
	@RequestMapping(value = "/getReportDirectory", method = RequestMethod.POST)
	public void getReportDirectory(
			@RequestParam(value = "reportId", required = false) Long reportId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<ReportDirectory> reportDirectoryList = reportDirectoryService
				.getReportDirectory(reportId);
		JSONArray jsonarray = JSONArray.fromObject(reportDirectoryList);
		writeJSON(response, jsonarray.toString());
	}

	// 修改行业报告目录名称
	@RequestMapping(value = "/updateReportDirectory", method = RequestMethod.POST)
	public void updateReportDirectory(
			@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "dirConext", required = false) String dirConext,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		JSONObject result = new JSONObject();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("dirConext", dirConext);
		int flag = reportDirectoryService.updateByProperties(paramMap);
		if (flag > 0) {
			result.put("success", true);
			writeJSON(response, result.toString());
		} else {
			result.put("success", false);
			writeJSON(response, result.toString());
		}
	}

	public BigDecimal getMultiplyVal(BigDecimal reportPriceBd,
			BigDecimal reportDiscount) {
		BigDecimal defDivScale = new BigDecimal("10");
		reportPriceBd = reportPriceBd.setScale(2, BigDecimal.ROUND_HALF_UP);
		reportDiscount = reportDiscount.setScale(2, BigDecimal.ROUND_HALF_UP)
				.divide(defDivScale);
		BigDecimal reportTpriceBd = reportPriceBd.multiply(reportDiscount)
				.setScale(2, BigDecimal.ROUND_HALF_UP);
		return reportTpriceBd;
	}

}
