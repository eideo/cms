package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/common/base.jsp");
    _jspx_dependants.add("/WEB-INF/views/dialogLogin/loginDialog.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatDate_value_pattern_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\r\n");
      out.write("    ");
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
      out.write("\tvar path = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t//var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://101.200.0.81/cms/homepage\");\r\n");
      out.write("\t//var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://192.168.8.129:8080/homepage\");\r\n");
      out.write("\tvar casPath =encodeURI(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${casPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\");\r\n");
      out.write("\tvar casBase = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${casBase}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\tfunction logout(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\tasync:true,\r\n");
      out.write("\t\t\turl:casBase+'/ajaxlogout',\tdataType:\"jsonp\",\r\n");
      out.write("\t\t\tjsonp:'jsoncallback',\r\n");
      out.write("\t\t\tsuccess:function(a){\r\n");
      out.write("\t\t\t\tif(a.result){\r\n");
      out.write("\t\t\t\t\tlocation.href = location.href;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("     \r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>搜索详情</title>\r\n");
      out.write("\t<myCss>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/detail.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t</myCss>\r\n");
      out.write("\t<myScript>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/custBehavior.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("\t</myScript>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 中间内容 -->\r\n");
      out.write("<div class=\"article\">\r\n");
      out.write("\t<h2 class=\"title\" id=\"info_");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" infotype=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("\t<div class=\"info clearfix\">\r\n");
      out.write("\t\t<span class=\"time\">发布时间：<i>");
      if (_jspx_meth_fmt_formatDate_0(_jspx_page_context))
        return;
      out.write("</i></span>\r\n");
      out.write("\t\t<div class=\"navBox clearfix\">\r\n");
      out.write("\t\t\t<div class=\"ap\" actiontype=\"3\" infotype=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" infoid=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >\r\n");
      out.write("\t\t\t\t<i class=\"attention\"></i>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\">关注</a>\r\n");
      out.write("\t\t\t\t<span class=\"re\">已关注</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"cp\" actiontype=\"4\" infotype=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" infoid=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >\r\n");
      out.write("\t\t\t\t<i class=\"collection\"></i>\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\">收藏</a>\r\n");
      out.write("\t\t\t\t<span class=\"re\">已收藏</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"sp\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\" class=\"share\">分享</a>\r\n");
      out.write("\t\t\t\t<div class=\"shareBtn bdsharebuttonbox\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" onclick=\"javascript:custBehaviorShare(5, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("', 'QQ空间');\" class=\"bds_qzone\" data-cmd=\"qzone\"  title=\"分享到QQ空间\"></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" onclick=\"javascript:custBehaviorShare(5, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("', '新浪微博');\" class=\"bds_tsina\" data-cmd=\"tsina\"  title=\"分享到新浪微博\"></a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" onclick=\"javascript:custBehaviorShare(5, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.infoType}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(", '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("', '微信');\" class=\"bds_weixin\" data-cmd=\"weixin\"  title=\"分享到微信\"></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<em></em>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"paragraph clearfix\">\r\n");
      out.write("\t\t<div class=\"detail\">\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<a class=\"img\" href=\"");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\" target=\"_blank\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/images/de_img.png\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 相关推荐 -->\r\n");
      out.write("<div class=\"tuijian\">\r\n");
      out.write("\t<ul class=\"btn clearfix\">\r\n");
      out.write("\t\t<li style=\"color:#0a8dff;\" class=\"bxiangmu\">相关项目信息<i style=\"display:block;\"></i></li>\r\n");
      out.write("\t\t<li class=\"bzhaobiao\">相关招标信息<i></i></li>\r\n");
      out.write("\t\t<li class=\"bzhongbiao\">相关中标信息<i></i></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<ol class=\"de-list xiangmu\">\r\n");
      out.write("\t</ol>\r\n");
      out.write("\t<ol class=\"de-list zhaobiao\">\r\n");
      out.write("\t</ol>\r\n");
      out.write("\t<ol class=\"de-list zhongbiao\">\r\n");
      out.write("\t</ol>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("window._bd_share_config={\"common\":{\"bdSnsKey\":{},\"bdText\":\"欢迎进入中国采购与招标网新平台，感兴趣可以点击下面链接体验……\",\"bdMini\":\"2\",\"bdPic\":\"\",\"bdStyle\":\"0\",\"bdSize\":\"16\"},\"share\":{}};\r\n");
      out.write("with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\t <script type=\"text/html\" id=\"headerTemp\">\r\n");
      out.write("\t\t \t<li><a href=\"javascript:;\">欢迎您，{username}</a></li>\r\n");
      out.write("\t\t\t<li>|</li>\r\n");
      out.write("\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/personal/information\">个人中心</a></li>\r\n");
      out.write("\t\t\t<li>|</li>\r\n");
      out.write("\t\t\t<li><a href=\"javaScript:logout();\">退出</a></li>\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar username = \"\";\r\n");
      out.write("\t\t \tfunction ajaxLogin(){\r\n");
      out.write("\t \t\t\t$.ajax({\r\n");
      out.write("\t \t\t\t\ttype:\"post\",\r\n");
      out.write("\t \t\t\t\tasync:true,\r\n");
      out.write("\t \t\t\t\turl:casBase+'/ajaxlogin',\r\n");
      out.write("\t \t\t\t\tdata:{user:$(\"#username\").val(),passwd:$(\"#password\").val(),service:path+'/toLoginIframe'},\r\n");
      out.write("\t \t\t\t\tdataType:\"jsonp\",\r\n");
      out.write("\t \t\t\t\tjsonp:'jsoncallback',\r\n");
      out.write("\t \t\t\t\tsuccess:function(a){\r\n");
      out.write("\t \t\t\t\t\tif(a.result){\r\n");
      out.write("\t \t\t\t\t\t\tajaxSetUser(path+\"/toLoginIframe?ticket=\"+a.st);\r\n");
      out.write("\t \t\t\t\t\t\t$('.close').click();\r\n");
      out.write("\t \t\t\t\t\t}else{\r\n");
      out.write("\t \t\t\t\t\t\t//提示错误信息\r\n");
      out.write("\t \t\t\t\t\t\talert(a.message);\r\n");
      out.write("\t \t\t\t\t\t}\r\n");
      out.write("\t \t\t\t\t}\r\n");
      out.write("\t \t\t\t});\r\n");
      out.write("\t \t\t\treturn false;\r\n");
      out.write("\t\t \t }\r\n");
      out.write("\t\t\t function ajaxSetUser(str){\r\n");
      out.write("\t\t\t\tvar iframe = document.createElement(\"iframe\"); \r\n");
      out.write("\t\t\t\tiframe.src = str; \r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (iframe.attachEvent){ \r\n");
      out.write("\t\t\t\t\tiframe.attachEvent(\"onload\", function(){ \r\n");
      out.write("\t\t\t\t\t\tvar html = $(\"#headerTemp\").html().replace(\"{username}\",username);\r\n");
      out.write("\t\t\t\t\t\t$(\".user-info\").html(html);\r\n");
      out.write("\t\t\t\t\t\tdocument.body.removeChild(iframe);\r\n");
      out.write("\t\t\t\t\t}); \r\n");
      out.write("\t\t\t\t} else { \r\n");
      out.write("\t\t\t\t\tiframe.onload = function(){ \r\n");
      out.write("\t\t\t\t\t\tvar html = $(\"#headerTemp\").html().replace(\"{username}\",username);\r\n");
      out.write("\t\t\t\t\t\t$(\".user-info\").html(html);\r\n");
      out.write("\t\t\t\t\t\tdocument.body.removeChild(iframe);\r\n");
      out.write("\t\t\t\t\t};\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tdocument.body.appendChild(iframe);\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t</script>\r\n");
      out.write("<!-- \t2015-12-01 by liyang -->\r\n");
      out.write("<!-- 下面是登录框 -->\r\n");
      out.write("\t<form onsubmit=\"return ajaxLogin();\">\r\n");
      out.write("\t\t<div class=\"login_box\">\r\n");
      out.write("\t\t    <i class=\"close\"></i>\r\n");
      out.write("\t\t    <div class=\"loginTitle\">登录</div>\r\n");
      out.write("\t\t\t<div class=\"userbox\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"username\" placeholder=\"邮箱/手机号\">\r\n");
      out.write("\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"passwordbox\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" id=\"password\" placeholder=\"密码\">\r\n");
      out.write("\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"op_password\">\r\n");
      out.write("\t\t\t\t<input id=\"remember\" type=\"checkbox\"></input>\r\n");
      out.write("\t\t\t\t<label for=\"remember\">记住密码</label>\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/findPwd\" class=\"update\">忘记密码</a>\r\n");
      out.write("\t\t\t\t<span>|</span>\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/register\" class=\"register\">免费注册</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"立即登录\" class=\"button\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div class=\"shadow_all\"></div>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/sea.js?v=1.0.1\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tseajs.config({\r\n");
      out.write("\t\tbase: path+'/resources/commons/js/lib/',\r\n");
      out.write("\t\talias: {\r\n");
      out.write("\t\t\t'jquery':'jquery/jquery-1.7.2.js',\r\n");
      out.write("\t\t\t'common':'common.js',\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\t// 入口模块\r\n");
      out.write("\tseajs.use(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/detail\");\r\n");
      out.write("</script>\r\n");
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
    _jspx_th_c_set_3.setValue(new String("http://192.168.8.241/cas/login?service=http://192.168.8.122:8080/homepage"));
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
    _jspx_th_c_set_4.setValue(new String("http://192.168.8.241/cas"));
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
    _jspx_th_c_set_5.setValue(new String("http://192.168.8.241"));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }

  private boolean _jspx_meth_fmt_formatDate_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_formatDate_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _jspx_tagPool_fmt_formatDate_value_pattern_nobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_formatDate_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatDate_0.setParent(null);
    _jspx_th_fmt_formatDate_0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.publishDate}", java.util.Date.class, (PageContext)_jspx_page_context, null));
    _jspx_th_fmt_formatDate_0.setPattern("yyyy-MM-dd");
    int _jspx_eval_fmt_formatDate_0 = _jspx_th_fmt_formatDate_0.doStartTag();
    if (_jspx_th_fmt_formatDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
      return true;
    }
    _jspx_tagPool_fmt_formatDate_value_pattern_nobody.reuse(_jspx_th_fmt_formatDate_0);
    return false;
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${infoType=='xmxx'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("/relation?name=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${publishInfo.projectName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${infoType!='xmxx'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("javaScript:void(0);");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
