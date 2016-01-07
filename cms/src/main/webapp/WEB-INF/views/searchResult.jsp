<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/base.jsp"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>搜索结果</title>
	<myCss>
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/basic.css?v=1.0.1-20151229">
		<link rel="stylesheet" type="text/css" href="${resPath}/resources/commons/css/searchresult.css?v=1.0.1-20151229">
	</myCss>

</head>
<body>

<!-- 搜索框 -->

<!-- 搜索条件 -->
<div class="searchTerms_bg">
	<div class="searchTerms">
		<div class="timeBox clearfix">
			<div class="strong">时 间:</div>
			<i class="unlimited active" id="un" circle="">不限</i>
			<ul class="clearfix" id="opTime">
				<li circle="1">今天</li>
				<li circle="2">最近一周</li>
				<li circle="3">最近一月</li>
			</ul>
		</div>
		<div class="typeBox clearfix" id="typeBox">
			<div class="strong">内 容:</div>
			<i class="unlimited active" id="un1">不限</i>
			<ul class="type clearfix" id="dtype">
				<li>项目</li>
				<li>招标</li>
				<li>中标</li>
			</ul>
		</div>
		<div class="areaBox clearfix" id="areaBox">
		    <div class="more" id="more1"><em></em>更多</div>
			<div class="strong">地 区:</div>
			<i class="unlimited active" id="un2">不限</i>
			<ul class="area clearfix" id="dcity">
				<li id="318601">
					<span>北京</span>
					<div class="hidden">
						<a id="31860101">东城区</a>
						<a id="31860102">朝阳区</a>
						<a id="31860103">西城区</a>
						<a id="31860104">石景山区</a>
						<a id="31860105">丰台区</a>
						<a id="31860106">海淀区</a>
						<a id="31860107">通州区</a>
						<a id="31860108">平谷区</a>
						<a id="31860109">顺义区</a>
						<a id="31860110">怀柔区</a>
						<a id="31860111">密云县</a>
						<a id="31860112">延庆县</a>
						<a id="31860113">昌平区</a>
						<a id="31860114">门头沟区</a>
						<a id="31860115">房山区</a>
						<a id="31860116">大兴区</a>
					</div>
					<i></i>
				</li>
				<li id="318602">
					<span>上海</span>
					<div class="hidden" style="display: none;">
						<a id="31860201">黄浦区</a>
						<a id="31860202">徐汇区</a>
						<a id="31860203">静安区</a>
						<a id="31860204">杨浦区</a>
						<a id="31860205">长宁区</a>
						<a id="31860206">闸北区</a>
						<a id="31860207">虹口区</a>
						<a id="31860208">杨浦区</a>
						<a id="31860209">浦东区</a>
						<a id="31860210">普陀区</a>
						<a id="31860211">闵行区</a>
						<a id="31860212">南汇区</a>
						<a id="31860213">奉贤区</a>
						<a id="31860214">金山区</a>
						<a id="31860215">松江区</a>
						<a id="31860216">青浦区</a>
						<a id="31860217">嘉定区</a>
						<a id="31860218">宝山区</a>
						<a id="31860219">崇明县</a>
		
					</div>
					<i style="display: none;"></i>
				</li>
		
				<li id="318603"><span>天津</span>
					<div class="hidden">
						<a id="31860301">和平区</a>
						<a id="31860302">南开区</a>
						<a id="31860303">红桥区</a>
						<a id="31860304">河北区</a>
						<a id="31860305">河东区</a>
						<a id="31860306">河西区</a>
						<a id="31860307">东丽区</a>
						<a id="31860308">津南区</a>
						<a id="31860309">西青区</a>
						<a id="31860310">北辰区</a>
						<a id="31860311">滨海新区</a>
						<a id="31860312">宁河县</a>
						<a id="31860313">静海县</a>
						<a id="31860314">武清区</a>
						<a id="31860315">宝坻区</a>
						<a id="31860316">蓟县</a>
					</div>
					<i></i>
				</li>
		
				<li id="318604"><span>重庆</span>
					<div class="hidden">
						<a id="31860401">渝中区</a>
						<a id="31860402">江北区</a>
						<a id="31860403">沙坪坝区</a>
						<a id="31860404">九龙坡区</a>
						<a id="31860405">南岸区</a>
						<a id="31860406">大渡口区</a>
						<a id="31860407">北碚区</a>
						<a id="31860408">渝北区</a>
						<a id="31860409">长寿区</a>
						<a id="31860410">巴南区</a>
						<a id="31860411">綦江区</a>
						<a id="31860412">合川区</a>
						<a id="31860413">永川区</a>
						<a id="31860414">江津区</a>
						<a id="31860415">大足区</a>
						<a id="31860416">荣昌县</a>
						<a id="31860417">铜梁县</a>
						<a id="31860418">潼南县</a>
						<a id="31860419">璧山县</a>
						<a id="31860420">万州区</a>
						<a id="31860421">忠县</a>
						<a id="31860422">云阳县</a>
						<a id="31860423">奉节县</a>
						<a id="31860424">巫山县</a>
						<a id="31860425">梁平县</a>
						<a id="31860426">开县</a>
						<a id="31860427">巫溪县</a>
						<a id="31860428">城口县</a>
						<a id="31860429">涪陵区</a>
						<a id="31860430">丰都县</a>
						<a id="31860431">垫江县</a>
						<a id="31860432">南川区</a>
						<a id="31860433">武隆县</a>
						<a id="31860434">石柱土家族自治县</a>
						<a id="31860435">彭水苗族土家族自治县</a>
						<a id="31860436">黔江区</a>
						<a id="31860437">酉阳土家族苗族自治县</a>
						<a id="31860438">秀山土家族苗族自治县</a>
					</div>
					<i></i>
				</li>
		
				<li id="318605"><span>河北</span>
					<div class="hidden" style="display: none;">
						<a id="31860501">石家庄市</a>
						<a id="31860502">衡水市</a>
						<a id="31860503">邢台市</a>
						<a id="31860504">邯郸市</a>
						<a id="31860505">沧州市</a>
						<a id="31860506">唐山市</a>
						<a id="31860507">廊坊市</a>
						<a id="31860508">秦皇岛市</a>
						<a id="31860509">承德市</a>
						<a id="31860510">保定市</a>
						<a id="31860511">张家口市</a>
					</div>
					<i style="display: none;"></i>
				</li>
		
				<li id="318606">
					<span>山西</span>
					<div class="hidden" style="display: none;">
						<a id="31860601">太原市</a>
						<a id="31860602">晋中市</a>
						<a id="31860603">吕梁市</a>
						<a id="31860604">忻州市</a>
						<a id="31860605">朔州市</a>
						<a id="31860606">大同市</a>
						<a id="31860607">临汾市</a>
						<a id="31860608">运城市</a>
						<a id="31860609">阳泉市</a>
						<a id="31860610">长治市</a>
						<a id="31860611">晋城市</a>
				</div>
				<i style="display: none;"></i>
				</li>
		
				<li id="318607"><span>内蒙古</span><div class="hidden"><a id="31860701">呼和浩特市</a>
					<a id="31860702">乌兰察布市</a>
				<a id="31860703">包头市</a>
				<a id="31860704">巴彦淖尔市</a>
				<a id="31860705">乌海市</a>
				<a id="31860706">鄂尔多斯市</a>
				<a id="31860707">呼伦贝尔市</a>
				<a id="31860708">赤峰市</a>
				<a id="31860709">锡林郭勒盟</a>
				<a id="31860710">通辽市</a>
				<a id="31860711">兴安盟</a>
				<a id="31860712">阿拉善盟</a>
			</div><i></i>
				</li>
		
				<li id="318608"><span>辽宁</span><div class="hidden"><a id="31860801">沈阳市</a>
					<a id="31860802">辽阳市</a>
				<a id="31860803">铁岭市</a>
				<a id="31860804">抚顺市</a>
				<a id="31860805">鞍山市</a>
				<a id="31860806">营口市</a>
				<a id="31860807">大连市</a>
				<a id="31860808">本溪市</a>
				<a id="31860809">丹东市</a>
				<a id="31860810">锦州市</a>
				<a id="31860811">朝阳市</a>
				<a id="31860812">阜新市</a>
				<a id="31860813">盘锦市</a>
				<a id="31860814">葫芦岛市</a>
			</div><i></i>
				</li>
		
				<li id="318609"><span>吉林</span><div class="hidden" style="display: none;"><a id="31860901">长春市</a>
					<a id="31860902">吉林市</a>
				<a id="31860903">延边朝鲜族自治州</a>
				<a id="31860904">通化市</a>
				<a id="31860905">白山市</a>
				<a id="31860906">四平市</a>
				<a id="31860907">辽源市</a>
				<a id="31860908">白城市</a>
				<a id="31860909">松原市</a>
			</div><i style="display: none;"></i>
				</li>
		
				<li id="318610"><span>黑龙江</span><div class="hidden"><a id="31861001">哈尔滨市</a>
					<a id="31861002">绥化市</a>
				<a id="31861003">伊春市</a>
				<a id="31861004">佳木斯市</a>
				<a id="31861005">鹤岗市</a>
				<a id="31861006">七台河市</a>
				<a id="31861007">双鸭山市</a>
				<a id="31861008">牡丹江市</a>
				<a id="31861009">绥芬河市</a>
				<a id="31861010">鸡西市</a>
				<a id="31861011">齐齐哈尔市</a>
				<a id="31861012">大庆市</a>
				<a id="31861013">黑河市</a>
				<a id="31861014">大兴安岭地区</a>
			</div><i></i>
				</li>
		
				<li id="318611"><span>江苏</span><div class="hidden"><a id="31861101">南京市</a>
					<a id="31861102">镇江市</a>
				<a id="31861103">常州市</a>
				<a id="31861104">无锡市</a>
				<a id="31861105">苏州市</a>
				<a id="31861106">徐州市</a>
				<a id="31861107">连云港市</a>
				<a id="31861108">淮安市</a>
				<a id="31861109">宿迁市</a>
				<a id="31861110">盐城市</a>
				<a id="31861111">扬州市</a>
				<a id="31861112">泰州市</a>
				<a id="31861113">南通市</a>
			</div><i></i>
				</li>
		
				<li id="318612"><span>浙江</span><div class="hidden"><a id="31861201">杭州市</a>
					<a id="31861202">绍兴市</a>
				<a id="31861203">湖州市</a>
				<a id="31861204">嘉兴市</a>
				<a id="31861205">宁波市</a>
				<a id="31861206">舟山市</a>
				<a id="31861207">台州市</a>
				<a id="31861208">金华市</a>
				<a id="31861209">丽水市</a>
				<a id="31861210">衢州市</a>
				<a id="31861211">温州市</a>
			</div><i></i>
				</li>
		
				<li id="318613"><span>安徽</span><div class="hidden"><a id="31861301">合肥市</a>
					<a id="31861302">淮南市</a>
				<a id="31861303">蚌埠市</a>
				<a id="31861304">宿州市</a>
				<a id="31861305">淮北市</a>
				<a id="31861306">阜阳市</a>
				<a id="31861307">毫州市</a>
				<a id="31861308">六安市</a>
				<a id="31861309">滁州市</a>
				<a id="31861310">芜湖市</a>
				<a id="31861311">宣城市</a>
				<a id="31861312">广德县</a>
				<a id="31861313">黄山市</a>
				<a id="31861314">马鞍山市</a>
				<a id="31861315">铜陵市</a>
				<a id="31861316">安庆市</a>
				<a id="31861317">宿松县</a>
				<a id="31861318">池州市</a>
			</div><i></i>
				</li>
		
				<li id="318614"><span>福建</span><div class="hidden"><a id="31861401">福州市</a>
					<a id="31861402">莆田市</a>
				<a id="31861403">宁德市</a>
				<a id="31861404">厦门市</a>
				<a id="31861405">泉州市</a>
				<a id="31861406">漳州市</a>
				<a id="31861407">南平市</a>
				<a id="31861408">龙岩市</a>
				<a id="31861409">三明市</a>
			</div><i></i>
				</li>
		
				<li id="318615" class="rightli"><span>江西</span><div class="hidden"><a id="31861501">南昌市</a>
					<a id="31861502">九江市</a>
				<a id="31861503">景德镇市</a>
				<a id="31861504">上饶市</a>
				<a id="31861505">鹰潭市</a>
				<a id="31861506">宜春市</a>
				<a id="31861507">萍乡市</a>
				<a id="31861508">新余市</a>
				<a id="31861509">赣州市</a>
				<a id="31861510">吉安市</a>
				<a id="31861511">抚州市</a>
			</div><i></i>
				</li>
		
				<li id="318616" class="rightli"><span>山东</span><div class="hidden"><a id="31861601">济南市</a>
					<a id="31861602">聊城市</a>
				<a id="31861603">德州市</a>
				<a id="31861604">淄博市</a>
				<a id="31861605">滨州市</a>
				<a id="31861606">东营市</a>
				<a id="31861607">潍坊市</a>
				<a id="31861608">烟台市</a>
				<a id="31861609">威海市</a>
				<a id="31861610">青岛市</a>
				<a id="31861611">泰安市</a>
				<a id="31861612">莱芜市</a>
				<a id="31861613">济宁市</a>
				<a id="31861614">菏泽市</a>
				<a id="31861615">临沂市</a>
				<a id="31861616">日照市</a>
				<a id="31861617">枣庄市</a>
			</div><i></i>
				</li>
		
				<li id="318617" class="rightli"><span>河南</span><div class="hidden"><a id="31861701">郑州市</a>
					<a id="31861702">巩义市</a>
				<a id="31861703">新乡市</a>
				<a id="31861704">长垣县</a>
				<a id="31861705">焦作市</a>
				<a id="31861706">济源市</a>
				<a id="31861707">安阳市</a>
				<a id="31861708">滑县</a>
				<a id="31861709">濮阳市</a>
				<a id="31861710">鹤壁市</a>
				<a id="31861711">许昌市</a>
				<a id="31861712">漯河市</a>
				<a id="31861713">驻马店市</a>
				<a id="31861714">新蔡县</a>
				<a id="31861715">信阳市</a>
				<a id="31861716">固始县</a>
				<a id="31861717">周口市</a>
				<a id="31861718">平顶山市</a>
				<a id="31861719">汝州市</a>
				<a id="31861720">洛阳市</a>
				<a id="31861721">三门峡市</a>
				<a id="31861722">南阳市</a>
				<a id="31861723">邓州市</a>
				<a id="31861724">开封市</a>
				<a id="31861725">兰考县</a>
				<a id="31861726">商丘市</a>
				<a id="31861727">永城市</a>
				<a id="31861728">鹿邑县</a>
			</div><i></i>
				</li>
		
				<li id="318618" class="liHidden2"><span>湖北</span><div class="hidden"><a id="31861801">武汉市</a>
					<a id="31861802">天门市</a>
				<a id="31861803">孝感市</a>
				<a id="31861804">仙桃市</a>
				<a id="31861805">潜江市</a>
				<a id="31861806">荆州市</a>
				<a id="31861807">黄石市</a>
				<a id="31861808">鄂州市</a>
				<a id="31861809">咸宁市</a>
				<a id="31861810">黄冈市</a>
				<a id="31861811">襄阳市</a>
				<a id="31861812">随州市</a>
				<a id="31861813">十堰市</a>
				<a id="31861814">神农架林区</a>
				<a id="31861815">宜昌市</a>
				<a id="31861816">恩施土家族苗族自治州</a>
				<a id="31861817">荆门市</a>
			</div><i></i>
				</li>
		
				<li id="318619" class="liHidden2"><span>湖南</span><div class="hidden"><a id="31861901">长沙市</a>
					<a id="31861902">湘潭市</a>
				<a id="31861903">株洲市</a>
				<a id="31861904">益阳市</a>
				<a id="31861905">岳阳市</a>
				<a id="31861906">常德市</a>
				<a id="31861907">湘西土家苗族自治州</a>
				<a id="31861908">娄底市</a>
				<a id="31861909">怀化市</a>
				<a id="31861910">衡阳市</a>
				<a id="31861911">邵阳市</a>
				<a id="31861912">郴州市</a>
				<a id="31861913">永州市</a>
				<a id="31861914">张家界市</a>
			</div><i></i>
				</li>
		
				<li id="318620" class="liHidden2"><span>广东</span><div class="hidden"><a id="31862001">广州市</a>
					<a id="31862002">清远市</a>
				<a id="31862003">韶关市</a>
				<a id="31862004">梅州市</a>
				<a id="31862005">汕头市</a>
				<a id="31862006">惠州市</a>
				<a id="31862007">汕尾市</a>
				<a id="31862008">河源市</a>
				<a id="31862009">深圳市</a>
				<a id="31862010">珠海市</a>
				<a id="31862011">潮州市</a>
				<a id="31862012">揭阳市</a>
				<a id="31862013">东莞市</a>
				<a id="31862014">湛江市</a>
				<a id="31862015">茂名市</a>
				<a id="31862016">肇庆市</a>
				<a id="31862017">云浮市</a>
				<a id="31862018">佛山市</a>
				<a id="31862019">中山市</a>
				<a id="31862020">江门市</a>
				<a id="31862021">阳江市</a>
			</div><i></i>
				</li>
		
				<li id="318621" class="liHidden2"><span>广西</span><div class="hidden"><a id="31862101">南宁市</a>
				<a id="31862102">崇左市</a>
				<a id="31862103">凭祥市</a>
				<a id="31862104">百色市</a>
				<a id="31862105">钦州市</a>
				<a id="31862106">北海市</a>
				<a id="31862107">玉林市</a>
				<a id="31862108">贵港市</a>
				<a id="31862109">防城港市</a>
				<a id="31862110">桂林市</a>
				<a id="31862111">贺州市</a>
				<a id="31862112">梧州市</a>
				<a id="31862113">柳州市</a>
				<a id="31862114">来宾市</a>
				<a id="31862115">宜州市</a>
				<a id="31862116">合山市</a>
				<a id="31862117">河池市</a>
			</div><i></i>
				</li>
		
				<li id="318622" class="liHidden2"><span>海南</span><div class="hidden"><a id="31862201">海口市</a>
					<a id="31862202">定安县</a>
				<a id="31862203">文昌市</a>
				<a id="31862204">琼海市</a>
				<a id="31862205">万宁市</a>
				<a id="31862206">屯昌县</a>
				<a id="31862207">儋州市</a>
				<a id="31862208">临高县</a>
				<a id="31862209">澄迈县</a>
				<a id="31862210">三亚市</a>
				<a id="31862211">五指山市</a>
				<a id="31862212">保亭黎族苗族自治县</a>
				<a id="31862213">陵水黎族自治县</a>
				<a id="31862214">乐东黎族自治县</a>
				<a id="31862215">东方市</a>
				<a id="31862216">昌江黎族自治县</a>
				<a id="31862217">白沙黎族自治县</a>
				<a id="31862218">琼中黎族苗族自治县</a>
				<a id="31862219">三沙市</a>
			</div><i></i>
				</li>
		
				<li id="318623" class="liHidden2">
					<span>贵州</span>
					<div class="hidden">
						<a id="31862301">贵阳市</a>
						<a id="31862302">毕节地区</a>
						<a id="31862303">六盘水市</a>
						<a id="31862304">铜仁地区</a>
						<a id="31862305">黔东南苗族侗族自治州</a>
						<a id="31862306">黔南布衣族苗族自治州</a>
						<a id="31862307">安顺市</a>
						<a id="31862308">黔西南布衣族苗族自治州</a>
						<a id="31862309">遵义市</a>
				   </div>
				   <i></i>
				</li>
		
				<li id="318624" class="liHidden2"><span>云南</span><div class="hidden"><a id="31862401">昆明市</a>
					<a id="31862402">玉溪市</a>
				<a id="31862403">曲靖市</a>
				<a id="31862404">昭通市</a>
				<a id="31862405">红河哈尼族黎族自治州</a>
				<a id="31862406">文山壮族苗族自治州</a>
				<a id="31862407">普洱市</a>
				<a id="31862408">西双版纳傣族自治州</a>
				<a id="31862409">大理白族自治州</a>
				<a id="31862410">怒江傈僳族自治州</a>
				<a id="31862411">丽江市</a>
				<a id="31862412">迪庆藏族自治区</a>
				<a id="31862413">楚雄彝族自治州</a>
				<a id="31862414">临沧傈僳族自治州</a>
				<a id="31862415">宝山市</a>
				<a id="31862416">德宏傣族景颇族自治州</a>
			</div><i></i>
				</li>
		
				<li id="318625" class="liHidden2"><span>西藏</span><div class="hidden"><a id="31862501">拉萨市</a>
					<a id="31862502">那曲地区</a>
				<a id="31862503">昌都地区</a>
				<a id="31862504">山南地区</a>
				<a id="31862505">日喀则地区</a>
				<a id="31862506">阿里地区</a>
				<a id="31862507">林芝地区</a>
			</div><i></i>
				</li>
		
				<li id="318626" class="liHidden2"><span>陕西</span><div class="hidden"><a id="31862601">西安市</a>
					<a id="31862602">咸阳市</a>
				<a id="31862603">渭南市</a>
				<a id="31862604">延安市</a>
				<a id="31862605">榆林市</a>
				<a id="31862606">宝鸡市</a>
				<a id="31862607">汉中市</a>
				<a id="31862608">安康市</a>
				<a id="31862609">商洛市</a>
				<a id="31862610">铜川市</a>
			</div><i></i>
				</li>
		
				<li id="318627" class="liHidden2"><span>四川</span><div class="hidden"><a id="31862701">成都市</a>
					<a id="31862702">乐山市</a>
				<a id="31862703">凉山彝族自治州</a>
				<a id="31862704">攀枝花市</a>
				<a id="31862705">德阳市</a>
				<a id="31862706">眉山市</a>
				<a id="31862707">绵阳市</a>
				<a id="31862708">阿坝藏族羌族自治州</a>
				<a id="31862709">雅安市</a>
				<a id="31862710">甘孜藏族自治州</a>
				<a id="31862711">广元市</a>
				<a id="31862712">遂宁市</a>
				<a id="31862713">达州市</a>
				<a id="31862714">巴中市</a>
				<a id="31862715">南充市</a>
				<a id="31862716">广安市</a>
				<a id="31862717">内江市</a>
				<a id="31862718">资阳市</a>
				<a id="31862719">自贡市</a>
				<a id="31862720">宜宾市</a>
				<a id="31862721">泸州市</a>
			</div><i></i>
				</li>
		
				<li id="318628" class="liHidden2"><span>甘肃</span><div class="hidden"><a id="31862801">兰州市</a>
					<a id="31862802">白银市</a>
				<a id="31862803">临夏回族自治州</a>
				<a id="31862804">武威市</a>
				<a id="31862805">张掖市</a>
				<a id="31862806">酒泉市</a>
				<a id="31862807">嘉峪关市</a>
				<a id="31862808">玉门市</a>
				<a id="31862809">敦煌市</a>
				<a id="31862810">金昌市</a>
				<a id="31862811">天水市</a>
				<a id="31862812">陇南市</a>
				<a id="31862813">定西市</a>
				<a id="31862814">平凉市</a>
				<a id="31862815">庆阳市</a>
				<a id="31862816">甘南藏族自治州</a>
			</div><i></i>
				</li>
		
				<li id="318629" class="liHidden2"><span>青海</span><div class="hidden"><a id="31862901">西宁市</a>
					<a id="31862902">海东地区</a>
				<a id="31862903">黄南藏族自治州</a>
				<a id="31862904">海北藏族自治州</a>
				<a id="31862905">海南藏族自治州</a>
				<a id="31862906">果洛藏族自治州</a>
				<a id="31862907">玉树藏族自治州</a>
				<a id="31862908">海西蒙古族藏族自治州</a>
			</div><i></i>
				</li>
		
				<li id="318630" class="liHidden2"><span>新疆</span><div class="hidden"><a id="31863001">乌鲁木齐市</a>
					<a id="31863002">昌吉回族自治州</a>
				<a id="31863003">五家渠市</a>
				<a id="31863004">石河子市</a>
				<a id="31863005">博尔塔拉蒙古自治州</a>
				<a id="31863006">双河市</a>
				<a id="31863007">克拉玛依市</a>
				<a id="31863008">塔城地区</a>
				<a id="31863009">伊犁哈萨克自治州</a>
				<a id="31863010">北屯市</a>
				<a id="31863011">阿勒泰地区</a>
				<a id="31863012">吐鲁番地区</a>
				<a id="31863013">哈密地区</a>
				<a id="31863014">巴音郭楞蒙古自治州</a>
				<a id="31863015">阿克苏地区</a>
				<a id="31863016">阿拉尔市</a>
				<a id="31863017">喀什地区</a>
				<a id="31863018">图木舒克市</a>
				<a id="31863019">克孜勒苏柯尔克孜自治州</a>
				<a id="31863020">和田地区</a>
			</div><i></i>
				</li>
		
				<li id="318631" class="liHidden2"><span>宁夏</span><div class="hidden"><a id="31863101">银川市</a>
					<a id="31863102">吴忠市</a>
				<a id="31863103">石嘴山市</a>
				<a id="31863104">中卫市</a>
				<a id="31863105">固原市</a>
			</div><i></i>
				</li>
		
				<li id="318632" class="liHidden2"><span>香港</span>
				</li>
		
				<li id="318633" class="liHidden2"><span>澳门</span>
				</li>
		
				<li id="318634" class="liHidden2"><span>台湾</span>
				</li>
		
		
			</ul>
		</div>
		<div class="tradeBox clearfix" id="tradeBox">
		    <div class="more">更多<em></em></div>
			<div class="strong">行 业:</div>
			<i class="unlimited active" id="un3">不限</i>
			<ul class="trade clearfix" id="dtrade">
				<li id ="2101">
					<span >冶金矿产原材料</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id ="210101">建材工业</a>
						<a href="javascript:;" id ="210102">金属矿采选</a>
						<a href="javascript:;" id ="210103">非金属矿采选</a>
						<a href="javascript:;" id ="210104">金属冶炼</a>
						<a href="javascript:;" id ="210105">非金属矿物制造</a>
					</p>
				</li>
				<li  id="2102">
					<span>能源</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id ="210201">煤炭</a>
						<a href="javascript:;" id ="210202">石油</a>
						<a href="javascript:;" id ="210203">天然气</a>
						<a href="javascript:;" id ="210204">电网建设</a>
						<a href="javascript:;" id ="210205">火力发电</a>
						<a href="javascript:;" id ="210206">水力发电</a>
						<a href="javascript:;" id ="210207">核力发电</a>
						<a href="javascript:;" id ="210208">风力发电</a>
						<a href="javascript:;" id ="210209">太阳能发电</a>
						<a href="javascript:;" id ="210210">垃圾焚烧发电</a>
						<a href="javascript:;" id ="210211">其他电力发电</a>
						<a href="javascript:;" id ="210212">热力生产</a>
					</p class="hidden">
				</li>
				<li id="2103">
					<span>农业水利</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id ="210301">农林牧渔</a>
						<a href="javascript:;" id ="210302">水库引水</a>
						<a href="javascript:;" id ="210303">水利枢纽</a>
						<a href="javascript:;" id ="210304">防洪堤防护堤</a>
						<a href="javascript:;" id ="210305">围海造地</a>
						<a href="javascript:;" id ="210306">河湖整治</a>
						<a href="javascript:;" id ="210307">灌溉工程</a>
						<a href="javascript:; "id ="210308">农田整治</a>
					</p>
				</li>
				<li id="2104">
					<span>环保</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id ="210401">垃圾处理</a>
						<a href="javascript:;" id ="210402">水处理</a>
						<a href="javascript:;" id ="210403">废弃物处理</a>
						<a href="javascript:;" id ="210404">废气处理</a>
						<a href="javascript:;" id ="210405">污泥治理</a>
					</p>
				</li>
				<li id="2105">
					<span >交通运输</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="210501">铁路</a>
						<a href="javascript:;" id="210502">轨道交通</a>
						<a href="javascript:;" id="210503">水利枢纽</a>
						<a href="javascript:;" id="210504">高速公路</a>
						<a href="javascript:;" id="210505">道路</a>
						<a href="javascript:;" id="210506">港口</a>
						<a href="javascript:;" id="210507">机场</a>
						<a href="javascript:;" id="210508">交通枢纽</a>
						<a href="javascript:;" id="210509">桥涵</a>
						<a href="javascript:;" id="210510">管道运输</a>
					</p>
				</li>
				<li id="2106">
					<span >网络通讯</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="210601">通信与通讯</a>
						<a href="javascript:;" id="210602">互联网和相关服务</a>
						<a href="javascript:;" id="210603">软件和信息技术服务业</a>
						<a href="javascript:;" id="210604">计算机及周边硬件</a>
					</p>
				</li>
				<li id="2107">
					<span >医疗卫生</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="210701">医院</a>
						<a href="javascript:;" id="210702">医药制造</a>
						<a href="javascript:;" id="210703">医疗设备</a>
					</p>
				</li>
				<li id="2108">
					<span >房地产建筑</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="210801">房屋建筑</a>
						<a href="javascript:;" id="210802">建筑安装</a>
						<a href="javascript:;" id="210803">建筑装饰</a>
						<a href="javascript:;" id="210804">土地整治</a>
						<a href="javascript:;" id="210805">仓储物流工程</a>
					</p>
				</li>
				<li id="2109">
					<span >公共设施</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="210901">市政市容设施</a>
						<a href="javascript:;" id="210902">供热</a>
					</p>
				</li>
				<li id="2110">
					<span >科技文教旅游</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="211001">旅游景区</a>
						<a href="javascript:;" id="211002">新闻出版</a>
						<a href="javascript:;" id="211003">广播影视</a>
					</p>
				</li>
				<li id="2111">
					<span >轻工</span>
					<i></i>
					<p class="hidden rightli">
						<a href="javascript:;" id="211101">办公家具</a>
						<a href="javascript:;" id="211102">食品</a>
						<a href="javascript:;" id="211103">卷烟制品</a>
						<a href="javascript:;" id="211104">纺织</a>
						<a href="javascript:;" id="211105">木材加工及制品</a>
						<a href="javascript:;" id="211106">造纸</a>
						<a href="javascript:;" id="211107">其他</a>
					</p>
				</li>
				<li id="2112">
					<span >化工</span>
					<i></i>
					<p class="hidden  rightli">
						<a href="javascript:;" id="211201">化学制品</a>
						<a href="javascript:;" id="211202">煤化工</a>
					</p>
				</li>
				<li class="liHidden" id="2113">
					<span >机械电子</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="211301">机械设备</a>
						<a href="javascript:;" id="211302">电子产品</a>
						<a href="javascript:;" id="211303">仪器仪表</a>
						<a href="javascript:;" id="211304">造船造车</a>
					</p>
				</li>
				<li class="liHidden" id="2114">
					<span >商务服务</span>
					<i></i>
					<p class="hidden">
						<a href="javascript:;" id="211401">餐饮服务</a>
						<a href="javascript:;" id="211402">租赁服务</a>
						<a href="javascript:;" id="211403">物业服务</a>
						<a href="javascript:;" id="211404">培训服务</a>
						<a href="javascript:;" id="211405">保险服务</a>
						<a href="javascript:;" id="211406">法律服务</a>
						<a href="javascript:;" id="211407">招标代理</a>
						<a href="javascript:;" id="211408">可研</a>
						<a href="javascript:;" id="211409">勘察设计</a>
						<a href="javascript:;" id="211410">监理</a>
						<a href="javascript:;" id="211411">造价咨询</a>
						<a href="javascript:;" id="211412">洗涤服务</a>
						<a href="javascript:;" id="211413">安保服务</a>
						<a href="javascript:;" id="211414">外包服务</a>
						<a href="javascript:;" id="211415">调查服务</a>
						<a href="javascript:;" id="211416">管理服务</a>
						<a href="javascript:;" id="211417">安装维修服务</a>
						<a href="javascript:;" id="211418">仓储物流服务</a>
						<a href="javascript:;" id="211419">金融服务</a>
						<a href="javascript:;" id="211420">其他</a>
					</p>
				</li>
				<li class="liHidden" id="2115">
					<span >其他</span>
					<i></i>
					<p class="hidden">
					<a href="javascript:;" id="211501">其他</a>
					</p>
				</li>
			</ul>
		</div>
		<div class="termBox clearfix">
			<div class="strong2"  id="de">已选条件:</div>
			<div class="term" id="term">
				<div class="Checktime clearfix">
					<h5>时间：</h5>
					<p class="span" id="Checktime"></p>
				</div>
				<div class="term1 clearfix">
					<h5>内容：</h5>
					<p class="span" id="term1"></p>
				</div>
				<div class="term2 clearfix">
					<h5>地区：</h5>
					<p class="span" id="term2"></p>
				</div>
				<div class="term3">
					<h5>行业：</h5>
					<p class="span" id="term3"></p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 搜索结果图 -->

