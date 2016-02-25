'use strict';

$(function(){
	// 相关推荐切换
	$('.btn li').click(function(){
		$('.btn li').css('color','#5e5e5e');
		$(this).css('color','#0a8dff');
		$('.btn i').css('display','none')
		$('.btn i').eq($(this).index()).css('display','block');
		$('.tuijian ol').css('display','none')
		$('.tuijian ol').eq($(this).index()).css('display','block');
	})

	$('.btn2 li').click(function(){
		$('.btn2 li').css('color','#5e5e5e');
		$(this).css('color','#0a8dff');
		$('.btn2 i').css('display','none')
		$('.btn2 i').eq($(this).index()).css('display','block');
		$('.tuijian2 ol').css('display','none')
		$('.tuijian2 ol').eq($(this).index()).css('display','block');
	})
	$('.btn3 li').click(function(){
		$('.btn3 li').css('color','#5e5e5e');
		$(this).css('color','#0a8dff');
		$('.btn3 i').css('display','none')
		$('.btn3 i').eq($(this).index()).css('display','block');
		$('.tuijian3 ol').css('display','none')
		$('.tuijian3 ol').eq($(this).index()).css('display','block');
	})


})
