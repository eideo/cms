/* 
* @Author: Administrator
* @Date:   2015-12-16 08:41:22
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-01-13 17:03:18
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
			year: '2012',
			month: '01'
		},
		rangeEndTime: {
			year: '2015',
			month: '11'
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