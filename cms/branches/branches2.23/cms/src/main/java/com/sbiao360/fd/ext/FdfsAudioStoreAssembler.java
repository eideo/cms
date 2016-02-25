package com.sbiao360.fd.ext;

import java.io.IOException;

import org.csource.util.ImageServer;
import org.springframework.util.Assert;

public class FdfsAudioStoreAssembler implements StoreEntityAssembler {

	private ImageServer fdfsImgServer;	
	
	
	
	
	public ImageServer getFdfsImgServer() {
		return fdfsImgServer;
	}

	public void setFdfsImgServer(ImageServer fdfsImgServer) {
		this.fdfsImgServer = fdfsImgServer;
	}

	@Override
	public boolean support(StoreId storeId) {
		// TODO Auto-generated method stub
		Assert.notNull(storeId);
		return AudioId.class.isAssignableFrom(storeId.getClass());
	}

	@Override
	public String assembleUri(StoreId storeId) {
		// TODO Auto-generated method stub
		AudioId audioId = (AudioId)storeId;
		
		//此处向Fdfs trackserver 请求，获取Storage ip 或者 host
		String uri=null;
		String storageAddress=null;
		StringBuilder buf = new StringBuilder("http:/");
		try {
			storageAddress = fdfsImgServer.getFileById(audioId.getStoreId());
			
			
			
			buf.append(storageAddress);
			buf.append("/");
			buf.append(audioId.getStoreId());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String uri = String.format(URI_FORMAT, audioDownUri, audioId.getStoreId());
	    return buf.toString();
	}

	
}