<div class='chartCon'>
	<div class='chart'>
		<div class='title'>
			<span class='sTitle'>搜索信息比例图</span>
			<div class='time'>
					<div class='innerTime'>
						<span class='start'>2014.01</span> -
						<span class='end'>2015.12</span>
					</div>
					<i class='daShow'>
					</i>
					<div class='dataWindow' style='height:0px'>
						<div class='dataTab'>
							<ul>
								<li class='selected'>开始年月</li>
								<li>终止年月</li>
							</ul>
						</div>

						<div class='dYear'>
							<ul>
								<li class="liYear">2001年</li>
								<li class="liYear">2002年</li>
								<li class="liYear">2003年</li>
								<li class="liYear">2004年</li>
								<li class="liYear">2005年</li>
								<li class="liYear">2006年</li>
								<li class="liYear">2007年</li>
								<li class="liYear">2008年</li>
								<li class="liYear">2009年</li>
								<li class="liYear">2010年</li>
								<li class="liYear">2011年</li>
								<li class="liYear selected">2012年</li>
								<li class="liYear">2013年</li>
								<li class="liYear">2014年</li>
								<li class="liYear">2015年</li>
								<li class="liYear">2016年</li>
							</ul>
						</div>
							<div class='dMonth'>
							<ul>
								<li class="liMonth selected">1月</li>
								<li class="liMonth">2月</li>
								<li class="liMonth">3月</li>
								<li class="liMonth">4月</li>
								<li class="liMonth">5月</li>
								<li class="liMonth">6月</li>
								<li class="liMonth">7月</li>
								<li class="liMonth">8月</li>
								<li class="liMonth">9月</li>
								<li class="liMonth">10月</li>
								<li class="liMonth">11月</li>
								<li class="liMonth">12月</li>
							</ul>
						</div> 
					</div>
			</div>
		</div>
		<div class='chartwrap'>
			<div class='left'>
			</div>
			<div class="right">
				<div class='chart1'>
				</div>
				<div class='chart2'></div>
			</div>
		</div>
	</div>
