<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>找回密码</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/findPwd.css?v=1.0.1-20151229">
	</myCss>
</head>
<body>
	<div class="content">
		<h3>找回密码</h3>
		<div class="findBox">
			<div class="sign">
				<span class="emailBtn">邮箱找回</span>
				<span class="phoneBtn">短信找回</span>
				<i></i>	
			</div>
			<div class="operationFrame">
				<div class="email box">
					<p>请输入注册邮箱地址</p>
					<form action="" name="" method="post">
						<div class="emailBox">
							<input type="text" id="email" name="email" placeholder="请输入邮箱地址" />
							<i class="error"></i>
						</div>
						<div class="codeBox clearfix">
							<input type="text" id="code" name="code" placeholder="请输入验证码" />
							<span></span>
						</div>
						<div class="submitBox">
							<input type="submit" value="下一步" class="submit" />	
						</div>	
					</form>
				</div>
				<div class="phone box">
					<p>请输入注册手机号码</p>
					<form action="${appPath}/personal/resetPwd" name="" method="post">
						<div class="phoneBox">
							<input type="text" id="phone" name="phone" placeholder="请输入手机号码">
							<i class="error"></i>
						</div>
						<div class="codeBox  clearfix">
							<input type="text" id="phoneCode" name="phoneCode" placeholder="请输入验证码">
							<span class="codeBtn">获取验证码</span>
						</div>
						<div class="submitBox">
							<input type="submit" value="下一步" class="submit">	
						</div>	
					</form>
				</div>
			</div>
		</div>
	</div>





	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/findPwd.js?v=1.0.1-20151229"></script>
	</myScript>
</body>
</html>