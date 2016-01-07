define(function(require, exports, module) {

	var Close = {};
	Close.closeLoginBox = function() {

		$('.close').click(function() {

			$('.login_box').hide();
			$('.shadow_all').hide();
		});
	}

	module.exports = Close;
})