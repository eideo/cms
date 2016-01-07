
function filterRepeatStr(str){
	var ar2 = str.split(",");
	var array = new Array();
	var j=0
	for(var i=0;i<ar2.length;i++){
	if((array == "" || array.toString().match(new RegExp(ar2[i],"g")) == null)&&ar2[i]!=""){
	array[j] =ar2[i];
	array.sort();
	j++;
	}
	}
	return array.toString();
}

var dataTimeoStr="";
var dataAreaStr="";
var dataIndustryStr="";

console.log(dataAreaStr);

/*测试
 * 
 * 
var buffer = new StringBuffer();
buffer.append("Hello,").append("javascript,");

var test="sad,sdfsdf,qq,vbv,qqs,";
test=test.replace('qq','');
console.log(test);

var result = buffer.toString();
console.log(result);
buffer.dede("javascript,");
var ss=buffer.toString();
console.log("aaaaaaaaaaaaaaaaa"+ss);
*/


(function($){
    $.fn.capacityFixed = function(options) {
        var opts = $.extend({},$.fn.capacityFixed.deflunt,options);
        var FixedFun = function(element) {
            var top = opts.top;
            element.css({
                "top":top
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top: 0							
                        });
                    } else {
                        element.css({
                            top: scrolls
                        });
                    }
                }else {
                    element.css({
                        position: "inherit",
                        top: top
                    });
                }
            });
         
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed.deflunt={
		right : 0,//相对于页面宽度的右边定位
        top:0
	};
})(jQuery);

$(function(){
	
	$(".selectCenter ul li a").click( function(){
		var parent = $(this).closest("div");
		if ($(this).hasClass("icon-ok1")) {
			$(this).removeClass("icon-ok1");
			if(parent.hasClass("selectCont")){
				removeType($(this).text());
				if(parent.find(".icon-ok1").length==0){
					parent.find(".box").addClass("boxAll");
					$(".pitchOn.type").remove();
				}
				dataTimeoStr=dataTimeoStr.replace(new RegExp(($(this).text()+","),'gm'),'');
				
			}else if(parent.hasClass("regionBox")||parent.hasClass("foreign")){
				removeArea($(this).text());
				if(parent.find(".icon-ok1").length==0){
					parent.find(".box").addClass("boxAll");
					$(".pitchOn.area").remove();
				}
				
				dataAreaStr=dataAreaStr.replace(new RegExp(($(this).text()+","),'gm'),'');
				
			}else if(parent.hasClass("industryBox")){
				removeIndustry($(this).text());
				if(parent.find(".icon-ok1").length==0){
					parent.find(".box").addClass("boxAll");
					$(".pitchOn.industry").remove();
				}
				
				dataIndustryStr=dataIndustryStr.replace(new RegExp(($(this).text()+","),'gm'),'');
				
			}
		}else{
			$(this).addClass("icon-ok1");
			if(parent.hasClass("selectCont")){
				addType($(this).text());
				
				dataTimeoStr+=$(this).text()+",";
				
			}else if(parent.hasClass("regionBox")||parent.hasClass("foreign")){
				addArea($(this).text());
				
				dataAreaStr+=$(this).text()+",";
				
			}else if(parent.hasClass("industryBox")){
				addIndustry($(this).text());
				
				dataIndustryStr+=$(this).text()+",";
				
			}
			if(parent.find(".box").hasClass("boxAll")){
				parent.find(".box").removeClass("boxAll");
			}			
			
		}
		
		
		$(".regionWrap").hide();
		
		
		c3ajaxLoad("","",dataAreaStr,dataIndustryStr,"","");//关键字，内容，地区，行业，开始时间，结束时间
		ajaxSearch();
		
		
		
		
		
		
		
		
		
		
		
		
	});
	
	$(".box").on("click",function(){
		if(!$(this).hasClass("boxAll")){
			var parent = $(this).parent();
			parent.find(".icon-ok1").each(function(){
				$(this).click();
			});
			$(this).addClass("boxAll");
			ajaxSearch();
		}
	});
	
	$(".selectBox.condition").on("click","li span",function(){
		var str = $(this).parent().text();
		$(".selectCenter ul li a:contains('"+str+"')").click();
	});

	$(".regionBox p").click( function(){
		$(".region").toggleClass("regions")
	})

	$(".industryBox p").click( function(){
		$(".industry").toggleClass("industrys")
	})

	
	/*
	$(".selectCenter ul li a").on("mouseover",function(){
		$(".regionWrap").hide();
		var name = $(this).text();
		$(".regionWrap[name='"+name+"']").show();
	});

	$(".selectCenter ul li a").on("mouseout",function(){
		var name = $(this).text();
		//$(".regionWrap[name='"+name+"']").hide();
		
		$(".regionWrap").on("mouseover",function(){		
			$(this).show();
		});
		$(".regionWrap").on("mouseout",function(){
			$(this).hide();
		})	
	});
	
	*/


	
	
})

