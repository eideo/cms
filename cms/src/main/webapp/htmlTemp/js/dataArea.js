/* 
* @Author: Administrator
* @Date:   2015-12-07 11:22:50
* @Last Modified by:   Administrator
* @Last Modified time: 2015-12-07 17:15:51
*/

'use strict';

$(function() {
	
	$('.dataTab > ul > li').on('click',function(e) {

		var e = e || window.event

		$(this).addClass('selected').siblings().removeClass('selected')
	})

	$('.time').find('i').on('click',function(e) {
		
		var e = e || window.event,
			$dataWindow = $('.dataWindow'),
			height = $dataWindow.height()

		if (height === 0) {

			$dataWindow.stop().animate({height:'180px'},500)
		} else {

			$dataWindow.stop().animate({height:'0px'},500)
		}	
	})

	// TODO 待添加逻辑
	var setTime = function (year,month) {

		if (month < 10) {

			month = '0'+month
		}

		var time = year+'.'+month
		var selected = $('.dataTab>ul>li').eq(0).hasClass('selected')
		
		if (selected) {

			$('.innerTime .start').html(time)
		} else {

			$('.innerTime .end').html(time)
		}	
	}

	$('.liYear').on('click',function(e) {

		var e = e || window.event,
			year = parseInt($(this).html()),
			month = parseInt($('.dMonth').find('.selected').html())

		$(this).addClass('selected').siblings().removeClass('selected')
		setTime(year,month)
	})

	$('.liMonth').on('click',function(e) {

		var e = e || window.event,
			year = parseInt($('.dYear').find('.selected').html()),
			month = parseInt($(this).html())

		$(this).addClass('selected').siblings().removeClass('selected')
		setTime(year,month)
	})

	// 信息类型分布时间拖动滑块	
	
})