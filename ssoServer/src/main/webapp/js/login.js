function reloadcode(){
    var verify=document.getElementById('codeImg');
    verify.setAttribute('src',path+'/common/makeCertPic.jsp?it='+Math.random());
}

window.onload = function(){
	var certPic = document.getElementById("certPic");
	certPic.onblur = validate;
	
}
function beforeSubmit(){
	if($("#username").val().trim()==""){
		alert("用户名不能为空！");
		return false;
	}
	if($("#password").val().trim()==""){
		alert("密码不能为空！");
		return false;
	}
	SetPwdAndChk();
	if(!validate()){
		alert("验证码错误！");
		return false;
	}
	var Request = new Object();
	Request = GetRequest();
	if(!Request['service']){
		Request['service']=resPath
	}
	$.ajax({
		type:"post",
		async:false,
		url:path+'/ajaxlogin',data:{user:$("#username").val(),passwd:$("#password").val(),service:Request['service']},
		dataType:"jsonp",
		jsonp:'jsoncallback',
		success:function(a){
			if(a.result){
				location.href = Request['service']+"?ticket="+a.st;
			}else{
				alert(a.message);
			}
		}
	});
	
	return false;
}
function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function loadTest(){
	$.ajax({
		type:"post",
		async:true,
		url:path+'/ajaxlogin',data:{user:$("#username").val(),passwd:$("#password").val(),service:resPath+'/homepage'},
		dataType:"jsonp",
		jsonp:'jsoncallback',
		success:function(a){
			if(a.result){
				location.href = resPath+"/homepage?ticket="+a.st;
			}
		}
	});
}


function validate(){
	var status;
	var cert = certPic.value;
	$.ajax({
		type:"post",
		async:false,
		url:path+"/validatePic",
		data:{certCode:cert},
		dataType:"text",
		success:function(data){
			data = eval("("+data+")");
			status = data.status;
			if(data.status){
				$(".code-box span").hide();
			}else{
				$(".code-box span").show();
			}
		}
	});
	return status;
}