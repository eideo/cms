function logout() {
	// 单点登出
	$.ajax({
		dataType : "jsonp",
		url : 'http://101.200.0.81/cas/ajaxlogout',
		type : "post",
		data : {},
		jsonp : 'jsoncallback',
		success : function(data) {
			if (data.result) {
				document.location.href = getContextPath() + "/sys/sysuser/logout";
			} else {
				alert("单点登出服务器错误");
			}
		},
		error : function() {
			alert("单点登出服务器异常");
		}
	});
}