$(function(){
	$(".regionWrap ol li a").click( function(){
		var div = $(".regionBox");
		if ($(this).hasClass("icon-ok1")) {
			$(this).removeClass("icon-ok1");
			removeArea($(this).text());
			if(div.find(".icon-ok1").length==0){
				div.find(".box").addClass("boxAll");
			}
		}else{
			$(this).addClass("icon-ok1");
			addArea($(this).text());
			if(div.find(".box").hasClass("boxAll")){
				div.find(".box").removeClass("boxAll");
			}
		}
		ajaxSearch();
	})
})


/*导航*/
$(function(){
    $(".navCenter li a").click( function(){
        $(".navCenter li a").removeClass("cur");
        $(this).addClass("cur");
    })

    $("#01").click( function(){
        $(this).addClass("cur");
        $("#02,#03,#04,#05,#06").removeClass("cur");
    })

     $("#02").click( function(){
        $(this).addClass("cur");
        $("#01,#03,#04,#05,#06").removeClass("cur");
    })
     $("#03").click( function(){
        $(this).addClass("cur");
        $("#01,#02,#04,#05,#06").removeClass("cur");
    })
     $("#04").click( function(){
        $(this).addClass("cur");
        $("#01,#02,#03,#05,#06").removeClass("cur");
    })
     $("#05").click( function(){
        $(this).addClass("cur");
        $("#01,#02,#03,#04,#06").removeClass("cur");
    })
     $("#06").click( function(){
        $(this).addClass("cur");
        $("#01,#02,#03,#04,#05").removeClass("cur");
    })

})


/*关系网小图标*/
$( function(){
	
	$(".contCenter").on("mouseover",".contLeft",function(){
		$(this).find(".contLeftBox").show();
		$(this).find(".contLeftPic2").show();
	});
	$(".contCenter").on("mouseout",".contLeft",function(){
		$(this).find(".contLeftBox").hide();
		$(this).find(".contLeftPic2").hide();
	})

})

/*分享关闭*/
$(function(){
    $(".close").click( function(){
        $(".fullbg").hide();
        $(".dialog").hide();
    })
})
$(function(){
	$("#searchForm").submit(function(){
		var keyword = $("#searchForm").find("input[name='keyword']").val();
		console.log("keyword-----"+keyword);
		if(keyword.trim()!=""){
			ajaxSearch();
			ajaxAsync("post",path+"/gethotkeywords",{keyword:keyword},"json",function(datas){
				if(datas.status){
					$(".correlation ul").html("");
					for(var i=0;i<datas.hotKeywords.length;i++){
						var hotKeywords = datas.hotKeywords[i];
						var li = "<li><a href=\"${resPath}/search?keyword="+hotKeywords.keywords+"\">"+hotKeywords.keywords+"</a></li>";
						$(".correlation ul").append(li);
					}
				}
			},function(data){
				alert("非常抱歉，服务器发生错误，请联系管理员解决！");
			});
		}
		return false;
	});
	
	
	$(".pitchOn").on("click","i,span",function(){
		var li = $(this).parent();
		$(".icon-ok1:contains('"+li.text()+"')").removeClass("icon-ok1");
		li.remove();
	});
	
	
	initParam();
		
});


