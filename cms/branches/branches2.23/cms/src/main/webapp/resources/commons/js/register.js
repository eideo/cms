"use strict";
//验证正则表达式

//验证电话号码
var reMoblie=/^1[3|4|5|8][0-9]\d{8}$/

//验证密码
var rePassword=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

//验证个人用户名
var rePerson=/^[\w.]{6,20}$/;

//公司名称验证
var reCompany=/^[\u4e00-\u9fa5]{6,20}$/;

//邮箱验证
var reEmail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/ ;

//个人用户和企业用户注册框切换
function tab() {

	$('.personal').click(function() {

		if($('#username').val() == ''){

			$('#mobile').hide();
			$('#code').show();
		}

		$('#div1').show();
		$('#div2').hide();
		$(this).find('em').animate({left:'0'});
		$('#div2 input').val('');
		$('#div2 span').hide();
	})

	$('.company').click(function() {

		$('#div2').show();
		$('#div1').hide();
		$('.personal em').animate({left:'126px'});
		$('#div1 input').val('');
		$('#div1 span').hide();
	})
}

//验证用户名
var usernameCkeck = function () {

	var result = true;

	if($('#username').val()=='') {

		$('.user-box span').hide();
		$('.nullmsg').show();

		result =false;
	}else {

		$('.nullmsg').hide();

		if(!(reMoblie.test($('#username').val())||reEmail.test($('#username').val()))) {

			$('.user-box span').hide();
			$('.errormsg').show();

			result =false;
		}else{

			$('.errormsg').hide();

			var result = true;

            //用户名是否重复
			$.ajax({

				url:path+'/checkUserName',
				async:false,
				dataType:'text',
				type: "post",
				data:{

					username:$('#username').val()
				},
				success:function(str) {

					console.log(str)
					var json = eval("("+str+")");
					if(json.status) {

						result =  true;
						$('#s-name').hide();
						$('#d-name').show();
						if(reMoblie.test($('#username').val())) {

							$('#mobile').show();
							$('#code').hide();
						}else {

							$('#mobile').hide();
							$('#code').show();
						}	
					}else {

						result =  false;
						$('#s-name').show();
						$('#d-name').hide();
					}
				},
				error:function(e) {

					alert('错误:'+e);
					result =  false;
				}
			});
			return result;
		}
	}
	return result;
};

//密码验证
function passwordCkeck() {

	var result = true;
	if(!(rePassword.test($('#password').val()))) {

		$('#p-error').show();
		result = false;
	}else {

		$('#p-error').hide();
		result = true;
	}	
	return result;
}

function r_passwordCkeck() {

	var result = true;

	if(($('#r-password').val()!=$('#password').val())) {

		$('#rp-error').show();
		result = false;
	}else {

		$('#rp-error').hide();
		result = true;
	}
	return result;
}

//验证码验证
function codeCkeck() {

	var result = true;

	$.ajax({
		async:false,
		url:path+'/getCertCodeStatus',
		dataType:'text',
		type: "post",
		data:{
			certCode:$('#v-code').val()
		},

		success:function(str) {

			var json = eval("("+str+")");

			if(json.status) {

				$('#c-error').hide();
				result = true;
			}else {

				$('#c-error').show();
				result = false;
			}
			return result;
		},
		error:function(e) {

			alert('错误:'+e);
			result = false;
		}
	});
	return result;
}

//公司名验证
function companyNameCkeck() {

	var result=true;
	if($('#company-name').val()=='') {

		$('.user-box span').hide();
		$('#u-error2null').show();
		result = false;
	}else {

		$('#u-error2null').hide();
		if(!(reCompany.test($('#company-name').val()))) {

			$('#u-error2').show();
			result = false;
		}else {

			var result = true;
			//公司名重名验证
			$.ajax({

				url:path+'/checkUserName',
				async:false,
				dataType:'text',
				type: "post",
				data:{

					username:$('#company-name').val()
				},
				success:function(str) {

					var json = eval("("+str+")");
					if(json.status) {

						$('#s-name2').hide();
						$('#d-name2').show();
						result =  true;
					}else {

						$('#s-name2').show();
						$('#d-name2').hide();
						result =  false;
					}
				},
				error:function(e) {

					alert('错误:'+e);
					
					result =  false;
				}
			});
		}
	}	
	return result;
}
//联系人手机号验证
function phoneCheck() {

	var result=true;
	if(!(reMoblie.test($('#user-mobile').val()))) {

		$('#mobile2').show();
		result=false;
	}else {

		result=true;
	}
	return result;
}

