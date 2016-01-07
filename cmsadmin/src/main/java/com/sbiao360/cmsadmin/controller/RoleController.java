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
import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.RoleService;
import com.sbiao360.core.support.ExtJSBaseParameter;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 角色的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController extends JavaEEFrameworkBaseController<Role>
		implements Constant {

	@Resource
	private RoleService roleService;

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("roleKey", "ROLE_KEY");
		sortedMap.put("createDate", "CREATE_DATE");
		sortedMap.put("updateDate", "UPDATE_DATE");
	}

	// 查询角色的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getRole", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getRole(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		String sortedObject = request.getParameter("sidx");
		String sortedValue = request.getParameter("sord");
		String filters = request.getParameter("filters");
		if (null != filters) {
			filters = URLDecoder.decode(request.getParameter("filters"),
					"UTF-8");
		}
		Role role = new Role();
		role.setSortedObject(sortedMap.get(sortedObject));
		role.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("roleKey")
						&& result.getString("op").equals("eq")) {
					role.setEqRoleKey(result.getString("data").trim());
				}
				if (result.getString("field").equals("roleName")
						&& result.getString("op").equals("cn")) {
					role.setLikeRoleName(result.getString("data").trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				role.setFlag("OR");
			} else {
				role.setFlag("AND");
			}
		}
		role.setPage(page);
		role.setRows(rows);
		Long totalCount = roleService.getCount(role);
		List<Role> queryResult = roleService.getList(role);
		JqGridPageView<Role> roleListView = new JqGridPageView<Role>();
		roleListView.setMaxResults(rows);
		roleListView.setRows(queryResult);
		roleListView.setRecords(totalCount);
		writeJSON(response, roleListView);
	}

	// 保存角色的实体
	@RequestMapping(value = "/saveRole", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doSave(Role entity, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
		if (CMD_EDIT.equals(parameter.getCmd())) {
			roleService.update(entity);
		} else if (CMD_NEW.equals(parameter.getCmd())) {
			roleService.save(entity);
		}
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 操作角色的删除、导出Excel、字段判断和保存
	@RequestMapping(value = "/operateRole", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void operateRole(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteRole(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=role.xls");
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
			String roleKey = request.getParameter("roleKey");
			String roleName = request.getParameter("roleName");
			String status = request.getParameter("statusCn");
			String note = request.getParameter("note");
			Role role = null;
			SysUser sysUser = (SysUser) request.getSession().getAttribute(
					SESSION_SYS_USER);
			if (oper.equals("edit")) {
				role = roleService.getByPrimaryKey(Long.valueOf(id));
			}
			boolean existRoleKey = roleService.existRoleKey(roleKey);
			if (StringUtils.isBlank(roleKey) || StringUtils.isBlank(roleName)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写角色编码和角色名称");
				writeJSON(response, result);
			} else if (existRoleKey && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此角色编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (existRoleKey
					&& !role.getRoleKey().equalsIgnoreCase(roleKey)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此角色编码已存在，请重新输入");
				writeJSON(response, result);
			} else {
				Role entity = new Role();
				entity.setRoleKey(roleKey);
				entity.setRoleName(roleName);
				entity.setStatus(Short.parseShort(status));
				entity.setNote(note);
				if (oper.equals("edit")) {
					entity.setId(Long.valueOf(id));
					entity.setCmd("edit");
					entity.setPermissions(role.getPermissions());
					entity.setCreateDate(role.getCreateDate());
					entity.setCreateUserId(role.getCreateUserId());
					entity.setUpdateDate(new Date());
					entity.setUpdateUserId(sysUser.getId());
					doSave(entity, request, response);
				} else if (oper.equals("add")) {
					entity.setCreateDate(new Date());
					entity.setCreateUserId(sysUser.getId());
					entity.setUpdateDate(new Date());
					entity.setUpdateUserId(sysUser.getId());
					entity.setCmd("new");
					// Set<String> permissions = new HashSet<String>();
					// permissions.add(roleKey + ":*");
					// entity.setPermissions(permissions);
					doSave(entity, request, response);
				}
			}
		}
	}

	// 删除角色
	@RequestMapping("/deleteRole")
	public void deleteRole(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = roleService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

	// 获取角色的下拉框
	@RequestMapping(value = "/getRoleSelectList", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void getRoleSelectList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Role> roleList = roleService.getDropDownList();
		StringBuilder builder = new StringBuilder();
		builder.append("<select>");
		for (int i = 0; i < roleList.size(); i++) {
			Role role = roleList.get(i);
			builder.append("<option value='" + role.getRoleKey() + "'>"
					+ role.getRoleName() + "</option>");
		}
		builder.append("</select>");
		writeJSON(response, builder.toString());
	}

}
