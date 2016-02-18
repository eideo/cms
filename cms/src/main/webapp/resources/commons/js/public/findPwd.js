/* 
 * @Author: zhanganchun
 * @Date:   2016-02-01 16:39:51
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-18 15:46:17
 */

'use strict';

var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,
	phoneReg = /^1[3|4|5|8][0-9]\d{8}$/,
	passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

var pswFlag = {
	phone: false,
	email: false,
	code: false,
	password: false,
	emailCode: false,
	resetpassword: false,
	phoneName:'',
	phoneCodeName:'',
	uuid: ''
}

var emailAndPhone = function() {

	$('#emailTab').on('click', function(e) {

		$(this).find('input').attr('checked', true)
		$('#phoneTab').find('input').attr('checked', false)
		$('.emailBox').show()

		if ($('.phoneBox').css('display') === 'block') {
			$('.phoneBox').hide()
		}
		if ($('.validBox').css('display') === 'block') {
			$('.validBox').hide()
		}

		if ($('.reSendCode').css('display') === 'block') {
			$('.reSendCode').hide()
		}
		$('.error').hide()
	})

	$('#phoneTab').on('click', function(e) {

		$(this).find('input').attr('checked', true)
		$('#emailTab').find('input').attr('checked', false)

		if ($('.emailBox').css('display') === 'block') {
			$('.emailBox').hide()
		}
		if ($('.validBox').css('display') === 'block') {
			$('.validBox').hide()
		}
		if ($('.reSendCode').css('display') === 'block') {
			$('.reSendCode').hide()
		}
		$('.phoneBox').show()
		$('.error').hide()
	})
}

var sendEmail = function() {

	$.ajax({
		url: path + '/mail/sendPassResetMail',
		async: false,
		dataType: 'text',
		type: "post",
		data: {
			to: $('#email').val()
		},
		success: function(str) {

			var json = eval("(" + str + ")");

			if (json.success) {

				$('.flagCon').hide()
				$('.successCon').show()
			} else {

			}
		},
		error: function() {
			$.Message({
				text: '请求异常',
				type: "failure"
			})
		}
	})
}

var controlState = function() {

	clearInterval(interval);

	var minitus = 30;
	var interval = setInterval(function() {

		$('.reSendCode #reSend').html(minitus + '秒后可重发');
		$('.validBtn').css('background','#cccccc')
		minitus --;

		if (minitus === -1) {

			clearInterval(interval)
			$('.validBtn').css('background','#47aaff')
			$('.reSendCode #reSend').html('重新发送')
		}
	},1000)
}

var getUUID = function() {

	$.ajax({
		url: path + '/phoneResetCheck',
		async: false,
		dataType: 'text',
		type: "post",
		data: {
			phone: pswFlag.phoneName,
			phoneCode:pswFlag.phoneCodeName
		},
		success: function(str) {

			var json = eval("(" + str + ")");
			if (json.status) {

				window.location.href = path+"/resetPwd?uuid="+json.uuid
			} else {

			}
		},
		error: function() {
			$.Message({
				text: '请求异常',
				type: "failure"
			})
		}
	})
}

