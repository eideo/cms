package com.sbiao360.cmsadmin.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.sbiao360.cmsadmin.model.param.MethodExcuTimeParameter;

/**
 * 服务方法执行时间的实体类
 * 
 * @author yujunwei
 */
@JsonIgnoreProperties(value = { "maxResults", "firstResult", "topCount",
		"sortColumns", "cmd", "queryDynamicConditions", "sortedConditions",
		"dynamicProperties", "success", "message", "sortColumnsString", "flag" })
public class MethodExcuTime extends MethodExcuTimeParameter {

	private static final long serialVersionUID = 2015110220320667925L;

	private Long id;

	private String execMethod;

	private Long execTime;

	private Date insertDate;

	public MethodExcuTime() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExecMethod() {
		return execMethod;
	}

	public void setExecMethod(String execMethod) {
		this.execMethod = execMethod;
	}

	public Long getExecTime() {
		return execTime;
	}

	public void setExecTime(Long execTime) {
		this.execTime = execTime;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MethodExcuTime other = (MethodExcuTime) obj;
		return Objects.equal(this.id, other.id)
				&& Objects.equal(this.execMethod, other.execMethod)
				&& Objects.equal(this.execTime, other.execTime)
				&& Objects.equal(this.insertDate, other.insertDate);
	}

	public int hashCode() {
		return Objects.hashCode(this.id, this.execMethod, this.execTime,
				this.insertDate);
	}
}
