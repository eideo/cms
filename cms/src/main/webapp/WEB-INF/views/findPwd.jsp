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

		<div class="top">
			<div class="h3con"><h3>找回密码</h3></div>
			<span>已有账号？<a href="${casPath}">登录</a></span>
		</div>
		<div class="findBox">
			<div class="flagCon">
				<p class='flagTitle'>请输入注册使用的邮箱地址或手机号码</p>
				<div class="phone box">
						<div class="phoneBox">
							<input type="text" id="phone" placeholder="邮箱/手机号">
							<i class="info"></i>
						</div>
						<div class="codeBox phoneCode clearfix" id="c1" style="display:block">
							<i class="info"></i>
							<input type="text" id="phoneCode" placeholder="请输入验证码">
							<span class="codeBtn">获取验证码</span>
						</div>

						<div class="codeBox emailCode clearfix" id="c2" style="display:none">
							<i class="info"></i>
							<input type="text" id="code" name="code" placeholder="请输入验证码" />
							<span>
								<img src="${appPath}/common/makeCertPic.jsp" id="codeImg" style="cursor: pointer;" alt="看不清楚,换一张">
							</span>	
						</div>
						<div class="submitBox">
							<input type="button" value="下一步" class="submit" id="phoneSubmit">	
						</div>	
				</div>
				<div class="email box">
					<p>请输入注册邮箱地址</p>
					<form action="http://www.baidu.com" name="" method="post">
						<div class="emailBox">
							<input type="text" id="email" name="email" placeholder="请输入邮箱地址" />
							<i class="info"></i>
						</div>
						<div class="codeBox emailCode clearfix">
							<input type="text" id="code" name="code" placeholder="请输入验证码" />
							<span>
								<img src="${appPath}/common/makeCertPic.jsp" id="codeImg" onclick="reloadcode()" style="cursor: pointer;" alt="看不清楚,换一张">
							</span>
							<i class="info"></i>
						</div>
						<div class="submitBox">
							<input type="button" value="下一步" class="submit" id="emailSubmit" />	
						</div>	
					</form>
				</div>
			</div>
		</div>
		<div class="resetBox" style="display: none">
			<div class="flagCon">
				<p class="flagTitle">请重新设置您的账号密码</p>
				<div class="box">
						<input type="hidden" name="uuid" value="${uuid}" id="uuid">
						<div class="passwordBox">
							<input type="password" id="password" name="password" placeholder="6-20位新密码，以英文字母开头">
							<i class="info"></i>
						</div>
						<div class="rePasswordBox">
							<input type="password" id="repassword" name="repassword" placeholder="请再次确认密码">
							<i class="info"></i>
						</div>
						<div class="submitBox">
							<input type="submit" value="提交" class="submit" id="changeBtn">	
						</div>	
				</div>
			</div>
		</div>
		<div class="emailCon" style="display:none">
				<div class="flagCon">
				<p class="flagTitle">为了保护账户安全，需要验证邮箱有效性</p>
				<div class="box">
					<p class="desc">点击发送邮件按钮，将会发送一封验证码的邮件至邮箱</p>
					<p class="emailName">cms@chinabidding.com.cn</p>
					<div class="submitBox">
						<input type="submit" value="发送邮件" class="submit" id="sendEmail">	
					</div>	
				</div>
			</div>
		</div>
	</div>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/public/findPwd.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>