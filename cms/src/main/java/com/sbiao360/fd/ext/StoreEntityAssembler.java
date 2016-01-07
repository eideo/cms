package com.sbiao360.fd.ext;

public interface StoreEntityAssembler {


    /**
     * 是否支持
     * @param storeId, 参数不能为null
     * @return
     */
    boolean support(StoreId storeId);
    
    /**
     * 组装URI,
     * @param storeId, 参数不能为null
     * @return
     */
    String assembleUri(StoreId storeId);
}
