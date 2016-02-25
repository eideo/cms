'use strict';

$(function(){
	// 左边切换
	tab('.btn1','.tab1');
	tab('.btn2','.tab2');
	tab('.btn3','.tab3');

	// 右边大切换
	$('#c_btn li').click(function(){
		$('#c_btn li').removeClass('active');
		$('.part').hide();
		$(this).addClass('active');
		$('.part').eq($(this).index()).show();
	})
	//li移入背景变色
	$('.part li').mouseover(function(){
		$('.part li').css('background','#fff');
		$(this).css('background','#f6f6f6');
	})
   
})

// 左侧切换
function tab(btn,div){
	$(btn).click(function(){
		if($(div).css("display")=="block"){
			$(div).hide();
			$(this).find('i').addClass('active');
		}else{
			$(div).show();
			$(this).find('i').removeClass('active');
		}
	})
}
// 指数切换
// function tab1(btn,div){
// 	$(btn).click(function(){
// 		if($(div).css("display")=="none"){
// 			$(div).show();
// 		}else{
// 			$(div).hide();
// 		}
// 	})
// }
	