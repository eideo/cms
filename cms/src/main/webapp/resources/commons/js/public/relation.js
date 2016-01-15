/* 
 * @Author: Administrator
 * @Date:   2015-11-18 15:50:00
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-15 13:09:43
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
		companyRoleArray: [],
		personRoleArray: [],
		startDate: '201312',
		endDate: '201511',
		rolesName: '',
		rolesType: 'company',
		industryId:'2108',
		canSearch:false
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
		
		var argComRole = AjaxObj.companyRoleArray.join(','),
			argPerRole = AjaxObj.personRoleArray.join(',')

		$.ajax({
			url: path + '/getRelation',
			type: 'POST',
			dataType: 'json',
			data: {
				startDate: AjaxObj.startDate,
				endDate: AjaxObj.endDate,
				type: 0,
				name: AjaxObj.name,
				companyRole: '',
				personRole: ''
			},
			success: function(data) {

				Tool.removeMask()

				var series = {
					nodes: data.objectList,
					links: data.linkList
				}

				if (data.linkList.length === 0) {

					$.Message({

						text:'没有相关数据！',
						type:'success'
					})
					
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
			AjaxObj.canSearch = true

			if (args['industryId']) {

				AjaxObj.industryId = args['industryId']
				getRecommProject(function() {

					$(".searchBody .inputText")
						.val(AjaxObj.name)
						.data('cValue', AjaxObj.name)

					getRelationRoles(function() {

						getRelation()
					})
				})

				return
			}

			$(".searchBody .inputText")
				.val(AjaxObj.name)
				.data('cValue', AjaxObj.name)

			getRelationRoles(function() {

				getRelation()
			})
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

				$('.comRem ul').html('')
				$('.perRem ul').html('')

				var companyRoles = data.companyRoles,
					personRoles = data.personRoles
				

				AjaxObj.companyRoleArray.push(companyRoles[0]['role'])
				AjaxObj.personRoleArray.push(personRoles[0]['role'])

				companyRoles.forEach(function(item,index) {

					var $li = $('<li class="item"></li>')
						.html(item['role'])
						.appendTo($('.comRem ul'))

					if (index === 0) {

						$li.addClass("selected")
					}
				})

				personRoles.forEach(function(item,index) {

					var role = item['role'];

					if (role.length > 5) {

						role = role.substr(0,5)
					}

					var $li = $('<li class="item"></li>')
						.html(role)
						.appendTo($('.perRem ul'))

					if (index > 2) {

						$li.addClass('hidden')
					}

					if (index === 0) {

						$li.addClass("selected")
					}
				})

				if (personRoles.length > 3) {

					var $more = $('<i class="more"></i>').appendTo($('.perRem'))
				}

				if (companyRoles.length > 3) {

					var $more = $('<i class="more"></i>').appendTo($('.comRem'))
				}

				if (callback && callback()) {

					callback()
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

	/*	var slider = new Slider(sliderOption)
		slider.init()
*/
		var scaleOption = {
				selector: 'scale',
				handle: 'scaleHandle',
				range: null,
				value: 10
			}
		/*var scale = new Scale(scaleOption)
			scale.init()*/

		// 手动删除滚动条的横向div
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
			AjaxObj.canSearch = true
			
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

				if (AjaxObj.canSearch) {

					Tool.mask()
					getRelation()
				}

			}
		})
	}

	function initRole() {


		// 鼠标滑过事件
		$('.tip .close').live('click', function(e) {

			$(this).parent().parent().remove()
		})

		$(".recomCon").draggable({containment:"parent"});
		$('.tip').draggable({containment:"parent"});

		$('.comRem ul li,.perRem ul li').live('click',function(e) {

			var parent = $(this).parent().parent(),
				word = $(this).html(),
				comIndex,
				perIndex

			if ($(this).hasClass('selected') ) {
				$(this).removeClass('selected')
			} else {
				$(this).addClass('selected')
			}

			if (parent.hasClass('comRem')) {

				comIndex = AjaxObj.companyRoleArray.indexOf(word)

				if (comIndex === -1) {

					AjaxObj.companyRoleArray.push(word)
				} else {
					AjaxObj.companyRoleArray.splice(comIndex,1)
				}
			} else if (parent.hasClass('perRem')) {

				perIndex = AjaxObj.personRoleArray.indexOf(word)

				if (perIndex === -1) {

					AjaxObj.personRoleArray.push(word)
				} else {
					AjaxObj.personRoleArray.splice(perIndex,1)
				}
			}

			if (AjaxObj.canSearch) {

				getRelation()	
			} else {
				
				$('.searchBody .inputText').addClass('selected')

				return
			}	
		})

		$('.perRem .more,.conRem .more').live('click',function() {

			var parent = $(this).parent().find('ul'),
				height = parent.height()

			if (parent.height() === 30) {

				parent.find('li').removeClass('hidden')
			} else {
				parent.find('li:gt(2)').addClass('hidden')
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