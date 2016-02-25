'use strict';

$(function(){
	// 行业分类
	$('.term li').click(function(){
		$('.term li').removeClass('active');
		$('.h2').removeClass('active');
		$(this).addClass('active');
	})
	$('.h2').click(function(){
		$('.term li').removeClass('active');
		$(this).addClass('active');
	})
	// 行业报告列表
	$('.reportList li').mouseover(function(){
		$('.reportList li').css('background','#fff');
		$(this).css('background','#f6f6f6');
	})
	$('.reportList li').mouseout(function(){
		$(this).css('background','#fff');
	})
	// 推荐
	$('.img').mouseover(function(){
		$('.img').removeClass('on');
		$(this).addClass('on');
	})
	$('.img').mouseout(function(){
		$(this).removeClass('on');
	})

	// 推荐分享关注收藏
	var flag=true;
	$('.recommend .attention').click(function(){
		if(flag){
			$(this).addClass('active1');
		}else{
			$(this).removeClass('active1');
		}
		flag=!flag;
	})
	$('.recommend .collection').click(function(){
			$(this).addClass('active2');
	})
	// $('.recommend .share').click(function(){
	// 	if(flag){
	// 		$(this).addClass('active3');
	// 	}else{
	// 		$(this).removeClass('active3');
	// 	}
	// 	flag=!flag;
	// })

	// 报告列表关注收藏
	$('.ap').click(function(){
		if($(this).find('.re').css('display')=='none'){
			$(this).find('i').addClass('active1');
			$(this).find('span').hide();
			$(this).find('.re').show();
		}else{
			$(this).find('i').removeClass('active1');
			$(this).find('span').show();
			$(this).find('.re').hide();
		}
	})
		$('.cp').click(function(){
		if($(this).find('.re').css('display')=='none'){
			$(this).find('i').addClass('active2');
			$(this).find('span').hide();
			$(this).find('.re').show();
		}else{
			$(this).find('i').removeClass('active2');
			$(this).find('span').show();
			$(this).find('.re').hide();
		}
	})
	// 分享按钮
	$('.sp').mouseover(function(){
		$(this).find('em').show();
		$(this).find('div').show();
		$(this).find('.share').addClass('reShare')
	}).mouseout(function(){
		$(this).find('em').hide();
		$(this).find('div').hide();
		$(this).find('.share').removeClass('reShare')
	})

})

// // 轮播图
window.onload=function(){
	var oBox = document.getElementById('box');
	var oUl = oBox.getElementsByTagName('ul')[0];
	var aLi = oUl.children;
	var oOl = oBox.getElementsByTagName('ol')[0];
	var aBtn=  oOl.children;
	var oPrev = document.getElementById('prev');
	var oNext = document.getElementById('next');
	oUl.innerHTML+=oUl.innerHTML;
	oUl.style.width=aLi.length*aLi[0].offsetWidth+'px';
	var W = oUl.offsetWidth/2;
	var iNow=0;
	var timer =null;
	oBox.onmouseover=function(){
		clearInterval(timer);
		oPrev.style.display='block';
		oNext.style.display='block';
	};
	oBox.onmouseout=function(){
		timer = setInterval(function(){
			fnNext();
		},2000);
		oPrev.style.display='none';
		oNext.style.display='none';
	};
	for(var i=0;i<aBtn.length;i++){
		(function(index){
			aBtn[i].onclick=function(){
				if(iNow%aBtn.length==0&&index==4){
					iNow--;
				}
				if((iNow%aBtn.length==4||iNow==-1)&&index==0){
					iNow++;
				}
				iNow=Math.floor(iNow/aBtn.length)*aBtn.length+index;
				tab();
			};
		})(i);
	}
	function tab(){
		for(var i=0;i<aBtn.length;i++){
			aBtn[i].className='';
		}
		if(iNow>0){
			aBtn[iNow%aBtn.length].className='on';
		}else{
			aBtn[(iNow%aBtn.length+aBtn.length)%aBtn.length].className='on';
		}
		startMove(oUl,-iNow*aLi[0].offsetWidth);
		//oUl.style.left=-iNow*aLi[0].offsetWidth+'px';
	}
	oPrev.onclick=function(){
		iNow--;
		tab();
	};
	oNext.onclick=fnNext;
	function fnNext(){
		iNow++;
		tab();
	}
	
	timer = setInterval(function(){
		fnNext();
	},2000);
	
	
	var left = 0;
	function startMove(obj,iTarget){
		var start = left;
		var dis = iTarget-start;
		var count = Math.floor(700/30);
		var n = 0;
		clearInterval(obj.timer);
		obj.timer = setInterval(function(){
			n++;
			var a = 1-n/count;
			left = start+dis*(1-Math.pow(a,3));
			if(left<0){
				obj.style.left=left%W+'px';
			}else{
				obj.style.left=(left%W-W)%W+'px';
			}
			if(n==count){
				clearInterval(obj.timer);
			}
		},30);
	}
	
};