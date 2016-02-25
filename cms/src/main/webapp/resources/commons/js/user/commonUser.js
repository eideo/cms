/* 
* @Author: zhanganchun
* @Date:   2016-02-24 17:12:58
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 10:32:51
*/

'use strict';

var maskShow = function() {

	$('#vipUpgrade').on('click',function(e) {

		$('.shadow_all').show()
		$('.vUpgrade').show()
	})

	$('.vUpgradeCon .close').on('click',function() {

		$('.shadow_all').hide()
		$('.vUpgrade').hide()
	})

	$('.shadow_all').on('click',function() {

		$(this).hide()
		$('.vUpgrade').hide()
	})
}

//图像加载出错时处理
function errorAvatar(img) {

	img.src = resPath + "/resources/commons/images/face.png";
	img.onerror = null;
}

function errorAvatarTwo(img) {

	img.src = resPath + "/resources/commons/images/face2.png";
	img.onerror = null;
}

function classSwith() {

	$('.project').click(function() {

		if($(this).find('ul').css('display')=='none') {

			$(this).find('ul').show();
		}else {

			$(this).find('ul').hide();
		}
	});

	$('.project li').click(function() {

		$(this).parent().parent().find('span').text($(this).text());
	});

	changeType('xiangmu_type','cart_list','xiangmu');

	changeType('zhaobiao_type','cart_list','zhaobiao');

	changeType('zhongbiao_type','cart_list','zhongbiao');

	$('.project .all_type').click(function() {

		$('.cart_list li').show();
	});
}

// 信息类别切换
function changeType( tBtn,list,box) {

	$('.'+tBtn).click(function() {

		var oList=$(this).parent().parent().parent().parent();

		oList.find('.'+list).find('li').hide();
		oList.find('.'+box).show();
	});
}

function checkList() {

	var aLi=$('.optional').length;
	console.log(aLi);

	$('#custBehaviorList').on("click", ".check", function(e) {

		console.log($(this))
		var oLi=$(this).parent().parent();

		if(oLi.find('.on').length==0) {

			oLi.find('.check').addClass('on');
		}else {

			oLi.find('.check').removeClass('on');
		}

		var listNum = $('.name').find('.on').length
		aLi = $('.optional').length;
		if(listNum == aLi) {

			$('.selectall').find('i').addClass('on');
		}else {

			$('.selectall').find('i').removeClass('on');
		}

		$('.account a').addClass('active');
		$('.balance_operation a').addClass('active');

		total();
	});

	$('#custBehaviorList').on("mouseover", ".optional", function() {

		$(this).find('.border').show();
		$(this).addClass('on');
		$(this).find('.name').find('a').css('color','#47aaff');
		$(this).find('span').css('color','#47aaff');	
	}).on("mouseout", ".optional", function() {

		$(this).find('.border').hide();
		$(this).removeClass('on');
		$(this).find('.name').find('a').css('color','#5e5e5e');
		$(this).find('span').css('color','#5e5e5e');
	});
}

// 列表链接
function clickLink(listClass) {

	$(listClass).each(function () {

		var linkNum = $(this).attr('infoId');
		var linkWord = path+'/detail/';
		var linkWord2 = path+'/reportdetail/';
		var infoType = $(this).attr('intype');
		// $(this).find('.infoLink').attr('href',infoType);
		var infoName= $(this).find('.infoLink');
		// a.attr('href',infoType)
		if(infoType ==11501){
			infoName.attr('href',linkWord+linkNum);
		}else if(infoType ==11502){
			infoName.attr('href',linkWord+'zbgg-'+linkNum);
		}else if(infoType ==11503){
			infoName.attr('href',linkWord+'zbgs-'+linkNum);
		}else{
			infoName.attr('href',linkWord2+linkNum);
		}
	})
}


function getByInfoType(value) {

	if(value != "") {

		$("#info_type").val(value);
	} else {

		$("#info_type").val("");
	}

	ajaxCustBehaviorList();
}

function ajaxCustBehaviorList(p) {

	var currentPage = 1;

	if(p) {

		currentPage = p;
	}

	var infoType = $("#info_type").val();
	var actionType = $("#action_type").val();
	var url = path + "/personal/ajaxCustBehaviorList";

	$.ajax({

		url : url,
		data : {
			'currentPage' : currentPage,
			'infoType' : infoType,
			'actionType' : actionType
		},
		type : "POST",
		dataType : "json",
		success : function(data) {

			// alert(data.success);
			if(data.success == true) {

				$("#custBehaviorList").html("");
				for(var i = 0; i < data.custBehaviorList.length; i++) {

					var custBehavior = data.custBehaviorList[i];
					var html = $("#custBehaviorListTemplate").html();

					for(var key in custBehavior) {

						while(html.indexOf("{custBehavior." + key + "}") != -1) {

							html = html.replace("{custBehavior." + key + "}", custBehavior[key]);
						}
					}

					$("#custBehaviorList").append(html);
				}

				if(!p) {

					$(".tcdPageCode").createPage({

						pageCount : data.totalPage,
						current : data.currentPage,
						backFn : function(p) {

							ajaxCustBehaviorList(p);
						}
					});
				}
			}

			clickLink('.cart_list li');
			clickLink('.message_list li');
			
		},
		error : function() {

			alert("获取数据请求异常");
		}
	});
}

function deleteCustBehavior(id) {

	var flag = confirm("您确定要删除吗?");
	if(flag) {

		var url = path + "/personal/delete";
		$.ajax({
			url : url,
			data : {
				'id' : id
			},
			type : "POST",
			dataType : "json",
			success : function(data) {

				if(data.success == true) {

					ajaxCustBehaviorList();
				}
			},
			error : function() {

				alert("删除失败");
			}
		});
	}
}

// 结算金额
function total() {

	var sum=0;

	$('.shopping_cart .name').find('.on').each(function(i) {

		sum=sum+parseFloat($(this).parent().parent().find('.price').text());
	});

	var total= sum.toFixed(2);

	$('.total span').text(total);
	$('.account span').text(total);
	$('.balance .number span').text($('.shopping_cart .name').find('.on').length);
}

$(function() {

	maskShow();
	classSwith();
	checkList();
})