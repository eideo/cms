package com.sbiao360.fd.ext;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.activation.FileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;


public abstract class AbstractStore implements EntityStorer {
	
	
private Logger logger = LoggerFactory.getLogger(getClass());
    
    private FileTypeMap fileTypeMap;
    
    protected StoreListener nullListener = new NullStoreListener();
    
    private List<StoreInterceptor> storeInterceptors;//默认为空
    
    public AbstractStore() {
    }
    
    public void setStoreInterceptors(List<StoreInterceptor> storeInterceptors) {
        logger.debug("set intecepter :{}", storeInterceptors);
        this.storeInterceptors = storeInterceptors;
    }
    
    @Override
    public void destroy(String path) {
        logger.debug("ready to destory the entity by path:{}", path);
        doDestory(path);
    }
    
    protected void doDestory(String path){
    }
    
    /**
     * Determine the default Java Activation FileTypeMap for the given MimeMessage.
     * @param mimeMessage the passed-in MimeMessage
     * @return the default FileTypeMap associated with the MimeMessage,
     * or a default ConfigurableMimeFileTypeMap if none found for the message
     * @see ConfigurableMimeFileTypeMap
     */
    protected FileTypeMap getDefaultFileTypeMap() {
        ConfigurableMimeFileTypeMap fileTypeMap = new ConfigurableMimeFileTypeMap();
        fileTypeMap.setMappingLocation(new ClassPathResource("mime.types", AbstractStore.class));//重设映射
        fileTypeMap.afterPropertiesSet();
        return fileTypeMap;
    }
    
    /**
     * 
     * <code>FileTypeMap</code> instance else.
     * @see javax.activation.FileTypeMap#getDefaultFileTypeMap
     * @see ConfigurableMimeFileTypeMap
     */
    public void setFileTypeMap(FileTypeMap fileTypeMap) {
        this.fileTypeMap = (fileTypeMap != null ? fileTypeMap : getDefaultFileTypeMap());
    }

    /**
     * Return the <code>FileTypeMap</code> 
     */
    public FileTypeMap getFileTypeMap() {
        if(this.fileTypeMap == null){
            setFileTypeMap(null);
        }
        return this.fileTypeMap;
    }
    
    /**
     * Delegates to the underlying FileTypeMap.
     * @see #getFileTypeMap()
     */
    public String getContentType(File file) {
        return getFileTypeMap().getContentType(file);
    }

    /**
     * Delegates to the underlying FileTypeMap.
     * @see #getFileTypeMap()
     */
    public String getContentType(String fileName) {
        return getFileTypeMap().getContentType(fileName);
    }
    
    /**
     * 随机产生UUID文件名字,
     * 
     * @param originalName
     *            原始文件名字
     * @return 通过UUID生成的文件名
     */
    public String generateUUIDFileName(String originalName) {
        return String.format("%s-%s", UUID.randomUUID().toString(),
                originalName);
    }
    
    @Override
    public boolean supports(Class<? extends StoreEntity> storeEntity) {
        return StoreEntity.class.isAssignableFrom(storeEntity);
    }
    
//    @Override
//    public String store(StoreEntity entity, StoreListener storeListener) {
//        //TODO 这里是否设计合理？ 得考虑 Gogo
//        throw new IllegalStateException("Not implemented yet");
//    }
    
    @Override
    public final String store(StoreEntity entity) {
        
        if (storeInterceptors != null){
            for (StoreInterceptor interceptor : storeInterceptors) {
                if (!interceptor.preHandle(this, entity)){
                    return null;//TODO 修改返回结果值
                }
            }
        }
        
        String storeId = null;
        Exception exception = null;
        try {
            storeId = doStore(entity);
        } catch (Exception e) {
            exception = e;
        }
        
        if (storeInterceptors != null){
            for (StoreInterceptor interceptor : storeInterceptors) {
                interceptor.afterCompletion(entity, exception);
            }
        }
        
        return storeId;
    }
    
    
    public abstract String doStore(StoreEntity entity);
}
