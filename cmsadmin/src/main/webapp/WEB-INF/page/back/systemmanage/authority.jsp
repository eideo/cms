<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/common/base.jsp"%>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<table id="grid-table-authority"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table-authority";
        		var pager_selector = "#grid-pager";

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
        			url : "${contextPath}/sys/authority/getAuthority",
        			datatype : "json",
        			height : 450,
        			colNames : ['ID', '资源编码', '资源名称', '资源url属性值', '序列', '上级资源编码', '资源类型', '操作权限', '资源状态', '操作'],
        			colModel : [ {
        				name : 'id',
        				index : 'id',
        				label : 'ID',
        				width : 30,
        				sorttype : "long",
        				search : false,
        				hidden : true
        			}, {
        				name : 'resourceCode',
        				index : 'resourceCode',
        				label : '资源编码',
        				width : 100,
        				editable : true,
        				editoptions : {size : "27", maxlength : "60"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				searchoptions : {sopt : ['eq']},
        				editrules : {required : true, custom : true, custom_func : resourceCodeRuleFun}
        			}, {
        				name : 'resourceName',
        				index : 'resourceName',
        				label : '资源名称',
        				width : 100,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "60"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true, custom : true, custom_func : resourceNameRuleFun}
        			}, {
        				name : 'resourceUrl',
        				index : 'resourceUrl',
        				label : '资源url属性值',
        				width : 100,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "100"},
        				formoptions : {elmsuffix : '<font color="red">*<br>如果资源类型选择菜单，请输入 #</font>'},
        				editrules : {required : true, custom : true, custom_func : resourceUrlRuleFun},
        				search : false
        			}, {
        				name : 'sequence',
        				index : 'sequence',
        				label : '序列',
        				width : 40,
        				editable : true,
        				sorttype : "long",
        				search : false,
        				editoptions : {size : "27", maxlength : "10"},
        				editrules : {number : true}
        			}, {
        				name : 'parentResourceCode',
        				index : 'parentResourceCode',
        				label : '上级资源编码',
        				width : 100,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "60", title : "如果没有上级，不填即可"},
        				formoptions : {elmsuffix : '<font color="red"><br>如果没有上级，请输入: 0</font>'},
        				search : false
        			}, {
        				name : 'resourceTypeCn',
        				index : 'resourceType',
        				label : '资源类型',
        				width : 50,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {value : "1:菜单;0:页面"},
        				search : false
        			}, {
        				name : 'operAuthority',
        				index : 'operAuthority',
        				label : '操作权限',
        				width : 100,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "64"},
        				formoptions : {elmsuffix : '<font color="red">*<br>新增:add;编辑:edit;删除:delete;查看:view;搜索:search;导出:export。<br>输入内容如 add,edit,delete,view,search,export 以逗号拼接</font>'},
        				editrules : {required : true},
        				search : false
        			}, {
        				name : 'statusCn',
        				index : 'status',
        				label : '资源状态',
        				width : 50,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {value : "1:启用;0:未启用;2:暂停使用;3:废弃"},
        				search : false
        			}, {
        				name : '',
        				index : '',
        				width : 70,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				search : false,
        				formatter : 'actions',
        				formatoptions : {
        					keys : true,
        					editbutton : <shiro:hasPermission name="${ROLE_KEY}:authority:edit">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:edit">false</shiro:lacksPermission>,
        					delbutton : <shiro:hasPermission name="${ROLE_KEY}:authority:delete">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:delete">false</shiro:lacksPermission>
        				}
        			} ],
        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        			sortname : "id",
        			sortorder : "asc",
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
        			editurl : "${contextPath}/sys/authority/operateAuthority"
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
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : <shiro:hasPermission name="${ROLE_KEY}:authority:edit">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:edit">false</shiro:lacksPermission>,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : <shiro:hasPermission name="${ROLE_KEY}:authority:add">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:add">false</shiro:lacksPermission>,
        			addicon : 'ace-icon fa fa-plus-circle purple',
        			del : <shiro:hasPermission name="${ROLE_KEY}:authority:delete">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:delete">false</shiro:lacksPermission>,
        			delicon : 'ace-icon fa fa-trash-o red',
        			search : <shiro:hasPermission name="${ROLE_KEY}:authority:search">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:search">false</shiro:lacksPermission>,
        			searchicon : 'ace-icon fa fa-search orange',
        			refresh : true,
        			refreshicon : 'ace-icon fa fa-refresh blue',
        			view : <shiro:hasPermission name="${ROLE_KEY}:authority:view">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:view">false</shiro:lacksPermission>,
        			viewicon : 'ace-icon fa fa-search-plus grey'
        		}, {
        			// edit record form
        			// closeAfterEdit: true,
					top : 115,
					left : 435,
					// height : 600,
					width : 500,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					var result = eval('('+response.responseText+')');
    				    return result.message;
    				}
        		}, {
        			// new record form
					top : 115,
					left : 435,
					// height : 600,
					width : 500,
        			closeAfterAdd : true,
        			recreateForm : true,
        			viewPagerButtons : false,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        				style_edit_form(form);
        			},
    				errorTextFormat: function (response) {
    					var result = eval('('+response.responseText+')');
    				    return result.message;
    				}
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
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
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
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
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
					top : 115,
					left : 435,
					// height : 600,
					width : 500,
        			recreateForm : true,
        			beforeShowForm : function(e) {
        				var form = $(e[0]);
        				form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
        			}
        		})
        		
        		// add custom button to export the data to excel
        		if(<shiro:hasPermission name="${ROLE_KEY}:authority:export">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:authority:export">false</shiro:lacksPermission>){
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
     			    	   var form = "<form name='csvexportform' action='${contextPath}/sys/authority/operateAuthority?oper=excel' method='post'>";
     			    	   form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURIComponent(rows) + "'>";
     			    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
     			    	   OpenWindow = window.open('', '');
     			    	   OpenWindow.document.write(form);
     			    	   OpenWindow.document.close();
     			       } 
     				});
        		}
        		
        		function buttonAuthorityFormatter(cellvalue, options, cell) {
        			var template = "<button data-toggle='modal' onclick='javascript:$(\"#button-modal-table\").modal(\"toggle\");$(\"#resourceCodeId\").val(\"" + cell.resourceCode +"\")' class='btn btn-xs btn-warning'><i class='ace-icon fa fa-flag bigger-120'></i></button>";
        			if(cell.parentResourceCode == "0"){
        				return "";
        			}else{
        				return template;
        			}
        		}
        		
        		function style_edit_form(form) {
        			// form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
        			// don't wrap inside a label element, the checkbox value won't be submitted (POST'ed)
        			// .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        			// update buttons classes
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-primary').prepend('<i class="ace-icon fa fa-check"></i>');
        			buttons.eq(1).prepend('<i class="ace-icon fa fa-times"></i>')

        			buttons = form.next().find('.navButton a');
        			buttons.find('.ui-icon').hide();
        			buttons.eq(0).append('<i class="ace-icon fa fa-chevron-left"></i>');
        			buttons.eq(1).append('<i class="ace-icon fa fa-chevron-right"></i>');
        		}

        		function style_delete_form(form) {
        			var buttons = form.next().find('.EditButton .fm-button');
        			buttons.addClass('btn btn-sm btn-white btn-round').find('[class*="-icon"]').hide();// ui-icon, s-icon
        			buttons.eq(0).addClass('btn-danger').prepend('<i class="ace-icon fa fa-trash-o"></i>');
        			buttons.eq(1).addClass('btn-default').prepend('<i class="ace-icon fa fa-times"></i>')
        		}

        		function style_search_filters(form) {
        			form.find('.delete-rule').val('X');
        			form.find('.add-rule').addClass('btn btn-xs btn-primary');
        			form.find('.add-group').addClass('btn btn-xs btn-success');
        			form.find('.delete-group').addClass('btn btn-xs btn-danger');
        		}
        		function style_search_form(form) {
        			var dialog = form.closest('.ui-jqdialog');
        			var buttons = dialog.find('.EditTable')
        			buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'ace-icon fa fa-retweet');
        			buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'ace-icon fa fa-comment-o');
        			buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'ace-icon fa fa-search');
        		}

        		function beforeDeleteCallback(e) {
        			var form = $(e[0]);
        			if (form.data('styled'))
        				return false;
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        			style_delete_form(form);
        			form.data('styled', true);
        		}

        		function beforeEditCallback(e) {
        			var form = $(e[0]);
        			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        			style_edit_form(form);
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
        			})
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
        		
        		function resourceCodeRuleFun(value, colname) {
        			var reg = /^[A-Za-z0-9]+$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"资源编码: 必须是由英文字母和数字组成的字符串"];
        			}
        		}
        		
        		function resourceNameRuleFun(value, colname) {
        			var reg = /^[\u4e00-\u9fa5]{2,60}$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"资源名称: 请填写正确的资源名称（汉字）"];
        			}
        		}
        		
        		function resourceUrlRuleFun(value, colname) {
        			var reg = /^[A-Za-z0-9]|[/#]+$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"资源url属性值: 请填写正确的资源url属性"];
        			}
        		}
        	});
        });
</script>
