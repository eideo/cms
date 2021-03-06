/* 
 * @Author: zhanganchun
 * @Date:   2016-01-04 15:01:07
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-18 12:01:58
 */

"use strict";
define(function(require, exports, module) {

/*	var $ = require('jquery')
    var createPage = require('./lib/page');*/
    var Close = require('./lib/common');
    var ajax = require('./public/ajax');
    var SearchChart = require('./chart/searchChart');
    var Tool = require('./util/tool')

    function toTop() {

        var h = $(window).height();
        var t = $(document).scrollTop();
        if (t >= 768) {
            $('#gotop').show();
        } else {
            $('#gotop').hide();
        }
    }

    function searchHint() {

        $('.searchBox').focus(function() {

            $(this).addClass('active');
            $('.searchBtn').addClass('on');
        }).blur(function() {

            $(this).removeClass('active');
            $('.searchBtn').removeClass('on');
        })

        $('.prompt').on("mouseover", function() {

            $(this).show();
        }).on("mouseout", function() {

            $(this).hide();
        });

        $('.searchBox').on("keyup", function() {

            var name = this.value;
            if (name) {

                getSuggest(name);
            }
        });

        $('.prompt').on("click", "li", function() {

            $('.searchBox').val($(this).text());
            ajaxSearch();
            searchJump(".chartCon", 0);
        });

        var searchInput = document.getElementById('searchBox');

        searchInput.oninput = function() {

            if (this.value != '') {

                $('.search i').show();
            } else {

                $('.search i').hide();
            }
        }

        $('.search i').click(function() {

            $('.searchBox').val('');
            $(this).hide();
        })
    }

    var leftSetting = {
        selector: '.chartwrap .left',
        margin: {
            left: 63,
            top: 50,
            right: 30,
            bottom: 40
        },
        colorset: ['#ffb503', '#fd8b59', '#91e035'],
        series: [],
        type: ['项目', '招标', '中标'],
        opacity: [0.4, 0.8, 0.4]
    }


    var arcSetting = {
        selector: '.chartwrap .right .chart1',
        width: 280,
        height: 240,
        margin: {
            left: 0,
            top: 0,
            right: 0,
            bottom: 0
        },
        colorset: ['#ff7290', '#c572ff', '#9ee262', '#ffd55a', '#ffb503', '#4ad486'],
        series: []
    }


    var tagSetting = {
        selector: '.chartwrap .right .chart2',
        margin: {
            left: 70,
            top: 50,
            right: 50,
            bottom: 60
        },
        colorset: ['#ffb541', '#96ccff', '#ddeeff', '#c4e5ff', '#addaff', '#97cfff', '#97cfff'],
        series: []
    }

    function GetRequest() {
        var url = location.search; //获取url中"?"符后的字串
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            var strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    function getSuggest(val) {
        var data = {};
        data.name = val;
        ajaxNotAsync("post", path + "/getSuggest", data, "json", function(result) {
            if (result.status) {
                $(".prompt").html("");
                for (var i = 0; i < result.datas.length; i++) {
                    var li = $("<li>" + result.datas[i] + "</li>");
                    $(".prompt").append(li);
                }
                $('.prompt').show();
            }
        }, function(e) {});

    }

    function initChart(data) {

        var dataArea = data[0].dataArea,
            dataIndustry = data[0].dataIndustry,
            dataTimeo = data[0].dataTimeo,
            tagSeries = [],
            arcSeries = [],
            tempArray1 = [],
            tempArray2 = [],
            tempArray3 = [],
            leftSeries = []

        if (dataArea.length !== 0) {

            dataArea.forEach(function(item) {

                var temp = [item['area'], item['nums']];
                tagSeries.push(temp);
            })

            tagSetting.series = tagSeries
            SearchChart.rect(tagSetting)
        }

        if (dataIndustry.length !== 0) {

            dataIndustry.forEach(function(item) {
                var temp1 = {
                    name: item['industry'],
                    weight: 1,
                    value: item['nums']
                }

                arcSeries.push(temp1)
            })

            arcSetting.series = arcSeries
            SearchChart.pieCircle(arcSetting)
        }

        if (dataTimeo.length !== 0) {


            dataTimeo.forEach(function(item) {

                var bid = {
                    time: item['time'],
                    value: item['bid']
                }

                var project = {
                    time: item['time'],
                    value: item['project']
                }

                var tender = {
                    time: item['time'],
                    value: item['tender']
                }

                tempArray1.push(project)
                tempArray2.push(tender)
                tempArray3.push(bid)
            })

            leftSeries.push(tempArray1)
            leftSeries.push(tempArray2)
            leftSeries.push(tempArray3)

            leftSetting.series = leftSeries
            SearchChart.brokeArea(leftSetting)
        }
    }

    // 获取图表部分的数据，刷新图表
    function getData() {

        var mhref = window.location.href.split('=')
        var word = decodeURIComponent(mhref[1])

        var term1Spans = $('.term .term1>.span span'),
            term2Spans = $('.term .term2>.span span'),
            term3Spans = $('.term .term3>.span span'),
            typeArray = [],
            cityArray = [],
            tradeArray = [],
            typeString,
            cityString,
            tradeString,
            timeStart,
            timeEnd

        for (var sj = 0; sj < term1Spans.length; sj++) {

            typeArray.push(term1Spans.eq(sj).text())
        }

        if (term2Spans.length < 5) {

            for (var si = 0; si < term2Spans.length; si++) {

                cityArray.push(term2Spans.eq(si).text())
            }
        } else {

            for (var si = term2Spans.length; si > term2Spans.length - 6; si--) {

                cityArray.push(term2Spans.eq(si).text())
            }
        }

        for (var sk = 0; sk < term3Spans.length; sk++) {

            tradeArray.push(term3Spans.eq(sk).text())
        }

        typeString = typeArray.join(',')
        cityString = cityArray.join(',')
        tradeString = tradeArray.join(',')

        var parmStart = $('.innerTime .start').text(),
            parmEnd = $('.innerTime .end').text()

        timeStart = parmStart.substr(0, 4) + parmStart.substr(5, 2)
        timeEnd = parmEnd.substr(0, 4) + parmEnd.substr(5, 2)


        $.ajax({
            url: path + '/getsearchstatistics',
            data: {
                'type': typeString,
                'keywords': word,
                'area': cityString,
                'industry': tradeString,
                'startDate': timeStart,
                'endDate': timeEnd
            },
            type: "POST",
            dataType: "json",
            success: function(data) {

                initChart(data)
            },
            error: function() {

                $.Message({
                    text: '请求异常',
                    type: "failure"
                })

            }
        })
    }

    // 搜索ajax
    function ajaxSearch(p) {

        if (!p) {

            refreshLikewords();
        }

        //获取搜索条件、
        var time = $("#Checktime span").attr('circle');

        var type = "";
        $("#term1 span").each(function() {

            type += $(this).text() + ",";
        });

        var area = ""
        $("#term2 span").each(function() {

            area += $(this).attr('rid') + ",";
        });

        var trade = ""
        $("#term3 span").each(function() {

            trade += $(this).text() + ",";
        });

        var data = {};
        if (p) {

            data.pageNo = p;
        } else {

            data.pageNo = 1;
        }

        data.keyword = $('.searchBox').val();
        data.circle = time;
        data.area = area;
        data.industry = trade;
        data.type = type;

        if (data.circle == '' && data.keyword == '' && data.area == '' && data.industry == '' && data.type == '') {

            return;
        }

        ajaxAsync("post", path + "/ajaxsearch", data, "json", function(datas) {

            if (datas.status) {

                //搜素用时以及结果条数
                $("#s_time").text(datas.time);
                $("#s_number").text(datas.count);
                $(".resultList").html("");

                if (datas.listIndex.length === 0) {

                    $('.chartCon').hide();
                    var imgError = path + '/resources/commons/images/searchError.png';
                    $('#list').html('<img src="' + path + '/resources/commons/images/searchError.png' + '" style="margin:100px auto"/>')
                    $(".paging").hide()
                } else {

                    $('.chartCon').show();
                    $(".paging").show()

                    getData();
                }


                for (var i = 0; i < datas.listIndex.length; i++) {

                    var indexData = datas.listIndex[i];
                    var html = $("#listTemp").html();
                    if (indexData.projectName) {

                        html = html.replace("{projectName}", "?name=" + indexData.projectName + "&&type=project");
                    } else {

                        html = html.replace("{projectName}", "");
                    }
                    if (indexData.areaName) {
                        html = html.replace("{indexInfo.areaName}", "<a class=\"add\">" + indexData["areaName"] + "</a>");
                    } else {
                        html = html.replace("{indexInfo.areaName}", "");
                    }
                    for (var key in indexData) {

                        while (html.indexOf("{indexInfo." + key + "}") != -1) {

                            html = html.replace("{indexInfo." + key + "}", indexData[key]);
                        }
                    }
                    while (html.indexOf("{indexInfo.") != -1) {
                        html = html.replace(/{indexInfo[^}]+}/g, "");
                    }
                    $(".resultList").append(html);
                }

                removeLink();

                if (!p) {

                    $("#num_span").text(datas.count);
                    $(".tcdPageCode").createPage({

                        pageCount: datas.num,
                        current: 1,
                        backFn: function(p) {

                            ajaxSearch(p);
                        }
                    });
                }
            }
        }, function(data) {

            //alert("非常抱歉，服务器发生错误，请联系管理员解决！");
        });
    }

    function refreshLikewords() {

        $(".rSearch a").remove();

        var keyword = $('.searchBox').val();
        if (keyword.trim() == "") {

            return;
        }
        var data = {};
        data.keyword = keyword;

        ajaxAsync("post", path + "/gethotkeywords", data, "json", function(datas) {

            if (datas.status) {

                var alldata = datas.hotKeywords;
                for (var i = 0; i < alldata.length; i++) {

                    var a = '<a href="' + path + '/search?keyword=' + alldata[i].keywords + '">' + alldata[i].keywords + '</a>';
                    $(".rSearch").append($(a));
                }
            }
        }, function(data) {

            $.Message({

                    text: '非常抱歉，服务器发生错误',
                    type: 'failure'
                })
                //alert("非常抱歉，服务器发生错误，请联系管理员解决！");
        });
    }

    // 判断不限
    function unlimit() {

        $('#anyTime').on("click", function() {

            $('#Checktime span').remove();
            $(this).addClass('active');
            $('#opTime li').removeClass('active');
            $('.Checktime').hide();

            ajaxSearch();
            searchJump(".hr", 0);
            checkLimit();
        })

        $('#anyType').on("click", function() {

            $('#term1 span').remove();
            $(this).addClass('active');
            $('#opType li').removeClass('active');
            $('.term1').hide();

            ajaxSearch();
            searchJump(".hr", 0);
            checkLimit();
        })
        $('#anyRegion').on("click", function() {

            $('#term2 span').remove();
            $(this).addClass('active');
            $('#opCity span').removeClass('active');
            $('.term2').hide();

            ajaxSearch();
            searchJump(".hr", 0);
            checkLimit();
        })
        $('#anyIndustry').on("click", function() {

            $('#term3 span').remove();
            $(this).addClass('active');
            $('#dtrade span').removeClass('active');
            $('.term3').hide();

            ajaxSearch();
            searchJump(".hr", 0);
            checkLimit();
        })

    }

    function checkLimit() {

        if ($("#term p span").length == 0) {

            $(".termBox").hide();
        }
    }


    //二级目录移入效果
    function secondLevel() {

        $('#tradeBox .more').click(function() {

                if ($(".liHidden").css("display") == "none") {

                    $(".liHidden").show();
                    $(this).addClass('active');
                    $(this).find('em').addClass('active');
                } else {

                    $(".liHidden").hide();
                    $(this).removeClass('active');
                    $(this).find('em').removeClass('active');
                }
            })
            // 行业二级菜单
        $('#dtrade li').mouseover(function() {

            $(this).find('p').show();
            $(this).find('i').show();
        }).mouseout(function() {

            $(this).find('p').hide();
            $(this).find('i').hide();
        })

        //	地区二级目录
        $('#opCity').on("mouseover", "li", function() {

            $(this).find('div').show();
            $(this).find('i').show();
        }).on("mouseout", "li", function() {

            $(this).find('div').hide();
            $(this).find('i').hide();
        })

    }

    // 添加搜索条件
    function addOption() {

        // 点击更多
        $('#more1').click(function() {

            if ($(".liHidden2").css("display") == "none") {

                $(".liHidden2").show();
                $(this).addClass('active');
                $(this).find('em').addClass('active');
            } else {

                $(".liHidden2").hide();
                $(this).removeClass('active');
                $(this).find('em').removeClass('active');
            }
        });

        //点击省份
        $('#areaBox').on("click", "li span", function() {

            // add by yujunwei 2015-11-12 15:00
            // 用户行为-点击搜索条件
            topClick(7, 2, $(this).text());

            if ($(this).hasClass("active")) {

                $(this).removeClass('active');
                $('#term2 span[rid="' + $(this).parent().attr('id') + '"]').remove();
                $('#term2 span[pid="' + $(this).parent().attr('id') + '"]').remove();
                $(this).parent().find("a.active").remove();
                if ($('.term2 span').length == 0) {

                    $('.term2').hide();
                    $('#anyRegion').addClass('active');
                }

                checkLimit();
            } else {

                if ($("#term2 span").length == 5) {

                    $.Message({

                        text: '最多同时选择5个地区',
                        type: 'failure'
                    })
                    return;
                }

                $(".termBox").show();

                if ($('#term2 span[rid="' + $(this).parent().attr('id') + '"]').length == 0) {

                    $("#term2 span[pid='" + $(this).parent().attr('id') + "']").remove();
                    $('<span><span>').text($(this).text()).appendTo('#term2').attr('rid', $(this).parent().attr('id'));
                }

                $(this).addClass('active');
                $('#anyRegion').removeClass('active');
                $('.term2').show();
            }

        })

        //点击二级城市，添加搜索条件
        $('#opCity').on("click", "a", function() {

            if ($(this).hasClass("active")) {

                $(this).removeClass("active");

                var thisSpan = $("#term2 span[rid='" + $(this).attr("id") + "']");
                var spanText = thisSpan.text();
                var pid = thisSpan.attr("pid");

                thisSpan.remove();
                var pChild = $("#term2 span[pid='" + pid + "']");

                if (pChild.length == 0) {

                    $(this).parent().parent().find("span").removeClass("active");
                } else if (spanText.indexOf("-") != -1) {

                    $(pChild[0]).text($("#" + pid).find("span").text() + "-" + $(pChild[0]).text());
                }

                if ($('.term2 span').length == 0) {

                    $('.term2').hide();
                    $('#opCity .active').removeClass('active');
                    $('#anyRegion').addClass('active');
                }

                checkLimit();
            } else {

                if ($("#term2 span").length == 5) {

                    $.Message({

                        text: '最多同时选择5个地区',
                        type: 'failure'
                    })
                    return;
                }

                //如果父级已选择则不做操作
                var pid = $(this).parent().parent().attr("id");

                if ($('#term2 span[rid="' + pid + '"]').length > 0) {

                    $('#term2 span[rid="' + pid + '"]').remove();
                }


                $(".termBox").show();
                $(this).addClass("active");
                $(this).parent().parent().find("span").addClass('active');
                $('#anyRegion').removeClass('active');

                // add by yujunwei 2015-11-12 15:00
                // 用户行为-点击搜索条件
                topClick(7, 2, $(this).text());

                var p = $(this).parent().parent().find("span").text();
                var parentTerm = $("#term2 span:contains('" + p + "')");
                var city = $(this).text();
                if (parentTerm.length == 0) {

                    var province = p + '-' + $(this).text();

                    if ($('#term2 span[rid="' + $(this).attr('id') + '"]').length == 0) {

                        $('<span><span>').text(province).appendTo('#term2').attr('rid', $(this).attr('id')).attr("pid", pid);
                    }
                } else {

                    var province = $(this).text();

                    if ($('#term2 span[rid="' + $(this).attr('id') + '"]').length == 0) {

                        var span = $('<span><span>').text(province).attr('rid', $(this).attr('id')).attr("pid", pid);
                        parentTerm.after(span);
                    }
                }

                $('.term2').show();
            }
        })

        $('#term2').on("click", "span", function() {

            var id = $(this).attr("rid");
            var source = $("#" + id);

            $(this).remove();
            if (source.is("li")) {

                source.find("span").removeClass('active');
            } else {

                source.removeClass("active");
                var pid = $(this).attr("pid");
                var text = $(this).text();
                var pChild = $("#term2 span[pid='" + pid + "']");

                if (pChild.length == 0) {

                    $("#" + pid).find("span").removeClass("active");
                } else if (text.indexOf("-") != -1) {

                    $(pChild[0]).text($("#" + pid).find("span").text() + "-" + $(pChild[0]).text());

                }
            }

            if ($('.term2 span').length == 0) {

                $('.term2').hide();
                $('#opCity .active').removeClass('active');
                $('#anyRegion').addClass('active');
            } else {

                $('.term2').show();
            }

            ajaxSearch();
            searchJump(".hr", 0);
        })

        //点击二级行业，添加搜索条件
        $('#dtrade').on("click", "a", function() {

            if ($(this).hasClass("active")) {

                $(this).removeClass("active");

                var thisSpan = $("#term3 span[rid='" + $(this).attr("id") + "']");
                var spanText = thisSpan.text();
                var pid = thisSpan.attr("pid");

                thisSpan.remove();

                var pChild = $("#term3 span[pid='" + pid + "']");
                if (pChild.length == 0) {

                    $(this).parent().parent().find("span").removeClass("active");
                } else if (spanText.indexOf("-") != -1) {

                    $(pChild[0]).text($("#" + pid).find("span").text() + "-" + $(pChild[0]).text());
                }

                if ($('.term3 span').length == 0) {

                    $('.term3').hide();
                    $('#dtrade .active').removeClass('active');
                    $('#anyIndustry').addClass('active');
                }

                checkLimit();
            } else {

                if ($("#term3 span").length == 5) {


                    $.Message({

                        text: '最多同时选择5个行业',
                        type: 'failure'
                    })
                    return;
                }

                //如果父级已选择则不做操作
                var pid = $(this).parent().parent().attr("id");

                if ($('#term3 span[rid="' + pid + '"]').length > 0) {

                    $('#term3 span[rid="' + pid + '"]').remove();
                }


                $(".termBox").show();
                $(this).addClass("active");
                $(this).parent().parent().find("span").addClass('active');
                $('#anyIndustry').removeClass('active');

                // add by yujunwei 2015-11-12 15:00
                // 用户行为-点击搜索条件
                topClick(7, 3, $(this).text());

                var p = $(this).parent().parent().find("span").text();
                var parentTerm = $("#term3 span:contains('" + p + "')");
                var city = $(this).text();

                if (parentTerm.length == 0) {

                    var province = p + '-' + $(this).text();
                    if ($('#term3 span[rid="' + $(this).attr('id') + '"]').length == 0) {

                        $('<span><span>').text(province).appendTo('#term3').attr('rid', $(this).attr('id')).attr("pid", pid);
                    }
                } else {

                    var province = $(this).text();
                    if ($('#term3 span[rid="' + $(this).attr('id') + '"]').length == 0) {

                        var span = $('<span><span>').text(province).attr('rid', $(this).attr('id')).attr("pid", pid);
                        parentTerm.after(span);
                    }
                }
                $('.term3').show();
            }
        })

        $('#term3').on("click", "span", function() {

            var id = $(this).attr("rid");
            var source = $("#" + id);

            $(this).remove();

            if (source.is("li")) {

                source.find("span").removeClass('active');
            } else {

                source.removeClass("active");

                var pid = $(this).attr("pid");
                var text = $(this).text();
                var pChild = $("#term3 span[pid='" + pid + "']");

                if (pChild.length == 0) {

                    $("#" + pid).find("span").removeClass("active");
                } else if (text.indexOf("-") != -1) {

                    $(pChild[0]).text($("#" + pid).find("span").text() + "-" + $(pChild[0]).text());

                }
            }
            if ($('.term3 span').length == 0) {

                $('.term3').hide();
                $('#dtrade .active').removeClass('active');
                $('#anyIndustry').addClass('active');
            } else {

                $('.term3').show();
            }
            ajaxSearch();
            searchJump(".hr", 0);
        })

        //点击一级行业
        $('#tradeBox').on("click", "li span", function() {

            // add by yujunwei 2015-11-12 15:00
            // 用户行为-点击搜索条件
            topClick(7, 3, $(this).text());
            if ($(this).hasClass("active")) {

                $(this).removeClass('active');
                $('#term3 span[rid="' + $(this).parent().attr('id') + '"]').remove();
                $('#term3 span[pid="' + $(this).parent().attr('id') + '"]').remove();
                $(this).parent().find("a.active").remove();

                if ($('.term3 span').length == 0) {

                    $('.term3').hide();
                    $('#anyIndustry').addClass('active');
                }

                checkLimit();
            } else {

                if ($("#term3 span").length == 5) {

                    $.Message({

                        text: '最多同时选择5个行业',
                        type: 'failure'
                    })

                    return;
                }

                $(".termBox").show();

                if ($('#term3 span[rid="' + $(this).parent().attr('id') + '"]').length == 0) {

                    $("#term3 span[pid='" + $(this).parent().attr('id') + "']").remove();
                    $('<span><span>').text($(this).text()).appendTo('#term3').attr('rid', $(this).parent().attr('id'));
                }

                $(this).addClass('active');
                $('#anyIndustry').removeClass('active');
                $('.term3').show();
            }

        })

        //	添加时间搜索条件
        $('#opTime li').click(function() {

            var compare = $(this).text();
            var circle = $(this).attr('circle');
            if ($(this).hasClass("active")) {

                $(this).removeClass("active");
                $("#Checktime span:contains('" + compare + "')").remove();
                if ($('.Checktime span').length == 0) {

                    $('.Checktime').hide();
                    $('#anyTime').addClass('active');
                }

                checkLimit();
            } else {

                $(".termBox").show();

                //当条件没有选的时候默认是不限
                $('#anyTime').removeClass('active');
                $('#opTime li').removeClass('active');
                $(this).addClass('active');
                $('#Checktime span').remove();
                if ($("#Checktime span:contains('" + compare + "')").length == 0) {

                    $('<span></span>').text(compare).appendTo('#Checktime').attr('circle', circle);
                }

                $('.Checktime').show();
            }

        })

        $('#Checktime').on("click", "span", function() {

            var text = $(this).text();
            $('#opTime li:contains("' + text + '")').removeClass("active");
            $(this).remove();
            ajaxSearch();
            searchJump(".hr", 0);

            if ($('.Checktime span').length == 0) {

                $('.Checktime').hide();
                $('#anyTime').addClass('active');
            } else {

                $('.Checktime').show();
            }
        })

        //	添加内容搜索条件
        $('#opType li').click(function() {

            // add by yujunwei 2015-11-12 15:00
            // 用户行为-点击搜索条件
            topClick(7, 1, $(this).text());

            var compare = $(this).text();
            if ($(this).hasClass("active")) {

                $(this).removeClass("active");
                $("#term1 span:contains('" + compare + "')").remove();
                if ($('.term1 span').length == 0) {

                    $('.term1').hide();
                    $('#anyType').addClass('active');
                }

                checkLimit();
            } else {

                $(".termBox").show();

                //当条件没有选的时候默认是不限
                $('#anyType').removeClass('active');
                $(this).addClass('active');
                if ($("#term1 span:contains('" + compare + "')").length == 0) {

                    $('<span></span>').text(compare).appendTo('#term1');
                }

                $('.term1').show();
            }

            // 当三个内容类别都被选中时，则为不限
            if ($('#opType').find('.active').length == 3) {

                $('#anyType').addClass('active');
                $('#opType li').removeClass('active');
                $('.term1').find('span').remove();
                $('.term1').hide();

                if ($('#term').find('span').length == 0) {

                    $('.termBox').hide();
                }
            }
        })

        $('#term1').on("click", "span", function() {

            var text = $(this).text();
            $('#opType li:contains("' + text + '")').removeClass("active");
            $(this).remove();
            ajaxSearch();
            searchJump(".hr", 0);

            if ($('.term1 span').length == 0) {

                $('.term1').hide();
                $('#anyType').addClass('active');
            } else {

                $('.term1').show();
            }
        })

        $('#term').on("click", "span", function() {

            if ($('#term span').length == 0) {

                $('.termBox').hide();
            } else {

                $('.termBox').show();
            }
        })

        //发送搜索条件
        $('.searchTerms').on("click", "li", function() {

            ajaxSearch();
            searchJump(".hr", 0);
        });


        //点击搜索按钮发送AJAX
        $('.searchBtn').click(function() {
            ajaxSearch();
            searchJump(".chartCon", 0);
        })

        // 按回车键搜索
        document.onkeydown = function(e) {

            var ev = document.all ? window.event : e;
            if (ev.keyCode == 13) {

                ajaxSearch();
                searchJump(".chartCon", 0);
            }
        }
    }

    // 用户行为
    function userBehavior() {

        // 关注按钮
        $('#list').on("click", ".ap", function() {

            var actiontype = $(this).attr("actiontype");
            var infotype = $(this).attr("infotype");
            var infoid = $(this).attr("infoid");

            if ($(this).find('.re').css('display') == 'none') {

                var status = custBehavior(actiontype, infotype, infoid, 1);

                // 已登录
                if (status == 0) {

                    $(this).find('i').addClass('active1');
                    $(this).find('a').hide();
                    $(this).find('.re').show();

                    // 未登录
                } else if (status == -1) {

                    $('.login_box').show();
                    $('.shadow_all').show();
                } else if (status == -2) {

                    $.Message({

                        text: '请求异常！',
                        type: 'failure'
                    })
                }
            } else {

                var status = custBehavior(actiontype, infotype, infoid, 0);

                // 已登录
                if (status == 0) {

                    $(this).find('i').removeClass('active1');
                    $(this).find('a').show();
                    $(this).find('.re').hide();

                    // 未登录
                } else if (status == -1) {

                    $('.login_box').show();
                    $('.shadow_all').show();
                } else if (status == -2) {

                    $.Message({

                        text: '请求异常！',
                        type: 'failure'
                    })
                }
            }
        });

        // 收藏按钮
        $('#list').on("click", ".cp", function() {

            var actiontype = $(this).attr("actiontype");
            var infotype = $(this).attr("infotype");
            var infoid = $(this).attr("infoid");

            if ($(this).find('.re').css('display') == 'none') {

                var status = custBehavior(actiontype, infotype, infoid, 1);

                // 已登录
                if (status == 0) {

                    $(this).find('i').addClass('active2');
                    $(this).find('a').hide();
                    $(this).find('.re').show();

                    // 未登录
                } else if (status == -1) {

                    $('.login_box').show();
                    $('.shadow_all').show();
                } else if (status == -2) {

                    $.Message({

                        text: '请求异常！',
                        type: 'failure'
                    })
                }
            } else {

                var status = custBehavior(actiontype, infotype, infoid, 0);

                // 已登录
                if (status == 0) {

                    $(this).find('i').removeClass('active2');
                    $(this).find('a').show();
                    $(this).find('.re').hide();

                    // 未登录
                } else if (status == -1) {

                    $('.login_box').show();
                    $('.shadow_all').show();
                } else if (status == -2) {

                    $.Message({

                        text: '请求异常！',
                        type: 'failure'
                    })
                }
            }
        });

        // 分享按钮
        $('#list').on("mouseover", ".sp", function() {

            $(this).find('em').show();
            $(this).find('div').show();
            $(this).find('.share').addClass('reShare');
        }).on("mouseout", ".sp", function() {

            $(this).find('em').hide();
            $(this).find('div').hide();
            $(this).find('.share').removeClass('reShare');
        });
    }

    // 招中标关系网不能跳转链接
    function removeLink() {

        $('.bid').each(function() {

            var type = $(this).text();
            if (type === "招标" || type === "中标" || type === "采购") {

                /*window.location.href = path +"/construction"*/
                /*$(this).parent().parent().parent().find('.rpage').addClass('rno');
                $(this).parent().parent().parent().find('.rpage').removeAttr('href');*/

                $(this).parent().parent().parent().find('.rpage').attr("href", path + "/construction")
            }
        })
    }

    // 搜索锚点
    function searchJump(oClass, distance) {

        var oTop = $(oClass).offset().top;
        if ($(document).scrollTop() != oTop) {
            $("html, body").scrollTop(0).animate({

                scrollTop: oTop + distance
            });
        }
    }

    // url传递默认条件
    function urlOption() {

        var urlParameter = Tool.getUrlArgs(document.getElementById('getUrlArgs'));

        if (urlParameter['industryId']) {

            $('.termBox').show();
            $('.term3').show();
            $('#anyIndustry').removeClass('active');
            var pid = urlParameter['industryId'];

            if (pid == 2113 || pid == 2114 || pid == 2115) {

                $('.liHidden').show();
                $('#more').addClass('active');
            }

            var theSpan = $("'.trade li[id='" + pid + "']'").find('span');
            theSpan.addClass('active');
            $('<span></span>').attr('rid', pid).appendTo('#term3').text(theSpan.text());
        }
    }

    // 点击页码返回结果列表顶部
    function pageClick() {

        $('.tcdPageCode,.searchPage').on("click", "a", function() {

            $("html, body").scrollTop(0).animate({
                scrollTop: $(".result").offset().top - 30
            }, 0);
        })
    }

    $(function() {

        ajaxSearch();

        // 不限判断
        unlimit();

        secondLevel();

        // 添加搜索条件
        addOption();

        // 用户行为
        userBehavior();

        // 关闭登录框
        Close.closeLoginBox();

        //	搜索框交互
        searchHint();

        // 获取图表数据
        // getData();

        // url传递默认条件
        urlOption();

        pageClick();

        $(window).scroll(function() {
            toTop()
        })

        $('#gotop').click(function() {

            $('body,html').animate({
                scrollTop: 0
            }, 300);
        }).mouseover(function() {

            $('#gotop i').hide();
            $('#gotop span').show();
        }).mouseout(function() {

            $('#gotop i').show();
            $('#gotop span').hide();
        })

    })

    module.exports = 'searchResult';
})
