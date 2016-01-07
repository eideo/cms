package com.sbiao360.fdfs;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.ServerInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * File Manager used to provide to services to upload , download or delete the files 
 * 
 * <Note> In this version, it only support single tracker , will enhance this later...</note>
 * 
 * @author Marlon Li
 *  
 */
public class FileManager implements FileManagerConfig{

	private static final Logger LOG = Logger.getLogger(FileManager.class); 
	
	private static final long serialVersionUID = -7488856937610175525L;
	
	private static TrackerClient  trackerClient;
	private static TrackerServer  trackerServer;
	private static StorageServer  storageServer;
	private static StorageClient  storageClient;
	
   static { // Initialize Fast DFS Client configurations
		
		try {
			String classPath = new File(FileManager.class.getResource("/").getFile()).getCanonicalPath();
			String fdfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
			LOG.info("Fast DFS configuration file path:" + fdfsClientConfigFilePath);
			ClientGlobal.init(fdfsClientConfigFilePath);
			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
			storageClient = new StorageClient(trackerServer, storageServer);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
	
		}
	}
   public static String upload(FastDFSFile file){
	   
	   LOG.info("File name:"+file.getName()+"   File length:"+file.getContent().length);
	   
	   NameValuePair[] meta_list = new NameValuePair[3];
	    meta_list[0] = new NameValuePair("width", "120");
	    meta_list[1] = new NameValuePair("heigth", "120");
	    meta_list[2] = new NameValuePair("author", "MarlonLi");
	   
	    long startTime = System.currentTimeMillis();
		String[] uploadResults = null;
		try {
			uploadResults = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
		} catch (IOException e) {
			LOG.error("IO Exception when uploadind the file: " + file.getName(), e);
		} catch (Exception e) {
			LOG.error("Non IO Exception when uploadind the file: " + file.getName(), e);
		}
		LOG.info("upload_file time used: " + (System.currentTimeMillis() - startTime) + " ms");
		
		if (uploadResults == null) {
			LOG.error("upload file fail, error code: " + storageClient.getErrorCode());
		}
		
		String groupName 		= uploadResults[0];
		String remoteFileName   = uploadResults[1];
		
		String fileAbsolutePath = PROTOCOL + trackerServer.getInetSocketAddress().getHostName() 
				+ SEPARATOR
				+ TRACKER_NGNIX_PORT
				+ SEPARATOR 
				+ groupName 
				+ SEPARATOR 
				+ remoteFileName;
		
		
		LOG.info("upload file successfully!!!  " +"group_name: " + groupName + ", remoteFileName:"
				+ " " + remoteFileName);
		
		return fileAbsolutePath;
	   
   }
   
   public static FileInfo getFileInfo(String groupName,String remoteFileName){
	   
		try {
			return storageClient.get_file_info(groupName, remoteFileName);
		} catch (IOException e) {
			LOG.error("IO Exception: Get File from Fast DFS failed", e);
		} catch (Exception e) {
			LOG.error("Non IO Exception: Get File from Fast DFS failed", e);
		}
		return null;
   }
   
	public static void deleteFile(String groupName, String remoteFileName) throws Exception {
		storageClient.delete_file(groupName, remoteFileName);
	}
	
	public static StorageServer[] getStoreStorages(String groupName) throws IOException {
		return trackerClient.getStoreStorages(trackerServer, groupName);
	}
	
	public static ServerInfo[] getFetchStorages(String groupName, String remoteFileName) throws IOException {
		return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
	}
	
	
}
