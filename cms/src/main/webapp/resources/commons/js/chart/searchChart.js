/* 
 * @Author: Administrator
 * @Date:   2015-11-25 14:05:51
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-12 15:21:01
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

		seriesArray.forEach(function(item) {

			yArray.push(item.value);
		});

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
			.tickPadding(10)
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
			.transition()
			.duration(1500)
			.tween('text',function(d, i) {

				var value = ((d.data.value / total).toFixed(2) * 100).toString()

				if (value.length > 3) {

					value = value.substr(0, 2)
				}

				var nameArray = d.data['name'].split('-'),
					len = nameArray.length,
					name
					len > 1 ? name = nameArray[1] : name = nameArray[0];

				return function(t) {

					d3.select(this)
						.text(name+'   '+(t*value).toFixed(0)+ "%");
				}
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

			return Math.ceil(d)*(1.2)
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

		var textCon = svg.append('g')
			.attr('class', 'textCon')
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

		textCon.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('fill','#5d5d5d')
			.attr('x', function(d, i) {

				return xScale(xArray[i]);
			})
			.attr("y", function(d, i) {

				return contentH - hScale(d[1]) - 10;
			})
			.transition()
			.duration(1500)
			.tween('text',function(d,i) {

				var trueNumber = Math.round(((d[1] / total)* 10000).toFixed(2)) / 100

				return function(t) {

					d3.select(this)
						.text((t*trueNumber).toFixed(0)+ "%")
				}
			})
	}
	module.exports = SearchChart;
})
