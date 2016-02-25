package com.sbiao360.cms.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cms.domain.MemberInfo;
import com.sbiao360.cms.domain.PersonalCustBehavior;

/**
 * 个人中心的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class PersonalDao {

	@Resource
	private BaseDao baseDao;

	public MemberInfo getMemberInfoById(Long id) {
		return this.baseDao.get("memberInfoMapper.getByPrimaryKey", id);
	}

	public int updateMemberInfo(MemberInfo memberInfo) {
		return this.baseDao.update("memberInfoMapper.update", memberInfo);
	}

	public int getCountBehavior(Map<String, Object> paraMap) {
		return this.baseDao
				.getCount("PersonalMapper.getCountBehavior", paraMap);
	}

	public List<PersonalCustBehavior> getListBehavior(int pageNum,
			int pageSize, Map<String, Object> paraMap) {
		PageHelper.startPage(pageNum, pageSize);
		return this.baseDao.getList("PersonalMapper.getListBehavior", paraMap);
	}

	public List<PersonalCustBehavior> getListBehavior(
			Map<String, Object> paraMap) {
		return this.baseDao.getList("PersonalMapper.getListBehavior", paraMap);
	}

	public int updateBehavior(Map<String, Object> paraMap) {
		return this.baseDao.update("PersonalMapper.updateBehavior", paraMap);
	}

	public int update(String[] ids, Map<String, Object> paraMap) {
		int i = 0;
		for (String id : ids) {
			paraMap.put("id", Long.parseLong(id));
			i += updateBehavior(paraMap);
		}
		return i;
	}

	public int updateBehaviorByDate(Map<String, Object> paraMap) {
		return this.baseDao.update("PersonalMapper.updateBehaviorByDate",
				paraMap);
	}

	public int updateAvatar(Map<String, Object> paraMap) {
		return this.baseDao.update("memberInfoMapper.updateAvatar", paraMap);
	}
}
