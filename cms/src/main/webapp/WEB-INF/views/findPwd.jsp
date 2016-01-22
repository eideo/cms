<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>找回密码</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/findPwd.css?v=${projectversion}">
	</myCss>
</head>
<body>
	<div class="content">
		<h3>找回密码</h3>
		<div class="findBox">
			<div class="sign">
				<span class="phoneBtn">短信找回</span>
				<span class="emailBtn">邮箱找回</span>
				<i></i>	
			</div>
			<div class="operationFrame">
				<div class="phone box">
					<p>请输入注册手机号码</p>
					<form action="${appPath}/resetPwd" name="" method="get">
						<div class="phoneBox">
							<input type="text" id="phone" name="phone" placeholder="请输入手机号码">
							<i class="error"></i>
						</div>
						<div class="codeBox phoneCode clearfix">
							<input type="text" id="phoneCode" name="phoneCode" placeholder="请输入验证码">
							<span class="codeBtn">获取验证码</span>
							<i class="error"></i>
						</div>
						<div class="submitBox">
							<input type="submit" value="下一步" class="submit" id="phoneSubmit">	
						</div>	
					</form>
				</div>
				<div class="email box">
					<p>请输入注册邮箱地址</p>
					<form action="http://www.baidu.com" name="" method="post">
						<div class="emailBox">
							<input type="text" id="email" name="email" placeholder="请输入邮箱地址" />
							<i class="error"></i>
						</div>
						<div class="codeBox emailCode clearfix">
							<input type="text" id="code" name="code" placeholder="请输入验证码" />
							<span>
								<img src="${appPath}/common/makeCertPic.jsp" id="codeImg" onclick="reloadcode()" style="cursor: pointer;" alt="看不清楚,换一张">
							</span>
							<i class="error"></i>
						</div>
						<div class="submitBox">
							<input type="submit" value="下一步" class="submit" id="emailSubmit" />	
						</div>	
					</form>
				</div>
			</div>
		</div>
	</div>





	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/findPwd.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>