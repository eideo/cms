<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title><sitemesh:write property='title' /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <meta name="keywords" content="采购与招标、关系网、排行榜、行业指数、行业报告 " />
    <meta name="description" content="数据对话,一触即发" />
	<link rel="icon" href="${resPath}/resources/commons/images/top_icon_03.png" mce_href="${resPath}/resources/commons/images/top_icon_03.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css">
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css">
	<sitemesh:write property='myCss' />
</head>
<body>
			<!-- 	顶部 -->
		<div class="header clearfix">
			<div class="logo">关系网</div>
			<h2>填写用户注册信息</h2>
			<ul class="nav">
				<li><a href="${appPath}/homepage">首页</a></li>
				<li>|</li>
				<li><a href="${appPath }/relation">关系网</a></li>
				<li>|</li>
				<li><a href="${appPath}/industry">行业指数</a></li>
				<li>|</li>
				<li><a href="${appPath }/ranking">排行榜</a></li>
				<li>|</li>
				<li><a href="${appPath }/report">行业报告</a></li>
				<li>|</li>
				<li><a href="${appPath }/topservice">高端服务</a></li>
			</ul>
		</div>
		
		
		
		
		<sitemesh:write property='body' />
		<!-- 底部信息 -->
		<div class="footer-bg">
			<div class="footer clearfix">
				<ul class="clearfix">
					<li><a href="${resPath }/about#about" target="_blank">关于我们</a></li>
					<li>|</li>
					<li><a href="${resPath }/about#nav" target="_blank">网站导航</a></li>
					<li>|</li>
					<li><a href="${resPath }/about#copyright" target="_blank">版权所有</a></li>
					<li>|</li>
					<li><a href="${resPath }/about#link" target="_blank">友情链接</a></li>
					<li>|</li>
					<li><a href="${resPath }/about#contact" target="_blank">联系我们</a></li>
					<li>|</li>
					<li><a href="${resPath }/about#zhaopin" target="_blank">招聘信息</a></li>
				</ul>
				<p>©2001-2015 中国采购与招标网 京ICP证070104号</p>
			</div>
		</div>

	<sitemesh:write property='myScript' />
</body>
</html> 