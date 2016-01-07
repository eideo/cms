package com.sbiao360.fd.ext;

import java.io.IOException;
import java.io.InputStream;

import org.csource.util.ImageServer;


public class FdfsStorer extends AbstractStore {

	private ImageServer fdfsImgServer;	
	
	

	public ImageServer getFdfsImgServer() {
		return fdfsImgServer;
	}

	public void setFdfsImgServer(ImageServer fdfsImgServer) {
		this.fdfsImgServer = fdfsImgServer;
	}

	@Override
	public StoreEntity retrieve(String storeId) {
		// TODO Auto-generated method stub		
		try {
			String fileurl=fdfsImgServer.getFileById(storeId);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String doStore(StoreEntity entity) {
		// TODO Auto-generated method stub
		String url=null;
		InputStream entityStream = null;
		
		try {
			String fileExtName = getFileExtName(entity.getFileName());
			entityStream = entity.getInputStream();
			
			url=fdfsImgServer.uploadFile(entityStream, fileExtName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
	
	
	private String getFileExtName(String name) {
		String extName = null;
		if (name != null && name.contains(".")) {
			extName = name.substring(name.lastIndexOf(".") + 1);
		}
		return extName;
	}

}
