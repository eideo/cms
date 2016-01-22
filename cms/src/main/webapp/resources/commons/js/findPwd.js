'use strict';
$(function() {

	tab();

	verification();

	emailSubmit();

	phoneSubmit();

	passwordSubmit();
})

function tab() {

	$('.sign span').click(function() {

		$('.box').hide();
		$('.box').eq($(this).index()).show();
		$('.error').text('');
	})

	$('.emailBtn').click(function() {

		$('.sign i').animate({"left":"110"});
	})
	$('.phoneBtn').click(function() {

		$('.sign i').animate({"left":"0"});
	})
}

var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
var phoneReg = /^1[3|4|5|8][0-9]\d{8}$/;
var passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

// 验证
function verification() {

	$('#email').blur(function () {
		userVerification('email',emailReg,'emailBox');	
	})

	$('#phone').blur(function () {
		userVerification('phone',phoneReg,'phoneBox');	
	})

	$('.emailCode').bind('input propertychange', function() {

	    codeVerification();
	});

	$('.codeBtn').click(function () {

		getPhoneCode();
	})

	$('.phoneCode').bind('input propertychange', function() {

	    phoneCodeVerification();
	});

	$('#password').blur(function () {

		passwordVerification();
	})

	$('#repassword').blur(function () {

		repasswordVerification();
	})

}

function userVerification(inputId,reg,box) {

	var result =true;
	if($('#'+inputId).val() =='') {

		$('.'+box+' .error').text('用户不能为空');
		result = false
	}else {
		if(reg.test($('#'+inputId).val())){
			
			$.ajax({
				url:path+'/checkUserName',
				async:false,
				dataType:'text',
				type: "post",
				data:{

					username:$('#'+inputId).val()
				},
				success: function(str) {

					
					var json = eval("("+str+")");
					if(json.status) {

						result =false;
						$('.'+box+' .error').text('用户不存在,请重新填写');
					}else {

						$('.'+box+' .error').text('');
						result =true;
					}
				},
				error: function() {

					$.Message({
						text:'请求异常',
						type:"failure"
					})
					result =false;
				}
			})
		}else {

			$('.'+box+' .error').text('格式不正确');
			result =false;
		}
	}
	return result;
}
// 刷新验证码
function reloadcode() {

    var verify=document.getElementById('codeImg');
    verify.setAttribute('src',path+'/common/makeCertPic.jsp?it='+Math.random());
}

// 邮箱验证码验证

function codeVerification() {

	var result = true ;
	if($('#code').val() == '') {

		$('.codeBox .error').text('验证码不能为空');
		result = false;
	}else{
		$.ajax({

			url:path+'/getCertCodeStatus',
			async:false,
			dataType:'text',
			type:'POST',
			data:{
				certCode:$('#code').val()
			},
			success:function (data) {

				var json = eval("("+data+")");
				if(json.status) {

					$('.codeBox .error').text('');
					result = true;
				}else {

					$('.codeBox .error').text('验证码错误');
					result = false;
				}
			},
			error:function () {

				$.Message({
					text:'请求异常',
					type:"failure"
				})
				result = false;
			}
		})
		return result;
	}
	return result;
}

function passwordVerification() {

	var result = true;

	if($('#password').val() == '') {

		$('.passwordBox .error').text('用户名不能为空');
		result = false
	}else {

		if(passwordReg.test($('#password').val())) {

			$('.passwordBox .error').text('');
			result = true;
		}else {

			$('.passwordBox .error').text('密码格式不正确');
			result = false;
		}
	}
	return result;
}

function repasswordVerification() {

	var result =true;
	if($('#repassword').val() != $('#password').val()) {

		$('.rePasswordBox .error').text('两次输入密码不一致');
		result = false
	}else {

		$('.rePasswordBox .error').text('');
		result =true;
	}
	console.log(result);
	return result

}
// 提交验证

function emailSubmit() {

	$('#emailSubmit').click(function() {

		console.log(userVerification('email',emailReg,'emailBox'))
		console.log(codeVerification())
		if(!codeVerification()) {

			return false
		}

		if(!(userVerification('email',emailReg,'emailBox'))){

			return false
		}
	})
}

function phoneSubmit() {

	$('#phoneSubmit').click(function() {

		if(!phoneCodeVerification()) {

			return false
		}

		if(!(userVerification('phone',phoneReg,'phoneBox'))){

			return false
		}
	})
}

function passwordSubmit() {

	$('#changeBtn').click(function() {

		console.log(passwordVerification());
		if(!passwordVerification()) {

			return false
		}

		console.log(repasswordVerification());
		if(!repasswordVerification()){

			return false
		}
		setPassword();		
	})
}
// 获取短信验证码
function getPhoneCode() {

	$.ajax({
		url:path+'/sendmes',
		dataType:'text',
		type: "post",
		data:{

			mobile:$('#phone').val()
		},
		success:function(str) {

			var json = eval("("+str+")");
			if(json.status) {

				alert('已发送验证码');
			}
		},
		error:function(e) {

			alert('错误:'+e);
		}
	});
}

function phoneCodeVerification() {

	if($('#phoneCode').val()=="") {

		$('.phoneCode .error').text('验证码不能为空')
		return false;
	}else {

		var result = true;
		$.ajax({
			url:path+'/checkmes',
			async:false,
			dataType:'text',
			type: "post",
			data:{
				mobileMessage:$('#phoneCode').val()
			},
			success:function(str) {

				var json = eval("("+str+")");
				if(json.status) {

					$('.phoneCode .error').text('验证码正确');
					result = true;
				}else {

					$('.phoneCode .error').text('验证码不正确');
					result = false;
				}
			},
			error:function(e) {

				$.Message({
					text:'请求异常',
					type:"failure"
				})
				result = false;
			}
		});
		return result;
	}
}

// 获取短信验证码倒计时


// 修改密码
function setPassword() {

	$.ajax({
		url:path+'/updatePass',
		dataType:'text',
		async:false,
		type:'post',
		data:{
			password:$('#repassword').val(),
			uuid:$('#uuid').val()
		},
		success:function (data) {
			$.Message({
				text:'修改成功'
			})

			location.href = casPath;
		},
		error:function() {

			$.Message({
				text:'请求异常',
				type:"failure"
			})
		}
	})
}


