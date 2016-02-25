package com.sbiao360.fd.ext;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * 用来给Jackson序列化使用，因为目前没有掌握怎么自定义某个字符串的格式,
 * 
 * 具体查看 {@link JacksonAudioIdSerializer}
 * @author gogo
 *
 */
public class StoreId implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -7570003855920427690L;
    
    public static enum Type{
        USER_AVATAR, ACTIVITY_LOGO, EMAIL_AVATAR, COMPANY_LOGO, REGION_COVER
    }
    
    private String storeId;
    private Type type;
    
    public StoreId() {
    }
    
    /**
     * 
     * @param storeId
     */
    public StoreId(String storeId) {
        this.storeId = storeId;
        this.type = Type.USER_AVATAR;//默认是用户头像
    }
    
    /**
     * 
     * @param storeId 存储对象的ID
     * @param type 类型
     */
    public StoreId(String storeId, Type type) {
        this.storeId = storeId;
        this.type = type;
    }
    
    public String getStoreId() {
        return storeId;
    }
    
    public boolean hasStoreId() {
        return StringUtils.isNotBlank(storeId);
    }
    
    /**
     * 获取该存取的类型
     * @return
     */
    public Type getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return String.format("[StoreId] the store id:%s, type:%s", storeId, type.name());
    }
    
}
