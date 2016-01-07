
/*
d3.xhr("http://192.168.8.122:8080/ajaxsearch")
    .header("Content-Type", "application/json")
    .post(
        JSON.stringify({pageNo: "1",industry:"轻工"}),
        function(err, data){
        	var json = eval("(" + data + ")");
            console.log("---"+json);
        }
);
*/








/*
var data = [
		{date: "12/27/2012", http_404: 2, http_200: 190, http_302: 100},
		{date: "12/28/2012", http_404: 2, http_200: 10, http_302: 100}，,
		{date: "12/29/2012", http_404: 1, http_200: 300, http_302: 200},
		{date: "12/30/2012", http_404: 2, http_200: 90, http_302: 0},
		{date: "12/31/2012", http_404: 2, http_200: 90, http_302: 0},
		{date: "01/01/2013", http_404: 2, http_200: 90, http_302: 0},
		{date: "01/02/2013", http_404: 1, http_200: 10, http_302: 1},
		{date: "01/03/2013", http_404: 2, http_200: 90, http_302: 0},
		{date: "01/04/2013", http_404: 2, http_200: 90, http_302: 0},
		{date: "01/05/2013", http_404: 2, http_200: 90, http_302: 0},
		{date: "01/06/2013", http_404: 2, http_200: 200, http_302: 1},
		{date: "01/07/2013", http_404: 1, http_200: 200, http_302: 100}
		];
        
var data = [
		{id:1,month:1,jq:200,gz:150},
		{id:1,month:2,jq:100,gz:130},
		{id:1,month:3,jq:140,gz:100},
		{id:1,month:4,jq:201,gz:159},
		{id:1,month:5,jq:202,gz:158},
		{id:1,month:6,jq:203,gz:157},
		{id:1,month:7,jq:204,gz:156},
		{id:1,month:8,jq:205,gz:155},
		{id:1,month:9,jq:206,gz:154},
		{id:1,month:10,jq:207,gz:153},
		{id:1,month:11,jq:208,gz:152},
		{id:1,month:12,jq:209,gz:151},
		{id:2,month:1,jq:300,gz:251},
		{id:2,month:2,jq:301,gz:250},
		{id:2,month:3,jq:302,gz:230},
		{id:2,month:4,jq:303,gz:282},
		{id:2,month:5,jq:380,gz:272},
		{id:2,month:6,jq:370,gz:252},
		{id:2,month:7,jq:360,gz:253},
		{id:2,month:8,jq:350,gz:254},
		{id:2,month:9,jq:340,gz:255},
		{id:2,month:10,jq:330,gz:256},
		{id:2,month:11,jq:320,gz:257},
		{id:2,month:12,jq:310,gz:258},
		{id:3,month:1,jq:130,gz:351},
		{id:3,month:2,jq:140,gz:352},
		{id:3,month:3,jq:150,gz:353},
		{id:3,month:4,jq:160,gz:354},
		{id:3,month:5,jq:170,gz:355},
		{id:3,month:6,jq:180,gz:356},
		{id:3,month:7,jq:190,gz:357},
		{id:3,month:8,jq:210,gz:58},
		{id:3,month:9,jq:250,gz:59},
		{id:3,month:10,jq:720,gz:550},
		{id:3,month:11,jq:340,gz:650},
		{id:3,month:12,jq:540,gz:250}
		];
  */
  
  var data = [
		{id:1,month:1,jq:20000,gz:150},
		{id:1,month:2,jq:100,gz:130},
		{id:1,month:3,jq:50000,gz:100},
		{id:1,month:4,jq:30345,gz:159},
		{id:1,month:5,jq:202,gz:50158},
		{id:1,month:6,jq:203,gz:23157},
		{id:1,month:7,jq:204,gz:156},
		{id:1,month:8,jq:205,gz:155},
		{id:1,month:9,jq:206,gz:154},
		{id:1,month:10,jq:207,gz:153},
		{id:1,month:11,jq:208,gz:152},
		{id:1,month:12,jq:209,gz:151},
		{id:2,month:1,jq:300,gz:251},
		{id:2,month:2,jq:301,gz:250},
		{id:2,month:3,jq:302,gz:230},
		{id:2,month:4,jq:303,gz:282},
		{id:2,month:5,jq:380,gz:272},
		{id:2,month:6,jq:370,gz:252},
		{id:2,month:7,jq:360,gz:253},
		{id:2,month:8,jq:350,gz:254},
		{id:2,month:9,jq:340,gz:255},
		{id:2,month:10,jq:330,gz:256},
		{id:2,month:11,jq:320,gz:257},
		{id:2,month:12,jq:310,gz:258},
		{id:3,month:1,jq:130,gz:351},
		{id:3,month:2,jq:140,gz:352},
		{id:3,month:3,jq:150,gz:353},
		{id:3,month:4,jq:160,gz:354},
		{id:3,month:5,jq:170,gz:355},
		{id:3,month:6,jq:180,gz:356},
		{id:3,month:7,jq:190,gz:357},
		{id:3,month:8,jq:210,gz:58},
		{id:3,month:9,jq:250,gz:59},
		{id:3,month:10,jq:720,gz:550},
		{id:3,month:11,jq:340,gz:650},
		{id:3,month:12,jq:540,gz:250}
		];
  
  var chartData=[{id:1,num:54},{id:2,num:78},{id:3,num:134}]
		
 // console.log(data[1].jq);	
		
		
		
