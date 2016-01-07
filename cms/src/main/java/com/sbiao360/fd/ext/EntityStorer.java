package com.sbiao360.fd.ext;


public interface EntityStorer {

//  /**
//  * 保存该实体
//  * @param entity 需要被保存的实体
//  * @param storeListener 存储的监听器，在处理时的一些结果处理
//  * @return 能够通过EntityStorer找到唯一标识
//  */
// String store(StoreEntity entity, StoreListener storeListener);
 
	/**
	 * 保存该实体, 必须修改 实体本身，返回store id的能力
	 * @param 需要被保存的实体
	 * @return 能够通过EntityStorer找到唯一标识
	 */
	String store(StoreEntity entity);
	
	/**
	 * 通过Storer中查询出来的唯一标识字符串来获得存储实体
	 * @param storeId 这里的path可以看作是一种id
	 * @return
	 */
	StoreEntity retrieve(String storeId);
	
	/**
	 * 销毁某个实体
	 * @param storeId 这里的path可以看作是一种id
	 */
	void destroy(String storeId);
	
 /**
  * Returns <code>true</code> if this <Code>StoreProvider</code> supports the indicated
  * <Code>StoreEntity</code> object.
  * <p>
  * Returning <code>true</code> does not guarantee an <code>StoreEntity</code>will be support 
  * to be stored. if false that means u should try another.
  * </p>
  *
  * @param StoreEntity DOCUMENT ME!
  *
  * @return <code>true</code> if the implementation can more closely evaluate the <code>StoreEntity</code> class
  *         presented
  */
 boolean supports(Class<? extends StoreEntity> storeEntity);
 
 /**
  * 存储的监听器
  * @author gogo
  *
  */
 public interface StoreListener {
     
     /**
      * 在存储完成之后的回调方法
      * @param entity 存储完成之后，返回的entity实体，这里会包括 可以访问到自己的storeid,以及存储的位置
      */
     void onStoreCompleted(StoreEntity entity);
     
 }
}
