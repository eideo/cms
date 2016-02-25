<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn'%>
<%@ page isELIgnored="false"%> 
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="appPath" value="http://192.168.8.129" />
<%-- <c:set var="resPath" value="http://192.168.8.129/cms"/> --%>
 <c:set var="resPath" value="http://192.168.8.129"/>
 <%--  <c:set var="casPath" value="http://192.168.8.129/cas/login?service=http://192.168.8.129/cms/homepage"/>--%>
  <c:set var="casPath" value="http://192.168.8.129/cas/login?service=http://${pageContext.request.localAddr}/homepage"/>
<%--  <c:set var="casPath" value="http://192.168.8.133:9080/login?service=http://192.168.8.129:8080/homepage"/>--%>
  <c:set var="casBase" value="http://192.168.8.129/cas"/>
<c:set var="imgPath" value="http://192.168.8.129" />
<c:set var="projectversion" value="1.0.1-20160122" />

<script type="text/javascript">
	var path = "${resPath}";
	//var casPath =encodeURI("http://192.168.8.129/cas/login?service=http://192.168.8.129/cms/homepage");
	//var casPath =encodeURI("http://192.168.8.129/cas/login?service=http://192.168.8.129:8080/homepage");
	var casPath =encodeURI("${casPath}");
	var casBase = "${casBase}";
	function logout(){
		$.ajax({
			type:"post",
			async:true,
			url:casBase+'/ajaxlogout',	dataType:"jsonp",
			jsonp:'jsoncallback',
			success:function(a){
				if(a.result){
					var iframe = document.createElement("iframe"); 
					iframe.src = path+"/ajaxLogout"; 
					if (iframe.attachEvent){ 
						iframe.attachEvent("onload", function(){ 
							location.href = location.href;
							document.body.removeChild(iframe);
						}); 
					} else { 
						iframe.onload = function(){ 
							location.href = location.href;
							document.body.removeChild(iframe);
						};
					}
					document.body.appendChild(iframe);
				}
			}
		});
	}
	</script>
