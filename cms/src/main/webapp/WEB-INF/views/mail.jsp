<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="ie-comp">
	<title>邮件测试</title>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			function sendMail() {
				$.ajax({
					url : path + "/mail/sendtemplate",
					data : {
						'to' : "yujw@chinabidding.com.cn"
					},
					type : "POST",
					dataType : "json",
					success : function(data) {
						alert(data.success);
					},
					error : function() {
						alert("邮件发送异常");
					}
				});
			}
		</script>
	</myScript>
</head>
<body>
	<a href="javascript:sendMail();">邮件发送</a>
</body>
</html>