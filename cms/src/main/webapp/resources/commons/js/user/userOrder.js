/* 
* @Author: zhanganchun
* @Date:   2016-02-25 11:14:53
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 11:51:28
*/

'use strict';

$(function() {

	// 主体切换
	$('.order_nav li').click(function(){
		$('.order_nav li').removeClass('active');
		$(this).addClass('active');
		$('.order_box .part').hide();
		$('.order_box .part').eq($(this).index()).show();
	})

		// 购物车标题全选
	$('.selectall').click(function(){
		var num=$('.cart_list li').length-$('.cart_list .failure_info').length;
		if($('.name').find('.on').length!=num){
			$(this).find('i').addClass('on');
			$('.selectall').find('i').addClass('on');
			$('.name i').each(function(){
				$(this).addClass('on');
			})
			$('.account a').addClass('active');
			$('.balance_operation a').addClass('active');
		}else{
			$(this).find('i').removeClass('on');
			$('.selectall').find('i').removeClass('on');
			$('.name i').each(function(i){
				$(this).removeClass('on');
			})
			$('.account a').removeClass('active');
			$('.balance_operation a').removeClass('active');
		}
		total();
	})
	// 删除按钮
	$('.remove').click(function(){
		$(this).parent().parent().remove();
		total();
	})
	$('.removeall').click(function(){
		$('.cart_list .optional').find('.on').parent().parent().remove();
		total();
	})

	// 购物车悬浮框
	$(window).scroll(function(){
		if($(window).scrollTop()>390){
			$('.balance').css('position','static');
		}else{
			$('.balance').css('position','fixed');
		}
	})

	// 下面是我的订单
	// 订单列表移入效果
	$('.order_list .detail').mouseover(function(){
		$(this).find('.border').show();
		$(this).addClass('on');
		$(this).find('a').css('color','#47aaff');
		$(this).find('.stage').css('color','#47aaff');
		$(this).find('.o_price').css('color','#47aaff');
	}).mouseout(function(){
		$(this).find('.border').hide();
		$(this).removeClass('on');
		$(this).find('a').css('color','#5e5e5e');
		$(this).find('.stage').css('color','#a5a5a5');
		$(this).find('.o_price').css('color','#5e5e5e');
	})
	// 列表选择
	var oLinum=$('.order_list li').length;
	$('.select_order').click(function(){
		if($(this).find('.on').length==0){
			$(this).find('i').addClass('on');
			$(this).parent().find('.li_remove').show();
		}else{
			$(this).find('i').removeClass('on');
			$(this).parent().find('.li_remove').hide();
		}
		if($('.select_order').find('.on').length==oLinum){
			$('.select_box .select_all').find('i').addClass('on');
		}
	})
	// 全选联动
	$('.select_box .select_all').click(function(){
		if($(this).find('.on').length==0){
			$(this).find('i').addClass('on');
			$('.select_order i').addClass('on');
			$('.li_remove').show();
		}else{
			$(this).find('i').removeClass('on');
			$('.select_order i').removeClass('on');
			$('.li_remove').hide();
		}
	})
	// 全部删除功能
	$('.remove_all').click(function(){
		$('.select_order .on').parent().parent().parent().remove();
	})
	// 单独删除功能
	$('.li_remove').click(function(){
		$(this).parent().parent().remove();
	})


	// 信息类别切换
	$('.p_name').click(function(){
		if($(this).find('ul').css('display')=='none'){
			$(this).find('ul').show();
		}else{
			$(this).find('ul').hide();
		}	
	})
	$('.p_name li').click(function(){
		$(this).parent().parent().find('span').text($(this).text());
	})
	changeType('xiangmu_type','order_list','xiangmu');
	changeType('zhaobiao_type','order_list','zhaobiao');
	changeType('zhongbiao_type','order_list','zhongbiao');
	$('.all_type').click(function(){
		$('.order_list li').show();
	})

})
    