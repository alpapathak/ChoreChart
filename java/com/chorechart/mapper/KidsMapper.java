package com.chorechart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chorechart.model.Kids;

public class KidsMapper implements RowMapper<Kids>{

	@Override
	public Kids mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Kids foundKidUser = new Kids();
		foundKidUser.setFirstName(rs.getString("FirstName"));
		foundKidUser.setLastName(rs.getString("LastName"));
		foundKidUser.setLoginId(rs.getString("LoginId"));
		return foundKidUser;
		
	}

}
