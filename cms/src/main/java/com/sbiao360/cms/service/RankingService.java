package com.sbiao360.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.RankingDao;
import com.sbiao360.cms.domain.RankingData;

@Service
public class RankingService {
	
	@Resource
	private RankingDao rankingDao;
	
	public  List<RankingData> selectKeywordsRanking(Map<String,Object> params,String circle){
		List<RankingData> result = rankingDao.selectKeywordsRanking(params);
		return result;
	}
	
	public List<RankingData> selectInfoRanking(Map<String,Object> params,String circle){
		List<RankingData> result = rankingDao.selectInfoRanking(params);
		return result;
	}
	
	public List<RankingData> selectCompanyRanking(Map<String,Object> params,String circle){
		List<RankingData> result = rankingDao.selectCompanyRanking(params);
		return result;
	}
	
	public List<RankingData> selectReportRanking(Map<String,Object> params,String circle){
		List<RankingData> result = rankingDao.selectReportRanking(params);
		return result;
	}
	
	public List<RankingData> selectKeywordsRankingDefault() {
		List<RankingData> result = rankingDao.selectKeywordsRankingDefault();
		return result;
	}

	public List<RankingData> selectInfoRankingDefault() {
		List<RankingData> result = rankingDao.selectInfoRankingDefault();
		return result;
	}

	public List<RankingData> selectCompanyRankingDefault(Map<String, Object> map) {
		List<RankingData> result = rankingDao.selectCompanyRankingDefault(map);
		return result;
	}

	public List<RankingData> selectReportRankingDefault() {
		List<RankingData> result = rankingDao.selectReportRankingDefault();
		return result;
	}

}
