<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="/common/base.jsp"%>
<html>
<head>
	<title>首页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="keywords" content="采购与招标、关系网、排行榜、行业指数、行业报告 " />
    <meta name="description" content="数据对话,一触即发" />
	<link rel="icon" href="${resPath}/resources/commons/images/top_icon_03.png" mce_href="${resPath}/resources/commons/images/top_icon_03.png" type="image/x-icon">
	<sitemesh:write property='myCss'/>
	<sitemesh:write property='head'/>
</head>
<body>
	<sitemesh:write property='body'/>
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
	<sitemesh:write property='myScript'/>
</body>
</html> 