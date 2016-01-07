package com.sbiao360.cmsadmin.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.CustBehaviorDao;
import com.sbiao360.cmsadmin.model.CustBehavior;
import com.sbiao360.core.util.DateJsonValueProcessor;
import com.sbiao360.core.util.DateUtil;

/**
 * 用户行为-实时展示的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class CustBehaviorService {

	@Resource
	private CustBehaviorDao custBehaviorDao;

	public Long getCount(CustBehavior custBehavior) {
		return this.custBehaviorDao.getCount(custBehavior);
	}

	public List<CustBehavior> getList(CustBehavior custBehavior) {
		return this.custBehaviorDao.getList(custBehavior);
	}

	public int delete(Long[] ids) {
		return this.custBehaviorDao.delete(ids);
	}

	public int delete(Long id) {
		return this.custBehaviorDao.deleteByPrimaryKey(id);
	}

	// 获取Redis缓存服务器用户行为列表
	public List<CustBehavior> getListRedis(String key, long start, long end) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		jsonConfig.setRootClass(com.sbiao360.cms.domain.CustBehavior.class);

		List<CustBehavior> custBehaviorList = new ArrayList<CustBehavior>();
		List<Object> objectList = this.custBehaviorDao.getListRedis(key, start,
				end);
		for (Object o : objectList) {
			String jsonStr = (String) o;
			JSONObject jsonObject = JSONObject.fromObject(jsonStr, jsonConfig);
			JSONUtils.getMorpherRegistry().registerMorpher(
					new DateMorpher(new String[] { "yyyy-MM-dd HH:mm:ss" }));
			com.sbiao360.cms.domain.CustBehavior serialCustBehavior = (com.sbiao360.cms.domain.CustBehavior) JSONObject
					.toBean(jsonObject, jsonConfig);
			CustBehavior custBehavior = transToCustBehavior(serialCustBehavior);
			custBehaviorList.add(custBehavior);
		}
		return custBehaviorList;
	}

	// 用户行为数据反序列化转换
	public CustBehavior transToCustBehavior(
			com.sbiao360.cms.domain.CustBehavior serialCustBehavior) {
		CustBehavior custBehavior = new CustBehavior();
		custBehavior.setId(serialCustBehavior.getId());
		custBehavior.setUserId(serialCustBehavior.getUserId());
		custBehavior.setLoginId(serialCustBehavior.getLoginId());
		custBehavior.setCustName(serialCustBehavior.getCustName());
		custBehavior.setIp(serialCustBehavior.getIp());
		custBehavior.setInfoType(serialCustBehavior.getInfoType());
		if (null != serialCustBehavior.getInfoType()
				&& !"".equals(serialCustBehavior.getInfoType())) {
			String infoTypeCn = "";
			switch (serialCustBehavior.getInfoType()) {
			case "11501":
				infoTypeCn = "项目";
				break;
			case "11502":
				infoTypeCn = "招标";
				break;
			case "11503":
				infoTypeCn = "中标";
				break;
			case "11504":
				infoTypeCn = "采购";
				break;
			case "11505":
				infoTypeCn = "新闻";
				break;
			case "11506":
				infoTypeCn = "行业报告";
				break;
			case "1":
				infoTypeCn = "关系网";
				break;
			default:
				infoTypeCn = "";
			}
			custBehavior.setInfoType(infoTypeCn);
		}
		custBehavior.setClickType(serialCustBehavior.getClickType());
		if (null != serialCustBehavior.getClickType()) {
			String clickTypeCn = "";
			switch (serialCustBehavior.getClickType()) {
			case 1:
				clickTypeCn = "内容";
				break;
			case 2:
				clickTypeCn = "地区";
				break;
			case 3:
				clickTypeCn = "行业";
				break;
			default:
				clickTypeCn = "";
			}
			custBehavior.setClickTypeCn(clickTypeCn);
		}
		custBehavior.setActionType(serialCustBehavior.getActionType());
		if (null != serialCustBehavior.getActionType()) {
			String actionTypeCn = "";
			String infoName = "";
			switch (serialCustBehavior.getActionType()) {
			case 1:
				actionTypeCn = "访问";
				infoName = serialCustBehavior.getUrl();
				break;
			case 2:
				actionTypeCn = "点击";
				infoName = serialCustBehavior.getColumnLevelOne() + ": "
						+ serialCustBehavior.getColumnLevelTwo();
				break;
			case 3:
				if (serialCustBehavior.getInfoValid().shortValue() == 1) {
					actionTypeCn = "关注";
					infoName = custBehavior.getInfoType() + ": "
							+ serialCustBehavior.getInfoName();
				} else if (serialCustBehavior.getInfoValid().shortValue() == 0) {
					actionTypeCn = "取消关注";
					infoName = custBehavior.getInfoType() + ": "
							+ serialCustBehavior.getInfoName();
				}
				break;
			case 4:
				if (serialCustBehavior.getInfoValid().shortValue() == 1) {
					actionTypeCn = "收藏";
					infoName = custBehavior.getInfoType() + ": "
							+ serialCustBehavior.getInfoName();
				} else if (serialCustBehavior.getInfoValid().shortValue() == 0) {
					actionTypeCn = "取消收藏";
					infoName = custBehavior.getInfoType() + ": "
							+ serialCustBehavior.getInfoName();
				}
				break;
			case 5:
				actionTypeCn = "分享";
				infoName = custBehavior.getInfoType() + ": "
						+ serialCustBehavior.getInfoName();
				break;
			case 6:
				actionTypeCn = "搜索";
				infoName = serialCustBehavior.getKeywords();
				break;
			case 7:
				actionTypeCn = "点击搜索条件";
				infoName = custBehavior.getClickTypeCn() + ": "
						+ serialCustBehavior.getClickContent();
				break;
			case 8:
				actionTypeCn = "取消";
				infoName = custBehavior.getInfoType() + ": "
						+ serialCustBehavior.getInfoName();
				break;
			default:
				actionTypeCn = "";
				infoName = "";
			}
			custBehavior.setActionTypeCn(actionTypeCn);
			custBehavior.setInfoName(infoName);
		}
		custBehavior.setInfoId(serialCustBehavior.getInfoId());
		custBehavior.setInfoValid(serialCustBehavior.getInfoValid());
		if (null != serialCustBehavior.getInfoValid()) {
			String infoValidCn = "";
			switch (serialCustBehavior.getInfoValid()) {
			case 1:
				infoValidCn = "是";
				break;
			case 0:
				infoValidCn = "否";
				break;
			default:
				infoValidCn = "";
			}
			custBehavior.setInfoValidCn(infoValidCn);
		}
		custBehavior.setActionDate(serialCustBehavior.getActionDate());
		if (null != serialCustBehavior.getActionDate()) {
			try {
				String actionDateCn = DateUtil.formatDateToStr(
						"yyyy-MM-dd HH:mm:ss",
						serialCustBehavior.getActionDate());
				custBehavior.setActionDateCn(actionDateCn);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		custBehavior.setColumnLevelOne(serialCustBehavior.getColumnLevelOne());
		custBehavior.setColumnLevelTwo(serialCustBehavior.getColumnLevelTwo());
		custBehavior.setUrl(serialCustBehavior.getUrl());
		custBehavior.setParameter(serialCustBehavior.getParameter());
		custBehavior.setConsumeTime(serialCustBehavior.getConsumeTime());
		custBehavior.setRemoteAddr(serialCustBehavior.getRemoteAddr());
		custBehavior.setKeywordsType(serialCustBehavior.getKeywordsType());
		custBehavior.setKeywords(serialCustBehavior.getKeywords());
		custBehavior.setShareType(serialCustBehavior.getShareType());
		if (null != serialCustBehavior.getShareType()) {
			String shareTypeCn = "";
			switch (serialCustBehavior.getShareType()) {
			case 1:
				shareTypeCn = "个人电脑";
				break;
			case 2:
				shareTypeCn = "手机";
				break;
			case 3:
				shareTypeCn = "平板电脑";
				break;
			default:
				shareTypeCn = "";
			}
			custBehavior.setShareTypeCn(shareTypeCn);
		}
		custBehavior.setShareSys(serialCustBehavior.getShareSys());
		custBehavior.setShareTarget(serialCustBehavior.getShareTarget());
		custBehavior.setShareMessage(serialCustBehavior.getShareMessage());
		custBehavior.setClickContent(serialCustBehavior.getClickContent());
		return custBehavior;
	}

}
