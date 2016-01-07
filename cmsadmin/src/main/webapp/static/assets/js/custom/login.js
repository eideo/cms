jQuery(function($) {
	jQuery.validator.addMethod("loginIdFun", function(value, element) {
		return this.optional(element) || /^[a-zA-Z]{1}([a-zA-Z0-9]|[._-]){3,19}$/.test(value);
	}, "用户名必须是4-20位以字母开头、可带数字、“-”、“_”、“.”的字符串");
	jQuery.validator.addMethod("passwdFun", function(value, element) {
		return this.optional(element) || /^(\w){6,16}$/.test(value);
	}, "密码必须是6-16位以字母、数字、下划线组合的字符串");
	jQuery.validator.addMethod("custNameFun", function(value, element) {
		return this.optional(element) || /^[\u4e00-\u9fa5]{2,10}$/.test(value);
	}, "请填写真实的姓名（汉字）");
	jQuery.validator.addMethod("mobilePhoneFun", function(value, element) {
		return this.optional(element) || /^0?(13|15|18|14|17)[0-9]{9}$/.test(value);
	}, "手机号码格式有误，请输入正确的手机");

	$(document).on('click', '.toolbar a[data-target]', function(e) {
		e.preventDefault();
		var target = $(this).data('target');
		$('.widget-box.visible').removeClass('visible');// hide others
		$(target).addClass('visible');// show target
	});

	// 登录页面切换背景图
	$('#btn-login-dark').on('click', function(e) {
		$('body').attr('class', 'login-layout');
		e.preventDefault();
	});
	$('#btn-login-light').on('click', function(e) {
		$('body').attr('class', 'login-layout light-login');
		e.preventDefault();
	});
	$('#btn-login-blur').on('click', function(e) {
		$('body').attr('class', 'login-layout blur-login');
		e.preventDefault();
	});

	// 验证找回密码表单
	$("#retrieveButton").bind("click", function() {
		// 待开发
		return;
		$('#validationRetrieveForm').submit();
	});
	$('#validationRetrieveForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		ignore : "",
		rules : {
			retrieveEmail : {
				required : true,
				email : true
			}
		},
		messages : {
			retrieveEmail : {
				required : "请填写邮箱",
				email : "请填写正确的邮箱"
			}
		},
		highlight : function(e) {
			$(e).closest('label').removeClass('has-info').addClass('has-error');
		},
		success : function(e) {
			$(e).closest('label').removeClass('has-error');// .addClass('has-info');
			$(e).remove();
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function(form) {
			$.ajax({
				dataType : "json",
				url : getContextPath() + "/sys/sysuser/retrievePassword",
				type : "post",
				data : {
					retrieveEmail : $('#retrieveEmail').val()
				},
				complete : function(xmlRequest) {
					var returninfo = eval("(" + xmlRequest.responseText + ")");
					if (returninfo.result == 1) {
						$("#retrieveTip").html("找回密码邮件已经发到您的邮箱");
					} else if (returninfo.result == -1) {
						$("#retrieveTip").html("密保邮箱不存在，请重新输入");
					}
				}
			});
		},
		invalidHandler : function(form) {
		}
	});

	// 按回车键触发登录事件
	$(document).keydown(function(event) {
		var key = window.event ? event.keyCode : event.which;
		if (key == 13) {
			$('#validationLoginForm').submit();
		}
	});

	// 验证登录表单
	$("#loginButton").bind("click", function() {
		$('#validationLoginForm').submit();
	});
	$('#validationLoginForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		ignore : "",
		rules : {
			loginId : {
				required : true
			},
			loginPasswd : {
				required : true,
				minlength : 6,
				maxlength : 16
			}
		},
		messages : {
			loginId : {
				required : "请填写用户名"
			},
			loginPasswd : {
				required : "请输入密码",
				minlength : "密码长度至少为6个字符",
				maxlength : "密码长度至多为16个字符"
			}
		},
		highlight : function(e) {
			$(e).closest('label').removeClass('has-info').addClass('has-error');
		},
		success : function(e) {
			$(e).closest('label').removeClass('has-error');// .addClass('has-info');
			$(e).remove();
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
			//error.appendTo('#invalid');
		},
		submitHandler : function(form) {
			/*$.ajax({
				dataType : "json",
				url : getContextPath() + "/sys/sysuser/login",
				type : "post",
				data : {
					loginId : $('#loginId').val(),
					loginPasswd : $('#loginPasswd').val(),
					rememberMe : $("input[name='rememberMe']:checked").val()
				},
				complete : function(xmlRequest) {
					var returninfo = eval("(" + xmlRequest.responseText + ")");
					if (returninfo.result == 1) {
						document.location.href = getContextPath() + "/sys/sysuser/home";
					} else if (returninfo.result == -1) {
						$("#loginTip").html("用户名有误或已被禁用");
					} else if (returninfo.result == -2) {
						$("#loginTip").html("密码错误");
					} else {
						$("#loginTip").html("服务器错误");
					}
				}
			});*/
			
			// 单点登录认证
			$.ajax({
				dataType : "jsonp",
				url : 'http://101.200.0.81/cas/ajaxlogin',
				type : "post",
				data : {
					user : $('#loginId').val(),
					passwd : $('#loginPasswd').val(),
					service : getHostPath() + getContextPath() + '/sys/sysuser/home'
				},
				jsonp : 'jsoncallback',
				success : function(data) {
					if (data.result) {
						$.ajax({
							dataType : "json",
							url : getContextPath() + "/sys/sysuser/login",
							type : "post",
							data : {
								ticket : data.st,
								loginId : $('#loginId').val(),
								loginPasswd : $('#loginPasswd').val(),
								rememberMe : $("input[name='rememberMe']:checked").val()
							},
							complete : function(xmlRequest) {
								var returninfo = eval("(" + xmlRequest.responseText + ")");
								if (returninfo.result == 1) {
									document.location.href = getContextPath() + "/sys/sysuser/home?ticket=" + data.st;
								} else if (returninfo.result == -1) {
									$("#loginTip").html("单点登录认证错误");
								} else {
									$("#loginTip").html("单点登录服务器异常");
								}
							}
						});
					} else {
						$("#loginTip").html("用户名无效或密码错误");
					}
				},
				error : function() {
					$("#loginTip").html("单点登录服务器异常");
				}
			});
		},
		invalidHandler : function(form) {
		}
	});

	$('[data-rel=tooltip]').tooltip({
		container : 'body'
	});
	
	$('#custBirthday').datepicker({
	    format: 'yyyy-mm-dd',
	    language: 'zh-CN'
	});

	// 验证注册表单
	$("#registerButton").bind("click", function() {
		$('#validationRegisterForm').submit();
	});
	$('#validationRegisterForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		ignore : "",
		rules : {
			registerLoginId : {
				required : true,
				loginIdFun :  true
			},
			custName : {
				required : true,
				custNameFun : true
			},
			sex : {
				required : true
			},
			custEmail : {
				required : true,
				email : true,
				maxlength : 50
			},
			mobilePhone : {
				required : true,
				mobilePhoneFun : true
			},
			custBirthday : {
				required : false
			},
			registerPasswd : {
				required : true,
				passwdFun : true
			},
			repeatPasswd : {
				required : true,
				passwdFun : true,
				equalTo : "#registerPasswd"
			},
			agree : {
				required : true,
			}
		},
		messages : {
			registerLoginId : {
				required : "请填写用户名"
			},
			custName : {
				required : "请填写姓名"
			},
			sex : "请选择性别",
			custEmail : {
				required : "请填写邮箱",
				email : "请填写正确的邮箱",
				maxlength : "邮箱长度至多为50个字符"
			},
			mobilePhone : {
				required : "请填写手机"
			},
			registerPasswd : {
				required : "请输入密码"
			},
			repeatPasswd : {
				required : "请输入确认密码",
				equalTo : "密码和确认密码不一致"
			},
			agree : "您还未接受用户协议"
		},
		highlight : function(e) {
			$(e).closest('label').removeClass('has-info').addClass('has-error');
		},
		success : function(e) {
			$(e).closest('label').removeClass('has-error');// .addClass('has-info');
			$(e).remove();
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function(form) {
			$.ajax({
				dataType : "json",
				url : getContextPath() + "/sys/sysuser/register",
				type : "post",
				data : {
					loginId : $('#registerLoginId').val(),
					custName : $('#custName').val(),
					sex : $("input[name='sex']:checked").val(),
					custEmail : $('#custEmail').val(),
					mobilePhone : $('#mobilePhone').val(),
					custBirthday : $('#custBirthday').val(),
					loginPasswd : $('#registerPasswd').val()
				},
				complete : function(xmlRequest) {
					var returninfo = eval("(" + xmlRequest.responseText + ")");
					if (returninfo.result == 1) {
						document.location.href = getContextPath() + "/sys/sysuser/home";
					} else if (returninfo.result == -1) {
						$("#registerTip").html("此用户名已被注册");
					} else if (returninfo.result == -2) {
						$("#registerTip").html("此邮箱已被注册");
					} else if (returninfo.result == -3) {
						$("#registerTip").html("此手机已被注册");
					} else {
						$("#registerTip").html("服务器错误");
					}
				}
			});
		},
		invalidHandler : function(form) {
		}
	});
});
