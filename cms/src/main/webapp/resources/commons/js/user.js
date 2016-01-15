'use strict';
var option = null;
$(function(){

	tabHover();
	
	// 更换头像
	changeFace('.my_info_box .face');

	// 左侧折叠切换
	tabFold();

	// 购物车标题全选
	checkAll();
	
	// 购物车信息类别切换
	classSwith();

	// 购物车列表选择
	checkList();
	
	// 购物车悬浮框
	fixedBar();

	// 安全设置
	// 确认提交按钮
	// $('.update_box button').mouseover(function(){
	// 	$('.update_box button').removeClass('on');
	// 	$(this).addClass('on');
	// }).mouseout(function(){
	// 	$(this).removeClass('on');
	// });
	// 修改切换
	// $('.re_box a').click(function(){
	// 	var oLi=$(this).parent().parent();
	// 	if(oLi.find('.update_box').css('display')=='none'){
	// 		$(this).text('取消修改');
	// 		oLi.find('.update_box').show();
	// 	}else{
	// 		$(this).text('修改');
	// 		oLi.find('.update_box').hide();
	// 	}
	// });

	// 关注按钮
	userAttention();
	
	// 收藏按钮
	userCollection();
	
	// 分享按钮
	userShare()
	

	// 我的足迹信息列表移入移出效果
	footListHover();

	clickLink('.cart_list li');	
	clickLink('.message_list li');	

	saveImg();	
});

function tabHover() {

	// 所有按钮移入变色
	$('.hover').mouseover(function() {

		$(this).addClass('on');
	}).mouseout(function() {

		$(this).removeClass('on');
	});
}
function tabFold() {

	$('.sign h4').click(function() {

		if($(this).parent().find('ul').css('display')=='block') {

			$(this).parent().find('ul').hide();
		}else {

			$(this).parent().find('ul').show();
		}
	});
}

function checkAll() {

	$('.selectall').click(function() {

		var num=$('.cart_list li').length-$('.cart_list .failure_info').length;

		if($('.name').find('.on').length!=num) {

			$(this).find('i').addClass('on');
			$('.selectall').find('i').addClass('on');

			$('.name i').each(function() {

				$(this).addClass('on');
			});

			$('.account a').addClass('active');
			$('.balance_operation a').addClass('active');
		}else {

			$(this).find('i').removeClass('on');
			$('.selectall').find('i').removeClass('on');

			$('.name i').each(function(i) {

				$(this).removeClass('on');
			});

			$('.account a').removeClass('active');
			$('.balance_operation a').removeClass('active');
		}

		total();
	});
}

