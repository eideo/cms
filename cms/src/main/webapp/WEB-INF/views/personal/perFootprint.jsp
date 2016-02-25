<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css"  href="${resPath}/resources/commons/css/user.css?v=${projectversion}">
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
			<li><a href="javascript:;" class="location">我的足迹</a></li>
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
					<li><a href="${appPath}/personal/collection" >我的收藏</a></li>
					<li><a href="${appPath}/personal/footprint" class="active">我的足迹</a></li>
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
				<div class="section my_foot" style="display:block;">
					<h2>
						我的足迹<i></i>
						<!-- <div class="searchBox clearfix">
							<input type="text" placeholder="输入项目标题或订单号进行搜索">
							<button>搜索</button>
						</div> -->
					</h2>
					<div class="screening clearfix">
						<span>信息类型:</span>
						<input id="info_type" type="hidden" value="${infoType}" />
						<a href="${appPath}/personal/footprint" id="unlimited" class="<c:choose><c:when test="${activeFlag == 0}">active</c:when><c:otherwise></c:otherwise></c:choose>" >不限</a>
						<a href="${appPath}/personal/footprint/11501" id="item" class="<c:choose><c:when test="${activeFlag == 1}">active</c:when><c:otherwise></c:otherwise></c:choose>" >项目信息</a>
						<a href="${appPath}/personal/footprint/11502" id="attract" class="<c:choose><c:when test="${activeFlag == 2}">active</c:when><c:otherwise></c:otherwise></c:choose>" >招标信息</a>
						<a href="${appPath}/personal/footprint/11503" id="bidding" class="<c:choose><c:when test="${activeFlag == 3}">active</c:when><c:otherwise></c:otherwise></c:choose>" >中标信息</a>
					</div>
					<div class="foot_list">
						<i class="last_icon"></i>
						<ol>
							<c:choose>
								<c:when test="${!empty footprintMap}">
									<c:forEach var="footprint" items="${footprintMap}">
										<li>
											<div class="trade_time">
												<span class="time">${footprint.key}</span>
												<i id="remove_date_${footprint.key}" onclick="javascript:deleteByDate(2, 1, '${footprint.key}');"></i>
												<b></b>
											</div>
											<ul class="message_list" id="my_footprint">
												<c:forEach var="custBehavior" items="${footprint.value}">
													<c:choose>
														<c:when test="${custBehavior.enabledFlag == 1}">
															<li class="zhaobiao" inType="${custBehavior.infoType}" infoId="${custBehavior.infoId}">
																<i class="f_border"></i>
																<i class="f_remove" id="remove_${custBehavior.id}" onclick="javascript:deleteById(${custBehavior.id});"></i>
																<div class="f_title">
																	<a href="javascript:;" class="name cutTitle infoLink"  target="_blank">信息名称：${custBehavior.subInfoName}</a>
																	<span>${custBehavior.infoTypeCn}</span>
																	<p class="cutParagraph">
																		${custBehavior.subIntroduction}
																	</p>
																</div>
																<div class="clearfix">
																	<div class="navBox clearfix">
																		<div class="ap" actiontype="3" infotype="${custBehavior.infoType}" infoid="${custBehavior.infoId}" >
																			<i class="attention"></i>
																			<span>关注</span>
																			<span class="re">已关注</span>
																		</div>
																		<div class="cp" actiontype="4" infotype="${custBehavior.infoType}" infoid="${custBehavior.infoId}" >
																			<i class="collection"></i>
																			<span>收藏</span>
																			<span class="re">已收藏</span>
																		</div>
																		<div class="sp">
																			<a href="javascript:;" class="share">分享</a>
																			<div class="shareBtn bdsharebuttonbox">
																				<a href="#" onclick="javascript:custBehaviorShare(5, ${custBehavior.infoType}, '${custBehavior.infoId}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
																				<a href="#" onclick="javascript:custBehaviorShare(5, ${custBehavior.infoType}, '${custBehavior.infoId}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
																				<a href="#" onclick="javascript:custBehaviorShare(5, ${custBehavior.infoType}, '${custBehavior.infoId}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
																			</div>
																			<em></em>
																		</div>
																	</div>
																</div>
															</li>
														</c:when>
														<c:otherwise>
															<li class="xiangmu failure_info">
																<i class="f_remove" id="remove_${custBehavior.id}" onclick="javascript:deleteById(${custBehavior.id});"></i>
																<div class="f_title">
																	<a href="javascript:;" class="name cutTitle">信息名称：${custBehavior.subInfoName}
																	</a>
																	<span>${custBehavior.infoTypeCn}</span>
																	<span class="failure_icon">失效</span>
																	<p  class="cutParagraph">
																		${custBehavior.subIntroduction}
																	</p>
																</div>	
															</li>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</ul>
										</li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									没有任何足迹
								</c:otherwise>
							</c:choose>
						</ol>
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

	<script>
		window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};
		with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
	</script>
	<myScript>
	<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=${projectversion}"></script>
	<script type="text/javascript" src="${resPath}/resources/commons/js/user/userFootprint.js?v=${projectversion}"></script>
	<script type="text/javascript" src="${resPath}/resources/commons/js/user/commonUser.js?v=${projectversion}"></script>
	</myScript>
</body>
</html>