//公司用户密码验证
function c_passwordCkeck() {

	var result=true;
	if(!(rePassword.test($('#password2').val()))) {

		$('#p-error2').show();
		result = false;
	}else {

		$('#p-error2').hide();
		result = true;
	}
	return result;
}
function rc_passwordCkeck() {

	var result=true;
	if(($('#r-password2').val()!=$('#password2').val())) {

		$('#rp-error2').show();
		result = false;
	}else {

		$('#rp-error2').hide();
		result = true;
	}	
	return result;
}

//个人注册表单验证
var oUser=$('#username');
var oMobile=$('#mobile');
var oUerror=$('#u-error');
var oSname=$('#s-name');
var oDname=$('#d-name');
var mCode=$("#m-code");
//密码验证
var oPassword=$('#password');
var oPerror=$('#p-error');
var oRpassword=$('#r-password');
var oRperror=$('#rp-error');
//验证码验证
var oVcode=$('#v-code');
var oCerror=$('#c-error');
var mError = $("#m-error");

//企业注册表单验证
var oUser2=$('#company-name');
var oSname2=$('#s-name2');
var oDname2=$('#d-name2');
var oUerror2=$('#u-error2');
var oMobile2=$('#user-mobile');
var oMerror=$('#mobile2');
var oMerror2=$('#mobile3');
var oPassword2=$('#password2');
var oPerror2=$('#p-error2');
var oRpassword2=$('#r-password2');
var oRperror2=$('#rp-error2');
window.onload=function() {

	tab();
	$('#username').on("blur",usernameCkeck);
	$('#username').focus(function() {

		$('.user-box span').hide();
	})

	$('#password').on("blur",passwordCkeck);
	$('#r-password').on("blur",r_passwordCkeck);

	$('#password').focus(function() {

		$('.password-box span').hide();
	})

	$('#r-password').focus(function() {

		$('.r-password-box span').hide();
	})
	
	$('#v-code').on("blur",codeCkeck);

	$('#v-code').focus(function() {

		$('#c-error').hide();
	})
	
	$('#company-name').on("blur",companyNameCkeck);

	$('#company-name').focus(function() {

		$('.user-box span').hide();
	})
	
	$('#user-mobile').on("blur",phoneCheck);

	$('#user-mobile').focus(function() {

		$('#mobile2').hide();
	})
	
	$('#password2').on("blur",c_passwordCkeck);

	$('#r-password2').on("blur",rc_passwordCkeck);

	$('#password2').focus(function() {

		$('.r-password-box span').hide();
	})

	$('#r-password2').focus(function() {

		$('.r-password-box span').hide();
	})

	mCode.on("blur",phoneCodeValidate);

	mCode.on("focus",function() {

		mError.hide();
	});
	
//	短信定时器
	var wait=60;

	$('#mBtn').click(function() {

		$(this).hide();
		$('#relaunch').show();

		clearInterval(timer);
		var timer=setInterval(function() {

			wait--;
			if(wait<0) {

				wait=60;
			}
			if(wait==0) {

				clearInterval(timer);
				$('#mBtn').show();
				$('#relaunch').hide();

			}else {

				$('#relaunch b').text(wait);
			}
		},1000)
	})

}



var user2Validate = function () {

	if(!(cR.test(oUser2.value))) {

		oUerror2.style.display='block';
		return false;
	}else {

		var result = true;
		//公司名重名验证
		$.ajax({

			url:path+'/checkUserName',
			async:false,
			dataType:'text',
			type: "post",
			data:{

				username:oUser2.value
			},
			success:function(str) {

				var json = eval("("+str+")");
				if(json.status) {

					oDname2.style.display='block';
					oSname2.style.display='none';
					result =  true;
				}else {

					oSname2.style.display='block';
					oDname2.style.display='none';
					result =  false;
				}
			},
			error:function(e) {

				alert('错误:'+e);
				
				result =  false;
			}
		});
		return result ;
	}
}

