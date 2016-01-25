/* 
 * @Author: zhanganchun
 * @Date:   2016-01-04 15:01:07
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-22 14:15:36
 * @ 排行榜入口模块
 */

'use strict';

define(function(require, exports, module) {

	var positionAll = require('../../js/tagCloud');

	var createPage = require('createPage');

	var hot = true;

	var asc = true;

	var tagIndex = 0;

	var Chart = require('../../js/chart/chart');

	var mapSetting = {
		selector: '#map',
		margin: {
			left: 0,
			right: 0,
			top: 20,
			bottom: 20
		},
		dataset: [],
		colorset: ['#6ebeff', '#fff']
	}

	var mapReload = function(callback) {

		Chart.addChinaMap('#map', function() {

			if (callback) {

				callback()
			}
		})
	}

	// 排行榜分类切换
	function rankType() {

		$('#c_btn li').click(function() {

			$('#c_btn li').removeClass('active');

			$('.part').hide();

			$(this).addClass('active');

			ajaxChangeData();


			if($(document).scrollTop() != 712){

				$("html, body").scrollTop(0).animate({scrollTop: $("#c_btn").offset().top});
			}
		})

		// li移入背景变色
		$('.part li').mouseover(function() {

			$('.part li').css('background', '#fff');
			$(this).css('background', '#f6f6f6');
		})
	}

	// 条件更多切换
	function toggleClass(aClass) {

		$(aClass).click(function() {

			if ($(this).find('i').hasClass('active')) {

				$(this).find('i').removeClass('active');
				$(this).removeClass('active');
			} else {

				$(this).find('i').addClass('active');
				$(this).addClass('active');
			}

			$(this).parent().find('.hidden').toggle();
		})
	}

	function toggleThis(parm) {

		$(parm + ' a').click(function() {

			if ($(this).hasClass('active')) {

				$(this).removeClass('active')
			} else {

				$(parm + ' a').removeClass('active');
				$(this).addClass('active');
			}

			ajaxChangeData();
		})
	}

	function bindClickOnleft() {

		toggleThis('.time');
		toggleThis('.area');
		toggleThis('.trade');
	}

	function ajaxChangeData() {

		var data = {};

		data.type = $("#c_btn .active").attr("type");

		if ($(".areaType .active").attr("id")) {

			data.areaCode = $(".areaType .active").attr("id");
		}

		if ($(".trade .active").attr("code")) {

			data.industry = $(".trade .active").attr("code");
		}

		if ($(".time .active").attr("code")) {

			data.circle = $(".time .active").attr("code");
		}

		if (hot) {

			data.sort = 1;
		} else {

			data.sort = 0;
		}

		if (asc) {

			data.asc = 1;
		} else {

			data.asc = 0;
		}

		ajaxAsync("post", path + "/getRanking", data, "json", function(datas) {

			if (datas.status) {

				$(".part" + data.type + " .rankinglist").html("");

				var datalength = datas.rankingDatas.length < 20 ? datas.rankingDatas.length : 20;

				window.allRankingDatas = datas.rankingDatas;

				for (var i = 0; i < datalength; i++) {

					var indexData = datas.rankingDatas[i];
					var html = $("#partTemp" + data.type).html();

					while (html.indexOf("{num}") != -1) {

						html = html.replace("{num}", i + 1);
					}

					for (var key in indexData) {

						while (html.indexOf("{" + key + "}") != -1) {

							html = html.replace("{" + key + "}", indexData[key]);
						}
					}

					html = exeStr(html);
					$(".part" + data.type + " .rankinglist").append(html);
				}

				$(".part" + data.type).show();
				$(".tcdPageCode").createPage({
					pageCount: datas.num,
					current: 1,
					backFn: function(p) {

						changePage(p);
					}
				});
			}

		}, function(data) {

		});
	}

	function changePage(p) {

		if (typeof allRankingDatas == "string") {

			allRankingDatas = eval('(' + allRankingDatas + ')');
		}

		var last = allRankingDatas.length > p * 20 ? p * 20 : allRankingDatas.length;

		var type = $("#c_btn .active").attr("type");

		$(".part" + type + " .rankinglist").html("");

		for (var i = (p - 1) * 20; i < last; i++) {

			var indexData = allRankingDatas[i];
			var html = $("#partTemp" + type).html();

			while (html.indexOf("{num}") != -1) {

				html = html.replace("{num}", i + 1);
			}
			for (var key in indexData) {

				while (html.indexOf("{" + key + "}") != -1) {

					html = html.replace("{" + key + "}", indexData[key]);
				}
			}

			html = exeStr(html);
			$(".part" + type + " .rankinglist").append(html);
		}
	}

	function exeStr(html) {

		while (html.indexOf("-[") != -1) {

			var exeStr = html.substring(html.indexOf("-[") + 2, html.indexOf("]-"));

			var value = "";

			if (exeStr.indexOf(":") == 0) {

				var exe = exeStr.split(":");
				value = eval(exe[1]);
			} else {

				var exeStrArr = exeStr.split(";");

				for (var i = 0; i < exeStrArr.length; i++) {

					var exe = exeStrArr[i].split(":");

					if (eval(exe[0])) {

						value = exe[1];
						break;
					}
				}
			}

			html = html.replace("-[" + exeStr + "]-", value);
		}
		return html;
	}

	function initHotWord(parm) {

		$('.words a').eq(tagIndex++).html(parm);

		if (tagIndex > 14) {

			tagIndex = 0
		}
	}

	function goTop() {

		$(window).scroll(function() {

			if ($(window).scrollTop() > 200) {

				$('#gotop').show();

			} else {
				$('#gotop').hide();
			}
		})
		$('#gotop').click(function() {

			$('body,html').animate({
				scrollTop: 0
			}, 300);
		}).mouseover(function() {

			$('#gotop i').hide();
			$('#gotop span').show();
		}).mouseout(function() {

			$('#gotop i').show();
			$('#gotop span').hide();
		})
	}

	// 点击页码返回结果列表顶部
	function pageClick() {

		$('.tcdPageCode').on("click", "a", function() {

			$("html, body").scrollTop(0).animate({
				scrollTop: $(".ranking").offset().top - 30
			});
		})
	}
	
	$(function() {

		positionAll();
		rankType();
		toggleClass('.more');
		bindClickOnleft();

		pageClick();

		// $('#c_btn li').eq(0).click()
		ajaxChangeData();

		Chart.addChinaMap(mapSetting, function() {

			var parent = d3.select('#map').select('.content'),
				dataset = []

			function getMapData() {

				$.ajax({
					url: path + "/customerBehavior/getHotword",
					type: "GET",
					dataType: "json",
					success: function(data) {

						if (data.areaName === '') {

							return
						}

						dataset = [data.areaName, data.hotWord]

						initHotWord(data.hotWord)

						var width = document.querySelector(mapSetting.selector).getBoundingClientRect().width,
							height = document.querySelector(mapSetting.selector).getBoundingClientRect().height

						Chart.addCircle(parent, width, height, dataset)
					},
					error: function() {
						return "error";
					}
				})
			}

			var intervel = setInterval(function() {
				getMapData()
			}, 1200)
		})

		$('.tip').live('click', function(e) {

			var e = e || window.event,
				word = $(this).html()

			window.location.href = path + '/search?keyword=' + word
		})

		$('.words a').on('click', function() {

			window.location.href = path + '/search?keyword=' + $(this).html()
		})


		$('.linkResult a').live('click', function() {

			console.log($(this))
			$(this).css('color', '#333')
		})

		goTop();
	})


	module.exports = '';
})