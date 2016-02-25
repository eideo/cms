/* 
* @Author: zhanganchun
* @Date:   2016-02-19 14:48:15
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-22 14:24:04
*/

'use strict';

var maskShow = function() {

	$('.mask').show()
	$('.mform').show()
}

var maskHide = function() {

	$('.mask').hide()
	$('.mform').hide()
}

$(function() {

	$('.list li').hover(function(){

		$(this).find('.hidden').show().stop().slideDown('slow')
	},function(){

		$(this).find('.hidden').stop().slideUp().hide()
	})
/*
	$('.sList li').hover(function(){

		$(this).find('.sMask').show()
		$(this).find('.hidden').show().stop().slideDown('slow')
	},function(){

		$(this).find('.sMask').hide()
		$(this).find('.hidden').stop().slideUp().hide()
	})*/

	$('.mform i').on('click',function(e) {

		maskHide()
	})

	$('.btn,#btn').on('click',function() {

		maskShow()
	})

	$('.control li').on('click',function() {

		var index = $(this).index();

		$(this).addClass('on').siblings().removeClass('on')
		
		if (index === 0) {
			$('.sList li:lt(4)').show()
		} else {
			$('.sList li:lt(4)').hide()
		}
	})

	$('.contact h2 i').click(function() {

	})

})