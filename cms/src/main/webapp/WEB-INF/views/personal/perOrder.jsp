<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心-我的订单</title>
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
			<li><a href="javascript:;" class="location">我的订单</a></li>
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
					<li><a href="${appPath}/personal/perOrder" class="active">我的订单</a></li>
					<li><a href="${appPath}/personal/information" >个人信息</a></li>
					<li><a href="${appPath}/personal/perSecurity">安全设置</a></li>
					<li><a href="${appPath}/personal/attention">我的关注</a></li>
					<li><a href="${appPath}/personal/collection" >我的收藏</a></li>
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
				<div class="section my_order"  style="display:block;">
					<h2>我的订单<i></i></h2>
					<ul class="order_nav clearfix">
						<li class="active">全部订单</li>
						<div class="search_box clearfix">
							<input type="text" value="页面订单搜索">
							<button>搜索</button>
						</div>
					</ul>
					<div class="order_box">
						<div class="all_orders part">
							<div class="select_box clearfix">
								<span class="select_all">
									<i></i>
									全选
								</span>
								<span class="remove_all hover">
									<i></i>
									删除
								</span>
							</div>
							<div class="screen_box clearfix">
								<div class="time">
									<i></i> 
									近3个月订单 
								</div>
								<div class="p_name">
									<i></i>
									<span>信息名称</span>
									<ul class="tab_n title_tab">
										<b></b>
										<li class="all_type">信息名称</li>
										<li class="xiangmu_type">项目</li>
										<li class="zhaobiao_type">招标</li>
										<li class="zhongbiao_type">中标</li>
										<li class="baogao_type">报告</li>
									</ul>
								</div>
								<div class="o_price">
									消费采钻
								</div>
								<div class="o_status">
									<span>剩余条数</span>
								</div>
								<div class="o_time">
									<span>购买时间</span>
								</div>
								<div class="o_operation">
									操作
								</div>
							</div>
							<ul class="order_list clearfix">
								<li class="zhaobiao">
									<div class="li_title">
										<div class="select_order">
											<i></i>
											订单编号：201511127188
										</div>
										<div class="li_remove">
										</div>
										<div class="timing">交易时间：<span>2015-11-12</span></div>
									</div>
									<div class="detail clearfix">
										<a href="javascript:;" class="o_name">信息名称：槽式太阳能—燃气联合循环（ISCC）发电站工程
											<b>招标</b>
										</a>
										
										<div class="o_price">1500.00</div>
										<div class="status">
											300万采钻
										</div>
										<div class="o_time">
											2015-11-12 12:00
										</div>
										<div class="op">
											<div class="share sp">
												<i></i>
												<a href="javascript:;" class="share">分享</a>
												<div class="shareBtn bdsharebuttonbox">
												<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
												</div>
												<em></em>
											</div>
											<div class="comment"><i></i>评论</div>
											<div class="collection">
												<i></i><span>已</span>收藏
											</div>
										</div>
									</div>
									<div class="comment_box">
										<div class="star">
											<span>评分：</span>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
										</div>
										<div class="rating">
											<span>评级：</span>
											<a href="javascript:;">非常满意</a>
											<a href="javascript:;">满意</a>
											<a href="javascript:;">一般</a>
										</div>
										<div class="comment_val clearfix">
											<span>评论：</span>
											<textarea>信息是否给力？快分享你的购买心得吧·····</textarea>
										</div>
										<div class="c_btn">
											<span>评论并继续</span>
											<b><i></i>匿名评论</b>
										</div>
									</div>	
								</li>
								<li class="xiangmu">
									<div class="li_title">
										<div class="select_order">
											<i></i>
											订单编号：201511127100
										</div>
										<div class="li_remove">
										</div>
										<div class="timing">交易时间：<span>2015-11-02</span></div>
									</div>
									<div class="detail clearfix">
										<a href="javascript:;" class="o_name">信息名称：占地面积为30000平方米母线槽系统生产建设项目
											<b>项目</b>
										</a>
										
										<div class="o_price">6600.00</div>
										<div class="status">
											300万采钻
										</div>
										<div class="o_time">
											2015-11-12 12:00
										</div>
										<div class="op">
											<div class="share sp">
												<i></i>
												<a href="javascript:;" class="share">分享</a>
												<div class="shareBtn bdsharebuttonbox">
												<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
												</div>
												<em></em>
											</div>
											<div class="comment"><i></i>评论</div>
											<div class="collection">
												<i></i><span>已</span>收藏
											</div>
										</div>
									</div>
									<div class="comment_box">
										<div class="star">
											<span>评分：</span>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
										</div>
										<div class="rating">
											<span>评级：</span>
											<a href="javascript:;">非常满意</a>
											<a href="javascript:;">满意</a>
											<a href="javascript:;">一般</a>
										</div>
										<div class="comment_val clearfix">
											<span>评论：</span>
											<textarea>信息是否给力？快分享你的购买心得吧·····</textarea>
										</div>
										<div class="c_btn">
											<span>评论并继续</span>
											<b><i></i>匿名评论</b>
										</div>
									</div>	
								</li>
								<li class="xiangmu">
									<div class="li_title">
										<div class="select_order">
											<i></i>
											订单编号：201511127188
										</div>
										<div class="li_remove">
										</div>
										<div class="timing">交易时间：<span>2015-11-12</span></div>
									</div>
									<div class="detail clearfix">
										<a href="javascript:;" class="o_name">信息名称：总建筑面积为33,115平方米海洋声学光电集成系统产研基地项目 
											<b>项目</b>
										</a>
										
										<div class="o_price">800.00</div>
										<div class="status">
											20万条
										</div>
										<div class="o_time">
											2015-11-12 12:00
										</div>
										<div class="op">
											<div class="share sp">
												<i></i>
												<a href="javascript:;" class="share">分享</a>
												<div class="shareBtn bdsharebuttonbox">
												<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
												</div>
												<em></em>
											</div>
											<div class="comment"><i></i>评论</div>
											<div class="collection">
												<i></i><span>已</span>收藏
											</div>
										</div>
									</div>
									<div class="comment_box">
										<div class="star">
											<span>评分：</span>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
										</div>
										<div class="rating">
											<span>评级：</span>
											<a href="javascript:;">非常满意</a>
											<a href="javascript:;">满意</a>
											<a href="javascript:;">一般</a>
										</div>
										<div class="comment_val clearfix">
											<span>评论：</span>
											<textarea>信息是否给力？快分享你的购买心得吧·····</textarea>
										</div>
										<div class="c_btn">
											<span>评论并继续</span>
											<b><i></i>匿名评论</b>
										</div>
									</div>	
								</li>
								<li class="zhaobiao">
									<div class="li_title">
										<div class="select_order">
											<i></i>
											订单编号：201511127138
										</div>
										<div class="li_remove">
										</div>
										<div class="timing">交易时间：<span>2015-11-12</span></div>
									</div>
									<div class="detail clearfix">
										<a href="javascript:;" class="o_name">信息名称：6000KW发电机组离子膜烧碱等工程
											<b>招标</b>
										</a>
										
										<div class="o_price">2200.00</div>
										<div class="status">
											300万采钻
										</div>
										<div class="o_time">
											2015-11-12 12:00
										</div>
										<div class="op">
											<div class="share sp">
												<i></i>
												<a href="javascript:;" class="share">分享</a>
												<div class="shareBtn bdsharebuttonbox">
												<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
												</div>
												<em></em>
											</div>
											<div class="comment"><i></i>评论</div>
											<div class="collection">
												<i></i><span>已</span>收藏
											</div>
										</div>
									</div>
									<div class="comment_box">
										<div class="star">
											<span>评分：</span>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
										</div>
										<div class="rating">
											<span>评级：</span>
											<a href="javascript:;">非常满意</a>
											<a href="javascript:;">满意</a>
											<a href="javascript:;">一般</a>
										</div>
										<div class="comment_val clearfix">
											<span>评论：</span>
											<textarea>信息是否给力？快分享你的购买心得吧·····</textarea>
										</div>
										<div class="c_btn">
											<span>评论并继续</span>
											<b><i></i>匿名评论</b>
										</div>
									</div>	
								</li>
								<li class="zhongbiao">
									<div class="li_title">
										<div class="select_order">
											<i></i>
											订单编号：201511127200
										</div>
										<div class="li_remove">
										</div>
										<div class="timing">交易时间：<span>2015-11-11</span></div>
									</div>
									<div class="detail clearfix">
										<a href="javascript:;" class="o_name">信息名称：总建筑面积约10000平方米原料药和外用制剂生产线项目
											<b>中标</b>
										</a>
										
										<div class="o_price">3200.00</div>
										<div class="status">
											300万采钻
										</div>
										<div class="o_time">
											2015-11-12 12:00
										</div>
										<div class="op">
											<div class="share sp">
												<i></i>
												<a href="javascript:;" class="share">分享</a>
												<div class="shareBtn bdsharebuttonbox">
												<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
												<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
												<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
												</div>
												<em></em>
											</div>
											<div class="comment"><i></i>评论</div>
											<div class="collection">
												<i></i><span>已</span>收藏
											</div>
										</div>
									</div>
									<div class="comment_box">
										<div class="star">
											<span>评分：</span>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
											<a href="javascript:;"></a>
										</div>
										<div class="rating">
											<span>评级：</span>
											<a href="javascript:;">非常满意</a>
											<a href="javascript:;">满意</a>
											<a href="javascript:;">一般</a>
										</div>
										<div class="comment_val clearfix">
											<span>评论：</span>
											<textarea>信息是否给力？快分享你的购买心得吧·····</textarea>
										</div>
										<div class="c_btn">
											<span>评论并继续</span>
											<b><i></i>匿名评论</b>
										</div>
									</div>	
								</li>
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

						</div>
					</div>
				</div>
			</div>		
		</div>
	</div>

	<!-- 错误提示框 -->
	<div class="errorMessage">
		<h6>网页提示</h6>
		<p class="msg">未知错误，请求异常</p>
		<a class="ensure">确定</a>
	</div>

	<!--上传头像层-->
	<div class="updateImgBox">
		<h3>上传头像</h3>
		<div class="updateBtn">
			<a>
				<em>上传头像</em>
				<input type="file"  onchange="uploadFace(this)"  id="personalAvatar" name="personalAvatar">
			</a>
			<span id="uploadError"></span>
		</div>
		<div class="alertMsg">
			您可以上传JPG、GIF或PNG文件上传图片最大2M,推荐100x100
		</div>
		<div class="subBtn">
			<input type="submit" value="保存"  id="saveImg"  userId="${userId }">
			<input type="reset" value="取消"  class="cancel">
		</div>
		<div class="previewImg" id="preview">
			<img src="" alt="" id="imghead">
		</div>
	</div>

	<div class="shadow_all" style='display:none;'></div>

	<div class="vUpgrade">
		<div class="vUpgradeCon">
			<div class="top">会员升级</div><i class='close'></i>
			<div class="con clearfix">
				<i class='levelTag levelTag4'></i>
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
<myScript>
<script type="text/javascript">
	var imgPath = "${imgPath}";
	var resPath = "${resPath}";
</script>
<script type="text/javascript" src="${resPath}/resources/commons/js/area.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/user/commonUser.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/user/userOrder.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/ajaxfileupload.js?v=${projectversion}"></script>
</myScript>
</body>
</html>