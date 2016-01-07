/* 
* @Author: Administrator
* @Date:   2015-12-16 08:41:22
* @Last Modified by:   Administrator
* @Last Modified time: 2015-12-16 17:18:37
*/

'use strict';

define(function(require, exports, module) {

	var Interaction = {
		type: '',
		id: '',
		leftStartTime: {
			year: '2013',
			month: '11'
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
			year: '2015',
			month: '11'
		},
		informationType: '项目',
		getLeftDate: function() {},
		getFullDate: function() {},
		initDataZoom:function() {}
	}

	module.exports = Interaction
})