<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>搜索详情</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/detail.css?v=1.0.1-20151229">
	</myCss>
</head>
<body>
	<h3>找回密码</h3>
	<div class="findBox">
		<div class="sign">
			<span>邮箱找回</span>
			<span>短信找回</span>	
		</div>
		<div class="operationFrame">
			<div class="email"></div>
			<div class="phone"></div>
		</div>
	</div>





	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/findPwd.js?v=1.0.1-20151229"></script>
	</myScript>
</body>
</html>