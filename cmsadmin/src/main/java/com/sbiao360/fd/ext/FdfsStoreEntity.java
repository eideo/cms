package com.sbiao360.fd.ext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

public class FdfsStoreEntity implements StoreEntity{
	
	public static final String DEFAULT_LOCATION = "local_location";
    public static final String FILE_NAME = "local_file_name";//存储本地文件的名字
    public static final String STORE_ID = "store_id";//
    public static final String CONTENT_TYPE = "content_type";

	private MultipartFile multipartFile;
    private Map<String, Object> metaData;
    
    private Mode mode;
    
    public static enum Mode{
        /**
         * 上传模式
         */
        upload, 
        /**
         * 获取模式,可以理解为下载模式
         */
        retrieve;
    }
    public FdfsStoreEntity() {
        metaData = new HashMap<String, Object>();
        this.mode = Mode.retrieve;//默认是获取模式
    }
    
    public FdfsStoreEntity(MultipartFile multipartFile) {
    	this();
    	setMultipartFile(multipartFile);
    }
    public void setMultipartFile(MultipartFile multipartFile) {
        Assert.notNull(multipartFile, "the multi part file object must not be null.");
        this.multipartFile = multipartFile;
        this.mode = Mode.upload;
        
        setContentType(multipartFile.getContentType());
        setFileName(multipartFile.getOriginalFilename());
    }
    /**
     * 设置文件名称
     * @param fileName
     */
    public void setFileName(String fileName){
        setProperty(FILE_NAME, fileName);
    }
    @Override
    public String getFileName() {
        if(Mode.upload.equals(mode)){
            return getProperty(FILE_NAME);
        } else if(Mode.retrieve.equals(mode)) {
            if(!getMetaData().containsKey(FILE_NAME)){//如果是下载模式，则直接读取路径，获得文件名
                setFileName(FilenameUtils.getName(getLocation()));
            }
            return getProperty(FILE_NAME);
        }
        return null;
    }
    
    @Override
    public InputStream getInputStream() throws IOException {
        switch (mode) {
        case upload:
            return multipartFile.getInputStream();
        case retrieve:
            String file = getLocation();//获得路径，直接返回
            return new FileInputStream(file);
        default :
            return null;
        }
    }
    
    /**
     * 设置属性，
     * @param <T>
     * @param key
     * @param value
     * @return 继承{@link MailModel}的类
     */
    public void setProperty(String key, Object value) {
        if( value != null){//设置的value不为空的时候，才去处理
            metaData.put(key, value);
        }//如果值为空，直接返回，不处理
    }
    
    /**
     * 获得已有的属性，如果为空，返回null
     * @param <T>
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key){
        return (T) metaData.get(key);
    }
    
    /**
     * 获得路径
     * @return
     */
    public String getLocation(){
        return getProperty(DEFAULT_LOCATION);
    }

    /**
     * 设置本地路径
     * @param location
     */
    public void setLocation(String location){
        setProperty(DEFAULT_LOCATION, location);
    }
    
    @Override
    public Map<String, Object> getMetaData() {
        return metaData;
    }
    
    public MultipartFile getMultipartFile() {
        return multipartFile;
    }
    
    public void setIdentity(String identity){
        setProperty(STORE_ID, identity);
    }
    
    /**
     * 设置内容类型
     * @param contentType
     */
    @Override
    public void setContentType(String contentType){
        setProperty(CONTENT_TYPE, contentType);
    }
    
    public String getContentType(){
        return getProperty(CONTENT_TYPE);
    }
    
    @Override
    public String getIdentity() {
        return getProperty(STORE_ID);
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	@Override
	public StoreType getStoreType() {
		return StoreType.local;
	}

	
}
