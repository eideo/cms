package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class topService_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>高端服务</title>\r\n");
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
      out.write("/resources/commons/css/topService.css?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectversion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    </mycss>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"sliderWrapper\">\r\n");
      out.write("\t<div class=\"slider\">\r\n");
      out.write("\t\t<h1>创新，盛出不群攻创造未来</h1>\r\n");
      out.write("\t\t<p>创新，盛出不群攻创造未来</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"infoWrapper\">\r\n");
      out.write("\t<div class=\"top\"><h2>信息</h2></div>\r\n");
      out.write("\t<div class=\"info\">\r\n");
      out.write("\t\t<ul class=\"list clearfix\">\r\n");
      out.write("\t\t\t<li class=\"item item1\">\r\n");
      out.write("\t\t\t\t<i></i><p>微型报告</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">根据客户需求定制细分市场微型分析报告，含有独家细分市场景气指数，便于客户把握市场现状，预测未来。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item2\"><i></i><p>行业研究报告</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">可以向客户提供涵盖16大行业、涉及咨询、投资、设备等招投标环节的专业研究报告，帮助企业了解掌握行业的现状和趋势,增强企业在行业经济大潮中的应变能力和竞争能力。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item3\"><i></i><p>专题信息</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">按热门专题提供咨询、项目动 态、招中标新等一揽子服务， 便于客户全面、准确掌握行业 动态，掘金商海。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item4\"><i></i><p>独家跟踪</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">向客户提供专属项目的全程跟踪服务，提供各时段的项目进展情况,让客户能够及时的跟进, 避免错过任意环节。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item5\"><i></i><p>项目汇总</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">根据客户需求汇总各行业、地区、业主单位等拟在建项目信息。便于客户及时了解、全面掌握所关注的项目情况，有针对性开展业务工作降低客户运营成本。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item6\"><i></i><p>个性化信息汇总</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">根据客户指定的需求，以列表形式按行业、按地区、按时间段等条件进行汇总，方便客户统计和分析。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item7\"><i></i><p>定制招中标项目汇总</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">根据客户个性化需求汇总招投标项目设备参数、中标金额、中标单位等信息，方便客户统计和分析。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item8\"><i></i><p>项目大全</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">以列表的形式定期汇总各行业当前的拟在建项目信息。帮助客户 宏观把握各地区、各行业当前市场情况及未来趋势，为企业安排当前业务工作及调整未来业务布局，提供数据支撑。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item9\"><i></i><p>期刊订阅</p>\r\n");
      out.write("\t\t\t\t<div class='hidden'>\r\n");
      out.write("\t\t\t\t\t<p class=\"text\">定期发布行业政策、新闻、行业分析等最新资讯。便于客户及时掌握行业资讯。</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"serviceWrapper\">\r\n");
      out.write("\t<div class=\"top\"><h2>服务<i></i></h2></div>\r\n");
      out.write("\t<div class=\"service\">\r\n");
      out.write("\t\t<ul class=\"sList clearfix\">\r\n");
      out.write("\t\t\t<li class=\"item item1\"><i></i><div class='con'><h3>标书范本服务</h3><p>提供规范、标准的标书范本。模块清晰、重点突出，满足招投标领域标书撰写专业规范的需求。</p></div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item2\"><i></i><div class='con'><h3>邮件订阅</h3><p>将对口信息或客户特别关注的信息以邮件形式发送到客\r\n");
      out.write("户指定邮箱，方便客户及时获取相关信息防止商机贻误</p></div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item3\"><i></i><div class='con'><h3>短信订阅</h3><p>将对口信息或客户特别关注的信息以邮件形式发送到客户指定邮箱，方便客户及时获取相关信息，防止商机贻误。</p></div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item4\"><i></i><div class='con'><h3>i追踪</h3><p>当您再次登入网站时无需搜索，只需点开i追踪，您所关注的信息将全部呈现在您面前。i追踪将是您投标过程中的理想帮手！</p></div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item item5\"><i></i><div class='con'><h3>招投标法规培训</h3><p>提供业内最专业的招中标法规培训，有助于客户理清招投标领域的法律问题，规避法律风险。</p></div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<ul class=\"control\">\r\n");
      out.write("\t\t<li class=\"item on\"></li>\r\n");
      out.write("\t\t<li class=\"item\"></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"tasteWrapper\">\r\n");
      out.write("\t<div class=\"taste\">\r\n");
      out.write("\t\t<h2>客户体验</h2>\r\n");
      out.write("\t\t<p class='subTitle'>定向行业客户邀约，户外体验活动 </p>\r\n");
      out.write("\t\t<p class='text' style=\"margin-top:20px;\">通过旅游、拓展和培训等活动调节紧张心情、舒解工作压力，</p>\r\n");
      out.write("\t\t<p class=\"text\">在放松的同时搭建客户间交流合作的平台。</p> \r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"contact\">\r\n");
      out.write("\t<h2>咨询方式</h2>\r\n");
      out.write("\t<ul class=\"cList\">\r\n");
      out.write("\t\t<li class=\"item\" id='phone'><i></i><a href='http://wpa.qq.com/msgrd?v=3&uin=2133606287&site=qq&menu=yes' target=\"_blank\">2133606287</a></li>\r\n");
      out.write("\t\t<li class=\"item\" id='email'><i></i><a href=\"Mailto:sales@chinabidding.cn\">sales@chinabidding.cn</a></li>\r\n");
      out.write("\t\t<li class=\"item\" id='four'><i></i>400-968-9685</li>\r\n");
      out.write("\t\t<li class=\"item\"><i></i>010-82743201</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<div class='mask'>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"mform\">\r\n");
      out.write("<div class=\"mformCon\">\r\n");
      out.write("\t<h2>请在下面留言，稍后我们会与您联系。</h2><i></i>\r\n");
      out.write("\t<div class=\"leftCon\">\r\n");
      out.write("\t\t<ul class='clearfix'>\r\n");
      out.write("\t\t\t<li class=\"item\">\r\n");
      out.write("\t\t\t\t<span>姓名</span><input type='text' name=\"name\" placeholder=\"请输入你的姓名\" />\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item\">\r\n");
      out.write("\t\t\t\t<span>电话</span><input type='text' name=\"name\" placeholder=\"请输入你的电话\"/>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item\">\r\n");
      out.write("\t\t\t\t<span>地址</span><input type='text' name=\"name\" placeholder=\"请输入你的地址\"/>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li class=\"item\">\r\n");
      out.write("\t\t\t\t<span>邮箱</span><input type='text' name=\"name\" placeholder=\"请输入你的邮箱\"/>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"rightCon\">\r\n");
      out.write("\t\t<textarea  placeholder=\"请在下面留言，稍后我们会与您联系.\"></textarea>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<span class=\"sendInfo\">发送</span>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<myScript>\r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/commons/js/topService.js?v=");
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
