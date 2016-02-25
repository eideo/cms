"use strict";
window.onload=function(){
	var oH3=document.getElementById('h3');
	var oStrong1=oH3.getElementsByTagName('strong')[0];
	var oStrong2=oH3.getElementsByTagName('strong')[1];
	var oEm=document.getElementsByTagName('em')[0];
	var oDiv1=document.getElementById('div1');
	var oDiv2=document.getElementById('div2');
	oStrong1.onclick=function(){
		// oEm.style.left=0;
		startMove(oEm,{left:0});
		oDiv1.style.display='block';
		oDiv2.style.display='none';
	}
	oStrong2.onclick=function(){
		// oEm.style.left=126+'px';
		startMove(oEm,{left:126});
		oDiv2.style.display='block';
		oDiv1.style.display='none';
	}

	// 个人注册表单验证
	var oUser=document.getElementById('user');
	var oMobile=document.getElementById('mobile');
	var oCode=document.getElementById('code');
	var oUerror=document.getElementById('u-error');
	var uRe=/^1[3|4|5|8][0-9]\d{4,8}$/;
	var uRe2=/[^\d].{5,19}/;
	var uRe3=/^\w{6,20}$/;
	oUser.onblur=function(){
		if(uRe.test(oUser.value)){
			oMobile.style.display="block";
			oCode.style.display='none';
		}else{
			oMobile.style.display="none";
			oCode.style.display='block';
		}
		if(!(uRe3.test(oUser.value))){
			oUerror.style.display='block';
		}
	}
	oUser.onfocus=function(){
		oUerror.style.display='none';
	}
	// 密码验证
	var oPassword=document.getElementById('password');
	var oPerror=document.getElementById('p-error');
	var oRpassword=document.getElementById('r-password');
	var oRperror=document.getElementById('rp-error');
	oPassword.onblur=function(){
		if(!(uRe2.test(oPassword.value))){
			oPerror.style.display='block';
		}
	}
	oPassword.onfocus=function(){
		oPerror.style.display='none';
	}
	oRpassword.onblur=function(){
		if((oPassword.value)!=(oRpassword.value)){
			oRperror.style.display='block';
		}
	}
	oRpassword.onfocus=function(){
			oRperror.style.display='none';
	}

	// 企业注册表单验证
	var oUser2=document.getElementById('company-name');
	var oUerror2=document.getElementById('u-error2');
	var oMobile2=document.getElementById('user-mobile');
	var oMerror=document.getElementById('mobile2');
	var oPassword2=document.getElementById('password2');
	var oPerror2=document.getElementById('p-error2');
	var oRpassword2=document.getElementById('r-password2');
	var oRperror2=document.getElementById('rp-error2');
	// 公司名称验证
	var cR=/^[\u4e00-\u9fa5]{6,20}$/;
	oUser2.onblur=function  () {
		if(!(cR.test(oUser2.value))){
			oUerror2.style.display='block';
		}
	}
	oUser2.onfocus=function  () {
			oUerror2.style.display='none';
	}
	// 联系人手机号验证
	oMobile2.onblur=function(){
		if(!(uRe.test(oMobile2.value))){
			oMerror.style.display='block';
		}
	}
	oMobile2.onfocus=function(){
		oMerror.style.display='none';
	}
	// 密码验证
	oPassword2.onblur=function(){
		if(!(uRe2.test(oPassword2.value))){
			oPerror2.style.display='block';
		}
	}
	oPassword2.onfocus=function(){
			oPerror2.style.display='none';
	}
	oRpassword2.onblur=function(){
		if((oPassword2.value)!=(oRpassword2.value)){
			oRperror2.style.display='block';
		}
	}
	oRpassword2.onfocus=function(){
			oRperror2.style.display='none';
	}
}
