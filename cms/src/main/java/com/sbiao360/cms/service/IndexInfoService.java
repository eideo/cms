package com.sbiao360.cms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.RangeFacet;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import com.sbiao360.cms.base.cons.CommonConstants;
import com.sbiao360.cms.dao.CustomerClickLogDao;
import com.sbiao360.cms.domain.IndexInfo;
import com.sbiao360.cms.domain.KeywordsException;
import com.sbiao360.cms.zutil.DateTime;
import com.sbiao360.cms.zutil.SolrConnector;
import com.sbiao360.cms.zutil.StringUtil;

@Service("indexInfoService")  
public class IndexInfoService {

	
	@Resource
	private CustomerClickLogDao customerClickLogDao;
	
	
	/**
	 * 搜索数据
	 * @param findStr 搜索语句
	 * @param start 开始行业
	 * @param rows	获取数量
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public Map<String,Object> queryIndexInfo(String findStr,int start,int rows){
		HttpSolrServer solrServer = SolrConnector.getConnector();
		SolrQuery query = new SolrQuery(); 
		query.setQuery(findStr); 
		query.setStart(start==-1?0:start);
		query.setRows(rows==-1?CommonConstants.PAGE_SIZE:rows);
		query.set("qt", "/select");
		query.setHighlight(true);
		query.addHighlightField("description");
		query.addHighlightField("titleForIndex");
		query.setHighlightSimplePre("%-");
		query.setHighlightSimplePost("-%");
		query.setHighlightFragsize(0);
		query.set("fl", "*,score");
		Map<String,Object> mapResult = new HashMap<String, Object>();
		try { 
			QueryResponse rsp = solrServer.query( query );
			SolrDocumentList docs = rsp.getResults(); 
			long numFound = docs.getNumFound();
			mapResult.put("num", numFound+"");
			mapResult.put("time",rsp.getQTime()+"");
			mapResult.put("maxScore",docs.getMaxScore()+"");
			List<IndexInfo> result = new ArrayList<IndexInfo>();
			for (SolrDocument doc : docs) { 
				Object id= doc.getFieldValue("id");
				List<String> s = rsp.getHighlighting().get(id+"").get("titleForIndex");
				String title = (s==null||s.isEmpty())?(String)doc.getFieldValue("titleForIndex"):s.get(0);
				List<String> desc = rsp.getHighlighting().get(id+"").get("description");
				String description = (desc==null||desc.isEmpty())?(String)doc.getFieldValue("description"):desc.get(0);
				description = description.replaceAll("<[^>]*>","");
				List<String> categorys = rsp.getHighlighting().get(id+"").get("category");
				
				String category = (categorys==null||categorys.isEmpty())?(doc.getFieldValue("category")==null?null:doc.getFieldValue("category").toString()):categorys.get(0);
				if(StringUtil.isNotBlank(category)){
					category = category.replace("[", "").replace("]", "");
				}
				List<String> areanames = rsp.getHighlighting().get(id+"").get("area_name");
				String areaName = (areanames==null||areanames.isEmpty())?(doc.getFieldValue("area_name")==null?null:doc.getFieldValue("area_name").toString()):areanames.get(0);
				if(StringUtil.isNotBlank(category)){
					areaName = areaName.replace("[", "").replace("]", "");
				}
				IndexInfo index = new IndexInfo();
				index.setId(""+id);
				index.setTitle(getHighLightColor(title));
				index.setCategory(getHighLightColor(category));
				index.setAreaName(areaName);
				index.setPublishDate(DateTime.toDate("yyyy-MM-dd",(Date)doc.getFieldValue("publish_date")));

				String tableName = (String)doc.getFieldValue("table_name");
				String table2Name = (String)doc.getFieldValue("table_name2");
				String type = "";
				String infoType = "11501";
				if(tableName.equals("XMXX")){
					type="项目";
					infoType="11501";
				}else if(tableName.equals("ZBXX")&&table2Name.equals("ZBGS")){
					type="中标";
					infoType="11503";
				}else if(tableName.equals("ZBXX")){
					type="招标";
					infoType="11502";
				}
				index.setType(type);
				index.setInfoType(infoType);
				index.setProjectName((String)doc.getFieldValue("project_name"));
				description = getHighLightColor(description);
				index.setDescription(description);
				result.add(index);
			}
			mapResult.put("result", result);
		} catch (SolrServerException e) { 
			e.printStackTrace(); 
		}
		return mapResult;
	}
	
	
	/**
	 * 获取行业分类数据
	 * @param findStr
	 * @return
	 * @throws SolrServerException
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> getFacetIndustryNum(String findStr) throws SolrServerException{
		HttpSolrServer solrServer = SolrConnector.getConnector();
		SolrQuery query = new SolrQuery(); 
		query.setQuery(findStr);
		query.setFacet(true);
		query.addFacetField("category");
		QueryResponse response = solrServer.query(query);
		List<FacetField> facets = response.getFacetFields();//返回的facet列表
		List<Map<String,Object>> list = new ArrayList<>();
		for (FacetField facet : facets) {
			List<Count> counts = facet.getValues();
		    for (Count count : counts) {
		    	Map<String,Object> map = new HashMap<>();
		    	map.put("industry",count.getName());
		    	map.put("nums", count.getCount());
		    	list.add(map);
		    }
		}
		return list;
	}
	
	/**
	 * 获取月度分片数据
	 * @param findStr
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SolrServerException
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getFacetMonthNum(String findStr,String startDate,String endDate) throws SolrServerException{
		HttpSolrServer solrServer = SolrConnector.getConnector();
		SolrQuery query = new SolrQuery(); 
		query.setFacet(true);
		query.setQuery(findStr+ " AND publish_date:["+startDate+" TO "+endDate+"]");
		Date end = DateTime.parseDate(endDate, "yyyyMM");
		end.setMonth(end.getMonth()+1);
		Date start = DateTime.parseDate(startDate+"02", "yyyyMMdd");
		query.addDateRangeFacet("publish_date",start,end, "+1MONTH");
		QueryResponse response = solrServer.query(query);
		Map<String,Object> map = new HashMap<>();
		List<RangeFacet> dateFacetFields = response.getFacetRanges();
	    for (RangeFacet facetField : dateFacetFields){
	        List<org.apache.solr.client.solrj.response.RangeFacet.Count> dateCounts= facetField.getCounts();
	        for (org.apache.solr.client.solrj.response.RangeFacet.Count count : dateCounts) {
	        	if(count.getCount()!=0){
	        		map.put(count.getValue(), count.getCount());
	        	}
	        }
	    }
		return map;
	}
	
	
	/**
	 * 获取地区分片数据
	 * @param findStr
	 * @return
	 * @throws SolrServerException
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<Map<String,Object>> getFacetAreaNum(String findStr) throws SolrServerException{
		HttpSolrServer solrServer = SolrConnector.getConnector();
		SolrQuery query = new SolrQuery(); 
		query.setFacet(true);
		query.setQuery(findStr);
		query.addFacetField("area_name");
		QueryResponse response = solrServer.query(query);
		List<FacetField> facets = response.getFacetFields();//返回的facet列表
		List<Map<String,Object>> result = new ArrayList<>();
		for (FacetField facet : facets) {
			List<Count> counts = facet.getValues();
		    for (Count count : counts) {
		    	Map<String,Object> map = new HashMap<>();
		    	map.put("area",count.getName());
		    	map.put("nums", count.getCount());
		    	result.add(map);
		    }
		}
		return result;
	}
	
	/**
	 * 设置高亮标签
	 * @param str
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	private String getHighLightColor(String str){
		if(StringUtil.isBlank(str)){
			return "";
		}
		str = str.replaceAll(" ", "");
		if(str.length()>130){
			str = str.substring(0,130)+"...";
		}
		if(str.lastIndexOf("%-")>str.lastIndexOf("-%")){
			str = str+"-%";
		}
		str = str.replace("%-", "<font color='red'>").replace("-%", "</font>");
		return str;
	}
	
	
	/**
	 * 检索建议
	 * @param keyword
	 * @return
	 * @author 廖得宇
	 * 	2016年1月4日
	 */
	public List<String> getSpellCheckFromSolr(String keyword){
		
		HttpSolrServer service = SolrConnector.getConnector();
		SolrQuery params = new SolrQuery();
        params.set("qt", "/suggest");
        params.setQuery(keyword);
        QueryResponse response = null;  
        List<String> suggestionResult = new ArrayList<String>();
        try {
			response = service.query(params);
			SpellCheckResponse suggest = response.getSpellCheckResponse();  
	        List<Suggestion> suggestionList = suggest.getSuggestions();  
	        for (Suggestion suggestion : suggestionList) {  
//	            System.out.println("Suggestions NumFound: " + suggestion.getNumFound());  
//	            System.out.println("Token: " + suggestion.getToken());  
//	            System.out.print("Suggested: ");  
	        	suggestionResult = suggestion.getAlternatives();  
	        }  
		} catch (SolrServerException e) {
			e.printStackTrace();
		} 
 
		return suggestionResult;
	}
	
}
