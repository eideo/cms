package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class industry_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/common/base.jsp");
    _jspx_dependants.add("/WEB-INF/views/dialogLogin/loginDialog.jsp");
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

      out.write("\r\n");
      out.write("\r\n");
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
      out.write(" \r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>行业指数</title>\r\n");
      out.write("\t<myCss>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/basic.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/industry.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/lib/calendar.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t</myCss>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class='profile'>\r\n");
      out.write("\t<div class='profileCon clearfix'>\r\n");
      out.write("\t\t<h2 class='title'>\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t\t<div class='left'>\r\n");
      out.write("\t\t\t<div class='top'>\r\n");
      out.write("\t\t\t\t<h3>按一级行业分类</h3>\r\n");
      out.write("\t\t\t\t<!--<div class='time' id='endTime'>\r\n");
      out.write("\t\t\t\t\t<div class='innerTime'>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"dateRight\"  value ='2015.11'/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<i class='daShow'>\r\n");
      out.write("\t\t\t\t\t</i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='zhi'>至</div>\r\n");
      out.write("\t\t\t\t<div class='time' id='startTime'>\r\n");
      out.write("\t\t\t\t\t<div class='innerTime'>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"dateLeft\"  value ='2014.01'/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<i class='daShow'>\r\n");
      out.write("\t\t\t\t\t</i>\r\n");
      out.write("\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class='chart' id='chart1'>\r\n");
      out.write("\t\t\t\t<div class='tip'>\r\n");
      out.write("\t\t\t\t\t<div class='tipCon'>8888\r\n");
      out.write("\t\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class='right'>\r\n");
      out.write("\t\t\t<div class='distr'>\r\n");
      out.write("\t\t\t\t<h3 class='mt25 ml30'><span id='timeShow' style='font-weight:normal;color:#ff8519'>201312-201511</span> 信息数量分布</h3>\r\n");
      out.write("\t\t\t\t<div class='timeRange'>\r\n");
      out.write("\t\t\t\t\t<div class='con' id='timeRange'>\t\r\n");
      out.write("\t\t\t\t\t\t<span class='handle' id='timeHandle'>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id='chart2'></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class='prop'>\r\n");
      out.write("\t\t\t\t<h3 class='mt25 ml30'>信息类型占比</h3>\r\n");
      out.write("\t\t\t\t<div id='chart3'></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class='industry'>\r\n");
      out.write("\t<div class='industryCon clearfix'>\r\n");
      out.write("\t\t<h2 class='title'></h2>\r\n");
      out.write("\t\t<div class='left'>\r\n");
      out.write("\t\t\t<h3 class='mt37 ml42'> <span class='highLight'></span></h3>\r\n");
      out.write("\t\t\t<div id='chart4'>\r\n");
      out.write("\t\t\t\t<div class='tip'>\r\n");
      out.write("\t\t\t\t\t<div class='tipCon'>8888\r\n");
      out.write("\t\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class='result'> <span class='bold'></span></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class='right'>\r\n");
      out.write("\t\t\t<h3 class='mt37 ml42'> <span class='highLight'></span></h3>\r\n");
      out.write("\t\t\t<div id='chart5'>\r\n");
      out.write("\t\t\t\t<div class='tip'>\r\n");
      out.write("\t\t\t\t\t<div class='tipCon'>8888\r\n");
      out.write("\t\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class='result'><span class='bold'></span> </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class='industryTag'>\r\n");
      out.write("\t\t<p>数据来源：中国采购与招标网大数据研究中心</p>\r\n");
      out.write("\t\t<p>作用说明：景气指数反映特定行业的景气变化情况，关注指数反映客户在互联网上对特定行业的关注程度及持续变化情况</p>\r\n");
      out.write("\t\t<p>算法说明：以中国采购与招标网大数据研究中心的数据资源和客户在我网的搜索量为基础，以特定行业为统计对象，科学分析并计算出各个特定行业的指数值。</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class='user'>\r\n");
      out.write("\t<div class='userCon clearfix'>\r\n");
      out.write("\t\t<h2 class='title'></h2>\r\n");
      out.write("\t\t<div class='left'>\r\n");
      out.write("\t\t\t<div class=\"province\">省份</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class='right'>\r\n");
      out.write("\t\t\t<div id ='chart6'>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class='chartText'>关注 <span id='chartT6'>房地产建筑行业</span>的客户中，约60%竞争力适中占比最大</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id ='chart7'>\r\n");
      out.write("\t\t\t\t<div class='chartText'>关注 <span id='chartT6'>房地产建筑行业</span>约60%竞争力适中占比最大</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div class='userTag'>\r\n");
      out.write("\t\t<p>数据来源：中国采购与招标网大数据研究中心</p>\r\n");
      out.write("\t\t<p>作用说明：景气指数反映特定行业的景气变化情况，关注指数反映客户在互联网上对特定行业的关注程度及持续变化情况</p>\r\n");
      out.write("\t\t<p>算法说明：以中国采购与招标网大数据研究中心的数据资源和客户在我网的搜索量为基础，以特定行业为统计对象，科学分析并计算出各个特定行业的指数值。</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class='report'>\r\n");
      out.write("\t<div class='reportCon clearfix'>\r\n");
      out.write("\t\t<h2 class='title'></h2>\r\n");
      out.write("\t\t<div class='left'>\r\n");
      out.write("\t\t\t<div class='top'>\r\n");
      out.write("\t\t\t\t<div><span class='large'>房地产建筑行业</span>\r\n");
      out.write("\t\t\t\t<span class='small'>热门单位</span></div>\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"list\">\r\n");
      out.write("\t\t\t\t<div class='reTitle clearfix'>\r\n");
      out.write("\t\t\t\t\t<span class='rePm'>排名</span>\r\n");
      out.write("\t\t\t\t\t<span class='reGjc'>单位名称</span>\r\n");
      out.write("\t\t\t\t\t<span class='reZs'>搜索指数</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id='leftListCon'>\r\n");
      out.write("\t\t\t\t\t<ul id='leftList' class='clearfix'>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class='right clearfix'>\r\n");
      out.write("\t\t\t<div class=\"conLeft\">\r\n");
      out.write("\t\t\t\t<div class='mTop'>\r\n");
      out.write("\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t<span class='mtitle'>房地产建筑行业</span>\r\n");
      out.write("           \t\t\t<span class='subTitle'>热门报告</span>\r\n");
      out.write("           \t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"mBottom\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class='li3'>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class='li4'>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"conRight\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div class='rTop'>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class='li1'>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class='li2'>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class='rTop'>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class='li5'>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class='li6'>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='chart'></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class='more'>查看更多</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"gotop\">\r\n");
      out.write("\t\t<i></i>\r\n");
      out.write("\t\t<span>顶部</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<myScript>\r\n");
      out.write("\t\t<script src=\"//cdn.bootcss.com/d3/3.5.12/d3.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" >\r\n");
      out.write("\t\t\tvar startDate=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${startDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\tvar endDate=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${endDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/sea.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/config.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t// 入口模块\r\n");
      out.write("\t\tseajs.use(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/public/industry\")\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</myScript>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\t <script type=\"text/html\" id=\"headerTemp\">\r\n");
      out.write("\t\t \t<li style=\"color:#fff\">欢迎您，{username}</li>\r\n");
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
      out.write("\t\t \t\t$('.userbox span').hide();\r\n");
      out.write("\t\t \t\t$('.passwordbox span').hide()\r\n");
      out.write("\t \t\t\t$.ajax({\r\n");
      out.write("\t \t\t\t\ttype:\"post\",\r\n");
      out.write("\t \t\t\t\tasync:true,\r\n");
      out.write("\t \t\t\t\turl:casBase+'/ajaxlogin',\r\n");
      out.write("\t \t\t\t\tdata:{user:$(\"#username\").val(),passwd:$(\"#password\").val(),service:path+'/toLoginIframe'},\r\n");
      out.write("\t \t\t\t\tdataType:\"jsonp\",\r\n");
      out.write("\t \t\t\t\tjsonp:'jsoncallback',\r\n");
      out.write("\t \t\t\t\tsuccess:function(a){\r\n");
      out.write("\r\n");
      out.write("\t \t\t\t\t\tif(a.result){\r\n");
      out.write("\r\n");
      out.write("\t \t\t\t\t\t\tajaxSetUser(path+\"/toLoginIframe?ticket=\"+a.st);\r\n");
      out.write("\t \t\t\t\t\t\t$('.close').click();\r\n");
      out.write("\t \t\t\t\t\t\t$('.login_box').hide()\r\n");
      out.write("\t\t\t \t\t\t\t$('.shadow_all').hide()\r\n");
      out.write("\t \t\t\t\t\t}else{\r\n");
      out.write("\r\n");
      out.write("\t \t\t\t\t\t\tif (a.message === '用户名不存在') {$('.userbox span').show()}\r\n");
      out.write("\t \t\t\t\t\t\tif (a.message === '密码错误') {$('.passwordbox span').show()}\r\n");
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
      out.write("\t\t\t\t<span class='error'>用户名不存在!</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"passwordbox\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" id=\"password\" placeholder=\"密码\">\r\n");
      out.write("\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t<span class='error'>密码错误!</span>\r\n");
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
