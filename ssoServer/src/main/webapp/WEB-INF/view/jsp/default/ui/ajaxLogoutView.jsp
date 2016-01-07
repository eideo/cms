
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String callBack = request.getParameter("jsoncallback");
	out.write(callBack+"({result:true})");
%>