package com.sbiao360.cms.zutil;

import java.util.Comparator;

import com.sbiao360.cms.domain.RankingData;

public class RankingPMCompare implements Comparator<RankingData>{


	@Override
	public int compare(RankingData o1, RankingData o2) {
		int flag =  o1.getPm().compareTo(o2.getPm());
		if(flag==0){
			return o1.getName().compareTo(o2.getName()); 
		}else{
			return flag;
		}
	}
	
}
