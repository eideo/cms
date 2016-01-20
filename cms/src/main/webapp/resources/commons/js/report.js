'use strict';
$(function() {

	//	搜索框交互
	searchHint();

	// 轮播图
	imgArr();

	//	关闭登录框
	closeLoginBox();

	// 行业分类
	tradeClass();

	// 行业报告列表关注收藏分享
	userBehavior();

	urlOption();

	pageClick();

	goTop()
});

function goTop() {
	$(window).scroll(function () {

		if($(window).scrollTop() > 200) {

			$('#gotop').show();
			
		}else {
			$('#gotop').hide();
		}	
	})
	$('#gotop').click(function () {

		$('body,html').animate({scrollTop:0},300);
	}).mouseover(function() {

		$('#gotop i').hide();
		$('#gotop span').show();
	}).mouseout(function() {

		$('#gotop i').show();
		$('#gotop span').hide();
	})
}
// 搜索框交互

function searchHint() {

	$('.searchBox').focus(function() {

		$(this).addClass('active');
	}).blur(function() {

		$(this).removeClass('active');
	})

	$('.prompt').on("mouseover", function() {

		$('.prompt').show();
	}).on("mouseout", function() {

		$('.prompt').hide();
	});

	$('.searchBox').on("keyup", function() {

		var keywords = this.value;
		if (keywords) {

			getSuggestReport(keywords);
		}
	});

	$('.prompt').on("click", "li", function() {

		$('.searchBox').val(this.innerHTML);
		searchReport();
		$("html, body").scrollTop(0).animate({scrollTop: $(".s_nav").offset().top-30});
	});

	$('.searchBtn').on("click", function() {

		searchReport();
		$("html, body").scrollTop(0).animate({scrollTop: $(".s_nav").offset().top-30});
	});

	// 按回车键搜索
	document.onkeydown = function(e) {

		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {

			searchReport();
			$("html, body").scrollTop(0).animate({scrollTop: $(".s_nav").offset().top-30});
		}
	}

	var searchInput=document.getElementById('searchBox');

	searchInput.oninput=function(){

		if(this.value !='') {

			$('.search i').show();
		}else {

			$('.search i').hide();
		}
	}

	$('.search i').click(function() {

		$('.searchBox').val('');
		$(this).hide();
	})

}

function closeLoginBox() {

	$('.close').click(function() {

		$('.login_box').hide();
		$('.shadow_all').hide();
	});
}

function tradeClass() {

	$('.term li').click(function() {

		$('.term li').removeClass('active');
		$('.term li').find('i').removeClass('active');
		$('.term li').find('a').removeClass('active');

		$('.s_nav .h2').find('i').removeClass('active');
		$('.s_nav .h2').find('a').removeClass('active');
		$('.s_nav .h2').removeClass('active');

		$(this).addClass('active');
		$(this).find('i').addClass('active');
		$(this).find('a').addClass('active');
	});

	$('.s_nav .h2').click(function() {

		$('.term li').removeClass('active');
		$('.term li').find('i').removeClass('active');
		$('.term li').find('a').removeClass('active');

		$(this).addClass('active');
		$(this).find('i').addClass('active');
		$(this).find('a').addClass('active');
	});
}

// 用户行为

