package com.sbiao360.fd.ext;

import com.sbiao360.fd.ext.EntityStorer.StoreListener;

/**
 * 空的 存储监听器，什么也不会做
 * @author gogo
 *
 */
public class NullStoreListener implements StoreListener{

    /**
     * 暂时还没有体会到这个接口的用处, 相关资料查看书  《重构 改善现有的代码结构》
     */
//    @Override
//    public boolean isNull() {
//        return true;
//    }
    
    @Override
    public void onStoreCompleted(StoreEntity entity) {
        //do nothing
    }
    
}
