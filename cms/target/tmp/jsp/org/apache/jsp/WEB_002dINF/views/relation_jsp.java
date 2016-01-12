package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class relation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
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
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>关系网展示页</title>\r\n");
      out.write("    <mycss>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/basic.css?v=1.0.1-20151229\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/util.css?v=1.0.1-20151229\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/css/relation.css?v=1.0.1-20151229\">\r\n");
      out.write("        \r\n");
      out.write("    </mycss>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class='sliderCon'>\r\n");
      out.write("\r\n");
      out.write("    <div class='sliderBody'>\r\n");
      out.write("        <div class='start'>2001</div>\r\n");
      out.write("        <div class=\"slider\" id='slider'>\r\n");
      out.write("            <div class='timeShow' id='timeShow'>2010.01 - 2012.01</div>\r\n");
      out.write("            <div class='handle' id='handle'></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='end'>2015</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='searchBody'>\r\n");
      out.write("\r\n");
      out.write("        <div class='inputBox'>        \r\n");
      out.write("            <input type='text'  class='inputText' id='searchText' value='项目/单位名称'/>\r\n");
      out.write("            <div class='searchItem'>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"rItem\">混凝土项目</li>\r\n");
      out.write("                    <li class=\"rItem\">北京混凝土</li>\r\n");
      out.write("                    <li class=\"rItem\">上海混凝土专业标</li>\r\n");
      out.write("                    <li class=\"rItem\">混凝土公司</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='comRem'>\r\n");
      out.write("            <div class=\"comRemCon\">\r\n");
      out.write("                <div class='topTitle'>业主<i></i></div>\r\n");
      out.write("                <div class='list' style='display:none'>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>单位角色</li>\r\n");
      out.write("                        <li class=\"item selected\">业主</li>\r\n");
      out.write("                        <li class=\"item\">设计院</li>\r\n");
      out.write("                        <li class=\"item\">承建商</li>\r\n");
      out.write("                        <li class=\"item\">供应商</li>\r\n");
      out.write("                        <li class=\"item diabled\">招标代理</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>    \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='perRem'>\r\n");
      out.write("            <div class=\"perRemCon\">\r\n");
      out.write("                <div class='topTitle'>项目负责人<i></i></div>\r\n");
      out.write("                <div class='list' style='display:none'>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>联系人角色</li>\r\n");
      out.write("                        <li class=\"item\">总工程师</li>\r\n");
      out.write("                        <li class=\"item\">规划师</li>\r\n");
      out.write("                        <li class=\"item selected\">项目负责人</li>\r\n");
      out.write("                        <li class=\"item\">前期负责人</li>\r\n");
      out.write("                        <li class=\"item\">现场负责人</li>\r\n");
      out.write("                        <li class=\"item\">项目经理</li>\r\n");
      out.write("                        <li class=\"item\">采矿工程师</li>\r\n");
      out.write("                        <li class=\"item\">道桥工程师</li>\r\n");
      out.write("                        <li class=\"item\">地质勘查工程师</li>\r\n");
      out.write("                        <li class=\"item\">电气工程师</li>\r\n");
      out.write("                        <li class=\"item\">动力工程师</li>\r\n");
      out.write("                        <li class=\"item\">副总工程师</li>\r\n");
      out.write("                        <li class=\"item\">钢结构工程师</li>\r\n");
      out.write("                        <li class=\"item\">给排水工程师</li>\r\n");
      out.write("                        <li class=\"item\">工艺工程师</li>\r\n");
      out.write("                        <li class=\"item\">光伏工程师</li>\r\n");
      out.write("                        <li class=\"item\">轨道工程师</li>\r\n");
      out.write("                        <li class=\"item\">化工工程师</li>\r\n");
      out.write("                        <li class=\"item\">机电工程师</li>\r\n");
      out.write("                        <li class=\"item\">建筑工程师</li>\r\n");
      out.write("                        <li class=\"item\">建筑设计师</li>\r\n");
      out.write("                        <li class=\"item\">结构工程师</li>\r\n");
      out.write("                        <li class=\"item\">景观设计师</li>\r\n");
      out.write("                        <li class=\"item\">幕墙设计师</li>\r\n");
      out.write("                        <li class=\"item\">暖通工程师</li>\r\n");
      out.write("                        <li class=\"item\">弱电工程师</li>\r\n");
      out.write("                        <li class=\"item\">设备工程师</li>\r\n");
      out.write("                        <li class=\"item\">室内设计师</li>\r\n");
      out.write("                        <li class=\"item\">通信工程师</li>\r\n");
      out.write("                        <li class=\"item\">项目知情人</li>\r\n");
      out.write("                        <li class=\"item\">消防工程师</li>\r\n");
      out.write("                        <li class=\"item\">信号工程师</li>\r\n");
      out.write("                        <li class=\"item\">园林设计师</li>\r\n");
      out.write("                        <li class=\"item\">装饰设计师</li>\r\n");
      out.write("                        <li class=\"item\">项目参与人</li>\r\n");
      out.write("                        <li class=\"item\">其他</li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class='btnCon'><div class='btn'></div></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"chartCon\">\r\n");
      out.write("\r\n");
      out.write("<!--     <div class='scaleCon'>\r\n");
      out.write("    <div class='scale' id='scale'>\r\n");
      out.write("        <i class='handle' id='scaleHandle'></i>\r\n");
      out.write("    </div>\r\n");
      out.write("</div> -->\r\n");
      out.write("    <div class='descr'></div>\r\n");
      out.write("    <div class='tree' >\r\n");
      out.write("        <img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/images/resTemp.png' />\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class='recomCon'>\r\n");
      out.write("        <div class=\"top\">\r\n");
      out.write("            其他人正在浏览\r\n");
      out.write("            <i></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"recom\">\r\n");
      out.write("            <div class='reTitle'>联系人</div>\r\n");
      out.write("            <div id='marquee'>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li>张小三 137***501 </li>\r\n");
      out.write("                    <li>张小三137***501</li>\r\n");
      out.write("                    <li>张小三137***501</li>\r\n");
      out.write("                    <li>张小三137***501</li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <myScript>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/lib/seajs/config.js?v=1.0.1-20151229\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("         // 入口模块\r\n");
      out.write("         seajs.use(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/public/relation\")\r\n");
      out.write("        </script>\r\n");
      out.write("    </myScript>\r\n");
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
}
