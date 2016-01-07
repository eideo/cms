package com.sbiao360.core.service;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sbiao360.core.dao.JdbcBaseDao;

/**
 * @author yujunwei
 */
@Transactional
public class JdbcBaseService {

	@Resource
	protected JdbcBaseDao jdbcBaseDao;

}
