/* 
 * @Author: Administrator
 * @Date:   2015-12-17 09:35:18
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-18 15:58:57
 */

'use strict';
define(function(require, exports, module) {


	var Tool = {}


	/*清除字符串空格*/
	Tool.trim = function(str) {

		str = str.replace(/^(\s|\u00A0)+/, '');
		for (var i = str.length - 1; i >= 0; i--) {
			if (/\S/.test(str.charAt(i))) {
				str = str.substring(0, i + 1);
				break;
			}
		}
		return str;
	}

	/*遮罩层*/
	Tool.mask = function () {
		
		var i = 0,
			mask = $('<div></div>')
			.addClass('mask')
			.appendTo($('body'))

		var maskTip = $('<div></div>')
			.addClass('maskTip')
			.html('<img src='+path+'/resources/commons/images/search2.gif'+'/>')
			.appendTo(mask)
	}

	Tool.removeMask = function() {

		$('.mask').remove()
		$('.tree').html('')
	}

	Tool.getUrlArgs = function(e) {

		var args = '空',
			_args = [],

		u = window.location.href,
		s = u.indexOf("?"),
		i = 0,
		l = 0,
		o = null;

		if (s!= -1) {

			args = u.substr(s+1).split('&')
		}

		l = args.length

		for(;i<l;i++) {
            if(args[i]) {
            	o = args[i].split('=')
            	_args[o[0]] = o[1]
            }
		}

		return _args
	}

	/*数组去重*/
	Tool.unique = function(arr) {
		
	      var result = [], isRepeated;
	      for (var i = 0, len = arr.length; i < len; i++) {
	          isRepeated = false;
	          for (var j = 0, len = result.length; j < len; j++) {
	              if (arr[i] == result[j]) {   
	                  isRepeated = true;
	                  break;
	              }
	        }
	         if (!isRepeated) {
	            result.push(arr[i]);
	         }
	    }
	    return result;
	}

	module.exports = Tool
})