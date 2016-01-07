package com.sbiao360.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cms.dao.CustomerBehaviorDao;
import com.sbiao360.cms.dao.CustomerKeywordsDao;
import com.sbiao360.cms.domain.CustBehavior;
import com.sbiao360.cms.domain.CustomerKeywords;
import com.sbiao360.cms.domain.KeywordsDict;
import com.sbiao360.cms.domain.KeywordsException;
import com.sbiao360.cms.zutil.StringUtil;

@Service("customerKeywordsService ")
public class CustomerKeywordsService {
	
	@Resource
	private CustomerKeywordsDao  customerKeywordsDao;
	
	@Resource
	private CustomerBehaviorDao customerBehaviorDao;

	/**
	 * 获取前5热词
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@Cacheable(value="commonCache",key="'hotwords'")
	public List<KeywordsDict> getHotKeyWordsList(){
		PageHelper.startPage(1,5);
		return customerKeywordsDao.selectLikeKeywordsDic(null);
	}
	
	/**
	 * 获取相似前五词汇
	 * @param keywords
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<KeywordsDict> selectLikeKeywordsDic(String keywords){
		PageHelper.startPage(1,5);
		return customerKeywordsDao.selectLikeKeywordsDic(keywords);
	}
	
	/**
	 * 插入关键词搜索记录
	 * @param custBehavior
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public void insertKeyWords(CustBehavior custBehavior){
		customerBehaviorDao.save(custBehavior);
	}
	
	/**
	 * 检查关键词字典中是否存在
	 * @param keywords
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public void checkKeyWordsDict(String keywords){
		int keywordsCount = customerKeywordsDao.getKeywordsDicCount(keywords);
		if(keywordsCount==0){
			KeywordsDict dict = new KeywordsDict();
			dict.setKeywords(keywords);
			dict.setClickCount(1);
			customerKeywordsDao.insertKeyWordsDict(dict);
		}else{
			customerKeywordsDao.updateKeyWordsDicAddCount(keywords);
		}
	}

	/**
	 * 插入关键词搜索异常
	 * @param exception
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public void insertKeywordsException(KeywordsException exception) {
		customerKeywordsDao.insertKeywordsException(exception);
	}
	
}
