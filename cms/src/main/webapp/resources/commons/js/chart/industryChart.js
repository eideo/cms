/* 
 * @Author: Administrator
 * @Date:   2015-11-30 17:36:38
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-01 10:09:09
 */

'use strict';

define(function(require, exports, module) {

	var Interaction = require('../../js/public/getDate')

	var IndustryChart = {}

	Array.prototype.remove=function(index) {

	    if(isNaN(index)||index>=this.length) {
	        return false;
	    }

	    for(var i=0,n=0;i<this.length;i++) {

	        if(this[i]!=this[index]) {

	            this[n++]=this[i];
	        }
	    }
	    this.length-=1;
	}

	IndustryChart.leftBar = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			legend = setting.legend,
			type = setting.type,
			industryClicked = setting.industryClicked,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			length = series.length,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			svg,
			content,
			xScale,
			yScale,
			xAxis,
			yAxis,
			max,
			rangeBand,
			xArray = [],
			yArray = []

		series.forEach(function(item) {
			xArray.push(item['value']);
			yArray.push(item['type']);
		});

		max = d3.max(xArray, function(d, i) {

			return Math.ceil(d);
		});

		svg = d3.selectAll(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		yScale = d3.scale.ordinal()
			.domain(yArray)
			.rangeBands([0, contentH], 0.5)

		xScale = d3.scale.linear()
			.domain([0, max])
			.range([0, contentW])

		rangeBand = yScale.rangeBand()

		xAxis = d3.svg.axis()
			.scale(xScale)
			.orient('bottom')
			.ticks(7)
			.tickFormat(function(d) {
				return d
			})

		svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + margin.left + ',' + (height - margin.bottom - 20) + ')')
			.call(xAxis)


		svg.append('text')
			.attr('transform', 'translate(' + (margin.left + 20)+ ',' + (height - margin.bottom) + ')')
			.text('(/条)')

		svg.selectAll('.axis xAxis')
			.select('path')
			.style('stroke-width', 2)

		svg.selectAll('.axis xAxis')
			.selectAll('line')
			.style('stroke', '#e2e2e4')
			.style('stroke-width', 2)

		var rectCon = svg.append('g')
			.attr('class', 'rectCon')
			.attr('transform', 'translate(' + (margin.left) + ',' + 0 + ')')

		var rects = rectCon.append('g')
			.attr('class', 'rects')

		var texts = rectCon.append('g')
			.attr('class', 'texts')

		var node = rects.selectAll('g')
			.data(series)
			.enter()
			.append('g')
			.attr('class', 'node')

		node
			.append('rect')
			.attr('class', function(d,i) {

				$(this).data('type', d['type'])
				$(this).data('id', d['id'])
				$(this).data('color',colorset[i])

				if (d['value'] < 10) {

					$(this).data('canClick',false)
				} else {

					$(this).data('canClick',true)
				}
				return 'leftBarRect'
			})
			.attr('fill', function(d, i) {

				return colorset[i]
			})
			.on('mouseover',function(d,i) {

				d3.select(this).attr('opacity',1.0)
			})
			.on('mouseout',function(d) {

				d3.select(this).attr('opacity',0.8)
			})
			.attr('x', function(d, i) {

				return xScale(0)
			})
			.attr('y', function(d) {


				return yScale(d['type'])
			})
			.attr('cursor', 'pointer')
			.attr('width', function(d, i) {

				return xScale(0)
			})
			.attr('height', 20)
			.transition()
			.duration(1500)
			.ease('bounce')
			.attr("y", function(d) {

				return yScale(d['type'])
			})
			.attr('opacity',0.8)
			.attr('width', function(d) {

				return xScale(d['value'])
			})

		var nodetext = texts.selectAll('g')
			.data(series)
			.enter()
			.append('g')
			.attr('class', 'node')

		nodetext
			.append('text')
			.attr('cursor', 'pointer')
			.attr('class', 'leftBarText')
			.attr('text-anchor','end')
			.attr('x', function(d, i) {
				return xScale(0) - 10
			})
			.style('fill', function(d,i) {

				var type = Interaction.type

				if (d['type'] == type) {

					return colorset[i]
				} else {

					return '#333'
				}	
		
			})
			.attr("y", function(d, i) {

				$(this).data('type', d['type'])
				$(this).data('id', d['id'])
				$(this).data('color',colorset[i])

				if (d['value'] < 10) {

					$(this).data('canClick',false)
				} else {

					$(this).data('canClick',true)
				}
				
				return yScale(d['type']) + rangeBand
			})
			.text(function(d) {
				return d['type']
			})
			.style('text-align','right')


		nodetext.append("svg:title")
			.text(function(d) {
				return d['value'] + '条'
			})
	}

	IndustryChart.timeLine = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			legend = setting.legend,
			type = setting.type,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			length = series.length,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			svg,
			content,
			xScale,
			yScale,
			xAxis,
			yAxis,
			max,
			rangeBand,
			xArray = [],
			yArray = []

		series.forEach(function(item) {
			xArray.push(item['time']);
			yArray.push(item['value']);	
		});
		
		max = d3.max(yArray, function(d, i) {

			return Math.ceil(d)
		})

		svg = d3.selectAll(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		xScale = d3.scale.ordinal()
			.domain(xArray)
			.rangePoints([0, contentW])

		yScale = d3.scale.linear()
			.domain([0, max])
			.range([contentH, 0])

		rangeBand = xScale.rangeBand()

		yAxis = d3.svg.axis()
			.scale(yScale)
			.ticks(6)
			.orient('left')
			.tickSize(0)
			.ticks(6)
			.tickPadding(10)
			.tickFormat(function(d) {
				return d
			})

		xAxis = d3.svg.axis()
			.scale(xScale)
			.orient('bottom')
			.tickSize(0)
			.tickPadding(10)

		svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + margin.left + ',' + (height - margin.bottom) + ')')
			.call(xAxis)

		svg.append('g')
			.attr('class', 'axis yAxis')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')
			.call(yAxis)

		svg.selectAll('.yAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
				d3.select(this).append('line')
					.attr('x1', 0)
					.attr('y1', 0)
					.attr('x2', (contentW))
					.attr('y2', 0)
					.style('stroke', '#e7e7e7')
			})


		svg.selectAll('.xAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
			})

		svg.select('.yAxis')
			.selectAll('path').remove()

		svg.selectAll('.xAxis .tick').selectAll('text')
			.text(function(d) {

				$(this).data('time', d)

				var dd = d.toString().substr(4, 2),
					yearStart = d.toString().substr(0, 4)

				if (parseInt(dd) % 2 == 0) {

					return dd
				} else {

					return ''
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
			.interpolate("basic");

		var linePath = d3.svg.line()
			.x(function(d, i) {

				return xScale(xArray[i])
			})
			.y(function(d, i) {

				return yScale(d['value']);
			})
			.interpolate("basic")

		svg.append("clipPath")
			.attr("id", "content-brokeArea")
			.append("rect")
			.attr("x", -10)
			.attr("y", -10)
			.attr("height", height)
			.attr("width", 10)
			.transition()
			.duration(1500)
			.attr("width", width)

		var content = svg.append("g")
			.attr("class", "lineArea")
			.attr("clip-path", "url(#content-brokeArea)")
			.attr("transform", "translate(" + margin.left + "," + margin.top + ")")

		var pct = svg.select(".lineArea")
			.append("g")
			.attr("class", "pct")

		pct.append("path")
			.datum(series)
			.attr("d", area)
			.style("fill", function(d, i) {

				return colorset[1]
			})
			.style("opacity", "0.7")

		content.append('path')
			.datum(series)
			.attr("stroke", function(d, i) {

				return colorset[0];
			})
			.attr('stroke-width', 2)
			.attr("d", linePath)
			.style('fill', 'none')
	}

	IndustryChart.pieArea = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			type = setting.type,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			svg,
			content,
			max,
			total = 0

		max = d3.max(series, function(d, i) {
			return d.value
		})

		series.forEach(function(item) {

			total += item['value']
		})

		var arc = d3.svg.arc()
			.outerRadius(width / 6)
			.innerRadius(26);

		var outArc = d3.svg.arc()
			.outerRadius(width / 6 + 5)
			.innerRadius(21)


		var pie = d3.layout.pie()
			.value(function(d) {

				if ((d.value / total) < 0.05 && d.value > 0.0001) {

					var value = total * 0.05

					return value
				} else {

					return d.value
				}
			})
			.sort(null)

		svg = d3.select(selector).append('svg')
			.attr('width', width)
			.attr('height', height)

		var content = svg.append('g')
			.attr('transform', 'translate(' + (width * 0.35) + ',' + (height / 2) + ')')
			.attr('class', 'content')

		var rect = content.selectAll('g.arc')
			.data(pie(series))
			.enter()
			.append('g')
			.attr('class', function(d, i) {

				$(this).data('type', d['data']['name'])
				return 'arc' + i
			})

		var paths = rect.append('path')
			.attr({
				'fill': function(d, i) {

					$(this).data('type', d['data']['name'])
					$(this).data('color', colorset[i])

					return colorset[i]
				},
				'cursor': 'pointer',
				'd': arc,
			})
			.on("mouseover", function(e, i) {

				var vectx, vecty

				vectx = 5 * Math.cos((e.startAngle + e.endAngle) / 2 - Math.PI / 2)
				vecty = 5 * Math.sin((e.startAngle + e.endAngle) / 2 - Math.PI / 2)

				d3.select(this)
					.attr("transform", "translate(" + "0" + "," + "0" + ")")
					.transition()
					.duration(500)
					.attr("transform", "translate(" + vectx + "," + vecty + ")")
					.attr("transform", "translate(" + vectx + "," + vecty + ")")
					.transition()
					.duration(300)
					.attr("transform", "translate(" + "0" + "," + "0" + ")")

			})
			.attr('class', 'arcSelect')
			.transition()
			.duration(1000)
			.attrTween('d', function(d) {

				return tweenPie(d, arc)
			})
			.transition()
			.ease('elastic')

		var legends = svg.append('g')
			.attr('class', 'legends')

		var legend = legends.selectAll('.legend')
			.data(series)
			.enter()
			.append('g')

		legend.append('circle')
			.attr('cx', (width * 0.65))
			.attr('cy', function(d, i) {

				return i * 26 + (0.45 * height)
			})
			.attr('r', 0)
			.transition()
			.duration(1500)
			.attr('r', 5)
			.attr('fill', function(d, i) {
				return colorset[i]
			})

		legend.append('text')
			.attr('dx', '1.5em')
			.attr('dy', '0.45em')
			.attr('class','legendText')
			.attr('x', (width * 0.63))
			.attr('y', function(d, i) {

				return i * 26 + (0.45 * height)
			})
			.transition()
			.duration(2000)
			.tween('text',function(d,i) {

				var trueNumber = Math.round(((d['value'] / total)* 10000).toFixed(2)) / 100

				return function(t) {

					d3.select(this)
						.text(d['name'] +'      '+ (t*trueNumber).toFixed(2)+ "%")
				}
			})
			.style('fill',function(d,i) {

				var name = d['name']

				if (name === type) {

					return colorset[i]
				} else {
					return '#333'
				}
			})
			.style('font-weight',function(d,i) {

				var name = d['name']

				if (name === type) {

					return 'bold'
				} else {
					return 'normal'
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

	IndustryChart.singleLine = function(setting) {

		// 清空图表
		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			legend = setting.legend,
			industry = setting.industry || '房地产建筑',
			type = setting.type,
			chartColor = setting.chartColor,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			length = series.length,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			svg,
			content,
			xScale,
			yScale,
			xAxis,
			yAxis,
			max,
			rangeBand,
			xArray = [],
			yArray = []

		series.forEach(function(item) {

			xArray.push(item['time'])
			yArray.push(item['value'])
		})	
		
		max = d3.max(yArray, function(d, i) {

			return Math.ceil(d)*(1.1)
		})

		svg = d3.selectAll(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		xScale = d3.scale.ordinal()
			.domain(xArray)
			.rangePoints([0, contentW])

		yScale = d3.scale.linear()
			.domain([0, max])
			.range([contentH, 0])

		rangeBand = xScale.rangeBand()

		yAxis = d3.svg.axis()
			.scale(yScale)
			.orient('left')
			.tickSize(0)
			.ticks(6)
			.tickPadding(10)
			.tickFormat(function(d) {
				return d
			})

		xAxis = d3.svg.axis()
			.scale(xScale)
			.orient('bottom')
			.tickSize(0)
			.tickPadding(10)

		svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + margin.left + ',' + (height - margin.bottom) + ')')
			.call(xAxis)

		svg.append('g')
			.attr('class', 'axis yAxis')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')
			.call(yAxis)

		svg.selectAll('.yAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
				d3.select(this).append('line')
					.attr('x1', 0)
					.attr('y1', 0)
					.attr('x2', (contentW))
					.attr('y2', 0)
					.style('stroke', '#e7e7e7')
			})

		svg.append('line')
			.attr('opacity', function(d, i) {

				d3.select(this)
					.attr('x1', margin.left)
					.attr('y1', 0)
					.attr('x2', (contentW + margin.left))
					.attr('y2', 0)
					.style('stroke','red')

				return 0
			})
			.attr('class','tipLine')
			.style('stroke-dasharray','3px')

		svg.selectAll('.xAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
			})

		svg.selectAll('.xAxis .tick').selectAll('text')
			.text(function(d) {

				$(this).data('time', d)

				var dd = d.toString().substr(4, 2),
					yearStart = d.toString().substr(0, 4)

				if (parseInt(dd) % 2 == 0) {

					return dd
				} else {

					return ''
				}
			})

		svg.append('text')
			.attr('transform', 'translate(' + (width - margin.right - 30) + ',' + (margin.top - 10) + ')')
			.text('时间:月')

		var lineArea = d3.svg.line()
			.x(function(d, i) {

				return xScale(xArray[i])
			})
			.y(function(d, i) {

				return yScale(d['value'])
			})
			.interpolate("cardinal")

		svg.append("clipPath")
			.attr("id", "content-brokeArea")
			.append("rect")
			.attr("x", -10)
			.attr("y", -10)
			.attr("height", height)
			.attr("width", 10)
			.transition()
			.duration(1500)
			.attr("width", width)

		var lineCon = svg.append('g')
			.attr('class', 'lineCon')
			.attr("clip-path", "url(#content-brokeArea)")
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

		lineCon.append("path")
			.datum(series)
			.attr("stroke", function(d, i) {
				 
				return chartColor;
			})
			.attr('stroke-width', 2)
			.attr("d", lineArea)
			.style("fill", function(d, i) {

				return 'none'
			})
			.style("opacity", "0.7")

		var circleCon = svg.append('g')
			.attr('class', 'circleCon')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

		var node = circleCon.selectAll('circle')
			.data(series)
			.enter()
			.append('circle')
			.attr('class', 'circle')
			.attr('cx', function(d, i) {
				return xScale(xArray[i])
			})
			.attr('cy', function(d, i) {

				$(this).data('info', d['value'])
				$(this).data('pos', [xScale(xArray[i]), yScale(d['value'])])
				return yScale(d['value'])
			})
			.on('mouseover', function(d,i) {

				d3.select(this)
					.attr('r',3)
					.transition()
					.duration(500)
					.attr('r', 6)
					.transition()
					.duration(500)
					.attr('r', 3)

				var pos = d3.mouse(this)

				$('#chart4 .tip')
					.css('background',chartColor)
					.css('left',xScale(xArray[i])+margin.left - 24)
					.css('top',yScale(d['value'])+margin.top - 34)
					.html(d['value']+"<i style='background:"+chartColor+"'></i>")
					.show()

				d3.select('#chart4 .tipLine')
					.attr('opacity',1.0)
					.attr('y1',yScale(d['value'])+margin.top)
					.attr('y2',yScale(d['value'])+margin.top)
					.style('stroke',chartColor)
			})
			.on('mouseout',function(d,i) {

				$('#chart4 .tip').hide()
				d3.select('#chart4 .tipLine')
					.attr('opacity',0)
			})
			.attr('r', 0)
			.transition()
			.duration(1000)
			.attr('r', 3)
			.attr('fill', chartColor)
			.style('cursor', 'pointer')

		var mtime = Interaction.leftStartTime.year + Interaction.leftStartTime.month + '-' + Interaction.leftEndTime.year + Interaction.leftEndTime.month
		
		var nowMonth = series[length-1].time.toString().substr(4,2),
			length = series.length

		var cMonthVal = series[length-1].value,
			tAmonthVal = series[length -12].value,
			bMonthVal = series[length-2].value,
			aMonthVal = series[length-3].value,
			averAgeVal = (aMonthVal + bMonthVal + cMonthVal) / 3,
			tbPer,
			tbValue,
			tbPerShow,
			hbPer,
			hbValue,
			hbPerShow,
			zsState
		
		tbPer = (aMonthVal - tAmonthVal ) / tAmonthVal
		hbPer = (cMonthVal - bMonthVal) / bMonthVal

		tbValue =  (Math.abs(tbPer) * 100).toFixed(0)
		hbValue =  (Math.abs(hbPer) * 100).toFixed(0)

		tbPer < 0 ? tbPerShow = '下降'+ tbValue+"%":tbPerShow = '上升'+ tbValue +"%"
		hbPer < 0 ? hbPerShow = '下降'+ hbValue+"%":hbPerShow = '上升'+ hbValue+"%"

		if (aMonthVal < averAgeVal && bMonthVal > averAgeVal) {

			zsState = '呈上升趋势'
		} else if (aMonthVal < averAgeVal && bMonthVal < averAgeVal) {
			zsState = '呈波动趋势'
		} else if (aMonthVal > averAgeVal && bMonthVal > averAgeVal) {
			zsState = '呈波动趋势'
		} else if (aMonthVal > averAgeVal && bMonthVal < averAgeVal) {
			zsState = '呈下降趋势'
		} else {
			zsState = '呈稳定趋势'
		}

		// 设置标题
		$('.industryCon .left h3').html('<span class="highLight" style="color:'+chartColor+'">' + industry + '</span>行业  景气指数' + '<span style="font-size:10px;font-weight:normal">(' + mtime + ')</span>')
		$('.industryCon .left .result').html(nowMonth +'月 <span class="bold">' + industry + '</span> 景气指数同比'+tbPerShow+'，环比'+hbPerShow+'，'+zsState)
	}

	IndustryChart.lengthBar = function(setting) {

		// 清空图表
		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			series = setting.series,
			colorset = setting.colorset,
			margin = setting.margin,
			legend = setting.legend,
			industry = setting.industry || '房地产建筑',
			type = setting.type,
			chartColor = setting.chartColor,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			length = series.length,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom,
			svg,
			content,
			xScale,
			yScale,
			hScale,
			xAxis,
			yAxis,
			max,
			mtime,
			rangeBand,
			xArray = [],
			yArray = []

		mtime = Interaction.leftStartTime.year + Interaction.leftStartTime.month + '-' + Interaction.leftEndTime.year + Interaction.leftEndTime.month

		for (var i = 0; i < series.length; i++) {

			xArray.push(series[i]['time'])
			yArray.push(series[i]['value'])
		}

		max = d3.max(yArray, function(d, i) {

			return Math.ceil(d)*(1.1);
		})

		svg = d3.selectAll(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		xScale = d3.scale.ordinal()
			.domain(xArray)
			.rangeBands([0, contentW], 0.6)

		yScale = d3.scale.linear()
			.domain([0, max])
			.range([contentH, 0])

		hScale = d3.scale.linear()
			.domain([0, max])
			.range([0, contentH])

		rangeBand = xScale.rangeBand()

		yAxis = d3.svg.axis()
			.scale(yScale)
			.orient('left')
			.tickSize(0)
			.ticks(6)
			.tickPadding(10)
			.tickFormat(function(d) {
				return d
			})

		xAxis = d3.svg.axis()
			.scale(xScale)
			.orient('bottom')
			.tickSize(0)
			.tickPadding(10)

		svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + margin.left + ',' + (height - margin.bottom) + ')')
			.call(xAxis)

		svg.append('g')
			.attr('class', 'axis yAxis')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')
			.call(yAxis)

		svg.selectAll('.yAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
				d3.select(this).append('line')
					.attr('x1', 0)
					.attr('y1', 0)
					.attr('x2', (contentW))
					.attr('y2', 0)
					.style('stroke', '#e7e7e7')
			})

		svg.append('line')
			.attr('opacity', function(d, i) {

				d3.select(this)
					.attr('x1', margin.left)
					.attr('y1', 0)
					.attr('x2', (contentW + margin.left))
					.attr('y2', 0)
					.style('stroke','red')

				return 0
			})
			.attr('class','tipLine')
			.style('stroke-dasharray','3px')

		svg.selectAll('.xAxis .tick')
			.attr('opacity', function(d, i) {
				d3.select(this).select('text')
					.style('font-family', 'Arial')
			})

		svg.append('text')
			.attr('transform', 'translate(' + (width - margin.right - 30) + ',' + (margin.top - 10) + ')')
			.text('时间:月')

		svg.selectAll('.xAxis .tick').selectAll('text')
			.text(function(d) {

				$(this).data('time', d)

				var dd = d.toString().substr(4, 2),
					yearStart = d.toString().substr(0, 4)

				if (parseInt(dd) % 2 == 0) {

					return dd
				} else {

					return ''
				}
			})

		var lineArea = d3.svg.line()
			.x(function(d, i) {

				return xScale(xArray[i])
			})
			.y(function(d, i) {

				return yScale(d['value']);
			})
			.interpolate("cardinal")

		var barCon = svg.append('g')
			.attr('class', 'barCon')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

		var node = barCon.selectAll('rect')
			.data(series)
			.enter()
			.append('rect')
			.attr('class','chart5Rect')
			.attr('fill', function(d, i) {

				return chartColor
			})
			.attr('x', function(d, i) {

				return xScale(xArray[i])
			})
			.attr('y', function(d) {

				return contentH - hScale(0);
			})
			.on('mouseover',function(d,i) {

				$('#chart5 .tip')
					.css('background',chartColor)
					.css('left',xScale(xArray[i])+margin.left - 20)
					.css('top',yScale(d['value'])+margin.top - 30)
					.html(d['value']+"<i style='background:"+chartColor+"'></i>")
					.show()

				d3.select('#chart5 .tipLine')
					.attr('opacity',1.0)
					.attr('y1',yScale(d['value'])+margin.top)
					.attr('y2',yScale(d['value'])+margin.top)
					.style('stroke',chartColor)

				d3.selectAll('.chart5Rect')
					.attr('opacity',0.5)
				d3.select(this)
					.attr('opacity',1.0)
			})
			.on('mouseout',function(d,i) {

				$('#chart5 .tip')
					.hide()
				d3.select('#chart5 .tipLine')
					.attr('opacity',0.0)

				d3.selectAll('.chart5Rect')
					.attr('opacity',1.0)
			})
			.attr('width', xScale.rangeBand)
			.attr('height', 0)
			.transition()
			.duration(1500)
			.attr("y", function(d, i) {

				return contentH - hScale(d['value'])
			})
			.attr('height', function(d, i) {

				return hScale(d['value'])
			})

		var nowMonth = series[length-1].time.toString().substr(4,2),
			length = series.length

		var cMonthVal = series[length-1].value,
			tAmonthVal = series[length -12].value,
			bMonthVal = series[length-2].value,
			aMonthVal = series[length-3].value,
			averAgeVal = (aMonthVal + bMonthVal + cMonthVal) / 3,
			tbPer,
			tbValue,
			tbPerShow,
			hbPer,
			hbValue,
			hbPerShow,
			zsState
		
		tbPer = (aMonthVal - tAmonthVal ) / tAmonthVal
		hbPer = (cMonthVal - bMonthVal) / bMonthVal

		tbValue =  (Math.abs(tbPer) * 100).toFixed(2)
		hbValue =  (Math.abs(hbPer) * 100).toFixed(2)

		tbPer < 0 ? tbPerShow = '下降'+ tbValue+"%":tbPerShow = '上升'+ tbValue +"%"
		hbPer < 0 ? hbPerShow = '下降'+ hbValue+"%":hbPerShow = '上升'+ hbValue+"%"

		if (aMonthVal < averAgeVal && bMonthVal > averAgeVal) {

			zsState = '呈上升趋势'
		} else if (aMonthVal < averAgeVal && bMonthVal < averAgeVal) {
			zsState = '呈波动趋势'
		} else if (aMonthVal > averAgeVal && bMonthVal > averAgeVal) {
			zsState = '呈波动趋势'
		} else if (aMonthVal > averAgeVal && bMonthVal < averAgeVal) {
			zsState = '呈下降趋势'
		} else {
			zsState = '呈稳定趋势'
		}

		// 设置标题
		$('.industryCon .right h3').html('<span class="highLight" style="color:'+chartColor+'">' + industry + '</span>行业  关注指数' + '<span style="font-size:10px;font-weight:normal">(' + mtime + ')</span>')
		$('.industryCon .right .result').html(nowMonth +'月 <span class="bold">' + industry + '</span> 关注指数同比'+tbPerShow+'，环比'+hbPerShow+'，'+zsState)
	}

	IndustryChart.chinaMap = function(setting, callback) {

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			margin = setting.margin,
			series = setting.series,
			colorset = setting.colorset,
			dataset = setting.dataset,
			color,
			areas = []

		for (var i = 0; i < series.length; i++) {
			areas.push(series[i].name)
		}

		var svg = d3.select(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		var projection = d3.geo.mercator()
			.center([107, 38])
			.scale(width * 0.65)
			.translate([width / 2 - 20, height / 3 + 30])

		var mPath = d3.geo.path().projection(projection)

		var content = svg.append("g")
			.attr("class", "content")
			.attr("transform", "translate(" + margin.left + ", " + margin.top + ")");

		$.getJSON(path + '/resources/json/china.json', function(data) {

			var json = data
			//绘制中国地图
			content.selectAll("path")
				.data(json.features)
				.enter()
				.append("path")
				.attr("d", mPath)
				.attr("fill", function(d, i) {

					var name = d.properties['name'],
						index = areas.indexOf(name)
					if (index !== -1) {

						return colorset[index]
					} else {

						return '#e0f0fd'
					}
				})
				.attr("stroke-width", "1px")
				.attr("stroke-linejoin", "round")
				.attr("stroke", function(d, i) {

					return '#cce4ff';
				})
				.style('opacity',0.8)

			content.selectAll("text")
				.data(json.features)
				.enter()
				.append("text")
				.attr("transform", function(d) {

					var name = d.properties.name,
						pos = mPath.centroid(d)

					if (name === '河北') {

						return "translate(" + (pos[0] - 10) + "," + (pos[1] + 10) + ")";

					} else if (name === '香港') {

						return "translate(" + (pos[0] + 10) + "," + (pos[1] + 10) + ")";

					} else if (name === '澳门') {

						return "translate(" + (pos[0] - 10) + "," + (pos[1] + 10) + ")";

					} else if (name === '钓鱼岛') {

						return "translate(" + mPath.centroid(d) + ")";
					} else {

						return "translate(" + mPath.centroid(d) + ")";
					}
				})
				.attr("dy", ".35em")
				.attr("class", function(d, i) {

					return "text" + d.properties.id;
				})
				.text(function(d) {

					var name = d.properties.name
					return name
				})
				.style('fill', '#0760bd')
		})

		var barCon = svg.append('g')
			.attr('class', 'barCon')
			.attr("transform", "translate(" + 30 + ", " + (margin.top * 2 - 5) + ")")

		// add the southChina sea

		var southChina = svg.append('image')
			.attr('class', 'southChinaSea')
			.attr('width', 80)
			.attr('height', 80)
			.attr("transform", "translate(" + (width - margin.left) + ", " + (height - margin.bottom) + ")")
			.attr('xlink:href', path + '/resources/commons/images/southSea.png')

		if (callback) {

			callback && callback()
		}
	}

	IndustryChart.mapBar = function(selector, series, colorset) {

		selector.select('g').remove()

		var
			width = 200,
			height = 320,
			availWidth = 100

		var svg,
			content,
			xScale,
			yScale,
			xAxis,
			yAxis,
			xArray = [],
			yArray = []

		for (var i = 0; i < series.length; i++) {

			xArray.push(series[i]['value'])
			yArray.push(series[i]['name'])
		}

		var max = d3.max(xArray, function(d, i) {

			return Math.ceil(d)
		})

		content = selector
			.append('g')

		yScale = d3.scale.ordinal()
			.domain(yArray)
			.rangeBands([0, height], 0.5)

		xScale = d3.scale.linear()
			.domain([0, max])
			.range([0, availWidth])

		var rangeBand = yScale.rangeBand()

		content.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('x', function(d, i) {
				return xScale(0)
			})
			.attr("y", function(d, i) {

				return yScale(d['name']) + 10
			})
			.text(function(d, i) {
				return (i + 1) + '    ' + d['name']
			})
			.style('fill', '#333')

		content.selectAll('rect')
			.data(series)
			.enter()
			.append('rect')
			.attr('fill', function(d, i) {
				return colorset[i]
			})
			.attr('x', function(d, i) {

				return 50
			})
			.attr('y', function(d) {

				return yScale(d['name'])
			})
			.attr('width', function(d, i) {

				return xScale(0)
			})
			.attr('height', 12)
			.transition()
			.duration(1500)
			.attr("y", function(d, i) {

				return yScale(d['name'])
			})
			.attr('width', function(d, i) {

				return xScale(d['value'])
			})
	}

	IndustryChart.radarBar = function(setting) {

		d3.select(setting.selector).select('svg').remove()

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			margin = setting.margin,
			series = setting.series,
			colorset = setting.colorset,
			industry = setting.industry,
			polyArray = [],
			lineArray = [],
			raderLength = 5,
			arcArray = [],
			total = 0

		var svg = d3.select(selector)
			.append('svg')
			.attr('width', width)
			.attr('height', height)

		var raderCon = svg.append('g')
			.attr('class', 'raderCon')
			.attr('transform', 'translate(' + (width / 2) + ',' + (height / 2 - 20) + ')')

		var max = series[0]

		for (var ma = 1; ma < series.length; ma++) {

			if (series[ma] > max) {

				max = series[ma]
			}
		}
		var pie = d3.layout.pie()
			.value(function(d) {

				return 1
			})
			.sort(null)

		var arcArea = raderCon.selectAll('g.arc')
			.data(pie(series))
			.enter()
			.append('g')
			.attr('class', function(d, i) {

				return 'arc' + i
			})

		for (var i = 0; i <= raderLength; i++) {

			var tempArray = []
			var arc = d3.svg.arc()
				.innerRadius(20 + i * 10)
				.outerRadius(21 + i * 10)
			arcArray.push(arc)

			var paths = arcArea.append('path')
				.attr({
					'fill': function(d, i) {
						tempArray.push(arc.centroid(d))
						return colorset[0];
					},
					'cursor': 'pointer',
					'd': arcArray[i]
				}).remove()

			polyArray.push(tempArray)
		}

		for (var j = raderLength; j > 0; j--) {

			raderCon.append('polygon')
				.attr('points', function() {

					var points = ''

					for (var k = 0; k < polyArray[j].length; k++) {

						points += polyArray[j][k].toString() + ' '
					}


					return points
				})
				.attr('fill', function() {

					if (j % 2 === 0) {

						return '#f6f6f6'
					} else {
						return '#fff'
					}
				})
				.attr('opacity', '0.8')
				.attr('stroke', colorset[1])

		}

		// add the line
		var outerArray = polyArray[raderLength]
		for (var n = 0; n < outerArray.length; n++) {

			raderCon.append('line')
				.attr('x1', 0)
				.attr('y1', 0)
				.attr('x2', function() {

					return outerArray[n][0]
				})
				.attr('y2', function() {

					return outerArray[n][1]
				})
				.attr('stroke', colorset[1])
		}

		// add the rader
		var rScale = d3.scale.linear()
			.domain([0, d3.max(series, function(d, i) {
				return d['value']
			})])
			.range([0, 70 - 10])

		var pathArray = []
		var pointScale = []

		for (var idx = 0; idx < series.length; idx++) {
			total += series[idx]['value']
			pointScale.push(rScale(series[idx].value))
		}

		var tempPath = arcArea.append('path')
			.attr({
				'fill': function(d, i) {

					pathArray.push([d.startAngle, d.endAngle])
					return colorset[0];
				},
				'cursor': 'pointer',
				'd': arcArray[arcArray.length - 1]
			}).remove()

		// add the dataArea
		var dataAreaArr = []

		for (var idy = 0; idy < pointScale.length; idy++) {

			var marc = pathArray[idy][1],
				diffAngle = (pathArray[idy][0] + pathArray[idy][1]) / 2,
				pointX = Math.cos(diffAngle - Math.PI / 2) * pointScale[idy],
				pointY = Math.sin(diffAngle - Math.PI / 2) * pointScale[idy]
			dataAreaArr.push([pointX, pointY])
		}

		raderCon.append('polygon')
			.attr('points', function() {

				var points = ''

				for (var i = 0; i < dataAreaArr.length; i++) {

					points += dataAreaArr[i][0] + ',' + dataAreaArr[i][1] + ' '
				}

				return points
			})
			.attr('fill', '#b0f6f7')
			.attr('opacity', '0.8')
			.attr('stroke', '#39d4d7')

		// add the circle
		raderCon.selectAll('.circle')
			.data(dataAreaArr)
			.enter()
			.append('circle')
			.attr('cx', function(d, i) {

				return dataAreaArr[i][0]
			})
			.attr('cy', function(d, i) {

				return dataAreaArr[i][1]
			})
			.attr('r', 4)
			.attr('fill', '#fff')
			.attr('stroke', '#39d4d7')
			.attr('stroke-width', 3)

		// add the text

		var rName = raderCon.append('g')
			.attr('class', 'rName')

		var rValue = raderCon.append('g')
			.attr('class', 'rValue')

		rName.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('x', function(d, i) {

				var diffAngle = (pathArray[i][0] + pathArray[i][1]) / 2,
					pointX = Math.cos(diffAngle - Math.PI / 2) * 90
				return pointX
			})
			.attr('y', function(d, i) {

				var diffAngle = (pathArray[i][0] + pathArray[i][1]) / 2,
					pointY = Math.sin(diffAngle - Math.PI / 2) * 90
				return pointY
			})
			.text(function(d, i) {

				return d['type']
			})
			.attr('dx', '-1.75em')
			.attr('dy', '0em')
			.style('fill', '#5e5e5e')

		rValue.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('x', function(d, i) {

				var diffAngle = (pathArray[i][0] + pathArray[i][1]) / 2,
					pointX = Math.cos(diffAngle - Math.PI / 2) * 90
				return pointX
			})
			.attr('y', function(d, i) {

				var diffAngle = (pathArray[i][0] + pathArray[i][1]) / 2,
					pointY = Math.sin(diffAngle - Math.PI / 2) * 90
				return pointY
			})
			.text(function(d, i) {

				var value = ((d['value'] / total) * 100).toFixed(1).toString()

				if (value.length > 4) {

					value = value.substr(0, 4)
				}

				return Math.round(((d['value'] / total)* 10000).toFixed(2)) / 100 + "%"
			})
			.attr('dx', '-1.5em')
			.attr('dy', '1.5em')
			.style('fill', '#5e5e5e')


		var maxPercent = Math.round(((max.value / total)* 10000).toFixed(2)) / 100

		$('#chart6 .chartText').html('关注 ' + '<span style="font-weight:bold">' + industry + '</span>' + '  行业的客户中,' + max.type + '占比最大为' + maxPercent + '%')
	}

	IndustryChart.sevenBar = function(setting) {

		var selector = setting.selector,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			margin = setting.margin,
			series = setting.series,
			industry = setting.industry,
			colorset = setting.colorset,
			xArray = [],
			yArray = [],
			total = 0,
			rangeBand,
			contentW = width - margin.left - margin.right,
			contentH = height - margin.top - margin.bottom

		var svg, content, rects, texts, rect, text, xScale, yScale, hScale, legends, legend

		d3.select(selector).select('svg').remove()

		svg = d3.select(selector).append('svg')
			.attr({
				'width': width,
				'height': height
			})

		content = svg.append('g')
			.attr('class', 'content')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

		rects = content.append('g')
			.attr('class', 'rects')

		texts = svg.append('g')
			.attr('class', 'texts')
			.attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')

		legends = content.append('g')
			.attr('class', 'legends')

		for (var i = 0; i < series.length; i++) {	
			if (series[i].value == 0) {
				series.remove(i)
			}
		}

		var maxPer = series[0]

		for (var si = 0; si < series.length;si++) {

			total += series[si].value
			xArray.push(series[si]['type'])
			yArray.push(series[si]['value'])

			if (series[si].value > maxPer.value) {

				maxPer = series[si]
			}
		}

		var max = d3.max(yArray, function(d, i) {

			return Math.ceil(d)
		})

		xScale = d3.scale.ordinal()
			.domain(xArray)
			.rangePoints([0, contentW])

		rangeBand = xScale.rangeBand()

		yScale = d3.scale.linear()
			.domain([0, max])
			.range([contentH, 0])

		hScale = d3.scale.linear()
			.domain([0, max])
			.range([0, contentH])

		rect = rects.selectAll('rect')
			.data(series)
			.enter()
			.append('rect')
			.attr('fill', function(d, i) {

				return colorset[i]
			})
			.attr('x', function(d, i) {

				return xScale(xArray[i])
			})
			.attr('y', function(d) {

				return contentH - hScale(0);
			})
			.attr('width', 36)
			.attr('height', 0)
			.transition()
			.duration(1000)
			.attr("y", function(d, i) {

				return contentH - hScale(d['value'])
			})
			.attr('height', function(d, i) {

				return hScale(d['value'])
			})

		legend = legends.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('x', function(d, i) {

				return xScale(xArray[i]) + rangeBand + 10
			})
			.attr("y", function(d, i) {

				return contentH - hScale(d['value']) - 10
			})
			.text(function(d, i) {

				return d['type']
			})
			.style('fill', '#5e5e5e')

		text = texts.selectAll('text')
			.data(series)
			.enter()
			.append('text')
			.attr('x', function(d, i) {

				return xScale(xArray[i]) + rangeBand / 2 + 6
			})
			.attr("y", function(d, i) {

				return contentH + 20;
			})
			.text(function(d, i) {

				return Math.round(((d['value'] / total).toFixed(4) * 100).toFixed(1)) + "%"
			})
			.style('fill', '#888888')
			.style('font-family','Arial')

		var maxPercent = Math.round(((maxPer.value / total) * 100).toFixed(2))

		$('#chart7 .chartText').html('关注 <span style="font-weight:bold">' +industry
			+ '</span>' + '  行业的客户中,' +  maxPercent + '%竞争力'+ maxPer.type + '  占比最大')
	}

	module.exports = IndustryChart
})