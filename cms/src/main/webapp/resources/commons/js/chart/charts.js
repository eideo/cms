/* 
 * @Author: Administrator
 * @Date:   2016-01-04 09:05:32
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-05 10:55:06
 */

'use strict';

define(function(require, exports, module) {

	var Interaction = require("../../js/public/getDate");

	Array.prototype.remove = function(index) {

		if (isNaN(index) || index >= this.length) {
			return false;
		}

		for (var i = 0, n = 0; i < this.length; i++) {

			if (this[i] != this[index]) {

				this[n++] = this[i];
			}
		}
		this.length -= 1;
	}

	function Chart(option) {
		console.log(option)
		this.selector = option.selector
		this.series = option.series
		this.colorset = option.colorset
		this.margin = option.margin
		this.legend = option.legend
		this.type = option.type
		this.industryClicked = option.industryClicked
		this.width = document.querySelector(this.selector).getBoundingClientRect().width
		this.height = document.querySelector(this.selector).getBoundingClientRect().height
		this.length = this.series.length
		this.contentW = this.width - this.margin.left - this.margin.right
		this.contentH = this.height - this.margin.top - this.margin.bottom
		this.svg = null
		this.content = null
		this.xScale = null
		this.yScale = null
		this.xAxis = null
		this.xAxisSetting = option.xAxisSetting
		this.yAxisSetting = option.yAxisSetting
		this.yAxis = null
		this.xArray = []
		this.yArray = []
		this.max = null
		this.total = 0
		this.rangeBand = null
	}

	// 定义图表的横纵坐标数组
	Chart.prototype._initArray = function() {

		var that = this,
			series = this.series,
			xScale = that.xAxisSetting.scale,
			yScale = that.yAxisSetting.scale

		if (xScale === 'ordinal') {

			for (var i = 0, n = series.length; i < n; i++) {

				that.xArray.push(series[i]['time'])
				that.yArray.push(series[i]['value'])
			}

			that.max = d3.max(that.yArray, function(d, i) {

				return Math.ceil(d)
			})

		} else if (yScale === 'ordinal') {

			for (var i = 0, n = series.length; i < n; i++) {

				that.xArray.push(series[i]['value'])
				that.yArray.push(series[i]['type'])
			}

			that.max = d3.max(that.xArray, function(d, i) {

				return Math.ceil(d)
			})
		}
	}

	Chart.prototype._createSvg = function() {

		d3.select(this.selector).selectAll('svg').remove()

		this.svg = d3.select(this.selector)
			.append('svg')
			.attr('width', this.width)
			.attr('height', this.height)
	}

	Chart.prototype._createAxis = function() {

		var that = this,
			xScale = that.xAxisSetting.scale,
			yScale = that.yAxisSetting.scale,
			xAxisShow = that.xAxisSetting.show,
			yAxisShow = that.yAxisSetting.show,
			xAxisOrient = that.xAxisSetting.orient,
			yAxisOrient = that.yAxisSetting.orient

		if (xScale === 'ordinal') {

			that.xScale = d3.scale.ordinal()
				.domain(that.xArray)
				.rangeBands([0, that.contentW], 0.5)

			that.rangeBand = that.xScale.rangeBand()

		} else if (xScale === 'linear') {

			that.xScale = d3.scale.linear()
				.domain([0, that.max])
				.range([0, that.contentW])
		}


		if (yScale === 'ordinal') {

			that.yScale = d3.scale.ordinal()
				.domain(that.yArray)
				.rangeBands([that.contentH,0], 0.5)

			that.rangeBand = that.yScale.rangeBand()

		} else if (yScale === 'linear') {

			that.yScale = d3.scale.linear()
				.domain([0, that.max])
				.range([that.contentH,0])
		}

		if (yAxisShow) {

			if (yScale === 'ordinal') {

				that.yAxis = d3.svg.axis()
					.scale(that.yScale)
					.tickValues(that.yArray)
					.orient(yAxisOrient)

			} else if (yScale === 'linear') {

				that.yAxis = d3.svg.axis()
					.scale(that.yScale)
					.orient(yAxisOrient)
					.ticks(7)
					.tickFormat(function(d) {
						return d
					})
			}

		that.svg.append('g')
			.attr('class', 'axis yAxis')
			.attr('transform', 'translate(' + that.margin.left + ',' + that.margin.top + ')')
			.call(that.yAxis)

		}

		if (xAxisShow) {

			if (xScale === 'linear') {

				that.xAxis = d3.svg.axis()
					.scale(that.xScale)
					.orient(xAxisOrient)
					.ticks(7)
					.tickFormat(function(d) {
						return d
					})
			} else if (xScale === 'ordinal') {

				that.xAxis = d3.svg.axis()
					.scale(that.xScale)
					.tickValues(that.xArray)
					.orient(xAxisOrient)
			}


			that.svg.append('g')
				.attr('class', 'axis xAxis')
				.attr('transform', 'translate(' + that.margin.left + ',' + (that.height - that.margin.bottom) + ')')
				.call(that.xAxis)
		}

/*		that.svg.append('g')
			.attr('class', 'axis xAxis')
			.attr('transform', 'translate(' + that.margin.left + ',' + (that.height - that.margin.bottom - 20) + ')')
			.call(that.xAxis)

		that.svg.append('text')
			.attr('transform', 'translate(' + (that.margin.left + 20) + ',' + (that.height - that.margin.bottom) + ')')
			.text('(/条)')

		that.svg.selectAll('.axis xAxis')
			.select('path')
			.style('stroke-width', 2)

		that.svg.selectAll('.axis xAxis')
			.selectAll('line')
			.style('stroke', '#e2e2e4')
			.style('stroke-width', 2)*/
	}

	Chart.prototype._create = function() {

		var type = this.type,
			that = this

		that._initArray()
		that._createSvg()
		that._createAxis()

		switch (type) {

			case 'leftBar':

				var rectCon = that.svg.append('g')
					.attr('class', 'rectCon')
					.attr('transform', 'translate(' + (that.margin.left) + ',' + 0 + ')')

				var rects = rectCon.append('g')
					.attr('class', 'rects')

				var texts = rectCon.append('g')
					.attr('class', 'texts')

				var node = rects.selectAll('g')
					.data(that.series)
					.enter()
					.append('g')
					.attr('class', 'node')

				node
					.append('rect')
					.attr('class', function(d, i) {

						$(this).data('type', d['type'])
						$(this).data('id', d['id'])
						$(this).data('color', that.colorset[i])

						if (d['value'] < 10) {

							$(this).data('canClick', false)
						} else {

							$(this).data('canClick', true)
						}
						return 'leftBarRect'
					})
					.attr('fill', function(d, i) {

						return that.colorset[i]
					})
					.on('mouseover', function(d) {

						d3.select(this).attr('opacity', 0.7)
					})
					.on('mouseout', function(d) {

						d3.select(this).attr('opacity', 1.0)
					})
					.attr('x', function(d, i) {

						return that.xScale(0)
					})
					.attr('y', function(d) {


						return that.yScale(d['type'])
					})
					.attr('cursor', 'pointer')
					.attr('width', function(d, i) {

						return that.xScale(0)
					})
					.attr('height', 20)
					.transition()
					.duration(1500)
					.attr("y", function(d, i) {

						return that.yScale(d['type'])
					})
					.attr('width', function(d, i) {

						return that.xScale(d['value'])
					})

				node.append("svg:title")
					.attr('class', 'rectTitle')
					.text(function(d) {
						return d['value'] + '条'
					})
					.style('fill', 'red')

				var nodetext = texts.selectAll('g')
					.data(that.series)
					.enter()
					.append('g')
					.attr('class', 'node')

				nodetext
					.append('text')
					.attr('cursor', 'pointer')
					.attr('class', 'leftBarText')
					.attr('text-anchor', 'end')
					.attr('x', function(d, i) {
						return that.xScale(0) - 10
					})
					.style('fill', function(d, i) {

						var type = Interaction.type

						if (d['type'] == type) {

							return that.colorset[i]
						} else {

							return '#333'
						}

					})
					.attr("y", function(d, i) {

						$(this).data('type', d['type'])
						$(this).data('id', d['id'])
						$(this).data('color', that.colorset[i])

						if (d['value'] < 10) {

							$(this).data('canClick', false)
						} else {

							$(this).data('canClick', true)
						}

						return that.yScale(d['type']) + that.rangeBand
					})
					.text(function(d, i) {
						return d['type']
					})
					.style('text-align', 'right')


				nodetext.append("svg:title")
					.text(function(d) {
						return d['value'] + '条'
					})

				break;
			case 'timeLine':

				var area = d3.svg.area()
					.x(function(d, i) {

						return that.xScale(that.xArray[i])
					})
					.y0(that.height - that.margin.top - that.margin.bottom)
					.y1(function(d, i) {
						return that.yScale(d['value']);
					})
					.interpolate("cardinal");

				var linePath = d3.svg.line()
					.x(function(d, i) {

						return that.xScale(that.xArray[i])
					})
					.y(function(d, i) {

						return that.yScale(d['value']);
					})
					.interpolate("basic")

				that.svg.append("clipPath")
					.attr("id", "content-brokeArea")
					.append("rect")
					.attr("x", -10)
					.attr("y", -10)
					.attr("height", that.height)
					.attr("width", 10)
					.transition()
					.duration(1500)
					.ease('bounce')
					.attr("width", that.width)

				var content = that.svg.append("g")
					.attr("class", "lineArea")
					.attr("clip-path", "url(#content-brokeArea)")
					.attr("transform", "translate(" + that.margin.left + "," + that.margin.top + ")")

				var pct = that.svg.select(".lineArea")
					.append("g")
					.attr("class", "pct")

				pct.append("path")
					.datum(that.series)
					.attr("d", area)
					.style("fill", function(d, i) {

						return that.colorset[1]
					})
					.style("opacity", "0.7")

				content.append('path')
					.datum(that.series)
					.attr("stroke", function(d, i) {

						return that.colorset[0];
					})
					.attr('stroke-width', 2)
					.attr("d", linePath)
					.style('fill', 'none')

					break;
			case 'pieArea':
				break;
			default:
		}

	}

	Chart.prototype._bindEvent = function() {

	}

	Chart.prototype.init = function() {

		this._create()
		this._bindEvent()
	}

	module.exports = Chart
})