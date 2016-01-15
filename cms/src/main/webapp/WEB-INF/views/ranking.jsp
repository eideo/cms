<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>排行榜</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/ranking.css?v=1.0.1-20151229">
	</myCss>

</head>
<body>

<!--地图部分-->
<div class="map_bg">
	<div class="mapBox">
		<div class="f2">
			<div class="chart clearfix">
				<div class="map" id="map">
				</div>
				<div class="key-words">
					<h4>
						<a class="a1" href="javascript:;">热门关键词</a>
					</h4>
					<div class="words" id="words">
						<a href="javascript:;" target="_blank">铁路</a>
						<a href="javascript:;" target="_blank">橡胶</a>
						<a href="javascript:;" target="_blank">接地</a>
						<a href="javascript:;" target="_blank">综合</a>
						<a href="javascript:;" target="_blank">钢筋</a>
						<a href="javascript:;" target="_blank">施工</a>
						<a href="javascript:;" target="_blank">钢材</a>
						<a href="javascript:;" target="_blank">工程</a>
						<a href="javascript:;" target="_blank">真空</a>
						<a href="javascript:;" target="_blank">断路器</a>
						<a href="javascript:;" target="_blank">系统</a>
						<a href="javascript:;" target="_blank">水泥</a>
						<a href="javascript:;" target="_blank">广州</a>
						<a href="javascript:;" target="_blank">铁路货车</a>
						<a href="javascript:;" target="_blank">招标</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- 中间内容 -->
<div class="content clearfix">
	<div class="ranking">
		<ul class="clearfix" id="c_btn">
			<li class="active" type="2">热门关系网</li>
			<li type="3">热门信息</li>
			<li type="4">热门单位</li>
			<li type="5" class="last">热门报告</li>
		</ul>
		<div class="option clearfix">
			<div class="timeType clearfix">
				<h5>时 间:</h5>
				<div class="time clearfix">
					<a class="active" href="javascript:;">不限</a>
					<a code="1" href="javascript:;">今天</a>
					<a code="2" href="javascript:;">最近一周</a>
					<a code="3" href="javascript:;">最近一月</a>
					<div class="diy" style="display:none">
						<input class="sang_Calender" value="自定义时间">
						<i></i>
					</div>		    
				</div>
			</div>
			<div class="tradeType clearfix">
				<h5>行 业:</h5>
				<div class="trade clearfix">
					<a class="active" href="javascript:;">不限</a>
					<a code="2101" href="javascript:;">冶金矿产原材料</a>
					<a code="2102" href="javascript:;">能源</a>
					<a code="2103" href="javascript:;">农林水利</a>
					<a code="2104" href="javascript:;">环保</a>
					<a code="2105" href="javascript:;">交通运输</a>
					<a code="2106" href="javascript:;">网络通讯计算机</a>
					<a code="2107" href="javascript:;">医疗卫生</a>
					<a code="2108" href="javascript:;">房地产建筑</a>
					<a code="2109" href="javascript:;">公共设施</a>
					<a code="2110" href="javascript:;" class="hidden disLeft">科技文教旅游</a>
					<a code="2111" href="javascript:;" class="hidden">轻工</a>
					<a code="2112" href="javascript:;" class="hidden">化工</a>
					<a code="2113" href="javascript:;" class="hidden">机械电子</a>
					<a code="2114" href="javascript:;" class="hidden">商务服务</a>
					<a code="2115" href="javascript:;" class="hidden">其他</a>
				</div>
				<div class="more">更多<i></i></div>	
			</div>
			<div class="areaType clearfix">
				<h5>地 区:</h5>
				<div class="area clearfix">
					<a class="active" href="javascript:;">不限</a>
					<a href="javascript:;" id="318601">北京</a>
					<a href="javascript:;" id="318602">上海</a>
					<a href="javascript:;" id="318603">天津</a>
					<a href="javascript:;" id="318604">重庆</a>
					<a href="javascript:;" id="318605">河北</a>
					<a href="javascript:;" id="318606">山西</a>
					<a href="javascript:;" id="318607">内蒙古</a>
					<a href="javascript:;" id="318608">辽宁</a>
					<a href="javascript:;" id="318609">吉林</a>
					<a href="javascript:;" id="3186010">黑龙江</a>
					<a href="javascript:;" id="3186011">江苏</a>
					<a href="javascript:;" id="3186012">浙江</a>
					<a href="javascript:;" id="3186013">安徽</a>
					<a href="javascript:;" id="3186014">福建</a>
					<a href="javascript:;" id="3186015">江西</a>
					<a href="javascript:;" id="3186016">山东</a>
					<a href="javascript:;" id="3186017">河南</a>
					<a href="javascript:;" id="3186018" class="hidden disLeft">湖北</a>
					<a href="javascript:;" id="3186019" class="hidden">湖南</a>
					<a href="javascript:;" id="3186020" class="hidden">广东</a>
					<a href="javascript:;" id="3186021" class="hidden">广西</a>
					<a href="javascript:;" id="3186022" class="hidden">海南</a>
					<a href="javascript:;" id="3186023" class="hidden">贵州</a>
					<a href="javascript:;" id="3186024" class="hidden">云南</a>
					<a href="javascript:;" id="3186025" class="hidden">西藏</a>
					<a href="javascript:;" id="3186026" class="hidden">陕西</a>
					<a href="javascript:;" id="3186027" class="hidden">四川</a>
					<a href="javascript:;" id="3186028" class="hidden">甘肃</a>
					<a href="javascript:;" id="3186029" class="hidden">青海</a>
					<a href="javascript:;" id="3186030" class="hidden">新疆</a>
					<a href="javascript:;" id="3186031" class="hidden">宁夏</a>
					<a href="javascript:;" id="3186032" class="hidden">香港</a>
					<a href="javascript:;" id="3186033" class="hidden">澳门</a>
					<a href="javascript:;" id="3186034" class="hidden">台湾</a>
					
				</div>
				<div class="more">更多<i></i></div>
			</div>
		</div>
		<div class="listBox">
			<div class="part part2">
				<h3 class="clearfix">
					<i class="rank"></i>
					<i class="keyword">项目/单位名称</i>
					<i class="index">搜索热度</i>
					<i class="link">相关链接</i>
				</h3>
				<ul class="rankinglist">
					<c:forEach var="ranking" items="${rankingDatas}" varStatus="status">
					<li class="clearfix">
						<i class="rankResult <c:if test="${(status.index+1)==1}">one</c:if><c:if test="${(status.index+1)==2}">two</c:if><c:if test="${(status.index+1)==3}">three</c:if>">${status.index+1}</i>
						<div class="keyResult cutTitle">${ranking.name}</div>
						<i <c:if test="${(status.index+1)<=3}">class="red"</c:if><c:if test="${(status.index+1)>3}">class="indexResult"</c:if>>${ranking.countNow}</i>
						<div class="linkResult">
							<a href="${appPath}/relation?name=${ranking.name}">关系网</a>
							<a href="${appPath}/search?keyword=${ranking.name}">信息</a>
						</div>	
					</li>
				</c:forEach>
				</ul>
			</div>
			<div class="part part3">
				<h3 class="clearfix">
					<i class="rank"></i>
					<i class="keyword">项目名称</i>
					<i class="index">搜索指数</i>
					<i class="link">相关链接</i>
				</h3>
				<ul class="rankinglist">
					
				</ul>
			</div>
			<div class="part part4">
				<h3 class="clearfix">
					<i class="rank"></i>
					<i class="keyword">单位名称</i>
					<i class="index">热度</i>
					<i class="link">相关链接</i>
					
				</h3>
				<ul class="rankinglist">
					
				</ul>	
			</div>
			<div class="part part5">
				<h3 class="clearfix">
					<i class="rank"></i>
					<i class="keyword">报告名称</i>
					<i class="index">热度</i>
					<i class="link">相关链接</i>
					
				</h3>
				<ul class="rankinglist">
					
				</ul>
			</div>
		</div>
	</div>
