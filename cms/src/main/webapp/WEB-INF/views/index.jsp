<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<head>
<title>首页</title>  
<myCss>
<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/index.css?v=${projectversion}">
</myCss>
	<!--[if IE 6]>
	<script src="${resPath}/resources/commons/js/DD_belatedPNG.js" type="text/javascript"></script>
	<script type="text/javascript">DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<!--[if lt IE 9]>
	<script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js"></script>
	<![endif]-->
</head>
<body>

<div class="imgBox">
	<ul class="imgArr clearfix">
		<li style="display:block;">
			<a href="${resPath }/relation" target="_blank" class="imgRelation img"></a>
			<div class="imgInfo">
				<h3><a href="${appPath}/relation" target="_blank">关系网</a></h3>
				<h4><a href="${appPath}/relation" target="_blank">BIDING RELATIONSHIP</a></h4>
				<p><a href="${appPath}/relation" target="_blank">专招投标行业的朋友圈，挖掘潜在合作可能</a></p>
			</div>
		</li>
		<li>
			<a href="${resPath }/industry" target="_blank" class="imgIndustry img"></a>
			<div class="imgInfo">
				<h3><a href="${appPath}/industry" target="_blank">行业指数</a></h3>
				<h4><a href="${appPath}/industry" target="_blank">INDUSTRY INDEX</a></h4>
				<p><a href="${appPath}/industry" target="_blank">多维度，统观行业发展趋势和变化规律</a></p>
			</div>
		</li>
		<li>
			<a href="${appPath }/ranking" target="_blank" class="imgRanking img"></a>
			<div class="imgInfo">
				<h3><a href="${appPath}/ranking" target="_blank">排行榜</a></h3>
				<h4><a href="${appPath}/ranking" target="_blank">INDUSTRY DATE LIST</a></h4>
				<p><a href="${appPath}/ranking" target="_blank">实时反映工程项目关注度，热点单位跟踪，全面展示项目进度</a></p>
			</div>
		</li>
		<li>
			<a href="${appPath }/report" target="_blank" class="imgReport img"></a>
			<div class="imgInfo">
			    <h3><a href="${appPath}/report" target="_blank">行业报告</a></h3>
				<h4><a href="${appPath}/report" target="_blank">INDUSTRY REPORT</a></h4>
				<p><a href="${appPath}/report" target="_blank">专业权威的行业分析，十多年项目数据，为企业战略规划和市场定位提供咨询服务</a></p>
			</div>
		</li>
	</ul>
	<ol class="clearfix">
		<li class="on"></li>
		<li></li>
		<li></li>
		<li></li>
	</ol>
</div>

<div class="shadow_bg">
	<div class="header_bg clearfix">
		<a href="${appPath }/homepage" class='indexlogo'>
		    <img src='${resPath}/resources/commons/images/logoIndex.png' />
		</a>
		<ul class="nav clearfix">
			<li><a href="${appPath }/homepage" class='buttonHover' id="index" >首页</a></li>
			<li><a href="${appPath }/relation" class='buttonHover' >关系网</a></li>
			<li><a href="${appPath }/industry" class='buttonHover' >行业指数</a></li>
			<li><a href="${appPath }/ranking" class='buttonHover' >排行榜</a></li>
			<li><a href="${appPath }/report" class='buttonHover' >行业报告</a></li>
			<li><a href="${appPath }/topservice" class='buttonHover' >高端服务</a></li>
		</ul>
		<c:if test="${empty username}">
		<div class="option">
			<a href="${casPath}">登录</a>
			<a href="${appPath}/register" class="active">注册</a>
		</div>
		</c:if>
		<ul class="user-info clearfix">
			<c:if test="${not empty username}">
			<li class="username">
				<a href="javascript:;" target="_blank">欢迎您,${username }</a>
			</li>
			<li>|</li>
			<li><a href="${appPath}/personal/information" target="_blank">个人中心</a></li>
			<li>|</li>
			<li><a href="javaScript:logout();">退出</a></li>
			</c:if>
		</ul>
	</div>
	<div class="shadow_top"></div>
</div>

<!-- 搜索框 111-->
<div class="search-box">
	<div class="search clearfix">
		<form action="${appPath}/search" onSubmit="return checkForm();">
			<input name="keyword" type="text" placeholder="请输入您要搜索的内容" id="seachInput">
			<button type="submit"></button>
			<ul class="prompt">
				<li>提示1</li>
				<li>提示2</li>
				<li>提示3</li>
				<li>提示4</li>
				<li>提示5</li>
			</ul>
		</form>
	</div>
	<p class="search-words clearfix">
		<span class="hotword">热搜词：</span>
		<c:forEach var="hotSearch" items="${hotKeyWords}">
			<a href="${appPath}/search?keyword=${hotSearch.keywords}">${hotSearch.keywords}</a>
		</c:forEach>
	</p>
</div>

<myScript>
<script src="${resPath}/resources/commons/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=${projectversion}"></script>
<script src="${resPath}/resources/commons/js/index.js?v=${projectversion}"></script>
</myScript>
</body>
</html>