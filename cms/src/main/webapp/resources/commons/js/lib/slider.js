/* 
 * @Author: Micheal
 * @Date:   2015-11-28 15:46:08
 * @Last Modified by:   Administrator
 * @Last Modified time: 2015-12-28 16:57:10
 */
define(function(require, exports, module) {

	var Debounce = require('../../js/util/debounce')

	var Event = require('../../js/util/event')

	function Slider(option) {

		this.selector = document.getElementById(option.selector)
		this.handle = document.getElementById(option.handle)
		this.width = $(this.selector).width() - $(this.handle).width()
		this.newScroll = null
		this.offLeft = 30
		this.range = null
		this.value = option.value
		this.showDom = option.dom || null
		this.resizeDom = false
		this.pos = null
		this.leftTime = null
		this.rightTime = null
	}

	Slider.prototype._setPosition = function(pos) {


		var that = this,
			timeArray = that._getTimeRange()

		that.range = timeArray.length - 24

		that.pos = pos || (this.value / this.range) * (that.width)

		if ( that.pos < 0) {

			that.pos = 0
		}

		if (that.pos > that.width) {

			that.pos = that.width
		}

		that.handle.style.left = that.pos + 'px'

		$(that.showDom).css('left',(that.pos-28) +'px')

		that.value = Math.round(that.range * (that.pos / that.width))

		var value = timeArray[that.value],
			rightValue = timeArray[that.value + 23]

		that.leftTime = value
		that.rightTime = rightValue

		$(that.showDom).html(value.substr(0,4)+'.'+value.substr(4,2)+'-'+rightValue.substr(0,4)+'.'+rightValue.substr(4,2))
	}

	Slider.prototype.getPosition = function(callback) {

		if (callback) {

			callback && callback()
		}

		return this.value
	}

	Slider.prototype._bindEvent = function() {

		var that = this

		$(that.handle).on('mousedown', function(e) {

			$(this).addClass('selected')

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

				that._setPosition(newscroll)
			})

		})

		$(document).on('mouseup', function() {
	
			$(document).off('mousemove')
		})

		$(that.handle).on('mouseup',function() {
			
			$(this).removeClass('selected')

			Event.trigger('timeChange',[that.leftTime,that.rightTime]);
		})
	}

	Slider.prototype._getTimeRange = function() {

		var that = this
		var leftYear = 2001,
			rightYear = parseInt(new Date().getFullYear()),
			leftMonth = 1,
			rightMonth = parseInt(new Date().getMonth()),
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

	Slider.prototype.init = function(callback) {

		this._setPosition()
		this._bindEvent()

		if (callback) {

			callback && callback()
		}
		return this
	}

	module.exports = Slider
})