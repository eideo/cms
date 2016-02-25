package com.sbiao360.fd.ext;

import static org.apache.commons.lang.StringUtils.startsWithIgnoreCase;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;


/**
 * 访问实体的帮助类，如根据sotreId来获得网络访问
 * 目前该体系需要正常运作，需要在 对应的静态资源中  /data/www/foxpro.com/static 对应到 webapps下面相应的 static文件夹
 * @author zhjt
 *
 */
public class StoreEntityAccessor {
	
    public enum RemoteProtocol {
        HTTP,
        HTTPS,
        FTP,
        FTPS
        ;
        private final String protocol;
        
        private RemoteProtocol() {
            this.protocol = name().toLowerCase() + "://";
        }
        
        public boolean match(String url) {
            if (StringUtils.isBlank(url)) {
                return false;
            }
            return startsWithIgnoreCase(url.trim(), this.protocol);
        }
    }
    
   /* private RequestPathResolver requestPathResolver = new RequestPathResolver();*/
    
    private List<StoreEntityAssembler> storeEntityAssemblers;
    
    public void setStoreEntityAssemblers(
            List<StoreEntityAssembler> storeEntityAssemblers) {
        this.storeEntityAssemblers = storeEntityAssemblers;
    }
   /* @Resource
    public void setRequestPathResolver(RequestPathResolver requestPathResolver) {
        this.requestPathResolver = requestPathResolver;
    }*/
    
   
    
    /**
     * 根据StoreId组装下载路径
     * @return
     */
    public String assembleDownloadPath(StoreId storeId){
        Assert.notNull(storeId, "we can't make up a download path with null StoreId Object.");
        
        //考虑远程的图片，如果是任何一些协议开头的图片，则返回连接
        if (isRemoteStoreId(storeId.getStoreId())){
            return storeId.getStoreId();
        }
        //修改为fdfs路径 20130624zhjt start
       // String serverBase =  requestPathResolver.getServerBasePath() ;
        String serverBase = "";
        //修改为fdfs路径 20130624zhjt end
       
       
        
       // String serverBase = enableServeletContext ? requestPathResolver.getServerBasePath() : "";
        StringBuilder buf = new StringBuilder(serverBase);
        
        if (!storeId.hasStoreId()){
        	//TODO 如果没有storeId
        } else {
            boolean uriHandled = false;
            if (storeEntityAssemblers != null) {
                for (StoreEntityAssembler assembler : storeEntityAssemblers) {
                    if (assembler.support(storeId)){
                        uriHandled = true;
                        buf.append(assembler.assembleUri(storeId));
                        break;//跳出本次循环
                    }
                }
            }
            
            if (!uriHandled) {//如果URI没有被处理，则附加，如果已经被处理过了，跳过这个流程
                buf.append(storeId.getStoreId());
            }
        }
        return buf.toString();
    }
    
    /**
     * XXX 查询某个StoreId是否是远程的，这里是个临时解决方案,需要进行重构!
     * @param storeId
     * @return
     */
    protected boolean isRemoteStoreId(String storeId){
        if (StringUtils.isBlank(storeId)){
            return false;
        }
        
        for (RemoteProtocol protocol : RemoteProtocol.values()) {
            if (protocol.match(storeId)){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 组装下载地址
     * @param storeId 图片的ID
     * @param type 图片类型
     * @return
     */
    public String assembleDownloadPath(String storeId, String type){
        return assembleDownloadPath(new StoreId(storeId, StoreId.Type.valueOf(type)));
    }
    
    /**
     * 组装下载路径
     * @param storeId 需要组装的资源ID
     * @return 返回组织后的
     */
    public String assembleDownloadPath(String storeId){
        return assembleDownloadPath(new StoreId(storeId));
    }
    
}
