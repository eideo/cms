<%@page contentType="image/jpeg" %>
　　<jsp:useBean id="image" scope="page" class="com.sbiao360.cms.zutil.MakeCertPic" />
　　<%	
	String str=image.getCertPic(102,40,response.getOutputStream());session.setAttribute("certCode", str);out.clear();out = pageContext.pushBody();%>