/* 
 * @Author: Micheal
 * @Date:   2015-11-28 15:46:08
 * @Last Modified by:   Administrator
 * @Last Modified time: 2016-01-04 11:18:14
 */

'use strict';
define(function(require, exports, module) {

	//var $ = require('jquery')

	var Interaction = window.Interaction

	function DataZoom(option) {

		this.selector = document.getElementById(option.selector)
		this.handleDom = option.handle
		this.handle = document.getElementById(option.handle)
		this.handleShow = option.show
		this.width = $(this.selector).width()
		this.handleWidth = option.handleWidth
		this.range = null
		this.value = null
		this.rightValue = null
		this.rangeStart = {
				year: '2001',
				month: '01'
			},
			this.rangeEnd = {
				year: new Date().getFullYear(),
				month: new Date().getMonth()
			}
		this.timeStart = option.timeStart
		this.timeEnd = option.timeEnd
		this.leftTime = null
		this.rightTime = null
	}

	DataZoom.prototype._getTimeRange = function() {

		var that = this
		var leftYear = parseInt(that.rangeStart.year),
			rightYear = parseInt(that.rangeEnd.year),
			leftMonth = parseInt(that.rangeStart.month),
			rightMonth = parseInt(that.rangeEnd.month),
			leftTime,
			rightTime,
			diffYear = rightYear - leftYear

		var timeArray = []

		if (diffYear > 1) {

			for (var a = leftMonth; a <= 12; a++) {

				if (a < 10) {

					timeArray.push(leftYear.toString() + '0' + a.toString())
				} else {

					timeArray.push(leftYear.toString() + a.toString())
				}
			}

			for (var b = leftYear + 1; b < rightYear; b++) {

				for (var c = 1; c < 10; c++) {

					timeArray.push(b.toString() + '0' + c.toString())
				}

				for (var d = 10; d <= 12; d++) {

					timeArray.push(b.toString() + d.toString())
				}
			}

			for (var e = 1; e <= rightMonth; e++) {

				if (e < 10) {

					timeArray.push(rightYear.toString() + '0' + e.toString())
				} else {

					timeArray.push(rightYear.toString() + e.toString())
				}
			}

		} else {

			for (var j = leftMonth; j <= 12; j++) {

				if (j < 10) {

					timeArray.push(leftYear.toString() + '0' + j.toString())
				} else {

					timeArray.push(leftYear.toString() + j.toString())
				}
			}

			for (var i = 1; i <= rightMonth; i++) {

				if (i < 10) {

					timeArray.push(rightYear.toString() + '0' + i.toString())
				} else {

					timeArray.push(rightYear.toString() + i.toString())
				}
			}
		}


		return timeArray
	}

	DataZoom.prototype._getRange = function() {

		var timeArray = this._getTimeRange()

		return timeArray.length
	}

	DataZoom.prototype._getLeftAndRightVal = function() {

		var that = this,
			timeArray = that._getTimeRange(),
			timeStr = $('#' + that.handleShow).html().toString(),
			leftTime = Interaction.leftStartTime.year.toString()+ Interaction.leftStartTime.month.toString(),
			rightTime = Interaction.leftEndTime.year.toString() + Interaction.leftEndTime.month.toString(),
			leftValue = timeArray.indexOf(leftTime),
			rightValue = timeArray.indexOf(rightTime)

		return {
			leftValue: leftValue,
			rightValue: rightValue
		}
	}

	DataZoom.prototype._setPosition = function(direction, pos) {

		var that = this
			that.range = that._getRange()
		var timeArray = that._getTimeRange()
	
		var va = that._getLeftAndRightVal()
			
		that.value = va.leftValue,
		that.rightValue = va.rightValue

		if (pos < 0) {

			pos = 0
		}

		if (pos > this.width - 44) {

			pos = that.width - 44
		}

		that.handle.style.left = pos + 'px'

		if (direction === undefined) {

			that.handle.style.left = (that.value / that.range)*that.width + 'px'

		} else {

			that.value = Math.round(that.range * (pos / that.width))
		}
		

		var leftTime = timeArray[that.value],
		    rightTime = timeArray[parseInt(that.value) + 23]

		$('#' + that.handleShow).html(leftTime + '-' + rightTime)

		var lyear = leftTime.substr(0, 4),
			lmonth = leftTime.substr(4, 2),
			ryear = rightTime.substr(0, 4),
			rmonth = rightTime.substr(4, 2)

		that.leftTime = lyear + lmonth
		that.rightTime = ryear + rmonth

		Interaction.leftStartTime.year = lyear
		Interaction.leftStartTime.month = lmonth
		Interaction.leftEndTime.year = ryear
		Interaction.leftEndTime.month = rmonth

	}

	DataZoom.prototype.upDate = function() {

		this._setPosition()
	}

	DataZoom.prototype.getPosition = function(callback) {

		if (callback) {

			callback && callback()
		}
	}

	DataZoom.prototype._bindEvent = function() {

		var that = this

		$(that.handle).on('mousedown', function(e) {

			var left = that.handle.offsetLeft

			that.start = {
				x: e.pageX,
				y: e.pageY
			}

			$(document).on('mousemove', function(e) {

				that.endPos = {
					x: e.pageX,
					y: e.pageY
				}

				var newscroll = left + that.endPos.x - that.start.x

				that._setPosition('scroll', newscroll)
			})

		})

		$(document).on('mouseup', function() {

			$(document).off('mousemove')
		})

		$(that.handle).on('mouseup', function() {

			
			var parm = {
				leftTime: that.leftTime,
				rightTime: that.rightTime
			}

			$('#dateLeft').val(Interaction.leftStartTime.year + '.'+Interaction.leftStartTime.month)
			$('#dateRight').val(Interaction.leftEndTime.year + '.'+Interaction.leftEndTime.month)
			Interaction.getLeftDate()
			Interaction.getFullDate('second', parm)
		})
	}

	DataZoom.prototype.init = function(callback) {

		this._setPosition()
		this._bindEvent()

		if (callback) {

			callback && callback()
		}
		return this
	}

	module.exports = DataZoom
})