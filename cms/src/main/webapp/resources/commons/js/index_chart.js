  $(function(){
      var data = [
                  {name : '交通',value : 17.04,color:'#ff5256'},
                  {name : '机电',value : 20,color:'#25cbc1'},
                  {name : '建筑',value : 10,color:'#38e5ff'},
                  {name : '化工',value : 20,color:'#ffa938'},
                  {name : '能源',value : 25,color:'#fce22a'},
                  {name : '医疗',value : 10,color:'#4ad486'}
            ];

      var chart = new iChart.Donut2D({
            render : 'chart1',
            data: data,
            shadow_offsetx:0,
            shadow_offsety:2,
            shadow_blur:10,
            shadow_color:'#676767',
            gradient:false,//开启渐变背景
            color_factor:0.25,//渐变因子
            gradient_mode:'LinearGradientDownUp',//渐变模式
            background_color:'#fff',
            separate_angle:4,//分离角度
            increment:10,//弹出距离
            border:{
                  width:0//整个画布的边框样式
            },
            sub_option:{
                  label:false,
                  gradient:true,
                  color_factor:0.08,
                  gradient_mode:'RadialGradientInOut',
            },
            tip:{
                  enable:true,//鼠标移入是否提示数据
                  showType:'fixed'//提示是否在固定的位置
            },
            showpercent:true,//显示%
            decimalsnum:2,//提示保留小数点后2位数
            width : 530,
            height : 530,
            radius:140//控制圆环的半径
      });
                  
      chart.bound(0);//突出第几个图
});

// 面积图
$(function(){
      var data = [
                  {
                        name : '交通',
                        value:[2,6,10,14,18,14,10,6,2,6,8,10,6],
                        color:'#ff5256',
                        line_width:2
                  },
                  {
                        name : '机电',
                        value:[10,14,18,20,26,24,20,16,12,8,4,4,0],
                        color:'#25cbc1',
                        line_width:2
                  }
              ];
    
      var labels = ["9","10","11","12","1","2","3","4","5","6","7","8"];
      
      var chart = new iChart.Area2D({
            render : 'chart2',
            data: data,
            width : 600,
            height : 300,
            border:{
                  width:0
            },
            tip:{
                  enable : true,
                  listeners:{
                         //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                        parseText:function(tip,name,value,text,i){
                              return name+"行业<br/>:"+labels[i]+"景气指数:"+value;
                        }
                  }
            },
            crosshair:{
                  enable:true,
                  line_color:'#62bce9',
                  line_width:2
            },
            sub_option:{
                  label:false,
                  point_size:10 
            },
            background_color:'#fff',
            coordinate:{
                  axis : {
                        width : [0, 0, 2, 0]
                  },
                  background_color:'#ffffff',
                  height:'90%',
                  scale:[{
                         position:'left', 
                         scale_space:5,
                         scale_enable:false,//禁用小横线
                         listeners:{
                              parseText:function(t,x,y){
                                    return {text:t}
                              }
                        }
                  },{
                         position:'bottom',     
                         start_scale:1,
                         end_scale:12,
                         parseText:function(t,x,y){
                              return {textY:y+10}
                         },
                         labels:labels
                  }]
            }
      });
      chart.draw();

});

  // 条形图

$(function(){
      var data = [
                  {
                        name : '交通',
                        value:[45,52,54,74,90,84],
                        color:'#ff6c6c'
                  },
                  {
                        name : '机电',
                        value:[60,80,105,125,108,120],
                        color:'#25cbc1'
                  }
               ];
      var chart = new iChart.ColumnMulti2D({
                  render : 'chart3',
                  data: data,
                  border:{
                              width:0//整个画布的边框样式
                        },
                  labels:["1","2","3","4","5","6"],
                  width :600,
                  height :300,
                  background_color : '#ffffff',
                  coordinate:{
                        background_color : '#f1f1f1',
                        scale:[{
                               position:'left', 
                               start_scale:0,
                               end_scale:140,
                               scale_space:20
                        }],
                        width:500,
                        height:240
                  },
      });
      chart.draw();
});

function map(){
  var myChart = echarts.init(document.getElementById('map')); 
        option = {
        tooltip : {
            trigger: 'item'
        },
        dataRange: {
            min: 0,
            max: 2500,
            x: 'left',
            y: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        series : [
            {
                name: '项目',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '重庆',value: Math.round(Math.random()*1000)},
                    {name: '河北',value: Math.round(Math.random()*1000)},
                    {name: '河南',value: Math.round(Math.random()*1000)},
                    {name: '云南',value: Math.round(Math.random()*1000)},
                    {name: '辽宁',value: Math.round(Math.random()*1000)},
                    {name: '黑龙江',value: Math.round(Math.random()*1000)},
                    {name: '湖南',value: Math.round(Math.random()*1000)},
                    {name: '安徽',value: Math.round(Math.random()*1000)},
                    {name: '山东',value: Math.round(Math.random()*1000)},
                    {name: '新疆',value: Math.round(Math.random()*1000)},
                    {name: '江苏',value: Math.round(Math.random()*1000)},
                    {name: '浙江',value: Math.round(Math.random()*1000)},
                    {name: '江西',value: Math.round(Math.random()*1000)},
                    {name: '湖北',value: Math.round(Math.random()*1000)},
                    {name: '广西',value: Math.round(Math.random()*1000)},
                    {name: '甘肃',value: Math.round(Math.random()*1000)},
                    {name: '山西',value: Math.round(Math.random()*1000)},
                    {name: '内蒙古',value: Math.round(Math.random()*1000)},
                    {name: '陕西',value: Math.round(Math.random()*1000)},
                    {name: '吉林',value: Math.round(Math.random()*1000)},
                    {name: '福建',value: Math.round(Math.random()*1000)},
                    {name: '贵州',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '青海',value: Math.round(Math.random()*1000)},
                    {name: '西藏',value: Math.round(Math.random()*1000)},
                    {name: '四川',value: Math.round(Math.random()*1000)},
                    {name: '宁夏',value: Math.round(Math.random()*1000)},
                    {name: '海南',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: '招标',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '重庆',value: Math.round(Math.random()*1000)},
                    {name: '河北',value: Math.round(Math.random()*1000)},
                    {name: '安徽',value: Math.round(Math.random()*1000)},
                    {name: '新疆',value: Math.round(Math.random()*1000)},
                    {name: '浙江',value: Math.round(Math.random()*1000)},
                    {name: '江西',value: Math.round(Math.random()*1000)},
                    {name: '山西',value: Math.round(Math.random()*1000)},
                    {name: '内蒙古',value: Math.round(Math.random()*1000)},
                    {name: '吉林',value: Math.round(Math.random()*1000)},
                    {name: '福建',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '西藏',value: Math.round(Math.random()*1000)},
                    {name: '四川',value: Math.round(Math.random()*1000)},
                    {name: '宁夏',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            },
            {
                name: '中标',
                type: 'map',
                mapType: 'china',
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            }
        ]
    };
                    

    // 为echarts对象加载数据 
    myChart.setOption(option); 
}