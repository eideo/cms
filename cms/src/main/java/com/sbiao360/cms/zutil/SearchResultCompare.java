package com.sbiao360.cms.zutil;

import java.util.Comparator;
import java.util.Map;

public class SearchResultCompare implements Comparator<Map<String,Object>>{


	@Override
	public int compare(Map<String,Object> o1, Map<String,Object> o2) {
		int flag =  DateTime.parseDate(((String)o1.get("time")).replace("T", " ").replace("Z", ""),"yyyy-MM-dd hh:mm:ss").compareTo(DateTime.parseDate(((String)o2.get("time")).replace("T", " ").replace("Z", ""),"yyyy-MM-dd hh:mm:ss"));
		return flag;
	}
	

}
