/* 
 * @Author: Administrator
 * @Date:   2015-11-25 14:05:51
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-07 17:31:36
 */

'use strict';
define(function(require, exports, module) {

	var SearchChart = {}

	SearchChart.brokeArea = function(setting) {

		// 清空图表
		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			opacity = setting.opacity,
			legendOpacity = opacity.reverse(),
			legend = setting.legend,
			type = setting.type,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
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
			//var newTime = parseInt(temp.substr(4, 2))
			xArray.push(temp)
		}

		var max = d3.max(seriesArray, function(d, i) {

			return Math.ceil(d['value']) * 1.1
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

		var title = svg.append('text')
			.attr('transform', 'translate(' + 5 + ',' + 25 + ')')
			.text('行业内容比例图')
			.style('font-size', 12)
			.style('font-weight', 'normal')
			.style('fill', '#000')

		var gLegend = svg.append('g')
			.attr('transform', 'translate(' + (width * 0.6) + ',' + 25 + ')')

		var type = gLegend.selectAll('.legend')
			.data(type)
			.enter()
			.append('g')

		type.append('rect')
			.attr('x', function(d, i) {
				return i * 45
			})
			.attr('y', 0)
			.attr('width', 14)
			.attr('height', 10)
			.attr('fill', function(d, i) {
				return colorset[i]
			})
			.attr('opacity', function(d, i) {
				return legendOpacity[i]
			})

		type.append('text')
			.attr('dx', '1.5em')
			.attr('dy', '0.75em')
			.attr('x', function(d, i) {
				return i * 45
			})
			.attr('y', 0)
			.text(function(d, i) {
				return d
			})


		xAxis = d3.svg.axis()
			.scale(xScale)
			.tickValues(xArray)
			.orient('bottom')
			.tickSize(0)
			.tickPadding(10)

		yAxis = d3.svg.axis()
			.scale(yScale)
			.orient('left')
			.tickSize(0)
			.tickPadding(15)
			.tickFormat(function(d) {
				return d
			})

		content.append('g')
			.attr('class', 'axis yAxis')
			.attr('transform', 'translate(' + 0 + ',' + 0 + ')')
			.call(yAxis)

		content.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + 0 + ',' + (height - margin.top - margin.bottom) + ')')
			.call(xAxis)


		svg.selectAll('.yAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).append('line')
					.attr('x1', 0)
					.attr('y1', 0)
					.attr('x2', (contentW))
					.attr('y2', 0)
			})

		// 修改X轴上的文本
		svg.selectAll('.xAxis .tick').selectAll('text')
			.text(function(d) {

				$(this).data('time', d)

				var seriesLength = series.length

				var dd = d.toString().substr(5, 2),
					yearStart = d.toString().substr(0, 4)


					if (parseInt(dd) % 2 == 0) {

						return dd
					} else {

						return dd
					}
			})

		var area = d3.svg.area()
			.x(function(d, i) {
				return xScale(xArray[i])
			})
			.y0(height - margin.top - margin.bottom)
			.y1(function(d, i) {

				return yScale(d['value']);
			})
			.interpolate("basic")

		svg.append("clipPath")
			.attr("id", "content-brokeArea" + date)
			.append("rect")
			.attr("x", 0)
			.attr("y", 0)
			.attr("height", height)
			.attr("width", 10)
			.transition()
			.duration(1500)
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
				.style("opacity", function(d, i) {
				
					return opacity[j]
				})
		}
	}

	SearchChart.pieCircle = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			series = setting.series,
			margin = setting.margin,
			colorset = setting.colorset

		var max = d3.max(series, function(d, i) {
			return d.value
		})

		var total = 0

		for (var i = 0; i < series.length; i++) {
			total += series[i].value
		}

		var arc = d3.svg.arc()
			.outerRadius(function(d) {

				var value = parseFloat(d.data.value)
				return (width / 6) //* (value / max) + width / 12 - 15
			})
			.innerRadius(30);

		var pie = d3.layout.pie()
			.value(function(d) {
				return d.value
			})
			.sort(null)

		var svg = d3.select(selector).append('svg')
			.attr('width', width)
			.attr('height', height)

		var content = svg.append('g')
			.attr('transform', 'translate(' + (width * 0.4) + ',' + (height / 2 + 20) + ')')
			.attr('class', 'content')

		var rect = content.selectAll('g.arc')
			.data(pie(series))
			.enter()
			.append('g')
			.attr('class', function(d, i) {

				return 'arc' + i
			})

		var paths = rect.append('path')
			.attr({
				'fill': function(d, i) {

					return colorset[i];
				},
				'cursor': 'pointer',
				'd': arc,
			})
			.on("click", function(e, i) {

			})
			.transition()
			.duration(1500)
			.attrTween('d', function(d) {
				return tweenPie(d, arc)
			})
			.transition()
			.ease('elastic')

		var title = svg.append('text')
			.attr('transform', 'translate(' + 45 + ',' + 25 + ')')
			.text('行业领域比例图')
			.style('font-size', 12)
			.style('font-weight', 'normal')
			.style('fill', '#000')

		var type = svg.selectAll('.legend')
			.data(pie(series))
			.enter()
			.append('g')

		type.append('rect')
			.attr('x', (width * 0.65))
			.attr('y', function(d, i) {

				return i * 23 + (0.4 * height) + 10
			})
			.attr('width', 11)
			.attr('height', 10)
			.attr('fill', function(d, i) {
				return colorset[i]
			})

		type.append('text')
			.attr('dy', '0.75em')
			.attr('x', (width * 0.65) + 16)
			.attr('y', function(d, i) {
				return i * 23 + (0.4 * height) + 10
			})
			.text(function(d, i) {

				var value = ((d.data.value / total).toFixed(2) * 100).toString()

				if (value.length > 3) {

					value = value.substr(0, 3)
				}

				var nameArray = d.data['name'].split('-'),
					len = nameArray.length,
					name
					len > 1 ? name = nameArray[1] : name = nameArray[0]

				return name + '   ' + value + '%'
			})

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

	SearchChart.tagCloud = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			series = setting.series,
			margin = setting.margin,
			colorset = setting.colorset

		var hWidth = 120,
			hHeight = 95

		var svg = d3.select(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		var content = svg.append('g')
			.attr('class', 'content')
			.attr('transform', 'translate(' + 0 + ',' + (height / 6) + ')')

		var title = svg.append('text')
			.attr('transform', 'translate(' + 30 + ',' + 20 + ')')
			.text('地区比例图')
			.style('font-size', 16)
			.style('font-weight', 'bold')
			.style('fill', '#000')

		var rect = content.selectAll('.rect')
			.data(series)
			.enter()
			.append('rect')
			.attr('class', 'rect')
			.attr('x', function(d, i) {

				if (i < 3) {

					return hWidth * i + 10

				} else {

					return hWidth * 3 + 10
				}
			})
			.attr('y', function(d, i) {

				if (i < 3) {

					return 10

				} else {

					return 10 + (hHeight / 3) * (i - 3)
				}
			})
			.attr('width', function(d, i) {

				if (i < 3) {

					return hWidth

				} else {

					return hWidth
				}
			})
			.attr('height', function(d, i) {

				if (i < 3) {

					return hHeight

				} else {

					return hHeight / 3
				}
			})
			.attr('fill', function(d, i) {
				return colorset[i]
			})

	}

	SearchChart.Cloud2 = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			dataset = setting.series,
			margin = setting.margin,
			colorset = setting.colorset,
			animate = 2000,
			total = 0

		for (var i = 0; i < dataset.length; i++) {

			total += dataset[i][1]
		}

		var treemap = d3.layout.treemap()
			.size([width - 10, height - 85])
			.sticky(true)
			.value(function(d) {
				return d.size;
			})

		var svg = d3.select(selector).append("svg")
			.attr("width", width)
			.attr("height", height)
			.attr("transfrom", "translate(" + margin.left + "," + margin.top + ")")

		var content = svg.append('g')
			.attr('class', 'content')
			.attr('transform', 'translate(' + 0 + ',' + (height / 6) + ')')

		var title = svg.append('text')
			.attr('transform', 'translate(' + 5 + ',' + 25 + ')')
			.text('地区比例图')
			.style('font-size', 12)
			.style('font-weight', 'bold')
			.style('fill', '#000')

		var root = {
			"name": " ",
			"children": []
		}

		dataset.forEach(function(d) {
			root.children.push({
				"name": d[0] == null ? '' : d[0],
				"text": d[0] == null ? '' : d[0],
				"num": d[1] == null ? 0 : d[1],
				"size": d[1] == null ? 0 : d[1],
				"url": d[2] == null ? '' : d[2]
			})
		})

		var fScale = d3.scale.linear()
			.domain([0, width])
			.range([0, width * 0.15])

		var node = content.datum(root).selectAll("g")
			.data(treemap.nodes)
			.enter().append("g")

		node.append("rect")
			.call(position)

		node.append("a")
			.attr("target", "_bank")
			.append("text")
			.attr("x", function(d) {

				return d.x;
			})
			.attr("y", function(d) {

				return d.y;
			})
			.attr("transform", function(d) {

				var rotate = Math.max(0, d.dx - 1) > Math.max(0, d.dy - 1) ? 0 : 90
				return "translate(" + (Math.max(0, d.dx - 1) * 0.5) + "," + (Math.max(0, d.dy - 1) * 0.5 + fScale(Math.max(0, d.dx - 1)) * 0.5) + ")rotate(" + rotate + "," + d.x + "," + d.y + ")";
			})
			.attr("text-anchor", "middle")
			.text(function(d) {

				var percent = Math.round((d.size / total) * 100)
				return d.name + percent + '%';
			})
			.attr("font-size", 12)
			.style('fill', '#fff')



			function position() {
				this.attr("x", function(d) {

					return d.x;
				})
					.attr("y", function(d) {

						return d.y;
					})
					.attr('width', 0)
					.attr('height', 0)
					.transition()
					.duration(2000)
					.attr("width", function(d) {

						return Math.max(0, d.dx - 1);
					})
					.attr("height", function(d) {

						return Math.max(0, d.dy - 1);
					})
					.attr("fill", function(d, i) {

						return colorset[i]
					})
			}

	}

	SearchChart.rect = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			series = setting.series,
			margin = setting.margin,
			colorset = setting.colorset,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			total = 0

		var svg,
			title,
			content,
			xScale,
			hScale,
			yScale,
			xAxis,
			yAxis,
			xArray = [],
			yArray = []

		for (var i = 0; i < series.length; i++) {

			xArray.push(series[i][0])
			yArray.push(series[i][1])
		}

		var max = d3.max(yArray, function(d, i) {

			return Math.ceil(d)
		})

		for (var i = 0; i < series.length; i++) {

			total += series[i][1]
		}

		svg = d3.selectAll(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		title = svg.append('text')
			.attr('transform', 'translate(' + 30 + ',' + 25 + ')')
			.text('地区比例图')
			.style('font-size', 12)
			.style('font-weight', 'normal')
			.style('fill', '#000')

		xScale = d3.scale.ordinal()
			.domain(xArray)
			.rangeBands([0, contentW], 0.5)

		yScale = d3.scale.linear()
			.domain([0, max])
			.range([contentH, 0])

		hScale = d3.scale.linear()
			.domain([0, max])
			.range([0, contentH])

		xAxis = d3.svg.axis()
			.scale(xScale)
			.tickValues(xArray)
			.orient('bottom')

		svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + margin.left + ',' + (height - margin.bottom) + ')')
			.call(xAxis)


		var rectCon = svg.append('g')
			.attr('class', 'rectCon')
			.attr('transform', 'translate(' + (margin.left) + ',' + (margin.top) + ')')

		rectCon.selectAll('rect')
			.data(series)
			.enter()
			.append('rect')
			.attr('fill', function(d, i) {
				return colorset[0]
			})
			.attr('x', function(d, i) {

				return xScale(xArray[i])
			})
			.attr('y', function(d) {

				return contentH - hScale(0);
			})
			.attr('width', xScale.rangeBand() * 0.8)
			.attr('height', 0)
			.transition()
			.duration(1500)
			.attr("y", function(d, i) {

				return contentH - hScale(d[1])
			})
			.attr('height', function(d, i) {

				return hScale(d[1])
			})
	}
	module.exports = SearchChart;
})

