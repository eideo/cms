/* 
 * @Author: Administrator
 * @Date:   2015-11-09 17:30:30
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-07 09:45:59
 */

'use strict';

// 定义一个图表类，后期封装框架
define(function(require, exports, module) {
    var Chart = {}

    Chart.pieEmpty = function(setting) {

        // 清空图表
        d3.select(setting.selector).select('svg').remove()

        var selector = setting.selector,
            width = setting.width,
            height = setting.height,
            margin = setting.margin,
            outerRadius = setting.outerRadius,
            innerRadius = setting.innerRadius,
            dataset = setting.dataset,
            colorset = setting.colorset,
            arcIndex = 0
            // 弧度
        var arc = d3.svg.arc()
            .outerRadius(outerRadius)
            .innerRadius(innerRadius);

        var pie = d3.layout.pie()
            .value(function(d) {
                return d.value
            })
            .sort(null)

        var svg = d3.select(selector).append('svg')
            .attr('width', width)
            .attr('height', height)

        var content = svg.append('g')
            .attr('transform', 'translate(' + width / 2 + ',' + height / 2 + ')')
            .attr('class', 'content')

        var rect = content.selectAll('g.arc')
            .data(pie(dataset))
            .enter()
            .append('g')
            .attr('class', function(d, i) {

                return 'arc' + i
            })

        var paths = rect.append('path')
            .attr({
                'fill': function(d, i) {

                    var index = $(this).parent().index()

                    var vectx, vecty

                        vectx = 10 * Math.cos((d.startAngle + d.endAngle) / 2 - Math.PI / 2)
                        vecty = 10 * Math.sin((d.startAngle + d.endAngle) / 2 - Math.PI / 2)

                        if (index === 0 || index === 1) {

                            d.enabled = false
                            d3.select(this)
                                .attr("transform", "translate(" + vectx + "," + vecty + ")")
                        } else {

                            d.enabled = true;
                        }

                        //console.log(d)
                    return colorset[i];
                },
                'cursor': 'pointer',
                'd': arc,
            })

        .on("click", function(e, i) {

            var vectx, vecty

                vectx = 10 * Math.cos((e.startAngle + e.endAngle) / 2 - Math.PI / 2)
                vecty = 10 * Math.sin((e.startAngle + e.endAngle) / 2 - Math.PI / 2)
                //e.enabled = !e.enabled;

                d3.select(this)
                    .attr("transform", "translate(" + vectx + "," + vecty + ")")

                /*           if (!e.enabled) {

                       d3.select(this)
                           .attr("transform", "translate(" + vectx + "," + vecty + ")")
                   } else {
                       d3.select(this)
                           .attr("transform", "translate(" + "0" + "," + "0" + ")")
                   }*/

            var index = $(this).parent().index()

            var closeIndex = index - 2

            if (closeIndex < 0) {

                closeIndex = dataset.length + closeIndex
            }

            console.log(closeIndex, index)
            d3.select('.arc' + closeIndex).select('path')
                .attr("transform", "translate(" + "0" + "," + "0" + ")")
        })

        .transition()
            .duration(1500)
            .attrTween('d', function(d) {
                return tweenPie(d, arc)
            }) //transition.attrTween在不同attr属性值之间平滑过渡
        .transition()
            .ease('elastic')

        // 设置默认前2个突出
        $('#chart1 .arc').eq(0).find('path').trigger('click')

            function tweenPie(b, callback) {

                b.innerRadius = 0;

                var i = d3.interpolate({
                    startAngle: Math.PI * 2,
                    endAngle: Math.PI * 2
                }, b);

                return function(t) {
                    return callback && callback(i(t));
                };

            }
    }

    Chart.brokeArea = function(setting) {

        // 清空图表
        d3.select(setting.selector).select('svg').remove()

        var selector = setting.selector,
            series = setting.series,
            colorset = setting.colorset,
            margin = setting.margin,
            legend = setting.legend,
            width = setting.width,
            height = setting.height,
            length = series.length,
            contentW = width - margin.left - margin.right,
            contentH = height - margin.top - margin.bottom

        var svg,
            content,
            totalGroup,
            xScale,
            yScale,
            xAxis,
            yAxis,
            xArray = [],
            yArray = []

        var seriesArray = series[0].concat(series[1])

        for (var i = 0; i < seriesArray.length; i++) {

            //xArray.push(series[i].time)
            yArray.push(seriesArray[i].value)
        }

        for (var i = 0; i < series[0].length; i++) {

            var temp = series[0][i].time
            var newTime = parseInt(temp.substr(4, 2))
            xArray.push(newTime)
        }

        var max = d3.max(seriesArray, function(d, i) {

            return Math.ceil(d['value'] / 1000) * 1000
        })

        var date = new Date()
        date = date.getTime()

        xScale = d3.scale.ordinal()
            .domain(xArray)
            .rangePoints([0, contentW])

        var rangeBand = xScale.rangeBand()
        yScale = d3.scale.linear()
            .domain([0, max])
            .range([contentH, 0])

        svg = d3.select(selector).append('svg')
            .attr('width', width)
            .attr('height', height)

        content = svg.append('g')
            .attr('class', 'content')
            .attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

        xAxis = d3.svg.axis()
            .scale(xScale)
            .tickValues(xArray)
            .orient('bottom')

        yAxis = d3.svg.axis()
            .scale(yScale)
            .orient('left')
            .tickSize(0)

        content.append('g')
            .attr('class', 'axis xAxis')
            .attr('transform', 'translate(' + 0 + ',' + (contentH) + ')')
            .call(xAxis)

        content.append('g')
            .attr('class', 'axis yAxis')
            .attr('transform', 'translate(' + 0 + ',' + 0 + ')')
            .call(yAxis)



        svg.selectAll('.xAxis .tick')
            .attr('opacity', function(d, i) {
                d3.select(this).append('line')
                    .attr('x1', 0)
                    .attr('y1', 0)
                    .attr('x2', 0)
                    .attr('y2', -(contentH))
                    .attr('class', 'xLine' + i)
            })

        svg.selectAll('.yAxis .tick')
            .attr('opacity', function(d, i) {
                d3.select(this).append('line')
                    .attr('x1', 0)
                    .attr('y1', 0)
                    .attr('x2', (contentW))
                    .attr('y2', 0)
            })

        var area = d3.svg.area()
            .x(function(d, i) {
                return xScale(xArray[i])
            })
            .y0(height - margin.top - margin.bottom)
            .y1(function(d, i) {
                return yScale(d['value']);
            })
            .interpolate("cardinal");

        svg.append("clipPath")
            .attr("id", "content-brokeArea" + date)
            .append("rect")
            .attr("x", -10)
            .attr("y", -10)
            .attr("height", height)
            .attr("width", 10)
            .transition()
            .duration(2000)
            .attr("width", width);


        var content = svg.append("g")
            .attr("class", "lineArea")
            .attr("clip-path", "url(#content-brokeArea" + date + ")")
            .attr("transform", "translate(" + margin.left + "," + margin.top + ")")


        for (var j = 0; j < series.length; j++) {

            var pct = svg.select(".lineArea")
                .append("g")
                .attr("class", "pct")

            pct.append("path")
                .datum(series[j])
                .attr("stroke", function(d, i) {

                    return colorset[j];
                })
                .attr("d", area)
                .style("fill", function(d, i) {

                    return colorset[j];
                })
                .style("opacity", "0.3")

            pct.selectAll("circle")
                .data(series[j])
                .enter()
                .append("circle")
                .attr("class", function(d, i) {

                    return 'lineCircle' + i
                })
                .attr("cx", function(d, i) {
                    return xScale(xArray[i])
                })
                .attr("cy", function(d, i) {
                    return yScale(d['value']);
                })
                .attr("r", function(d) {
                    return 5; //圆点的半径统一定成3
                })
                .attr("fill", function(d, i) {
                    return colorset[j];
                })
                .attr('opacity', 1)
                .attr("data-id", j)
                .on("mouseover", function(d, i) {

                    var index = $(this).index()

                    var left = xScale(xArray[i])

                    $('.lineCircle' + index).show()

                    $('#chart2 .toolTip')
                        .css('display', 'block')
                        .css('left', left + 70)
                        .css('top', height / 2)

                    var firstInfo = legend[0] + ' ' + series[0][index - 1].value
                    var secondInfo = legend[1] + ' ' + series[1][index - 1].value

                    $('#chart2 .toolTip').find('li').eq(0).html(firstInfo)
                    $('#chart2 .toolTip').find('li').eq(1).html(secondInfo)

                    d3.select('.xLine' + (index - 1)).style('stroke', '#9c9c9c')

                })
                .on("mouseout", function() {

                    var index = $(this).index()

                    d3.select('.xLine' + (index - 1)).style('stroke', '#e1e1e1')

                    $('#chart2 .toolTip').hide()
                })

        }
    }


    Chart.muiltBar = function(setting) {

        // 清空图表
        d3.select(setting.selector).select('svg').remove()


        var selector = setting.selector,
            series = setting.series,
            colorset = setting.colorset,
            margin = setting.margin,
            width = setting.width,
            height = setting.height,
            length = series.length,
            legend = setting.legend,
            rectWidth = setting.rectWidth,
            contentW = width - margin.left - margin.right,
            contentH = height - margin.top - margin.bottom

        var svg,
            content,
            totalGroup,
            xScale,
            yScale,
            hScale,
            incomeGroup,
            circle,
            xAxis,
            yAxis,
            xArray = [],
            yArray = []

        var seriesArray = series[0].concat(series[1])

        for (var i = 0; i < seriesArray.length; i++) {

            yArray.push(seriesArray[i].value)
        }

        for (var i = 0; i < series[0].length; i++) {

            var temp = series[0][i].time
            var newTime = parseInt(temp.substr(4, 2))
            xArray.push(newTime)
        }

        var max = d3.max(seriesArray, function(d, i) {

            return Math.ceil(d['value'] / 1000) * 1000
        })

        xScale = d3.scale.ordinal()
            .domain(xArray)
            .rangeRoundBands([10, contentW])

        yScale = d3.scale.linear()
            .domain([0, max])
            .range([contentH, 0])

        hScale = d3.scale.linear()
            .domain([0, max])
            .range([0, contentH])

        var rangeBand = xScale.rangeBand()

        svg = d3.select(selector).append('svg')
            .attr('width', width)
            .attr('height', height)

        content = svg.append('g')
            .attr('class', 'content')
            .attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

        xAxis = d3.svg.axis()
            .scale(xScale)
            .tickValues(xArray)
            .orient('bottom')

        yAxis = d3.svg.axis()
            .scale(yScale)
            .orient('left')
            .tickSize(0)

        content.append('g')
            .attr('class', 'axis xAxis')
            .attr('transform', 'translate(' + 0 + ',' + (contentH) + ')')
            .call(xAxis)

        content.append('g')
            .attr('class', 'axis yAxis')
            .attr('transform', 'translate(' + 0 + ',' + 0 + ')')
            .call(yAxis)


        svg.selectAll('.xAxis .tick')
            .attr('opacity', function(d, i) {
                d3.select(this).append('line')
                    .attr('x1', 0)
                    .attr('y1', 0)
                    .attr('x2', 0)
                    .attr('y2', -(contentH))
            })

        //svg.select('.yAxis').select('path').remove()
        svg.selectAll('.yAxis .tick')
            .attr('opacity', function(d, i) {
                d3.select(this).append('line')
                    .attr('x1', 0)
                    .attr('y1', 0)
                    .attr('x2', (width - margin.left - margin.right))
                    .attr('y2', 0)
            })

        var rectFirst = svg.append('g')
            .attr('class', 'rectFirst')

        var rectSecond = svg.append('g')
            .attr('class', 'rectSecond')

        rectFirst.selectAll('rect')
            .data(series[0])
            .enter()
            .append('rect')
            .on('mouseover', function(d, i) {

                var index = $(this).index()

                var left = xScale(xArray[i])

                $('.lineCircle' + index).show()

                $('#chart3 .toolTip')
                    .css('display', 'block')
                    .css('left', left + 70)
                    .css('top', height / 2)

                var firstInfo = legend[0] + ' ' + series[0][index - 1].value
                var secondInfo = legend[1] + ' ' + series[1][index - 1].value

                $('#chart3 .toolTip').find('li').eq(0).html(firstInfo)
                $('#chart3 .toolTip').find('li').eq(0).html(secondInfo)
            })
            .on('mouseout', function(d, i) {
                var index = $(this).index()

                d3.select('.xLine' + (index - 1)).style('stroke', '#e1e1e1')

                $('#chart2 .toolTip').hide()
            })
            .attr('fill', function(d, i) {
                return colorset[0]
            })
            .attr('x', function(d, i) {
                return xScale(xArray[i])
            })
            .attr('y', function(d) {

                return height - hScale(0);
            })
            .attr('width', rectWidth)
            .attr("transform", "translate(" + margin.left + "," + (-margin.bottom) + ")")
            .attr('height', function(d, i) {

                return hScale(0);
            })
            .transition()
            .duration(1500)
            .attr("y", function(d, i) {

                return height - hScale(d['value']);
            })
            .attr('height', function(d, i) {
                return hScale(d['value'])
            })


        rectSecond.selectAll('rect')
            .data(series[1])
            .enter()
            .append('rect')
            .on('mouseover', function(d, i) {

                var index = $(this).index()

                var left = xScale(xArray[i])

                $('.lineCircle' + index).show()

                $('#chart3 .toolTip')
                    .css('display', 'block')
                    .css('left', left + 70)
                    .css('top', height / 2)

                var firstInfo = legend[0] + ' ' + series[0][index - 1].value
                var secondInfo = legend[1] + ' ' + series[1][index - 1].value

                $('#chart3 .toolTip').find('li').eq(0).html(firstInfo)
                $('#chart3 .toolTip').find('li').eq(0).html(secondInfo)
            })
            .on('mouseout', function(d, i) {
                var index = $(this).index()

                d3.select('.xLine' + (index - 1)).style('stroke', '#e1e1e1')

                $('#chart3 .toolTip').hide()
            })
            .attr('fill', function(d, i) {
                return colorset[1]
            })
            .attr('x', function(d, i) {

                return xScale(xArray[i]) + 10
            })
            .attr('y', function(d) {

                return height - hScale(0);
            })
            .attr('width', rectWidth)
            .attr("transform", "translate(" + margin.left + "," + (-margin.bottom) + ")")
            .attr('height', function(d, i) {

                return hScale(0);
            })
            .transition()
            .duration(1500)
            .attr("y", function(d, i) {

                return height - hScale(d['value']);
            })
            .attr('height', function(d, i) {
                return hScale(d['value'])
            })
    }

    Chart.addChinaMap = function(setting, callback) {

        var selector = setting.selector,
            width = document.querySelector(selector).getBoundingClientRect().width,
            height = document.querySelector(selector).getBoundingClientRect().height,
            margin = setting.margin,
            colorset = setting.colorset,
            dataset = setting.dataset,
            color

        var svg = d3.select(selector)
            .append('svg')
            .attr('width', width)
            .attr('height', height)

        var projection = d3.geo.mercator()
            .center([107, 38])
            .scale(width * 0.9)
            .translate([width / 2 + 20, height / 2 - 20])

        var mPath = d3.geo.path().projection(projection)

        var backProjection = d3.geo.mercator()
            .center([107, 38])
            .scale(width * 0.9)
            .translate([width / 2 + 20, height / 2 - 20])

        var mbackPath = d3.geo.path().projection(projection)


        var content = svg.append("g")
            .attr("class", "content")
            .attr("transform", "translate(" + margin.left + ", " + 20 + ")")


        d3.json(path + '/resources/json/china.json', function(data) {

            var json = data

            content.selectAll(".path1")
                .data(json.features)
                .enter()
                .append("path")
                .attr("d", mPath)
                .attr("fill", function(d, i) {
                    return '#5da9ff';
                })
                .attr("stroke-width", "1px")
                .attr("stroke-linejoin", "round")
                .attr("stroke", '#3e99ff')

            var southChina = svg.append('image')
                .attr('class', 'southChinaSea')
                .attr('width', 80)
                .attr('height', 80)
                .attr("transform", "translate(" + (width * 0.8 - margin.left) + ", " + (height * 0.8 - margin.bottom) + ")")
                .attr('xlink:href', path + '/resources/commons/images/southSea1.png')

            if (callback) {

                callback && callback()
            }
        })
    }

    Chart.addCircle = function(parent, width, height, dataset) {

        var content = parent
        //绘制地图上的点

        var projection = d3.geo.mercator()
            .center([107, 38])
            .scale(width * 0.9)
            .translate([width / 2 + 20, height / 2 - 20])

        var placesJW = [
            ['北京', 116.395645, 39.929986],
            ['上海', 121.487899, 31.249162],
            ['天津', 117.210813, 39.14393],
            ['重庆', 106.530635, 29.544606],
            ['香港', 114.186124, 22.293586],
            ['澳门', 113.557519, 22.204118],
            ['台湾', 120.961454, 23.80406],
            ['安徽', 117.282699, 31.866942],
            ['福建', 119.330221, 26.047125],
            ['甘肃', 103.823305, 36.064226],
            ['广东', 113.30765, 23.120049],
            ['广西', 108.297234, 22.806493],
            ['贵州', 106.709177, 26.629907],
            ['海南', 110.330802, 20.022071],
            ['河北', 114.522082, 38.048958],
            ['河南', 113.649644, 34.75661],
            ['黑龙江', 126.657717, 45.773225],
            ['湖北', 114.3162, 30.581084],
            ['湖南', 112.979353, 28.213478],
            ['江苏', 118.778074, 32.057236],
            ['江西', 115.893528, 28.689578],
            ['吉林', 125.313642, 43.898338],
            ['辽宁', 123.432791, 41.808645],
            ['内蒙古', 111.660351, 40.828319],
            ['宁夏', 106.206479, 38.502621],
            ['青海', 101.767921, 36.640739],
            ['山东', 117.024967, 36.682785],
            ['山西', 112.550864, 37.890277],
            ['陕西', 108.953098, 34.2778],
            ['四川', 104.067923, 30.679943],
            ['西藏', 91.111891, 29.662557],
            ['新疆', 87.564988, 43.84038],
            ['云南', 102.714601, 25.049153],
            ['浙江', 120.219375, 30.259244]
        ];
        var places = {};
        //连线的数据
        var routes = []

        var areaName = dataset[0],
            hotword = dataset[1]

            placesJW.forEach(function(d) {

                if (areaName === d[0]) {

                    places[areaName] = [d[1], d[2]];
                }
            })

            var point = content.selectAll("circle")
            .data(d3.entries(places))
            .enter()
            .append("circle")
            .attr("transform", function(d) {
                return "translate(" + projection(d.value) + ")";
            })
            .attr("r", function(d, i) {

                d3.select(this)
                    .attr("opacity", 1)
                return 0.01
            })
            .attr("fill", '#ff9829')
            .attr('stroke', '#6dd1fb')
            .attr('stroke-width', 2)
            .attr("class", function(d, i) {

                var keyArray = d.key.split(",")
                var text = keyArray[1]

                var obj = d3.select(this)[0][0]

                var info = {
                    text: text,
                    left: projection(d.value)[0],
                    top: projection(d.value)[1]
                }
                $(obj).data('info', info)

                return 'point'
            })
            .transition()
            .duration(600)
            .attr("r", 4)
            .remove()

        var points = d3.select('#map').selectAll('circle')[0]
        var tipDomArray = $('.tip')
        var tipArrayLength = tipDomArray.length

        var info = $(points[0]).data('info')
        d3.select(points[0]).attr('opacity', 1)

        for (var i = 0; i < tipArrayLength; i++) {

            var area = $('.tip').eq(i).attr('area')

            if (area === areaName) {

                $('.tip').eq(i).remove()
                $('.tip[area='+areaName+']').remove()
            }

            if (tipArrayLength === 30) {

                $('.tip').remove()
            }
        }

        var tipDom = $('<div></div>').html(hotword)
            .addClass('tip' + " " + areaName)
            .attr('area', areaName)
            .css('position', 'absolute')
            .css('left', info.left - 12)
            .css('top', info.top - 12)
            .appendTo($('#map'))
    }
    module.exports = Chart;
})