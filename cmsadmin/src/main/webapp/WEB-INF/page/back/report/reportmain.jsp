<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/common/base.jsp"%>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<table id="grid-table-rm"></table>

		<div id="grid-pager"></div>
		
		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<div id="modal-table-catalog" class="modal fade" tabindex="-1" data-backdrop="static">
	<div class="modal-dialog">
		<input id="oper_type" type="hidden" value="add" />
		<form id="catalogForm">
			<div class="modal-content">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						编辑目录
					</div>
				</div>
				<div class="modal-body" style="max-height: 450px;overflow-y: scroll;">
					<div id="modal-tip" class="red clearfix"></div>
					<input id="reportId" type="hidden" />
					<div class="widget-box widget-color-blue2">
						<div class="widget-body">
							<div class="widget-main padding-8">
								<ul id="catalogTree" class="ztree"></ul>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer no-margin-top">
					<div class="text-center">
						<button class="btn btn-app btn-pink btn-xs" data-dismiss="modal">
							<i class="ace-icon fa fa-share bigger-160"></i>
							取消
						</button>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</form>
	</div><!-- /.modal-dialog -->
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", "${contextPath}/static/assets/js/ajaxfileupload.js", 
		                null,  "${contextPath}/static/zTreeV3/js/jquery.ztree.core-3.5.js", "${contextPath}/static/zTreeV3/js/jquery.ztree.excheck-3.5.js", "${contextPath}/static/zTreeV3/js/jquery.ztree.exedit-3.5.js" ];
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table-rm";
        		var pager_selector = "#grid-pager";

        		// resize to fit page size
        		$(window).on('resize.jqGrid', function() {
        			$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
        		});
        		// resize on sidebar collapse/expand
        		var parent_column = $(grid_selector).closest('[class*="col-"]');
        		$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
        			if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
        				// setTimeout is for webkit only to give time for DOM changes and then redraw!!!
        				setTimeout(function() {
        					$(grid_selector).jqGrid('setGridWidth', parent_column.width());
        				}, 0);
        			}
        		});

        		jQuery(grid_selector).jqGrid({
        			subGrid : false,
        			url : "${contextPath}/sys/reportmain/getReportMain",
        			datatype : "json",
        			height : 450,
        			colNames : ['ID', '图片', '报告', 'PDF报告', '标题', '摘要', '价格', '优惠折扣', '所属行业', '页数', '字数', '是否在售', '标签', '更新时间', '编辑目录'],
        			colModel : [ {
        				name : 'id',
        				index : 'id',
        				label : 'ID',
        				width : 60,
        				sorttype : "long",
        				search : false,
        				hidden : true
        			}, {
        				name : 'reportImage',
        				index : 'reportImage',
        				label : '图片',
        				width : 55,
        				editable : true,
        				editoptions : {enctype: "multipart/form-data"},
        				edittype : 'file',
        				editrules : {required : true},
        				formoptions : {elmsuffix : '<font color="red" id="image_font">*</font>'},
        				search : false,
        				sortable : false,
        				formatter : showReportImage
        			}, {
        				name : 'reportName',
        				index : 'reportName',
        				label : '报告',
        				width : 80,
        				editable : true,
        				editoptions : {enctype: "multipart/form-data"},
        				edittype : 'file',
        				editrules : {required : true},
        				formoptions : {elmsuffix : '<font color="red">*, 请上传以docx结尾的word文档</font>'},
        				searchoptions : {sopt : ['cn']},
        				sortable : false
        			}, {
        				name : 'reportUrl',
        				index : 'reportUrl',
        				label : 'PDF报告',
        				width : 80,
        				editable : true,
        				editoptions : {enctype: "multipart/form-data"},
        				edittype : 'file',
        				editrules : {required : true},
        				formoptions : {elmsuffix : '<font color="red">*, 请上传pdf格式文档</font>'},
        				searchoptions : {sopt : ['cn']},
        				search : false,
        				sortable : false
        			}, {
        				name : 'reportTitle',
        				index : 'reportTitle',
        				label : '标题',
        				width : 90,
        				editable : true,
        				editoptions : {size : "80", maxlength : "200"},
        				//editrules : {required : true, custom : true, custom_func : reportTitleFun},
        				//formoptions : {elmsuffix : '<font color="red">*</font>'},
        				sortable : false,
        				search : false,
        				hidden : true
        			}, {
        				name : 'reportAbstract',
        				index : 'reportAbstract',
        				label : '摘要',
        				width : 100,
        				editable : true,
        				edittype : 'textarea', 
        				editoptions : {rows : "3", cols : "78", maxlength : "500"},
        				editrules : {required : true, custom : true, custom_func : reportAbstractFun},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				sortable : false,
        				search : false
        			}, {
        				name : 'reportPrice',
        				index : 'reportPrice',
        				label : '价格',
        				width : 30,
        				editable : true,
        				editoptions : {size : "20", maxlength : "10"},
        				editrules : {required : true, custom : true, custom_func : reportPriceFun},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				sorttype : "long",
        				search : false
        			}, {
        				name : 'reportDiscount',
        				index : 'reportDiscount',
        				label : '优惠折扣',
        				width : 50,
        				editable : true,
        				editoptions : {size : "20", maxlength : "10"},
        				editrules : {required : false, custom : true, custom_func : reportDiscountFun},
        				formoptions : {elmsuffix : '<font color="red"><br>输入内容如：8.5，代表八五折</font>'},
        				sorttype : "long",
        				search : false
        			}, {
        				name : 'reportInduxtryCn',
        				index : 'reportInduxtry',
        				label : '所属行业',
        				width : 65,
        				editable : true,
        				edittype : "select",
        				// editoptions : {dataUrl : "${contextPath}/sys/reportmain/getReportInduxtrySelectList"},
        				editoptions : {value : "2101:冶金矿产原材料;2102:能源;2103:农林水利;2104:环保;2105:交通运输;2107:医疗卫生;2108:房地产建筑;2111:轻工;2112:化工;2113:机械电子"},
        				sortable : false,
        				search : false
        			}, {
        				name : 'reportPages',
        				index : 'reportPages',
        				label : '页数',
        				width : 30,
        				editable : false,
        				sortable : false,
        				search : false
        			}, {
        				name : 'reportWords',
        				index : 'reportWords',
        				label : '字数',
        				width : 39,
        				editable : false,
        				sortable : false,
        				search : false
        			}, {
        				name : 'reportOnlineFlagCn',
        				index : 'reportOnlineFlag',
        				label : '是否在售',
        				width : 45,
        				sortable : false,
        				editable : true,
        				edittype : "select",
        				editoptions : {value : "1:是;0:否"},
        				search : false
        			}, {
        				name : 'reportTag',
        				index : 'reportTag',
        				label : '标签',
        				width : 60,
        				editable : true,
        				editoptions : {size : "80", maxlength : "200"},
        				sortable : false,
        				search : false,
        				hidden : true
        			}, {
        				name : 'updateTimeCn',
        				index : 'updateTime',
        				label : '更新时间',
        				width : 85,
        				sorttype : "date",
        				search : false
        			}, {
        				name : '',
        				index : '',
        				label : '编辑目录',
        				width : 50,
        				editable : false,
        				search : false,
        				sortable : false,
        				formatter : catalogFormatter
        			} ],
        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        			sortname : "updateTime",
        			sortorder : "desc",
        			viewrecords : true,
        			rowNum : 10,
        			rowList : [ 10, 20, 30 ],
        			pager : pager_selector,
        			altRows : true,
        			//toppager : true,
        			multiselect : true,
        			//multikey : "ctrlKey",
        	        multiboxonly : true,
        			loadComplete : function() {
        				var table = this;
        				setTimeout(function(){
        					styleCheckbox(table);
        					updateActionIcons(table);
        					updatePagerIcons(table);
        					enableTooltips(table);
        				}, 0);
        			},
        			editurl : "${contextPath}/sys/reportmain/operateReportMain"
        			//caption : "用户管理列表",
        			//autowidth : true,
        			/**
        			grouping : true, 
        			groupingView : { 
        				 groupField : ['name'],
        				 groupDataSorted : true,
        				 plusicon : 'fa fa-chevron-down bigger-110',
        				 minusicon : 'fa fa-chevron-up bigger-110'
        			},
        			*/
        		});
        		
        		$(window).triggerHandler('resize.jqGrid');// trigger window resize to make the grid get the correct size
        		
        		// enable search/filter toolbar
        		// jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
        		// jQuery(grid_selector).filterToolbar({});
        		// switch element when editing inline
        		function aceSwitch(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=checkbox]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			}, 0);
        		}

        		function catalogFormatter(cellvalue, options, cell) {
        			var template = "<button data-toggle='modal' onclick='javascript:$(\"#modal-table-catalog\").modal(\"toggle\");$(\"#reportId\").val(\"" + cell.id +"\")' class='btn btn-xs btn-info'><i class='ace-icon fa fa-pencil bigger-120'></i></button>";
        			return template;
        		}

        		var oldTreeNodeName;

        		function beforeDrag(treeId, treeNodes) {
        			return false;
        		}

        		function beforeEditName(treeId, treeNode) {
        			// alert("into beforeEditName, " + treeNode.name);
        			var zTree = $.fn.zTree.getZTreeObj("catalogTree");
        			zTree.selectNode(treeNode);
        			var flag = confirm("Are you sure to edit node " + treeNode.name + "?");
        			return flag;
        		}

        		function beforeRemove(treeId, treeNode) {
        			// alert("into beforeRemove, " + treeNode.name);
        			var zTree = $.fn.zTree.getZTreeObj("catalogTree");
        			zTree.selectNode(treeNode);
        			var flag = confirm("Are you sure to delete node -- " + treeNode.name + "?");
        			return flag;
        		}

        		function onRemove(e, treeId, treeNode) {
        			// alert("into onRemove, " + treeNode.name);
        		}

        		function beforeRename(treeId, treeNode, newName) {
        			// alert("into beforeRename, " + treeNode.name);
        			oldTreeNodeName = treeNode.name;
        			if (newName.length == 0) {
        			   alert("目录名称不能为空，请您输入");
        			   return false;
        			}
        			return true;
        		}

        		function onRename(e, treeId, treeNode) {
        			// alert("into onRename, " + treeNode.id + ", " + treeNode.name);
        			var flag = confirm("确定要修改吗?");
        			if (flag) {
    					$.ajax({
    						url : "${contextPath}/sys/reportmain/updateReportDirectory",
    						data : {
    							'id' : treeNode.id,
    							'dirConext' : treeNode.name
    						},
    						type : "POST",
    						dataType : "json",
    						success : function(data) {
    							if (data.success == true) {
    								alert("修改目录名称成功");
    							} else {
    								var zTree = $.fn.zTree.getZTreeObj("catalogTree");
    		        				treeNode.name = oldTreeNodeName;
    		        				zTree.updateNode(treeNode);
    								alert("修改目录名称失败");
    							}
    							return true;
    						},
    						error : function() {
    							alert("修改目录名称异常");
    						}
    					});
        			} else {
        				var zTree = $.fn.zTree.getZTreeObj("catalogTree");
        				treeNode.name = oldTreeNodeName;
        				zTree.updateNode(treeNode);
        				return flag;
        			}
        		}

				$("#modal-table-catalog").on('shown.bs.modal', function() {
        			// alert("into shown.bs.modal ... ...");
        			var setting = {
						edit: {
							enable: true,
							showRenameBtn: true,
			                showRemoveBtn: false
						},
						data: {
							simpleData: {
								enable: true
							}
						},
						callback: {
							beforeDrag: beforeDrag,
							// beforeEditName: beforeEditName,
							// beforeRemove: beforeRemove,
							beforeRename: beforeRename,
							// onRemove: onRemove,
							onRename: onRename
						}
					};

					$.ajax({
						url : "${contextPath}/sys/reportmain/getReportDirectory",
						data : {
							'reportId' : $("#reportId").val()
						},
						type : "POST",
						dataType : "json",
						success : function(data) {
							var zNodes = data;
							$.fn.zTree.init($("#catalogTree"), setting, zNodes);
						},
						error : function() {
							alert("获取目录结构异常");
						}
					});
        		});

        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : <shiro:hasPermission name="${ROLE_KEY}:reportmain:edit">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:edit">false</shiro:lacksPermission>,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : <shiro:hasPermission name="${ROLE_KEY}:reportmain:add">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:add">false</shiro:lacksPermission>,
        			addicon : 'ace-icon fa fa-plus-circle purple',
        			del : <shiro:hasPermission name="${ROLE_KEY}:reportmain:delete">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:delete">false</shiro:lacksPermission>,
        			delicon : 'ace-icon fa fa-trash-o red',
        			search : <shiro:hasPermission name="${ROLE_KEY}:reportmain:search">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:search">false</shiro:lacksPermission>,
        			searchicon : 'ace-icon fa fa-search orange',
        			refresh : true,
        			refreshicon : 'ace-icon fa fa-refresh blue',
        			view : <shiro:hasPermission name="${ROLE_KEY}:reportmain:view">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:view">false</shiro:lacksPermission>,
        			viewicon : 'ace-icon fa fa-search-plus grey'
        		}, {
        			// edit record form
        			// closeAfterEdit: true,
					top : 100,
					left : 375,
					// height : 600,
					width : 750,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					var result = eval('('+response.responseText+')');
    				    return result.message;
    				},
    				afterSubmit : uploadFile
        		}, {
        			// new record form
					top : 60,
					left : 375,
					// height : 600,
					width : 750,
        			closeAfterAdd : true,
        			recreateForm : true,
        			viewPagerButtons : false,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
        				style_add_form(form);
        			},
    				errorTextFormat: function (response) {
    					var result = eval('('+response.responseText+')');
    				    return result.message;
    				},
    				afterSubmit : uploadFile
        		}, {
        			// delete record form
					top : 300,
					left : 650,
					// height : 600,
					// width : 750,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				if (form.data('styled'))
        					return false;
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
        				style_delete_form(form);
        				form.data('styled', true);
        			},
        			onClick : function(e) {
        				// alert(1);
        			}
        		}, {
        			// search form
					top : 250,
					left : 435,
					// height : 600,
					width : 500,
        			recreateForm : true,
        			afterShowSearch : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
        				style_search_form(form);
        			},
        			afterRedraw : function() {
        				style_search_filters($(this));
        			},
        			multipleSearch : true 
	        		/**
	        		 * multipleGroup:true, showQuery: true
	        		 */
        		}, {
        			// view record form
					top : 60,
					left : 315,
					// height : 600,
					width : 1000,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
        			}
        		});
        		
        		// add custom button to export the data to excel
        		if(<shiro:hasPermission name="${ROLE_KEY}:reportmain:export">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:reportmain:export">false</shiro:lacksPermission>){
    				jQuery(grid_selector).jqGrid('navButtonAdd', pager_selector,{
   					   caption : "",
   				       title : "导出Excel",
   				       buttonicon : "ace-icon fa fa-file-excel-o green", 
   				       onClickButton : function () { 
   				    	   var keys = [], ii = 0, rows = "";
   				    	   var ids = $(grid_selector).getDataIDs(); // Get All IDs
   				    	   var row = $(grid_selector).getRowData(ids[0]); // Get First row to get the labels
   				    	   //var label = $(grid_selector).jqGrid('getGridParam','colNames');
   	   			    	   for (var k in row) {
   				    	   	   keys[ii++] = k; // capture col names
   				    	   	   rows = rows + k + "\t"; // output each Column as tab delimited
   				    	   }
   				    	   rows = rows + "\n"; // Output header with end of line
   				    	   for (i = 0; i < ids.length; i++) {
   				    	   	   row = $(grid_selector).getRowData(ids[i]); // get each row
   				    	   	   for (j = 0; j < keys.length; j++)
   				    	   		   rows = rows + row[keys[j]] + "\t"; // output each Row as tab delimited
   				    	   	   rows = rows + "\n"; // output each row with end of line
   				    	   }
   				    	   rows = rows + "\n"; // end of line at the end
   				    	   var form = "<form name='csvexportform' action='${contextPath}/sys/reportmain/operateReportMain?oper=excel' method='post'>";
   				    	   form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURIComponent(rows) + "'>";
   				    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
   				    	   OpenWindow = window.open('', '');
   				    	   OpenWindow.document.write(form);
   				    	   OpenWindow.document.close();
   				       } 
   					});        			
        		}

        		function style_add_form(form) {
        			// form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        			// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        			// update buttons classes
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>');

        			buttons = form.next().find('.navButton a');
        			buttons.find('.ui-icon').hide();
        			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        			buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
        		}

        		function style_edit_form(form) {
        			// form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        			// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        			// update buttons classes
        			$("#oper_type").val("edit");
        			$("#tr_reportName").attr("hidden", "true");
        			$("#tr_reportUrl").attr("hidden", "true");
        			$("#image_font").html("");
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>');

        			buttons = form.next().find('.navButton a');
        			buttons.find('.ui-icon').hide();
        			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        			buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
        		}

        		function style_delete_form(form) {
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
        			buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>');
        		}

        		function style_search_filters(form) {
        			form.find('.delete-rule').val('X');
        			form.find('.add-rule').addClass('btn btn-xs btn-primary');
        			form.find('.add-group').addClass('btn btn-xs btn-success');
        			form.find('.delete-group').addClass('btn btn-xs btn-danger');
        		}
        		function style_search_form(form) {
        			var dialog = form.closest('.ui-jqdialog');
        			var buttons = dialog.find('.EditTable');
        			buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
        			buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
        			buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
        		}

        		function beforeDeleteCallback(e) {
        			var form = $(e[0]);
        			if (form.data('styled'))
        				return false;
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
        			style_delete_form(form);
        			form.data('styled', true);
        		}

        		function beforeEditCallback(e) {
        			var form = $(e[0]);
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
        			style_add_form(form);
        		}

        		// it causes some flicker when reloading or navigating grid
        		// it may be possible to have some custom formatter to do this as the grid is being created to prevent this
        		// or go back to default browser checkbox styles for the grid
        		function styleCheckbox(table) {
        			/**
        			 * $(table).find('input:checkbox').addClass('ace') .wrap('<label />') .after('<span class="lbl align-top" />') $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
        			 * .find('input.cbox[type=checkbox]').addClass('ace') .wrap('<label />').after('<span class="lbl align-top" />');
        			 */
        		}

        		// unlike navButtons icons, action icons in rows seem to be hard-coded
        		// you can change them like this in here if you want
        		function updateActionIcons(table) {
        			/**
        			 * var replacement = { 'ui-ace-icon fa fa-pencil' : 'ace-icon fa fa-pencil blue', 'ui-ace-icon fa fa-trash-o' : 'ace-icon fa fa-trash-o red', 'ui-icon-disk' : 'ace-icon fa fa-check green', 'ui-icon-cancel' :
        			 * 'ace-icon fa fa-times red' }; $(table).find('.ui-pg-div span.ui-icon').each(function(){ var icon = $(this); var $class = $.trim(icon.attr('class').replace('ui-icon', '')); if($class in replacement)
        			 * icon.attr('class', 'ui-icon '+replacement[$class]); })
        			 */
        		}

        		// replace icons with FontAwesome icons like above
        		function updatePagerIcons(table) {
        			var replacement = {
        				'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
        				'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
        				'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
        				'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
        			};
        			$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
        				var icon = $(this);
        				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        				if ($class in replacement)
        					icon.attr('class', 'ui-icon ' + replacement[$class]);
        			});
        		}

        		function enableTooltips(table) {
        			$('.navtable .ui-pg-button').tooltip({
        				container : 'body'
        			});
        			$(table).find('.ui-pg-div').tooltip({
        				container : 'body'
        			});
        		}

        		// var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');

        		$(document).one('ajaxloadstart.page', function(e) {
        			$(grid_selector).jqGrid('GridUnload');
        			$('.ui-jqdialog').remove();
        		});
        		
        		function showReportImage(cellvalue, options, rowObject) {
        			return "<img src = '${imgPath}/" + cellvalue  + "' height='50' width='50' />";
        		}

        		function uploadFile(response, postdata) {
        			// alert(response.responseText);
        			var data = $.parseJSON(response.responseText);
        		    if (data.success == true) {
        		    	var elementId = ['reportImage', 'reportName', 'reportUrl'];
        		        ajaxFileUpload(elementId, data.id, data.cmd);
        		    }
        		}

        		function ajaxFileUpload(elementId, id, cmd) {
        			// alert("into ajaxFileUpload");
        		    $.ajaxFileUpload({
						url : '${contextPath}/sys/reportmain/uploadFile',
						type : 'post',
  						secureuri : false,
						fileElementId : elementId,
       					dataType : 'json',
						data: {id : id, cmd : cmd},
						success : function (data, status) {
							// alert(data.success + "," + data.message);
							if (typeof (data.success) != 'undefined') {
								if (data.success == true) {
									reloadFun();
								} else if (data.success == 'checkFalse') {
									alert(data.message);
									return false;
								} else {
									alert(data.message);
									return false;
								}
							} else {
								return alert('上传文件失败');
							}
						},
						error : function (data, status, e) {
        		                return alert('系统异常：' + e);
						}
					});
				}

        		function reloadFun() {
        			// $("#editmodgrid-table-rm").hide();
        			$.jgrid.hideModal("#editmodgrid-table-rm", null);
        			$("#grid-table-rm").jqGrid('setGridParam', {
        				url : "${contextPath}/sys/reportmain/getReportMain",
        				datatype : "json"
        			}).trigger("reloadGrid");
        		}

        		function reportPriceFun(value, colname) {
        			var reg = /^(-?\d+)(\.\d+)?$/;
        			if (value == 0 || reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"价格：请填写正确格式"];
        			}
        		}
        		
        		function reportDiscountFun(value, colname) {
        			var reg = /^(-?\d+)(\.\d+)?$/;
        			if (value == 0 || reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"优惠折扣：请填写正确格式"];
        			}
        		}

        		function reportAbstractFun(value, colname) {
        			var operType = $("#oper_type").val();
        			var reportImage = $("#reportImage").val();
        			var reportName = $("#reportName").val();
        			var reportUrl = $("#reportUrl").val();
        			// var reg = /^[a-z\d\u4E00-\u9FA5]+$/;
        			var startIndexDoc = reportName.lastIndexOf(".");
    				var suffixStrDoc = reportName.substring(startIndexDoc, reportName.length).toUpperCase();
    				var startIndexPdf = reportUrl.lastIndexOf(".");
    				var suffixStrPdf = reportUrl.substring(startIndexPdf, reportUrl.length).toUpperCase();
    				if(operType == "add") {
    					/* if (!reg.test(value)) {
             				return [false,"摘要：请填写正确内容"];
             			} else  */
             			if (reportImage == '') {
            				return [false,"图片：请选择需要上传的图片"];
            			} else if (reportName == '') {
            				return [false,"报告：请选择需要上传的报告"];
            			} else if (reportName != '' && suffixStrDoc != ".DOCX") {
            				return [false,"报告：请选择正确格式的报告(以docx结尾的word文档)"];
            			} else if (reportUrl == '') {
            				return [false,"PDF报告：请选择需要上传的PDF报告"];
            			} else if (reportUrl != '' && suffixStrPdf != ".PDF") {
            				return [false,"PDF报告：请选择正确格式的PDF报告(以pdf结尾的文档)"];
            			} else {
            				return [true,""];
            			}
    				} else {
    					/* if (!reg.test(value)) {
             				return [false,"摘要：请填写正确内容"];
             			} else { */
             				return [true,""];
             			//}
    				}
        		}

        	});
        });
</script>
<link rel="stylesheet" href="${contextPath}/static/zTreeV3/css/zTreeStyle/zTreeStyle.css" >