$(function() {

	function setInfo(context, flag, text) {

		var $dom = $(context + " .error")

		if (flag) {

			$(context + " .flagState").show()
			$('.error').hide()
		} else {

			$dom.show().text(text);
		}
	}

	// 刷新验证码
	function reloadcode() {

		var verify = document.getElementById('codeImg');
		verify.setAttribute('src', path + '/common/makeCertPic.jsp?it=' + Math.random());
	}

	$('#codeImg').click(function() {

		reloadcode()
	})

	/*手机号验证，发请求*/
	$('#phone').on('blur', function(e) {

		var valueFlag = phoneReg.test($(this).val())

		if (!valueFlag) {

			setInfo('.phoneBox', false, "输入不正确，请重新输入");

		} else {

			$.ajax({
				url: path + '/checkUserName',
				async: false,
				dataType: 'text',
				type: "post",
				data: {

					username: $('#phone').val()
				},
				success: function(str) {

					var json = eval("(" + str + ")");
					if (json.status) {

						pswFlag.phone = false;
						setInfo('.phoneBox', false, '用户不存在,请重新填写');
					} else {

						setInfo('.phoneBox', true, '用户名输入正确');
						pswFlag.phone = true;
						pswFlag.phoneName = $('#phone').val()
					}
				},
				error: function() {
					$.Message({
						text: '请求异常',
						type: "failure"
					})
					pswFlag.phone = false;
				}
			})
		}
	})

	// 获取验证码
	$('.phoneBox .sendBtn,#reSend').on('click', function() {

		if (pswFlag.phone) {

			$.ajax({

				url: path + '/sendmes',
				dataType: 'text',
				type: "post",
				data: {

					mobile: $('#phone').val() || pswFlag.phoneName
				},
				success: function(data) {

					var json = eval("(" + data + ")");

					if (json.status) {

						$('.phoneBox').hide()
						$('.validBox').show()
						$('.reSendCode').show()

						controlState()

					} else {

						$.Message({
							text: '请求异常',
							type: "failure"
						})
					}
				},
				error: function() {

					$.Message({
						text: '请求异常',
						type: "failure"
					})

					setInfo('.codeBox', false, "请求异常！");
				}
			})
		}
	})

	/*验证码输入*/
	$('.validBox .validBtn').on('click', function(e) {


		var length = $('#phoneCode').val().length;

		if (!isNaN($('#phoneCode').val()) && length === 4 && pswFlag.phone) {

			$.ajax({

				url: path + '/checkmes',
				async: false,
				dataType: 'text',
				type: 'POST',
				data: {
					mobileMessage: $('#phoneCode').val()
				},
				success: function(data) {

					var json = eval("(" + data + ")");

					if (json.status) {

						pswFlag.code = true;
						pswFlag.phoneCodeName = $('#phoneCode').val()
						
						getUUID()
						
					} else {

						$('.flagCon').hide()
						$('.failCon').show()

						pswFlag.code = false;	
					}
				},
				error: function() {

				}
			})
		}
	})

	/*第一次输入密码*/
	$('#psw').on('blur', function(e) {

		var value = $('#psw').val(),
			reValue = $('#rePsw').val();

		if (value === '') {

			setInfo('.pswBox', false, '密码不能为空！');

		} else {

			if (passwordReg.test(value)) {

				pswFlag.password = true
				setInfo('.pswBox', true, '密码输入正确');
			} else {

				pswFlag.password = false
				setInfo('.pswBox', false, '密码格式不正确');
			}
		}
	})

	/*再次确认密码*/
	$('#rePsw').on('blur', function(e) {

		var value = $('#psw').val(),
			reValue = $('#rePsw').val();

		if (reValue === '') {

			setInfo('.rePswBox', false, '密码不能为空！');

		} else {

			if (!passwordReg.test(reValue)) {

				setInfo('.rePswBox', false, '密码格式不正确');

			} else if (value !== '' && value !== reValue) {

				setInfo('.rePswBox', false, '两次密码输入不一致');

			} else {

				pswFlag.resetpassword = true
				setInfo('.rePswBox', true, '密码输入正确');
			}
		}
	})

	/*修改密码*/
	$('.submitBox #changeBtn').on('click', function(e) {

		var url = window.location.href,
			uuid = url.split('?')[1].split('=')[1]

		if (pswFlag.password && pswFlag.resetpassword) {

			$.ajax({
				url: path + '/updatePass',
				dataType: 'text',
				async: false,
				type: 'post',
				data: {
					password: $('#rePsw').val(),
					uuid: $('#uuid').val()
				},
				success: function(data) {

					$('.resetCon').hide()
					$('.stateCon').show()

					$('.tabCon .step2').removeClass('selected').addClass('dVaild')
					$('.tabCon .step3').addClass('selected')

					$('.tabCon .step2').find('i').removeClass('active').addClass('vaild')
					$('.tabCon .step3').find('i').addClass('active')
					/*
					setTimeout(function() {
						location.href = casPath;
					}, 5000000)*/
				},
				error: function() {

					$.Message({
						text: '请求异常',
						type: "failure"
					})
				}
			})

		} else {

			$.Message({
				text: '请检查密码是否填写',
				type: "failure"
			})
		}
	})

	/*邮箱验证码校验，已作废*/
	$('.validBox validBtn1').on('click', function(e) {

		if ($('#code').val() == '') {

			setInfo('.codeBox', false, '验证码不能为空');
			pswFlag.emailCode = false;

		} else {

			$.ajax({

				url: path + '/getCertCodeStatus',
				async: false,
				dataType: 'text',
				type: 'POST',
				data: {
					certCode: $('#code').val()
				},
				success: function(data) {

					var json = eval("(" + data + ")");

					if (json.status) {

						setInfo('.codeBox', true, '验证码正确');
						pswFlag.emailCode = true;
					} else {

						setInfo('.codeBox', false, '验证码错误');
						pswFlag.emailCode = false;
					}
				},
				error: function() {

					$.Message({
						text: '请求异常',
						type: "failure"
					})
					pswFlag.emailCode = false;
				}
			})
		}
	})

	/*邮箱输入*/
	$('#email').on('blur', function(e) {

		var valueFlag = emailReg.test($(this).val())

		if (!valueFlag) {

			setInfo('.emialBox', false, "输入不正确，请重新输入");

		} else {

			$.ajax({
				url: path + '/checkUserName',
				async: false,
				dataType: 'text',
				type: "post",
				data: {

					username: $('#email').val()
				},
				success: function(str) {

					var json = eval("(" + str + ")");
					if (json.status) {

						pswFlag.email = false;
						setInfo('.emailBox', false, '邮箱不存在,请重新填写');
					} else {

						$('.emailBox .flagState').show()
						if ($('.emailBox .error').css('display') === 'block') {$('.emailBox .error').hide()}
						pswFlag.email = true;
					}
				},
				error: function() {
					$.Message({
						text: '请求异常',
						type: "failure"
					})
					pswFlag.email = false;
				}
			})
		}
	})

	$('.emailBox .sendBtn').on('click', function(e) {

		sendEmail()
	})

	emailAndPhone()
})