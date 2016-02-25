/* 
* @Author: zhanganchun
* @Date:   2016-02-25 08:31:28
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 08:34:20
*/

'use strict';

var slideAfter = function() {

	$('.update_box button').mouseover(function(){
		$('.update_box button').removeClass('on');
		$(this).addClass('on');
	}).mouseout(function(){
		$(this).removeClass('on');
	})
	// 修改切换
	$('.re_box a').click(function(){
		var oLi=$(this).parent().parent();
		if(oLi.find('.update_box').css('display')=='none'){
			$(this).text('取消修改');
			oLi.find('.update_box').show();
		}else{
			$(this).text('修改');
			oLi.find('.update_box').hide();
		}
	})
}

$(function() {

	slideAfter()
})