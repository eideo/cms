<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	var username = "${userName}";
	parent.username = username;
</script>
<%@include file="/common/base.jsp"%>
</head>
<body>
</body>
</html>