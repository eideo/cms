<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>关系网展示页</title>
    <mycss>
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=1.0.1-20160113">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/util.css?v=1.0.1-20160113">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/relation.css?v=1.0.1-20160113">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/intro.css?v=1.0.1-20160113">
        
    </mycss>
</head>
<body>

<div class='sliderCon'>

    <div class='sliderBody'>
        <div class='start'>2001</div>
        <div class="slider" id='slider'>
            <div class='timeShow' id='timeShow'>2010.01 - 2012.01</div>
            <div class='handle' id='handle'></div>
        </div>
        <div class='end'>2015</div>
    </div>
    <div class='searchBody'>

        <div class='inputBox'>        
            <input type='text'  class='inputText' id='searchText' value='项目/单位名称'/>
            <div class='searchItem'>
                <ul>
                    <li class="rItem">混凝土项目</li>
                    <li class="rItem">北京混凝土</li>
                    <li class="rItem">上海混凝土专业标</li>
                    <li class="rItem">混凝土公司</li>
                </ul>
            </div>
        </div>
        <div id="Rem" class="clearfix">
            <div class='comRem'>
                <div class="comRemCon">
                    <div class='topTitle'>业主<i></i></div>
                    <div class='list' style='display:none'>
                        <ul>
                            <li>单位角色</li>
                            <li class="item selected">业主</li>
                            <li class="item">设计院</li>
                            <li class="item">承建商</li>
                            <li class="item">供应商</li>
                            <li class="item diabled">招标代理</li>
                        </ul>
                    </div>
                </div>    
            </div>
            <div class='perRem'>
                <div class="perRemCon">
                    <div class='topTitle'>项目负责人<i></i></div>
                    <div class='list' style='display:none'>
                        <ul>
                            <li>联系人角色</li>
                            <li class="item">总工程师</li>
                            <li class="item">规划师</li>
                            <li class="item selected">项目负责人</li>
                            <li class="item">前期负责人</li>
                            <li class="item">现场负责人</li>
                            <li class="item">项目经理</li>
                            <li class="item">采矿工程师</li>
                            <li class="item">道桥工程师</li>
                            <li class="item">地质勘查工程师</li>
                            <li class="item">电气工程师</li>
                            <li class="item">动力工程师</li>
                            <li class="item">副总工程师</li>
                            <li class="item">钢结构工程师</li>
                            <li class="item">给排水工程师</li>
                            <li class="item">工艺工程师</li>
                            <li class="item">光伏工程师</li>
                            <li class="item">轨道工程师</li>
                            <li class="item">化工工程师</li>
                            <li class="item">机电工程师</li>
                            <li class="item">建筑工程师</li>
                            <li class="item">建筑设计师</li>
                            <li class="item">结构工程师</li>
                            <li class="item">景观设计师</li>
                            <li class="item">幕墙设计师</li>
                            <li class="item">暖通工程师</li>
                            <li class="item">弱电工程师</li>
                            <li class="item">设备工程师</li>
                            <li class="item">室内设计师</li>
                            <li class="item">通信工程师</li>
                            <li class="item">项目知情人</li>
                            <li class="item">消防工程师</li>
                            <li class="item">信号工程师</li>
                            <li class="item">园林设计师</li>
                            <li class="item">装饰设计师</li>
                            <li class="item">项目参与人</li>
                            <li class="item">其他</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class='btnCon'><div class='btn'></div></div>
        </div>
    </div>
</div>

<div class="chartCon">

<!--     <div class='scaleCon'>
    <div class='scale' id='scale'>
        <i class='handle' id='scaleHandle'></i>
    </div>
</div> -->
    <div class='descr'></div>
    <div class='tree' >  
        <div id="relationImg">
            <img src='${resPath}/resources/commons/images/resTemp.png' />
        </div>
    </div>
    <div class='recomCon'>
        <div class="top">
            其他人正在浏览
            <i></i>
        </div>
        <div class="recom">
            <div class='reTitle'>联系人</div>
            <div id='marquee'>
                <ul>
                    <li>张小三 137***501 </li>
                    <li>张小三137***501</li>
                    <li>张小三137***501</li>
                    <li>张小三137***501</li>
                </ul>
            </div>
        </div>
    </div>
</div>

    <myScript>
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/intro.js?v=1.0.1-20160113"></script>
        <script type="text/javascript">
         // 入口模块
         seajs.use("${resPath}/resources/commons/js/public/relation")
        </script>

        <script type="text/javascript">
            $(function(){
                    introJs().setOptions({
                        //对应的按钮
                        prevLabel:"上一步", 
                        nextLabel:"下一步",
                        skipLabel:"跳过引导页",
                        doneLabel:"立即体验",
                        //对应的数组，顺序出现每一步引导提示
                        steps: [
                            {
                                //第一步引导
                                //这个属性类似于jquery的选择器， 可以通过jquery选择器的方式来选择你需要选中的对象进行指引
                                element: '.user-info',
                                //这里是每个引导框具体的文字内容，中间可以编写HTML代码
                                intro: '<div id="guideMsg"><h3>登录查询</h3><p>亲,只有登录了!才能查看关系网更多信息</p></div>',
                                //这里可以规定引导框相对于选中对象出现的位置 top,bottom,left,right
                                position: 'left'
                            },
                            {
                                //第二步引导
                                element: '#searchText',
                                intro: '<div id="guideMsg"><h3>精确搜索</h3><p>输入项目名称或单位名称按角色进行关系精确查询</p></div>',
                                position: 'left'
                            },
                            {
                                //第三步引导
                                element: '#Rem',
                                intro: '<div id="guideMsg"><h3>精确搜索</h3><p>选择角色进行精确查询</p></div>',
                                position: 'left'
                            },
                            {
                                //第四步引导
                                element: '.sliderBody',
                                intro: '<div id="guideMsg"><h3>时间轴筛选</h3><p>亲，您还可以通过时间轴对搜索进行调整。</p></div>',
                                position: 'right'
                            },
                            {
                                //第五步引导
                                element: '#relationImg',
                                intro: '<div id="guideMsg"><h3>搜索结果</h3><p>试试鼠标悬浮或者点击结点，会有意外收获</p></div>',
                                position: 'right'
                            },
                            {
                                //第六步引导
                                element: '.recomCon',
                                intro: '<div id="guideMsg"><h3>其他人关注</h3><p>您还可以看看其他人都查了些什么？</p></div>',
                                position: 'left'
                            } 
                        ]

                    }).start();
            });
        </script>
    </myScript>
</body>
</html>