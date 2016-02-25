package com.sbiao360.cms.zutil;

public class CutTitle {
	public static String cutXMXXTitle(String title){
		title = title.replace("的", "").replace("项目", "").replace("工程", "").replace("（", "(").replace("）", ")");
		while(title.indexOf("(")!=-1){
			title =title.replace(title.substring(title.indexOf("("),title.indexOf(")")==-1?title.length():(title.indexOf(")")+1)), "");
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
	public static String cutZBGGTitle(String title){
		String word = "评标、招标、变更、资格预审、补充、延期开标、延长报名时间、竞争性谈判、比选、单一来源采购";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|总承包的|公告|二次|【变更】|重新招标]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
	public static String cutZBGSTitle(String title){
		String word = "中标、评标、变更、补充、竞争性谈判、比选";
		String[] s = word.split("、");
		for (String string : s) {
			if(title.indexOf(string)!=-1){
				title = title.replace(title.substring(title.indexOf(string),title.length()),"");
			}
		}
		title = title.replaceAll("[公开|预|结果公示|总承包的|公告|二次]","");
		if(title.lastIndexOf("的")==title.length()-1){
			title = title.substring(0,title.length()-1);
		}
		title = title.replaceAll("[\\pP‘’“”]", "").replace("<","").replace(">", ""); 
		return title;
	}
	
}
