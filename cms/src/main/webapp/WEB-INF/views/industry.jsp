
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>行业指数</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=1.0.1-20151229">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/industry.css?v=1.0.1-20151229">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/lib/calendar.css?v=1.0.1-20151229">
	</myCss>
</head>
<body>

<div class='profile'>
	<div class='profileCon clearfix'>
		<h2 class='title'>
		</h2>
		<div class='left'>
			<div class='top'>
				<h3>按一级行业分类</h3>
				<!--<div class='time' id='endTime'>
					<div class='innerTime'>
						<input type="text" id="dateRight"  value ='2015.11'/>
					</div>
					<i class='daShow'>
					</i>
				</div>
				<div class='zhi'>至</div>
				<div class='time' id='startTime'>
					<div class='innerTime'>
						<input type="text" id="dateLeft"  value ='2014.01'/>
					</div>
					<i class='daShow'>
					</i>
				</div> -->
			</div>
			<div class='chart' id='chart1'>
				<div class='tip'>
					<div class='tipCon'>8888
						<i></i>
					</div>
				</div>
			</div>
		</div>
		<div class='right'>
			<div class='distr'>
				<h3 class='mt25 ml30'><span id='timeShow' style='font-weight:normal;color:#ff8519'>201312-201511</span> 信息数量分布</h3>
				<div class='timeRange'>
					<div class='con' id='timeRange'>	
						<span class='handle' id='timeHandle'>
						</span>
					</div>
				</div>
				<div id='chart2'></div>
			</div>
			<div class='prop'>
				<h3 class='mt25 ml30'>信息类型占比</h3>
				<div id='chart3'></div>
			</div>
		</div>
	</div>
</div>

<div class='industry'>
	<div class='industryCon clearfix'>
		<h2 class='title'></h2>
		<div class='left'>
			<h3 class='mt37 ml42'> <span class='highLight'></span></h3>
			<div id='chart4'>
				<div class='tip'>
					<div class='tipCon'>8888
						<i></i>
					</div>
				</div>
			</div>
			<div class='result'> <span class='bold'></span></div>
		</div>
		<div class='right'>
			<h3 class='mt37 ml42'> <span class='highLight'></span></h3>
			<div id='chart5'>
				<div class='tip'>
					<div class='tipCon'>8888
						<i></i>
					</div>
				</div>
			</div>
			<div class='result'><span class='bold'></span> </div>
		</div>
	</div>
	<div class='industryTag'>
		<p>数据来源：中国采购与招标网大数据研究中心</p>
		<p>作用说明：景气指数反映特定行业的景气变化情况，关注指数反映客户在互联网上对特定行业的关注程度及持续变化情况</p>
		<p>算法说明：以中国采购与招标网大数据研究中心的数据资源和客户在我网的搜索量为基础，以特定行业为统计对象，科学分析并计算出各个特定行业的指数值。</p>
	</div>
</div>

<div class='user'>
	<div class='userCon clearfix'>
		<h2 class='title'></h2>
		<div class='left'>
			<div class="province">省份</div>
		</div>
		<div class='right'>
			<div id ='chart6'>
				
				<div class='chartText'>关注 <span id='chartT6'>房地产建筑行业</span>的客户中，约60%竞争力适中占比最大</div>
			</div>
			<div id ='chart7'>
				<div class='chartText'>关注 <span id='chartT6'>房地产建筑行业</span>约60%竞争力适中占比最大</div>
			</div>
		</div>
	</div>
		<div class='userTag'>
		<p>数据来源：中国采购与招标网大数据研究中心</p>
		<p>作用说明：景气指数反映特定行业的景气变化情况，关注指数反映客户在互联网上对特定行业的关注程度及持续变化情况</p>
		<p>算法说明：以中国采购与招标网大数据研究中心的数据资源和客户在我网的搜索量为基础，以特定行业为统计对象，科学分析并计算出各个特定行业的指数值。</p>
	</div>
</div>

<div class='report'>
	<div class='reportCon clearfix'>
		<h2 class='title'></h2>
		<div class='left'>
			<div class='top'>
				<div><span class='large'>房地产建筑行业</span>
				<span class='small'>热门单位</span></div>		
			</div>
			<div class="list">
				<div class='reTitle clearfix'>
					<span class='rePm'>排名</span>
					<span class='reGjc'>单位名称</span>
					<span class='reZs'>搜索指数</span>
				</div>
				<div id='leftListCon'>
					<ul id='leftList' class='clearfix'>
						
					</ul>
				</div>
			</div>
		</div>
		<div class='right clearfix'>
			<div class="conLeft">
				<div class='mTop'>
					<i></i>
					<span class='mtitle'>房地产建筑行业</span>
           			<span class='subTitle'>热门报告</span>
           		</div>
				<div class="mBottom">
					<ul>
						<li class='li3'>
							
						</li>

						<li class='li4'>
							
						</li>
					</ul>
				</div>
			</div>
			<div class="conRight">

				<div class='rTop'>
					<ul>
						<li class='li1'>
							
						</li>

						<li class='li2'>
							
						</li>
					</ul>
				</div>
				<div class='rTop'>
					<ul>
						<li class='li5'>
							
						</li>

						<li class='li6'>
							<div class='chart'></div>
							<div class='more'>查看更多</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20151229"></script>
		<script type="text/javascript">
		// 入口模块
		seajs.use("${resPath}/resources/commons/js/public/industry")
		</script>
	</myScript>
</body>
</html>