function classSwith(){

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

function checkList() {

	var aLi=$('.optional').length;
	console.log(aLi);

	$('#custBehaviorList').on("click", ".check", function() {

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

function fixedBar() {

	$(window).scroll(function() {

		if($(window).scrollTop()>100) {

			$('.balance').css('position','static');
		}else {

			$('.balance').css('position','fixed');
		}
	});
}

function userAttention() {

	$('.message_list').on("click", ".ap", function() {

		var actiontype = $(this).attr("actiontype");
		var infotype = $(this).attr("infotype");
		var infoid = $(this).attr("infoid");

		if ($(this).find('.re').css('display') == 'none') {

			var status = custBehavior(actiontype, infotype, infoid, 3);

			// 已登录
			if (status == 0) {

				$(this).find('i').addClass('active1');
				$(this).find('span').hide();
				$(this).find('.re').show();

				// 未登录
			} else if (status == -1) {

				$('.login_box').show();
				$('.shadow').show();
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
				$('.shadow').show();
			} else if (status == -2) {

				alert("请求异常");
			}
		}
	});
}

function userCollection() {

	$('.message_list').on("click", ".cp", function() {

		var actiontype = $(this).attr("actiontype");
		var infotype = $(this).attr("infotype");
		var infoid = $(this).attr("infoid");

		if ($(this).find('.re').css('display') == 'none') {

			var status = custBehavior(actiontype, infotype, infoid, 4);

			// 已登录
			if (status == 0) {

				$(this).find('i').addClass('active2');
				$(this).find('span').hide();
				$(this).find('.re').show();

				// 未登录
			} else if (status == -1) {

				$('.login_box').show();
				$('.shadow').show();
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
				$('.shadow').show();
			} else if (status == -2) {

				alert("请求异常");
			}
		}
	});

}

function userShare() {

	$('.message_list').on("mouseover", ".sp", function() {

		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('reShare');
	}).on("mouseout", ".sp", function() {

		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('reShare');
	});
}

function footListHover() {

	$('.message_list li').mouseover(function() {

		$(this).find('.f_border').show();
		$(this).find('.f_remove').show();
		$(this).addClass('on');
	}).mouseout(function() {

		$(this).find('.f_border').hide();
		$(this).find('.f_remove').hide();
		$(this).removeClass('on');
	});
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

// 信息类别切换
function changeType( tBtn,list,box) {

	$('.'+tBtn).click(function() {

		var oList=$(this).parent().parent().parent().parent();

		oList.find('.'+list).find('li').hide();
		oList.find('.'+box).show();
	});
}

// 我的足迹信息分类切换
function changeTrade(id,aclass) {

	$('#'+id).click(function() {

		$(this).parent().find('a').removeClass('active');
		$(this).addClass('active');
		$('.message_list li').hide();
		// $(this).parent().parent().find('.'+aclass).parent().parent().show();
		$(this).parent().parent().find('.'+aclass).show();
	});
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

function deleteAll() {

	var checkObj = $('.collection_list .name i.on');

	if(checkObj.length == 0) {

		alert("请选择需要删除的记录");
		return false;
	} else {

		var flag = confirm("您确定要删除吗?");
		if(flag) {

			var ids = new Array();

			$.each(checkObj, function(n, value) {

				 var id = $(value).attr('info_id'); 
				 ids.push(id);
			 });
			ids = ids.join(",");
			 // alert(ids);
			var url = path + "/personal/deleteAll";
			$.ajax({
				url : url,
				data : {
					'ids' : ids
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
}

function deleteInvalid() {

	var invalidObj = $("[class='clearfix failure_info zhaobiao']");

	if(invalidObj.length == 0) {

		alert("记录中不包含失效信息");
		return false;
	} else {

		var flag = confirm("您确定要删除失效信息吗?");
		if(flag) {

			var ids = new Array();
			$.each(invalidObj, function(n, value) {

				 var id = $(value).attr('id');

				 ids.push(id);
			 });
			ids = ids.join(",");
			// alert(ids);
			var url = path + "/personal/deleteInvalid";
			$.ajax({
				url : url,
				data : {
					'ids' : ids
				},
				type : "POST",
				dataType : "json",
				success : function(data) {

					if(data.success == true) {

						ajaxCustBehaviorList();
					}
				},
				error : function() {

					alert("删除失效信息失败");
				}
			});
		}
	}
}

function deleteById(id) {

	var elementId = "#remove_" + id;
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

					$(elementId).parent().remove();
				}
			},
			error : function() {

				alert("删除失败");
			}
		});
	}
}

function deleteByDate(actionType, infoValid, date) {

	var elementId = "#remove_date_" + date;
	var infoType = $("#info_type").val();
	// alert("infoType = " + infoType);
	var flag = confirm("您确定要删除该日期下的足迹吗?");
	if(flag) {

		var url = path + "/personal/deleteByDate";
		$.ajax({
			url : url,
			data : {
				'actionType' : actionType,
				'infoType' : infoType,
				'infoValidWhere' : infoValid,
				'actionDateWhere' : date
			},
			type : "POST",
			dataType : "json",
			success : function(data) {

				if(data.success == true) {

					$(elementId).parent().parent().remove();
				}
			},
			error : function() {

				alert("删除失败");
			}
		});
	}
}

function getSex() {

	var sex = "";
	var radio = $("input[name='sex']");
	for (var i = 0; i < radio.length; i++) {

		if (radio[i].checked == true) {
			sex = radio[i].value;
			break;
		}
	}
	return sex;
}

function mobilePhoneRuleFun(value) {

	var reg = /^0?(13|15|18|14|17)[0-9]{9}$/;
	if (reg.test(value)) {

		return true;
	} else {

		return false;
	}
}

function custEmailRuleFun(value) {
	var reg = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	if (reg.test(value)) {

		return true;
	} else {

		return false;
	}
}

function custNameRuleFun(value) {

	var reg = /^[\u4e00-\u9fa5]{2,10}$/;
	if (reg.test(value)) {

		return true;
	} else {

		return false;
	}
}

function informationSubmit(userId) {

	var sex = getSex();
	var mobilePhone = $("#mobile_phone").val();
	var custEmail = $("#cust_email").val();
	var custName = $("#name").val();
	var custProvince = $("#province").val();
	var custCity = $("#city").val();
	var address = $("#address").val();
	var companyName = $("#company").val();

	if(sex == '') {

		$('.sex_box b').text('请您选择性别').show();               
		return false;
	}
	
	if(mobilePhone == '') {

		$('.mobile_box b').text('请您填写手机号码').show();              
		return false;
	} else {

		if(!mobilePhoneRuleFun(mobilePhone)) {

            $('.mobile_box b').text('手机号码格式有误，请填写正确的手机号码').show();
			return false;
		}else{

			$('.mobile_box b').text('');
		}
	}
	
	if(custEmail == '') {

		$('.email_box b').text('请您填写邮箱').show();
		return false;
	} else {

		if(!custEmailRuleFun(custEmail)) {

			$('.email_box b').text('邮箱格式有误，请填写正确的邮箱').show();
			return false;
		}else{

			$('.email_box b').text('');
		}
	}
	
	if(custName == '') {

		$('.name_box b').text('请您填写姓名').show();
		return false;
	} else {
		if(!custNameRuleFun(custName)) {

			$('.name_box b').text('请填写真实的姓名（汉字）').show();
			return false;
		}else{
			$('.name_box b').text('');
		}
	}
	
	if(custProvince == '请选择省份') {

		$('.address_box b').text('请选择省份').show();
		return false;
	}else{

		$('.address_box b').text('');
	}
	
	if(custCity == '请选择地市') {

		$('.address_box b').text('请选择城市').show();
		return false;
	}else{

		$('.address_box b').text('');
	}

	if(companyName == '') {

		$('.company_box b').text('请填写公司名称').show();
		return false;
	}else {
		$('.company_box b').text('');
	}
	
	var url = path + "/personal/informationSubmit";
	$.ajax({
		url : url,
		data : {
			'id' : userId,
			'sex' : sex,
			'mobilePhone' : mobilePhone,
			'custEmail' : custEmail,
			'custName' : custName,
			'custProvince' : custProvince,
			'custCity' : custCity,
			'address' : address,
			'companyName' : companyName
		},
		type : "POST",
		dataType : "json",
		success : function(data) {

			if(data.success == true) {
				alert('保存成功！');
			}
		},
		error : function() {

			alert('保存失败！');
		}
	});
}

//更换头像
function changeFace(boxClass) {

	$(boxClass).mouseover(function() {

		$(this).find('a').show();
		$(this).find('a').click(function() {

			$('.shadow_all').show();
			$('.updateImgBox').show();
		})
	}).mouseout(function() {

		$(this).find('a').hide();
	});
}

//执行上传头像操作
function ajaxAvatarUpload(userId) {

	var url = path + "/personal/uploadAvatar";
	$.ajaxFileUpload({
		url : url,
		type : 'POST',
		secureuri : false,
		fileElementId : 'personalAvatar',
		dataType : 'json',
		data : {
			id : userId
		},
		success : function(data) {

			if (data.success == true) {

				var avatarPath = imgPath + "/" + data.message;

				$("img[id='uploadAvatar']").attr("src", avatarPath);
				$("img[id='avatarShow']").attr("src", avatarPath);
			} else {

				alert(data.message);
			}
		},
		error : function() {

			alert("上传头像异常");
		}
	});
}

// 头像上传预览
function uploadFace(file){
 	var imgReg = /(.jpg|.JPG|.jpeg|.JPEG|.png|.PNG|.gif|.GIF){1}/;
 	var uploadFile = document.getElementById('personalAvatar');
 	var uploadError = document.getElementById('uploadError');
 	if(!(imgReg.test(uploadFile.value))){

 		uploadError.innerHTML='上传失败，请选择正确的图片格式';
 		option = false;
 		
 	}else{
		previewImage(file);
		uploadError.innerHTML='上传成功';
		option = true;	
 	}
 	return option ;
 }
function previewImage(file) {
  var MAXWIDTH  = 260; 
  var MAXHEIGHT = 180;
  var div = document.getElementById('preview');
  if (file.files && file.files[0])
  {
      div.innerHTML ='<img id=imghead>';
      var img = document.getElementById('imghead');
      img.onload = function(){
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        img.width  =  rect.width;
        img.height =  rect.height;
      }
      var reader = new FileReader();
      reader.onload = function(evt){img.src = evt.target.result;}
      reader.readAsDataURL(file.files[0]);
  }
  else //兼容IE
  {
    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
    file.select();
    var src = document.selection.createRange().text;
    div.innerHTML = '<img id=imghead>';
    var img = document.getElementById('imghead');
    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;"+sFilter+src+"\"'></div>";
  }
}
function clacImgZoomParam( maxWidth, maxHeight, width, height ){
    var param = {top:0, left:0, width:width, height:height};
    if( width>maxWidth || height>maxHeight )
    {
        rateWidth = width / maxWidth;
        rateHeight = height / maxHeight;
         
        if( rateWidth > rateHeight )
        {
            param.width =  maxWidth;
            param.height = Math.round(height / rateWidth);
        }else
        {
            param.width = Math.round(width / rateHeight);
            param.height = maxHeight;
        }
    }
     
    param.left = Math.round((maxWidth - param.width) / 2);
    param.top = Math.round((maxHeight - param.height) / 2);
    return param;
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

// 保存头像
function saveImg() {
	$('#saveImg').click(function(){

		if(option) {

			var userId = $(this).attr('userId');
			ajaxAvatarUpload(userId);
			$('#personalAvatar').val('');
			$('.updateImgBox').hide();
			$('.shadow_all').hide();
			$('#imghead').attr('src','');
			$('#uploadError').text('');
		}
	})
	$('.cancel').click(function() {

		$('#personalAvatar').val('');
		$('#imghead').attr('src','');
		$('.updateImgBox').hide();
		$('.shadow_all').hide();
		$('#uploadError').text('');
	})
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
