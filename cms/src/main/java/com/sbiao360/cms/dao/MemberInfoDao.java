package com.sbiao360.cms.dao;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.sbiao360.cms.domain.MemberInfo;

@Repository
public class MemberInfoDao {
	
	@Resource
	private BaseDao baseDao;
	
	public void insertMemberInfo(MemberInfo memberInfo){
		this.baseDao.save("memberInfoMapper.insertMemberInfo", memberInfo);
	}
	
	public boolean checkMember(MemberInfo memberInfo){
		List<MemberInfo> list = this.baseDao.getList("memberInfoMapper.checkMember", memberInfo);
		if(list.size()>0){
			return false;
		}else{
			
			return true;
		}
	}
}
