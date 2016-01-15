/* 
* @Author: zhanganchun
* @Date:   2016-01-15 10:41:25
* @Last Modified by:   zhanganchun
* @Last Modified time: 2016-01-15 13:07:08
* @ 消息提示框，目前仅成功和错误两种
*/

'use strict';

(function ($) {

	var defaluts = {

		name:"消息提示框",
		version:'0.1'
	}


	$.extend({

		Message:function(option) {

			var text = option.text,
				type = option.type,
				conWidth = 344,
				conHeigtht = 185,
				titleColor = "#ebebeb",
				titleHeight = 43,
				timeout = option.timeout || 1500

			var $messageCon = $('<div></div>')
				.addClass('pInitMessage')
				.css('width',conWidth)
				.css({
					position:'absolute',
					left:'50%',
					top:'50%',
					marginLeft:-172+'px',
					marginTop:-92+'px',
					borderRadius:3+'px',
					webkitTransition: "all .5s",
				       mozTransition: "all .5s",
				         oTransition: "all .5s",
				            transition: "all .5s"
				})
				.css('height',conHeigtht)
				.css('backgroundColor','#fff')
				.appendTo($('body'))


			var $title = $('<h1></h1>')
				.css({
					height:titleHeight+"px",
					lineHeight:titleHeight+"px",
					backgroundColor:titleColor,
					position:"relative",
					color:'#000',
					textIndent:"20px",
					fontWeight:'bold',
					fontSize:'14px',
					fontFamily:'微软雅黑'
				})
				.html('提示信息')
				.appendTo($messageCon)

			var $close = $('<img></img>')
				.css({
					position:"absolute",
					right:'20px',
					top:"14px",
					width:'9px',
					height:"9px",
					display:'block',
					cursor:"pointer"
				})
				.attr('src',path+'/resources/commons/images/mClose.png')
				.appendTo($title)

			var $tipCon = $('<div></div>')
				.css({
					height:'42px',
					lineHeight:"42px",
					paddingLeft:'115px',
					marginTop:'26px',
					width:'100%',
					position:"relative"
				})
				.html(text)
				.appendTo($messageCon)

			var $img = $('<img></img>')
				.attr('src',path+'/resources/commons/images/mSuccess.png')
				.css({
					position:'absolute',
					left:'67px',
					top:'5px'
				})
				.appendTo($tipCon)

			if (type === 'success') {

				$img.attr('src',path+'/resources/commons/images/mSuccess.png')
			} else {
				$img.attr('src',path+'/resources/commons/images/mFailure.png')
			}

			var $buttonCon = $('<div></div>')
				.css({
					marginTop:'20px'
				})
				.appendTo($messageCon)

			var $buttonCancle = $('<span>取消</span>')
				.css({
					width:"70px",
					height:'25px',
					display:'inline-block',
					textAlign:"center",
					marginLeft:"90px",
					lineHeight:'25px',
					borderRadius:'2px',
					cursor:'pointer',
					border:'1px solid #47aaff'
				})
				.appendTo($buttonCon)

			var $buttonSubmit = $('<span>确定</span>')
				.css({
					width:"70px",
					height:'25px',
					display:'inline-block',
					textAlign:"center",
					marginLeft:"30px",
					lineHeight:'25px',
					borderRadius:'2px',
					backgroundColor:'#47aaff',
					color:'#fff',
					cursor:'pointer',
					border:'1px solid #47aaff'
				})
				.appendTo($buttonCon)



			$buttonSubmit.on('click',function(e) {

				var e = e || window.event;

				$messageCon.remove()
				e.preventDefault()
			})

			$close.on('click',function(e) {

				var e = e || window.event;
				$messageCon.remove()
				e.preventDefault()
			})

			setTimeout(function(){

				$messageCon.remove()
			},timeout)
		}
	})

})(jQuery)