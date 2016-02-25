/* 
* @Author: zhanganchun
* @Date:   2016-02-25 08:45:51
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 15:58:18
*/

'use strict';

function footListHover() {

	$('.message_list li').mouseover(function() {

		$(this).find('.f_border').show();
		$(this).find('.f_remove').show();
		$(this).addClass('on');
	}).mouseout(function() {

		$(this).find('.f_border').hide();
		$(this).find('.f_remove').hide();
		$(this).removeClass('on');
	});
}

// 我的足迹信息分类切换
function changeTrade(id,aclass) {

	$('#'+id).click(function() {

		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active');
		$('.message_list li').hide();
		// $(this).parent().parent().find('.'+aclass).parent().parent().show();
		$(this).parent().parent().find('.'+aclass).show();
	});
}

function deleteById(id) {

	var elementId = "#remove_" + id;
	var flag = confirm("您确定要删除吗?");

	if(flag) {

		var url = path + "/personal/delete";
		$.ajax({
			url : url,
			data : {
				'id' : id
			},
			type : "POST",
			dataType : "json",
			success : function(data) {

				if(data.success == true) {

					$(elementId).parent().remove();
				}
			},
			error : function() {

				alert("删除失败");
			}
		});
	}
}

function deleteByDate(actionType, infoValid, date) {

	var elementId = "#remove_date_" + date;
	var infoType = $("#info_type").val();
	// alert("infoType = " + infoType);
	var flag = confirm("您确定要删除该日期下的足迹吗?");
	if(flag) {

		var url = path + "/personal/deleteByDate";
		$.ajax({
			url : url,
			data : {
				'actionType' : actionType,
				'infoType' : infoType,
				'infoValidWhere' : infoValid,
				'actionDateWhere' : date
			},
			type : "POST",
			dataType : "json",
			success : function(data) {

				if(data.success == true) {

					$(elementId).parent().parent().remove();
				}
			},
			error : function() {

				alert("删除失败");
			}
		});
	}
}

$(function() {

	// 我的足迹信息列表移入移出效果
	footListHover();
})