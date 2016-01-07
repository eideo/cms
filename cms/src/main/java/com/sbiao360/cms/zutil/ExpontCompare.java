package com.sbiao360.cms.zutil;

import java.util.Comparator;
import java.util.Map;

public class ExpontCompare implements Comparator<Map<String,Object>>{

	@Override
	public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		int flag = ((Integer)o1.get("time")).compareTo((Integer)o2.get("time"));
		return flag;
	}

}
