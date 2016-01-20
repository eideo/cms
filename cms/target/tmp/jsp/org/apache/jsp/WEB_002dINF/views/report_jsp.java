package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class report_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/common/base.jsp");
    _jspx_dependants.add("/WEB-INF/views/dialogLogin/loginDialog.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_otherwise.release();
    _jspx_tagPool_c_when_test.release();
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
      out.write("\r\n");
      out.write(" ");
      if (_jspx_meth_c_set_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("  ");
      if (_jspx_meth_c_set_3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("  ");
      if (_jspx_meth_c_set_4(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_set_5(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- [if Ite IE8]>\r\n");
      out.write("<script type=\"text/javascript\" src='http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js'></script>\r\n");
      out.write("<script type=\"text/javascript\" src='http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js'></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar path = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t//var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://101.200.0.81/cms/homepage\");\r\n");
      out.write("\t//var casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://192.168.8.129:8080/homepage\");\r\n");
      out.write("\tvar casPath =encodeURI(\"http://101.200.0.81/cas/login?service=http://192.168.8.122:8080/homepage\");\r\n");
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
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>行业报告</title>\r\n");
      out.write("\t<myCss>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/basic.css?v=1.0.1-20151229\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/report.css?v=1.0.1-20151229\">\r\n");
      out.write("\t</myCss>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 轮播图 -->\r\n");
      out.write("\t<div id=\"box\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t    </ul>\r\n");
      out.write("\t    <ol>\r\n");
      out.write("\t    \t<li class=\"on\"></li>\r\n");
      out.write("\t    \t<li></li>\r\n");
      out.write("\t    \t<li></li>\r\n");
      out.write("\t    </ol>\r\n");
      out.write("\t\t<a href=\"javascript:;\" id=\"prev\"></a>\r\n");
      out.write("\t\t<a href=\"javascript:;\" id=\"next\"></a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 分类导航 -->\r\n");
      out.write("\t<div class=\"s_nav clearfix\">\r\n");
      out.write("\t\t<div class=\"h2\" onclick=\"javascript:getByInduxtry(0);\"><i class=\"h2i\"></i><a>行业分类</a></div>\r\n");
      out.write("\t\t<div class=\"term clearfix\">\r\n");
      out.write("\t\t\t<input id=\"induxtry_id\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${induxtryId }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t<ul class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<li class=\"li1\" onclick=\"javascript:getByInduxtry(2101);\" rid=\"2101\"><i class=\"i1\"></i><a>冶金矿产原材料</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li2\" onclick=\"javascript:getByInduxtry(2102);\" rid=\"2102\"><i class=\"i2\"></i><a>能源</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li3\" onclick=\"javascript:getByInduxtry(2103);\" rid=\"2103\"><i class=\"i3\"></i><a>农林水利</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li4\" onclick=\"javascript:getByInduxtry(2104);\" rid=\"2104\"><i class=\"i4\"></i><a>环保</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li5 right\" onclick=\"javascript:getByInduxtry(2105);\" rid=\"2105\"><i class=\"i5\"></i><a>交通运输</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li6\" onclick=\"javascript:getByInduxtry(2107);\" rid=\"2107\"><i class=\"i6\"></i><a>医疗卫生</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li7\" onclick=\"javascript:getByInduxtry(2108);\" rid=\"2108\"><i class=\"i7\"></i><a>房地产建筑</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li8\" onclick=\"javascript:getByInduxtry(2111);\" rid=\"2111\"><i class=\"i8\"></i><a>轻工</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li9\" onclick=\"javascript:getByInduxtry(2112);\" rid=\"2112\"><i class=\"i9\"></i><a>化工</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"li10 right\" onclick=\"javascript:getByInduxtry(2113);\" rid=\"2113\"><i class=\"i10\"></i><a>机械电子</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 列表 -->\r\n");
      out.write("\t<div class=\"list clearfix\">\r\n");
      out.write("\t\t<div class=\"reportList\">\r\n");
      out.write("\t\t\t<h4>行业报告列表<i></i></h4>\r\n");
      out.write("\t\t\t\t<ul id=\"reportMainList\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<!-- 分页 -->\r\n");
      out.write("\t\t\t\t<div class=\"page_bg\">\r\n");
      out.write("\t\t\t\t\t<div class=\"page\">\r\n");
      out.write("\t\t\t\t\t\t<form id=\"pageForm\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"paging\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"tcdPageCode\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"hotList\">\r\n");
      out.write("\t\t\t<h4>热门报告<i></i></h4>\r\n");
      out.write("\t\t\t<ul class=\"hot\">\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<a id=\"gotop\">\r\n");
      out.write("\t\t<i></i>\r\n");
      out.write("\t\t<span>顶部</span>\r\n");
      out.write("\t</a>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/html\" id=\"listTemplate\">\r\n");
      out.write("\t\t<li class=\"clearfix\">\r\n");
      out.write("\t\t\t<div  class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/reportdetail/{reportMain.id}\" class=\"leftImg\" target=\"_blank\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/images/{reportMain.imageIndex}\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div class=\"description\">\r\n");
      out.write("\t\t\t\t\t<h5><a class=\"cutTitle\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/reportdetail/{reportMain.id}\" id=\"info_{reportMain.id}\" onclick=\"javascript:custBehavior(2, 11506, {reportMain.id}, 1);\" target=\"_blank\" >{reportMain.reportTitle}</a></h5>\r\n");
      out.write("\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"trade\">{reportMain.induxtryName}</a>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"line\"></i>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"time\">{reportMain.updateDate}</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"font cutParagraph\">{reportMain.reportAbstract}</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"navBox clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"ap\" actiontype=\"3\" infotype=\"11506\" infoid=\"{reportMain.id}\" >\r\n");
      out.write("\t\t\t\t\t<i class=\"attention\"></i>\r\n");
      out.write("\t\t\t\t\t<span>关注</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"re\">已关注</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"cp\" actiontype=\"4\" infotype=\"11506\" infoid=\"{reportMain.id}\" >\r\n");
      out.write("\t\t\t\t\t<i class=\"collection\"></i>\r\n");
      out.write("\t\t\t\t\t<span>收藏</span>\r\n");
      out.write("\t\t\t\t\t<span class=\"re\">已收藏</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"sp\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" class=\"share\">分享</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"shareBtn bdsharebuttonbox\">\r\n");
      out.write("\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '{reportMain.id}', 'QQ空间');\" class=\"bds_qzone\" data-cmd=\"qzone\" title=\"分享到QQ空间\"></a>\r\n");
      out.write("\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '{reportMain.id}', '新浪微博');\" class=\"bds_tsina\" data-cmd=\"tsina\" title=\"分享到新浪微博\"></a>\r\n");
      out.write("\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '{reportMain.id}', '微信');\" class=\"bds_weixin\" data-cmd=\"weixin\" title=\"分享到微信\"></a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<em></em>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<myScript>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/popwin.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/paging/page.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/custBehavior.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/report.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tvar resPath = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t$(\".tcdPageCode\").createPage({\r\n");
      out.write("\t\t        pageCount : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",\r\n");
      out.write("\t\t        current : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(",\r\n");
      out.write("\t\t        backFn : function(p) {\r\n");
      out.write("\t\t        \tajaxReport(p);\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    });\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</myScript>\r\n");
      out.write("\t<script>\r\n");
      out.write("\twindow._bd_share_config={\"common\":{\"bdSnsKey\":{},\"bdText\":\"\",\"bdMini\":\"2\",\"bdPic\":\"\",\"bdStyle\":\"0\",\"bdSize\":\"16\"},\"share\":{}};\r\n");
      out.write("\twith(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];\r\n");
      out.write("\t</script>\r\n");
      out.write("\t");
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
      out.write("\t\t\t\t<a href=\"javascript:;\" class=\"update\">忘记密码</a>\r\n");
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
    _jspx_th_c_set_3.setValue(new String("http://101.200.0.81/cas/login?service=http://192.168.8.122:8080/homepage"));
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
    _jspx_th_c_set_4.setValue(new String("http://101.200.0.81/cas"));
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
    _jspx_th_c_set_5.setValue(new String("http://101.200.0.81"));
    int _jspx_eval_c_set_5 = _jspx_th_c_set_5.doStartTag();
    if (_jspx_th_c_set_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_5);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("reportCarousel");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainListCarousel}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t    \t<li>\r\n");
          out.write("\t\t    \t\t<input id=\"reporturl_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('/');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.reportUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" />\r\n");
          out.write("\t\t    \t\t<a href=\"javascript:reportView(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(");\" target=\"_blank\"><img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/resources/commons/images/report_img");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status.index + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(".png\"></a>\r\n");
          out.write("\t\t    \t\t<div class=\"shadow\"></div>\r\n");
          out.write("\t\t    \t\t<div class=\"imgInfo\">\r\n");
          out.write("\t\t    \t\t\t<h6 id=\"info_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.reportTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</h6>\r\n");
          out.write("\t\t    \t\t\t<p class=\"cutParagraph\">\r\n");
          out.write("\t\t    \t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.reportAbstract}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("\t\t    \t\t\t</p>\r\n");
          out.write("\t\t    \t\t\t<a href=\"javascript:reportView(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportCarousel.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(");\" target=\"_blank\">点击阅读</a>\r\n");
          out.write("\t\t    \t\t</div>\r\n");
          out.write("\t\t    \t</li>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!empty reportMainList}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_c_forEach_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_forEach_1.setVar("reportMain");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainList}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<li class=\"clearfix\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div  class=\"clearfix\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/reportdetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"leftImg\" target=\"_blank\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/resources/commons/images/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.imageIndex}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"description\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<h5><a class=\"cutTitle\" href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/reportdetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" id=\"info_");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" onclick=\"javascript:custBehavior(2, 11506, ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(", 1);\" title=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.reportTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"  target=\"_blank\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.reportTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a class=\"trade\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.induxtryName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"line\"></i>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"time\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.updateDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<p class=\"font cutParagraph\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.reportAbstract}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div class=\"navBox clearfix\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ap\" actiontype=\"3\" infotype=\"11506\" infoid=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"attention\"></i>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span>关注</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"re\">已关注</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"cp\" actiontype=\"4\" infotype=\"11506\" infoid=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"collection\"></i>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span>收藏</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"re\">已收藏</span>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"sp\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:;\" class=\"share\">分享</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"shareBtn bdsharebuttonbox\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', 'QQ空间');\" class=\"bds_qzone\" data-cmd=\"qzone\" title=\"分享到QQ空间\"></a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', '新浪微博');\" class=\"bds_tsina\" data-cmd=\"tsina\" title=\"分享到新浪微博\"></a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a onclick=\"javascript:custBehaviorShare(5, 11506, '");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMain.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', '微信');\" class=\"bds_weixin\" data-cmd=\"weixin\" title=\"分享到微信\"></a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<em></em>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t没有符合条件的记录\r\n");
        out.write("\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("reportMainTop");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainListTop10}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<li class=\"cutTitle\"><a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/reportdetail/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainTop.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" title=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainTop.reportTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" onclick=\"javascript:custBehavior(2, 11506, ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainTop.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(", 1);\"  target=\"_blank\" >");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reportMainTop.reportTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
