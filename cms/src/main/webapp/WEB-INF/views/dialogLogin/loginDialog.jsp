<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	 <script type="text/html" id="headerTemp">
		 	<li><a href="javascript:;">欢迎您，{username}</a></li>
			<li>|</li>
			<li><a href="${appPath}/personal/information">个人中心</a></li>
			<li>|</li>
			<li><a href="javaScript:logout();">退出</a></li>
	</script>
	<script type="text/javascript">
			var username = "";
		 	function ajaxLogin(){
	 			$.ajax({
	 				type:"post",
	 				async:true,
	 				url:casBase+'/ajaxlogin',
	 				data:{user:$("#username").val(),passwd:$("#password").val(),service:path+'/toLoginIframe'},
	 				dataType:"jsonp",
	 				jsonp:'jsoncallback',
	 				success:function(a){
	 					if(a.result){
	 						ajaxSetUser(path+"/toLoginIframe?ticket="+a.st);
	 						$('.close').click();
	 					}else{
	 						//提示错误信息
	 						alert(a.message);
	 					}
	 				}
	 			});
	 			return false;
		 	 }
			 function ajaxSetUser(str){
				var iframe = document.createElement("iframe"); 
				iframe.src = str; 

				if (iframe.attachEvent){ 
					iframe.attachEvent("onload", function(){ 
						var html = $("#headerTemp").html().replace("{username}",username);
						$(".user-info").html(html);
						document.body.removeChild(iframe);
					}); 
				} else { 
					iframe.onload = function(){ 
						var html = $("#headerTemp").html().replace("{username}",username);
						$(".user-info").html(html);
						document.body.removeChild(iframe);
					};
				}
				document.body.appendChild(iframe);
			 }
	</script>
<!-- 	2015-12-01 by liyang -->
<!-- 下面是登录框 -->
	<form onsubmit="return ajaxLogin();">
		<div class="login_box">
		    <i class="close"></i>
		    <div class="loginTitle">登录</div>
			<div class="userbox">
				<input type="text" id="username" placeholder="邮箱/手机号">
				<i></i>
			</div>
			<div class="passwordbox">
				<input type="password" id="password" placeholder="密码">
				<i></i>
			</div>
			<div class="op_password">
				<input id="remember" type="checkbox"></input>
				<label for="remember">记住密码</label>
				<a href="javascript:;" class="update">忘记密码</a>
				<span>|</span>
				<a href="${appPath}/register" class="register">免费注册</a>
			</div>
			<input type="submit" value="立即登录" class="button">
		</div>
	</form>
	<div class="shadow_all"></div>