<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>个人中心-安全设置</title>
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
			<li><a href="javascript:;" class="location">安全设置</a></li>
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
			<div class="personalBox">
				<div class="section" style="display: block;">
				<h2>安全设置<i></i></h2>
				<ul class="setting_list">
					<li>
						<div class="re_box clearfix">
							<span class="option">登录密码</span>
							<span class="op_value color_red">保障账户安全，建议您定期修改密码</span>
							<span class="setting_status">已认证</span>
							<a href="javascript:;" class="update_btn">修改</a>
						</div>
						<div class="update_box">
							<div class="password_box">
								<span>输入原始密码</span>
								<input type="password">
							</div>
							<div class="mobile_code">
								<span>输入验证码</span>
								<input type="text">
								<button>获取验证码</button>
								<a href="javascript:;">邮箱验证码</a>
							</div>
							<div class="new_password">
								<span>输入新密码</span>
								<input type="password">
							</div>
							<div class="re_password">
								<span>重新输入新密码</span>
								<input type="password">
							</div>
							<div class="btn_box">
								<button>确认提交</button>
							</div>
						</div>
					</li>
					<li>
						<div class="re_box clearfix">
							<span class="option">手机认证</span>
							<span class="op_value">13******005</span>
							<span class="setting_status">已认证</span>
							<a href="javascript:;" class="update_btn">修改</a>
						</div>
						<div class="update_box update_mobile1">
							<div class="password_box">
								<span>输入原手机号</span>
								<input type="password">
							</div>
							<div class="mobile_code">
								<span>输入验证码</span>
								<input type="text">
								<button>获取验证码</button>
							</div>
							<div class="btn_box">
								<button>下一步</button>
							</div>
						</div>
						<div class="update_box update_mobile2">
							<div class="password_box">
								<span>输入新手机号</span>
								<input type="password">
							</div>
							<div class="mobile_code">
								<span>输入验证码</span>
								<input type="text">
								<button>获取验证码</button>
							</div>
							<div class="btn_box">
								<button>确认提交</button>
							</div>
						</div>
					</li>
					<li>
						<div class="re_box clearfix">
							<span class="option">邮箱认证</span>
							<span class="op_value">dema***xi@163.com</span>
							<span class="setting_status">已认证</span>
							<a href="javascript:;" class="update_btn">修改</a>
						</div>
						<div class="update_box update_mobile1">
							<div class="password_box">
								<span>已验证邮箱</span>
								<input type="password">
							</div>
							<div class="mobile_code">
								<span>输入箱验证码</span>
								<input type="text">
								<button>获取验证码</button>
							</div>
							<div class="btn_box">
								<button>下一步</button>
							</div>
						</div>
						<div class="update_box update_email2">
							<div class="password_box">
								<span>输入新邮箱</span>
								<input type="password">
							</div>
							<div class="btn_box">
								<button>确认提交</button>
							</div>
						</div>
					</li>
					<li>
						<div class="re_box clearfix">
							<span class="option">支付密码</span>
							<span class="op_value pay_password"></span>
							<span class="setting_status unverified">未设置</span>
							<a  href="javascript:;"class="update_btn">设置</a>
						</div>
						<div class="update_box pay_box">
							<div class="password_box">
								<span>输入新密码</span>
								<input type="password">
							</div>
							<div class="password_box">
								<span>重新输入新密码</span>
								<input type="password">
							</div>
							<div class="btn_box">
								<button>确认提交</button>
							</div>
						</div>
					</li>
				</ul>
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