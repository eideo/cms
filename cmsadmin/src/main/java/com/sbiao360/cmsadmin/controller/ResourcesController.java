package com.sbiao360.cmsadmin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.cmsadmin.model.RoleResources;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.ResourcesService;
import com.sbiao360.cmsadmin.service.RoleResourcesService;
import com.sbiao360.core.support.ExtJSBaseParameter;
import com.sbiao360.core.support.JqGridPageView;

/**
 * 菜单的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/authority")
public class ResourcesController extends
		JavaEEFrameworkBaseController<Resources> implements Constant {

	@Resource
	private ResourcesService resourcesService;

	@Resource
	private RoleResourcesService roleResourcesService;

	private static Map<String, String> dataMap = new HashMap<String, String>();

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		dataMap.put("add", "新增");
		dataMap.put("edit", "编辑");
		dataMap.put("delete", "删除");
		dataMap.put("view", "查看");
		dataMap.put("search", "搜索");
		dataMap.put("export", "导出");
		sortedMap.put("id", "ID");
		sortedMap.put("resourceCode", "RESOURCE_CODE");
		sortedMap.put("sequence", "SEQUENCE");
	}

	// 查询菜单的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getAuthority", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getAuthority(HttpServletRequest request,
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
		Resources authority = new Resources();
		authority.setSortedObject(sortedMap.get(sortedObject));
		authority.setSortedValue(sortedValue);
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("resourceCode")
						&& result.getString("op").equals("eq")) {
					authority
							.setEqResourceCode(result.getString("data").trim());
				}
				if (result.getString("field").equals("resourceName")
						&& result.getString("op").equals("cn")) {
					authority.setLikeResourceName(result.getString("data")
							.trim());
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				authority.setFlag("OR");
			} else {
				authority.setFlag("AND");
			}
		}
		authority.setPage(page);
		authority.setRows(rows);
		Long totalCount = resourcesService.getCount(authority);
		List<Resources> queryResult = resourcesService.getList(authority);
		JqGridPageView<Resources> authorityListView = new JqGridPageView<Resources>();
		authorityListView.setMaxResults(rows);
		authorityListView.setRows(queryResult);
		authorityListView.setRecords(totalCount);
		writeJSON(response, authorityListView);
	}

	// 保存菜单的实体
	@RequestMapping(value = "/saveAuthority", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doSave(Resources entity, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
		if (CMD_EDIT.equals(parameter.getCmd())) {
			resourcesService.update(entity);
		} else if (CMD_NEW.equals(parameter.getCmd())) {
			String roleKey = ((SysUser) request.getSession().getAttribute(
					SESSION_SYS_USER)).getRoleKey();
			resourcesService.save(entity, roleKey);
		}
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 操作菜单的删除、导出Excel、字段判断和保存
	@RequestMapping(value = "/operateAuthority", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void operateAuthority(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteAuthority(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=resources.xls");
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
			String resourceCode = request.getParameter("resourceCode");
			String resourceName = request.getParameter("resourceName");
			String resourceUrl = request.getParameter("resourceUrl");
			String sequence = request.getParameter("sequence");
			String parentResourceCode = request
					.getParameter("parentResourceCode");
			String resourceType = request.getParameter("resourceTypeCn");
			String status = request.getParameter("statusCn");
			String operAuthority = request.getParameter("operAuthority");
			if (StringUtils.isBlank(parentResourceCode)) {
				parentResourceCode = "0";
			}
			Resources authority = null;
			if (oper.equals("edit")) {
				authority = resourcesService.getByPrimaryKey(Long.valueOf(id));
			}
			boolean existResourceCode = resourcesService
					.existResourceCode(resourceCode);
			boolean existParentResourceCode = resourcesService
					.existParentResourceCode(parentResourceCode);
			if (StringUtils.isBlank(resourceCode)
					|| StringUtils.isBlank(resourceName)
					|| StringUtils.isBlank(resourceUrl)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写资源编码、资源名称、资源url属性值");
				writeJSON(response, result);
			} else if (existResourceCode && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此资源编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (existResourceCode
					&& !authority.getResourceCode().equalsIgnoreCase(
							resourceCode) && oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此资源编码已存在，请重新输入");
				writeJSON(response, result);
			} else if (!parentResourceCode.equals("0")
					&& !existParentResourceCode) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "上级资源编码输入有误，请重新输入");
				writeJSON(response, result);
			} else {
				Resources entity = new Resources();
				entity.setResourceUrl(resourceUrl);
				String resourceClass = "menu-icon fa fa-caret-right";
				entity.setResourceCode(resourceCode);
				entity.setResourceName(resourceName);
				entity.setParentResourceCode(parentResourceCode);
				entity.setSequence(sequence == "" ? null : Integer
						.valueOf(sequence));
				entity.setResourceType(Short.parseShort(resourceType));
				if (entity.getResourceType() == 0) {
					resourceClass = "menu-icon fa fa-caret-right";
				} else if (entity.getResourceType() == 1) {
					resourceClass = "menu-icon fa fa-list";
				}
				entity.setResourceClass(resourceClass);
				entity.setStatus(Short.parseShort(status));
				entity.setOperAuthority(operAuthority);
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

	// 删除菜单
	@RequestMapping("/deleteAuthority")
	public void deleteAuthority(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		int flag = resourcesService.delete(ids);
		if (flag > 0) {
			writeJSON(response, "{success:true}");
		} else {
			writeJSON(response, "{success:false}");
		}
	}

	// 获取菜单树
	@RequestMapping("/getAuthorityTreeList")
	public void getAuthorityTreeList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String roleKey = request.getParameter("roleKey");

		List<Resources> allAuthority = resourcesService.getListAll();
		Set<String> parentMenuCodeSet = new HashSet<String>();
		for (int i = 0; i < allAuthority.size(); i++) {
			Resources resources = allAuthority.get(i);
			parentMenuCodeSet.add(resources.getParentResourceCode());
		}

		List<RoleResources> roleAuthorityList = roleResourcesService
				.getListByRoleKey(roleKey);
		List<String> menuCodeList = new ArrayList<String>();
		Map<String, String> menuPermissionsMap = new HashMap<String, String>();
		for (int j = 0; j < roleAuthorityList.size(); j++) {
			RoleResources roleResources = roleAuthorityList.get(j);
			menuCodeList.add(roleResources.getResourceCode());
			if (roleResources.getPermissions() != null
					&& !"".equals(roleResources.getPermissions())) {
				menuPermissionsMap.put(roleResources.getRoleKey() + "|"
						+ roleResources.getResourceCode(),
						roleResources.getPermissions());
			}
		}

		JSONObject allJSONObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		List<Resources> subMenuList = resourcesService
				.getListtByParentResourceCode(id);

		if (subMenuList != null && subMenuList.size() > 0) {
			for (int i = 0; i < subMenuList.size(); i++) {
				Resources resources = subMenuList.get(i);
				if ("role".equals(resources.getResourceCode())) {
					continue;
				}
				JSONObject subJsonObject = new JSONObject();
				subJsonObject.element("id", resources.getResourceCode());
				subJsonObject.element("name", resources.getResourceName());

				if (parentMenuCodeSet.contains(id)) {
					subJsonObject.element("type", "folder");
					subJsonObject.element("children", true);
				} else {
					subJsonObject.element("type", "item");
				}

				if (menuCodeList.contains(resources.getResourceCode())) {
					subJsonObject.element("item-selected", true);
				} else {
					subJsonObject.element("item-selected", false);
				}

				subJsonObject.element("additionalParameters", subJsonObject);
				jsonArray.add(subJsonObject);
			}
		}

		Resources resource = resourcesService.getByResourceCode(id);
		if (resource != null && resource.getResourceType().shortValue() == 0) {
			String permissions = "";
			String operAuthority = resource.getOperAuthority();
			String permissionsKey = roleKey + "|" + id;
			if (menuPermissionsMap.containsKey(permissionsKey)) {
				permissions = menuPermissionsMap.get(permissionsKey);
			}

			String[] operAuthorityArr = operAuthority.split(",");
			Map<String, String> operMap = new HashMap<String, String>();
			for (String oper : operAuthorityArr) {
				operMap.put(oper, dataMap.get(oper));
			}

			for (Map.Entry<String, String> entry : operMap.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();

				JSONObject subJsonObject = new JSONObject();
				subJsonObject.element("id", permissionsKey + "|" + key);
				subJsonObject.element("name", value);
				subJsonObject.element("type", "folder");
				subJsonObject.element("children", true);
				if (permissions.indexOf(key) > -1) {
					subJsonObject.element("item-selected", true);
				} else {
					subJsonObject.element("item-selected", false);
				}

				subJsonObject.element("additionalParameters", subJsonObject);
				jsonArray.add(subJsonObject);
			}
		}

		allJSONObject.element("status", "OK");
		allJSONObject.element("data", jsonArray);
		writeJSON(response, allJSONObject);
	}

}
