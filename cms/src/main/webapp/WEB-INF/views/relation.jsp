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

    <div class='searchBody'>

        <div class='inputBox'>        
            <input type='text'  class='inputText' id='searchText' value='项目/单位名称'/>
            <div class='btnCon'><div class='btn'></div></div>
            <div class='searchItem'>
                <ul>
                    <li class="rItem">混凝土项目</li>
                    <li class="rItem">北京混凝土</li>
                    <li class="rItem">上海混凝土专业标</li>
                    <li class="rItem">混凝土公司</li>
                </ul>
            </div>
        </div>
        
        <div class='rem'>
            <div class='comRem'>
                <span>单位角色：</span>
                <ul>
                    <li class="item">全部</li>
                    <li class="item">业主</li>
                    <li class="item">设计院</li>
                    <li class="item">承建商</li>
                </ul>
            </div>
            <div class='perRem'>
               <span>联系人角色：</span>
                <ul>
                     <li class="item">全部</li>
                    <li class="item">设计师</li>
                    <li class="item">项目负责人</li>                  
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="chartCon">

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

    <div class="tip" style='display:none'>
        <div class="tipWrap"><i class="close">x</i>
            <div class="tipTitle" title="凯悦国际酒店管理集团(北京)有限责任公司商业及零售/办公楼/酒店与餐饮/交通">项目：凯悦国际酒店管理集团(北京)有限责任公司商业及零售/办公楼/酒店与餐饮/交通</div>
            <div class="tipCon">
                <ul>
                <li class="info">地址：上海</li>
                <li class="info">项目总额：20,700,000,000.00</li>
                <li class="more">了解更多</li>
                </ul>
            </div>
        </div>
    </div>
</div>

    <myScript>
      
        <script type="text/javascript" src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/relationCookie.js?v=1.0.1-20160113"></script>
        <script type="text/javascript" src="${resPath}/resources/commons/js/intro.js?v=1.0.1-20160113"></script>
        <script type="text/javascript">
         // 入口模块
         seajs.use("${resPath}/resources/commons/js/public/relation")
        </script>

        <script type="text/javascript">
            var num = getCookie('age');
            $(function(){
                if(num != "18"){
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
                    addCookie('age','18',250);
                }
            });
        </script>
    </myScript>
</body>
</html>