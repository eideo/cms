"use strict";
//列表
function list(){
	var aRpage=$('.rpage');
	var aH=$('.h');
	for (var i = 0; i < aH.length; i++){
		aH[i].index=i;
		aH[i].onmouseover=function(){
			for (var i = 0; i < aH.length; i++){
				aRpage[i].style.display='none';
			}
			aRpage[this.index].style.display='block';
		}
//		aH[i].onmouseout=function(){
//			aRpage[this.index].style.display='none';
//		}
	}
}
window.onload=function(){
	getplace();
	list();
	rchart();
//	var a=$('.term1 p').text();
//	var b=$('.term2 p').text();
//	var c=$('.term3 p').text();
//	if(a==''&b==''&c==''){
//		$('#term').hide();
//		$('#de').hide();
//	}
}

//获取地区目录
function getplace(){
	ajax({
		url:path+'/resources/json/city.json',
		data:{
			type:'post'
		},
		success:function(str){
			var data = eval('('+str+')');
			for (var i = 0; i <data.length; i++){
				var oDcity=document.getElementById('dcity');
				var oLi=document.createElement('li');
				var oBox=document.createElement('div');
				var oI=document.createElement('i');
				oLi.innerHTML="<span>"+data[i].name+"</span>";
				oLi.id=data[i].code;
				var arr=data[i].children;
				for (var j = 0; j < arr.length; j++) {
					var oA=document.createElement('a');
				    oA.innerHTML=arr[j].name;
				    oA.id=arr[j].code;
				    oBox.appendChild(oA);
				};

				oBox.className='hidden';
				if(oBox.innerHTML!=''){
				    oLi.appendChild(oBox);
				    oLi.appendChild(oI);
				}
				oDcity.appendChild(oLi);
			}
			var oUl=document.getElementById('dcity');
			var aLi=oUl.getElementsByTagName('li');
			var aDiv=oUl.getElementsByTagName('div');
			var more1=$('#more1');
			for (var i = 0; i < aDiv.length; i++){
				aDiv[i].onmouseout=function(){
					this.style.display='none';
				}
			}
			$('#dcity li').each(function(i){
				if(i>13&&i<17){
					$(this).addClass('rightli');
				}
			})
			$('#dcity li').each(function(i){
				if(i>16){
					$(this).addClass('liHidden2');
				}
			})
			$('#more1').click(function(){
		        if($(".liHidden2").css("display")=="none"){
			        $(".liHidden2").show();
			        $(this).addClass('active');
		        }else{
			        $(".liHidden2").hide();
		        	$(this).removeClass('active');
		     }
	})
		},
		error:function(e){
			alert('错误:'+e);
		}
	});
	
	//二级目录点击box消失
	var oUl=document.getElementById('dcity');
	var aLi=oUl.getElementsByTagName('a');
	for (var i = 0; i < aLi.length; i++) {
		aLi[i].onclick=function(){
			this.parenntNode.style.display='none';
		}
	};
	

}



$(function(){
	//点击二级城市，添加搜索条件
	$('#dcity').on("click","a",function(){
		$(this).parent().hide();
		var province='';
		var p=$(this).parent().parent().find("span").text()
		if($("#term2 span:contains('"+p+"')").length==0){
			province=p+'-'+$(this).text();
		}else{
			province=$(this).text()
		}
		
		var city=$(this).text();
		if($('#term2 span[rid="'+$(this).attr('id')+'"]').length==0){
			$('<span><span>').text(province).appendTo('#term2').attr('rid',$(this).attr('id'));
		}
	})
	$('#term2').on("click","span",function(){
		$(this).remove();
		ajaxSearch();
	})
	//点击省份
	$('#areaBox').on("click","li span",function(){
		if($('#term2 span[rid="'+$(this).parent().attr('id')+'"]').length==0){
		    $('<span><span>').text($(this).text()).appendTo('#term2').attr('rid',$(this).parent().attr('id'));	
		}
	})
	
	//点击二级行业，添加搜索条件
	$('#dtrade').on("click","a",function(){
		$(this).parent().hide();
		var province='';
		var p=$(this).parent().parent().find("span").text()
		if($("#term3 span:contains('"+p+"')").length==0){
			province=p+'-'+$(this).text();
		}else{
			province=$(this).text()
		}
		var city=$(this).text();
		if($("#term3 span:contains('"+$(this).text()+"')").length==0){
			$('<span><span>').text(province).appendTo('#term3');
		}
	})
	$('#term3').on("click","span",function(){
		$(this).remove();
		ajaxSearch();
	})
	//点击一级行业
	$('#tradeBox').on("click","li span",function(){
		if($("#term3 span:contains('"+$(this).text()+"')").length==0){
		    $('<span><span>').text($(this).text()).appendTo('#term3');	
		}
	})

//	添加内容搜索条件
	$('#dtype li').click(function(){
		//当条件没有选的时候默认是不限
		$('#un1').removeClass('active');
		$('#dtype li').removeClass('active');
		$(this).addClass('active');
		var compare=$(this).text();
		if($("#term1 span:contains('"+compare+"')").length==0){
			$('<span></span>').text(compare).appendTo('#term1');
		}
	})
	
//	$('#dtrade li').click(function(){
//		//当条件没有选的时候默认是不限
//		$('#un1').removeClass('active');
//		$('#dtrade li').removeClass('active');
//		$(this).addClass('active');
//		var compare=$(this).text();
//		if($("#term3 span:contains('"+compare+"')").length==0){
//			$('<span></span>').text(compare).appendTo('#term3');
//		}
//	})
//	
	$('#term').on("click","span",function(){
			$(this).remove();
			ajaxSearch();
		})
	
//	发送搜索条件
	$('.searchTerms').on("click","li",function(){
		ajaxSearch();
	});
	
	
//结果列表
$('#list li').mouseover(function(){
	$('#list li').css('background','#fff');
	$(this).css('background','#f6f6f6');
})
$('#list li').mouseout(function(){
	$(this).css('background','#fff');
})

$('.rpage').mouseout(function(){
	$(this).hide();
})
	
//	点击搜索按钮发送AJAX
	$('.searchbtn').click(function(){
		ajaxSearch();
	})
	unlimit();
})