function userBehavior() {

	// 关注按钮
	$('#reportMainList').on("click", ".ap", function() {

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
	$('#reportMainList').on("click", ".cp", function() {

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
	$('#reportMainList').on("mouseover", ".sp", function() {

		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('reShare');
	}).on("mouseout", ".sp", function() {

		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('reShare');
	});
}


// 轮播图

function imgArr() {

	var oBox = document.getElementById('box');
	var oUl = oBox.getElementsByTagName('ul')[0];
	var aLi = oUl.children;
	var oOl = oBox.getElementsByTagName('ol')[0];
	var aBtn = oOl.children;
	var oPrev = document.getElementById('prev');
	var oNext = document.getElementById('next');

	oUl.innerHTML += oUl.innerHTML;
	oUl.style.width = aLi.length * aLi[0].offsetWidth + 'px';

	var W = oUl.offsetWidth / 2;
	var iNow = 0;
	var timer = null;

	oBox.onmouseover = function() {

		clearInterval(timer);
		oPrev.style.display = 'block';
		oNext.style.display = 'block';
	};

	oBox.onmouseout = function() {

		timer = setInterval(function() {

			fnNext();
		}, 2000);

		oPrev.style.display = 'none';
		oNext.style.display = 'none';
	};

	for (var i = 0; i < aBtn.length; i++) {

		(function(index) {

			aBtn[i].onclick = function() {

				if (iNow % aBtn.length == 0 && index == 4) {

					iNow--;
				}
				if ((iNow % aBtn.length == 4 || iNow == -1) && index == 0) {

					iNow++;
				}

				iNow = Math.floor(iNow / aBtn.length) * aBtn.length + index;
				tab();
			};
		})(i);
	}

	function tab() {

		for (var i = 0; i < aBtn.length; i++) {

			aBtn[i].className = '';
		}

		if (iNow > 0) {

			aBtn[iNow % aBtn.length].className = 'on';
		} else {

			aBtn[(iNow % aBtn.length + aBtn.length) % aBtn.length].className = 'on';
		}
		startMove(oUl, -iNow * aLi[0].offsetWidth);
	}

	oPrev.onclick = function() {

		iNow--;
		tab();
	};

	oNext.onclick = fnNext;

	function fnNext() {

		iNow++;
		tab();
	}

	timer = setInterval(function() {

		fnNext();
	}, 8000);


	var left = 0;

	function startMove(obj, iTarget) {

		var start = left;
		var dis = iTarget - start;
		var count = Math.floor(700 / 30);
		var n = 0;

		clearInterval(obj.timer);
		obj.timer = setInterval(function() {

			n++;
			var a = 1 - n / count;
			left = start + dis * (1 - Math.pow(a, 3));
			if (left < 0) {

				obj.style.left = left % W + 'px';
			} else {

				obj.style.left = (left % W - W) % W + 'px';
			}
			if (n == count) {

				clearInterval(obj.timer);
			}
		}, 30);
	}
}

function getSuggestReport(keywords) {
	var url = path + "/report/getSuggest";
	$.ajax({
		url: url,
		async: false, //ajax返回值赋值给变量，必须定义为同步
		data: {
			'keywords': keywords
		},
		type: "POST",
		dataType: "json",
		success: function(data) {

			if (data.status) {

				$(".prompt").html("");

				for (var i = 0; i < data.resultList.length; i++) {
					var li = $("<li>" + data.resultList[i] + "</li>");
					$(".prompt").append(li);
				}
				$('.prompt').show();
			}
		},
		error: function() {

		}
	});
}

function searchReport(p) {
	var currentPage = 1;
	if (p) {
		currentPage = p;
	}
	var searchWords = $(".searchBox").val();
	// alert("currentPage = " + currentPage + ", searchWords = " + searchWords);
	var url = path + "/report/searchReport";
	$.ajax({
		url: url,
		data: {
			'currentPage': currentPage,
			'searchWords': searchWords
		},
		type: "POST",
		dataType: "json",
		success: function(data) {

			if (data.success == true) {

				$("#reportMainList").html("");

				if (data.reportMainList.length === 0) {

					var imgError = path+'/resources/commons/images/searchError.png';

					$('#reportMainList').html('<img src="'+path+'/resources/commons/images/searchError.png'+'" style="margin:100px auto"/>')
					$(".tcdPageCode").hide()
				}
				
				for (var i = 0; i < data.reportMainList.length; i++) {

					var reportMain = data.reportMainList[i];
					var html = $("#listTemplate").html();

					for (var key in reportMain) {

						while (html.indexOf("{reportMain." + key + "}") != -1) {

							html = html.replace("{reportMain." + key + "}", reportMain[key]);
						}
					}

					$("#reportMainList").append(html);
				}

				if (!p) {

					$(".tcdPageCode").createPage({
						pageCount: data.totalPage,
						current: data.currentPage,
						backFn: function(p) {
							searchReport(p);
						}
					});
				}
			}
		},
		error: function() {
			alert("获取行业报告请求异常");
		}
	});
}

function getByInduxtry(value) {
	if (value != 0) {
		$("#induxtry_id").val(value);
	} else {
		$("#induxtry_id").val("");
	}
	ajaxReport();
}

function ajaxReport(p) {
	var currentPage = 1;
	if (p) {
		currentPage = p;
	}
	var induxtry = $("#induxtry_id").val();
	// alert("currentPage = " + currentPage + ", induxtry = " + induxtry);
	var url = path + "/report/ajaxReport";
	$.ajax({
		url: url,
		data: {
			'currentPage': currentPage,
			'induxtry': induxtry
		},
		type: "POST",
		dataType: "json",
		success: function(data) {

			if (data.success == true) {

				$("#reportMainList").html("");

				if (data.reportMainList.length === 0) {

					var imgError = path+'/resources/commons/images/searchError.png';

					$('#reportMainList').html('<img src="'+path+'/resources/commons/images/searchError.png'+'" style="margin:100px auto"/>')
					$(".tcdPageCode").hide()
				}
				for (var i = 0; i < data.reportMainList.length; i++) {
					var reportMain = data.reportMainList[i];
					var html = $("#listTemplate").html();
					for (var key in reportMain) {
						while (html.indexOf("{reportMain." + key + "}") != -1) {
							html = html.replace("{reportMain." + key + "}", reportMain[key]);
						}
					}
					$("#reportMainList").append(html);
				}

				if (!p) {
					$(".tcdPageCode").createPage({
						pageCount: data.totalPage,
						current: data.currentPage,
						backFn: function(p) {
							ajaxReport(p);
						}
					});
				}
			}
		},
		error: function() {
			alert("获取行业报告请求异常");
		}
	});
}

function reportView(id) {
	var reportid = "#info_" + id;
	var reporttitle = $(reportid).text();
	var reporturlid = "#reporturl_" + id;
	var reporturl = $(reporturlid).val();
	var url = resPath + "/resources/pdfjs/web/viewer.html?file=" + reporturl;
	// alert(url);
	var width = parseInt($(window).width() * 0.8);
	var height = parseInt($(window).height() * 0.8);
	// alert(width + "/" + height);
	popWin.showWin(width, height, reporttitle, url);
}

// url传递默认行业分类

function getUrlArgs() {

	var url = window.location.href
	var urlArr = url.split('/');
	var args = urlArr[urlArr.length-1];
	return args;

}
function urlOption() {

	var pid = getUrlArgs();
	var theIndustry=$("'.term li[rid='"+pid+"']'");

	theIndustry.addClass('active');
	theIndustry.find('a').addClass('active');
	theIndustry.find('i').addClass('active');
}

// 点击页码返回结果列表顶部
function pageClick() {

	$('.tcdPageCode').on("click", "a", function() {

		$("html, body").scrollTop(0).animate({scrollTop: $(".s_nav").offset().top-30});
	})
}