/*$(function() {

	var leftSetting = {
		selector: '.chartwrap .left',
		margin: {
			left: 50,
			top: 50,
			right: 30,
			bottom: 40
		},
		colorset: ['#ffce00', '#ff7133', '#5d5d5d'],
		series: [
			[{
				time: '201401',
				value: 1000
			}, {
				time: '201402',
				value: 1400
			}, {
				time: '201403',
				value: 1500
			}, {
				time: '201404',
				value: 1600
			}, {
				time: '201405',
				value: 2500
			}, {
				time: '201406',
				value: 3100
			}, {
				time: '201407',
				value: 4780
			}, {
				time: '201408',
				value: 4580
			}, {
				time: '201409',
				value: 7460
			}, {
				time: '201410',
				value: 4330
			}, {
				time: '201411',
				value: 4300
			}, {
				time: '201412',
				value: 2000
			}],
			[{
				time: '201401',
				value: 1100
			}, {
				time: '201402',
				value: 1400
			}, {
				time: '201403',
				value: 2000
			}, {
				time: '201404',
				value: 3000
			}, {
				time: '201405',
				value: 3500
			}, {
				time: '201406',
				value: 4500
			}, {
				time: '201407',
				value: 5400
			}, {
				time: '201408',
				value: 6300
			}, {
				time: '201409',
				value: 7200
			}, {
				time: '201410',
				value: 6000
			}, {
				time: '201411',
				value: 5900
			}, {
				time: '201412',
				value: 5800
			}],
			[{
				time: '201401',
				value: 1200
			}, {
				time: '201402',
				value: 1400
			}, {
				time: '201403',
				value: 1600
			}, {
				time: '201404',
				value: 1800
			}, {
				time: '201405',
				value: 2100
			}, {
				time: '201406',
				value: 2600
			}, {
				time: '201407',
				value: 2700
			}, {
				time: '201408',
				value: 3800
			}, {
				time: '201409',
				value: 3900
			}, {
				time: '201410',
				value: 4000
			}, {
				time: '201411',
				value: 5000
			}, {
				time: '201412',
				value: 6000
			}]
		],
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
		colorset: ['#6ba3f1', '#ffd55a', '#49d5b6', '#b699f1', '#f26370', '#4ad486'],
		series: [{
			name: '能源',
			weight: 1,
			value: 5
		}, {
			name: '医疗',
			weight: 1,
			value: 8
		}, {
			name: '环保',
			weight: 1,
			value: 9
		}, {
			name: '机械电子',
			weight: 1,
			value: 10
		}, {
			name: '化工',
			weight: 1,
			value: 15
		}]
	}


	var tagSetting = {
		selector: '.chartwrap .right .chart2',
		margin: {
			left: 40,
			top: 50,
			right: 50,
			bottom: 60
		},
		colorset: ['#65bbff', '#96ccff', '#ddeeff', '#c4e5ff', '#addaff', '#97cfff', '#97cfff'],
		series: [
			["广东", 1200],
			["武汉", 1500],
			["上海", 1300],
			["北京", 300],
			["福建", 400],
			["杭州", 500]
		]

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
			tradeString

		console.log('-------------------887',term1Spans,term2Spans,term3Spans)
		for (var si=0;si<term1Spans.length;si++) {

			typeArray.push(term1Spans.eq(si).text())
			
		}
		
		for (var sj=0;sj<term2Spans.length;sj++) {

			cityArray.push(term2Spans.eq(sj).text())

		}

		for (var sk=0;sk<term3Spans.length;sk++) {
			console.log(term3Spans.eq(sk).text())
			tradeArray.push(term3Spans.eq(sk).text())
		}

		typeString = typeArray.join(',')
		cityString = cityArray.join(',')
		tradeString = tradeArray.join(',')

		console.log('------------------------908',tradeArray,tradeString)
		$.ajax({
			url: path + '/getsearchstatistics',
			data: {
				'type':typeString,
				'keywords': word,
				'area': cityString,
				'industry': tradeString,
				'startDate': '201401',
				'endDate': '201512'
			},
			type: "POST",
			dataType: "json",
			success: function(data) {
				console.log(data)
				var dataArea = data[0].dataArea,
					dataIndustry = data[0].dataIndustry,
					dataTimeo = data[0].dataTimeo,
					tagSeries = [],
					arcSeries = [],
					leftSeries = [
						[],
						[],
						[]
					]

				for (var i = 0; i < dataArea.length; i++) {

					var temp = [dataArea[i].area, dataArea[i].nums]
					tagSeries.push(temp)
				}


				for (var j = 0; j < dataIndustry.length; j++) {

					var temp1 = {
						name: dataIndustry[j]['industry'],
						weight: 1,
						value: dataIndustry[j]['nums']
					}

					arcSeries.push(temp1)
				}


				for (var k = 0; k < dataTimeo.length; k++) {

					var bid = {
						time: dataTimeo[k]['time'],
						value: dataTimeo[k]['bid']
					}

					var project = {
						time: dataTimeo[k]['time'],
						value: dataTimeo[k]['project']
					}

					var tender = {
						time: dataTimeo[k]['time'],
						value: dataTimeo[k]['tender']
					}

					// bid 投标 tender 招标 设计稿有出入
					leftSeries[0].push(project)
					leftSeries[1].push(tender)
					leftSeries[2].push(bid)
				}

				tagSetting.series = tagSeries
				SearchChart.rect(tagSetting)

				arcSetting.series = arcSeries
				SearchChart.pieCircle(arcSetting)

				leftSetting.series = leftSeries
				SearchChart.brokeArea(leftSetting)
			},
			error: function() {
				alert("请求异常");
			}
		})
	}

	getData()


	$('#dtype>li').on('click',function(e) {

		var e = e || window.event,
			display = $('.term1').css('display')

		if (display === 'block') {
			getData()
		}
	})


	$('.type>li').on('click',function(e) {

		var e = e || window.event,
			display = $('.term1').css('display')

		if (display === 'block') {
			getData()
		}
	})


	$('.area>li').on('click',function(e) {

		var e = e || window.event,
			display = $('.term2').css('display')

		if (display === 'block') {
			getData()
		}
	})

	$('.trade>li').on('click',function(e) {

		var e = e || window.event,
			display = $('.term3').css('display')

		if (display === 'block') {
			getData()
		}
	})
})*/