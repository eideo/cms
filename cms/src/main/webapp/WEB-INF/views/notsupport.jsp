<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>你的浏览器不被支持！</title>
    <mycss>
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/notsupport.css?v=${projectversion}">
    </mycss>
</head>
<body>

<map name="Map">
	<area shape="rect" coords="289,363,456,410" href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie" target="_blank">
	<area shape="rect" coords="468,362,572,411" href="http://www.firefox.com.cn/download/" target="_blank" alt="火狐">
	<area shape="rect" coords="586,361,702,410" href="https://www.google.com/intl/zh-CN/chrome/browser/" target="_blank" alt="谷歌浏览器">
	<area shape="rect" coords="714,360,811,410" href="http://www.apple.com/cn/safari/" target="_blank">
</map>
<myScript>
 <script type="text/javascript" src="${resPath}/resources/commons/js/topService.js?v=${projectversion}"></script>
</myScript>
</body>
</html>