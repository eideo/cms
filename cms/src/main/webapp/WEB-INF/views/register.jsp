<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<%@include file="/common/base.jsp"%>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/register.css?v=${projectversion}">
	</myCss>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/jquery-1.7.2.min.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/move.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/ajax.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/register.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/cookie.js?v=${projectversion}"></script>
	</myScript>
</head>
<body>


<!-- 主要内容	 -->
<div class="content-box">
	<div class="content">
		<div class="register-box">
			<form action="${appPath}/registerMember" name="reform" method="post" onSubmit="return ajaxSubmit();">
				<h3 class="clearfix" id="h3">
					<strong class="personal">个人用户<em></em></strong>
					<strong class="company">企业用户</strong>
				</h3>
				<div id="div1">
					<div class="user-box">
						<input type="text" class="username" placeholder="邮箱/手机号" id="username" name="username" style="width:340px;">
						<span class="nullmsg">请输入账号</span>
						<span class="errormsg">账号格式不正确</span>
						<span id="s-name">该用户名已注册，请重新输入</span>
						<span id="d-name">恭喜您，该用户名可以注册</span>
					</div>
					<div class="mcode-box clearfix" id="mobile">
						<input type="text" class="m-code" placeholder="输入验证码" id="m-code" name="m-code" >
						<a href="javascript:getPhoneCode();" id="mBtn">获取验证码</a>
						<a id="relaunch">重新获取<b>60</b>s</a>
						<span id="m-error">验证码输入不正确，请刷新验证码</span>
					</div>
					<div class="password-box">
						<input type="password" class="password" placeholder="设置登录密码（数字和字母组合，长度6-16字符）" id="password" name="password" style="width:340px;">
						<span id="p-error">密码格式不正确</span>
					</div>
					<div class="r-password-box">
						<input type="password" class="r-password" placeholder="确认登录密码" id="r-password" name="r-password">
						<span id="rp-error">两次输入密码不一致</span>
					</div>
					<div class="code-box clearfix" id="code">
						<input type="text" class="v-code" placeholder="输入验证码" id="v-code" name="v-code">
						<span id="c-error">验证码输入不正确，请刷新验证码</span>
						<img src="${appPath}/common/makeCertPic.jsp" id="codeImg" onclick="reloadcode()" style="cursor: pointer;" alt="看不清楚,换一张">
					</div>
				</div>
				<div id="div2">
					<div class="user-box">
						<input type="text" class="username" placeholder="请输入公司名称" id="company-name" name="companyname">
						<span id="u-error2">公司名格式不正确</span>
						<span id="s-name2">该公司名已注册，请重新输入</span>
						<span id="d-name2">恭喜您，该用户名可以注册</span>
						<span id="u-error2null">请输入公司名</span>
					</div>
					<div class="password-box">
						<input type="text" class="password" placeholder="请输入联系人电话" id="user-mobile" name="user-mobile" >
						<span id="mobile2">请输入正确的手机号格式！</span>
						<span id="mobile3">手机号已注册！</span>
					</div>
					<div class="r-password-box">
						<input type="password" class="r-password" placeholder="设置登录密码（以字母开头，长度6-16字符）" id="password2" name="password2">
						<span id="p-error2">密码格式不正确</span>
					</div>
					<div class="r-password-box">
						<input type="password" class="r-password" placeholder="请确认登录密码" id="r-password2">
						<span id="rp-error2">两次输入密码不一致</span>
					</div>
				</div>
				<div class="user-protocol clearfix">
					<input type="checkbox" checked="ture" id="rp" />
					<label for="rp">我已阅读并同意</label>
					<a href="javajscript:;">《用户使用协议》</a>
				</div>
				<input type="submit" value="立即注册" class="register" id="btn1" />
			</form>
			<div class="loginInfo">已有账号？<a href="${casPath}">登录</a></div>
		</div>
	</div>
</div>

</body>
</html>