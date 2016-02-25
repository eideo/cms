/* 
 * @Author: zhanganchun
 * @Date:   2016-01-04 15:01:07
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-02-18 11:48:41
 * @增加跳转
 */

(function($) {

	var ms = {

		init: function(obj, args) {
			return (function() {
				ms.fillHtml(obj, args);
				ms.bindEvent(obj, args);
			})();
		},
		//填充html
		fillHtml: function(obj, args) {

			return (function() {
				obj.empty();
				//上一页
				if (args.current > 1) {
					obj.append('<a href="javascript:;" class="prevPage">上一页</a>');
				} else {
					obj.remove('.prevPage');
					obj.append('<span class="disabled">上一页</span>');
				}
				//中间页码
				if (args.current != 1 && args.current >= 4 && args.pageCount != 4) {
					obj.append('<a href="javascript:;" class="tcdNumber">' + 1 + '</a>');
				}
				if (args.current >= 4 && args.current <= args.pageCount && args.pageCount > 5) {
					obj.append('<span>...</span>');
				}
				var start = args.current - 1,
					end = args.current + 1;
				if ((start > 1 && args.current < 4)) {
					end++;
				}
				if (args.current == 1) {
					end = end + 2;
				}
				if (args.current > args.pageCount - 4 && args.current >= args.pageCount) {
					start = start - 2;
				}
				if (args.current == args.pageCount - 1) {
					start = start - 1;
					end = end + 1;
				}
				if (args.current == args.pageCount - 2) {
					end = end + 1;
				}
				for (; start <= end; start++) {
					if (start <= args.pageCount && start >= 1) {
						if (start != args.current) {
							obj.append('<a href="javascript:;" class="tcdNumber">' + start + '</a>');
						} else {
							obj.append('<span class="current">' + start + '</span>');
						}
					}
				}
				if (args.current == 2 && args.pageCount > 4) {
					obj.append('<a href="javascript:;" class="tcdNumber">' + 4 + '</a>');
				}
				if (args.current + 1 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5) {
					obj.append('<span>...</span>');
				}
				if (args.current != args.pageCount && args.current < args.pageCount - 2 && args.pageCount != 4) {
					obj.append('<a href="javascript:;" class="tcdNumber">' + args.pageCount + '</a>');
				}
				//下一页
				if (args.current < args.pageCount) {
					obj.append('<a href="javascript:;" class="nextPage">下一页</a>');
				} else {
					obj.remove('.nextPage');
					obj.append('<span class="disabled">下一页</span>');
				}

				/*共有多少页*/
				$('.searchPage .allPage').html(args.pageCount)
				/*obj.parent().append('<div class="searchPage">');
				$('.searchPage').append('<span class="page-sum">共<strong class="allPage">' + args.pageCount + '</strong>页</span>');
				$('.searchPage').append('<span class="page-go">跳转到<input type="text" id="pageTo">页</span>');
				$('.searchPage').append('<a href="javascript:;" class="page-btn">GO</a>')*/

			})();
		},
		//绑定事件
		bindEvent: function(obj, args) {

			return (function() {
	/*			obj.off("click", "a.tcdNumber");
				obj.off("click", "a.prevPage");
				obj.off("click", "a.nextPage");
				obj.parent().off("click", ".sure");*/
				obj.on("click", "a.tcdNumber", function() {
					var current = parseInt($(this).text());
					ms.fillHtml(obj, {
						"current": current,
						"pageCount": args.pageCount
					});
					if (typeof(args.backFn) == "function") {
						args.backFn(current);
					}
				});
				//上一页
				obj.on("click", "a.prevPage", function() {
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj, {
						"current": current - 1,
						"pageCount": args.pageCount
					});
					if (typeof(args.backFn) == "function") {
						args.backFn(current - 1);
					}
				});
				//下一页
				obj.on("click", "a.nextPage", function() {
					var current = parseInt(obj.children("span.current").text());
					ms.fillHtml(obj, {
						"current": current + 1,
						"pageCount": args.pageCount
					});
					if (typeof(args.backFn) == "function") {
						args.backFn(current + 1);
					}
				});
				obj.parent().on("click", ".sure", function() {
					var current = obj.parent().find(".span").val();
					if (current.trim() == "") {
						return;
					}
					ms.fillHtml(obj, {
						"current": parseInt(current),
						"pageCount": args.pageCount
					});
					if (typeof(args.backFn) == "function") {
						args.backFn(current);
					}
				});

				obj.parent().on('click','.page-btn',function() {

					var current = $('#pageTo').val();

					if (parseInt(current) > parseInt(args.pageCount)) {

						return 
					}

					ms.fillHtml(obj, {
						"current": parseInt(current),
						"pageCount": args.pageCount
					});
					if (typeof(args.backFn) == "function") {
						args.backFn(parseInt(current));
					}
				})

			})();
		}
	}

	$.fn.createPage = function(options) {

		var args = $.extend({
			pageCount: 10,
			current: 1,
			backFn: function() {}
		}, options);
		ms.init(this, args);
	}

})(jQuery);