<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心-我的收藏</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/user.css?v=${projectversion}">
	</myCss>
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
		                <h3>${custName }<i class='level2'></i></h3>
		                <p>
		                    <span>我的采钻：</span>
		                    <span>10万</span>
		                </p>
		                <div class="vip_box clearfix">
		                    <div class="rechange" id='vipUpgrade'>会员升级</div>
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
					<li><a href="${appPath}/personal/perOrder">我的订单</a></li>
					<li><a href="${appPath}/personal/information" >个人信息</a></li>
					<li><a href="${appPath}/personal/perSecurity">安全设置</a></li>
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
					<li class="ban"><a>我的采钻</a></li>
					<li class="ban"><a>账户充值</a></li>
				</ul>
			</div>
		</div>
		
		<div class="content">
			<div class="personalBox">
				<div class="section my_attention common_operation" style="display:block;">
					<h2>我的收藏<i></i></h2>
					<div class="title clearfix">
						<span class="project">
							<i></i>
							<span>列表分类</span>
							<input id="action_type" type="hidden" value="4" />
							<input id="info_type" type="hidden" value="" />
							<ul class="tab_n title_tab">
								<b></b>
								<li class="all_type">列表分类</li>
								<li class="xiangmu_type" onclick="javascript:getByInfoType('11501');">项目
								</li>
								<li class="zhaobiao_type" onclick="javascript:getByInfoType('11502');">招标
								</li>
								<li class="zhongbiao_type" onclick="javascript:getByInfoType('11503');">中标
								</li>
								<li class="report_type">行业报告
								</li>
							</ul>
						</span>
						<span class="operation">操作</span>
					</div>
					<ul class="collection_list cart_list" id="custBehaviorList">
						<c:choose>
							<c:when test="${!empty custBehaviorList}">
								<c:forEach var="custBehavior" items="${custBehaviorList}">
									<li class="${custBehavior.styleClassLi}" id="${custBehavior.id}" inType="${custBehavior.infoType}" infoId="${custBehavior.infoId}">
										${custBehavior.styleClassBorder}
										<span class="name">
											${custBehavior.styleClassCheck}
											<a href="" class="infoLink" target="_blank">信息名称：${custBehavior.subInfoName}</a>
											<b>${custBehavior.infoTypeCn}</b>
											<br>
											<span class="cutTitle">${custBehavior.subIntroduction}</span>
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
									<div class="searchPage">
										<span class="page-sum">共<strong class="allPage">2</strong>页</span>
										<span class="page-go">跳转到<input type="text" id="pageTo">页</span>
										<a href="javascript:;" class="page-btn">确定</a>
									</div>
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

	<div class="shadow_all" style='display:none;'></div>

	<div class="vUpgrade">
		<div class="vUpgradeCon">
			<div class="top">会员升级</div><i class='close'></i>
			<div class="con clearfix">
				<div class="level level1">
					<h3>入门服务</h3>
					<ul>
						<li><i></i>5000元/年</li>
						<li><i></i>赠20万采钻</li>
						<li><i></i>9000元/2年</li>
						<li><i></i>赠40万采钻</li>
					</ul>
				</div>
				<div class="level level2">
					<h3>标准服务</h3>
					<ul>
						<li><i></i>9000元/年</li>
						<li><i></i>赠40万采钻</li>
						<li><i></i>16000元/2年</li>
						<li><i></i>赠80万采钻</li>
					</ul>
				</div>
				<div class="level level3">
					<h3>VIP服务</h3>
					<ul>
						<li><i></i>18000元/年</li>
						<li><i></i>赠100万采钻</li>
						<li><i></i>32000元/2年</li>
						<li><i></i>赠200万采钻</li>
					</ul>
				</div>
				<div class="level level4">
					<h3>钻石服务</h3>
					<ul>
						<li><i></i>58000元/年</li>
						<li><i></i>赠250万采钻</li>
						<li><i></i>98000元/2年</li>
						<li><i></i>赠500万采钻</li>
					</ul>
				</div>
			</div>
			<div class="contact">
				<ul>
					<li class="item" id='four'><i></i>400-968-9685</li>
					<li class="item" id='telephone'><i></i>010-82743201</li>
					<li class="item" id='qq'><i></i>2133606287</li>
				</ul>
			</div>
		</div>
	</div>

	<script type="text/html" id="custBehaviorListTemplate">
		<li class="{custBehavior.styleClassLi}" id="{custBehavior.id}" inType="{custBehavior.infoType}" infoId="{custBehavior.infoId}">
			{custBehavior.styleClassBorder}
			<span class="name">
				{custBehavior.styleClassCheck}
				<a href="" class="infoLink" target="_blank">{custBehavior.subInfoName}</a>
				<b>{custBehavior.infoTypeCn}</b>
				<br>
				<span class="cutTitle">{custBehavior.subIntroduction}</span>
			</span>
			<div class="operation">
				<a href="javascript:;" class="remove" onclick="javascript:deleteCustBehavior({custBehavior.id});"><i></i>删除</a>
			</div>	
		</li>
	</script>
	<myScript>
		<script type="text/javascript">
			var imgPath = "${imgPath}";
			var resPath = "${resPath}";
		</script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/jquery-1.7.2.min.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/paging/page.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/user/userCollection.js?v=${projectversion}"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/user/commonUser.js?v=${projectversion}"></script>
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
</body>
</html>