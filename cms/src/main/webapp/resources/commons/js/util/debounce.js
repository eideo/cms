/* 
 * @Author: Administrator
 * @Date:   2015-12-23 15:43:11
 * @Last Modified by:   Administrator
 * @Last Modified time: 2015-12-28 13:22:24
 */

'use strict';
define(function(require, exports, module) {

	var Debounce = {}

	Debounce.throttle = function(fn,interval) {

		var _self = fn,
			timer,
			firstTime = true;

		return function() {
			var args = arguments,
				_me = this;

			if (firstTime) {
				console.log('hah')
				_self.apply(_me,args)
				return firstTime = false
			}

			if (timer) {
				return false;
			}

			timer = setTimeout(function() {

				clearTimeout(timer)
				timer = null;
				_self.apply(_me,args);

			},interval || 500)
		}
	}

	Debounce.debounce = function(func, wait, immediate) {
		// immediate默认为false
		var timeout, args, context, timestamp, result;

		var later = function() {
			// 当wait指定的时间间隔期间多次调用_.debounce返回的函数，则会不断更新timestamp的值，导致last < wait && last >= 0一直为true，从而不断启动新的计时器延时执行func
			var last = _.now() - timestamp;

			if (last < wait && last >= 0) {
				timeout = setTimeout(later, wait - last);
			} else {
				timeout = null;
				if (!immediate) {
					result = func.apply(context, args);
					if (!timeout) context = args = null;
				}
			}
		};

		return function() {
			context = this;
			args = arguments;
			timestamp = _.now();
			// 第一次调用该方法时，且immediate为true，则调用func函数
			var callNow = immediate && !timeout;
			// 在wait指定的时间间隔内首次调用该方法，则启动计时器定时调用func函数
			if (!timeout) timeout = setTimeout(later, wait);
			if (callNow) {
				result = func.apply(context, args);
				context = args = null;
			}

			return result;
		}
	}

	Debounce.lightThrottle = function(method,context) {

		clearTimeout(method.tId)
		method.tId = setTimeout(function() {
			method.call(context)
		},500)
	}

	module.exports = Debounce
})