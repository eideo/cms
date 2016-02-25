<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
