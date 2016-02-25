package com.sbiao360.cms.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cms.dao.PersonalDao;
import com.sbiao360.cms.domain.MemberInfo;
import com.sbiao360.cms.domain.PersonalCustBehavior;
import com.sbiao360.cms.zutil.StringUtil;

/**
 * 个人中心的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class PersonalService {

	@Resource
	private PersonalDao personalDao;

	public MemberInfo getMemberInfoById(Long id) {
		return this.personalDao.getMemberInfoById(id);
	}

	public int updateMemberInfo(MemberInfo memberInfo) {
		return this.personalDao.updateMemberInfo(memberInfo);
	}

	public int getCountBehavior(Map<String, Object> paraMap) {
		return this.personalDao.getCountBehavior(paraMap);
	}

	public List<PersonalCustBehavior> getListBehavior(int pageNum,
			int pageSize, Map<String, Object> paraMap) {
		List<PersonalCustBehavior> list = this.personalDao.getListBehavior(pageNum, pageSize, paraMap);
		for(PersonalCustBehavior p: list){
			if(StringUtil.isNotBlank((p.getSubIntroduction()))){
				String intro = p.getSubIntroduction().replaceAll("<[^>]*>","");
				if(intro.lastIndexOf("<")>0){
					intro = intro.substring(0, intro.lastIndexOf("<"))+"...";
				}
				p.setSubIntroduction(intro);
				
			}
		}
		return list;
	}

	public Map<String, List<PersonalCustBehavior>> getFootprintMap(
			Map<String, Object> paraMap) {
		List<PersonalCustBehavior> footprintList = null;
		Map<String, List<PersonalCustBehavior>> footprintMap = new LinkedHashMap<String, List<PersonalCustBehavior>>();
		List<PersonalCustBehavior> custBehaviorList = this.personalDao
				.getListBehavior(paraMap);
		if (null != custBehaviorList && custBehaviorList.size() > 0) {
			for (PersonalCustBehavior custBehavior : custBehaviorList) {
				if(StringUtil.isNotBlank((custBehavior.getSubIntroduction()))){
					String intro = custBehavior.getSubIntroduction().replaceAll("<[^>]*>","");
					if(intro.lastIndexOf("<")>0){
						intro = intro.substring(0, intro.lastIndexOf("<"))+"...";
					}
					custBehavior.setSubIntroduction(intro);
					
				}
				String dateKey = custBehavior.getActionDateCn();
				if (footprintMap.containsKey(dateKey)) {
					footprintList = footprintMap.get(dateKey);
				} else {
					footprintList = new ArrayList<PersonalCustBehavior>();
				}
				footprintList.add(custBehavior);
				footprintMap.put(dateKey, footprintList);
				
			}
		}

		return footprintMap;
	}

	public int updateBehavior(Map<String, Object> paraMap) {
		return this.personalDao.updateBehavior(paraMap);
	}

	public int update(String[] ids, Map<String, Object> paraMap) {
		return this.personalDao.update(ids, paraMap);
	}

	public int updateBehaviorByDate(Map<String, Object> paraMap) {
		return this.personalDao.updateBehaviorByDate(paraMap);
	}

	public int updateAvatar(Map<String, Object> paraMap) {
		return this.personalDao.updateAvatar(paraMap);
	}

}
