<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>用户登录</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <meta name="keywords" content="采购与招标、关系网、排行榜、行业指数、行业报告 " />
   <meta name="description" content="数据对话,一触即发" />
   <%@include file="/common/base.jsp"%>
	<link rel="icon" href="${resPath}/resources/commons/images/top_icon_03.png" mce_href="${resPath}/resources/commons/images/top_icon_03.png" type="image/x-icon">
  <link rel="stylesheet" href="${casPath}/css/basic.css" />
  <link rel="stylesheet" href="${casPath}/css/login.css" />
  
</head>
<body>
 <!-- 	顶部 -->
<div class="header clearfix">
	<div class="logo">关系网</div>
	<h2>欢迎登录</h2>
	<ul class="nav clearfix">
		<li><a href="${appPath}/homepage">首页</a></li>
		<li>|</li>
		<li><a href="${appPath }/relation">关系网</a></li>
		<li>|</li>
		<li><a href="${appPath}/industry">行业指数</a></li>
		<li>|</li>
		<li><a href="${appPath }/ranking">排行榜</a></li>
		<li>|</li>
		<li><a href="${appPath }/report">行业报告</a></li>
	</ul>
</div>



   <form:form method="post" id="fm1" commandName="${commandName}" onSubmit="return beforeSubmit();" htmlEscape="true">
       <div class="content-box">
			<div class="content clearfix">
				<div class="login-box">
						<h3 class="clearfix"><strong>登录</strong></h3>
						<div class="user-box">
							<div class="icon"></div>
							<form:input cssClass="required username" onblur="GetPwdAndChk()" placeholder="邮箱/手机号" cssErrorClass="error" id="username" 
							tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
						</div>
						<div class="password-box">
							<div class="icon"></div>
							<form:password cssClass="required password" placeholder="密码" cssErrorClass="error" id="password" tabindex="2" path="password"
							  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
						</div>
						<div class="code-box clearfix">
							<div class="icon"></div>
							<input type="text" id="certPic" class="v-code" placeholder="验证码">
							<span>验证码错误!</span>
							<img src="${casPath}/common/makeCertPic.jsp" id="codeImg" onclick="reloadcode()" style="cursor: pointer;" alt="看不清楚,换一张">
						</div>
						<div class="r-password clearfix">
							<input type="checkbox" checked="ture" id="rp" />
							<label for="rp">记住密码</label>
							<a href="javajscript:;" class="f-password">忘记密码？</a>|
							<a href="${resPath}/register" class="register">免费注册</a>
						</div>
						<input type="submit" value="登录" class="login"  />
				</div>
			</div>
		</div>
		<section class="row btn-row">
           <input type="hidden" name="lt" value="${loginTicket}" />
           <input type="hidden" name="execution" value="${flowExecutionKey}" />
           <input type="hidden" name="_eventId" value="submit" />
       </section>
   </form:form>

<%--

    Licensed to Apereo under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Apereo licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 底部信息 -->
<div class="footer-bg">
	<div class="footer clearfix">
		<ul class="clearfix">
			<li><a href="${resPath }/htmlTemp/nav.html#about" target="_blank">关于我们</a></li>
			<li>|</li>
			<li><a href="${resPath }/htmlTemp/nav.html#nav" target="_blank">网站导航</a></li>
			<li>|</li>
			<li><a href="${resPath }/htmlTemp/nav.html#copyright" target="_blank">版权所有</a></li>
			<li>|</li>
			<li><a href="${resPath }/htmlTemp/nav.html#link" target="_blank">友情链接</a></li>
			<li>|</li>
			<li><a href="${resPath }/htmlTemp/nav.html#contact" target="_blank">联系我们</a></li>
			<li>|</li>
			<li><a href="${resPath }/htmlTemp/nav.html#zhaopin" target="_blank">招聘信息</a></li>
		</ul>
		<p>©2001-2015 中国采购与招标网 京ICP证070104号</p>
	</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/headjs/1.0.3/head.min.js"></script>
<script type="text/javascript" src = "${casPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src = "${casPath}/js/login.js"></script>
<script type="text/javascript" src = "${casPath}/js/cookie.js"></script>
</body>
</html>


