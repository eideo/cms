// 左边图
$(function(){
      var flow=[];
      for(var i=0;i<25;i++){
            flow.push(Math.floor(Math.random()*(10+((i%16)*5)))+10);
      }
      
      // var data = [
      //             {
      //                   name : 'PV',
      //                   value:flow,
      //                   color:'#ec4646',
      //                   line_width:2
      //             }
      //          ];
      var data = [
                  {
                        name : '项目',
                        value:[1000,5000,4000,3500,6000,1800,5000,4000,4800,1050,5125],
                        color:'#4dced0'
                  },
                  {
                        name : '招标',
                        value:[2600,4800,1050,4125,5108,1120,1000,1125,3108,4600,3800],
                        color:'#cc7dda'
                  },
                  {
                        name : '中标',
                        value:[4600,3800,1000,1125,3108,4120,3500,6000,1800,5000,1800],
                        color:'#ffca64'
                  }
               ];
  
      var labels = ["04","05","06","07","08","09","10","11","12","01","02","03","04","05"];
      
      var chart = new iChart.LineBasic2D({
            render : 'leftChart',
            data: data,
            align:'left',
            offsetx:30,
            width : 600,
            height : 350,
            border:0,
            shadow:true,
            shadow_color : '#202020',
            shadow_blur : 8,
            shadow_offsetx : 0,
            shadow_offsety : 0,
            background_color:'#f6f6f6',
            tip:{
                  enable:true,
                  shadow:true,
                  listeners:{
                         //tip:提示框对象、name:数据名称、value:数据值、text:当前文本、i:数据点的索引
                        parseText:function(tip,name,value,text,i){
                              return "<span style='color:#2ec7c9;font-size:12px;'>"+labels[i]+"月访问量约:<br/>"+
                              "</span><span style='color:#2ec7c9;font-size:20px;'>"+value+"万</span>";
                        }
                  }
            },
            crosshair:{
                  enable:true,
                  line_color:'#f90'
            },
            sub_option : {
                  smooth : true,
                  label:false,
                  hollow:false,
                  hollow_inside:false,
                  point_size:8,
            },
            coordinate:{
                  width:440,
                  height:260,
                  striped_factor : 0.18,
                  grid_color:'#e6e6e6',//网格
                  axis:{
                        color:'#008acd',
                        width:[0,0,4,4]
                  },
                  scale:[{
                         position:'left', 
                         start_scale:0,
                         end_scale:6000,
                         scale_space:1000,
                         scale_size:2,
                         scale_enable : false,
                         label : {color:'#888888',font : '微软雅黑',fontsize:11},
                         scale_color:'#2ec7c9'
                  },{
                         position:'bottom',     
                         label : {color:'#888888',font : '微软雅黑',fontsize:11},
                         scale_enable : false,
                         labels:labels
                  }]
            }
      });

//开始画图
chart.draw();
});

// 中间图
$(function(){
      var data = [
                  {name : '北京',value : 20,color:'#ff64a9'},
                  {name : '武汉',value : 5,color:'#ff3e94'},
                  {name : '青岛',value : 25,color:'#bd54ff'},
                  {name : '河南',value :20,color:'#c569ff'},
                  {name : '重庆',value : 20,color:'#75afff'},
                  {name : '其他地区',value : 30,color:'#a9ccfc'}
            ];


      var chart = new iChart.Pie2D({
            render : 'centerChart',
            data: data,
            sub_option : {
                  mini_label_threshold_angle : 0,//迷你label的阀值,单位:角度
                  mini_label:{//迷你label配置项
                        fontsize:12,
                        fontweight:300,
                        color : '#ffffff'
                  },
                  label : {
                        // background_color:null,
                        // sign:false,//设置禁用label的小图标
                        // padding:'0 4',
                        // border:{
                        //       enable:true,
                        //       color:'#666666'
                        // },
                        fontsize:11,
                        fontweight:600,
                        color : '#4572a7'
                  },
                  listeners:{
                        parseText:function(d, t){
                              return d.get('name')+d.get('value')+"%";//自定义label文本
                        }
                  } 
            },
            coordinate:{
                  width:320,
                  height:320
            },
            shadow : false,
            shadow_blur : 6,
            shadow_color : '#aaaaaa',
            shadow_offsetx : 0,
            shadow_offsety : 0,
            background_color:'#f6f6f6',
            border:0,
            align:'center',//右对齐
            offsetx:0,//设置向x轴负方向偏移位置60px
            offset_angle:-90,//逆时针偏移120度
            width : 400,
            height : 400,
            radius:300
      });
      chart.draw();
      });

// 右图
function rchart(){
      var myChart = echarts.init(document.getElementById('rchart')); 
      var dataStyle = {
            normal: {
                  label: {show:false},
                  labelLine: {show:false}
            }
      };
      var placeHolderStyle = {
          normal : {
              color: 'rgba(0,0,0,0)',
              label: {show:false},
              labelLine: {show:false}
          },
          emphasis : {
              color: 'rgba(0,0,0,0)'
          }
      };
      option = {
            title: {
              text: '行业领域比例图',
              x: 120,
              y: 'center',
              itemGap: 20,
              textStyle : {
                  color : '#5e5e5e',
                  fontFamily : '微软雅黑',
                  fontSize : 16,
                  fontWeight : 'bolder'
              }
          },
          legend: {
              orient : 'vertical',
              x : document.getElementById('rchart').offsetWidth / 2,
              y : 20,
              itemGap:3,
              data:['能源50%','医疗卫生25%','环保5%','机械电子15%','化工15%']
          },
          series : [
              {
                  name:'1',
                  type:'pie',
                  clockWise:false,
                  radius : [110, 130],
                  itemStyle : dataStyle,
                  data:[
                      {
                          value:68,
                          name:'能源50%'
                      },
                      {
                          value:29,
                          name:'invisible',
                          itemStyle : placeHolderStyle
                      }
                  ]
              },
              {
                  name:'2',
                  type:'pie',
                  clockWise:false,
                  radius : [90, 110],
                  itemStyle : dataStyle,
                  data:[
                      {
                          value:98, 
                          name:'医疗卫生25%'
                      },
                      {
                          value:61,
                          name:'invisible',
                          itemStyle : placeHolderStyle
                      }
                  ]
              },
              {
                  name:'3',
                  type:'pie',
                  clockWise:false,
                  radius : [70, 90],
                  itemStyle : dataStyle,
                  data:[
                      {
                          value:87, 
                          name:'环保5%'
                      },
                      {
                          value:67,
                          name:'invisible',
                          itemStyle : placeHolderStyle
                      }
                  ]
              },
               {
                  name:'4',
                  type:'pie',
                  clockWise:false,
                  radius : [50, 70],
                  itemStyle : dataStyle,
                  data:[
                      {
                          value:77, 
                          name:'机械电子15%'
                      },
                      {
                          value:67,
                          name:'invisible',
                          itemStyle : placeHolderStyle
                      }
                  ]
              },
              {
                  name:'5',
                  type:'pie',
                  clockWise:false,
                  radius : [30, 50],
                  itemStyle : dataStyle,
                  data:[
                      {
                          value:55, 
                          name:'化工15%'
                      },
                      {
                          value:97,
                          name:'invisible',
                          itemStyle : placeHolderStyle
                      }
                  ]
              }

          ]
      };
         
                          

          // 为echarts对象加载数据 
          myChart.setOption(option); 
}
