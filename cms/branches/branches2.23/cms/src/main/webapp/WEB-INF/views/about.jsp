<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>网站导航</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/Aboutbasic.css?v=${projectversion}">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/copyright.css?v=${projectversion}">
	</myCss>
</head>
<body>
	<!-- 顶部banner -->
	<div class="banner">
		<div>
			<a href="${appPath }/homepage" target="_blank">首页</a>
		</div>
	</div>
	<!-- 主要内容 -->
	<div class="main">
		<div class="sign">
			<ul>
				<li id="about"><a>关于我们</a></li>
				<li id="nav"><a >网站导航</a></li>
				<li id="copyright"><a>版权所有</a></li>
				<li id="link"><a>友情链接</a></li>
				<li id="contact"><a>联系我们</a></li>
				<li id="zhaopin"><a>招聘信息</a></li>
			</ul>
		</div>
		<div class="content_box">
			<div class="about aclass" id="ccc">
				<h3>关于我们</h3>
				<div class="work_photos">
					<img src="${resPath}/resources/commons/images/about.jpg">
				</div>
				<div class="company_info">
					<p>
						中国搜标网（http://www.sbiao360.com/）中国搜标网是基于服务招标采购行业的垂直电子商务门户，中国招标采购项目信息搜索先驱，通过强大的搜索技术整合了中国几乎所有的大中型招标采购项目信息，为供应商搭建了完美的销售渠道，同时聚合了大量的业主、代理机构、设计院，形成了招标采购行业里最完美的互动交流平台。
					</p>
					<p>
						中国搜标网由北京国信创新科技有限公司投资运营，授权北京华源惠通科技服务中心（有限合伙）全权负责本网的市场销售工作。
					</p>
					<p>
						目前，本网为客户提供的信息检索、信息分类、信息订阅等独家服务功能在业内都属于领先水平。未来，我们将本着“招标采购深度服务商”的经营理念，再接再厉！
					</p>
					<p class="idea">
						为用户创造一流的服务、创造商机、让用户中标中采（彩）是本网的经营理念。
					</p>
					<p class="last">
						多做一点、勤奋一些、领先一步、胜人一筹是本网的不懈追求。
					</p>
				</div>
			</div>
			<div class="webnav aclass" style="display:block;">
				<h3>网站导航</h3>
				<table cellspacing="0" cellpadding="0">
					<thead>
						<tr>
							<td><a>首页</a></td>
							<td><a>搜索</a></td>
							<td><a>行业指数</a></td>
							<td><a>排行榜</a></td>
							<td><a>关于我们</a></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><a href="${appPath }/relation">关系网</a></td>
							<td><a href="${appPath }/search">搜索结果</a></td>
							<td><a>数据概况</a></td>
							<td><a>行业指数</a></td>
							<td><a>用户细分</a></td>
						</tr>
						<tr>
							<td><a href="${appPath }/industry">行业指数</a></td>
							<td><a>统计指数</a></td>
							<td><a>行业指数</a></td>
							<td><a>热门关系网</a></td>
							<td><a>版权所有</a></td>
						</tr>
						<tr>
							<td><a href="${appPath }/ranking">排行榜</a></td>
							<td><a>项目详情</a></td>
							<td><a>用户细分</a></td>
							<td><a>热门单位</a></td>
							<td><a>友情链接</a></td>
						</tr>
						<tr>
							<td><a href="${appPath }/report">行业报告</a></td>
							<td></td>
							<td></td>
							<td><a>热门信息</a></td>
							<td><a>联系我们</a></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><a>热门行业报告</a></td>
							<td><a>招聘信息</a></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="copyright aclass">
				<h3>版权所有</h3>
				<div class="dear_user"></div>
				<p>未经中国搜标网的书面许可，对于本网站的任何内容，任何人或者单位都不得或在非本网站所属的其他服务器做镜像。
				</p>
				<div class="my_name"></div>
			</div>
			<div class="link aclass">
				<h3>友情链接</h3>
				<div class="web_links">
					<h4>
						网站链接
					</h4>
					<div>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<a href="http://www.chinabidding.com.cn" target="_blank">
										中国采购与招标网（www.chinabidding.com.cn）
									</a>
								</td>
								<td>
									<a href="http://www.zbsonline.com" target="_blank">
										招标师在线（http://www.zbsonline.com/）
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="http://www.paihang360.com" target="_blank">
										中国名企排行网（http://www.paihang360.com/）
									</a>
								</td>
								<td>
									<a href="http://www.gxzb.com.cn" target="_blank">
										国信招标集团（http://www.gxzb.com.cn/）
									</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="http://www.ctba.org.cn/" target="_blank">
										中国招标投标协会（http://www.ctba.org.cn/）
									</a>
								</td>
								<td></td>
							</tr>
						</table>	
					</div>
					<h4>合作方</h4>
					<p>
						1.必须内容丰富，专业性强。在业内有较大影响，同时在资源、内容和其它方面可以进行深入的网站。
					</p>
					<p>
						2.双方应签定书面形式的资源，内容共享协议。
					</p>
					<h4>交换链接</h4>
					<p>
						 必须事先在首页做好“中国采购与招标网”的图标链接（图标及链接地址如上）。同时需要满足下面多项条件：
					</p>
					<p>
						 1.制作精良、内容丰富并且定期更新
					</p>
					<p>
						2.定期提供资讯的网站
					</p>
					<p>
						3.首页日访问量在1000IP以上的网站
					</p>
					<p>
						4.对“中国采购与招标网”的发展提供一定帮助的网站
					</p>
					<p>
						注：所有获得推荐的网站，我们均将进行严格的审核控制。凡不符合上述条件的链接要求，恕不一一回复
					</p>
				</div>
			</div>
			<div class="contact aclass">
				<h3>联系我们</h3>
				<div class="contact_box clearfix">
					<div class="way">
						<h4>公司联系方式</h4>
						<p>
							地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：北京市海淀区安宁庄西路9号金泰富地大厦
						</p>
						<p>
							电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：010-82743196 82743157
						</p>
						<div class="way_box clearfix">
							<div class="service2">
								<h4>客户服务</h4>
								<p>
									电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：010-82743157
								</p>
								<p>
									周末咨询电话：13521375473
								</p>
								<p>
									传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：010-82743720
								</p>
							</div>
							<div class="member">
								<h4>入会咨询</h4>
								<p>
									电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：010-82743196
								</p>
								<p>
									传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：010-82744142 82743113
								</p>
							</div>
						</div>
					</div>
					<div class="service">
						<h4>项目信息咨询</h4>
						<p>
							研究报告：研究报告内容合作 010-82744228
						</p>
						<p>
							项目信息：工程项目提供合作 010-82744228
						</p>
						<h4 class="top">发布招标信息咨询</h4>
						<p>
							电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：010-82744233 82744128
						</p>
						<p>
							传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：010-82744588
						</p>
						<p>
							周末发信息咨询：13522704312
						</p>
						<p>
							电子邮箱：bid@chinabidding.com.cn
						</p>
					</div>
				</div>
				<div class="address">
					<img src="${resPath}/resources/commons/images/adress_map.jpg">
				</div>
			</div>
			<div class="recruitment aclass">
				<h3>招聘信息</h3>
				<p>暂未开放，敬请期待！</p>
			</div>
		</div>
	</div>
	<!-- 底部信息 -->
	<div class="footer-bg">
		<div class="footer clearfix">
			<ul class="clearfix">
				<li><a href="${appPath }/about#about" target="_blank">关于我们</a></li>
				<li>|</li>
				<li><a href="${appPath }/about#nav" target="_blank">网站导航</a></li>
				<li>|</li>
				<li><a href="${appPath }/about#copyright" target="_blank">版权所有</a></li>
				<li>|</li>
				<li><a href="${appPath }/about#link" target="_blank">友情链接</a></li>
				<li>|</li>
				<li><a href="${appPath }/about#contact" target="_blank">联系我们</a></li>
				<li>|</li>
				<li><a href="${appPath }/about#zhaopin" target="_blank">招聘信息</a></li>
			</ul>
			<p>©2001-2015 中国采购与招标网  京ICP证070104号</p>
		</div>
	</div>
	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/lib/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${resPath}/resources/commons/js/copyright.js?v=${projectversion}"></script>
		<script type="text/javascript">
		$(function(){
			$(window.location.hash).click();
		})
		</script>
	</myScript>
</body>
</html>