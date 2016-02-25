
/* 
* @Author: Micheal
* @Date:   2015-12-17 21:34:46
* @Last Modified by:   Administrator
* @Last Modified time: 2016-01-04 08:35:54
*/

'use strict';

define(function(require,exports,module) {


	//var $ = require('jquery')

	var Interaction = window.Interaction

	function Calendar(option) {

		this.selector = option.selector
		this.selctInput = option.input
		this.selectCon = option.selectCon
		this.selectDom = null
		this.year = parseInt(option.year)
		this.month = parseInt(option.month)
		this.leftBtn = null
		this.rightBtn = null
		this.yearDom = null
		this.monthCon = null
		this.type = option.type
		this.left = option.left || "0"
		this.yearEnd = new Date().getFullYear()
		this.cursor = option.cursor
		this.value = option.value
	}

	Calendar.prototype._createDom = function() {

		var that = this

		$(that.selector).css('position','relative')
		$(that.selectDom).remove()

		that.selectDom = $('<div class="calendar"></div>')
			.attr('id',that.selectCon)
			.css({
				top:$(that.selctInput)[0].offsetHeight,
				left:that.left,
				position:'absolute',
				width:'204px',
				height:'120px',
				display:'none'
			}).appendTo(that.selector)

		var yearWrapper = $('<div></div>')
			.addClass('yearWrapper')
			.appendTo(that.selectDom)
		
		that.leftBtn = $('<i></i>')
			.addClass('leftBtn')
			.appendTo(yearWrapper)

		console.log(that.year,that.month)
		that.yearDom = $('<div></div>')
			.addClass('yearCon')
			.html(that.year).appendTo(yearWrapper)

		that.rightBtn = $('<i></i>')
			.addClass('rightBtn')
			.appendTo(yearWrapper)

		that.monthCon = $('<div></div>')
			.addClass('monthCon')
			.appendTo(that.selectDom)

		that._addMonth(that.monthCon)
	}
	
	Calendar.prototype._getLeftAndRightVal = function(parm) {

		var that = this,
			timeArray = that._getTimeRange(),
			index = timeArray.indexOf(parm)

		return index
	}

	Calendar.prototype._getTimeRange = function() {

		var that = this
		var leftYear = 2001,
			rightYear = parseInt(new Date().getFullYear()),
			leftMonth = 1,
			rightMonth = 12,
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

	Calendar.prototype.update = function() {

		var that = this
		var year = $(that.selctInput).val().toString().substr(0,4),
			month = $(that.selctInput).val().toString().substr(5,2)

		if (that.year !== year || that.month !== month) {

			that.year = parseInt(year)
			that.month = parseInt(month)
		}

		that._createDom()
	}

	Calendar.prototype._addMonth = function(parm) {

		var monthArray = ['01','02','03','04','05','06','07','08','09','10','11','12'];
		
		for (var i=0; i < monthArray.length; i++) {

			var li = $('<li></li>')
				.addClass('cMonth')
				.data('month',monthArray[i])
				.html('<a href="#">'+ parseInt(monthArray[i])+'月</a>')
				.appendTo(parm)
		}
	}

	Calendar.prototype._bindEvent = function() {

		var that = this

		$(that.cursor).on('click',function(e) {

			var e = e || window.event,
				display = $(that.selectDom).css('display')

			$('.calendar').hide()

			if (display === 'none') {
				$(that.selectDom).slideDown('fast')
			}
		})

		$(that.rightBtn).on('click',function(e) {

			var e = e || window.event

			if (that.type === 'startTime') {

				if (that.year < 2013) {

					that.year = that.year + 1
				}

			} else if(that.type === 'endTime'){

				if (that.year < 2015) {

					that.year = that.year + 1
				}
			}
		
			$(that.yearDom).html(that.year)

		})

		$(that.leftBtn).on('click',function(e) {

			var e = e || window.event

 			if (that.type === 'endTime') {

				if (that.year >= 2002) {
					that.year = that.year - 1
				}
			} else if(that.type === 'startTime'){
				if (that.year > 2001) {
					that.year = that.year - 1
				}
			}
	
			$(that.yearDom).html(that.year)

			e.preventDefault()
			e.stopPropagation()
		})

		$(that.monthCon).find('li').on('click',function(e) {

			
			var month = $(this).data('month')

			that.month = month

			var timeArray = that._getTimeRange()

			var value = that._getLeftAndRightVal(that.value)


			if (that.type === 'startTime') {

				var loalMonth = that.month

				if (that.year > 2013 && loalMonth-0 >= 1) {

					that.year = 2013
					that.month = 12

					$(that.monthCon).find('li:last').addClass('selected').siblings().removeClass('selected')
					$(that.selctInput).val(that.year+'.'+that.month)
					$(that.yearDom).html(that.year)
					$(that.selectDom).slideUp('fast')

				} else {

					$(this).addClass('selected').siblings().removeClass('selected')
					$(that.selctInput).val(that.year+'.'+that.month)
					$(that.selectDom).slideUp('fast')
				}

			} else if (that.type === 'endTime') {

				var localMonth1 = that.month

				if (that.year <= 2002 && localMonth1 <= 12) {

					that.year = 2002
					that.month = 12

					$(that.monthCon).find('li:first').addClass('selected').siblings().removeClass('selected')
					$(that.selctInput).val(that.year+'.'+that.month)
					$(that.yearDom).html(that.year)
					$(that.selectDom).slideUp('fast')

				} else if (that.year == new Date().getFullYear() && that.month == new Date().getMonth() +1) {

					that.year = parseInt(new Date().getFullYear())
					that.month = parseInt(new Date().getMonth())

					$(that.selectDom).slideUp('fast')
				} else {

					$(this).addClass('selected').siblings().removeClass('selected')
					$(that.selctInput).val(that.year+'.'+that.month)
					$(that.selectDom).slideUp('fast')
				}
			}

			e.stopPropagation()
			e.preventDefault()

			that.onClose()
		})
	}

	Calendar.prototype.onClose = function(callback) {

		var that = this
		var close = {
			year:this.year,
			month:this.month
		}

		if (this.type === 'startTime') {

			if (JSON.stringify(close) !== JSON.stringify(Interaction.leftStartTime)) {

				var timeArray = that._getTimeRange(),
					value = that.year.toString()+that.month.toString(),
					index = that._getLeftAndRightVal(value)

				var endTime = timeArray[index + 23]

				Interaction.leftStartTime.year = close.year
				Interaction.leftStartTime.month = close.month

				Interaction.leftEndTime.year = endTime.substr(0,4)
				Interaction.leftEndTime.month = endTime.substr(4,2)

				var parm = {
					leftTime: Interaction.leftStartTime.year + Interaction.leftStartTime.month,
					rightTime: Interaction.leftEndTime.year+Interaction.leftEndTime.month
				}

				Interaction.initYearZoom()

				$('#dateRight').val(Interaction.leftEndTime.year+'.'+Interaction.leftEndTime.month)
				
				Interaction.getLeftDate()
				Interaction.getFullDate('second',parm)
			}

		} else if (this.type === 'endTime') {

			if (JSON.stringify(close) !== JSON.stringify(Interaction.leftEndTime)) {

				var timeArray = that._getTimeRange(),
					value = that.year.toString()+that.month.toString(),
					index = that._getLeftAndRightVal(value)

				var startTime = timeArray[index - 23]

				Interaction.leftStartTime.year = startTime.substr(0,4)
				Interaction.leftStartTime.month = startTime.substr(4,2)

				Interaction.leftEndTime.year = close.year
				Interaction.leftEndTime.month = close.month

				console.log(that.value,startTime,Interaction.leftEndTime)

				var parm = {
					leftTime: Interaction.leftStartTime.year + Interaction.leftStartTime.month,
					rightTime: Interaction.leftEndTime.year+Interaction.leftEndTime.month
				}

				Interaction.initYearZoom()

				$('#dateLeft').val(Interaction.leftStartTime.year+'.'+Interaction.leftStartTime.month)
				Interaction.getLeftDate()
				Interaction.getFullDate('second',parm)
			}			
		}

		Interaction.initDataZoom()

		if (callback) {

			callback && callback()
		}
	}

	Calendar.prototype.init = function() {

		if (!this.leftBtn) {
			this._createDom()
		}
		
		this._bindEvent()
	}

	module.exports = Calendar
})