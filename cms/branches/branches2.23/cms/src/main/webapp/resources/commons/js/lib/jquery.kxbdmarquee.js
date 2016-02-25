/**
 * $("#marquee").kxbdMarquee(options);
 * @options
 *		isEqual:true,		//所有滚动的元素长宽是否相等,true,false
 *  	loop:0,				//循环滚动次数，0时无限
 *		direction:"left",	//滚动方向，"left","right","up","down"
 *		scrollAmount:1,		//步长
 *		scrollDelay:20		//时长
 */

define(function(require, exports, module) {
	(function($) {
		$.fn.kxbdMarquee = function(options) {

			var opts = $.extend({}, $.fn.kxbdMarquee.defaults, options);

			return this.each(function() {

				var $marquee = $(this),
					_scrollObj = $marquee.get(0),
					scrollW = $marquee.width(),
					scrollH = $marquee.height(),
					$element = $marquee.find('ul'),
					$kids = $element.children(),
					scrollSize = 0

				var _type = (opts.direction == "left" || opts.direction == "right") ? 1 : 0;

				$element.css(_type ? "width" : "height", 10000);

				if (opts.isEqual) {
					scrollSize = $kids[_type ? "outerWidth" : "outerHeight"]() * $kids.length;
				} else {
					$kids.each(function() {
						scrollSize += $(this)[_type ? "outerWidth" : "outerHeight"]();
					});
				};

				if (scrollSize < (_type ? scrollW : scrollH)) {

					return;
				};

				$element.append($kids.clone()).css(_type ? "width" : "height", scrollSize * 2);

				var numMoved = 0;

				function scrollFunc() {

					var _dir = (opts.direction == "left" || opts.direction == "right") ? "scrollLeft" : "scrollTop";
					if (opts.loop > 0) {
						numMoved += opts.scrollAmount;
						if (numMoved > scrollSize * opts.loop) {
							_scrollObj[_dir] = 0;
							return clearInterval(moveId);
						};
					};

					if (opts.direction == "left" || opts.direction == "up") {

						var newPos = _scrollObj[_dir] + opts.scrollAmount;
						if (newPos >= scrollSize) {
							newPos -= scrollSize;
						}
						_scrollObj[_dir] = newPos;
					} else {
						var newPos = _scrollObj[_dir] - opts.scrollAmount;
						if (newPos <= 0) {
							newPos += scrollSize;
						};
						_scrollObj[_dir] = newPos;
					};
				};

				if (this.moveId) {
					clearInterval(this.moveId);
				}

				this.moveId = setInterval(scrollFunc, opts.scrollDelay);
				
				$marquee.hover(function() {
					clearInterval(this.moveId);
				}, function() {
					clearInterval(this.moveId);
					this.moveId = setInterval(scrollFunc, opts.scrollDelay);
				});
			});
		};

		$.fn.kxbdMarquee.defaults = {
			isEqual: true, //所有滚动的元素长宽是否相等,true,false
			loop: 0, //循环滚动次数，0时无限
			direction: "left", //滚动方向，"left","right","up","down"
			scrollAmount: 1, //步长
			scrollDelay: 20 //时长

		};

		$.fn.kxbdMarquee.setDefaults = function(settings) {
			$.extend($.fn.kxbdMarquee.defaults, settings);
		};
	})(jQuery);

})