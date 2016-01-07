/* 
* @Author: Administrator
* @Date:   2015-12-16 08:41:22
* @Last Modified by:   Administrator
* @Last Modified time: 2015-12-23 14:00:05
*/

'use strict';

define(function(require, exports, module) {

	var Interaction = {
		type: '',
		id: '',
		leftStartTime: {
			year: '2013',
			month: '12'
		},
		leftEndTime: {
			year: '2015',
			month: '11'
		},
		rangeStartTime:{
			year: '2001',
			month: '01'
		},
		rangeEndTime: {
			year: new Date().getFullYear() + '',
			month: new Date().getMonth() + ''
		},
		chartColor:'#ff8519',
		informationType: '项目',
		industryClicked:false,
		getLeftDate: function() {},
		getFullDate: function() {},
		initDataZoom:function() {},
		initYearZoom:function() {}
	}

	module.exports = Interaction
})