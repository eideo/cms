<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/common/base.jsp"%>

<!-- ajax layout which only needs content area -->
<div class="page-header">
	<h1>
		控制台
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			概述&统计
		</small>
	</h1>
</div><!-- /.page-header -->

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="alert alert-block alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<i class="ace-icon fa fa-times"></i>
			</button>
			<strong class="green">
				CMS后台管理系统
			</strong>
   			可能还有一些BUG，功能还可以更多。系统在开发完善中 ... ...
		</div>
		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${contextPath}/static/assets/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/jquery-ui.custom.js", "${contextPath}/static/assets/js/jquery.ui.touch-punch.js", "${contextPath}/static/assets/js/jquery.easypiechart.js", "${contextPath}/static/assets/js/jquery.sparkline.js",
        		"${contextPath}/static/assets/js/flot/jquery.flot.js", "${contextPath}/static/assets/js/flot/jquery.flot.pie.js", "${contextPath}/static/assets/js/flot/jquery.flot.resize.js", "${contextPath}/static/assets/js/activities-serverload.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        });
		
</script>
