<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/common/base.jsp"%>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<table id="grid-table-cbr"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
		function reloadFun() {
			$("#grid-table-cbr").jqGrid('setGridParam', {
				page : 1,
				url : "${contextPath}/sys/custbehavior/getCustBehaviorRedis",
				datatype : "json"
			}).trigger("reloadGrid");
		}

		var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
    			// 间隔时间5000毫秒
    			var intervalTime = 5000;

        		var grid_selector = "#grid-table-cbr";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
        		})
        		// resize on sidebar collapse/expand
        		var parent_column = $(grid_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(grid_selector).jqGrid('setGridWidth', parent_column.width());
        				}, 0);
        			}
        		})

        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/custbehavior/getCustBehaviorRedis",
        			datatype : "json",
        			height : 450,
        			colNames : ['ID', '用户ID', '登录名', '用户名称', 'IP', '行为类型', '信息ID', '信息名称', '操作时间'],
        			colModel : [{
        				name : 'id',
        				index : 'id',
        				label : 'ID',
        				width : 60,
        				sortable : false,
        				search : false,
        				hidden : true
        			}, {
        				name : 'userId',
        				index : 'userId',
        				label : '用户ID',
        				width : 60,
        				sorttype : "long",
        				search : false
        			}, {
        				name : 'loginId',
        				index : 'loginId',
        				label : '登录名',
        				width : 80,
        				searchoptions : {sopt : ['cn']},
        				sortable : false
        			}, {
        				name : 'custName',
        				index : 'custName',
        				label : '用户名称',
        				width : 80,
        				sortable : false,
        				search : false
        			}, {
        				name : 'ip',
        				index : 'ip',
        				label : 'IP',
        				width : 70,
        				sortable : false,
        				search : false
        			}, {
        				name : 'actionTypeCn',
        				index : 'actionType',
        				label : '行为类型',
        				width : 55,
						search : false,
        				sortable : false
        			}, {
        				name : 'infoId',
        				index : 'infoId',
        				label : '信息ID',
        				width : 65,
        				sortable : false,
        				search : false
        			}, {
        				name : 'infoName',
        				index : 'infoName',
        				label : '信息名称',
        				width : 150,
        				sortable : false,
        				search : false
        			}, {
        				name : "actionDateCn",
        				index : "actionDate",
        				label : "操作时间",
        				width : 90,
        				sortable : false,
        				search : false
        			} ],
        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        			sortname : "id",
        			sortorder : "desc",
        			viewrecords : true,
        			rowNum : 10,
        			rowList : [ 10, 20, 30 ],
        			altRows : true,
        			//toppager : true,
        			multiselect : true,
        			//multikey : "ctrlKey",
        	        multiboxonly : true,
        			loadComplete : function() {
        				
        			},
        			editurl : ""
        		});
        		
        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size

    			setInterval('reloadFun()', intervalTime);
        	});
        });
</script>
