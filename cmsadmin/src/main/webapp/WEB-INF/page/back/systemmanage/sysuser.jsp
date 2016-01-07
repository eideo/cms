<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/common/base.jsp"%>

<link rel="stylesheet" href="${contextPath}/static/assets/css/jquery-ui.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/datepicker.css" />
<link rel="stylesheet" href="${contextPath}/static/assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<table id="grid-table-sysuser"></table>

		<div id="grid-pager"></div>

		<script type="text/javascript">
			var $path_base = "${contextPath}/static";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
		var scripts = [ null, "${contextPath}/static/assets/js/date-time/bootstrap-datepicker.js", "${contextPath}/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js", "${contextPath}/static/assets/js/jqGrid/jquery.jqGrid.js", "${contextPath}/static/assets/js/jqGrid/i18n/grid.locale-cn.js", null ]
        $('.page-content-area').ace_ajax('loadScripts', scripts, function() {
        	// inline scripts related to this page
        	jQuery(function($) {
        		var grid_selector = "#grid-table-sysuser";
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
        			url : "${contextPath}/sys/sysuser/getSysUser",
        			datatype : "json",
        			height : 450,
        			colNames : ['ID', '用户名', '姓名', '性别', '出生日期', '是否为管理员', '所属系统', '手机', '邮箱', '是否禁用', '所属部门', '角色', '最后登录时间', '操作'],
        			colModel : [ {
        				name : 'id',
        				index : 'id',
        				label : 'ID',
        				width : 45,
        				sorttype : "long",
        				search : false,
        				hidden : true
        			}, {
        				name : 'loginId',
        				index : 'loginId',
        				label : '用户名',
        				width : 65,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "20"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true, custom : true, custom_func : loginIdRuleFun}
        			}, {
        				name : 'custName',
        				index : 'custName',
        				label : '姓名',
        				width : 55,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "10"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				searchoptions : {sopt : ['cn']},
        				editrules : {required : true, custom : true, custom_func : custNameRuleFun}
        			}, {
        				name : 'sexCn',
        				index : 'sex',
        				label : '性别',
        				width : 40,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {value : "N:男;Y:女"},
        				search : false
        			}, {
        				name : 'custBirthdayCn',
        				index : 'custBirthday',
        				label : '出生日期',
        				width : 65,
        				editable : true,
        				editoptions : {size : "27", maxlength : "10"},
        				readonly : true,
        				search : false,
        				sorttype : 'date',
        				unformat : pickDate
        			}, {
        				name : 'isAdminCn',
        				index : 'isAdmin',
        				label : '是否为管理员',
        				width : 75,
        				editable : false,
        				sortable : false,
        				search : false
        			}, {
        				name : 'belongCn',
        				index : 'belong',
        				label : '所属系统',
        				width : 60,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {value : "1:后台系统;0:前台系统"},
        				stype : 'select',
        				searchoptions : {sopt : ['eq'], value : "1:后台系统;0:前台系统"}
        			}, {
        				name : 'mobilePhone',
        				index : 'mobilePhone',
        				label : '手机',
        				width : 70,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "11"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				search : false,
        				editrules : {required : true, custom : true, custom_func : mobilePhoneRuleFun}
        			}, {
        				name : 'custEmail',
        				index : 'custEmail',
        				label : '邮箱',
        				width : 140,
        				editable : true,
        				sortable : false,
        				editoptions : {size : "27", maxlength : "50"},
        				formoptions : {elmsuffix : '<font color="red">*</font>'},
        				search : false,
        				editrules : {required : true, custom : true, custom_func : custEmailRuleFun}
        			}, {
        				name : 'custStatusCn',
        				index : 'custStatus',
        				label : '是否禁用',
        				width : 60,
        				editable : true,
        				sortable : false,
        				edittype : "checkbox",
        				editoptions : {value : "是:否"},
        				unformat : aceSwitch,
        				search : false
        			}, {
        				name : 'deptName',
        				index : 'deptId',
        				label : '所属部门',
        				width : 60,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {
        					dataUrl : "${contextPath}/sys/department/getDepartmentSelectList"
        				},
        				search : false
        			}, {
        				name : 'roleName',
        				index : 'role',
        				label : '角色',
        				width : 60,
        				editable : true,
        				sortable : false,
        				edittype : "select",
        				editoptions : {
        					dataUrl : "${contextPath}/sys/role/getRoleSelectList"
        				},
        				search : false
        			}, {
        				name : 'lastLoginTimeCn',
        				index : 'lastLoginTime',
        				label : '最后登录时间',
        				width : 100,
        				sorttype : "date",
        				search : false
        			}, {
        				name : '',
        				index : '',
        				width : 65,
        				fixed : true,
        				sortable : false,
        				resize : false,
        				search : false,
        				formatter : 'actions',
        				formatoptions : {
        					keys : true,
        					editbutton : <shiro:hasPermission name="${ROLE_KEY}:sysuser:edit">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:edit">false</shiro:lacksPermission>,
        					delbutton : <shiro:hasPermission name="${ROLE_KEY}:sysuser:delete">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:delete">false</shiro:lacksPermission>
        				}
        			} ],
        			//scroll : 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        			sortname : "id",
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
        			editurl : "${contextPath}/sys/sysuser/operateSysUser"
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
        		
        		// enable datepicker
        		function pickDate(cellvalue, options, cell) {
        			setTimeout(function() {
        				$(cell).find('input[type=text]').datepicker({
        					format : 'yyyy-mm-dd',
        					autoclose : true,
        				    language: 'zh-CN'
        				});
        			}, 0);
        		}
        		
        		// navButtons
        		jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar options
        			edit : <shiro:hasPermission name="${ROLE_KEY}:sysuser:edit">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:edit">false</shiro:lacksPermission>,
        			editicon : 'ace-icon fa fa-pencil blue',
        			add : <shiro:hasPermission name="${ROLE_KEY}:sysuser:add">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:add">false</shiro:lacksPermission>,
        			addicon : 'ace-icon fa fa-plus-circle purple',
        			del : <shiro:hasPermission name="${ROLE_KEY}:sysuser:delete">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:delete">false</shiro:lacksPermission>,
        			delicon : 'ace-icon fa fa-trash-o red',
        			search : <shiro:hasPermission name="${ROLE_KEY}:sysuser:search">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:search">false</shiro:lacksPermission>,
        			searchicon : 'ace-icon fa fa-search orange',
        			refresh : true,
        			refreshicon : 'ace-icon fa fa-refresh blue',
        			view : <shiro:hasPermission name="${ROLE_KEY}:sysuser:view">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:view">false</shiro:lacksPermission>,
        			viewicon : 'ace-icon fa fa-search-plus grey'
        		}, {
        			// edit record form
        			// closeAfterEdit: true,
					top : 75,
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
					top : 75,
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
					top : 75,
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
        		if(<shiro:hasPermission name="${ROLE_KEY}:sysuser:export">true</shiro:hasPermission><shiro:lacksPermission name="${ROLE_KEY}:sysuser:export">false</shiro:lacksPermission>){
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
   				    	   var form = "<form name='csvexportform' action='${contextPath}/sys/sysuser/operateSysUser?oper=excel' method='post'>";
   				    	   form = form + "<input type='hidden' name='csvBuffer' value='" + encodeURIComponent(rows) + "'>";
   				    	   form = form + "</form><script>document.csvexportform.submit();</sc" + "ript>";
   				    	   OpenWindow = window.open('', '');
   				    	   OpenWindow.document.write(form);
   				    	   OpenWindow.document.close();
   				       } 
   					});
        		}
        		
        		function style_edit_form(form) {
        			// enable datepicker on "birthday" field and switches for "stock" field
        			form.find('input[name=custBirthdayCn]').datepicker({
        				format : 'yyyy-mm-dd',
        				autoclose : true,
        			    language: 'zh-CN'
        			})

        			form.find('input[name=statusCn]').addClass('ace ace-switch ace-switch-5').after('<span class="lbl"></span>');
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
        		
        		function loginIdRuleFun(value, colname) {
        			var reg = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._-]){3,19}$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"用户名: 必须是4-20位以字母开头、可带数字、“-”、“_”、“.”的字符串"];
        			}
        		}
        		
        		function custNameRuleFun(value, colname) {
        			var reg = /^[\u4e00-\u9fa5]{2,10}$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"姓名: 请填写真实的姓名（汉字）"];
        			}
        		}
        		
        		function mobilePhoneRuleFun(value, colname) {
        			var reg = /^0?(13|15|18|14|17)[0-9]{9}$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"手机: 格式有误，请填写正确的手机"];
        			}
        		}
        		
        		function custEmailRuleFun(value, colname) {
        			var reg = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
        			if (reg.test(value)) {
        				return [true,""];
        			} else {
        				return [false,"邮箱: 格式有误，请填写正确的邮箱"];
        			}
        		}
        	});
        });
</script>
