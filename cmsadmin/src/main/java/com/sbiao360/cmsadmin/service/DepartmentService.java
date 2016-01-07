package com.sbiao360.cmsadmin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sbiao360.cmsadmin.dao.DepartmentDao;
import com.sbiao360.cmsadmin.model.Department;

/**
 * 部门的业务逻辑层的实现
 * 
 * @author yujunwei
 */
@Service
public class DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	public int save(Department department) {
		return this.departmentDao.save(department);
	}

	public int update(Department department) {
		return this.departmentDao.update(department);
	}

	public Department getByPrimaryKey(Long id) {
		return this.departmentDao.getByPrimaryKey(id);
	}

	public Department getByDeptKey(String deptKey) {
		return this.departmentDao.getByDeptKey(deptKey);
	}

	public Long getCount(Department department) {
		return this.departmentDao.getCount(department);
	}

	public List<Department> getList(Department department) {
		return this.departmentDao.getList(department);
	}

	public boolean existDeptKey(String deptKey) {
		return this.departmentDao.existDeptKey(deptKey);
	}

	public boolean existParentDeptKey(String parentDeptKey) {
		return this.departmentDao.existParentDeptKey(parentDeptKey);
	}

	public int delete(Long[] ids) {
		return this.departmentDao.delete(ids);
	}

	public int delete(Long id) {
		return this.departmentDao.deleteByPrimaryKey(id);
	}

	public List<Department> getDropDownList() {
		return this.departmentDao.getDropDownList();
	}

	public List<Department> getDeptSelectNoSelfList(String deptKey) {
		return this.departmentDao.getDeptSelectNoSelfList(deptKey);
	}

}
