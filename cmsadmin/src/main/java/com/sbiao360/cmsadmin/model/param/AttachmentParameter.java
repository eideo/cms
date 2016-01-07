package com.sbiao360.cmsadmin.model.param;

import com.sbiao360.core.support.ExtJSBaseParameter;

/**
 * 附件的参数类
 * 
 * @author yujunwei
 */
public class AttachmentParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = 201511101421233331L;

	private String description;

	private String epcId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEpcId() {
		return epcId;
	}

	public void setEpcId(String epcId) {
		this.epcId = epcId;
	}

}
