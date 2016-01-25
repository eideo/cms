/* 
 * @Author: zhanganchun
 * @Date:   2016-01-04 15:01:07
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-06 16:35:50
 */

"use strict";

function imgArr() {

	var timer = null;
	var index = $('.on').index()

	$('.imgBox ol li').click(function() {

		tab($(this).index() - 1);
	})

	clearInterval(timer);

	timer = setInterval(function() {
		if (index === 3) {
			index = -1;
		}
		tab(index++);
	}, 5000)
}

function tab(index) {

	$('.imgBox ol li').removeClass('on');
	$('.imgBox ol li').eq(index + 1).addClass('on');
	$('.imgArr li').hide(500);
	$('.imgArr li').eq(index + 1).fadeIn(500);
}

function searchHint() {

	$('.prompt').on("mouseover", function() {

		$('.prompt').show();
	}).on("mouseout", function() {

		$('.prompt').hide();
	});

	$('#seachInput').on("keyup", function() {

		var name = this.value;
		if (name) {

			getSuggest(name);
		}
	});

	$('.prompt').on("click", "li", function() {

		$('#seachInput').val(this.innerText);
		$(".search form").submit();
	});
}

function checkForm() {

	if (!$('#seachInput').val()) {

		return false;
	}
}

function getSuggest(val) {

	var data = {};
	data.name = val;
	$.ajax({

		type: "post",
		async: true,
		url: path + "/getSuggest",
		data: data,
		dataType: "json",
		success: function(result) {

			if (result.status) {

				$(".prompt").html("");
				for (var i = 0; i < result.datas.length; i++) {

					var li = $("<li>" + result.datas[i] + "</li>");
					$(".prompt").append(li);
				}

				$('.prompt').show();
			}
		},
		error: function(e) {}
	});

}

$(function() {

	imgArr();
	searchHint();

	$('#seachInput').mouseover(function() {

		$('.search button').addClass('on');
	}).mouseout(function() {

	$('.search button').removeClass('on');
	})

	$('.search button').click(function() {

		$('#seachInput').focus();
	})
})