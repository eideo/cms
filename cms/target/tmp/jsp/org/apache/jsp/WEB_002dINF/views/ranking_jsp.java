package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ranking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/common/base.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
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
      out.write("<!DOCTYPE html>\r\n");
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>排行榜</title>\r\n");
      out.write("\t<myCss>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/ranking.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t</myCss>\r\n");
      out.write("\t<!--[if lt IE9]>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/html5shiv.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/respond.js\"></script>\r\n");
      out.write("\t<![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--地图部分-->\r\n");
      out.write("<div class=\"map_bg\">\r\n");
      out.write("\t<div class=\"mapBox\">\r\n");
      out.write("\t\t<div class=\"f2\">\r\n");
      out.write("\t\t\t<div class=\"chart clearfix\">\r\n");
      out.write("\t\t\t\t<div class=\"map\" id=\"map\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"key-words\">\r\n");
      out.write("\t\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"a1\" href=\"javascript:;\">热门关键词</a>\r\n");
      out.write("\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t<div class=\"words\" id=\"words\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">铁路</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">橡胶</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">接地</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">综合</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">钢筋</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">施工</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">钢材</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">工程</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">真空</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">断路器</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">系统</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">水泥</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">广州</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">铁路货车</a>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" target=\"_blank\">招标</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 中间内容 -->\r\n");
      out.write("<div class=\"content clearfix\">\r\n");
      out.write("\t<div class=\"ranking\">\r\n");
      out.write("\t\t<ul class=\"clearfix\" id=\"c_btn\">\r\n");
      out.write("\t\t\t<li class=\"active\" type=\"2\">热门关系网</li>\r\n");
      out.write("\t\t\t<li type=\"3\">热门信息</li>\r\n");
      out.write("\t\t\t<li type=\"4\">热门单位</li>\r\n");
      out.write("\t\t\t<li type=\"5\" class=\"last\">热门报告</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div class=\"option clearfix\">\r\n");
      out.write("\t\t\t<div class=\"timeType clearfix\">\r\n");
      out.write("\t\t\t\t<h5>时 间:</h5>\r\n");
      out.write("\t\t\t\t<div class=\"time clearfix\">\r\n");
      out.write("\t\t\t\t\t<a class=\"active\" href=\"javascript:;\">不限</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"1\" href=\"javascript:;\">今天</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2\" href=\"javascript:;\">最近一周</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"3\" href=\"javascript:;\">最近一月</a>\r\n");
      out.write("\t\t\t\t\t<div class=\"diy\" style=\"display:none\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"sang_Calender\" value=\"自定义时间\">\r\n");
      out.write("\t\t\t\t\t\t<i></i>\r\n");
      out.write("\t\t\t\t\t</div>\t\t    \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"tradeType clearfix\">\r\n");
      out.write("\t\t\t\t<h5>行 业:</h5>\r\n");
      out.write("\t\t\t\t<div class=\"trade clearfix\">\r\n");
      out.write("\t\t\t\t\t<a class=\"active\" href=\"javascript:;\">不限</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2101\" href=\"javascript:;\">冶金矿产原材料</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2102\" href=\"javascript:;\">能源</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2103\" href=\"javascript:;\">农林水利</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2104\" href=\"javascript:;\">环保</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2105\" href=\"javascript:;\">交通运输</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2106\" href=\"javascript:;\">网络通讯计算机</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2107\" href=\"javascript:;\">医疗卫生</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2108\" href=\"javascript:;\">房地产建筑</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2109\" href=\"javascript:;\">公共设施</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2110\" href=\"javascript:;\" class=\"hidden disLeft\">科技文教旅游</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2111\" href=\"javascript:;\" class=\"hidden\">轻工</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2112\" href=\"javascript:;\" class=\"hidden\">化工</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2113\" href=\"javascript:;\" class=\"hidden\">机械电子</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2114\" href=\"javascript:;\" class=\"hidden\">商务服务</a>\r\n");
      out.write("\t\t\t\t\t<a code=\"2115\" href=\"javascript:;\" class=\"hidden\">其他</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"more\">更多<i></i></div>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"areaType clearfix\">\r\n");
      out.write("\t\t\t\t<h5>地 区:</h5>\r\n");
      out.write("\t\t\t\t<div class=\"area clearfix\">\r\n");
      out.write("\t\t\t\t\t<a class=\"active\" href=\"javascript:;\">不限</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318601\">北京</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318602\">上海</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318603\">天津</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318604\">重庆</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318605\">河北</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318606\">山西</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318607\">内蒙古</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318608\">辽宁</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"318609\">吉林</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186010\">黑龙江</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186011\">江苏</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186012\">浙江</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186013\">安徽</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186014\">福建</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186015\">江西</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186016\">山东</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186017\">河南</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186018\" class=\"hidden disLeft\">湖北</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186019\" class=\"hidden\">湖南</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186020\" class=\"hidden\">广东</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186021\" class=\"hidden\">广西</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186022\" class=\"hidden\">海南</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186023\" class=\"hidden\">贵州</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186024\" class=\"hidden\">云南</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186025\" class=\"hidden\">西藏</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186026\" class=\"hidden\">陕西</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186027\" class=\"hidden\">四川</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186028\" class=\"hidden\">甘肃</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186029\" class=\"hidden\">青海</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186030\" class=\"hidden\">新疆</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186031\" class=\"hidden\">宁夏</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186032\" class=\"hidden\">香港</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186033\" class=\"hidden\">澳门</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" id=\"3186034\" class=\"hidden\">台湾</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"more\">更多<i></i></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"listBox\">\r\n");
      out.write("\t\t\t<div class=\"part part2\">\r\n");
      out.write("\t\t\t\t<h3 class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t<i class=\"rank\"></i>\r\n");
      out.write("\t\t\t\t\t<i class=\"keyword\">项目/单位名称</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"index\">搜索热度</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"link\">相关链接</i>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<ul class=\"rankinglist\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"part part3\">\r\n");
      out.write("\t\t\t\t<h3 class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t<i class=\"rank\"></i>\r\n");
      out.write("\t\t\t\t\t<i class=\"keyword\">项目名称</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"index\">搜索指数</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"link\">相关链接</i>\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<ul class=\"rankinglist\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"part part4\">\r\n");
      out.write("\t\t\t\t<h3 class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t<i class=\"rank\"></i>\r\n");
      out.write("\t\t\t\t\t<i class=\"keyword\">单位名称</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"index\">热度</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"link\">相关链接</i>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<ul class=\"rankinglist\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"part part5\">\r\n");
      out.write("\t\t\t\t<h3 class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t<i class=\"rank\"></i>\r\n");
      out.write("\t\t\t\t\t<i class=\"keyword\">报告名称</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"index\">热度</i>\r\n");
      out.write("\t\t\t\t\t<i class=\"link\">相关链接</i>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<ul class=\"rankinglist\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"page_bg\">\r\n");
      out.write("\t\t<div class=\"page\">\r\n");
      out.write("\t\t\t<form id=\"pageForm\">\r\n");
      out.write("\t\t\t\t<div class=\"paging\">\r\n");
      out.write("\t\t\t\t\t<div class=\"tcdPageCode\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<a id=\"gotop\">\r\n");
      out.write("\t<i></i>\r\n");
      out.write("\t<span>顶部</span>\r\n");
      out.write("</a>\r\n");
      out.write("<script type=\"text/html\" id = \"partTemp2\">\r\n");
      out.write("\t\t\t\t<li class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-\">{num}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"keyResult cutTitle\">{name}</div>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"-[{num}>3:indexResult;{num}<=3:red;]-\">{countNow}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"linkResult\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/search?keyword={name}\"  target=\"_blank\">信息</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/report/{industry}\"  target=\"_blank\">行业报告</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/html\" id = \"partTemp4\">\r\n");
      out.write("\t<li class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-\">{num}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"keyResult cutTitle\">{name}</div>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"-[{num}>3:indexResult;{num}<=3:red;]-\">{countNow}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"linkResult\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/relation?name={name}&type=company\" target=\"_blank\">关系网</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/report/{industry}\"  target=\"_blank\">行业报告</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/html\" id = \"partTemp3\">\r\n");
      out.write("\t\t\t\t\t<li class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-\">{num}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"keyResult cutTitle\">{name}</div>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"-[{num}>3:indexResult;{num}<=3:red;]-\">{countNow}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"linkResult\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/relation?name={name}&type=project\" target=\"_blank\">关系网</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/search?keyword={name}\" target=\"_blank\">信息</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/report/{industry}\" target=\"_blank\">行业报告</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/html\" id = \"partTemp5\">\r\n");
      out.write("\t\t\t\t<li class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-\">{num}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"keyResult cutTitle\">{name}</div>\r\n");
      out.write("\t\t\t\t\t\t<i class=\"-[{num}>3:indexResult;{num}<=3:red;]-\">{countNow}</i>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"linkResult\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/relation?industryId={industry}&type=project\" target=\"_blank\">关系网</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/search?industryId={industry}\" target=\"_blank\">信息</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t<myScript>\r\n");
      out.write("\t\t<script src=\"//cdn.bootcss.com/d3/3.5.12/d3.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/custBehavior.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/paging/page.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
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
      out.write("/resources/commons/js/public/ranking\")\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</myScript>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("ranking");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rankingDatas}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("status");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<li class=\"clearfix\">\r\n");
          out.write("\t\t\t\t\t\t<i class=\"rankResult ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${status.index+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</i>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"keyResult cutTitle\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ranking.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</div>\r\n");
          out.write("\t\t\t\t\t\t<i ");
          if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          if (_jspx_meth_c_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ranking.countNow}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</i>\r\n");
          out.write("\t\t\t\t\t\t<div class=\"linkResult\">\r\n");
          out.write("\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/relation?name=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ranking.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\">关系网</a>\r\n");
          out.write("\t\t\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${appPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/search?keyword=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ranking.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\">信息</a>\r\n");
          out.write("\t\t\t\t\t\t</div>\t\r\n");
          out.write("\t\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t");
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

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(status.index+1)==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("one");
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

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(status.index+1)==2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("two");
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

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(status.index+1)==3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("three");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(status.index+1)<=3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("class=\"red\"");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(status.index+1)>3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("class=\"indexResult\"");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }
}
