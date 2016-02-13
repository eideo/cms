/* 
 * @Author: zhanganchun
 * @Date:   2016-02-01 16:39:51
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-02 17:17:01
 */

'use strict';

$(function() {

	var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,
		phoneReg = /^1[3|4|5|8][0-9]\d{8}$/,
		passwordReg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;

	var pswFlag = {
		username: false,
		code: false,
		password: false,
		emailCode: false,
		resetpassword: false,
		uuid:''
	}

	checkFromEmail()

	function setInfo(context, flag, text) {

		var $dom = $(context + " i")

		if ($dom.hasClass('error')) {
			$dom.removeClass('error')
		}
		if ($dom.hasClass('success')) {
			$dom.removeClass('success')
		}

		if (flag === true) {

			$dom.addClass("success").text(text);

		} else {

			$dom.addClass("error").text(text);
		}
	}

	function checkFromEmail() {

		//findPwd?from=email&&uuid=3253
		var url = window.location.href.split('?')[1],
			uuid;
		
		if (url) {

			pswFlag.uuid = uuid = url.split('&&')[1].split('=')[1];

			$('.content .findBox').css('display', 'none')
			$('.content .resetBox').css('display', 'block')
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

	/*
	  urlArgs: 接口名
	  type:http类型
	  data:参数
	  urlArgs,type,data,dataType,sucessTrue,successFalse,error
	 */
	function myAjaxVaild(option) {

		$.ajax({
			url: path + '/' + option.urlArgs,
			async: false,
			dataType: option.dataType,
			type: option.type,
			data: option.data,
			success: function(str) {

				var json = eval("(" + str + ")");

				if (json.status) {

					pswFlag.phone = false;

					setInfo('.phoneBox', false, '用户不存在,请重新填写');

				} else {

					setInfo('.phoneBox', true, '用户名输入正确');

					pswFlag.phone = true;
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

	/*进入修改密码之前的确认*/
	$('.submitBox #phoneSubmit').on('click', function(e) {

		var $phoneInput = $('#phone'),
			$phoneCode = $('#phoneCode');

		if ($phoneInput.val() === '') {

			setInfo('.phoneBox', false, "手机号不能为空");
		}

		if ($phoneCode.val() === '') {

			setInfo('.codeBox', false, "验证码不能为空");
		}

		if (pswFlag.username && pswFlag.emailCode) {

			$('.content .findBox').css('display', 'none')

			$('.content .emailCon').css('display', 'block')
		}

		if (pswFlag.username && pswFlag.code) {

			console.log('---开始修改密码')

			$('.content .findBox').css('display', 'none')

			$('.content .resetBox').css('display', 'block')
		}
	})

	/*手机号输入*/
	$('#phone').on('input', function(e) {

		$('.phoneBox .info').text('')
	})

	/*手机号或者邮箱验证，发请求*/
	$('#phone').on('blur', function(e) {

		var valueFlag = phoneReg.test($(this).val()) || emailReg.test($(this).val()),
			phoneCode = $('.codeBox .phoneCode .clearfix'),
			emailCode = $('.codeBox .emailCode .clearfix');

		if (!valueFlag) {

			setInfo('.phoneBox', false, "输入不正确，请重新输入");

		} else {

			if ($('#c2').css('display') === 'block') {

				$('#c2').css('display','none')
				$('#c1').css('display','block')
			}

			if ( phoneReg.test($(this).val()) ) {

				$.ajax({
					url: path + '/checkUserName',
					async: false,
					dataType: 'text',
					type: "post",
					data: {

						phone: $('#phone').val()
					},
					success: function(str) {

						var json = eval("(" + str + ")");
						if (json.status) {

							pswFlag.username = false;
							setInfo('.phoneBox', false, '用户不存在,请重新填写');
						} else {

							setInfo('.phoneBox', true, '用户名输入正确');
							pswFlag.username = true;
						}
					},
					error: function() {
						$.Message({
							text: '请求异常',
							type: "failure"
						})
						pswFlag.username = false;
					}
				})

			} else if (emailReg.test($(this).val())) {

				console.log('-------验证邮箱是否存在')

				if ($('#c1').css('display') === 'block') {

					$('#c1').css('display','none')
					$('#c2').css('display','block')
				}

				$.ajax({
					url: path + '/checkUserName',
					async: false,
					dataType: 'text',
					type: "post",
					data: {

						email: $('#phone').val()
					},
					success: function(str) {

						var json = eval("(" + str + ")");
						if (json.status) {

							pswFlag.username = false;
							setInfo('.phoneBox', false, '用户不存在,请重新填写');
						} else {

							setInfo('.phoneBox', true, '用户名输入正确');
							pswFlag.username = true;
						}
					},
					error: function() {
						$.Message({
							text: '请求异常',
							type: "failure"
						})

						pswFlag.username = false;
					}
				})
			}
		}

	})

	// 获取验证码
	$('.codeBox .codeBtn').on('click', function() {

		if (pswFlag.phone) {

			$.ajax({

				url: path + '/sendmes',
				dataType: 'text',
				type: "post",
				data: {

					mobile: $('#phone').val()
				},
				success: function(data) {

					var json = eval("(" + data + ")");

					if (json.status) {

						$.Message({
							text: '已经发送验证码',
							type: "success"
						})

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
	$('#phoneCode').on('input', function(e) {

		$('.codeBox .info').text('')

		var length = $(this).val().length;

		if (!isNaN($(this).val()) && length === 4 && pswFlag.phone) {

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

						setInfo('.codeBox', true, "验证码正确");
						pswFlag.code = true;
					} else {

						setInfo('.codeBox', false, "验证码错误");
						pswFlag.code = false;
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
	})

	/*第一次输入密码*/
	$('#password').on('blur', function(e) {

		var value = $('#password').val(),
			reValue = $('#repassword').val();

		if (value === '') {

			setInfo('.passwordBox', false, '密码不能为空！');

		} else {

			if (!passwordReg.test(value)) {

				setInfo('.passwordBox', false, '密码格式不正确');

			} else if (reValue !== '' && value !== reValue) {

				setInfo('.passwordBox', false, '两次密码输入不一致');

			} else {

				pswFlag.password = true
				setInfo('.passwordBox', true, '密码输入正确');

			}
		}
	})

	/*再次确认密码*/
	$('#repassword').on('blur', function(e) {

		var value = $('#password').val(),
			reValue = $('#repassword').val();

		if (reValue === '') {

			setInfo('.rePasswordBox', false, '密码不能为空！');

		} else {

			if (!passwordReg.test(reValue)) {

				setInfo('.rePasswordBox', false, '密码格式不正确');

			} else if (value !== '' && value !== reValue) {

				setInfo('.rePasswordBox', false, '两次密码输入不一致');

			} else {

				pswFlag.resetpassword = true
				setInfo('.rePasswordBox', true, '密码输入正确');
			}
		}
	})

	/*修改密码*/
	$('.submitBox #changeBtn').on('click', function(e) {

		if (pswFlag.password && pswFlag.resetpassword) {

			$.ajax({
				url: path + '/updatePass',
				dataType: 'text',
				async: false,
				type: 'post',
				data: {
					password: $('#repassword').val(),
					uuid: $('#phone').val() || pswFlag.uuid
				},
				success: function(data) {
					$.Message({
						text: '修改成功,请直接去登录',
						type: "success"
					})

					setTimeout(function() {
						location.href = casPath;
					}, 2000)
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
				text: '请检查密码是否一致',
				type: "failure"
			})
		}
	})

	/*验证码校验*/
	$('#code').on('blur',function(e) {

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

	/*发送邮件*/
	$('.submitBox #sendEmail').on('click',function(e) {

		console.log('---发送邮件')
	})

})