var oMobileValidate = function  () {

	if(!(uRe.test(oMobile2.value))) {

		oMerror.style.display='block';
		return false;
	}else {

		var result = true;
		//号码注册
		$.ajax({
			url:path+'/checkUserName',
			async:false,
			dataType:'text',
			type: "post",
			data:{
				username:oMobile2.value
			},
			success:function(str){
				var json = eval("("+str+")");
				if(json.status){
					oMerror2.style.display='none';
					result =  true;
				}else{
					oMerror2.style.display='block';
					result =  false;
				}
			},
			error:function(e){
				alert('错误:'+e);
				result =  false;
			}
		});
		return result;
	}
}


var phoneCodeValidate = function() {

	if(mCode.val()=="") {

		return false;
	}else {

		var result = true;
		$.ajax({
			url:path+'/checkmes',
			async:false,
			dataType:'text',
			type: "post",
			data:{
				mobileMessage:mCode.val()
			},
			success:function(str) {

				var json = eval("("+str+")");
				if(json.status) {

					mError.hide();
					result = true;
				}else {

					mError.show();
					result = false;
				}
			},
			error:function(e) {

				alert('错误:'+e);
				result = false;
			}
		});
		return result;
	}
}
function getPhoneCode() {

	$.ajax({
		url:path+'/sendmes',
		dataType:'text',
		type: "post",
		data:{

			mobile:oUser.val()
		},
		success:function(str) {

			var json = eval("("+str+")");
			if(json.status) {

				oMerror2.hide();
			}
		},
		error:function(e) {

			alert('错误:'+e);
		}
	});
}
var i = 60;
function setTime() {

	var a = document.getElementById("mBtn");
	var str = "获取验证码";
	if(i==0){ 

		clearTimeout();
		i = 60;
		a.innerText = str;
		return;
	}

	a.innerText = str+"("+i+")";
	i--;
	setTimeout("setTime()", 1000);
}
function reloadcode() {

    var verify=document.getElementById('codeImg');
    verify.setAttribute('src',path+'/common/makeCertPic.jsp?it='+Math.random());
}

function validateUserAll() {

	if(!usernameCkeck()) {

		return false;
	}
	if(reMoblie.test(oUser.val())&&!phoneCodeValidate()) {

		return false;
	}
	if(!passwordCkeck()) {

		return false;
	}
	if(!r_passwordCkeck()) {

		return false;
	};
	if(!reMoblie.test(oUser.val())&&!codeCkeck()) {

		return false;
	}
	return true;
}
function validateCompanyAll() {

	if(!companyNameCkeck()) {

		return false;
	};

	if(!c_passwordCkeck()) {

		return false;
	}
	if(!rc_passwordCkeck()) {

		return false;
	}
	return true;
}

function ajaxSubmit() {

	var forms  = document.getElementsByName("reform");
	var inputs = forms[0].getElementsByTagName("input");
	var obj = {};

	for(var i=0;i<inputs.length;i++) {

		if(inputs[i].name&&inputs[i].value) {

			obj[inputs[i].name] = inputs[i].value;
		}
	}

	if(!(($("#h3 em").css("left")=="0px"&&validateUserAll())||($("#h3 em").css("left")!="0px"&&validateCompanyAll()))) {

		return false;
	}
	ajax({

		url:path+"/registerMember",
		data:obj,
		success:function(str) {

			var json = eval('('+str+')');
			if(json.status) {

				var user = obj.username?obj.username:obj["user-mobile"];
				var password = obj.password?obj.password:obj.password2;
				$.ajax({

					type:"post",
					async:true,
					url:casBase+'/ajaxlogin',data:{user:user,passwd:password,service:path+'/homepage'},
					dataType:"jsonp",
					jsonp:'jsoncallback',
					success:function(a) {

						if(a.result) {

							location.href = path+"/homepage?ticket="+a.st;
						}
					}
				});
			}else {

				alert("注册信息有误，请重新填写！");
			}
		},
		error:function(e) {

			alert('错误:'+e);
		}
	});
	return false;
}

function toLoadTest() {

	$.ajax({
		
		type:"post",
		async:true,
		url:casBase+'/ajaxlogin',data:{user:'testUserForSys',passwd:'123456',service:path+'/homepage'},
		dataType:"jsonp",
		jsonp:'jsoncallback',
		success:function(a) {

			if(a.result) {

				location.href = path+"/homepage?ticket="+a.st;
			}
		}
	});
}
