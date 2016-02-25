/* 
 * @Author: Administrator
 * @Date:   2015-12-28 15:38:54
 * @Last Modified by:   Administrator
 * @Last Modified time: 2015-12-28 16:49:37
 * @ 发布-订阅模式体验
 */

'use strict';

define(function(require, exports, module) {

	var Event = (function() {

		var clientList = {},
			listen,
			trigger,
			remove

		listen = function(key,fn) {
			if (!clientList[key]) {
				clientList[key] = []
			}
			clientList[key].push(fn);
		};

		trigger = function() {

			var key = Array.prototype.shift.call(arguments),
				fns = clientList[key];
				
				if (!fns || fns.length === 0) {

					return false
				}

				for (var i = 0, fn; fn = fns[i++];) {
					fn.apply(this, arguments)
				}	
		};

		remove = function (key,fn) {

			var fns = clientList[key];
			if (!fns) {
				return false
			}

			if (!fn) {
				fns && ( fns.length = 0 )
			} else {

				for (var l = fns.length-1;l>=0;l--) {

					if (_fn === fn) {

						fns.splice(l,1);
					}
				}
			}
		};

		return {
			listen:listen,
			trigger:trigger,
			remove:remove
		}

	})()

	module.exports = Event
})