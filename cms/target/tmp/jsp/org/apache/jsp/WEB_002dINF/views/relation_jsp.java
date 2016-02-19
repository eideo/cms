package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>关系网展示页</title>\r\n");
      out.write("    <mycss>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/basic.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/style.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/util.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/relation.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/intro.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    </mycss>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class='sliderCon'>\r\n");
      out.write("\r\n");
      out.write("    <div class='searchBody'>\r\n");
      out.write("\r\n");
      out.write("        <div class='inputBox'>        \r\n");
      out.write("            <input type='text'  class='inputText' id='searchText' placeholder='项目/单位名称'/>\r\n");
      out.write("            <div class='btnCon'><div class='btn'></div></div>\r\n");
      out.write("            <div class='searchItem'>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"rItem\">混凝土项目</li>\r\n");
      out.write("                    <li class=\"rItem\">北京混凝土</li>\r\n");
      out.write("                    <li class=\"rItem\">上海混凝土专业标</li>\r\n");
      out.write("                    <li class=\"rItem\">混凝土公司</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class='rem'>\r\n");
      out.write("            <div class='comRem'>\r\n");
      out.write("                <span>单位角色：</span>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"item\">全部</li>\r\n");
      out.write("                    <li class=\"item\">业主</li>\r\n");
      out.write("                    <li class=\"item\">设计院</li>\r\n");
      out.write("                    <li class=\"item\">承建商</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class='perRem'>\r\n");
      out.write("               <span>联系人角色：</span>\r\n");
      out.write("                <ul>\r\n");
      out.write("                     <li class=\"item\">全部</li>\r\n");
      out.write("                    <li class=\"item\">设计师</li>\r\n");
      out.write("                    <li class=\"item\">项目负责人</li>                  \r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chartCon\">\r\n");
      out.write("\r\n");
      out.write("    <div class='tree' >  \r\n");
      out.write("        <div id=\"relationImg\">\r\n");
      out.write("            <img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/images/resTemp.png' />\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='recomCon'>\r\n");
      out.write("        <div class=\"top\">\r\n");
      out.write("            正在浏览的用户\r\n");
      out.write("            <i></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"recom\">\r\n");
      out.write("            <div id='marquee'>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li>xxx 158***501</li>\r\n");
      out.write("                    <li>xxx 137***446</li>\r\n");
      out.write("                    <li>xxx 137***223</li>\r\n");
      out.write("                    <li>xxx 159***712</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class='tipWrapper'>\r\n");
      out.write("        <div class='tipWrapCon'>\r\n");
      out.write("            <div class=\"tip tip_project\" style='display:none'>\r\n");
      out.write("                <div class=\"tipWrap\">\r\n");
      out.write("                    <i class='close'></i>\r\n");
      out.write("                    <div class=\"tipTitle\">项目</div>\r\n");
      out.write("                    <div class=\"tipCon\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class='more'><a href='#' target=\"_blank\">查看更多</a></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"tip tip_zhaobiao\" style='display:none'>\r\n");
      out.write("                <div class=\"tipWrap\">\r\n");
      out.write("                    <div class=\"tipLink\"></div>\r\n");
      out.write("                    <div class=\"tipTitle\">招标</div>\r\n");
      out.write("                    <div class=\"tipCon\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                        <li class=\"info\">凯悦国际酒店管理集团(北京)有限责任公司商业及零售/办公楼</li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"tip tip_zhongbiao\" style='display:none'>\r\n");
      out.write("                <div class=\"tipWrap\">\r\n");
      out.write("                    <div class=\"tipLink\"></div>\r\n");
      out.write("                    <div class=\"tipTitle\">中标</div>\r\n");
      out.write("                    <div class=\"tipCon\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                        <li class=\"info\">凯悦国际酒店管理集团(北京)有限责任公司商业及零售/办公楼</li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <myScript>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            \r\n");
      out.write("            !function() {\r\n");
      out.write("            var cookie,ua,match;\r\n");
      out.write("            ua = window.navigator.userAgent;\r\n");
      out.write("            match = /;\\s*MSIE (\\d+).*?;/.exec(ua);\r\n");
      out.write("            if (match && +match[1] < 9) {\r\n");
      out.write("\r\n");
      out.write("                $('body').html('')\r\n");
      out.write("                $('body').append('<h1>你正在使用低版本浏览器，为了更好的服务体验，请升级浏览器</h1>')\r\n");
      out.write("                cookie = document.cookie.match(/(?:^|;)\\s*ic=(\\d)/);\r\n");
      out.write("                if (cookie && cookie[1]) {\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("                $(\"body\").prepend([\r\n");
      out.write("                    \"<div id='compatible' class='compatible-contianer'>\",\r\n");
      out.write("                    \"<p class='cpt-ct'><i></i>您的浏览器版本过低。为保证最佳浏览体验，<a href='/static/html/browser.html'>请点此更新高版本浏览器</a></p>\",\r\n");
      out.write("                    \"<div class='cpt-handle'><a href='javascript:;' class='cpt-agin'>以后再说</a><a href='javascript:;' class='cpt-close'><i></i></a>\",\r\n");
      out.write("                    \"</div>\"\r\n");
      out.write("                ].join(\"\"));\r\n");
      out.write("\r\n");
      out.write("                $(\"#compatible .cpt-agin\").click(function() {\r\n");
      out.write("                    var d = new Date();\r\n");
      out.write("                    d.setTime(d.getTime() + 30 * 24 * 3600 * 1000);\r\n");
      out.write("                    document.cookie = \"ic=1; expires=\" + d.toGMTString() + \"; path=/\";\r\n");
      out.write("                    $(\"#compatible\").remove();\r\n");
      out.write("                });\r\n");
      out.write("                $(\"#compatible .cpt-close\").click(function() {\r\n");
      out.write("                    $(\"#compatible\").remove();\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }();\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("       <script src=\"//cdn.bootcss.com/d3/3.5.12/d3.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/sea.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/config.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/relationCookie.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/intro.js?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("         // 入口模块\r\n");
      out.write("         seajs.use(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/public/relation\")\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var num = getCookie('age');\r\n");
      out.write("            $(function(){\r\n");
      out.write("                if(num != \"18\"){\r\n");
      out.write("                    introJs().setOptions({\r\n");
      out.write("                        //对应的按钮\r\n");
      out.write("                        prevLabel:\"上一步\", \r\n");
      out.write("                        nextLabel:\"下一步\",\r\n");
      out.write("                        skipLabel:\"跳过引导页\",\r\n");
      out.write("                        doneLabel:\"立即体验\",\r\n");
      out.write("                        //对应的数组，顺序出现每一步引导提示\r\n");
      out.write("                        steps: [\r\n");
      out.write("                            {\r\n");
      out.write("                                //第一步引导\r\n");
      out.write("                                //这个属性类似于jquery的选择器， 可以通过jquery选择器的方式来选择你需要选中的对象进行指引\r\n");
      out.write("                                element: '.user-info',\r\n");
      out.write("                                //这里是每个引导框具体的文字内容，中间可以编写HTML代码\r\n");
      out.write("                                intro: '<div id=\"guideMsg\"><h3>登录查询</h3><p>亲,只有登录了!才能查看关系网更多信息</p></div>',\r\n");
      out.write("                                //这里可以规定引导框相对于选中对象出现的位置 top,bottom,left,right\r\n");
      out.write("                                position: 'left'\r\n");
      out.write("                            },\r\n");
      out.write("                            {\r\n");
      out.write("                                //第二步引导\r\n");
      out.write("                                element: '#searchText',\r\n");
      out.write("                                intro: '<div id=\"guideMsg\"><h3>精确搜索</h3><p>输入项目名称或单位名称按角色进行关系精确查询</p></div>',\r\n");
      out.write("                                position: 'left'\r\n");
      out.write("                            },\r\n");
      out.write("                            {\r\n");
      out.write("                                //第五步引导\r\n");
      out.write("                                element: '#relationImg',\r\n");
      out.write("                                intro: '<div id=\"guideMsg\"><h3>搜索结果</h3><p>试试鼠标悬浮或者点击结点，会有意外收获</p></div>',\r\n");
      out.write("                                position: 'right'\r\n");
      out.write("                            },\r\n");
      out.write("                             {\r\n");
      out.write("                                //第六步引导\r\n");
      out.write("                                element: '#relationImg',\r\n");
      out.write("                                intro: '<div id=\"guideMsg\"><h3>搜索结果</h3><p>点击图形空白处或者线可拖拽</p></div>',\r\n");
      out.write("                                position: 'left'\r\n");
      out.write("                            },\r\n");
      out.write("                            {\r\n");
      out.write("                                //第七步引导\r\n");
      out.write("                                element: '.top',\r\n");
      out.write("                                intro: '<div id=\"guideMsg\"><h3>其他人关注</h3><p>您还可以看看其他人都查了些什么？</p></div>',\r\n");
      out.write("                                position: 'left'\r\n");
      out.write("                            } \r\n");
      out.write("                        ]\r\n");
      out.write("\r\n");
      out.write("                    }).start();\r\n");
      out.write("                    addCookie('age','18',250);\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </myScript>\r\n");
      out.write("    ");
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
}
