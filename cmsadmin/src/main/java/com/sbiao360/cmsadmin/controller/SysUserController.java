package com.sbiao360.cmsadmin.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Arrays;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.sbiao360.cmsadmin.core.Constant;
import com.sbiao360.cmsadmin.core.JavaEEFrameworkBaseController;
import com.sbiao360.cmsadmin.model.Attachment;
import com.sbiao360.cmsadmin.model.Resources;
import com.sbiao360.cmsadmin.model.Role;
import com.sbiao360.cmsadmin.model.SysUser;
import com.sbiao360.cmsadmin.service.AttachmentService;
import com.sbiao360.cmsadmin.service.ResourcesService;
import com.sbiao360.cmsadmin.service.RoleService;
import com.sbiao360.cmsadmin.service.SysUserService;
import com.sbiao360.core.support.ExtJSBaseParameter;
import com.sbiao360.core.support.JqGridPageView;
import com.sbiao360.core.util.DateUtil;
import com.sbiao360.core.util.PwdStuff;
import com.sbiao360.fd.ext.EntityStorer;
import com.sbiao360.fd.ext.FdfsStoreEntity;

/**
 * 用户的控制层
 * 
 * @author yujunwei
 */
@Controller
@RequestMapping("/sys/sysuser")
public class SysUserController extends JavaEEFrameworkBaseController<SysUser>
		implements Constant {

	private static final Log LOG = LogFactory.getLog(SysUserController.class);

	@Resource
	private SysUserService sysUserService;

	@Resource
	private AttachmentService attachmentService;

	@Resource
	private ResourcesService authorityService;

	@Resource
	private RoleService roleService;

	private EntityStorer audioStorer;

	@Resource(name = "audioStorer")
	public void setAudioStorer(EntityStorer audioStorer) {
		this.audioStorer = audioStorer;
	}

	private static Map<String, String> sortedMap = new HashMap<String, String>();

	static {
		sortedMap.put("id", "ID");
		sortedMap.put("custBirthday", "CUST_BIRTHDAY");
		sortedMap.put("lastLoginTime", "LAST_LOGINTIME");
	}

	// 登录
	@RequestMapping("/login")
	public void login(SysUser sysUserModel, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// PwdStuff pwdStuff = new PwdStuff();
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser sysUser = sysUserService
				.getByLoginId(sysUserModel.getLoginId());
		// 用户名有误或已被禁用
		/*
		 * if (sysUser == null || "1".equals(sysUser.getCustStatus())) {
		 * result.put("result", -1); writeJSON(response, result); return; }
		 * boolean passwdFlag = pwdStuff.correctPassword(
		 * sysUserModel.getLoginPasswd(), sysUser.getLoginPasswd()); if
		 * (!passwdFlag) { // 密码错误 result.put("result", -2); writeJSON(response,
		 * result); return; }
		 */
		String ticket = sysUserModel.getTicket();
		if (null == ticket || "".equals(ticket)) {
			result.put("result", -1);
			writeJSON(response, result);
			return;
		}
		sysUser.setLastLoginTime(new Date());
		sysUserService.setFilePath(sysUser);
		sysUserService.update(sysUser);
		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken(sysUserModel.getLoginId(),
				sysUserModel.getLoginPasswd(), sysUserModel.isRememberMe()));
		Session session = subject.getSession();
		session.setAttribute(SESSION_SYS_USER, sysUser);
		session.setAttribute("ROLE_KEY", sysUser.getRoleKey());
		result.put("result", 1);
		writeJSON(response, result);
	}

	// 跳转到主页，获取菜单并授权
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response) {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if (session.getAttribute(SESSION_SYS_USER) == null) {
			return new ModelAndView();
		} else {
			SysUser sysUser = (SysUser) session.getAttribute(SESSION_SYS_USER);
			String globalRoleKey = sysUser.getRoleKey();
			try {
				Map<String, String> sortedCondition = new HashMap<String, String>();
				sortedCondition.put("sequence", "asc");
				List<Resources> mainMenuList = authorityService
						.getListByMainMenu();
				List<Resources> allMenuList = authorityService.getListMainMenu(
						globalRoleKey, mainMenuList);
				return new ModelAndView("back/index", "authorityList",
						allMenuList);
			} catch (Exception e) {
				LOG.error(e.toString());
				return new ModelAndView();
			}
		}
	}

	// 注册
	@RequestMapping("/register")
	public void register(SysUser sysUserModel, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PwdStuff pwdStuff = new PwdStuff();
		Map<String, Object> result = new HashMap<String, Object>();
		boolean existLoginId = sysUserService.existLoginId(sysUserModel
				.getLoginId());
		boolean existCustEmail = sysUserService.existCustEmail(sysUserModel
				.getCustEmail());
		boolean existMobilePhone = sysUserService.existMobilePhone(sysUserModel
				.getMobilePhone());

		if (existLoginId) {
			result.put("result", -1);
			writeJSON(response, result);
			return;
		}
		if (existCustEmail) {
			result.put("result", -2);
			writeJSON(response, result);
			return;
		}
		if (existMobilePhone) {
			result.put("result", -3);
			writeJSON(response, result);
			return;
		}
		SysUser sysUser = new SysUser();
		sysUser.setLoginId(sysUserModel.getLoginId());
		sysUser.setCustName(sysUserModel.getCustName());
		sysUser.setSex(sysUserModel.getSex());
		sysUser.setIsAdmin((short) 0);
		sysUser.setBelong((short) 1);
		sysUser.setMobilePhone(sysUserModel.getMobilePhone());
		sysUser.setCustEmail(sysUserModel.getCustEmail());
		sysUser.setCustStatus("0");
		sysUser.setCustBirthday(sysUserModel.getCustBirthday());
		sysUser.setLastLoginTime(new Date());
		sysUser.setLoginPasswd(pwdStuff.convertPassword(sysUserModel
				.getLoginPasswd()));

		sysUser.setRoleKey("ROLE_USER");
		Role role = roleService.getByRoleKey("ROLE_USER");
		sysUser.setRole(role);

		sysUserService.save(sysUser);

		Subject subject = SecurityUtils.getSubject();
		subject.login(new UsernamePasswordToken(sysUserModel.getLoginId(),
				sysUserModel.getLoginPasswd()));
		Session session = subject.getSession();
		session.setAttribute(SESSION_SYS_USER, sysUser);
		session.setAttribute("ROLE_KEY", "ROLE_USER");

		result.put("result", 1);
		writeJSON(response, result);
	}

	// 获取个人资料信息
	@RequestMapping("/sysuserprofile")
	public ModelAndView sysuserprofile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		SysUser sysuser = sysUserService.getByPrimaryKey(((SysUser) request
				.getSession().getAttribute(SESSION_SYS_USER)).getId());
		sysUserService.setFilePath(sysuser);
		return new ModelAndView("back/sysuserprofile", "sysuser", sysuser);
	}

	// 登出
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		SecurityUtils.getSubject().logout();
		response.sendRedirect("/cmsadmin/login.jsp");
	}

	// 发送邮件找回密码
	@RequestMapping("/retrievePassword")
	public void retrievePassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		String retrieveEmail = request.getParameter("retrieveEmail");
		boolean existCustEmail = sysUserService.existCustEmail(retrieveEmail);
		SysUser sysUser = sysUserService.getByCustEmail(retrieveEmail);
		if (!existCustEmail || "1".equals(sysUser.getCustStatus())) { // 邮箱有误或已被禁用
			result.put("result", -1);
			writeJSON(response, result);
			return;
		}
		SimpleEmail emailUtil = new SimpleEmail();
		emailUtil.setCharset("utf-8");
		// emailUtil.setHostName("smtp.163.com");
		emailUtil.setHostName("mail.chinabidding.com.cn");
		try {
			emailUtil.addTo(retrieveEmail, sysUser.getCustName());
			emailUtil.setAuthenticator(new DefaultAuthenticator(
					"yujw@chinabidding.com.cn", "12345"));// 参数是您的真实邮箱和密码
			emailUtil.setFrom("yujw@chinabidding.com.cn", "信息产品中心");
			emailUtil.setSubject("用户登录密码找回");
			emailUtil.setMsg("本邮件发送仅提供例子，需要二次开发。" + sysUser.getCustName()
					+ "，您的登录密码是：" + sysUser.getLoginPasswd());
			emailUtil.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("result", 1);
		writeJSON(response, result);
	}

	// 更改密码
	@RequestMapping("/resetPassword")
	public void resetPassword(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PwdStuff pwdStuff = new PwdStuff();
		String password = request.getParameter("password");
		Long id = ((SysUser) request.getSession()
				.getAttribute(SESSION_SYS_USER)).getId();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("loginPasswd", pwdStuff.convertPassword(password));
		sysUserService.updateByProperties(paramMap);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		writeJSON(response, result);
	}

	// 查询用户的表格，包括分页、搜索和排序
	@RequestMapping(value = "/getSysUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void getSysUser(HttpServletRequest request,
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
		SysUser sysUser = new SysUser();
		sysUser.setSortedObject(sortedMap.get(sortedObject));
		sysUser.setSortedValue(sortedValue);
		// 默认查询后台用户
		if (StringUtils.isNotBlank(filters)) {
			JSONObject jsonObject = JSONObject.fromObject(filters);
			JSONArray jsonArray = (JSONArray) jsonObject.get("rules");
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject result = (JSONObject) jsonArray.get(i);
				if (result.getString("field").equals("loginId")
						&& result.getString("op").equals("cn")) {
					sysUser.setLikeLoginId(result.getString("data").trim());
				}
				if (result.getString("field").equals("custName")
						&& result.getString("op").equals("cn")) {
					sysUser.setLikeCustName(result.getString("data").trim());
				}
				if (result.getString("field").equals("belong")
						&& result.getString("op").equals("eq")) {
					sysUser.setEqBelong(result.getString("data"));
				}
			}
			if (((String) jsonObject.get("groupOp")).equalsIgnoreCase("OR")) {
				sysUser.setFlag("OR");
			} else {
				sysUser.setFlag("AND");
			}
		}
		sysUser.setPage(page);
		sysUser.setRows(rows);
		Long totalCount = sysUserService.getCount(sysUser);
		List<SysUser> queryResult = sysUserService.getList(sysUser);
		JqGridPageView<SysUser> sysUserListView = new JqGridPageView<SysUser>();
		sysUserListView.setMaxResults(rows);
		sysUserListView.setRows(queryResult);
		sysUserListView.setRecords(totalCount);
		writeJSON(response, sysUserListView);
	}

	// 保存用户的实体
	@RequestMapping(value = "/saveSysUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void doSave(SysUser entity, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ExtJSBaseParameter parameter = ((ExtJSBaseParameter) entity);
		if (CMD_EDIT.equals(parameter.getCmd())) {
			SysUser sysUser = sysUserService.getByPrimaryKey(entity.getId());
			entity.setLoginPasswd(sysUser.getLoginPasswd());
			entity.setLastLoginTime(sysUser.getLastLoginTime());
			sysUserService.update(entity);
		} else if (CMD_NEW.equals(parameter.getCmd())) {
			PwdStuff pwdStuff = new PwdStuff();
			entity.setLoginPasswd(pwdStuff.convertPassword("123456")); // 初始化密码为123456
			sysUserService.save(entity);
		}
		parameter.setSuccess(true);
		writeJSON(response, parameter);
	}

	// 操作用户的删除、导出Excel、字段判断和保存
	@RequestMapping(value = "/operateSysUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void operateSysUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String oper = request.getParameter("oper");
		String id = request.getParameter("id");
		if (oper.equals("del")) {
			String[] ids = id.split(",");
			deleteSysUser(request, response,
					(Long[]) ConvertUtils.convert(ids, Long.class));
		} else if (oper.equals("excel")) {
			response.setContentType("application/msexcel;charset=UTF-8");
			try {
				response.addHeader("Content-Disposition",
						"attachment;filename=sysuser.xls");
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
			String loginId = request.getParameter("loginId");
			String custName = request.getParameter("custName");
			String mobilePhone = request.getParameter("mobilePhone");
			String custEmail = request.getParameter("custEmail");
			SysUser sysUser = null;
			if (oper.equals("edit")) {
				sysUser = sysUserService.getByPrimaryKey(Long.valueOf(id));
			}
			boolean existLoginId = sysUserService.existLoginId(loginId);
			boolean existCustEmail = sysUserService.existCustEmail(custEmail);
			boolean existMobilePhone = sysUserService
					.existMobilePhone(mobilePhone);
			if (StringUtils.isBlank(loginId) || StringUtils.isBlank(custName)
					|| StringUtils.isBlank(mobilePhone)
					|| StringUtils.isBlank(custEmail)) {
				response.setStatus(HttpServletResponse.SC_LENGTH_REQUIRED);
				result.put("message", "请填写用户名、姓名、手机和邮箱");
				writeJSON(response, result);
			} else if (existLoginId && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此用户名已存在，请重新输入");
				writeJSON(response, result);
			} else if (existLoginId
					&& !sysUser.getLoginId().equalsIgnoreCase(loginId)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此用户名已存在，请重新输入");
				writeJSON(response, result);
			} else if (existMobilePhone && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此手机已存在，请重新输入");
				writeJSON(response, result);
			} else if (existMobilePhone
					&& !sysUser.getMobilePhone().equalsIgnoreCase(mobilePhone)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此手机已存在，请重新输入");
				writeJSON(response, result);
			} else if (existCustEmail && oper.equals("add")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此邮箱已存在，请重新输入");
				writeJSON(response, result);
			} else if (existCustEmail
					&& !sysUser.getCustEmail().equalsIgnoreCase(custEmail)
					&& oper.equals("edit")) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result.put("message", "此邮箱已存在，请重新输入");
				writeJSON(response, result);
			} else {
				SysUser entity = new SysUser();
				entity.setLoginId(loginId);
				entity.setCustName(custName);
				entity.setSex(request.getParameter("sexCn"));
				entity.setBelong(Short.parseShort(request
						.getParameter("belongCn")));
				entity.setMobilePhone(request.getParameter("mobilePhone"));
				entity.setCustEmail(custEmail);
				entity.setCustStatusCn(request.getParameter("custStatusCn"));
				if (entity.getCustStatusCn().equals("是")) {
					entity.setCustStatus("1");
				} else if (entity.getCustStatusCn().equals("否")) {
					entity.setCustStatus("0");
				}
				entity.setDeptId(Long.parseLong(request
						.getParameter("deptName")));
				if (StringUtils.isNotBlank(request
						.getParameter("custBirthdayCn"))) {
					entity.setCustBirthday(DateUtil.formatStrToDate(
							"yyyy-MM-dd",
							request.getParameter("custBirthdayCn")));
				}

				String roleKey = request.getParameter("roleName");
				entity.setRoleKey(roleKey);

				if ("ROLE_RESTRICTED_ADMIN".equalsIgnoreCase(roleKey)) {
					entity.setIsAdmin((short) 1);
				} else {
					entity.setIsAdmin((short) 0);
				}

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

	// 保存个人资料
	@RequestMapping(value = "/saveSysUserProfile", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void saveSysUserProfile(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long sysUserId = ((SysUser) request.getSession().getAttribute(
				SESSION_SYS_USER)).getId();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", sysUserId);
		paramMap.put("custName", request.getParameter("custName"));
		paramMap.put("sex", request.getParameter("sex"));
		paramMap.put("custEmail", request.getParameter("custEmail"));
		paramMap.put("mobilePhone", request.getParameter("mobilePhone"));
		if (null != request.getParameter("custBirthday")) {
			paramMap.put("custBirthday", request.getParameter("custBirthday"));
		}

		sysUserService.updateByProperties(paramMap);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		writeJSON(response, result);
	}

	// 删除用户
	@RequestMapping("/deleteSysUser")
	public void deleteSysUser(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("ids") Long[] ids)
			throws IOException {
		if (Arrays.asList(ids).contains(Long.valueOf("206"))) {
			writeJSON(response,
					"{success:false,message:'删除项包含超级管理员，超级管理员不能删除！'}");
		} else {
			int flag = sysUserService.delete(ids);
			if (flag > 0) {
				writeJSON(response, "{success:true}");
			} else {
				writeJSON(response, "{success:false}");
			}
		}
	}

	// 即时更新个人资料的字段
	@RequestMapping(value = "/updateSysUserField", method = {
			RequestMethod.POST, RequestMethod.GET })
	public void updateSysUserField(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long id = Long.valueOf(request.getParameter("pk"));
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		if (value != null && !"".equals(value)) {
			if (name.equals("custName")) {
				paramMap.put("custName", value.trim());
				sysUserService.updateByProperties(paramMap);
			} else if (name.equals("sex")) {
				paramMap.put("sex", value);
				sysUserService.updateByProperties(paramMap);
			} else if (name.equals("custEmail")) {
				paramMap.put("custEmail", value.trim());
				sysUserService.updateByProperties(paramMap);
			} else if (name.equals("mobilePhone")) {
				paramMap.put("mobilePhone", value.trim());
				sysUserService.updateByProperties(paramMap);
			} else if (name.equals("custBirthday")) {
				paramMap.put("custBirthday",
						DateUtil.formatStrToDate("yyyy-MM-dd", value));
				sysUserService.updateByProperties(paramMap);
			}
		}
	}

	// 上传个人资料的头像
	@RequestMapping(value = "/uploadAttachement", method = RequestMethod.POST)
	public void uploadAttachement(
			@RequestParam(value = "avatar", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RequestContext requestContext = new RequestContext(request);
		JSONObject json = new JSONObject();
		if ((file != null) && (file.getSize() > 0)) {
			if (file.getSize() > 2097152) {
				json.put("message", requestContext.getMessage("g_fileTooLarge"));
			} else {
				try {
					String originalFilename = file.getOriginalFilename();
					/*String fileName = DateUtil.formatDateToStr(
							"yyyyMMddHHmmssSSS", new Date())
							+ JavaEEFrameworkUtils.getRandomString(3)
							+ originalFilename.substring(originalFilename
									.lastIndexOf("."));*/

					/*
					 * String filePathName = getClass() .getClassLoader()
					 * .getResource("/") .getPath() .replace(
					 * "/WEB-INF/classes/", "/static/upload/img/" +
					 * DateFormatUtils.format( new Date(), "yyyyMM"));
					 */

					/*String filePathName = request.getServletContext()
							.getRealPath(
									"/static/upload/img/"
											+ DateFormatUtils.format(
													new Date(), "yyyyMM"));
					filePathName = URLDecoder.decode(filePathName, "UTF-8");
					File filePath = new File(filePathName);
					if (!filePath.exists()) {
						filePath.mkdirs();
					}
					file.transferTo(new File(filePath.getAbsolutePath() + "/"
							+ fileName));
					
					String destinationFilePath = "/static/upload/img/"
							+ DateFormatUtils.format(new Date(), "yyyyMM")
							+ "/" + fileName;*/
					
					String destinationFilePath = audioStorer
							.store(new FdfsStoreEntity(file));

					Long sysUserId = ((SysUser) request.getSession()
							.getAttribute(SESSION_SYS_USER)).getId();

					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.put("type", (short) 1);
					paramMap.put("typeId", sysUserId);
					attachmentService.deleteByProperties(paramMap);

					Attachment attachment = new Attachment();
					attachment.setFileName(originalFilename);
					attachment.setFilePath(destinationFilePath);
					attachment.setType((short) 1);
					attachment.setTypeId(sysUserId);
					attachmentService.save(attachment);
					json.put("status", "OK");
					json.put("url", destinationFilePath);
					json.put("message",
							requestContext.getMessage("g_uploadSuccess"));
				} catch (Exception e) {
					e.printStackTrace();
					json.put("message",
							requestContext.getMessage("g_uploadFailure"));
				}
			}
		} else {
			json.put("message", requestContext.getMessage("g_uploadNotExists"));
		}
		writeJSON(response, json.toString());
	}

	/** 以下方法是根据路径跳转到页面 **/

	@RequestMapping("/sysuser")
	public String sysuser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/systemmanage/sysuser";
	}

	@RequestMapping("/homepage")
	public String homepage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/homepage";
	}

	@RequestMapping("/dict")
	public String dict(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "back/systemmanage/dict";
	}

	@RequestMapping("/role")
	public String role(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "back/systemmanage/role";
	}

	@RequestMapping("/department")
	public String department(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/systemmanage/department";
	}

	@RequestMapping("/mail")
	public String mail(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "back/systemmanage/mail";
	}

	@RequestMapping("/information")
	public String information(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/infomanage/information";
	}

	@RequestMapping("/authority")
	public String authority(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/systemmanage/authority";
	}

	@RequestMapping("/typography")
	public String typography(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/typography";
	}

	@RequestMapping("/uielements")
	public String uielements(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/uielements";
	}

	@RequestMapping("/buttonsicon")
	public String buttonsicon(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/buttonsicon";
	}

	@RequestMapping("/contentslider")
	public String contentslider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/contentslider";
	}

	@RequestMapping("/nestablelist")
	public String nestablelist(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/nestablelist";
	}

	@RequestMapping("/jquerydatatables")
	public String jquerydatatables(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/jquerydatatables";
	}

	@RequestMapping("/formelements")
	public String formelements(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/formelements";
	}

	@RequestMapping("/formelements2")
	public String formelements2(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/formelements2";
	}

	@RequestMapping("/wizardvalidation")
	public String wizardvalidation(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/wizardvalidation";
	}

	@RequestMapping("/uiwidgets")
	public String uiwidgets(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/uiwidgets";
	}

	@RequestMapping("/calendar")
	public String calendar(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/calendar";
	}

	@RequestMapping("/gallery")
	public String gallery(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/gallery";
	}

	@RequestMapping("/pricingtables")
	public String pricingtables(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/pricingtables";
	}

	@RequestMapping("/invoice")
	public String invoice(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/invoice";
	}

	@RequestMapping("/timeline")
	public String timeline(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/bootstrapexample/timeline";
	}

	@RequestMapping("/faq")
	public String faq(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "back/bootstrapexample/faq";
	}

	@RequestMapping("/grid")
	public String grid(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "back/bootstrapexample/grid";
	}

	@RequestMapping("/charts")
	public String charts(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/chartandreport/charts";
	}

	@RequestMapping("/callError404")
	public String callError404(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "redirect:/sys/sysuser/error404";
	}

	@RequestMapping("/error404")
	public String error404(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/error404";
	}

	@RequestMapping("/callError500")
	public String callError500(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "redirect:/sys/sysuser/error500";
	}

	@RequestMapping("/error500")
	public String error500(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/error500";
	}

	@RequestMapping("/callUnauthorized")
	public String callUnauthorized(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "redirect:/sys/sysuser/unauthorized";
	}

	@RequestMapping("/unauthorized")
	public String unauthorized(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/unauthorized";
	}

	@RequestMapping("/custaccess")
	public String custAccess(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custaccess";
	}

	@RequestMapping("/custaction")
	public String custAction(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custaction";
	}

	@RequestMapping("/custclick")
	public String custClick(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custclick";
	}

	@RequestMapping("/custkeywords")
	public String custKeywords(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custkeywords";
	}

	@RequestMapping("/custshare")
	public String custShare(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custshare";
	}

	@RequestMapping("/custtopclick")
	public String custTopClick(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custtopclick";
	}

	@RequestMapping("/custbehavior")
	public String custBehaviorRedis(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custbehavior";
	}

	@RequestMapping("/behaviorsequence")
	public String behaviorSequence(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/behaviorsequence";
	}

	@RequestMapping("/custbrowseurl")
	public String custBrowseUrl(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/custbehavior/custbrowseurl";
	}

	@RequestMapping("/methodexcutime")
	public String methodExcuTime(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/syslog/methodexcutime";
	}

	@RequestMapping("/sysstatusmonitor")
	public String sysStatusMonitor(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/syslog/sysstatusmonitor";
	}

	@RequestMapping("/reportmain")
	public String reportMain(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return "back/report/reportmain";
	}

}
