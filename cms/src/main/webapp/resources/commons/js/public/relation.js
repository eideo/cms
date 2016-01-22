/* 
 * @Author: Administrator
 * @Date:   2015-11-18 15:50:00
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-22 17:14:15
 */

'use strict';

define(function(require, exports, module) {

    var nicescroll = require('niceScroll')

    var Slider = require('../../js/lib/slider')

    var Scale = require('../../js/lib/scale')

    var Debounce = require('../../js/util/debounce')

    var kxdbmarquee = require('kxdbmarquee')

    var AjaxObj = {
        type: 0,
        smallName: '',
        name: '',
        companyRoleArray: [],
        personRoleArray: [],
        startDate: '201312',
        endDate: '201511',
        rolesName: '',
        rolesType: 'company',
        industryId: '2108',
        canSearch: false
    }

    var RelationChart = require('../../js/chart/relationChart')

    var Tool = require('../../js/util/tool')

    var setting = {
        selector: '.tree',
        series: null,
        root: "project",
        legend: ['项目', '单位', '联系人'],
        colorSet: {
            project: '#ff1d20',
            company: '#239deb',
            person: '#ff9a00'
        },
        normal: {
            project: '#eb5864',
            company: '#ff8a0f',
            person: '#4aa0d4'
        }
    }

    var Event = require('../../js/util/event')

    function getRelation(callback) {

        Tool.mask();

        var argComRole = AjaxObj.companyRoleArray.join(','),
            argPerRole = AjaxObj.personRoleArray.join(',')

        if (argComRole === '全部') {

            argComRole = ''
        }

        if (argPerRole === '全部') {

            argPerRole = ''
        }

        $.ajax({
            url: path + '/getRelation',
            type: 'POST',
            dataType: 'json',
            data: {
                startDate: AjaxObj.startDate,
                endDate: AjaxObj.endDate,
                type: 0,
                name: AjaxObj.name,
                companyRole: argComRole,
                personRole: argPerRole
            },
            success: function(data) {

                Tool.removeMask()

                var series = {
                    nodes: data.objectList,
                    links: data.linkList
                }

                if (data.linkList.length === 0) {


                    var $noData = $('<div></div>')
                        .addClass('dataError')
                        .html('<img src="' + path + '/resources/commons/images/forceSearchErroe.png' + '"/>')
                        .appendTo($('.tree'))

                    var $i = $('<i></i>').appendTo($noData)

                    return
                }

                setting.root = AjaxObj.rolesType
                setting.series = series

                RelationChart.init(setting)
            },
            error: function() {

                return "error";
            }
        })
    }

    function loadUrlDate(callback) {

        var url = window.location.href,
            args

        if (url === path + '/relation' || url.split('/')[3] === 'relation') {

            return
        } else {


            args = Tool.getUrlArgs(document.getElementById('getUrlArgs'))

            AjaxObj.name = decodeURIComponent(args['name'])
            AjaxObj.id = args['id']
            AjaxObj.rolesType = args['type']
            AjaxObj.canSearch = true

            if (args['industryId']) {

                AjaxObj.industryId = args['industryId']
                getRecommProject(function() {

                    $(".searchBody .inputText")
                        .val(AjaxObj.name)
                        .data('cValue', AjaxObj.name)

                    getRelationRoles(function() {

                        getRelation()
                    })
                })

                return
            }

            $(".searchBody .inputText")
                .val(AjaxObj.name)
                .data('cValue', AjaxObj.name)

            getRelationRoles(function() {

                getRelation()
            })
        }
    }

    function getList(callback) {

        $.ajax({
            url: path + '/relationSuggest',
            type: 'POST',
            dataType: 'json',
            data: {
                'name': AjaxObj.smallName,
            },
            success: function(data) {

                $('.searchItem').find('ul').html('')

                if (data.length === 0) {
 
                    return
                } else {

                    for (var i = 0; i < data.length; i++) {

                        var li = $('<li></li>')
                            .addClass('rItem')
                            .html(data[i].name)
                            .data('type', data[i].type)

                        $('.searchItem').find('ul').append(li)
                    }
                }
            }
        })
    }

    function getRelationRoles(callback) {

        $.ajax({
            url: path + '/getRelationRoles',
            type: 'POST',
            dataType: 'json',
            data: {
                name: AjaxObj.name,
                type: AjaxObj.rolesType
            },
            success: function(data) {

                if (!data) {

                    return
                }

                $('.comRem ul').html('')
                $('.perRem ul').html('')

                var companyRoles = data.companyRoles,
                    personRoles = data.personRoles

                var $liAll = $('<li class="item"></li>')
                    .addClass('selected')
                    .html('全部')
                    .appendTo($('.comRem ul'))

                var $liAll2 = $('<li class="item"></li>')
                    .html('全部')
                    .appendTo($('.perRem ul'))

                companyRoles.forEach(function(item, index) {

                    var $li = $('<li class="item"></li>')
                        .html(item['role'])
                        .appendTo($('.comRem ul'))
                })

                personRoles.forEach(function(item, index) {

                    var role = item['role'];

                    var $li = $('<li class="item"></li>')
                        .html(role)
                        .appendTo($('.perRem ul'))

                    if (index > 1) {

                        $li.addClass('hidden');
                    }

                    if (index === 0) {

                        $li.addClass('selected');
                    }
                })

                if (personRoles.length > 3) {

                    var $more = $('<i class="more"></i>').appendTo($('.perRem'))
                }

                if (companyRoles.length > 3) {

                    var $more = $('<i class="more"></i>').appendTo($('.comRem'))
                }

                if (callback && callback()) {

                    callback()
                }
            }
        })
    }

    function getRecommProject(callback) {
        $.ajax({
            url: path + '/getRecommProject',
            type: 'POST',
            dataType: 'json',
            data: {
                industryId: AjaxObj.industryId
            },
            success: function(data) {

                AjaxObj.name = data.projectName
                AjaxObj.rolesType = 'project'
                if (callback && callback()) {

                    callback()
                }
            }
        })
    }

    // 获取正在查询当前关键词的人的信息
    function getSameSearchPerson(callback) {

         $.ajax({
            url: path + '/getSameSearchPerson',
            type: 'POST',
            dataType: 'json',
            data: {
                name:AjaxObj.name
            },
            success: function(data) {
                
                var username;

                if (data.status === "true") {

                    if (data.username === undefined) {

                        username = 'xxx'
                    } else {
                        username = data.username;
                    }

                    $('#marquee ul li').html(username + '  ' +data.phone)

                }
            }
        })
    }

    function initSlider() {

        var sliderOption = {
            selector: 'slider',
            handle: 'handle',
            range: null,
            value: 154,
            dom: '.timeShow'
        }

        var scaleOption = {
            selector: 'scale',
            handle: 'scaleHandle',
            range: null,
            value: 10
        }

        $("#marquee").kxbdMarquee({
            direction: "up",
            isEqual: false,
            scrollDelay: 50
        })
    }

    function initFocus() {

        $('.searchBody .inputText').on('focus', function(e) {

            var val = $(this).attr('value')
            $(this).addClass('selected')
        })

        $(".searchBody .inputText").bind('input', function() {

            AjaxObj.smallName = $(this).val()

            $(this).data('cValue', $(this).val())

            $('.searchItem').slideDown()

            Debounce.lightThrottle(getList)
        })

        $('.searchBody .searchItem li').live('click', function(e) {

            var e = e || window.event,
                word = $(this).html(),
                type = $(this).data('type')

            $(".searchBody .inputText").data('cValue', word)
            $('.searchBody .inputText').val(word)

            $('.searchItem').slideUp()

            AjaxObj.name = word
            AjaxObj.rolesType = type
            AjaxObj.canSearch = true

            getRelationRoles()
            getSameSearchPerson()
        })

        $('.searchBody .inputText').on('blur', function(e) {

            var val = $(this).attr('value'),
                cValue = $(this).data('cValue')

            if (cValue === '') {

                $(this).val('项目/单位名称')
            } else {
                //$(this).val(cValue)
            }

            $('.searchItem').slideUp()
            $(this).removeClass('selected')
        })


        $('.searchBody .btnCon').on('click', function(e) {

            var inputValue = $('.searchBody .inputText').val()

            if (inputValue === '' || inputValue === '项目/单位名称') {

                $('.searchBody .inputText').addClass('selected')

                return
            } else {

                if (AjaxObj.canSearch) {

                    Tool.mask()
                    getRelation()
                }

            }
        })

        /*浏览展开*/
        $('.recomCon .top').find('i').on('click', function(e) {

            var display = $('.recom').css('display')
            display === 'none' ? $('.recom').slideDown(500) : $('.recom').slideUp(500)
            display === 'none' ? $(this).addClass('selected') : $(this).removeClass('selected')
        })
    }

    function initRole() {

        // 鼠标滑过事件
        $('.tip .close').live('click', function(e) {

            $(this).parent().parent().remove()
        })

        $(".recomCon").draggable({
            containment: 'parent'
        });
        $('.tip').draggable({
            containment: "parent"
        });

        $('.comRem ul li,.perRem ul li').live('click', function(e) {

            var parent = $(this).parent().parent(),
                word = $(this).html(),
                comIndex,
                perIndex,
                thisIndex = $(this).index(),
                ul = $(this).parent(),
                firstLi = ul.find('li').get(0)

            if ($(this).hasClass('selected')) {

                $(this).removeClass('selected')
            } else {

                if (thisIndex > 2) {
                    $(this).insertAfter(firstLi)
                }
                $(this).addClass('selected')
            }

            if (thisIndex === 0) {

                $(this).siblings().removeClass('selected')

                if (parent.hasClass('comRem')) {

                    AjaxObj.companyRoleArray = []

                } else if (parent.hasClass('perRem')) {
                    AjaxObj.personRoleArray = []
                }

            } else {

                parent.find('li').eq(0).removeClass('selected')
            }

            if (parent.hasClass('comRem')) {

                comIndex = AjaxObj.companyRoleArray.indexOf(word)

                if (comIndex === -1) {

                    AjaxObj.companyRoleArray.push(word)
                } else {
                    AjaxObj.companyRoleArray.splice(comIndex, 1)
                }

            } else if (parent.hasClass('perRem')) {

                perIndex = AjaxObj.personRoleArray.indexOf(word)

                if (perIndex === -1) {

                    AjaxObj.personRoleArray.push(word)
                } else {
                    AjaxObj.personRoleArray.splice(perIndex, 1)
                }
            }

            if (AjaxObj.canSearch) {

                Debounce.lightThrottle(getRelation)

            } else {

                $('.searchBody .inputText').addClass('selected')

                return
            }
        })

        $('.perRem .more,.conRem .more').live('click', function() {

            var parent = $(this).parent().find('ul'),
                height = parent.height()

            if (parent.height() === 32) {

                parent.find('li').removeClass('hidden')
            } else {
                parent.find('li:gt(2)').addClass('hidden')
            }
        })


        $('.dataError i').live('click', function() {

            $('.dataError').remove()
        })
    }

    $(function() {

        initSlider()
        loadUrlDate()
        initFocus()
        initRole()
        
        Event.listen('timeChange', function(parm) {

            AjaxObj.startDate = parm[0]
            AjaxObj.endDate = parm[1]
        })

        // 浏览器版本检测
        ! function() {
            var cookie,
                ua,
                match;
            ua = window.navigator.userAgent;
            match = /;\s*MSIE (\d+).*?;/.exec(ua);
            if (match && +match[1] < 9) {
                cookie = document.cookie.match(/(?:^|;)\s*ic=(\d)/);
                if (cookie && cookie[1]) {
                    return;
                }
                $("body").prepend([
                    "<div id='compatible' class='compatible-contianer'>",
                    "<p class='cpt-ct'><i></i>您的浏览器版本过低。为保证最佳浏览体验，<a href='/static/html/browser.html'>请点此更新高版本浏览器</a></p>",
                    "<div class='cpt-handle'><a href='javascript:;' class='cpt-agin'>以后再说</a><a href='javascript:;' class='cpt-close'><i></i></a>",
                    "</div>"
                ].join(""));

                $("#compatible .cpt-agin").click(function() {
                    var d = new Date();
                    d.setTime(d.getTime() + 30 * 24 * 3600 * 1000);
                    document.cookie = "ic=1; expires=" + d.toGMTString() + "; path=/";
                    $("#compatible").remove();
                });
                $("#compatible .cpt-close").click(function() {
                    $("#compatible").remove();
                });
            }
        }();
    })

    module.exports = 'relation'
})