</div>
<!-- 搜索结果 -->
<div class="result">
	<h3>搜索信息结果<span>（共用<em id="s_time">${time}</em>秒搜索到<span id="num_span">${count}</span>条）</span><i></i></h3>
	<ul class="resultList" id="list">
		<c:forEach var="indexInfo" items="${listIndex}">
			<li>
				<h4 class="clearfix">
					<a href="${appPath }/detail/${indexInfo.id}" class="h" id="info_${indexInfo.id}" onclick="javascript:custBehaviorClick(2, ${indexInfo.infoType}, '${indexInfo.id}', 1);">${indexInfo.title}</a>
					<a href="${appPath }/relation<c:if test="${indexInfo.projectName!=null}">?name=${indexInfo.projectName}</c:if>"  onclick="javascript:custBehaviorClick(2, '1', '${indexInfo.id}', 1);" class="rpage"></a>
				</h4>
				<p>
					${indexInfo.description}
				</p>
				<div class="clearfix">
					<div class="s_label clearfix">
						<a class="ind">${indexInfo.category}</a>
						<a class="add">${indexInfo.areaName}</a>
						<a class="bid">${indexInfo.type}</a>
					</div>
					<div class="info clearfix">
						<span class="time">发布时间：<i>${indexInfo.publishDate}</i></span>
						<div class="navBox clearfix">
							<div class="ap" actiontype="3" infotype="${indexInfo.infoType}" infoid="${indexInfo.id}" >
								<i class="attention"></i>
								<a href="javascript:;">关注</a>
								<span class="re">已关注</span>
							</div>
							<div class="cp" actiontype="4" infotype="${indexInfo.infoType}" infoid="${indexInfo.id}" >
								<i class="collection"></i>
								<a href="javascript:;">收藏</a>
								<span class="re">已收藏</span>
							</div>
							<div class="sp">
								<a href="javascript:;" class="share">分享</a>
								<div class="shareBtn bdsharebuttonbox">
									<a href="#" onclick="javascript:custBehaviorShare(5, ${indexInfo.infoType}, '${indexInfo.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
									<a href="#" onclick="javascript:custBehaviorShare(5, ${indexInfo.infoType}, '${indexInfo.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
									<a href="#" onclick="javascript:custBehaviorShare(5, ${indexInfo.infoType}, '${indexInfo.id}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
								</div>
								<em></em>
							</div>			
						</div>
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
<!-- 错误提示框 -->
<div class="errorMessage">
	<h6>网页提示</h6>
	<p>未知错误，请求异常</p>
	<div class="clearfix">
		<a class="cancel">取消</a>
		<a class="ensure">确定</a>
	</div>
