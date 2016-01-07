package com.sbiao360.fd.ext;

/**
 * 存储的拦截器
 * @author gogo
 *
 */
public interface StoreInterceptor {
    
    /**
     * 在处理之前，判断是否需要继续处理,如果返回结果为false,则停止继续处理
     * @param entityStorer 当时保存的实体对象,不能为null
     * @param entity 需要保存的文件实体，不能为null
     * @return 是否需要继续处理该实体
     * @throws IllegalArgumentException 如果参数为null
     */
    boolean preHandle(EntityStorer entityStorer, StoreEntity entity);
    
    /**
     * 在存储完成之后的回调方法
     * @param entity 存储完成之后，返回的entity实体，该实体应该包括可以访问到自己的storeid,以及存储的位置
     * 否则就是业务错误
     */
    void afterCompletion(StoreEntity entity, Exception exception);
    
}
