package com.chorechart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chorechart.model.Parents;
import com.chorechart.model.Kids;
import java.util.List;


public class ParentMapper implements RowMapper<Parents>{

	@Override
	public Parents mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Parents foundParents = new Parents();
		foundParents.setFirstName(rs.getString("FirstName"));
		foundParents.setLastName(rs.getString("LastName"));
		return foundParents;
	}

}
