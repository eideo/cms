'use strict';

$(function(){
	// 行业分类
	$('.term li').click(function(){
		$('.term li').removeClass('active');
		$(this).find('a').css('color','#fff');
		$('.h2').removeClass('active');
		$(this).addClass('active');
	})
	$('.h2').click(function(){
		$('.term li').removeClass('active');
		$(this).find('a').css('color','#fff');
		$(this).addClass('active');
	})
	// 购买样式
	$('.buy').mouseover(function(){
		$(this).css('background','#ff4949');
	})
	$('.buy').mouseout(function(){
		$(this).css('background','#ff5a5a');
	})
	$('.shoppingCart').mouseover(function(){
		$(this).addClass('on');
	}).mouseout(function(){
		$(this).removeClass('on');
	})

	// 关注收藏
	$('.attention').click(function(){
		$(this).addClass('hover1');
	})
	$('#col1').click(function(){
		$(this).hide();
		$('#col2').show();
	})
	// 分享按钮
	$('.shareBox').mouseover(function(){
		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('hover3')
	}).mouseout(function(){
		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('hover3')
	})

    // 报告目录
	$('.li').click(function(){
		if($(this).parent().find('.hidden').css('display')=='none'){
			$(this).find('i').addClass('active');
			$(this).parent().find('.hidden').show();
		}else{
			$(this).find('i').removeClass('active');
			$(this).parent().find('.hidden').hide();
		}
		
	})
})
