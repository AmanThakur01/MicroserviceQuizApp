package com.company.question_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {
	@Autowired
	public NamedParameterJdbcTemplate npjt;
	@Autowired
	public JdbcTemplate jt;
}
