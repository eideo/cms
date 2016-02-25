package org.apache.jsp.WEB_002dINF.views.personal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class perSecurity_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/common/base.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var path = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("    //var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://101.200.0.81/cms/homepage\");\r\n");
      out.write("    //var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://192.168.8.129:8080/homepage\");\r\n");
      out.write("    var casPath = encodeURI(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${casPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("    var casBase = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${casBase}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("    function logout() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type: \"post\",\r\n");
      out.write("            async: true,\r\n");
      out.write("            url: casBase + '/ajaxlogout',\r\n");
      out.write("            dataType: \"jsonp\",\r\n");
      out.write("            jsonp: 'jsoncallback',\r\n");
      out.write("            success: function(a) {\r\n");
      out.write("                if (a.result) {\r\n");
      out.write("                    location.href = location.href;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"renderer\" content=\"ie-comp\">\r\n");
      out.write("\t<title>个人中心-安全设置</title>\r\n");
      out.write("\t<myCss>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/basic.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/style.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\"  href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/user.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t</myCss>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 页面位置 -->\r\n");
      out.write("\t<div class=\"message_top\">\r\n");
      out.write("\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t<li><a href=\"javascript:;\">CMS首页</a></li>\r\n");
      out.write("\t\t\t<li class=\"symbol\">></li>\r\n");
      out.write("\t\t\t<li><a href=\"javascript:;\">个人中心</a></li>\r\n");
      out.write("\t\t\t<li class=\"symbol\">></li>\r\n");
      out.write("\t\t\t<li><a href=\"javascript:;\" class=\"location\">安全设置</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<i></i>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 主要内容 -->\r\n");
      out.write("\t<div class=\"main clearfix\">\r\n");
      out.write("\t\t<div class=\"sign\">\r\n");
      out.write("\t\t    <div class=\"user_box\">\r\n");
      out.write("\t\t        <div class=\"face clearfix\">\r\n");
      out.write("\t\t            <div class=\"img\">\r\n");
      out.write("\t\t                <img id=\"avatarShow\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avatarPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" onerror=\"errorAvatar(this);\">\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t            <div class=\"user_info\">\r\n");
      out.write("\t\t                <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${custName }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("<i class='level2'></i></h3>\r\n");
      out.write("\t\t                <p>\r\n");
      out.write("\t\t                    <span>我的采钻：</span>\r\n");
      out.write("\t\t                    <span>10万</span>\r\n");
      out.write("\t\t                </p>\r\n");
      out.write("\t\t                <div class=\"vip_box clearfix\">\r\n");
      out.write("\t\t                    <div class=\"rechange\" id='vipUpgrade'>会员升级</div>\r\n");
      out.write("\t\t                </div>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"safety\">\r\n");
      out.write("\t\t            <span>安全设置</span>\r\n");
      out.write("\t\t            <span class=\"scale\"><i></i></span>\r\n");
      out.write("\t\t            <span class=\"grade\">低</span>\r\n");
      out.write("\t\t            <a href=\"javascript:;\">提升 ></a>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div class=\"personal_center\">\r\n");
      out.write("\t\t        <h4>\r\n");
      out.write("\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t<span>个人中心</span>\r\n");
      out.write("\t\t\t\t</h4 >\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/perOrder\">我的订单</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/information\" >个人信息</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/perSecurity\" class=\"active\">安全设置</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/attention\">我的关注</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/collection\" >我的收藏</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/footprint\">我的足迹</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"asset_center\">\r\n");
      out.write("\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t<span>个人资产</span>\r\n");
      out.write("\t\t\t\t</h4 >\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"ban\"><a>我的采钻</a></li>\r\n");
      out.write("\t\t\t\t\t<li class=\"ban\"><a>账户充值</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"personalBox\">\r\n");
      out.write("\t\t\t\t<div class=\"section\" style=\"display: block;\">\r\n");
      out.write("\t\t\t\t<h2>安全设置<i></i></h2>\r\n");
      out.write("\t\t\t\t<ul class=\"setting_list\">\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"re_box clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"option\">登录密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"op_value color_red\">保障账户安全，建议您定期修改密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"setting_status\">已认证</span>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:;\" class=\"update_btn\">修改</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入原始密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"mobile_code\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入验证码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>获取验证码</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"javascript:;\">邮箱验证码</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"new_password\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入新密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"re_password\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>重新输入新密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"re_box clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"option\">手机认证</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"op_value\">13******005</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"setting_status\">已认证</span>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:;\" class=\"update_btn\">修改</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box update_mobile1\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入原手机号</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"mobile_code\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入验证码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>获取验证码</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>下一步</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box update_mobile2\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入新手机号</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"mobile_code\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入验证码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>获取验证码</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"re_box clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"option\">邮箱认证</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"op_value\">dema***xi@163.com</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"setting_status\">已认证</span>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"javascript:;\" class=\"update_btn\">修改</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box update_mobile1\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>已验证邮箱</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"mobile_code\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入箱验证码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>获取验证码</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>下一步</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box update_email2\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入新邮箱</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"re_box clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"option\">支付密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"op_value pay_password\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"setting_status unverified\">未设置</span>\r\n");
      out.write("\t\t\t\t\t\t\t<a  href=\"javascript:;\"class=\"update_btn\">设置</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"update_box pay_box\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>输入新密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"password_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>重新输入新密码</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"password\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btn_box\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button>确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 错误提示框 -->\r\n");
      out.write("\t<div class=\"errorMessage\">\r\n");
      out.write("\t\t<h6>网页提示</h6>\r\n");
      out.write("\t\t<p class=\"msg\">未知错误，请求异常</p>\r\n");
      out.write("\t\t<a class=\"ensure\">确定</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!--上传头像层-->\r\n");
      out.write("\t<div class=\"updateImgBox\">\r\n");
      out.write("\t\t<h3>上传头像</h3>\r\n");
      out.write("\t\t<div class=\"updateBtn\">\r\n");
      out.write("\t\t\t<a>\r\n");
      out.write("\t\t\t\t<em>上传头像</em>\r\n");
      out.write("\t\t\t\t<input type=\"file\"  onchange=\"uploadFace(this)\"  id=\"personalAvatar\" name=\"personalAvatar\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<span id=\"uploadError\"></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"alertMsg\">\r\n");
      out.write("\t\t\t您可以上传JPG、GIF或PNG文件上传图片最大2M,推荐100x100\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"subBtn\">\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"保存\"  id=\"saveImg\"  userId=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"reset\" value=\"取消\"  class=\"cancel\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"previewImg\" id=\"preview\">\r\n");
      out.write("\t\t\t<img src=\"\" alt=\"\" id=\"imghead\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"shadow_all\" style='display:none;'></div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"vUpgrade\">\r\n");
      out.write("\t\t<div class=\"vUpgradeCon\">\r\n");
      out.write("\t\t\t<div class=\"top\">会员升级</div><i class='close'></i>\r\n");
      out.write("\t\t\t<div class=\"con clearfix\">\r\n");
      out.write("\t\t\t\t<i class='levelTag levelTag4'></i>\r\n");
      out.write("\t\t\t\t<div class=\"level level1\">\r\n");
      out.write("\t\t\t\t\t<h3>入门服务</h3>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>5000元/年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠20万采钻</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>9000元/2年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠40万采钻</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"level level2\">\r\n");
      out.write("\t\t\t\t\t<h3>标准服务</h3>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>9000元/年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠40万采钻</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>16000元/2年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠80万采钻</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"level level3\">\r\n");
      out.write("\t\t\t\t\t<h3>VIP服务</h3>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>18000元/年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠100万采钻</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>32000元/2年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠200万采钻</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"level level4\">\r\n");
      out.write("\t\t\t\t\t<h3>钻石服务</h3>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>58000元/年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠250万采钻</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>98000元/2年</li>\r\n");
      out.write("\t\t\t\t\t\t<li><i></i>赠500万采钻</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"contact\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li class=\"item\" id='four'><i></i>400-968-9685</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item\" id='telephone'><i></i>010-82743201</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"item\" id='qq'><i></i>2133606287</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("<myScript>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar imgPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\tvar resPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/area.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/user/userSecurity.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/user/commonUser.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/ajaxfileupload.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("</myScript>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("path");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent(null);
    _jspx_th_c_set_1.setVar("appPath");
    _jspx_th_c_set_1.setValue(new String("http://192.168.8.122:8080"));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_c_set_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_2.setPageContext(_jspx_page_context);
    _jspx_th_c_set_2.setParent(null);
    _jspx_th_c_set_2.setVar("resPath");
    _jspx_th_c_set_2.setValue(new String("http://192.168.8.122:8080"));
    int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
    if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_2);
    return false;
  }

  private boolean _jspx_meth_c_set_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_3 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_3.setPageContext(_jspx_page_context);
    _jspx_th_c_set_3.setParent(null);
    _jspx_th_c_set_3.setVar("casPath");
    _jspx_th_c_set_3.setValue(new String("http://www.cms.org/cas/login?service=http://192.168.8.122:8080/homepage"));
    int _jspx_eval_c_set_3 = _jspx_th_c_set_3.doStartTag();
    if (_jspx_th_c_set_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_3);
    return false;
  }

  private boolean _jspx_meth_c_set_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_4 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_4.setPageContext(_jspx_page_context);
    _jspx_th_c_set_4.setParent(null);
    _jspx_th_c_set_4.setVar("casBase");
    _jspx_th_c_set_4.setValue(new String("http://www.cms.org/cas"));
    int _jspx_eval_c_set_4 = _jspx_th_c_set_4.doStartTag();
    if (_jspx_th_c_set_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_4);
    return false;
  }

  private boolean _jspx_meth_c_set_5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_5 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_5.setPageContext(_jspx_page_context);
    _jspx_th_c_set_5.setParent(null);
    _jspx_th_c_set_5.setVar("imgPath");
    _jspx_th_c_set_5.setValue(new String("http://www.cms.org"));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }
}
