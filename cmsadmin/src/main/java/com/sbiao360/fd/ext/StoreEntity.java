package com.sbiao360.fd.ext;

import java.util.Map;

import org.springframework.core.io.InputStreamSource;

public interface StoreEntity extends InputStreamSource{
	 public enum StoreType {
	        local, local_temp, mock, memory
	    }
	    
	    StoreType getStoreType();
		
	    /**
	     * The metadata associated with this object.
	     * @return The object's metadata, never return null
	     */
	    Map<String, Object> getMetaData();
	    
	    /**
	     * The file name of the entity.
	     * @return file name
	     */
	    String getFileName();
	    
	    /**
	     * 获得该实体能够被访问的路径,比如是本地的类型,那么就是本地的绝对路径，如果是一个http的link,那就必须是完整能够
	     * 被访问到的link
	     * @return
	     */
	    String getLocation();

	    /**
	     * 获得实体的唯一标识,该标识可以直接通过EntityStore
	     * @return  获得实体的唯一标识
	     */
	    String getIdentity();
	    
	    /**
	     * 获得MimeType
	     * @return
	     */
	    String getContentType();
	    
	    /**
	     * 设置可以访问到的位置,比如是本地的类型,那么就是本地的绝对路径，如果是一个http的link,那就必须是完整能够
	     * 被访问到的link
	     * TODO 采用更丰富的实体 替代该参数
	     * @param location
	     */
	    void setLocation(String location);
	    
	    /**
	     * 设置唯一标示自己的实体，就是现有的storeId
	     * @param identity
	     */
	    void setIdentity(String identity);
	    
	    void setContentType(String contentType);
}
