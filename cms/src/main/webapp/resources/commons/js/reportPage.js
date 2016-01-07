'use strict';

$(function(){
//	关闭登录框
	$('.close').click(function(){
		$('.login_box').hide();
		$('.shadow_all').hide();
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

	// 行业报告详情页关注收藏分享
	// 关注按钮
	$('#report_detail').on("click", ".ap", function() {
		var actiontype = $(this).attr("actiontype");
		var infotype = $(this).attr("infotype");
		var infoid = $(this).attr("infoid");
		if ($(this).find('.re').css('display') == 'none') {
			var status = custBehavior(actiontype, infotype, infoid, 1);
			// 已登录
			if (status == 0) {
				$(this).find('i').addClass('active1');
				$(this).find('span').hide();
				$(this).find('.re').show();
				// 未登录
			} else if (status == -1) {
				$('.login_box').show();
				$('.shadow_all').show();
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
				$('.shadow_all').show();
			} else if (status == -2) {
				alert("请求异常");
			}
		}
	});
	// 收藏按钮
	$('#report_detail').on("click", ".cp", function() {
		var actiontype = $(this).attr("actiontype");
		var infotype = $(this).attr("infotype");
		var infoid = $(this).attr("infoid");
		if ($(this).find('.re').css('display') == 'none') {
			var status = custBehavior(actiontype, infotype, infoid, 1);
			// 已登录
			if (status == 0) {
				$(this).find('i').addClass('active2');
				$(this).find('span').hide();
				$(this).find('.re').show();
				// 未登录
			} else if (status == -1) {
				$('.login_box').show();
				$('.shadow_all').show();
			} else if (status == -2) {
				alert("请求异常");
			}
		} else {
			var status = custBehavior(actiontype, infotype, infoid, 0);
			// 已登录
			if (status == 0) {
				$(this).find('i').removeClass('active2');
				$(this).find('span').show();
				$(this).find('.re').hide();
				// 未登录
			} else if (status == -1) {
				$('.login_box').show();
				$('.shadow_all').show();
			} else if (status == -2) {
				alert("请求异常");
			}
		}
	});
	// 分享按钮
	$('#report_detail').on("mouseover", ".sp", function() {
		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('reShare');
	}).on("mouseout", ".sp", function() {
		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('reShare');
	});
	

    // 报告目录
	$('.li').click(function(){
		if($(this).parent().find('.hidden').css('display')=='none'){
			$(this).find('i').addClass('active');
			$(this).find('a').addClass('active');
			$(this).parent().find('.hidden').show();
		}else{
			$(this).find('i').removeClass('active');
			$(this).find('a').removeClass('active');
			$(this).parent().find('.hidden').hide();
		}
	});
	

	$('.buy').on(
		"click",
		function() {
			var reportid = $(this).attr("reportid");
			var reporttitle = $("#" + reportid).text();
			// alert(reporttitle);
			var reporturl = $(this).attr("reporturl");
			reporturl = unescape(reporturl);
			var url =  resPath + "/resources/pdfjs/web/viewer.html?file=" + reporturl;
			// alert(url);
			var width = parseInt($(window).width() * 0.8);
			var height = parseInt($(window).height() * 0.8);
			// alert(width + "/" + height);
			popWin.showWin(width, height, reporttitle, url);
		});
});
