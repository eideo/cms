<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>行业报告</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=1.0.1-20151229">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/report.css?v=1.0.1-20151229">
	</myCss>
</head>
<body>
	<!-- 轮播图 -->
	<div id="box">
		<ul>
			<c:forEach var="reportCarousel" items="${reportMainListCarousel}" varStatus="status">
		    	<li>
		    		<input id="reporturl_${reportCarousel.id}" type="hidden" value="${imgPath}/${reportCarousel.reportUrl}" />
		    		<a href="javascript:;"><img src="${resPath}/resources/commons/images/report_img${status.index + 1}.png"></a>
		    		<div class="shadow"></div>
		    		<div class="imgInfo">
		    			<h6 id="info_${reportCarousel.id}">${reportCarousel.reportTitle}</h6>
		    			<p class="cutParagraph">
		    				${reportCarousel.reportAbstract}
		    			</p>
		    			<a href="javascript:reportView(${reportCarousel.id});">点击阅读</a>
		    		</div>
		    	</li>
			</c:forEach>
	    </ul>
	    <ol>
	    	<li class="on"></li>
	    	<li></li>
	    	<li></li>
	    </ol>
		<a href="javascript:;" id="prev"></a>
		<a href="javascript:;" id="next"></a>
	</div>

	<!-- 分类导航 -->
	<div class="s_nav clearfix">
		<div class="h2" onclick="javascript:getByInduxtry(0);"><i class="h2i"></i><a>行业分类</a></div>
		<div class="term clearfix">
			<input id="induxtry_id" type="hidden" value="${induxtryId }" />
			<ul class="clearfix">
				<li class="li1" onclick="javascript:getByInduxtry(2101);" rid="2101"><i class="i1"></i><a>冶金矿产原材料</a></li>
				<li class="li2" onclick="javascript:getByInduxtry(2102);" rid="2102"><i class="i2"></i><a>能源</a></li>
				<li class="li3" onclick="javascript:getByInduxtry(2103);" rid="2103"><i class="i3"></i><a>农林水利</a></li>
				<li class="li4" onclick="javascript:getByInduxtry(2104);" rid="2104"><i class="i4"></i><a>环保</a></li>
				<li class="li5 right" onclick="javascript:getByInduxtry(2105);" rid="2105"><i class="i5"></i><a>交通运输</a></li>
				<li class="li6" onclick="javascript:getByInduxtry(2107);" rid="2107"><i class="i6"></i><a>医疗卫生</a></li>
				<li class="li7" onclick="javascript:getByInduxtry(2108);" rid="2108"><i class="i7"></i><a>房地产建筑</a></li>
				<li class="li8" onclick="javascript:getByInduxtry(2111);" rid="2111"><i class="i8"></i><a>轻工</a></li>
				<li class="li9" onclick="javascript:getByInduxtry(2112);" rid="2112"><i class="i9"></i><a>化工</a></li>
				<li class="li10 right" onclick="javascript:getByInduxtry(2113);" rid="2113"><i class="i10"></i><a>机械电子</a></li>
			</ul>
		</div>
	</div>

	<!-- 列表 -->
	<div class="list clearfix">
		<div class="reportList">
			<h4>行业报告列表<i></i></h4>
				<ul id="reportMainList">
					<c:choose>
						<c:when test="${!empty reportMainList}">
							<c:forEach var="reportMain" items="${reportMainList}">
								<li class="clearfix">
									<div  class="clearfix">
										<a href="" class="leftImg">
											<img src="${resPath}/resources/commons/images/${reportMain.imageIndex}">
										</a>
										<div class="description">
											<h5><a class="cutTitle" href="${appPath}/reportdetail/${reportMain.id}" id="info_${reportMain.id}" onclick="javascript:custBehavior(2, 11506, ${reportMain.id}, 1);" title="${reportMain.reportTitle}" >${reportMain.reportTitle}</a></h5>
											<p>
												<a class="trade">${reportMain.induxtryName}</a>
												<i class="line"></i>
												<span class="time">${reportMain.updateDate}</span>
											</p>
											<p class="font cutParagraph">${reportMain.reportAbstract}</p>
										</div>
									</div>
									<div class="navBox clearfix">
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
												<a onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a onclick="javascript:custBehaviorShare(5, 11506, '${reportMain.id}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
											</div>
											<em></em>
										</div>
									</div>
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							没有符合条件的记录
						</c:otherwise>
					</c:choose>
				</ul>
				<!-- 分页 -->
				<div class="page_bg">
					<div class="page">
						<form id="pageForm">
							<div class="paging">
								<div class="tcdPageCode"></div>
							</div>
						</form>
					</div>
				</div>
		</div>
		<div class="hotList">
			<h4>热门报告<i></i></h4>
			<ul class="hot">
				<c:forEach var="reportMainTop" items="${reportMainListTop10}">
					<li class="cutTitle"><a href="${appPath}/reportdetail/${reportMainTop.id}" title="${reportMainTop.reportTitle}" onclick="javascript:custBehavior(2, 11506, ${reportMainTop.id}, 1);" >${reportMainTop.reportTitle}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<script type="text/html" id="listTemplate">
		<li class="clearfix">
			<div  class="clearfix">
				<a href="" class="leftImg">
					<img src="${resPath}/resources/commons/images/{reportMain.imageIndex}">
				</a>
				<div class="description">
					<h5><a class="cutTitle" href="${appPath}/reportdetail/{reportMain.id}" id="info_{reportMain.id}" onclick="javascript:custBehavior(2, 11506, {reportMain.id}, 1);" >{reportMain.reportTitle}</a></h5>
					<p>
						<a class="trade">{reportMain.induxtryName}</a>
						<i class="line"></i>
						<span class="time">{reportMain.updateDate}</span>
					</p>
					<p class="font cutParagraph">{reportMain.reportAbstract}</p>
				</div>
			</div>
			<div class="navBox clearfix">
				<div class="ap" actiontype="3" infotype="11506" infoid="{reportMain.id}" >
					<i class="attention"></i>
					<span>关注</span>
					<span class="re">已关注</span>
				</div>
				<div class="cp" actiontype="4" infotype="11506" infoid="{reportMain.id}" >
					<i class="collection"></i>
					<span>收藏</span>
					<span class="re">已收藏</span>
				</div>
				<div class="sp">
					<a href="javascript:;" class="share">分享</a>
					<div class="shareBtn bdsharebuttonbox">
						<a onclick="javascript:custBehaviorShare(5, 11506, '{reportMain.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
						<a onclick="javascript:custBehaviorShare(5, 11506, '{reportMain.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
						<a onclick="javascript:custBehaviorShare(5, 11506, '{reportMain.id}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					</div>
					<em></em>
				</div>
			</div>
		</li>
	</script>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/popwin.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/paging/page.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/report.js?v=1.0.1-20151229"></script>
		<script type="text/javascript">
			var resPath = "${resPath}";
			$(".tcdPageCode").createPage({
		        pageCount : ${totalPage},
		        current : ${currentPage},
		        backFn : function(p) {
		        	ajaxReport(p);
		        }
		    });
		</script>
	</myScript>
	<script>
	window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
	</script>
	<%@include file="dialogLogin/loginDialog.jsp"%>
</body>
</html>