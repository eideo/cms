<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>行业报告详情页</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/reportPage.css?v=${projectversion}">
	</myCss>
</head>
<body>
	<div class="bg">
	
	<!-- 详情 -->
	<div class="list clearfix">
		<div class="reportList">
			<div class="reportInfo clearfix">
				<a href="javascript:;" class="reportImg">
					<img src="${resPath}/resources/commons/images/report_cover.png">
				</a>
				<div class="reportDe clearfix">
					<h5 class="title cutTitle" title="${reportMain.reportTitle}" id="info_${reportMain.id}">${reportMain.reportTitle}</h5>
					<div class="bookInfo clearfix">
						<div class="price clearfix"><i>报告单价</i><span>￥${reportMain.reportTprice}</span></div>
						<div class="industry clearfix"><i>所属行业：</i><span>${reportMain.induxtryName}</span></div>
						<div class="rePage clearfix"><i>报告页数：</i><span class="cha">${reportMain.reportPages}</span></div>
						<div class="words clearfix"><i>报告字数：</i><span class="cha">${reportMain.reportWords}</span></div>	
					</div>
					<div class="trading clearfix">
						<a href="javascript:;" class="buy" reporturl="${imgPath}/${reportMain.reportUrl}" reportid="info_${reportMain.id}">支付查看</a>
						<div class="attentions">已有<span class="cha">${reportMain.reportAttentions}</span>人关注</div>
					</div>
					<div class="operation navBox clearfix"  id="report_detail">
						<div class="ap" actiontype="3" infotype="11506" infoid="${reportMain.id}" >
							<i class="attention"></i>
							<span>关注</span>
							<span class="re">已关注</span>
						</div>
						<div class="cp" actiontype="4" infotype="11506" infoid="${reportMain.id}" >
							<i class="collection"></i>
							<span>收藏</span>
							<span class="re">已收藏</span>
						</div>
						<div class="sp">
							<a href="javascript:;" class="share">分享</a>
							<div class="shareBtn bdsharebuttonbox">
								<a href="#" onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
								<a href="#" onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
								<a href="#" onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
							</div>
							<em></em>
						</div>
					</div>
				</div>
			</div>
			<div class="catalog">
				<h4 >报告目录<i></i></h4>
				<c:choose>
					<c:when test="${!empty reportMain.reportDirectoryList}">
						<h5>目录</h5>
						<c:forEach var="reportDirectoryOne" items="${reportMain.reportDirectoryList}">
							<div class="reCatalog">
							    <div class="li">
							    	<i></i>
							    	<a href="javascript:;" >${reportDirectoryOne.dirConext}</a>
							    </div>
								<div class="hidden">
									<c:forEach var="reportDirectoryTwo" items="${reportDirectoryOne.reportDirectoryList}">
										<p><a href="javascript:;" >${reportDirectoryTwo.dirConext}</a></p>
									</c:forEach>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="hotList">
			<h4>热门报告<i></i></h4>
			<ul class="hot">
				<c:forEach var="reportMainTop" items="${reportMainListTop10}">
					<li class="cutTitle"><a href="${resPath}/reportdetail/${reportMainTop.id}" title="${reportMainTop.reportTitle}" >${reportMainTop.reportTitle}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div id="gotop">
		<i></i>
		<span>顶部</span>
	</div>
	<script>
	window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"欢迎进入中国采购与招标网新平台，感兴趣可以点击下面链接体验……","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
	</script>
	<!-- 	2015-12-01 by liyang -->
	<!-- 下面是登录框 -->
	<%@include file="dialogLogin/loginDialog.jsp"%>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/jquery-1.7.2.min.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/reportPage.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/popwin.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=${projectversion}"></script>
		<script type="text/javascript">
			var resPath = "${resPath}";
		</script>
	</myScript>
</body>
</html>