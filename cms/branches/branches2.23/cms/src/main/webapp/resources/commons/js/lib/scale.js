/* 
 * @Author: Administrator
 * @Date:   2015-12-25 15:25:37
 * @Last Modified by:   Administrator
 * @Last Modified time: 2015-12-29 11:54:22
 */

'use strict';
define(function(require, exports, module) {

	var Debounce = require('../../js/util/debounce')

	var Event = require('../../js/util/event')

	function Scale(option) {

		this.selector = document.getElementById(option.selector)
		this.handle = document.getElementById(option.handle)
		this.height = $(this.selector).height() - $(this.handle).height()
		this.newScroll = null
		this.range = null
		this.value = option.value
		this.resizeDom = false
		this.pos = null
	}

	Scale.prototype._setPosition = function(pos) {


		var that = this

		that.range = 20

		that.pos = pos || (this.value / this.range) * (that.height)

		if (that.pos < 19) {

			that.pos = 19
		}

		if (that.pos > that.height - 18) {

			that.pos = that.height - 18
		}

		that.handle.style.top = that.pos + 'px'
	}

	Scale.prototype._bindEvent = function() {

		var that = this

		$(that.handle).on('mousedown', function(e) {

			$(this).addClass('selected')

			var top = that.handle.offsetTop

			that.start = {
				x: e.pageX,
				y: e.pageY
			}

			$(document).on('mousemove', function(e) {

				that.endPos = {
					x: e.pageX,
					y: e.pageY
				}

				var newscroll = top + that.endPos.y - that.start.y

				that._setPosition(newscroll)
			})

		})

		$(document).on('mouseup', function() {

			$(document).off('mousemove')
		})

		$(that.handle).on('mouseup', function() {

			$(this).removeClass('selected')

			Event.trigger('scaleChange', 1);
		})
	}

	Scale.prototype.init = function(callback) {

		this._setPosition()
		this._bindEvent()

		if (callback) {

			callback && callback()
		}
		return this
	}

	module.exports = Scale
})