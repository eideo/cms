'use strict';

$(function(){
	// 整体切换
	$('.sign li').click(function(){
		$('.sign li').removeClass('active');
		$('.sign li').find('a').removeClass('active');
		$('.aclass').hide();
		$(this).addClass('active');
		$(this).find('a').addClass('active');
		$('.aclass').eq($(this).index()).show();
		$('title').text($(this).text());
	})
})
