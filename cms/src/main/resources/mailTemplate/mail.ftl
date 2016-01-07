<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<title>邮件模板</title>
		<style type="text/css">
		* {
			padding: 0;
			margin: 0;
		}
		
		body {
			font-size: 12px;
			font-family: 'Microsoft YaHei'
		}
		
		.bg {
			width: 960px;
			height: 600px;
			background: #e5eaf1;
			margin: 20px auto;
			padding-top: 100px;
			font-size: 14px;
		}
		
		h2 {
			width: 118px;
			height: 29px;
			background: url(http://101.200.0.81/resources/commons/images/h2_logo.png) no-repeat;
			margin-left: 54px;
			margin-bottom: 10px;
		}
		
		h2 a {
			display: block;
			width: 118px;
			height: 29px;
			text-decoration: none;
		}
		
		.letter_bg {
			margin-left: 54px;
			width: 735px;
			height: 258px;
			background: url(http://101.200.0.81/resources/commons/images/letter_bg.png) no-repeat;
			padding: 170px 0 0 25px;
		}
		
		h3 {
			font-size: 16px;
			font-weight: bold;
			margin-bottom: 16px;
		}
		
		.letter_bg .code {
			width: 240px;
			height: 32px;
			background: #47aaff;
			color: #fff;
			line-height: 32px;
			font-size: 14px;
			text-align: center;
			margin-bottom: 12px;
		}
		
		.spacing {
			line-height: 24px;
		}
		
		.last {
			margin-top: 30px;
		}
		</style>
	</head>
	<body>
		<div class="bg">
			<h2>
				<a href="http://101.200.0.81/" target="_blank"></a>
			</h2>
			<div class="letter_bg">
				<h3>亲爱的关系网用户，您好！</h3>
				<p class="code">${mailContent}</p>
				<p class="spacing">此邮件由系统自动发出，请勿直接回复。</p>
				<p class="spacing">如果在使用中遇到问题，请发送邮件到：mishu@chinabiding.com，我们将尽快回复。</p>
				<p class="last">感谢您的访问，祝你使用愉快！</p>
			</div>
		</div>
	</body>
</html>