var ndx = crossfilter(data); 
  var ndxChart=crossfilter(chartData);





var dateDim = ndx.dimension(function(d) {return d.month;});  //data 维度
var hits = dateDim.group().reduceSum(function(d) {return d.jq;}); //data 维度 求和total\

//var hits = dateDim.group().reduceSum(dc.pluck('total')); 




var hitslineChart  = dc.lineChart("#chart-line-hitsperday"); 


	hitslineChart
	.width(450).height(300).title(function(d) { return "数量为："+d.value })
	.dimension(dateDim)
	.group(hits)
	.margins({top: 40, right: 50, bottom: 30, left: 60})
	.brushOn(false)
	.x(d3.scale.linear().domain([1, 12]))
	.colors('#FE8463')
	.on("pretransition", function(chart){
			chart.selectAll('rect').each(function (d, i){
				d3.select(this).attr("rx","5").attr("ry","5");
            });
	})
	.yAxis().tickFormat(function (v) {
		
         if(v!=0){
        	 return v/10000+"万";
         }else{
        	 return v+"";
         }
         
     });
	
	hitslineChart.xAxis().tickFormat(function(v) {return v + "月";})
	
	//.x(d3.scale.ordinal().domain(["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]).rangePoints([0, 100]));
	//.xAxis().tickFormat(function(v) {return v + "月";})
 	
	/*
	data.forEach(function(d) {
	//	d.date = parseDate(d.date);
		d.total= d.http_404+d.http_200+d.http_302;
        d.Year=d.date.getFullYear();
	});
	*/

	var yearDim  = ndx.dimension(function(d) {	
			return d.id
	;});
	
	var newDimChart=ndxChart.dimension(function(d) {	
		return d.id
		;});
	var newGroupData=newDimChart.group().reduceSum(function(d) {return d.num;});
	
	
	
	var year_total = yearDim.group().reduceSum(function(d) {return d.jq+d.gz;});
	
	console.log("year_total-----"+year_total.top(1)[0].key+"-----"+year_total.top(1)[0].value);
	
	var chart1 = dc.pieChart("#chart-ring-year");
	
	 chart1
		.width(300)
		.height(180)
		.slicesCap(5)
		.innerRadius(30)
		.dimension(yearDim)
	//	.on('filtered', function(chart, filter){
	//		hitslineChart.linearColors("#000000");
	//		console.log(chart.innerRadius()+"-----"+filter);
	//	})
		.group(newGroupData)
		.ordinalColors(["#2EC7C9","#B6A2DE","#5AB1EF","#FFB980","#D87A80","8D98B3"])

		.label(function (d) {
		   var label="";
           switch(d.key)
			{
			case 1:
			  label="房地产建筑"
			  break;
			case 2:
			  label="医疗卫生"
			  break;
			case 3:
			  label="交通运输"
			  break;
			default:
			  label="未发现数据"
			}
			return label;
        })
		//.legend(dc.legend());
	
	
	var spendDim = ndx.dimension(function(d) {return d.month;}),
	spendHist    =  spendDim.group().reduceSum(function(d) {return d.gz;}); //data 维度 求和total\
	
	var spendHistChart  = dc.barChart("#chart-hist-spend");
	spendHistChart
    .width(450).height(300)
    .dimension(spendDim)
	.margins({top: 40, right: 50, bottom: 30, left: 60})
    .group(spendHist)
	.brushOn(false)
	.colors('#FE8463')
	.on("pretransition", function(chart){
			chart.selectAll('rect').each(function (d, i){
				d3.select(this).attr("rx","5").attr("ry","5");
            });
	})
    .x(d3.scale.linear().domain([1, 13]))
	.xAxis().tickFormat(function(v) {
		if(v==13){
			return "";
		}else{
			return v + "月";
		}	
	});
	
	spendHistChart.yAxis().tickFormat(function (v) {
        if(v>10000){
       	 return v/10000+"万";
        }else{
       	 return v+"";
        }
    });
	
	
	
	
	
	
	
	
	dc.renderAll()
  

