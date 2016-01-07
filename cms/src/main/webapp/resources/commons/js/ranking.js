'use strict';



 $(function(){
 	rankType();
 	more('.more');
 	bindClickOnleft();
// 	bindSortOrder();
 });

 // 排行榜分类切换
 function rankType(){
 	$('#c_btn li').click(function(){
 		$('#c_btn li').removeClass('active');
 		$('.part').hide();
 		$(this).addClass('active');
 		ajaxChangeData();
 	})
 	//li移入背景变色
 	$('.part li').mouseover(function(){
 		$('.part li').css('background','#fff');
 		$(this).css('background','#f6f6f6');
 	})
 }

 // 条件更多切换
 function more(aClass) {
	$(aClass).click(function(){
		if($(this).find('i').hasClass('active')){
			$(this).find('i').removeClass('active');
			$(this).removeClass('active');
		}else{
			$(this).find('i').addClass('active');
			$(this).addClass('active');
		}
		
		$(this).parent().find('.hidden').toggle();
	})
 }

// function bindSortOrder(){
// 	$(".index").on("click",function(){
// 		if(hot){
// 			asc = !asc;
// 		}else{
// 			hot = true;
// 			asc = true;
// 		}
// 		ajaxChangeData();
// 	});
// 	$(".lift").on("click",function(){
// 		if(hot){
// 			hot = false;
// 			asc = true;
// 		}else{
// 			asc = !asc;
// 		}
// 		ajaxChangeData();
// 	});
//	
// }

 function bindClickOnleft(){
 	$(".time").on("click","a",function(){
 		var a = $(this);
 		if(a.hasClass("active")){
 			$(this).removeClass("active");
 		}else{
 			$(".time a").removeClass("active");
 			a.addClass("active");
 		}
 		ajaxChangeData();
 	});
 	$(".trade").on("click","a",function(){
 		var a = $(this);
 		if(a.hasClass("active")){
 			$(this).removeClass("active");
 		}else{
 			$(".trade a").removeClass("active");
 			a.addClass("active");
 		}
 		ajaxChangeData();
 	});
 	$(".area").on("click","a",function(){
 		var a = $(this);
 		if(a.hasClass("active")){
 			$(this).removeClass("active");
 		}else{
 			$(".area a").removeClass("active");
 			a.addClass("active");
 		}
 		ajaxChangeData();
 	});
 }

//  指数切换
  function tab1(btn,div){
  	$(btn).click(function(){
  		if($(div).css("display")=="none"){
  			$(div).show();
  		}else{
  			$(div).hide();
  		}
  	})
  }
 var hot = true;
 var asc = true;
 function ajaxChangeData(){
 	var data = {};
 	data.type = $("#c_btn .active").attr("type");
 	if($(".areaType .active").attr("id")){
 		data.areaCode = $(".areaType .active").attr("id");
 	}
 	if($(".trade .active").attr("code")){
 		data.industry = $(".trade .active").attr("code");
 	}
 	if($(".time .active").attr("code")){
 		data.circle = $(".time .active").attr("code");
 	}
 	if(hot){
 		data.sort = 1;
 	}else{
 		data.sort = 0;
 	}
 	if(asc){
 		data.asc = 1;
 	}else{
 		data.asc = 0;
 	}
 	ajaxAsync("post",path+"/getRanking",data,"json",function(datas){
 		if(datas.status){
 			$(".part"+data.type+" .rankinglist").html("");
			
 			var datalength = datas.rankingDatas.length<20?datas.rankingDatas.length:20;
 			allRankingDatas = datas.rankingDatas;
 			for(var i=0;i<datalength;i++){
 				var indexData = datas.rankingDatas[i];
 				var html = $("#partTemp"+data.type).html();
 				while(html.indexOf("{num}")!=-1){
 					html = html.replace("{num}",i+1);
 				}
 				for(var key in indexData){
 					while(html.indexOf("{"+key+"}")!=-1){
 						html = html.replace("{"+key+"}",indexData[key]);
 					}
 				}
 				html = exeStr(html);
 				$(".part"+data.type+" .rankinglist").append(html);
 			}
 			$(".part"+data.type).show();
 			$(".tcdPageCode").createPage({
 				pageCount:datas.num,
 				current:1,
 				backFn:function(p){
 					changePage(p);
 				}
 			});
 		}
 	},function(data){
 //		alert("非常抱歉，服务器发生错误，请联系管理员解决！");
 	});
 }

 function changePage(p){
 	if(typeof allRankingDatas=="string"){
 		allRankingDatas = eval('('+allRankingDatas+')');
 	}
 	var last = allRankingDatas.length>p*20?p*20:allRankingDatas.length;
 	var type =  $("#c_btn .active").attr("type");
 	$(".part"+type+" .rankinglist").html("");
 	for(var i=(p-1)*20;i<last;i++){
 		var indexData = allRankingDatas[i];
 		var html = $("#partTemp"+type).html();
 		while(html.indexOf("{num}")!=-1){
 			html = html.replace("{num}",i+1);
 		}
 		for(var key in indexData){
 			while(html.indexOf("{"+key+"}")!=-1){
 				html = html.replace("{"+key+"}",indexData[key]);
 			}
 		}
 		html = exeStr(html);
 		$(".part"+type+" .rankinglist").append(html);
 	}
 }

 function exeStr(html){
 	while(html.indexOf("-[")!=-1){
 		var exeStr = html.substring(html.indexOf("-[")+2,html.indexOf("]-"));
 		var value = "";
 		if(exeStr.indexOf(":")==0){
 			var exe = exeStr.split(":");
 			value = eval(exe[1]);
 		}else{
 			var exeStrArr = exeStr.split(";");
 			for(var i=0;i<exeStrArr.length;i++){
 				var exe = exeStrArr[i].split(":");
 				if(eval(exe[0])){
 					value = exe[1]; 
 					break;
 				}
 			}
 		}
 		html = html.replace("-["+exeStr+"]-",value);
 	}
 	return html;
	
 }