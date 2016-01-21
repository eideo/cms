/* 
 * @Author: Administrator
 * @Date:   2015-11-30 17:36:46
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-21 09:59:40
 */

define(function(require, exports, module) {

	var IndustryChart = require('../../js/chart/industryChart')

	var kxdbmarquee = require('kxdbmarquee')

	var Interaction = require('../../js/public/getDate')

	window.Interaction = Interaction

	var DataZoom = require('../../js/lib/dataZoom')

	var Calendar = require('../../js/lib/calendar')

	var Debounce = require('../../js/util/debounce')

	var ChartConfig = require('./chartConfig')

	var ArraySort = function(array) {

		return array.sort(function(a, b) {

			return b.value - a.value;
		});
	}

	function initDataZoom() {

		$('#dateLeft').val(Interaction.leftStartTime.year + '.' + Interaction.leftStartTime.month)
		$('#dateRight').val(Interaction.leftEndTime.year + '.' + Interaction.leftEndTime.month)

		var option = {
			selector: '#startTime',
			input: '#dateLeft',
			cursor:"#startTime .daShow",
			type:'startTime',
			year:Interaction.leftStartTime.year,
			month:Interaction.leftStartTime.month,
			selectCon: '#myConLeft',
			value:'201312'
		}

		var option1 = {
			selector: '#endTime',
			input: '#dateRight',
			cursor:"#endTime .daShow",
			selectCon: '#myConRight',
			type:'endTime',
			year:Interaction.leftEndTime.year,
			month:Interaction.leftEndTime.month,
			value:'201511',
			left:'-118px'
		}


		var myCalendar = new Calendar(option)
		myCalendar.init()

		var myCalendar1 = new Calendar(option1)
		myCalendar1.init()
	}

	function initYearZoom() {
		
		// 滑动块初始化
		var dataZoomObj = {
			selector: 'timeRange',
			handle: 'timeHandle',
			show:'timeShow',
			rangeStartTime:Interaction.rangeStartTime,
			rangeEndTime:Interaction.rangeEndTime,
			timeStart: {
				year:Interaction.leftStartTime.year,
				month:Interaction.leftStartTime.month
			},
			timeEnd:{
				year:Interaction.leftEndTime.year,
				month:Interaction.leftEndTime.month
			}
		}
 
		var dataZoom = new DataZoom(dataZoomObj)

		if (!dataZoom.init()) {

			dataZoom.init()
		} else {

			dataZoom.upDate()
		}
	}

	function getLeftBar() {

		var startTime = Interaction.leftStartTime,
			endTime = Interaction.leftEndTime

		var lyear = startTime.year,
			lmonth = startTime.month,
			ryear = endTime.year,
			rmonth = endTime.month,
			informationType = Interaction.informationType

		var informationDist = lyear + lmonth + '-' + ryear + rmonth

		$.ajax({
			url: path + '/primaryIndustry',
			data: {
				startDate: lyear + lmonth,
				endDate: ryear + rmonth,
				informationType:informationType
			},
			type: "POST",
			dataType: "json",
			success: function(data) {

				ChartConfig.leftBarSetting.series = data
				ChartConfig.leftBarSetting.industryClicked = Interaction.industryClicked
				
				IndustryChart.leftBar(ChartConfig.leftBarSetting)	
			}
		})
	}

	function getFullDate(parm, newTime) {

		var leftTime,
			rightTime

		if (newTime === undefined) {

			leftTime = Interaction.leftStartTime.year + Interaction.leftStartTime.month
			rightTime = Interaction.leftEndTime.year + Interaction.leftEndTime.month
		} else {

			leftTime = newTime.leftTime
			rightTime = newTime.rightTime
		}

		var type = Interaction.id,
			startDate = leftTime,
			endDate = rightTime,
			informationType = Interaction.informationType

		$.ajax({
			url: path + '/industryInformation ',
			data: {
				id: type,
				startDate: startDate,
				endDate: endDate,
				informationType: informationType
			},
			type: "POST",
			dataType: "json",
			success: function(data) {

				if (parm === 'third') {

					// 信息数量分布
					ChartConfig.timeLineSetting.series = data.informationDist
					ChartConfig.timeLineSetting.type = Interaction.type
					IndustryChart.timeLine(ChartConfig.timeLineSetting)

				} else if (parm === 'second') {

					// 信息数量分布
					ChartConfig.timeLineSetting.series = data.informationDist
					ChartConfig.timeLineSetting.type = Interaction.type
					IndustryChart.timeLine(ChartConfig.timeLineSetting)
					

					//信息类型占比
					ChartConfig.pieAreaSetting.series = data.informationType
					ChartConfig.pieAreaSetting.type = Interaction.informationType
					IndustryChart.pieArea(ChartConfig.pieAreaSetting)

				} else {

					// 信息数量分布
					ChartConfig.timeLineSetting.series = data.informationDist
					IndustryChart.timeLine(ChartConfig.timeLineSetting)
					

					//信息类型占比
					ChartConfig.pieAreaSetting.series = data.informationType
					ChartConfig.pieAreaSetting.type = Interaction.informationType
					IndustryChart.pieArea(ChartConfig.pieAreaSetting)
				}

				// 景气指数
				ChartConfig.singleSetting.series = data.boomIndex
				ChartConfig.singleSetting.industry = Interaction.type
				ChartConfig.singleSetting.chartColor = Interaction.chartColor
				IndustryChart.singleLine(ChartConfig.singleSetting)

				// 关注指数
				ChartConfig.barSetting.series = data.concernedIndex
				ChartConfig.barSetting.industry = Interaction.type
				ChartConfig.barSetting.chartColor = Interaction.chartColor
				IndustryChart.lengthBar(ChartConfig.barSetting)


				// 排序，取最高的前10名
				var userSegm = ArraySort(data.userSegm).splice(0, 10)
					// 用户细分
				ChartConfig.mapSetting.series = userSegm
				IndustryChart.chinaMap(ChartConfig.mapSetting, function() {

					var selector = d3.select('.userCon .left').select('.barCon')

					IndustryChart.mapBar(selector, ChartConfig.mapSetting.series, ChartConfig.mapSetting.colorset)
				})

				// 行业占比
				ChartConfig.raderSetting.series = data.industryAccounted
				ChartConfig.raderSetting.industry = Interaction.type
				IndustryChart.radarBar(ChartConfig.raderSetting)

				//竞争力占比
				ChartConfig.sevenSetting.series = data.competeAccounted
				ChartConfig.sevenSetting.industry = Interaction.type
				IndustryChart.sevenBar(ChartConfig.sevenSetting)
			}
		})
	}

	function loadReportData() {

		var industryId = Interaction.id
		var startDate = Interaction.leftStartTime.year + Interaction.leftStartTime.month
		var endDate = Interaction.leftEndTime.year + Interaction.leftEndTime.month

		$('.reportCon .left .large').html(Interaction.type + '行业')

		$.ajax({
			url: path + '/getRanking',
			data: {
				type: 4,
				industry: industryId,
				startDate: startDate,
				endDate: endDate
			},
			type: "POST",
			dataType: "json",
			success: function(data) {

				$('#leftList').html('')

				var num,
					canScroll

				data.rankingDatas.length > 7 ? num = 7:num = data.rankingDatas.length
				data.rankingDatas.length >= 5 ? canScroll = true :canScroll = false

				if (data.status && data.rankingDatas.length) {

					var rankingDatas = data.rankingDatas

					for (var i = 0; i < num; i++) {

						var $li = $('<li></li>')
							.appendTo($('#leftList'))

						var $mi = $('<i></i>')
							.addClass("rank" + (i + 1))
							.appendTo($li)

						var $rankT = $('<div class="rankT"></div>')
							.html(rankingDatas[i].name)
							.data('id', rankingDatas[i].id)
							.appendTo($li)

						var $up = $('<div></div>')
							.addClass('up')
							.html(rankingDatas[i].countNow + '')
							.appendTo($li)

					}
				}

				if (canScroll) {

					$("#leftListCon").kxbdMarquee({direction:"up",isEqual:false,scrollDelay:60})
				}				
			}
		})
		//end ajax
		$('.rankT').live('click',function(e) {

			var id = $(this).data('id'),
				name = $(this).html(),
				eName = encodeURIComponent(name)
			window.location.href = path + '/relation?name='+eName+'&&id='+id+'&&type=company'
		})

		$('.left .list .more').on('click', function() {
			window.location.href = '/relation'
		})
	}

	function loadReportTop5() {

		$('.li6 .more').on('click', function() {
			window.location.href = '/report/'+Interaction.id;
		})

		var induxtry = Interaction.id
		$.ajax({
			url: path + '/report/getListTop5',
			data: {
				induxtry: induxtry
			},
			type: "POST",
			dataType: "json",
			success: function(data) {

				if (data.success) {

					var reportList = data.reportList

					$('.li1').html('')
					$('.li2').html('')
					$('.li3').html('')
					$('.li4').html('')
					$('.li5').html('')

					$('.reportCon .right .mTop .mtitle').html(Interaction.type + '行业')

					for (var i = 0; i < reportList.length; i++) {

						var mi = $('<i></i>').addClass('i' + (i + 1))
							.appendTo($('.li' + (i + 1)))

						var bTitle = $('<div class="bTitle"></div>')
							.html(reportList[i]['reportTitle'])
							.attr('title',reportList[i]['reportTitle'])
							.data('reportTitle', reportList[i]['reportTitle'])
							.data('id', reportList[i]['id'])
							.appendTo($('.li' + (i + 1)))

						var trimStr = reportList[i]['subReportAbstract']
						var subText = trimStr.substr(0,47) +'...'
		
						var bText = $('<div class="bText"></div>')
							.html(subText)
							.appendTo($('.li' + (i + 1)))

					}

				}

			}
		})

		// 事件
		$('.bTitle').live('click', function(e) {

			var e = e || window.event,
				id = $(this).data('id')
			window.location.href = '/reportdetail/' + id
		})
	}

	$(function() {

		Interaction.getFullDate = getFullDate
		Interaction.getLeftDate = getLeftBar
		Interaction.initYearZoom = initYearZoom
		Interaction.type = "房地产建筑";
		Interaction.id = "2108";
		
		getLeftBar()
		getFullDate()
		initYearZoom()
		loadReportData()
		loadReportTop5()

		$('#chart1 .leftBarRect').live('click', function(e) {

			var e = e || window.event,
				type = $(this).data('type'),
				id = $(this).data('id'),
				color = $(this).data('color'),
				canClick = $(this).data('canClick'),
				index = $(this).parent().index()

			if (!canClick) {

				return
			}

			d3.selectAll('#chart1 .leftBarText').style('fill', '#333')
			d3.select('#chart1 .texts g:nth-child(' + (index + 1) + ')').select('.leftBarText').style('fill', color)

			Interaction.type = type
			Interaction.id = id
			Interaction.chartColor = color
			Interaction.industryClicked = true

			Debounce.throttle(getFullDate())
			Debounce.throttle(loadReportData())
			Debounce.throttle(loadReportTop5())

			e.preventDefault()
			e.stopPropagation()
		})

		$('#chart1 .leftBarText').live('click', function(e) {

			var e = e || window.event,
				type = $(this).data('type'),
				html = $(this).text(),
				id = $(this).data('id'),
				canClick = $(this).data('canClick'),
				color = $(this).data('color'),
				index = $(this).parent().index()

			if (!canClick) {

				d3.select(this).style('cursor','default')
				return
			}

			d3.selectAll('#chart1 .texts .leftBarText').style('fill', '#333')
			d3.select($(this)[0]).style('fill', color)

			Interaction.type = html
			Interaction.id = id
			Interaction.chartColor = color
			Interaction.industryClicked = true
			
			Debounce.throttle(getFullDate())
			Debounce.throttle(loadReportData())
			Debounce.throttle(loadReportTop5())

			e.preventDefault()
			e.stopPropagation()
		})

		$('#chart3 .arcSelect').live('click', function(e) {

			var e = e || window.event,
				type = $(this).data('type'),
				color = $(this).data('color'),
				index = $(this).parent().index()

			d3.selectAll('#chart3 .legends .legendText').style('fill', '#333').style('font-weight','normal')
			d3.select('#chart3 .legends g:nth-child('+(index+1)+')').select('.legendText').style('fill', color).style('font-weight','bold')

			Interaction.informationType = type

			getLeftBar()
			getFullDate('third')

			e.preventDefault()
			e.stopPropagation()
		})
	})

	module.exports = ''
})