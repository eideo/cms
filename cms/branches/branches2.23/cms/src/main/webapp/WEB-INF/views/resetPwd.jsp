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
		
		<div class="tabWrapper">
			<div class="tabCon">
				<div class="step step1 dVaild"><i class="vaild"></i>验证身份</div>
				<div class="step step2 selected"><i class='active'></i>重置密码</div>
				<div class="step step3"><i></i>重置成功</div>
			</div>
			<span id="login">已有账号？<a href="${casPath}">登录</a></span>
		</div>

		<div class="resetCon" style="display: block;">
			<p class="resetTitle">请重新设置你的账号密码</p>
			<input type="hidden" name="uuid" value="${uuid}" id="uuid">
			<div class="pswBox clearfix">
					<input type='text' id='psw' placeholder="请输入密码" />
					<i class='error'>密码输入不正确</i>
					<i class='flagState'></i>
				</div>
				<div class='rePswBox clearfix'>
					<input type="text" id='rePsw' placeholder="请再次输入密码"/>
					<i class='error'>密码输入不正确</i>
					<i class='flagState'></i>
				</div>
				<div class="submitBox">
					<input type="submit" value="提交" class="submit" id="changeBtn">	
			</div>
		</div>
		<div class="stateCon" style="display: none;">
			<div class="stateBox">
				 	
				<i></i>
				<p>修改密码成功！</p>
			</div>
		</div>
	</div>


<!--<div class="content">
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
</div> -->

	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/public/findPwd.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>