function initParam(){
	$("#searchForm input[type='hidden']").each(function(){
		var name= this.name;
		var value = this.value;
		var values = value.split(",");
		for(var i=0;i<values.length;i++){
			if(name=="area"){
				if(values[i]!=""){
					$(".regionBox a:contains('"+values[i]+"')").addClass("icon-ok1");
					$(".foreign a:contains('"+values[i]+"')").addClass("icon-ok1");
					addArea(values[i]);
				}
			}
			if(name=="type"){
				if(values[i]!=""){
					$(".selectCont a:contains('"+values[i]+"')").addClass("icon-ok1");
					addType(values[i]);
				}
			}
			if(name=="industry"){
				if(values[i]!=""){
					$(".industryBox a:contains('"+values[i]+"')").addClass("icon-ok1");
					addIndustry(values[i]);
				}
			}
		}
	});
}

function addArea(text){
	var li = $("<li><i>"+text+"</i><span></span></li>");
	if($(".pitchOn.area").length==0){
		$(".selectBox.condition").append($("#pitchArea").html());
	}
	$(".pitchOn.area ul").append(li);
	// 用户行为点击搜索条件
	topClick(7, 2, text);
}
function removeArea(text){
	$(".pitchOn.area li:contains('"+text+"')").remove();
}
function addType(text){
	if($(".pitchOn.type").length==0){
		$(".selectBox.condition").append($("#pitchType").html());
	}
	var li = $("<li><i>"+text+"</i><span></span></li>");
	$(".pitchOn.type ul").append(li);
	// 用户行为点击搜索条件
	topClick(7, 1, text);
}
function removeType(text){
	$(".pitchOn.type li:contains('"+text+"')").remove();
}
function addIndustry(text){
	if($(".pitchOn.industry").length==0){
		$(".selectBox.condition").append($("#pitchIndustry").html());
	}
	var li = $("<li><i>"+text+"</i><span></span></li>");
	$(".pitchOn.industry ul").append(li);
	// 用户行为点击搜索条件
	topClick(7, 3, text);
}
function removeIndustry(text){
	$(".pitchOn.industry li:contains('"+text+"')").remove();
}

function ajaxSearch(isPage){
	var keyWord = $("#keyWord").val();
	var area = "";
	$(".regionBox").find(".icon-ok1").each(function(){
		area+=$(this).text()+",";
	});
	$(".foreign").find(".icon-ok1").each(function(){
		area +=$(this).text()+",";
	});
	var industry="";
	$(".industryBox .icon-ok1").each(function(){
		industry += $(this).text()+",";
	});
	var type ="";
	$(".selectCont .icon-ok1").each(function(){
		type +=$(this).text()+",";
	});
	$("#searchForm").find("input[name='area']").val(area);
	$("#searchForm").find("input[name='industry']").val(industry);
	$("#searchForm").find("input[name='type']").val(type);
	
	ajaxAsync("post",path+"/ajaxsearch",$("#searchForm").serialize(),"json",function(datas){
		if(datas.status){
			$(".contCenter").html("");
			for(var i=0;i<datas.listIndex.length;i++){
				var indexData = datas.listIndex[i];
				var html = $("#listTemp").html();
				for(var key in indexData){
					while(html.indexOf("{indexInfo."+key+"}")!=-1){
						html = html.replace("{indexInfo."+key+"}",indexData[key]);
					}
				}
				$(".contCenter").append(html);
			}
			if(!isPage){
				$(".tcdPageCode").createPage({
			        pageCount:datas.num,
			        current:1,
			        backFn:function(p){
			        	$("#searchForm").find("input[name='pageNo']").val(p);
			        	ajaxSearch(true);
			        }
			    });
				$("#allCount").remove();
				//$(".selectBox.condition").append($("#allCountTemp").html().replace("{count}",datas.count));
			}
		}
	},function(data){
		alert("非常抱歉，服务器发生错误，请联系管理员解决！");
	});


}

