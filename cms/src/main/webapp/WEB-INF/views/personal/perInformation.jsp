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
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/user.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
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
			<li><a href="javascript:;" class="location">个人信息</a></li>
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
					<li><a href="${appPath}/personal/information" class="active">个人信息</a></li>
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
				<div class="section my_info" style="display:block;">
					<h2>个人信息<i></i></h2>
					<div class="my_info_box clearfix">
						<div class="face">
							<img id="uploadAvatar" src="${imgPath}/${memberinfo.avatarPath }" onerror="errorAvatarTwo(this);" />
							<a>更换头像</a>
						</div>
						<div class="info_box">
							<div class="username_box">
								<span class="master">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</span>
								<span class="nickname">${username }</span>
							</div>
							<div class="sex_box">
								<span class="master import">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
								<input name="sex" type="radio" id="male" value="N" <c:choose><c:when test="${memberinfo.sex eq 'N'}">checked</c:when><c:otherwise></c:otherwise></c:choose> />
								<label>男</label>
								<input name="sex" type="radio" id="female" value="Y" <c:choose><c:when test="${memberinfo.sex eq 'Y'}">checked</c:when><c:otherwise></c:otherwise></c:choose> />
								<label>女</label>
								<input name="sex" type="radio" id="secrecy" value="S" <c:choose><c:when test="${memberinfo.sex eq 'S'}">checked</c:when><c:otherwise></c:otherwise></c:choose> />
								<label>保密</label>
								<b class="checkError"></b>
							</div>
							<!--<div class="mobile_box">
								<span class="master import">手机号码：</span>
								<input class="phone_number" value="${memberinfo.mobilePhone }" id="mobile_phone" maxlength="11">
								<a href="javascript:;" class="change">修改</a>
								<span class="test">未验证</span>
								<b class="checkError"></b>
							</div> -->
							<div class="email_box">
								<span class="master import">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</span>
								<input class="email" value="${memberinfo.custEmail }" id="cust_email" maxlength="200" >
								<a href="javascript:;" class="change">修改</a>
								<span class="test">未验证</span>
								<b class="checkError"></b>
							</div>
							<div class="name_box">
								<label for="email" class="master import">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
								<input type="text" id="name" value="${memberinfo.custName }" maxlength="200">
								<b class="checkError"></b>
							</div>
							<div class="address_box clearfix">
								<label for="email" class="master">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</label>
								<div class="area clearfix">
						            <div class="province_box">
						                  <input onclick="hidep('province_input')" type="text" value="${memberinfo.custProvince }" id="province" readonly="" />
						                  <div id="province_input" style="display:none " class="select_content"></div>
						            </div>
						            <div class="city_box">
						                  <input onclick="hidec('city_input')" type="text" value="${memberinfo.custCity }" id="city" readonly=""/>
						                  <div id="city_input" style="display:none " class="select_content"></div>
						            </div>
						        </div>
							    <div>
							    	<input type="text" id="address" value="${memberinfo.address }" maxlength="200">
							    </div>
							    <b class="checkError"></b>
							</div>
							<div class="company_box">
								<label for="company" class="master import">公司名称：</label>
								<input type="text" id="company" value="${memberinfo.companyName }" maxlength="128">
								<b class="checkError"></b>
							</div>
							<div class="btn_box">
								<input type="submit" value="保存" class="submit" id="changeInfo" />
								<input type="reset"  value="取消" />
							</div>
						</div>
					</div>
					<div class="keywords">
						<p>请选择您感兴趣的信息，方便为你提供最精准的信息</p>
						<ul class="clearfix">
							<li>项目信息</li>
							<li>招标信息</li>
							<li>轻工</li>
							<li>网络通讯计算机</li>
							<li>机械电子</li>
						</ul>
						<a href="javascript:;">添加新的标签</a>
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
	var userId = "${userId}";
</script>
<script type="text/javascript" src="${resPath}/resources/commons/js/area.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/user/userInformation.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/user/commonUser.js?v=${projectversion}"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/ajaxfileupload.js?v=${projectversion}"></script>
</myScript>
</body>
</html>