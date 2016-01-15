package com.sbiao360.cms.web;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.domain.MemberInfo;
import com.sbiao360.cms.domain.PersonalCustBehavior;
import com.sbiao360.cms.service.PersonalService;
import com.sbiao360.fd.ext.EntityStorer;
import com.sbiao360.fd.ext.FdfsStoreEntity;

/**
 * 个人中心的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping(value = "/personal")
public class PersonalController extends BaseController {

	@Resource
	private PersonalService personalService;

	private EntityStorer audioStorer;

	@Resource(name = "audioStorer")
	public void setAudioStorer(EntityStorer audioStorer) {
		this.audioStorer = audioStorer;
	}

	@RequestMapping(value = "/attention", method = RequestMethod.GET)
	public String attentionPage(HttpServletRequest request,
			HttpServletResponse response) {
		doCustBehaviorPage(request, 3);

		return "perAttention";
	}

	@RequestMapping(value = "/collection", method = RequestMethod.GET)
	public String collectionPage(HttpServletRequest request,
			HttpServletResponse response) {
		doCustBehaviorPage(request, 4);

		return "perCollection";
	}

	@RequestMapping(value = "/footprint", method = RequestMethod.GET)
	public String footprintPage(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, List<PersonalCustBehavior>> footprintMap = new LinkedHashMap<String, List<PersonalCustBehavior>>();
		int actionType = 2;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("actionType", actionType);
		paraMap.put("infoType", "");
		Long userId = 0L;
		String custName = "";
		MemberInfo memberInfo = new MemberInfo();
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			memberInfo = personalService.getMemberInfoById(userId);
			request.setAttribute("username", assertion.getPrincipal().getName());
			request.setAttribute("avatarPath", memberInfo.getAvatarPath());
		}
		paraMap.put("userId", userId);

		footprintMap = personalService.getFootprintMap(paraMap);

		request.setAttribute("custName", custName);
		request.setAttribute("footprintMap", footprintMap);
		request.setAttribute("infoType", "");
		request.setAttribute("activeFlag", 0);
		request.setAttribute("notSearch", "true");

		return "perFootprint";
	}

	@RequestMapping(value = "/information", method = RequestMethod.GET)
	public String informationPage(HttpServletRequest request,
			HttpServletResponse response) {
		Long userId = 0L;
		MemberInfo memberInfo = new MemberInfo();
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			memberInfo = personalService.getMemberInfoById(userId);
			if ("".equals(memberInfo.getCustProvince())) {
				memberInfo.setCustProvince("请选择省份");
			}
			if ("".equals(memberInfo.getCustCity())) {
				memberInfo.setCustCity("请选择地市");
			}
			if ("".equals(memberInfo.getSex())) {
				memberInfo.setSex("S");
			}
			request.setAttribute("username", assertion.getPrincipal().getName());
		}

		request.setAttribute("userId", userId);
		request.setAttribute("custName", memberInfo.getCustName());
		request.setAttribute("memberinfo", memberInfo);
		request.setAttribute("notSearch", "true");

		return "perInformation";
	}

	@RequestMapping(value = "/footprint/{infotype}", method = RequestMethod.GET)
	public String footprintPageByInfoType(HttpServletRequest request,
			@PathVariable String infotype, HttpServletResponse response) {
		Map<String, List<PersonalCustBehavior>> footprintMap = new LinkedHashMap<String, List<PersonalCustBehavior>>();
		int actionType = 2;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("actionType", actionType);
		paraMap.put("infoType", infotype);
		Long userId = 0L;
		String custName = "";
		MemberInfo memberInfo = new MemberInfo();
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			memberInfo = personalService.getMemberInfoById(userId);
			request.setAttribute("username", assertion.getPrincipal().getName());
			request.setAttribute("avatarPath", memberInfo.getAvatarPath());
		}
		paraMap.put("userId", userId);

		footprintMap = personalService.getFootprintMap(paraMap);

		request.setAttribute("custName", custName);
		request.setAttribute("footprintMap", footprintMap);
		request.setAttribute("infoType", infotype);
		request.setAttribute("notSearch", "true");

		if ("11501".equals(infotype)) {
			request.setAttribute("activeFlag", 1);
		} else if ("11502".equals(infotype)) {
			request.setAttribute("activeFlag", 2);
		} else if ("11503".equals(infotype)) {
			request.setAttribute("activeFlag", 3);
		}

		return "perFootprint";
	}

	public void doCustBehaviorPage(HttpServletRequest request, int actionType) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("actionType", actionType);

		Long userId = 0L;
		String custName = "";
		MemberInfo memberInfo = new MemberInfo();
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
			custName = (String) assertion.getPrincipal().getAttributes()
					.get("name");
			memberInfo = personalService.getMemberInfoById(userId);
			request.setAttribute("username", assertion.getPrincipal().getName());
			request.setAttribute("avatarPath", memberInfo.getAvatarPath());
		}

		paraMap.put("userId", userId);
		paraMap.put("infoType", "");

		// 当前页数 	
		int currentPage = 1;
		// 每页显示数目
		int pageSize = 5;

		int totalCount = personalService.getCountBehavior(paraMap);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		List<PersonalCustBehavior> custBehaviorList = personalService
				.getListBehavior(currentPage, pageSize, paraMap);

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("custName", custName);
		request.setAttribute("custBehaviorList", custBehaviorList);
		request.setAttribute("notSearch", "true");
	}

	@RequestMapping(value = "/ajaxCustBehaviorList", method = RequestMethod.POST)
	public void ajaxCustBehaviorList(
			@RequestParam(value = "currentPage", required = false) int currentPage,
			@RequestParam(value = "infoType", required = false) String infoType,
			@RequestParam(value = "actionType", required = false) int actionType,
			HttpServletRequest request, HttpServletResponse response) {
		// 每页显示数目
		int pageSize = 5;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("actionType", actionType);

		Long userId = 0L;
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
		}

		paraMap.put("userId", userId);
		paraMap.put("infoType", infoType);

		int totalCount = personalService.getCountBehavior(paraMap);
		int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
		List<PersonalCustBehavior> custBehaviorList = personalService
				.getListBehavior(currentPage, pageSize, paraMap);

		JSONObject result = new JSONObject();
		result.put("currentPage", currentPage);
		result.put("totalCount", totalCount);
		result.put("totalPage", totalPage);
		result.put("custBehaviorList", custBehaviorList);
		result.put("success", true);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("id", id);
		paraMap.put("infoValid", (short) 0);
		paraMap.put("actionDate", new Date());

		int num = personalService.updateBehavior(paraMap);

		if (num > 0) {
			flag = true;
		}

		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public void deleteAll(
			@RequestParam(value = "ids", required = false) String ids,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("infoValid", (short) 0);
		paraMap.put("actionDate", new Date());

		String[] idsArr = ids.split(",");

		int num = personalService.update(idsArr, paraMap);

		if (num > 0) {
			flag = true;
		}

		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/deleteInvalid", method = RequestMethod.POST)
	public void deleteInvalid(
			@RequestParam(value = "ids", required = false) String ids,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("infoValid", (short) 2);
		paraMap.put("actionDate", new Date());

		String[] idsArr = ids.split(",");

		int num = personalService.update(idsArr, paraMap);

		if (num > 0) {
			flag = true;
		}

		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/deleteByDate", method = RequestMethod.POST)
	public void deleteByDate(
			@RequestParam(value = "actionType", required = false) short actionType,
			@RequestParam(value = "infoType", required = false) String infoType,
			@RequestParam(value = "infoValidWhere", required = false) short infoValidWhere,
			@RequestParam(value = "actionDateWhere", required = false) String actionDateWhere,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;
		Map<String, Object> paraMap = new HashMap<String, Object>();

		Long userId = 0L;
		Assertion assertion = AssertionHolder.getAssertion();
		if (assertion != null) {
			userId = Long.parseLong((String) assertion.getPrincipal()
					.getAttributes().get("id"));
		}

		paraMap.put("userId", userId);
		paraMap.put("actionType", actionType);
		paraMap.put("infoType", infoType);
		paraMap.put("infoValidWhere", infoValidWhere);
		paraMap.put("actionDateWhere", actionDateWhere);
		paraMap.put("infoValid", (short) 0);
		paraMap.put("actionDate", new Date());

		int num = personalService.updateBehaviorByDate(paraMap);

		if (num > 0) {
			flag = true;
		}

		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	@RequestMapping(value = "/informationSubmit", method = RequestMethod.POST)
	public void informationSubmit(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "mobilePhone", required = false) String mobilePhone,
			@RequestParam(value = "custEmail", required = false) String custEmail,
			@RequestParam(value = "custName", required = false) String custName,
			@RequestParam(value = "custProvince", required = false) String custProvince,
			@RequestParam(value = "custCity", required = false) String custCity,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "companyName", required = false) String companyName,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;

		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setId(id);
		memberInfo.setSex("S".equals(sex) ? "" : sex);
		memberInfo.setMobilePhone(mobilePhone);
		memberInfo.setCustEmail(custEmail.trim());
		memberInfo.setCustName(custName.trim());
		memberInfo.setCustProvince(custProvince);
		memberInfo.setCustCity(custCity);
		memberInfo.setAddress(address == null ? "" : address.trim());
		memberInfo.setCompanyName(companyName.trim());

		int num = personalService.updateMemberInfo(memberInfo);

		if (num > 0) {
			flag = true;
		}

		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

	// 个人中心上传头像
	@RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
	public void uploadAvatar(
			@RequestParam(value = "personalAvatar", required = false) MultipartFile file,
			@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean flag = false;
		String message = "";
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("id", id);

		// System.out.println("file.getSize() = " + file.getSize());
		if ((file != null) && (file.getSize() > 0)) {
			try {
				// String originalFilename = file.getOriginalFilename();
				// System.out.println("originalFilename = " + originalFilename);
				String avatarPath = audioStorer
						.store(new FdfsStoreEntity(file));
				paraMap.put("avatarPath", avatarPath);

				int num = personalService.updateAvatar(paraMap);

				if (num > 0) {
					flag = true;
					message = avatarPath;
				}
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
				message = "上传头像失败";
			}
		} else {
			flag = false;
			message = "请选择需要上传的头像";
		}

		result.put("message", message);
		result.put("success", flag);

		ajaxJson(result.toJSONString(), response);
	}

}
