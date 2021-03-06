'use strict';

define(function(require, exports, module) {

	var Close = require('./lib/common');
	$(function() {

		// 相关推荐切换
		tab('.btn', '.tuijian');

		// 用户行为
		userBehavior();

		// 关闭登录框
		Close.closeLoginBox();

		recommend();

		getRecommended()
	});

	// 相关推荐ajaxsh数据读取
	function getRecommended() {

		var parameter =getUrlArgs();

		// 项目

		$.ajax({

			url:path+'/getRecomInfo',
			dataType:'json',
			type:'post',
			data:{
				infoid:parameter,
				showType:'0',
			},
			success:function(data) {

				for (var i = 0; i < data.length; i++) {
					var oLi = $('<li></li>').appendTo($('.xiangmu'));
					$('<i></i>').appendTo(oLi);
					$('<a></a>').attr('href',path+'/detail/'+data[i].id).attr('target','_blank').text(data[i].title).appendTo(oLi);

				};

			},
			error: function() {

				$.Message({
					text:'请求异常',
					type:"failure"
				})
				result =false;
				return result;
			}

		})

		// 招标

		$.ajax({

			url:path+'/getRecomInfo',
			dataType:'json',
			type:'post',
			data:{
				infoid:parameter,
				showType:'1',
			},
			success:function(data) {

				for (var i = 0; i < data.length; i++) {
					var oLi = $('<li></li>').appendTo($('.zhaobiao'));
					$('<i></i>').appendTo(oLi);
					$('<a></a>').attr('href',path+'/detail/'+data[i].id).attr('target','_blank').text(data[i].title).appendTo(oLi);

				};

			},
			error: function() {

				$.Message({
					text:'请求异常',
					type:"failure"
				})
				result =false;
				return result;
			}

		})

		// 中标

		$.ajax({

			url:path+'/getRecomInfo',
			dataType:'json',
			type:'post',
			data:{
				infoid:parameter,
				showType:'2',
			},
			success:function(data) {

				for (var i = 0; i < data.length; i++) {
					var oLi = $('<li></li>').appendTo($('.zhongbiao'));
					$('<i></i>').appendTo(oLi);
					$('<a></a>').attr('href',path+'/detail/'+data[i].id).attr('target','_blank').text(data[i].title).appendTo(oLi);

				};

			},
			error: function() {

				$.Message({
					text:'请求异常',
					type:"failure"
				})
				result =false;
				return result;
			}

		})

	}

	// 获取url参数
	function getUrlArgs() {

		var url = window.location.href
		var urlArr = url.split('/');
		var args = urlArr[urlArr.length-1];
		return args;

	}

	// 相关信息判断

	function recommend() {

		var type = $('.title').attr('infotype');
		if(type == '11501') {

			$('.bxiangmu').hide();
			$('.xiangmu').hide();
			$('.bzhaobiao').css('color','#0a8dff');
			$('.bzhaobiao i').show();
			$('.zhaobiao').show();
		}else if(type == '11502') {

			$('.bzhaobiao').hide();
			$('.zhaobiao').hide();
			$('.bxiangmu i').show();
			$('.bxiangmu').css('color','#0a8dff');
			$('.xiangmu').show();
		}else if(type == '11503'){
			
			$('.bzhongbiao').hide();
			$('.zhongbiao').hide();
			$('.bxiangmu i').show();
			$('.bxiangmu').css('color','#0a8dff');
			$('.xiangmu').show();
		}
	}

	function tab(aBtn, aBox) {
		$(aBtn + ' li').click(function() {
			$(aBtn + ' li').css('color', '#5e5e5e');
			$(this).css('color', '#0a8dff');
			$(aBtn + ' i').css('display', 'none');
			$(aBtn + ' i').eq($(this).index()).css('display', 'block');
			$(aBox + ' ol').css('display', 'none');
			$(aBox + ' ol').eq($(this).index()).css('display', 'block');
		});
	}

	function userBehavior() {

		$('.info').on("click", ".ap", function() {

			var actiontype = $(this).attr("actiontype");
			var infotype = $(this).attr("infotype");
			var infoid = $(this).attr("infoid");

			if ($(this).find('.re').css('display') == 'none') {

				var status = custBehavior(actiontype, infotype, infoid, 1);

				// 已登录
				if (status == 0) {

					$(this).find('i').addClass('active1');
					$(this).find('a').hide();
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
					$(this).find('a').show();
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
		$('.info').on("click", ".cp", function() {

			var actiontype = $(this).attr("actiontype");
			var infotype = $(this).attr("infotype");
			var infoid = $(this).attr("infoid");

			if ($(this).find('.re').css('display') == 'none') {

				var status = custBehavior(actiontype, infotype, infoid, 1);

				// 已登录
				if (status == 0) {

					$(this).find('i').addClass('active2');
					$(this).find('a').hide();
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
					$(this).find('a').show();
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
		$('.info').on("mouseover", ".sp", function() {

			$(this).find('em').show();
			$(this).find('div').show();
			$(this).find('.share').addClass('reShare');

		}).on("mouseout", ".sp", function() {

			$(this).find('em').hide();
			$(this).find('div').hide();
			$(this).find('.share').removeClass('reShare');
		});
	}

	module.exports = '';
})