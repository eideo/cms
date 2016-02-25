'use strict';

$(function(){
	// 所有按钮移入变色
	$('.hover').mouseover(function(){
		$(this).addClass('on');
	}).mouseout(function(){
		$(this).removeClass('on');
	})
	// 整体切换
	$('.personal_center li').click(function(){
		$('.location').text($(this).text());
		$('.personal_center li').removeClass('active');
		$('.asset_center li').removeClass('active');
		$(this).addClass('active');
		$('.personalBox .section').hide();
		$('.assetBox .section').hide();
		$('.personalBox .section').eq($(this).index()).show();
	})

	$('.asset_center li').click(function(){
		$('.asset_center li').removeClass('active');
		$('.personal_center li').removeClass('active');
		$(this).addClass('active');
		$('.personalBox .section').hide();
		$('.assetBox .section').hide();
		$('.assetBox .section').eq($(this).index()).show();
	})
	// 左侧折叠切换
	$('.sign h4').click(function(){
		if($(this).parent().find('ul').css('display')=='block'){
			$(this).parent().find('ul').hide();
		}else{
			$(this).parent().find('ul').show();
		}
		
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
	// 删除失效信息
	$('.remove_Invalid').click(function(){
		$('.failure_info').remove();
	})
	// 购物车信息类别切换
	$('.project').click(function(){
		if($(this).find('ul').css('display')=='none'){
			$(this).find('ul').show();
		}else{
			$(this).find('ul').hide();
		}
	})
	$('.project li').click(function(){
		$(this).parent().parent().find('span').text($(this).text());
	})
	changeType('xiangmu_type','cart_list','xiangmu');
	changeType('zhaobiao_type','cart_list','zhaobiao');
	changeType('zhongbiao_type','cart_list','zhongbiao');
	$('.project .all_type').click(function(){
		$('.cart_list li').show();
	})
	

	// 购物车收藏
	$('.operation .collection').click(function(){
		$(this).hide();
		$(this).parent().find('.collection2').show();
		$(this).parent().find('.collection2').css('color','#ff5a5a');
	})
	// 购物车列表选择
	var aLi=$('.optional').length-1;
	$('.check').click(function(){
		var oLi=$(this).parent().parent();
		if(oLi.find('.on').length==0){
			oLi.find('.check').addClass('on');
		}else{
			oLi.find('.check').removeClass('on');
		}
		if($('.name').find('.on').length==aLi){
			$('.selectall').find('i').addClass('on');
		}else{
			$('.selectall').find('i').removeClass('on');
		}
		$('.account a').addClass('active');
		$('.balance_operation a').addClass('active');
		total();
	})
	$('.cart_list .optional').mouseover(function(){
		$(this).find('.border').show();
		$(this).addClass('on');
		$(this).find('.name').find('a').css('color','#47aaff');
		$(this).find('span').css('color','#47aaff');	
	}).mouseout(function(){
		$(this).find('.border').hide();
		$(this).removeClass('on');
		$(this).find('.name').find('a').css('color','#5e5e5e');
		$(this).find('span').css('color','#5e5e5e');
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
	// 收藏
	$('.order_list').on("click", ".collection", function() {
		if($(this).find('span').css('display')=='none'){
			$(this).find('i').addClass('active');
			$(this).css('color','#ff5a5a');
			$(this).find('span').show();
		}else{
			$(this).find('i').removeClass('active');
			$(this).css('color','#a5a5a5');
			$(this).find('span').hide();
		}
		
	})

	// 分享
	$('.order_list').on("mouseover", ".sp", function() {
			$(this).find('.share').css('color','#ff5a5a');
			$(this).find('i').addClass('active');
			$(this).find('em').show();
			$(this).find('div').show();
		}).on("mouseout", ".sp", function() {
			$(this).find('i').removeClass('active');
			$(this).find('em').hide();
			$(this).find('div').hide();
		});
		// 关闭登录框
		$('.close').click(function() {
			$('.login_box').hide();
			$('.shadow').hide();
		});

	// 评论
	$('.order_list').on("click", ".comment", function() {
		if($(this).parent().parent().parent().find('.comment_box').css('display')=='none'){
			$(this).parent().parent().parent().find('.comment_box').show();
		}else{
			$(this).parent().parent().parent().find('.comment_box').hide();
		}
		
	})
	// 评分                                                                                                                                
	$('.star a').click(function(){
		var sNum=$(this).index();
		$(this).parent().find("a:gt("+(sNum-1)+")").removeClass('active');
		$(this).parent().find("a:lt("+sNum+")").addClass('active');
	})
	// 评级
	$('.rating a').click(function(){
		$('.rating a').removeClass('active');
		$(this).addClass('active');
	})
	// 评论
	$('.c_btn span').click(function(){
		$(this).parent().parent().hide();
	})
	$('.c_btn b').click(function(){
		if($(this).find('.on').length==0){
			$(this).find('i').addClass('on');
		}else{
			$(this).find('i').removeClass('on');
		}
	})
	// 交易状态切换
	$('.o_status').click(function(){
		if($(this).find('ul').css('display')=='none'){
			$(this).find('ul').show();
		}else{
			$(this).find('ul').hide();
		}	
	})
	$('.o_status li').click(function(){
		$(this).parent().parent().find('span').text($(this).text());
		$('.order_box .part').hide();
		$('.order_box .part').eq($(this).index()-1).show();
		$('.order_nav li').removeClass('active');
		$('.order_nav li').eq($(this).index()-1).addClass('active');
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
	// $('.title_tab').mouseout(function(){
	// 	$(this).hide();
	// })
	// $('.title_tab').mouseover(function(){
	// 	$(this).show();
	// })


	// 个人信息具体地址
	// $('#province').change(function(){
	// 	$('#address').val($('#province').val()+$('#city').val()+$('#ring').val());
	// })

    // 标签滑入效果
    $('.keywords li').mouseover(function(){
    	$(this).addClass('active');
    }).mouseout(function(){
    	$(this).removeClass('active');
    })
    $('.keywords a').mouseover(function(){
    	$(this).addClass('active');
    }).mouseout(function(){
    	$(this).removeClass('active');
    })

    // 个人订单
    // 主体切换
	$('.order_nav li').click(function(){
		$('.order_nav li').removeClass('active');
		$(this).addClass('active');
		$('.order_box .part').hide();
		$('.order_box .part').eq($(this).index()).show();
	})	

	// 安全设置
	// 确认提交按钮
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
	// 我的足迹-关注、收藏
	// 行业报告列表关注收藏分享
	// 关注按钮
	$('.message_list').on("click", ".ap", function() {

		if ($(this).find('.re').css('display') == 'none') {
				$(this).find('i').addClass('active1');
				$(this).find('span').hide();
				$(this).find('.re').show();
		} else {
				$(this).find('i').removeClass('active1');
				$(this).find('span').show();
				$(this).find('.re').hide();
		}
	});
	// 收藏按钮
	$('.message_list').on("click", ".cp", function() {
		if ($(this).find('.re').css('display') == 'none') {
				$(this).find('i').addClass('active2');
				$(this).find('span').hide();
				$(this).find('.re').show();
		} else {

				$(this).find('i').removeClass('active2');
				$(this).find('span').show();
				$(this).find('.re').hide();
		}
	});
	// 分享按钮
	$('.message_list').on("mouseover", ".sp", function() {
		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('reShare');
	}).on("mouseout", ".sp", function() {
		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('reShare');
	});

	// 我的足迹信息列表移入移出效果
	$('.message_list li').mouseover(function(){
		$(this).find('.f_border').show();
		$(this).find('.f_remove').show();
		$(this).addClass('on');
	}).mouseout(function(){
		$(this).find('.f_border').hide();
		$(this).find('.f_remove').hide();
		$(this).removeClass('on');
	})
	// 我的足迹信息列表移入点击删除按钮
	$('.f_remove').click(function(){
		$(this).parent().remove();
	})
	$('.trade_time i').click(function(){
		$(this).parent().parent().remove();
	})
	// 我的订单信息类别分类
	$('#unlimited').click(function(){
		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active');
		$('.message_list li').show();
	})
	changeTrade('item','xiangmu');
	changeTrade('attract','zhaobiao');
	changeTrade('bidding','zhongbiao');

	// 账户充值
	// 充值跳转
	$('#cztz').click(function(){
		$('.record').hide();
		$('.change_money').show();
	})
	// 支付方式切换
	$('.payment_method li').click(function(){
		$('.payment_method li').removeClass('active');
		$(this).addClass('active');
		$('.method').hide();
		$('.method').eq($(this).index()).show();
	})
	// 银行选中状态
	$('.bank_select li').click(function(){
		if($(this).find('span').css('display')=='none'){
			$(this).parent().find('li').find('span').hide();
			$(this).find('span').show();
		}else{
			$(this).parent().find('li').find('span').hide();
			$(this).find('span').hide();
		}
		
	})
	// 个人信息修改电话号和邮箱
	$('.change').click(function(){
		$(this).parent().find('input').val('');
	})
})
// 结算金额
function total(){
	var sum=0;
	$('.shopping_cart .name').find('.on').each(function(i){
		sum=sum+parseFloat($(this).parent().parent().find('.price').text());
	})
	var total= sum.toFixed(2);
	$('.total span').text(total);
	$('.account span').text(total);
	$('.balance .number span').text($('.shopping_cart .name').find('.on').length);
}
// 信息类别切换
function changeType( tBtn,list,box){
	$('.'+tBtn).click(function(){
		var oList=$(this).parent().parent().parent().parent();
		oList.find('.'+list).find('li').hide();
		oList.find('.'+box).show();
	})
}
// 我的足迹信息分类切换
function changeTrade(id,aclass){
	$('#'+id).click(function(){
		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active');
		$('.message_list li').hide();
		// $(this).parent().parent().find('.'+aclass).parent().parent().show();
		$(this).parent().parent().find('.'+aclass).show();
	})
}