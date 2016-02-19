<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>
	<title><sitemesh:write property='title' /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="采购与招标、关系网、排行榜、行业指数、行业报告 " />
    <meta name="description" content="数据对话,一触即发" />
	<link rel="icon" href="${resPath}/resources/commons/images/top_icon_03.png" mce_href="${resPath}/resources/commons/images/top_icon_03.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
	<sitemesh:write property='myCss'/>
	<%@include file="/common/base.jsp"%>
	<!--[if IE 6]>
	<script src="${resPath}/resources/commons/js/DD_belatedPNG.js" type="text/javascript"></script>
	<script type="text/javascript">DD_belatedPNG.fix('*');</script>
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/lib/ie6hack.css?v=${projectversion}">
	<![endif]-->
	<!--[if IE7]>
	<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/lib/ie6hack.css?v=${projectversion}">
	<![endif]-->
	<!--[if lt IE 9]>
	<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js"></script>
	<![endif]-->
</head>
<body>
<!--顶部导航 -->
<div class="header">
	<div class="user-nav clearfix">
		<ul class="user-info clearfix">
			<c:if test="${empty username}">
			<li><a href="${casPath}">登录</a></li>
			<li>|</li>
			<li><a href="${appPath}/register">注册</a></li>
		</c:if>
		<c:if test="${not empty username}">
			<li><a href="javascript:;">欢迎您，${username }</a></li>
			<li>|</li>
			<li><a href="${appPath}/personal/information">个人中心</a></li>
			<li>|</li>
			<li><a href="javaScript:logout();">退出</a></li>
		</c:if>
		</ul>
	</div>
</div>
<!-- 主导航-->
<div class='navWrapper'>
	<div class="main-nav clearfix">
		<h1 class="logo">
			关系网
			<a href="${appPath }/homepage"></a>
		</h1>
		<ul class="nav clearfix">
			<li><a href="${appPath }/homepage"  id="index" class='buttonHover'>首页</a></li>
			<li><a href="${appPath }/relation"  id="relation" class='buttonHover'>关系网</a></li>
			<li><a href="${appPath }/industry"  id="industry" class='buttonHover'>行业指数</a></li>
			<li><a href="${appPath }/ranking"  id="ranking" class='buttonHover'>排行榜</a></li>
			<li><a href="${appPath }/report" id="report" class='buttonHover'>行业报告</a></li>
		</ul>
		<c:if test="${notSearch==null}">
			<div class="search">
				<input type="text" class="searchBox" id="searchBox"  value="${keyword}" placeholder="请输入您要搜索的内容">
				<input type="button" class="searchBtn">
				<ul class="prompt">
				</ul>
				<i></i>
			</div>
		</c:if>
	</div>
</div>
<!-- 导航下划线 -->
<div class="hr"></div>
<sitemesh:write property='body'/>
<c:if test="${notFooter==null}">
<!-- 底部信息 -->
<div class="footer-bg">
	<div class="footer clearfix">
		<ul class="clearfix">
			<li><a href="${appPath }/about#about" target="_blank">关于我们</a></li>
			<li>|</li>
			<li><a href="${appPath }/about#nav" target="_blank">网站导航</a></li>
			<li>|</li>
			<li><a href="${appPath }/about#copyright" target="_blank">版权所有</a></li>
			<li>|</li>
			<li><a href="${appPath }/about#link" target="_blank">友情链接</a></li>
			<li>|</li>
			<li><a href="${appPath }/about#contact" target="_blank">联系我们</a></li>
			<li>|</li>
			<li><a href="${appPath }/about#zhaopin" target="_blank">招聘信息</a></li>
		</ul>
		<p>©2001-2015 中国采购与招标网  京ICP证070104号</p>
	</div>
</div>
</c:if>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.7.2/jquery.min.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/lib/message.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/ajaxCommon.js?v=${projectversion}"></script>
<sitemesh:write property='myScript'/>
</body>
</html> 