function ajaxSearch(p){
	//获取搜索条件、
	var type="";
	$("#term1 span").each(function(){
		type+=this.innerText+",";
	});
	var area=""
	$("#term2 span").each(function(){
		area+=$(this).attr('rid')+",";
	});
	var trade=""
	$("#term3 span").each(function(){
		trade+=this.innerText+",";
	});
	var data={};
	if(p){
		data.pageNo = p;
	}else{
		data.pageNo = 1;
	}
	data.keyword=$('.searchBox').val();
	data.area=area;
	data.industry=trade;
	data.type=type;
	if(data.keyword==''&&data.area==''&&data.industry==''&&data.type==''){
		return;
	}
	ajaxAsync("post",path+"/ajaxsearch",data,"json",function(datas){
		if(datas.status){
			//搜素用时以及结果条数
			$("#s_time").text(datas.time);
			$("#s_number").text(datas.count);
			$(".resultList").html("");
			for(var i=0;i<datas.listIndex.length;i++){
				var indexData = datas.listIndex[i];
				var html = $("#listTemp").html();
				for(var key in indexData){
					while(html.indexOf("{indexInfo."+key+"}")!=-1){
						html = html.replace("{indexInfo."+key+"}",indexData[key]);
					}
				}
				$(".resultList").append(html);
				
			}
			list();
			if(!p){
				$(".tcdPageCode").createPage({
					pageCount:datas.num,
					current:1,
					backFn:function(p){
						ajaxSearch(p);
					}
				});
			}
		}
	},function(data){
		alert("非常抱歉，服务器发生错误，请联系管理员解决！");
	});
}

function unlimit(){
	$('#un1').on("click",function(){
		$('#term1 span').remove();
		$('.term1').hide();
		ajaxSearch();
	})
	$('#un2').on("click",function(){
		$('#term2 span').remove();
		$('.term2').hide();
		ajaxSearch();
	})
	$('#un3').on("click",function(){
		$('#term3 span').remove();
		$('.term3').hide();
		ajaxSearch();
	})
}

//二级目录JS
$(function(){
	$('#tradeBox .more').click(function(){
		if($(".liHidden").css("display")=="none"){
			$(".liHidden").show();
			$(this).addClass('active');
		}else{
			$(".liHidden").hide();
			$(this).removeClass('active');
		}
	})
	// 行业二级菜单
	$('#dtrade li').mouseover(function(){
		$(this).find('span').addClass('active');
		$(this).find('p').show();
		$(this).find('i').show();
	}).mouseout(function(){
		$(this).find('span').removeClass('active');
		$(this).find('p').hide();
		$(this).find('i').hide();
	})
	
//	地区二级目录
	$('#dcity').on("mouseover","li",function(){
		$(this).find('span').addClass('active');
		$(this).find('div').show();
		$(this).find('i').show();
	}).on("mouseout","li",function(){
		$(this).find('span').removeClass('active');
		$(this).find('div').hide();
		$(this).find('i').hide();
	})
})