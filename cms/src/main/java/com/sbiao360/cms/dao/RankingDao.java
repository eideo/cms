package com.sbiao360.cms.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.RankingData;

@Repository
public class RankingDao {
	
	@Resource
	private BaseDao baseDao;
	
	
	public List<RankingData> selectKeywordsRanking(Map<String,Object> params){
		return baseDao.getList("ranking.selectKeywordsRanking", params);
	} 
	
	public Integer selectHisKeyWordsRanking(Map<String,Object> params){
		return baseDao.get("ranking.selectHisKeyWordsRanking", params);
	}
	
	public List<RankingData> selectInfoRanking(Map<String,Object> params){
		return baseDao.getList("ranking.selectInfoRanking", params);
	}
	
	public Integer selectHisInfoRanking(Map<String,Object> params){
		return baseDao.get("ranking.selectHisInfoRanking", params);
	}
	
	public List<RankingData> selectCompanyRanking(Map<String,Object> params){
		return baseDao.getList("ranking.selectCompanyRanking", params);
	}
	
	public Integer selectHisCompanyRanking(Map<String,Object> params){
		return baseDao.get("ranking.selectHisCompanyRanking", params);
	}
	
	public List<RankingData> selectReportRanking(Map<String,Object> params){
		return baseDao.getList("ranking.selectReportRanking", params);
	}
	
	public Integer selectHisReportRanking(Map<String,Object> params){
		return baseDao.get("ranking.selectHisReportRanking", params);
	}

	public List<RankingData> selectKeywordsRankingDefault() {
		return baseDao.getList("ranking.selectKeywordsRankingDefault");
	}

	public List<RankingData> selectInfoRankingDefault() {
		return baseDao.getList("ranking.selectInfoRankingDefault");
	}

	public List<RankingData> selectCompanyRankingDefault(Map<String, Object> map) {
		return baseDao.getList("ranking.selectCompanyRankingDefault", map);
	}

	public List<RankingData> selectReportRankingDefault() {
		return baseDao.getList("ranking.selectReportRankingDefault");
	}

}
