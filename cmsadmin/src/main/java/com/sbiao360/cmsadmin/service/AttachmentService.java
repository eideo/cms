package com.sbiao360.cmsadmin.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.AttachmentDao;
import com.sbiao360.cmsadmin.model.Attachment;

/**
 * 附件的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class AttachmentService {

	@Resource
	private AttachmentDao attachmentDao;

	public int save(Attachment attachment) {
		return this.attachmentDao.save(attachment);
	}

	public int update(Attachment attachment) {
		return this.attachmentDao.update(attachment);
	}

	public Attachment getByPrimaryKey(Long id) {
		return this.attachmentDao.getByPrimaryKey(id);
	}

	public int deleteByProperties(Map<String, Object> paramMap) {
		return this.attachmentDao.deleteByProperties(paramMap);
	}

	public Attachment getByProperties(Map<String, Object> paramMap) {
		return this.attachmentDao.getByProperties(paramMap);
	}
}
