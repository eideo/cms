(function($){
    $.fn.capacityFixed = function(options) {
        var opts = $.extend({},$.fn.capacityFixed.deflunt,options);
        var FixedFun = function(element) {
            var top = opts.top;
            element.css({
                "top":top
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top: 0							
                        });
                    } else {
                        element.css({
                            top: scrolls
                        });
                    }
                }else {
                    element.css({
                        position: "inherit",
                        top: top
                    });
                }
            });
         
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed.deflunt={
		right : 0,//相对于页面宽度的右边定位
        top: 0
	};
})(jQuery);

/*详情页*/
$(function(){
	$(".contBottom li a").click( function(){
		$(".contBottom li a").removeClass("on");
		$(this).addClass("on");	

	});

	$(".contBottom li").on("click","#01",function(){

		$(this).addClass("cur");
        $("#02,#03").removeClass("cur");

        $("#mf").show();
		$("#ms,#mt").hide();
	});

	$(".contBottom li").on("click","#02",function(){

		$(this).addClass("cur");
        $("#01,#03").removeClass("cur");

        $("#ms").show();
		$("#mf,#mt").hide();
	});

    $(".contBottom li").on("click","#03",function(){

		$(this).addClass("cur");
        $("#02,#01").removeClass("cur");

        $("#mt").show();
		$("#ms,#mf").hide();
	});
	
})

/*分享关闭*/
$(function(){
    $(".close").click( function(){
        $(".fullbg").hide();
        $(".dialog").hide();
    })
})
