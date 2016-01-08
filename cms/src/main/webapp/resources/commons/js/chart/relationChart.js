/* 
 * @Author: Administrator
 * @Date:   2015-12-22 09:10:01
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-08 16:22:44
 */

'use strict';

define(function(require, exports, module) {

	//var $ = require('jquery')

	var Tool = require('../../js/util/tool')

	var cola = require('cola')

	var RelationChart = {}

	var Debounce = require('../../js/util/debounce')

	var selector,
		series,
		colorSet,
		normal,
		legend,
		width,
		height,
		imageScale = 0.25,
		legendArray = ['项目', '单位', '人员'],
		legendObj = {
			project: '项目',
			company: '单位',
			person: '联系人'
		},
		color,
		cola,
		outer,
		legendCon,
		vis,
		nodeMouseDown = false,
		edgesLayer,
		nodesLayer,
		link,
		node;

	var sourceDate, modelgraph, viewgraph = {
			nodes: [],
			links: []
		},
		startNode;

	var chartUniqId = 0

	function loadInformation(parm, d, pos) {

		var type = d['type']

		$.ajax({
			url: path + '/getRelationDetail',
			type: 'POST',
			dataType: 'json',
			data: {
				'type': parm.type,
				'id': parm.id
			},
			success: function(data) {

				showInfoByType(type, data, pos, d)
			},
			error: function(error) {

				return "error";
			}
		})
	}

	function showInfoByType(type, data, pos, d) {

		var type = type
		var that = this

		var tipWrap = $('<div></div>')
			.addClass('tipWrap')

		var i = $('<i>x</i>')
			.addClass('close')
			.appendTo(tipWrap)

		var typeChinese = ''

		if (type === 'person') {
			typeChinese = '联系人'
		} else if (type === 'project') {
			typeChinese = '项目'
		} else if (type === 'company') {
			typeChinese = '单位'
		}

		var tipTitle = $('<div></div>')
			.addClass('tipTitle')
			.html(typeChinese + "：" + data.name)
			.attr('title', data.name)
			.appendTo(tipWrap)

		var tipCon = $('<div class="tipCon"></div>')
			.appendTo(tipWrap)

		if (type === "person") {

			var ul = $('<ul></ul>')
				.append('<li class="info">地址：' + data.address + '</li>')
				.append('<li class="info"> 邮箱：' + data.email + '</li>')
				.append('<li class="info">电话：' + data.cellphone + ' </li>')
				.append('<li class="more">了解更多</li>')
				.appendTo(tipCon)
		} else if (type === 'company') {

			var ul = $('<ul></ul>')
				.append('<li class="info">地址：' + data.address + '</li>')
				.append('<li class="info"> 座机：' + data.phone + '</li>')
				.append('<li class="more">了解更多</li>')
				.appendTo(tipCon)
		} else if (type === 'project') {

			var ul = $('<ul></ul>')
				.append('<li class="info">地址：' + data.address + '</li>')
				.append('<li class="info">项目总额：' + data.total + '</li>')
				.append('<li class="more">了解更多</li>')
				.appendTo(tipCon)

		}

		var tip = $('<div></div>')
			.addClass('tip tip' + d['uniqId'])
			.css('left', pos[0] + 20)
			.css('top', pos[1] - 30)
			.append(tipWrap)
			.appendTo($('.tree'))
	}

	function redraw() {

		if (nodeMouseDown) {
			return
		}

		var scale = d3.event.scale

		vis.attr("transform", "translate(" + d3.event.translate + ")" + " scale(" + scale + ")");
	}

	function refocus(focus) {

		modelgraph.links.forEach(function(l) {

			var u = modelgraph.nodes[l.source],
				v = modelgraph.nodes[l.target];

			if (u === focus && !inView(v)) addViewNode(v, focus);
			if (v === focus && !inView(u)) addViewNode(u, focus);
		})

		viewgraph.links = [];

		viewgraph.nodes.forEach(function(v) {

			v.color = colorSet[v['type']]
			v.stroke = true
		})

		modelgraph.links.forEach(function(l) {

			var u = modelgraph.nodes[l.source],
				v = modelgraph.nodes[l.target];

			if (inView(u) && inView(v)) {

				viewgraph.links.push({
					source: u,
					target: v
				})
			}

			if (inView(u) && !inView(v)) {
				u.color = colorSet[u['type']];
				u.stroke = false
			}

			if (!inView(u) && inView(v)) {
				v.color = colorSet[v['type']];
				v.stroke = true
			}
		})
	}

	function inView(v) {

		return typeof v.viewgraphid !== 'undefined';
	}

	function addViewNode(v, startpos) {

		v.viewgraphid = viewgraph.nodes.length;

		if (typeof startpos !== 'undefined') {
			v.x = startpos.x;
			v.y = startpos.y;
		}

		viewgraph.nodes.push(v);
	}

	function getNode(uniqId) {

		var v, i = modelgraph.nodes.length;
		while (i--) {

			if ((v = modelgraph.nodes[i]).uniqId == uniqId) {
				return v;
			}
		}
		return null;
	}

	function click(node) {

		var focus = getNode(node.uniqId);

		refocus(focus);
		update();
	}

	function mouseover(d) {

		d3.selectAll('.tip').remove()

		$(this).attr('transform', 'scale(1.4)')

		var type = d['type'],
			id = d['dataId'],
			parm = {
				type: type,
				id: id
			}

		var that = this,
			relativeDom = document.querySelector('.tree')

		var pos = d3.mouse(relativeDom)

		loadInformation(parm, d, pos)
	}

	function mouseout(d) {

		$(this).attr('transform', 'scale(1.0)')
	}

	function toggleImageZoom(img) {
		var scale = 1;
		d3.select(img).each(function(d) {
			if (Math.abs(img.width.baseVal.value - d.width) < 1) scale /= imageScale;
		});
		imageZoom(img, scale);
	}

	function imageZoom(img, scale) {
		d3.select(img)
			.transition()
			.attr("width", function(d) {
				return scale * d.width;
			})
			.attr("height", function(d) {
				return scale * d.height;
			});
	}

	function update() {

		cola.nodes(viewgraph.nodes)
			.links(viewgraph.links)
			.avoidOverlaps(true)
			.convergenceThreshold(1e-9)
			.handleDisconnected(true)
			.start()

		var link = edgesLayer.selectAll(".link")
			.data(viewgraph.links)

		link.enter().append("line")
			.attr("class", "link")
			.attr('stroke', colorSet['person'])
			.style("stroke-width", 1)

		link.exit().remove()

		var node = nodesLayer.selectAll(".node")
			.data(viewgraph.nodes, function(d) {
				return d.viewgraphid;
			});

		node.exit().remove()

		var enter = node.enter()
			.append("g")
			.attr("class", 'node')
			.on("mousedown", function() {

				nodeMouseDown = true;
			})
			.on("mouseup", function() {

				nodeMouseDown = false;
			})
			.on("touchmove", function() {

				d3.event.preventDefault()
			})
			.call(cola.drag)

		enter.append('svg:circle')
			.attr('r', function(d, i) {

				var type = d['type']

				if (type === 'project') {
					return 20
				} else if (type === 'company') {
					return 15
				} else if (type === 'person') {
					return 10
				}
			})
			.attr('fill', function(d, i) {

				return colorSet[d['type']]
			})
			.on('mouseover', mouseover)
			.on('mouseout', mouseout)
			.on('click', function(d, i) {

				click(d)
			})

		cola.on("tick", function() {
			link.attr("x1", function(d) {
					return d.source.x;
				})
				.attr("y1", function(d) {
					return d.source.y;
				})
				.attr("x2", function(d) {
					return d.target.x;
				})
				.attr("y2", function(d) {
					return d.target.y;
				});

			node.attr("transform", function(d) {
				return "translate(" + d.x + "," + d.y + ")";
			})
		})
	}
	RelationChart.init = function(setting) {

		d3.select(setting.selector).selectAll('svg').remove()

		selector = setting.selector,
			series = setting.series,
			colorSet = setting.colorSet,
			normal = setting.normal,
			legend = setting.legend,
			width = document.querySelector(selector).getBoundingClientRect().width,
			height = document.querySelector(selector).getBoundingClientRect().height,
			imageScale = 0.25,
			legendArray = ['项目', '单位', '人员'],
			legendObj = {
				project: '项目',
				company: '单位',
				person: '联系人'
			}

		color = d3.scale.category20();


		cola = cola.d3adaptor()
			.linkDistance(80)
			.size([width, height]);

		outer = d3.select(setting.selector).append("svg")
			.attr("width", width)
			.attr("height", height)
			.attr("pointer-events", "all");

		legendCon = outer.append('g')
			.attr('class', 'legend')
			.attr('transform', 'translate(10,20)')

		outer.append('rect')
			.attr('class', 'background')
			.attr('fill', 'none')
			.attr('width', "100%")
			.attr('height', "100%")
			.attr('cursor', 'move')
			.call(d3.behavior.zoom().on("zoom", redraw));

		vis = outer
			.append('g');

		nodeMouseDown = false;

		edgesLayer = vis.append("g")
		nodesLayer = vis.append("g")

		modelgraph = series;

		startNode = getNode("1");
		addViewNode(startNode);
		refocus(startNode);

		update();
	}

	module.exports = RelationChart
})