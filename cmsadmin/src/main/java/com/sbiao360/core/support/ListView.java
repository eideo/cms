package com.sbiao360.core.support;

import java.util.List;

/**
 * @author yujunwei
 */
public class ListView<E> {

	private Long totalRecord;

	private List<E> data;

	public Long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

}