package com.sbiao360.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.CustomerKeywords;
import com.sbiao360.cms.domain.KeywordsDict;
import com.sbiao360.cms.domain.KeywordsException;

@Repository
public class CustomerKeywordsDao {

	@Resource
	private BaseDao baseDao;
	
	public List<CustomerKeywords> getHotKeyWordsList(String likeStr){
		Map<String,String> map = new HashMap<String, String>();
		map.put("keywords", likeStr);
		if(likeStr==null){
			map.put("minLength", 9+"");
			map.put("maxLength", 15	+"");
		}
		return this.baseDao.getList("customerKeywordsMapper.selectLikeKeywords", map);
	}
	
	public void insertKeyWords(CustomerKeywords customerKeywords){
		this.baseDao.save("customerKeywordsMapper.insertKeywords", customerKeywords);
	}
	
	public void insertKeyWordsDict(KeywordsDict keywordsDict){
		this.baseDao.getList("keywordsDictMapper.insertKeyWordsDic", keywordsDict);
	}
	
	public List<KeywordsDict> selectLikeKeywordsDic(String keywords){
		Map<String,String> map = new HashMap<String, String>();
		map.put("keywords", keywords);
		if(keywords==null){
			map.put("minLength", 9+"");
			map.put("maxLength", 15	+"");
		}
		return this.baseDao.getList("keywordsDictMapper.selectLikeKeywordsDic", map);
	}
	
	public void updateKeyWordsDicAddCount(String keywords){
		this.baseDao.update("keywordsDictMapper.updateKeyWordsDicAddCount", keywords);
	}
	public int getKeywordsDicCount(String keywords){
		return this.baseDao.getCount("keywordsDictMapper.getKeywordsDicCount", keywords);
	}
	
	public void insertKeywordsException(KeywordsException keywordsException){
		this.baseDao.save("keywordsExceptionMapper.insertKeywordsException", keywordsException);
	}
}
