'use strict';
$(function() {

	tab();
	verification('email',emailReg,'emailBox');
	verification('phone',phoneReg,'phoneBox');
})

function tab() {

	$('.sign span').click(function() {

		$('.box').hide();
		$('.box').eq($(this).index()).show();
		$('.error').text('');
	})

	$('.emailBtn').click(function() {

		$('.sign i').animate({"left":"0"});
	})
	$('.phoneBtn').click(function() {

		$('.sign i').animate({"left":"110"});
	})
}

var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
var phoneReg = /^1[3|4|5|8][0-9]\d{8}$/;
function verification(inputId,reg,box) {

	$('#'+inputId).blur(function () {

			var result =true;
			console.log($('#'+inputId).val())
			if(reg.test($('#'+inputId).val())){
				
				$.ajax({
					url:path+'/checkUserName',
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
						return result;
					},
					error: function() {

						$.Message({
							text:'请求异常',
							type:"failure"
						})
						result =false;
						return result;
					}
				})
			}else {

				$('.'+box+' .error').text('格式不正确');
				result =false;
			}
			return result;

	})
}






