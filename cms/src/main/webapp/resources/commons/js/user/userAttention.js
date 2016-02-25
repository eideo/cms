/* 
* @Author: zhanganchun
* @Date:   2016-02-25 08:38:19
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 10:30:44
*/

'use strict';

function userAttention() {

	$('.message_list').on("click", ".ap", function() {

		var actiontype = $(this).attr("actiontype");
		var infotype = $(this).attr("infotype");
		var infoid = $(this).attr("infoid");

		if ($(this).find('.re').css('display') == 'none') {

			var status = custBehavior(actiontype, infotype, infoid, 3);

			// 已登录
			if (status == 0) {

				$(this).find('i').addClass('active1');
				$(this).find('span').hide();
				$(this).find('.re').show();

				// 未登录
			} else if (status == -1) {

				$('.login_box').show();
				$('.shadow').show();
			} else if (status == -2) {

				alert("请求异常");
			}

		} else {

			var status = custBehavior(actiontype, infotype, infoid, 0);

			// 已登录
			if (status == 0) {

				$(this).find('i').removeClass('active1');
				$(this).find('span').show();
				$(this).find('.re').hide();
				// 未登录
			} else if (status == -1) {

				$('.login_box').show();
				$('.shadow').show();
			} else if (status == -2) {

				alert("请求异常");
			}
		}
	});
}

var tabHover = function() {

	// 所有按钮移入变色
	$('.hover').mouseover(function() {

		$(this).addClass('on');
	}).mouseout(function() {

		$(this).removeClass('on');
	});
}

$(function() {

	tabHover();
	userAttention();
	
})