$(function (){
	
	/*
	var datas=[ 
	           	['x', '2013-01-01', '2013-01-02', '2013-01-03', '2013-01-04', '2013-01-05', '2013-01-06'],
				['data1', 30, 20, 50, 40, 60, 50],
				['data2', 200, 130, 90, 240, 130, 220],
				['data3', 300, 200, 160, 400, 250, 250]
			]
	*/

	
	//c3ajax(keyword,type,area,industry,startDate,endDate)
	

	
	

	/*
	$("body").on("mouseover mouseout",".contrightBox",function(event){
		 if(event.type == "mouseover"){
			 	$(this).css({"border":"2px solid #47aaff"});
			 	$(this).parent().prev().addClass("flipInX animated");
			 	$(this).children().find("a").css("color","#47aaff");
		 }else if(event.type == "mouseout"){
			 console.log("123123");
			 $(this).children().find("a").css("color","#333");
			 $(this).parent().prev().removeClass("flipInX animated");
			 $(this).css({"border-left":"2px solid #fff","border-right":"2px solid #fff","border-top":"2px solid #fff","border-bottom":"2px solid #f7f7f7"});
		 }
	})
	*/
	
	$("body").on("mouseenter",".contrightBox",function(){
		$(this).css({"border":"2px solid #47aaff"});
	 	$(this).parent().prev().addClass("flipInX animated");
	 	$(this).children().find("a").css("color","#47aaff");
	})
	
	$("body").on("mouseleave",".contrightBox",function(){
		 $(this).children().find("a").css("color","#333");
		 $(this).css({"border-left":"2px solid #fff","border-right":"2px solid #fff","border-top":"2px solid #fff","border-bottom":"2px solid #f7f7f7"});
	})
	
	$("body").on("mouseleave",".contBox",function(){
		$(this).children().eq(0).removeClass("flipInX animated");
	})
	
	
	
	
	
//	c3ajax("","","","","","");
	
	

	
	
	
	
	
	
	
	
	
	
	
	
});






	var dataTimeo=new Array();
	var dataArea=new Array();
	var dataIndustry=new Array();
	var xline=new Array();
	xline.push("x");
	var data1=new Array();
	data1.push("项目");
	var data2=new Array();
	data2.push("招标");
	var data3=new Array();
	data3.push("中标");
	
	/*新添加*/
	$.ajax({
//		url: path+"/resources/commons/json/testCon1.json",
		url:path+"/getsearchstatistics",
		type: "post",
		cache:false,
	   	async:false,
		dataType:'json',
		success:function(json){
			if(json!=null){
				
				/*--*/
				var lendataTimeo=json[0].dataTimeo;
				var dataTimeo=lendataTimeo.length;
				for(var i=0;i<dataTimeo;i++) 
				   { 
						xline.push(new Date(lendataTimeo[i].time));
						if(lendataTimeo[i].project!=null){
							data1.push(Number(lendataTimeo[i].project));
						}
						if(lendataTimeo[i].tender!=null){
							data2.push(Number(lendataTimeo[i].tender));
						}
						if(lendataTimeo[i].bid!=null){
							data3.push(Number(lendataTimeo[i].bid));
						}	
				   }
				
				/*area*/
				var lendataArea=json[0].dataArea;
				var dataAreas=lendataArea.length;
				for(var i=0;i<dataAreas;i++) 
			   { 
					var lin=new Array();
					lin.push(lendataArea[i].area,Number(lendataArea[i].nums));
					dataArea.push(lin);
			   }
				
				
				
				
				/*Industry*/
				
				var lendataIndustry=json[0].dataIndustry;
				var dataIndustrys=lendataIndustry.length;
				for(var i=0;i<dataIndustrys;i++) 
			   { 
					var lin=new Array();
					lin.push(lendataIndustry[i].industry,Number(lendataIndustry[i].nums));
					dataIndustry.push(lin);
			   }
				
			}	
		}	
	});
	
	dataTimeo.push(xline,data1,data2,data3);
	

