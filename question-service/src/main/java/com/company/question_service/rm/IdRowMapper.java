package com.company.question_service.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IdRowMapper implements RowMapper<Integer> {
	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer lst;
		lst=rs.getInt("queid");
		return lst;
	}
}