</div>

<!-- 分页-->
<div class="page">
	<form id="pageForm">
		<div class="paging">
			<!-- 
			<input type="button" value="确定" class="sure">
			<p><i>跳转</i><input type="text" name="" class="span"><i>页</i></p>	
			 -->
				<div class="tcdPageCode">
	 			</div>
		</div>
	</form>
</div>


<!-- 相关搜索 -->
<div class="rel-search">
	<div class="rSearch">
		<h4>相关搜索</h4>
		<c:forEach var="likeKeyWord" items="${likeKeyWords}">
			<a href="${appPath}/search?keyword=${likeKeyWord.keywords}">${likeKeyWord.keywords}</a>
		</c:forEach>
	</div>
</div>
<script type="text/html" id="listTemp">
			<li>
				<h4 class="clearfix">
					<a href="${appPath }/detail/{indexInfo.id}" class="h" id="info_{indexInfo.id}" onclick="javascript:custBehaviorClick(2, {indexInfo.infoType}, '{indexInfo.id}', 1);">{indexInfo.title}</a>
					<a href="${appPath }/relation{projectName}" onclick="javascript:custBehaviorClick(2, '1', '{indexInfo.id}', 1);" class="rpage"></a>
				</h4>
				<p>
					{indexInfo.description}
				</p>
				<div class="clearfix">
					<div class="s_label clearfix">
						<a class="ind">{indexInfo.category}</a>
						<a class="add">{indexInfo.areaName}</a>
						<a class="bid">{indexInfo.type}</a>
					</div>
					<div class="info clearfix">
						<span class="time">发布时间：<i>{indexInfo.publishDate}</i></span>
						<div class="navBox clearfix">
							<div class="ap" actiontype="3" infotype="{indexInfo.infoType}" infoid="{indexInfo.id}" >
								<i class="attention"></i>
								<a href="javascript:;">关注</a>
								<span class="re">已关注</span>
							</div>
							<div class="cp" actiontype="4" infotype="{indexInfo.infoType}" infoid="{indexInfo.id}" >
								<i class="collection"></i>
								<a href="javascript:;">收藏</a>
								<span class="re">已收藏</span>
							</div>
							<div class="sp">
								<a href="javascript:;" class="share">分享</a>
								<div class="shareBtn bdsharebuttonbox">
									<a href="#" onclick="javascript:custBehaviorShare(5, {indexInfo.infoType}, '{indexInfo.id}', 'QQ空间');" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
									<a href="#" onclick="javascript:custBehaviorShare(5, {indexInfo.infoType}, '{indexInfo.id}', '新浪微博');" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
									<a href="#" onclick="javascript:custBehaviorShare(5, {indexInfo.infoType}, '{indexInfo.id}', '微信');" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
								</div>
								<em></em>
							</div>			
						</div>
					</div>
				</div>
			</li>
</script>

	<myScript>
		<script type="text/javascript" src="${resPath}/resources/commons/js/custBehavior.js?v=1.0.1-20151229"></script>
	</myScript>
<%@include file="dialogLogin/loginDialog.jsp"%>
<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/sea.js?v=1.0.1-20151229"></script>
<script type="text/javascript" src="${resPath}/resources/commons/js/lib/seajs/config.js?v=1.0.1-20151229"></script>
<script type="text/javascript">

	// 入口模块
	seajs.use("${resPath}/resources/commons/js/searchresult");
</script>
</body>
</html>