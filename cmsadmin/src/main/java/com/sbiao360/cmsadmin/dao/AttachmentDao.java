package com.sbiao360.cmsadmin.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cmsadmin.model.Attachment;
import com.sbiao360.core.dao.BaseDao;

/**
 * 附件的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class AttachmentDao {

	@Resource
	private BaseDao baseDao;

	public int save(Attachment attachment) {
		return this.baseDao.save("AttachmentMapper.insert", attachment);
	}

	public int update(Attachment attachment) {
		return this.baseDao.update("AttachmentMapper.update", attachment);
	}

	public Attachment getByPrimaryKey(Long id) {
		return this.baseDao.get("AttachmentMapper.getByPrimaryKey", id);
	}

	public Attachment getByProperties(Map<String, Object> paramMap) {
		return this.baseDao.get("AttachmentMapper.getByProperties", paramMap);
	}

	public int deleteByProperties(Map<String, Object> paramMap) {
		return this.baseDao.delete("AttachmentMapper.deleteByProperties",
				paramMap);
	}

}
