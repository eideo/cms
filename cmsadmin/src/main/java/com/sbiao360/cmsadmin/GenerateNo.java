package com.sbiao360.cmsadmin;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateNo {
	/**
	 * 生成系统流水号
	 * 
	 * @return 流水号字符
	 */
	public static String generateNo() {

		// 接收流水号
		String generId = "";

		// 生成5位随机数
		int radomInt = new Random().nextInt(99999);

		// 获取系统当前时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateInfo = formatter.format(new Date());

		// 当前系统时分秒加上五位随机数,生成流水号
		generId = dateInfo + String.valueOf(radomInt);
		return generId;
	}

	public static float getFloatDivVal(Float total, Integer output) {
		BigDecimal a = new BigDecimal(Float.toString(total));
		BigDecimal b = new BigDecimal(Integer.toString(output));
		return a.divide(b, 2, BigDecimal.ROUND_HALF_DOWN).floatValue();
	}
	
	public static BigDecimal getMultiplyVal(BigDecimal reportPriceBd,
			BigDecimal reportDiscount) {
		BigDecimal defDivScale = new BigDecimal("10");
		reportDiscount = reportDiscount.divide(defDivScale);
		BigDecimal reportTpriceBd = reportPriceBd.multiply(reportDiscount)
				.setScale(2, BigDecimal.ROUND_HALF_UP);
		return reportTpriceBd;
	}
	
	public static void main(String[] args) {
		System.out.println(generateNo());
		String str = "add,edit,delete,view,search,export";
		System.out.println(str.indexOf("edit"));
		String string = "ROLE_USER-custaccess- ";
		String[] strArr = string.split("-");
		System.out.println(strArr.length);
		for(String str1 : strArr){
			System.out.println(str1);
		}
		System.out.println("end");
		
		String str11 = "1|2|3|4|5";
		System.out.println(str11.indexOf("|"));
		String[] str11Arr = str11.split("\\|");
		for(String s : str11Arr){
			System.out.println(s);
		}
		
        Pattern pattern = Pattern.compile("标题\\s{0,}3");

        Matcher m=pattern.matcher("标题 3,标题 3 Char1 Char");

System.out.println(m.matches());
        
/*     String string11 = "0.0.0.0         0.255.255.255   IANA保留地址       CZ88.NET";
        String test = string11.replaceAll("\\s{1,}", " ");
        System.out.println(test);

        string = test;

        String[] str1 = string.split(" ");

        for (String string2 : str1) {

            System.out.println(string2);

        }*/

		Map<String, String> map = new TreeMap<String, String>();
		map.put("第1章", "第一章");
		map.put("第2章", "第二章");
		map.put("第3章", "第三章");
		map.put("第4章", "第四章");
		map.put("第5章", "第五章");
	
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey());
		}
		
		String test1 = "1|第一章 房地产及建筑设计行业发展环境分析";
		System.out.println(test1.substring(test1.indexOf("|") + 1));
		
		String originalFilename = "2010-2012年中国泵制造行业深度分析及投资咨询报告.docx";
		System.out.println(originalFilename.substring(0, originalFilename.lastIndexOf(".")));
		
		BigDecimal a = new BigDecimal("6999");
		BigDecimal b = new BigDecimal("8.66666666").setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(getMultiplyVal(a, b));
		
		int num = 5;
		int tmp = 2;
		List<String> list = new ArrayList<String>();
		List<String> listTmp = new ArrayList<String>();
		for(int i = 1; i <= num; i++) {
			list.add("str" + i);
		}
		for(int i = 1; i <= tmp; i++) {
			listTmp.add("strtmp" + i);
		}
		
		if(null != list && list.size() < 7) {
			list.addAll(listTmp);
		}
		
		for(String s : list) {
			System.out.println("s = " + s);
		}
	}
}
