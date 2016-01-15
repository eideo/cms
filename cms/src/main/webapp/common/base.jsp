<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn'%>
<%@ page isELIgnored="false"%> 
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="appPath" value="http://192.168.8.122:8080" />
<%-- <c:set var="resPath" value="http://101.200.0.81/cms"/> --%>
 <c:set var="resPath" value="http://192.168.8.122:8080"/>
 <%--  <c:set var="casPath" value="http://101.200.0.81/cas/login?service=http://101.200.0.81/cms/homepage"/>--%>
  <c:set var="casPath" value="http://101.200.0.81/cas/login?service=http://192.168.8.122:8080/homepage"/>
<%--  <c:set var="casPath" value="http://192.168.8.133:9080/login?service=http://192.168.8.129:8080/homepage"/>--%>
  <c:set var="casBase" value="http://101.200.0.81/cas"/>
<c:set var="imgPath" value="http://101.200.0.81" />

<!-- [if Ite IE8]>
<script type="text/javascript" src='http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js'></script>
<script type="text/javascript" src='http://apps.bdimg.com/libs/respond.js/1.4.2/respond.js'></script>
<![endif]-->

<script type="text/javascript">
	var path = "${resPath}";
	//var casPath =encodeURI("http://101.200.0.81/cas/login?service=http://101.200.0.81/cms/homepage");
	//var casPath =encodeURI("http://101.200.0.81/cas/login?service=http://192.168.8.129:8080/homepage");
	var casPath =encodeURI("http://101.200.0.81/cas/login?service=http://192.168.8.122:8080/homepage");
	var casBase = "${casBase}";
	function logout(){
		$.ajax({
			type:"post",
			async:true,
			url:casBase+'/ajaxlogout',	dataType:"jsonp",
			jsonp:'jsoncallback',
			success:function(a){
				if(a.result){
					location.href = location.href;
				}
			}
		});
	}
	</script>
