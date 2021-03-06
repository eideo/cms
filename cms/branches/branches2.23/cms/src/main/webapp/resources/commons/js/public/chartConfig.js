/* 
 * @Author: zhanganchun
 * @Date:   2016-01-05 09:03:27
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-19 11:39:07
 */

'use strict';

define(function(require, exports, module) {

	var ChartConfig = {}

	ChartConfig.leftBarSetting = {
		selector: '.profile #chart1',
		series: [],
		colorset: ['#fd7497', '#ff4c7a', '#ff503c', '#ff620d', '#ff8a0d', '#ff9829', '#ffb400', '#ffc23e', '#eba602', '#d7c500', '#8ae778', '#7ed9a3', '#46e6ff', '#8cb4ff', '#c0a6ff'],
		type:"leftBar",
		xAxisSetting:{
			scale:'linear',
			orient:"bottom",
			show:true
		},
		yAxisSetting:{
			scale:"ordinal",
			orient:"left",
			show:false
		},
		margin: {
			left: 120,
			top: 30,
			right: 20,
			bottom: 40
		}
	}

	// 数据概括信息数量分布
	ChartConfig.timeLineSetting = {
		selector: '.profile #chart2',
		series: [],
		colorset: ['#b8deff', '#e9f5ff'],
		xAxisSetting:{
			scale:'ordinal',
			orient:"bottom",
			show:true
		},
		yAxisSetting:{
			scale:"linear",
			orient:"left",
			show:true
		},
		type:"timeLine",
		margin: {
			left: 60,
			top: 55,
			right: 30,
			bottom: 30
		}
	}

	// 信息类型占比
	ChartConfig.pieAreaSetting = {
		selector: '.profile #chart3',
		series: [{
			name: '项目',
			value: 60
		}, {
			name: '招标',
			value: 20
		}, {
			name: '中标',
			value: 25
		}, {
			name: '采购',
			value: 28
		}],
		colorset: ['#ffc247', '#ff8e29', '#b6c712', '#ff8949', '#ffbe60'],
		margin: {
			left: 60,
			top: 55,
			right: 30,
			bottom: 30
		}
	}

	// 景气指数
	ChartConfig.singleSetting = {
		selector: '.industry #chart4',
		series: [],
		colorset: ['#ff8519', '#e9f5ff'],
		margin: {
			left: 70,
			top: 55,
			right: 60,
			bottom: 100
		}
	}

	// 关注指数
	ChartConfig.barSetting = {
		selector: '.industry #chart5',
		series: [],
		colorset: ['#ff8519', '#e9f5ff'],
		margin: {
			left: 70,
			top: 55,
			right: 60,
			bottom: 100
		}
	}

	// 用户细分地图部分
	ChartConfig.mapSetting = {
		selector: '.userCon .left',
		series: [],
		colorset: ['#0069ec', '#1b83fd', '#3092ff', '#3799ff', '#3f9eff', '#47a3ff', '#76bbfe', '#8cc7ff', '#a2d4ff', '#b2dbff'],
		margin: {
			left: 120,
			top: 55,
			right: 60,
			bottom: 100
		}
	}

	// 添加雷达图
	ChartConfig.raderSetting = {
		selector: '.userCon #chart6',
		series: [],
		colorset: ['#ff881f', '#e5e4e4'],
		margin: {
			left: 50,
			right: 50,
			top: 60,
			bottom: 120
		}
	}

	// 竞争力占比图
	ChartConfig.sevenSetting = {
		selector: '.userCon #chart7',
		series: [{
			type: '强',
			value: 15
		}, {
			type: '适中',
			value: 60
		}, {
			type: '弱',
			value: 35
		}],
		colorset: ['#3aaffb', '#58bdff', '#91d3fe'],
		margin: {
			left: 100,
			right: 140,
			top: 60,
			bottom: 62
		}
	}

	module.exports = ChartConfig
})