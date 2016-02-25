<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心-账户充值</title>
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
			<li><a href="javascript:;" class="location">账户充值</a></li>
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
					<li><a href="${appPath}/personal/perSecurity" class="active">安全设置</a></li>
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
			<div class="assetBox">
				<div class="section">
					<h2>我的积分<i></i></h2>
				</div>
				<div class="section">
					<div class="record">
						<h2>充值记录<i></i></h2>
						<div class="wallet_box clearfix">
							<div class="available">可以用余额：<span>2300000.00</span>元</div>
							<div class="consumption">消费总额：<span>0.00</span>元</div>
							<div class="rechange_box">
								<a href="javascript:;" id="cztz">账户充值</a>
							</div>
						</div>
						<div class="time_type">
							近3个月
							<i></i>
						</div>
						<table cellspacing="0" cellpadding="0">
							  <tr>
							    <th>流水号</th>
							    <th>金额</th>
							    <th>余额</th>
							    <th>描述</th>
							    <th>时间</th>
							  </tr>
							  <tr>
							    <td class="serial_number">20151107233</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-19 10:20:00</td>
							  </tr>
							  <tr>
							    <td class="serial_number">20151107234</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-18 06.36:00</td>
							  </tr>
							  <tr>
							    <td class="serial_number">20151108231</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-17 09:30:00</td>
							  </tr>
							  <tr>
							    <td class="serial_number">20151107238</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-16 16:20:00</td>
							  </tr>
							  <tr>
							    <td class="serial_number">20151107237</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-12 08:40:00</td>
							  </tr>
							  <tr>
							    <td class="serial_number">20151107239</td>
							    <td class="money">300000.00</td>
							    <td class="remain_money">5000.00</td>
							    <td class="money_info">支付宝充值<span>2000.00</span>元</td>
							    <td class="p_time">2015-11-01 16:40:00</td>
							  </tr>
							</table>
					</div>
					<div class="change_money">
						<h2>账户充值<i></i></h2>
						<ul class="payment_method clearfix">
							<li class="method1 active">支付宝&nbsp/&nbsp财付通&nbsp/&nbsp微信支付</li>
							<li class="method2">储蓄卡</li>
							<li class="method3">信用卡</li>
						</ul>
						<div class="method_box">
							<div class="method_box1 method">
								<ul class="bank_select clearfix">
									<li class="bank1"><span><i></i></span></li>
									<li class="bank2"><span><i></i></span></li>
									<li class="bank3"><span><i></i></span></li>
								</ul>
								<div class="keyong">
									可用余额：<span>0.00</span>元
								</div>
								<div class="chongzhi">
									充值金额：<input type="text">元
								</div>
								<div class="chong_btn">
									<button>确认充值</button>
								</div>
							</div>
							<div class="method_box2 method">
								<ul class="bank_select clearfix">
									<li class="bank1"><span><i></i></span></li>
									<li class="bank2"><span><i></i></span></li>
									<li class="bank3"><span><i></i></span></li>
									<li class="bank4"><span><i></i></span></li>
									<li class="bank5"><span><i></i></span></li>
									<li class="bank6"><span><i></i></span></li>
									<li class="bank7"><span><i></i></span></li>
									<li class="bank8"><span><i></i></span></li>
									<li class="bank9"><span><i></i></span></li>
									<li class="bank10"><span><i></i></span></li>
								</ul>
								<div class="keyong">
									可用余额：<span>0.00</span>元
								</div>
								<div class="chongzhi">
									充值金额：<input type="text">元
								</div>
								<div class="chong_btn">
									<button>确认充值</button>
								</div>
							</div>
							<div class="method_box2 method">
								<ul class="bank_select clearfix">
									<li class="bank1"><span><i></i></span></li>
									<li class="bank2"><span><i></i></span></li>
									<li class="bank3"><span><i></i></span></li>
									<li class="bank4"><span><i></i></span></li>
									<li class="bank5"><span><i></i></span></li>
									<li class="bank6"><span><i></i></span></li>
									<li class="bank7"><span><i></i></span></li>
									<li class="bank8"><span><i></i></span></li>
									<li class="bank9"><span><i></i></span></li>
									<li class="bank10"><span><i></i></span></li>
								</ul>
								<div class="keyong">
									可用余额：<span>0.00</span>元
								</div>
								<div class="chongzhi">
									充值金额：<input type="text">元
								</div>
								<div class="chong_btn">
									<button>确认充值</button>
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
<script type="text/javascript" src="${resPath}/resources/commons/js/user/userSecurity.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/user/commonUser.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/ajaxfileupload.js?v=${projectversion}"></script>
</myScript>
</body>
</html>