package com.sbiao360.cms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.MemberInfoDao;
import com.sbiao360.cms.domain.MemberInfo;


@Service
public class MemberInfoService {

	@Resource
	private MemberInfoDao memberInfoDao;
	
	public void insertMemberInfo(MemberInfo memberInfo){
		memberInfoDao.insertMemberInfo(memberInfo);
	}
	
	public boolean checkMember(MemberInfo memberInfo){
		return memberInfoDao.checkMember(memberInfo);
	}
	
	public MemberInfo getMemberByPhone(MemberInfo memberInfo){
		return memberInfoDao.getMemberByPhone(memberInfo);
	}
	
	public void updatePass(MemberInfo memberInfo){
		memberInfoDao.updatePass(memberInfo);
	}

	public MemberInfo getByPrimaryKey(Long id) {
		return memberInfoDao.getByPrimaryKey(id);
	}
}
