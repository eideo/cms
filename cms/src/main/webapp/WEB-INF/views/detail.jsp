<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@include file="/common/base.jsp"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>搜索详情</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/detail.css?v=1.0.1-20151229">
	</myCss>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
	</myScript>
</head>
<body>

<!-- 中间内容 -->
<div class="article">
	<h2 class="title" id="info_${publishInfo.id}">${publishInfo.title}</h2>
	<div class="info clearfix">
		<span class="time">发布时间：<i><fmt:formatDate value="${publishInfo.publishDate}" pattern="yyyy-MM-dd"/></i></span>
		<div class="navBox clearfix">
			<div class="ap" actiontype="3" infotype="${publishInfo.infoType}" infoid="${publishInfo.id}" >
				<i class="attention"></i>
				<a href="javascript:;">关注</a>
				<span class="re">已关注</span>
			</div>
			<div class="cp" actiontype="4" infotype="${publishInfo.infoType}" infoid="${publishInfo.id}" >
				<i class="collection"></i>
				<a href="javascript:;">收藏</a>
				<span class="re">已收藏</span>
			</div>
			<div class="sp">
				<a href="javascript:;" class="share">分享</a>
				<div class="shareBtn bdsharebuttonbox">
					<a href="javascript:;" onclick="javascript:custBehaviorShare(5, ${publishInfo.infoType}, '${publishInfo.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone"  title="分享到QQ空间"></a>
					<a href="javascript:;" onclick="javascript:custBehaviorShare(5, ${publishInfo.infoType}, '${publishInfo.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina"  title="分享到新浪微博"></a>
					<a href="javascript:;" onclick="javascript:custBehaviorShare(5, ${publishInfo.infoType}, '${publishInfo.id}', '微信');" class="bds_weixin" data-cmd="weixin"  title="分享到微信"></a>
				</div>
				<em></em>
			</div>			
		</div>
	</div>
	<div class="paragraph clearfix">
		<div class="detail">
			${publishInfo.description}
		</div>
		<a class="img" href="<c:if test="${infoType=='xmxx'}">${appPath }/relation?name=${publishInfo.projectName}</c:if><c:if test="${infoType!='xmxx'}">javaScript:void(0);</c:if>"><img src="${resPath}/resources/commons/images/de_img.png"></a>
	</div>
</div>

<!-- 相关推荐 -->
<div class="tuijian">
	<ul class="btn clearfix">
		<li style="color:#0a8dff;">相关招标信息<i style="display:block;"></i></li>
		<li>相关采购信息<i></i></li>
		<li>相关中标信息<i></i></li>
	</ul>
	<ol class="de-list" style="display:block;">
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">江苏城市职业学院华为服务器的采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】遥控器询价项目采购公告</a>
		</li>
	</ol>
	<ol class="de-list">
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】1</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
	</ol>
	<ol class="de-list">
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
		<li>
			<i></i>
			<a href="javascript:;">【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告【沧州新建华】10月28日单梁吊机遥控器询价项目采购公告</a>
		</li>
	</ol>

</div>
<script>
window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"欢迎进入中国采购与招标网新平台，感兴趣可以点击下面链接体验……","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};
with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>
<%@include file="dialogLogin/loginDialog.jsp"%>
<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1"></script>
<script type="text/javascript">
	seajs.config({
		base: path+'/resources/commons/js/lib/',
		alias: {
			'jquery':'jquery/jquery-1.7.2.js',
			'common':'common.js',
		}
	})

	// 入口模块
	seajs.use("${resPath}/resources/commons/js/detail");
</script>
</body>
</html>