/* 
* @Author: zhanganchun
* @Date:   2016-02-24 16:49:01
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-02-25 09:21:36
*/

'use strict';

var option = null;
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
    file.blur();
    var src = document.selection.createRange().text;
    div.innerHTML = '<img id=imghead>';
    var img = document.getElementById('imghead');
    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;"+sFilter+src+"\"'></div>";
  }
}

function clacImgZoomParam( maxWidth, maxHeight, width, height ) {
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

// 保存头像
function saveImg() {
	$('#saveImg').click(function() {

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

/*用户信息保存*/
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
	}else {

		$('.sex_box b').text('')
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

//图像加载出错时处理
function errorAvatar(img) {

	img.src = resPath + "/resources/commons/images/face.png";
	img.onerror = null;
}

function errorAvatarTwo(img) {

	img.src = resPath + "/resources/commons/images/face2.png";
	img.onerror = null;
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

$(function(){

	$('#changeInfo').on('click',function(e) {

		informationSubmit(userId)
	})

	changeFace('.my_info_box .face');

	saveImg();
})