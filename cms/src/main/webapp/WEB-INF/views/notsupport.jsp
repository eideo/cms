<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>你的浏览器不被支持！</title>
    <mycss>
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=${projectversion}">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/style.css?v=${projectversion}">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/notsupport.css?v=${projectversion}">
    </mycss>
</head>
<body>
<span id='noLevel'>暂不升级,继续浏览</span>
<div class="content">
	<a href="http://down.360safe.com/p/360se_nanaxt10.exe" target="_blank"></a>
	<a href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie" target="_blank"></a>
	<a href="http://www.apple.com/cn/safari/" target="_blank"></a>
	<a href="https://www.google.com/intl/zh-CN/chrome/browser/" target="_blank"></a>
	<a href="http://www.firefox.com.cn/download/" target="_blank" alt="火狐"></a>
</div>
<script type="text/javascript">
	$(function(){
		$("#noLevel").on('click',function() {
	        var d = new Date();
	        d.setTime(d.getTime() + 24 * 3600 * 1000);
	        document.cookie = "ic=1; expires=" + d.toGMTString() + "; path=/";
	        window.location.href= '${resPath}/homepage';
	    });
		var cookie = document.cookie.match(/(?:^|;)\s*ic=(\d)/);
		if (cookie && cookie[1]) {
	        return;
	    }
	})
</script>
</body>
</html>