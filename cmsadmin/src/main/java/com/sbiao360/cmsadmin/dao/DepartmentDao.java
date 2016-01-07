package com.sbiao360.cmsadmin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.sbiao360.cmsadmin.model.Department;
import com.sbiao360.core.dao.BaseDao;

/**
 * 部门的数据持久层的实现类
 * 
 * @author yujunwei
 */
@Repository
public class DepartmentDao {

	@Resource
	private BaseDao baseDao;

	public int save(Department department) {
		return this.baseDao.save("DepartmentMapper.insert", department);
	}

	public int update(Department department) {
		return this.baseDao.update("DepartmentMapper.update", department);
	}

	public Department getByPrimaryKey(Long id) {
		return this.baseDao.get("DepartmentMapper.getByPrimaryKey", id);
	}

	public Department getByDeptKey(String deptKey) {
		return this.baseDao.get("DepartmentMapper.getByDeptKey", deptKey);
	}

	public Long getCount(Department department) {
		return this.baseDao.getCount("DepartmentMapper.getCount", department);
	}

	public List<Department> getList(Department department) {
		PageHelper.startPage(department.getPage(), department.getRows());
		return this.baseDao.getList("DepartmentMapper.getList", department);
	}

	public List<Department> getDropDownList() {
		return this.baseDao.getList("DepartmentMapper.getDropDownList");
	}

	public List<Department> getDeptSelectNoSelfList(String deptKey) {
		return this.baseDao.getList("DepartmentMapper.getDeptSelectNoSelfList",
				deptKey);
	}

	public int delete(Long[] ids) {
		int i = 0;
		for (Long id : ids) {
			i += deleteByPrimaryKey(id);
			;
		}
		return i;
	}

	public int deleteByPrimaryKey(Long id) {
		return this.baseDao.delete("DepartmentMapper.deleteByPrimaryKey", id);
	}

	public boolean existDeptKey(String deptKey) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deptKey", deptKey);
		Long num = this.baseDao.getCount("DepartmentMapper.getCountByDeptKey",
				paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean existParentDeptKey(String parentDeptKey) {
		boolean flag = false;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("parentDeptKey", parentDeptKey);
		Long num = this.baseDao.getCount(
				"DepartmentMapper.getCountByParentDeptKey", paramMap);
		if (num > 0) {
			flag = true;
		}
		return flag;
	}

}
