package com.sbiao360.cms.zutil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class SolrConnector {

	
    
	

	public static HttpSolrServer  getConnector(){
		InputStream in = null;
		Properties properties = new Properties();
		try {
			in =  Resources.getResourceAsStream("solr.properties");
			properties.load(in);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (null != in)  
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HttpSolrServer  solrServer = new HttpSolrServer(properties.getProperty("solrUrl")); 
		solrServer.setMaxTotalConnections(Integer.parseInt(properties.getProperty("maxTotalConnections")));
		solrServer.setSoTimeout(Integer.parseInt(properties.getProperty("timeOut"))); 
		return solrServer;
	}
	
}
