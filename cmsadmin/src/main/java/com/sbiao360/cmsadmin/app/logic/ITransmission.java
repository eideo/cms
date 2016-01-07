package com.sbiao360.cmsadmin.app.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sbiao360.cmsadmin.app.bean.BaseResponseBean;

/**
 * APP接口的协议传输接口
 * @author yujunwei
 */
public interface ITransmission {

	public String resv(HttpServletRequest request);

	public void resp(HttpServletResponse response, BaseResponseBean brb);

}
