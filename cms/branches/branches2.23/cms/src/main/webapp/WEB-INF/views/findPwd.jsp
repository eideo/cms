<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>找回密码</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/findPwd.css?v=${projectversion}">
	</myCss>
</head>
<body>
	<div class="content">
		
		<div class="tabWrapper">
			<div class="tabCon">
				<div class="step step1 selected"><i class="active"></i>验证身份</div>
				<div class="step step2"><i></i>重置密码</div>
				<div class="step step3"><i></i>重置成功</div>
			</div>
			<span id="login">已有账号？<a href="${casPath}">登录</a></span>
		</div>
		<div class="flagCon" style="display: block;">
			<p id="phoneTab"><input type="checkbox" id="phoneCheck" checked="true"/>通过注册或者绑定的手机号找回密码</p>
			<p id="emailTab"><input type="checkbox" id="emailCheck" />通过注册或者绑定的邮箱找回密码</p>

			<div class="emailBox clearfix" style='display:none;'>
				<input type='text' id="email"/>
				<i class="flagState"></i>
				<div class="sendBtn">发送邮件</div>
				<i class='error'></i>
			</div>

			<div class="phoneBox clearfix">
				<input type='text' name='phone' id="phone"/>
				<i class="flagState"></i>
				<div class="sendBtn">发送验证码</div>
				<i class='error'></i>
			</div>
			<div class="validBox clearfix" style='display:none;'>
				<input type='text' name='phoneCode' id="phoneCode"/>
				<i class="flagState"></i>
				<div class="validBtn">马上验证</div>
				<i class='error'></i>
			</div>

			<p class='reSendCode' style='display:none;'>验证码已经发送，请查收！<span id='reSend'>30秒后可重发</span></p>
		</div>
		<div class='failCon' style="display: none;">
			 <div class="failBox">
			 	
			 	<i></i>
			 	<p>身份验证失败！</p>
			 </div>
			 <p class='other'>使用&nbsp;&nbsp;&nbsp;&nbsp;<span id='reload'>其他验证方式</span></p>
		</div>
		<div class="successCon" style="display: none;">
			 <div class="successBox">
			 	
			 	<i></i>
			 	<p>邮件已经发送，请去邮箱查看</p>
			 </div>
		</div>
	</div>

	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/public/findPwd.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>