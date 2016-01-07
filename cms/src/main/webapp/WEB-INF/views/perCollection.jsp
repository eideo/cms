<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css">
		<link rel="stylesheet" type="text/css" media="screen and (max-width: 1200px)" href="${resPath}/resources/commons/css/user-min.css?v=1.0.1-20151229">
		<link rel="stylesheet" type="text/css" media="screen and (min-width: 1200px)" href="${resPath}/resources/commons/css/user.css?v=1.0.1-20151229">
	</myCss>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/jquery-1.7.2.min.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/paging/page.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/user.js?v=1.0.1-20151231"></script>
		<script type="text/javascript">
			$(".tcdPageCode").createPage({
		        pageCount : ${totalPage},
		        current : ${currentPage},
		        backFn : function(p) {
		        	ajaxCustBehaviorList(p);
		        }
		    });
		</script>
	</myScript>
</head>
<body>
	<!-- 页面位置 -->
	<div class="message_top">
		<ul class="clearfix">
			<li><a href="javascript:;">CMS首页</a></li>
			<li class="symbol">></li>
			<li><a href="javascript:;">个人中心</a></li>
			<li class="symbol">></li>
			<li><a href="javascript:;" class="location">我的收藏</a></li>
		</ul>
		<i></i>
	</div>

	<!-- 主要内容 -->
	<div class="main clearfix">
		<div class="sign">
			<div class="user_box">
				<div class="face clearfix">
					<div class="img">
						<img id="avatarShow" src="${imgPath}/${avatarPath }" onerror="errorAvatar(this);">
					</div>
					<div class="user_info">
						<h3>${custName }<i></i></h3>
						<p>
							<span>我的积分</span>
							<span>100000</span>
						</p>
						<div class="vip_box clearfix">
							<div class="vip">VIP</div>
							<div class="rechange">账户充值</div>
						</div>
					</div>
				</div>
				<div class="safety">
					<span>安全设置</span>
					<span class="scale"><i></i></span>
					<span class="grade">低</span>
					<a href="javascript:;">提升 ></a>
				</div>
			</div>
			<div class="personal_center">
				<h4>
					<i></i>
					<span>个人中心</span>
				</h4 >
				<ul>
					<li class="ban"><a>我的订单</a></li>
					<li><a href="${appPath}/personal/information">个人信息</a></li>
					<li class="ban"><a>安全设置</a></li>
					<li><a href="${appPath}/personal/attention">我的关注</a></li>
					<li><a href="${appPath}/personal/collection" class="active">我的收藏</a></li>
					<li><a href="${appPath}/personal/footprint">我的足迹</a></li>
				</ul>
			</div>
			<div class="asset_center">
				<h4>
					<i></i>
					<span>个人资产</span>
				</h4 >
				<ul>
					<li class="ban"><a>我的积分</a></li>
					<li class="ban"><a>账户充值</a></li>
				</ul>
			</div>
		</div>
		<div class="content">
			<div class="personalBox">
				<div class="section my_attention common_operation" style="display:block;">
					<h2>我的收藏<i></i></h2>
					<div class="title clearfix">
						<span class="selectall"><i></i>全选</span>
						<span class="project">
							<i></i>
							<span>信息名称</span>
							<input id="action_type" type="hidden" value="4" />
							<input id="info_type" type="hidden" value="" />
							<ul class="tab_n title_tab">
								<b></b>
								<li class="all_type">信息名称</li>
								<li class="xiangmu_type" onclick="javascript:getByInfoType('11501');">项目</li>
								<li class="zhaobiao_type" onclick="javascript:getByInfoType('11502');">招标</li>
								<li class="zhongbiao_type" onclick="javascript:getByInfoType('11503');">中标</li>
							</ul>
						</span>
						<span class="operation">操作</span>
					</div>
					<ul class="collection_list cart_list" id="custBehaviorList">
						<c:choose>
							<c:when test="${!empty custBehaviorList}">
								<c:forEach var="custBehavior" items="${custBehaviorList}">
									<li class="${custBehavior.styleClassLi}" id="${custBehavior.id}">
										${custBehavior.styleClassBorder}
										<span class="name">
											${custBehavior.styleClassCheck}
											<a href="javascript:;">信息名称：${custBehavior.subInfoName}</a>
											<b>${custBehavior.infoTypeCn}</b>
											<br>
											<span>${custBehavior.subIntroduction}</span>
										</span>
										<div class="operation">
											<a href="javascript:;" class="remove" onclick="javascript:deleteCustBehavior(${custBehavior.id});"><i></i>删除</a>
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
					<!-- 批量 -->
					<div class="balance clearfix">
						<div class="balance_select">
							<span class="selectall"><i></i>全选</span>
							<span class="removeall hover" onclick="javascript:deleteAll();">删除</span>
							<span class="remove_Invalid hover"  onclick="javascript:deleteInvalid();">删除失效信息</span>
						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>

	<script type="text/html" id="custBehaviorListTemplate">
		<li class="{custBehavior.styleClassLi}" id="{custBehavior.id}">
			{custBehavior.styleClassBorder}
			<span class="name">
				{custBehavior.styleClassCheck}
				<a href="javascript:;">{custBehavior.subInfoName}</a>
				<b>{custBehavior.infoTypeCn}</b>
				<br>
				<span>{custBehavior.subIntroduction}</span>
			</span>
			<div class="operation">
				<a href="javascript:;" class="remove" onclick="javascript:deleteCustBehavior({custBehavior.id});"><i></i>删除</a>
			</div>	
		</li>
	</script>
</body>
</html>