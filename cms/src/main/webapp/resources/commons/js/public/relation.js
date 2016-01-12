/* 
 * @Author: Administrator
 * @Date:   2015-11-18 15:50:00
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-12 10:13:37
 */

'use strict';

define(function(require, exports, module) {

	var nicescroll = require('niceScroll')

	var Slider = require('../../js/lib/slider')

	var Scale = require('../../js/lib/scale')

	var Debounce = require('../../js/util/debounce')

	var kxdbmarquee = require('kxdbmarquee')

	var AjaxObj = {
		type: 0,
		smallName: '',
		name: '',
		companyRole: '业主',
		personRole: '项目负责人',
		startDate: '201312',
		endDate: '201511',
		rolesName: '',
		rolesType: 'company',
		industryId:'2108'
	}

	var RelationChart = require('../../js/chart/relationChart')

	var Tool = require('../../js/util/tool')

	var setting = {
		selector: '.tree',
		series: null,
		legend: ['项目', '单位', '联系人'],
		colorSet: {
			project: '#ff1d20',
			company: '#239deb',
			person: '#ff9a00'
		},
		normal: {
			project: '#eb5864',
			company: '#ff8a0f',
			person: '#4aa0d4'
		}
	}

	var Event = require('../../js/util/event')

	function getRelation(callback) {

		Tool.mask();
		$.ajax({
			url: path + '/getRelation',
			type: 'POST',
			dataType: 'json',
			data: {
				startDate: AjaxObj.startDate,
				endDate: AjaxObj.endDate,
				type: 0,
				name: AjaxObj.name,
				companyRole: AjaxObj.companyRole,
				personRole: AjaxObj.personRole
			},
			success: function(data) {

				Tool.removeMask()

				var series = {
					nodes: data.objectList,
					links: data.linkList
				}

				if (data.linkList.length === 0) {

					alert("没有相关数据")
					return
				}
				
				setting.series = series
				RelationChart.init(setting)
			},
			error: function() {

				return "error";
			}
		})
	}

	function loadUrlDate(callback) {

		var url = window.location.href,
			args

		if (url === path + '/relation') {

			return
		} else {

			args = Tool.getUrlArgs(document.getElementById('getUrlArgs'))

			AjaxObj.name = decodeURIComponent(args['name'])
			AjaxObj.id = args['id']
			AjaxObj.rolesType = args['type']

			if (args['industryId']) {

				AjaxObj.industryId = args['industryId']
				getRecommProject(function() {

					$(".searchBody .inputText")
						.val(AjaxObj.name)
						.data('cValue', AjaxObj.name)

					getRelation()
					getRelationRoles()
				})

				return
			}

			$(".searchBody .inputText")
				.val(AjaxObj.name)
				.data('cValue', AjaxObj.name)

			getRelation()
			getRelationRoles()
		}
	}

	function getList(callback) {

		$.ajax({
			url: path + '/relationSuggest',
			type: 'POST',
			dataType: 'json',
			data: {
				'name': AjaxObj.smallName,
			},
			success: function(data) {


				$('.searchItem').find('ul').html('')

				if (data.length === 0) {

					console.log("没有相关数据")

					return
				} else {

					for (var i = 0; i < data.length; i++) {

						var li = $('<li></li>')
							.addClass('rItem')
							.html(data[i].name)
							.data('type', data[i].type)

						$('.searchItem').find('ul').append(li)
					}
				}
			}
		})
	}

	function getRelationRoles(callback) {

		$.ajax({
			url: path + '/getRelationRoles',
			type: 'POST',
			dataType: 'json',
			data: {
				name: AjaxObj.name,
				type: AjaxObj.rolesType
			},
			success: function(data) {

				if (!data) {

					return 
				}
				var companyRoles = data.companyRoles,
					personRoles = data.personRoles,
					comRemConli = $('.comRemCon .list li'),
					perRemConli = $('.perRemCon .list li'),
					comRole,
					perRole

				$('.comRemCon .list li.selected').removeClass('selected')
				$('.perRemCon .list li.selected').removeClass('selected')

				companyRoles[0] ? comRole = companyRoles[0]['role'] : comRole = AjaxObj.companyRole
				personRoles[0] ? perRole = personRoles[0]['role'] : perRole = AjaxObj.companyRole

				$('.comRemCon .topTitle').html(comRole + '<i></i>')
				$('.personRoles .topTitle').html(perRole + '<i></i>')


				for (var i = 0, n = comRemConli.length; i < n; i++) {

					var $li = $(comRemConli[i])

					companyRoles.forEach(function(item) {

						if ($li.html() === item.role) {

							$li.attr('canClick', true)
						}
					})
				}

				for (var i = 0, n = perRemConli.length; i < n; i++) {

					var $li = $(perRemConli[i])

					personRoles.forEach(function(item) {

						if ($li.html() === item.role) {

							$li.attr('canClick', true)
						}
					})
				}
			}
		})
	}

	function getRecommProject(callback) {
		$.ajax({
			url: path + '/getRecommProject',
			type: 'POST',
			dataType: 'json',
			data: {
				industryId:AjaxObj.industryId
			},
			success: function(data) {
				
				AjaxObj.name = data.projectName
				AjaxObj.rolesType = 'project'
				if (callback && callback() ) {

					callback()
				}
			}
		})
	}

	function initSlider() {

		var sliderOption = {
			selector: 'slider',
			handle: 'handle',
			range: null,
			value: 154,
			dom: '.timeShow'
		}

		var slider = new Slider(sliderOption)
		slider.init()

		var scaleOption = {
				selector: 'scale',
				handle: 'scaleHandle',
				range: null,
				value: 10
			}
		/*var scale = new Scale(scaleOption)
			scale.init()*/

		$('.perRemCon .list').niceScroll({
			cursorcolor: "#0a8dff",
			cursorwidth: '4px',
			cursorborder: '#0a8dff'
		})

		// 手动删除滚动条的横向div
		$('#ascrail2000-hr').remove()

		$("#marquee").kxbdMarquee({
			direction: "up",
			isEqual: false,
			scrollDelay: 50
		})
	}

	function initFocus() {

		$('.searchBody .inputText').on('focus', function(e) {

			var val = $(this).attr('value')
			$(this).addClass('selected')
		})

		$(".searchBody .inputText").bind('input', function() {

			AjaxObj.smallName = $(this).val()

			$(this).data('cValue', $(this).val())

			$('.searchItem').slideDown()

			Debounce.lightThrottle(getList)
		})

		$('.searchBody .searchItem li').live('click', function(e) {

			var e = e || window.event,
				word = $(this).html(),
				type = $(this).data('type')

			$(".searchBody .inputText").data('cValue', word)
			$('.searchBody .inputText').val(word)

			$('.searchItem').slideUp()

			AjaxObj.name = word
			AjaxObj.rolesType = type

			getRelationRoles()
		})

		$('.searchBody .inputText').on('blur', function(e) {

			var val = $(this).attr('value'),
				cValue = $(this).data('cValue')

			if (cValue === '') {

				$(this).val('项目/单位名称')
			} else {
				$(this).val(cValue)
			}

			$('.searchItem').slideUp()
			$(this).removeClass('selected')
		})


		$('.searchBody .btnCon').on('click', function(e) {

			var inputValue = $('.searchBody .inputText').val()

			if (inputValue === '' || inputValue === '项目/单位名称') {

				$('.searchBody .inputText').addClass('selected')

				return
			} else {

				Tool.mask()
				getRelation()
			}
		})
	}

	function initRole() {

		/*浏览展开*/
		$('.recomCon .top').find('i').on('click', function(e) {

			var display = $('.recom').css('display')
			display === 'none' ? $('.recom').slideDown(500) : $('.recom').slideUp(500)
			display === 'none' ? $(this).addClass('selected') : $(this).removeClass('selected')
		})

		$('.topTitle').find('i').live('click', function(e) {

			var con = $(this).parent().parent().find('.list'),
				display = con.css('display'),
				e = e || window.event

			display === 'none' ? con.slideDown(500) : con.slideUp(500)
			display === 'none' ? $(this).addClass('selected') : $(this).removeClass('selected')

			e.stopPropagation()
		})

		// 鼠标滑过事件
		$('.tip .close').live('click', function(e) {

			$(this).parent().parent().remove()
		})

		$('.tip').live('mouseleave', function(e) {

			var e = e || window.event
			$(this).remove()
		})

		$('.perRemCon .topTitle,.comRemCon .topTitle').on('click', function(e) {

			var con = $(this).parent().find('div').eq(1),
				e = e || window.event,
				display = con.css('display'),
				selected = $(this).hasClass('selected')

			display === 'none' ? con.slideDown(500) : con.slideUp(500)

			if (!selected) {

				$(this).addClass('selected')
			} else {
				$(this).removeClass('selected')
			}

			e.stopPropagation()
		})

		$('.list li.item').on('click', function(e) {

			if (!$(this).attr('canClick')) {

				return
			}

			var e = e || window.event,
				word = $(this).html(),
				parent = $(this).parent().parent().parent(),
				top = parent.find('div').eq(0),
				con = parent.find('div').eq(1)

			top.html(word + '<i></i>')
			con.slideUp('fast')

			if (parent.parent().hasClass('comRem')) {

				AjaxObj.companyRole = word
			} else if (parent.parent().hasClass('perRem')) {

				AjaxObj.personRole = word
			}
		})
	}

	$(function() {

		initSlider()
		loadUrlDate()
		initFocus()
		initRole()

		Event.listen('timeChange', function(parm) {

			AjaxObj.startDate = parm[0]
			AjaxObj.endDate = parm[1]
		})
	})

	module.exports = 'relation'
})