/*新添加*/
var chart1 = c3.generate({
	bindto: '#chart1',
	size: {
	  width: 600
	},
    data: {
        x: 'x',
        columns: dataTimeo
    },
    axis: {
        x: {
            type: 'timeseries',
            tick: {
              //  format: '%Y-%m-%d'
			   format: function (x) { return x.getFullYear()+"年"+(x.getMonth()+1)+"月"; },
			   count: 6,
			   fit: true
    		  // values: [new Date('2012-08'), new Date('2014-03')]
            },
            
        },
		 y: {
		tick: {
		  format: function (d) { 
		  	return d/10000+"万"; 
		  }
		}
	  }
    }
	
});




var chart2 = c3.generate({
	bindto: '#chart2',
    data: {
        // iris data from R
        columns:dataArea,
        type : 'pie'
    },
    pie: {
    	label: {
	        format: function (v, id, i, j) {
	          return i+(Math.round(Number(id) * 10000)/100).toFixed(2) + '%';
	        }
	      }
    }
    
});


var chart3 = c3.generate({
	bindto: '#chart3',
    data: {
        columns:dataIndustry,
        type : 'donut'
    },
    donut: {
        title: "行业比例图"
    }
});





function c3ajaxLoad(keyword,type,area,industry,startDate,endDate){
	
	
	
	var dataTimeo=new Array();
	var dataArea=new Array();
	var dataIndustry=new Array();
	var xline=new Array();
	xline.push("x");
	var data1=new Array();
	data1.push("项目");
	var data2=new Array();
	data2.push("招标");
	var data3=new Array();
	data3.push("中标");
	
	
	console.log("dataArea"+dataArea);
	
	/*新添加*/
	$.ajax({
//		url: path+"/resources/commons/json/testCon1.json",
		url:path+"/getsearchstatistics",
		type: "post",
		cache:false,
	   	async:false,
		data: {
			keyword:keyword,
			type:type,
			area:area,
			industry:industry,
			startDate:startDate,
			endDate:endDate
	   	},
		dataType:'json',
		success:function(json){
			if(json!=null){
				
				/*--*/
				var lendataTimeo=json[0].dataTimeo;
				var dataTimeo=lendataTimeo.length;
				for(var i=0;i<dataTimeo;i++) 
				   { 
						xline.push(new Date(lendataTimeo[i].time));
						if(lendataTimeo[i].project!=null){
							data1.push(Number(lendataTimeo[i].project));
						}
						if(lendataTimeo[i].tender!=null){
							data2.push(Number(lendataTimeo[i].tender));
						}
						if(lendataTimeo[i].bid!=null){
							data3.push(Number(lendataTimeo[i].bid));
						}	
				   }
				
				/*area*/
				var lendataArea=json[0].dataArea;
				var dataAreas=lendataArea.length;
				for(var i=0;i<dataAreas;i++) 
			   { 
					var lin=new Array();
					lin.push(lendataArea[i].area,Number(lendataArea[i].nums));
					dataArea.push(lin);
			   }
				
				/*Industry*/
				
				var lendataIndustry=json[0].dataIndustry;
				var dataIndustrys=lendataIndustry.length;
				for(var i=0;i<dataIndustrys;i++) 
			   { 
					var lin=new Array();
					lin.push(lendataIndustry[i].industry,Number(lendataIndustry[i].nums));
					dataIndustry.push(lin);
			   }
				
			}	
		}	
	});
	
	dataTimeo.push(xline,data1,data2,data3);
	
	/*新添加*/
	
	chart1.unload();
	chart1.load({
		columns:dataTimeo
	});
	
	chart2.unload();
	chart2.load({
	  columns:dataArea
	});
	
	chart3.unload();
	chart3.load({
	  columns: dataIndustry
	});
	
}














