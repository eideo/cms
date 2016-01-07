package com.sbiao360.cmsadmin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Date;
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
import com.sbiao360.cmsadmin.model.Department;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.DepartmentService;
import com.sbiao360.core.support.ExtJSBaseParameter;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 部门的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/department")
public class DepartmentController extends
		JavaEEFrameworkBaseController<Department> implements Constant {

	@Resource
	private DepartmentService departmentService;

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("deptKey", "DEPT_KEY");
		sortedMap.put("createDate", "CREATE_DATE");
	}

	// 查询部门的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getDepartment", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getDepartment(HttpServletRequest request,
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
		Department department = new Department();
		department.setSortedObject(sortedMap.get(sortedObject));
		department.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("deptKey")
						&& result.getString("op").equals("eq")) {
					department.setEqDeptKey(result.getString("data").trim());
				}
				if (result.getString("field").equals("deptName")
						&& result.getString("op").equals("cn")) {
					department.setLikeDeptName(result.getString("data").trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				department.setFlag("OR");
			} else {
				department.setFlag("AND");
			}
		}
		department.setPage(page);
		department.setRows(rows);
		Long totalCount = departmentService.getCount(department);
		List<Department> queryResult = departmentService.getList(department);
		JqGridPageView<Department> departmentListView = new JqGridPageView<Department>();
		departmentListView.setMaxResults(rows);
		departmentListView.setRows(queryResult);
		departmentListView.setRecords(totalCount);
		writeJSON(response, departmentListView);
	}

	// 保存部门的实体
	@RequestMapping(value = "/saveDepartment", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doSave(Department entity, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
		if (CMD_EDIT.equals(parameter.getCmd())) {
			departmentService.update(entity);
		} else if (CMD_NEW.equals(parameter.getCmd())) {
			departmentService.save(entity);
		}
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 操作部门的删除、导出Excel、字段判断和保存
	@RequestMapping(value = "/operateDepartment", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void operateDepartment(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteDepartment(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=department.xls");
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
			String deptKey = request.getParameter("deptKey");
			String deptName = request.getParameter("deptName");
			String parentDeptKey = request.getParameter("parentDeptName");
			String note = request.getParameter("note");
			Department department = null;
			if (oper.equals("edit")) {
				department = departmentService
						.getByPrimaryKey(Long.valueOf(id));
			}
			boolean existDeptKey = departmentService.existDeptKey(deptKey);
			boolean existParentDeptKey = departmentService
					.existParentDeptKey(parentDeptKey);
			if (StringUtils.isBlank(deptKey) || StringUtils.isBlank(deptName)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写部门编码和部门名称");
				writeJSON(response, result);
			} else if (existDeptKey && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此部门编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (existDeptKey
					&& !department.getDeptKey().equalsIgnoreCase(deptKey)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此部门编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (StringUtils.isNotBlank(parentDeptKey)
					&& !existParentDeptKey) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "上级部门编码输入有误，请重新输入");
				writeJSON(response, result);
			} else if (StringUtils.isNotBlank(parentDeptKey)
					&& parentDeptKey.equals(deptKey)) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "不能选择自己作为上级部门，请重新输入");
				writeJSON(response, result);
			} else {
				Department entity = new Department();
				entity.setDeptKey(deptKey);
				entity.setDeptName(deptName);
				entity.setParentDeptKey(parentDeptKey);
				entity.setCreateDate(new Date());
				SysUser sysUser = (SysUser) request.getSession().getAttribute(
						SESSION_SYS_USER);
				entity.setCreateUserId(sysUser.getId());
				entity.setNote(note);
				if (oper.equals("edit")) {
					entity.setId(Long.valueOf(id));
					entity.setCmd("edit");
					doSave(entity, request, response);
				} else if (oper.equals("add")) {
					entity.setCmd("new");
					doSave(entity, request, response);
				}
			}
		}
	}

	// 删除部门
	@RequestMapping("/deleteDepartment")
	public void deleteDepartment(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = departmentService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

	// 获取部门的下拉框
	@RequestMapping(value = "/getDepartmentSelectList", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getDepartmentSelectList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Department> departmentList = departmentService.getDropDownList();
		StringBuilder builder = new StringBuilder();
		builder.append("<select>");
		for (int i = 0; i < departmentList.size(); i++) {
			builder.append("<option value='" + departmentList.get(i).getId()
					+ "'>" + departmentList.get(i).getDeptName() + "</option>");
		}
		builder.append("</select>");
		writeJSON(response, builder.toString());
	}

	// 获取部门的下拉框(不包括自身)
	@RequestMapping(value = "/getDeptSelectNoSelfList", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getDepartmentSelectNoSelfList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String deptKey = request.getParameter("deptKey") == null ? "" : request
				.getParameter("deptKey");
		List<Department> departmentList = departmentService
				.getDeptSelectNoSelfList(deptKey);
		StringBuilder builder = new StringBuilder();
		builder.append("<select><option value=''></option>");
		for (int i = 0; i < departmentList.size(); i++) {
			Department department = departmentList.get(i);
			builder.append("<option value='" + department.getDeptKey() + "'>"
					+ department.getDeptName() + "</option>");
		}
		builder.append("</select>");
		writeJSON(response, builder.toString());
	}

}
