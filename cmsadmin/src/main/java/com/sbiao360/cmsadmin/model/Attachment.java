package com.sbiao360.cmsadmin.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.AttachmentParameter;

/**
 * 附件的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class Attachment extends AttachmentParameter {

	private static final long serialVersionUID = 2015111014241762506L;

	private Long id;

	private String fileName;

	private String filePath;

	private Short type;

	private Long typeId;

	public Attachment() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Attachment other = (Attachment) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.fileName, other.fileName)
				&& Objects.equal(this.filePath, other.filePath)
				&& Objects.equal(this.type, other.type)
				&& Objects.equal(this.typeId, other.typeId);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.fileName, this.filePath,
				this.type, this.typeId);
	}

}
