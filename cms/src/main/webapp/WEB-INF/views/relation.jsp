<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>关系网展示页</title>
    <mycss>
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=1.0.1-20151229">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/util.css?v=1.0.1-20151229">
        <link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/relation.css?v=1.0.1-20151229">
        
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

<div class="chartCon">

    <div class='scaleCon'>
        <div class='scale' id='scale'>
            <i class='handle' id='scaleHandle'></i>
        </div>
    </div>
    <div class='descr'></div>
    <div class='tree'>
        
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
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20151229"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20151229"></script>
        <script type="text/javascript">
         // 入口模块
         seajs.use("${resPath}/resources/commons/js/public/relation")
        </script>
    </myScript>
</body>
</html>