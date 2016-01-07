package com.sbiao360.cmsadmin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.RoleResources;
import com.sbiao360.cmsadmin.service.RolePermissionService;
import com.sbiao360.cmsadmin.service.RoleResourcesService;

/**
 * 角色权限的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/roleauthority")
public class RoleResourcesController extends
		JavaEEFrameworkBaseController<RoleResources> {

	@Resource
	private RoleResourcesService roleResourcesService;

	@Resource
	private RolePermissionService rolePermissionService;

	// 保存角色权限
	@RequestMapping(value = "/saveRoleAuthority")
	public void saveRoleAuthority(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String roleKey = request.getParameter("roleKey");
		String menuCode = request.getParameter("menuCode");
		Map<String, String> roleResourcesMap = new HashMap<String, String>();
		Map<String, String> rolePermissionsMap = new HashMap<String, String>();

		String[] menuCodeArr = menuCode.split(",");
		for (int i = 0; i < menuCodeArr.length; i++) {
			String resourceCode = menuCodeArr[i];
			if (resourceCode.indexOf("|") > -1) {
				String[] resourceCodeArr = resourceCode.split("\\|");
				String strOne = resourceCodeArr[1];
				String strTwo = resourceCodeArr[2] + ",";
				if (roleResourcesMap.containsKey(strOne)) {
					String str = roleResourcesMap.get(strOne);
					str += strTwo;
					roleResourcesMap.put(strOne, str);
				} else {
					roleResourcesMap.put(strOne, strTwo);
				}

				if (rolePermissionsMap.containsKey(strOne)) {
					String str = rolePermissionsMap.get(strOne);
					str += strTwo;
					rolePermissionsMap.put(strOne, str);
				} else {
					rolePermissionsMap.put(strOne, strTwo);
				}
			} else {
				roleResourcesMap.put(resourceCode, "");
			}
		}

		roleResourcesService.saveRoleResourcesList(roleKey, roleResourcesMap);

		rolePermissionService.saveRolePermissionList(roleKey,
				rolePermissionsMap);

		writeJSON(response, "{success:true}");
	}

}
