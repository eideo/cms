<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn'%>
<%@ page isELIgnored="false"%> 
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="appPath" value="http://www.cms.com" />
<%-- <c:set var="casPath" value="http://192.168.8.129:9080"/>  --%>
<c:set var="casPath" value="http://101.200.0.81:8080/cas"/>
 <c:set var="resPath" value="http://101.200.0.81:8080/cms"/>
<c:set var="imgPath" value="http://img.cms.com" /> 
<script type="text/javascript">
	var path = "${casPath}";
</script>
