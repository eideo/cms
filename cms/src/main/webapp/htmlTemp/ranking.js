'use strict';

$(function(){
	// 左边切换
	$('.btn1').click(function(){
		$(this).addClass('active');
		$('.tab1').toggle();
	})
	$('.btn2').click(function(){
		$('.tab2').toggle();
	})
	$('.btn3').click(function(){
		$('.tab3').toggle();
	})

	// 右边大切换
	$('#c_btn li').click(function(){
		$('#c_btn li').removeClass('active');
		$('.part').hide();
		$(this).addClass('active');
		$('.part').eq($(this).index()).show();
	})
	//li移入背景变色
	$('.part li').mouseover(function(){
		$('.part li').css('background','#fff');
		$(this).css('background','#f6f6f6');
	})
	// 指数排序
	$('.index').click(function(){
		$('.index div').toggle();
	})
	$('.lift').click(function(){
		$('.lift div').toggle();
	})
	$('.bar p').mouseover(function(){
		$('.bar p').css('color','#c9c9c9');
		$(this).css('color','#0a8dff');
	})
})
