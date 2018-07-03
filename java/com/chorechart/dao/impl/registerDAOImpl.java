package com.chorechart.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.chorechart.dao.RegisterDAO;
import com.chorechart.model.Register;

@Service("registerDAO")

public class registerDAOImpl implements RegisterDAO{
	@Autowired
	private DataSource dataSource;
	
	 @Autowired
	  JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insertUser(Register registerUser) {
		
		Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		String sql_register = "Insert into register"+"(FirstName,LastName,Email_username,password,DateOfBirth,Relations,Newsletter,DateCreated)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		String sql_parents = "Insert into parents"+"(FirstName,LastName,UserName,password,DateOfBirth,LastLogin)"
				+"values(?,?,?,?,?,?)";
		
		//System.out.println("Firstname"+registerUser.getFirstName()+" "+registerUser.getLastName()+"  "+registerUser.getEmail_username());
		jdbcTemplate.update(sql_register, new Object[] { registerUser.getFirstName(), registerUser.getLastName(), registerUser.getEmail_username(),registerUser.getPassword(),
				registerUser.getDateOfBirth(),registerUser.getRelations(),registerUser.isNewsletter(),sqlDate});
		
		jdbcTemplate.update(sql_parents, new Object[] { registerUser.getFirstName(), registerUser.getLastName(), registerUser.getEmail_username(),registerUser.getPassword(),
				registerUser.getDateOfBirth(),sqlDate});
	}

	@Override
	public Register findUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String sql_select = "Select User ";
		
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

}
