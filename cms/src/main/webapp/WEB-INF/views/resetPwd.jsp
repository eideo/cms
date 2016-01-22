<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>重置密码</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/findPwd.css?v=${projectversion}">
	</myCss>
</head>
<body>
	<div class="content">
		<h3>重置密码</h3>
		<div class="findBox">
			<div class="operationFrame">
				<div class="box">
					<p>请输入新密码</p>
						<input type="hidden" name="uuid" value="${uuid}" id="uuid">
						<div class="passwordBox">
							<input type="password" id="password" name="password" placeholder="请输入新密码">
							<i class="error"></i>
						</div>
						<div class="rePasswordBox">
							<input type="password" id="repassword" name="repassword" placeholder="请输入确认密码">
							<i class="error"></i>
						</div>
						<div class="submitBox">
							<input type="submit" value="提交" class="submit" id="changeBtn">	
						</div>	
				</div>
			</div>
		</div>
	</div>





	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/findPwd.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>