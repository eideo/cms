<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
      <title>404错误提示</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
      <link rel="stylesheet" type="text/css" href="${resPath}/resources/error/css/error.css" />
  </head>
<body>
     <div id="container"><img class="png" src="${resPath}/resources/error/images/404.png" />
       <img class="png msg" src="${resPath}/resources/error/images/404_msg.png" />
       <p><a href="${appPath}/homepage"><img class="png" src="${resPath}/resources/error/images/404_to_index.png" /></a> </p>
   </div>
    <div id="cloud" class="png"></div>
    <pre style="DISPLAY: none"></pre>
</body>
</html>