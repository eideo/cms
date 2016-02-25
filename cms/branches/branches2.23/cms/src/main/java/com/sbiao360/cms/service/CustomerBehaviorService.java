package com.sbiao360.cms.service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sbiao360.cms.dao.CustomerBehaviorDao;
import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.domain.HotwordMap;

/**
 * 用户行为服务层
 * 
 * @author yujunwei
 */

@Service
public class CustomerBehaviorService {

	private static String hotword;

	@Resource
	private CustomerBehaviorDao customerBehaviorDao;

	// 用户行为-关注项目
	public int insertCustomerAttention(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-收藏项目
	public int insertCustomerCollection(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-分享项目
	public int insertCustomerShare(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-点击详细页
	public int insertCustomerClickDetailPage(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-点击关系网
	public int insertCustomerClickRelNetwork(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-点击搜索条件
	public int insertCustomerTopClick(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-访问页面记录
	public int insertCustomerAccessLog(CustBehavior custBehavior) {
		return this.customerBehaviorDao.save(custBehavior);
	}

	// 用户行为-更新
	public int updateByProperties(CustBehavior custBehavior) {
		return this.customerBehaviorDao.updateByProperties(custBehavior);
	}

	// 用户行为-更新
	public int updateByFoot(Map<String, Object> paraMap) {
		return this.customerBehaviorDao.updateByFoot(paraMap);
	}

	public boolean exist(CustBehavior custBehavior) {
		return this.customerBehaviorDao.exist(custBehavior);
	}

	// 用户行为-热词搜索
	public List<HotwordMap> getHotwordMapList() {
		return this.customerBehaviorDao.getHotwordMapList();
	}

	public String getHotwordInit() {
		HotwordMap hotwordMap = this.customerBehaviorDao.getInitHotwordMap();
		JSONObject hotword = new JSONObject();
		hotword.put("hotWord", hotwordMap.getHotWord());
		hotword.put("areaName", hotwordMap.getAreaName());
		return hotword.toString();
	}

	// IP对应省份
	public String getAreaByIp(Long ip) {
		String location = customerBehaviorDao.getLocation(ip);

		return getAreaByLocation(location);
	}

	// 匹配地址对应的省份
	public String getAreaByLocation(String location) {
		String area = "";
		if (null == location) {
			return area;
		}
		String regex = "^(北京|上海|天津|重庆|河北|山西|内蒙古|辽宁|吉林|黑龙江|江苏|浙江|安徽|福建|江西|山东|河南|湖北|湖南|广东|广西|海南|贵州|云南|西藏|陕西|四川|甘肃|青海|新疆|宁夏|香港|澳门|台湾)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(location);
		if (matcher.find()) {
			area = matcher.group(1);
		}
		return area;
	}

	@Cacheable(value = "commonCache", key = "'newkeyword'")
	public String getHotword() {
		return hotword;
	}

	@CachePut(value = "commonCache", key = "'newkeyword'")
	public String setHotword(String hotwordstr) {
		hotword = hotwordstr;
		return hotwordstr;
	}

	@CachePut(value = "commonCache", key = "'newkeyword'")
	public String setHotwordRandom() {
		String[] areaArr = { "北京", "上海", "天津", "重庆", "河北", "山西", "内蒙古", "辽宁",
				"吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北",
				"湖南", "广东", "广西", "海南", "贵州", "云南", "西藏", "陕西", "四川", "甘肃",
				"青海", "新疆", "宁夏", "香港", "澳门", "台湾" };
		String[] hotwordArr = { "局放", "油漆", "测温", "电缆普查", "红外", "中国平安", "异形保温",
				"装饰", "输送机", "阀门", "杭黄", "辐射", "钢管", "中国人寿", "二次招标", "二氧化碳",
				"人防门", "医疗设备", "华龙区", "多媒体箱", "水质分析仪表", "氷济市韩阳镇", "浓密机",
				"天然气辐射", "低电压穿越", "住宅供电", "供氧设备", "供热", "供热节能", "供热节能管理",
				"供电局", "促销", "保定水处理", "保洁服务", "保温管", "保险", "停车设备", "光伏汇流箱",
				"光大金控", "光电色选设备", "光缆终端盒", "汽轮机维修", "浓缩机", "农残", "农药", "农药残",
				"冷却塔", "冷却塔风机", "净水设备", "净油", "出版印刷", "分拣线公告", "刑侦", "初设深度",
				"刮板机", "剑阁检测站", "剪草机", "办公", "办公家具", "加工中心", "加油机", "动力", "劳保",
				"包头市大青山", "包头市水务局", "化学清洗", "北海电厂", "区域电网调度", "医疗卫生", "华博",
				"华润", "华电", "华能", "单警", "南充东湖东路", "南平工程", "南通", "南通港", "南通港除尘",
				"南通除尘", "博物馆中标", "博贺", "卡口", "压力容器", "厨房用具", "叉车", "双牌", "变压器",
				"变频", "可燃", "启动锅炉", "吸泥机", "周转箱", "哈密", "商业服务", "喷射器", "喷灌",
				"喷灌机", "喷灌设备", "国家高速公路", "国际空运", "土工格栅", "在线监测", "塔内件", "填埋场",
				"墒情测试", "墒情监测设备", "声屏", "声障", "备件", "复兴公司", "外加剂", "大唐林州热电",
				"大庆油田", "大理石平板", "无功", "昆明供电局", "昌邑", "明星电缆", "智蓝", "服装",
				"机井灌溉", "材料", "束管", "束管监测", "枢纽", "查干淖尔", "标准电阻箱", "标志牌", "标识",
				"核子秤", "桂粤界", "梅州", "检测卡", "检测条", "检测箱", "检测试剂", "检测试纸", "检测车",
				"棉门帘", "棒磨机", "模温机", "止四", "正宁电厂", "正文", "正阳", "武川", "武穴年鉴",
				"母线", "母线槽", "毛衣", "毫伏表校准仪", "气体灭火设备", "水利", "水利桥梁", "水泵",
				"水溶肥料", "水稻", "水表检测" };
		int areaCount = areaArr.length;
		int hotwordCount = hotwordArr.length;
		Random random = new Random();
		int randomArea = random.nextInt(areaCount);
		int randomHotword = random.nextInt(hotwordCount);
		JSONObject hotwordJson = new JSONObject();
		hotwordJson.put("areaName", areaArr[randomArea]);
		hotwordJson.put("hotWord", hotwordArr[randomHotword]);
		String hotwordstr = hotwordJson.toString();
		hotword = hotwordstr;
		return hotwordstr;
	}

}