</div>

<div class="page_bg">
	<div class="page">
		<form id="pageForm">
			<div class="paging">
				<div class="tcdPageCode"></div>
			</div>
		</form>
	</div>
</div>
<a id="gotop">
	<i></i>
	<span>顶部</span>
</a>
<script type="text/html" id = "partTemp2">
				<li class="clearfix">
						<i class="rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-">{num}</i>
						<div class="keyResult cutTitle">{name}</div>
						<i class="-[{num}>3:indexResult;{num}<=3:red;]-">{countNow}</i>
						<div class="linkResult">
							<a href="${appPath}/search?keyword={name}">信息</a>
							<a href="${appPath }/report/{industry}">行业报告</a>
						</div>
					</li>
</script>
<script type="text/html" id = "partTemp4">
	<li class="clearfix">
						<i class="rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-">{num}</i>
						<div class="keyResult cutTitle">{name}</div>
						<i class="-[{num}>3:indexResult;{num}<=3:red;]-">{countNow}</i>
						<div class="linkResult">
							<a href="${appPath}/relation?name={name}&type=company">关系网</a>
							<a href="${appPath }/report/{industry}">行业报告</a>
						</div>
					</li>
</script>
<script type="text/html" id = "partTemp3">
					<li class="clearfix">
						<i class="rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-">{num}</i>
						<div class="keyResult cutTitle">{name}</div>
						<i class="-[{num}>3:indexResult;{num}<=3:red;]-">{countNow}</i>
						<div class="linkResult">
							<a href="${appPath}/relation?name={name}&type=project">关系网</a>
							<a href="${appPath}/search?keyword={name}">信息</a>
							<a href="${appPath }/report/{industry}">行业报告</a>
						</div>
					</li>
</script>
<script type="text/html" id = "partTemp5">
				<li class="clearfix">
						<i class="rankResult -[{num}==1:one;{num}==2:two;{num}==3:three;]-">{num}</i>
						<div class="keyResult cutTitle">{name}</div>
						<i class="-[{num}>3:indexResult;{num}<=3:red;]-">{countNow}</i>
						<div class="linkResult">
							<a href="${appPath}/relation?industryId={industry}&type=project">关系网</a>
							<a href="${appPath }/search?industryId={industry}">信息</a>
						</div>
					</li>
</script>

	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/paging/page.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20151229"></script>
		<script type="text/javascript">
		// 入口模块
		seajs.use("${resPath}/resources/commons/js/public/ranking")
		</script>
	</myScript>
</body>
</html>