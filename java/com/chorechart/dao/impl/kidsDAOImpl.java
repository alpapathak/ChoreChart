package com.chorechart.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.chorechart.dao.KidsDAO;
import com.chorechart.mapper.KidsMapper;
import com.chorechart.mapper.ParentMapper;
import com.chorechart.model.Kids;
import com.chorechart.model.Parents;
@Service("kidsDAO")
public class kidsDAOImpl implements KidsDAO {
	
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
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void addKid(Kids kid) {
		// TODO Auto-generated method stub
		Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		String sql_kids = "Insert into kids"+"(FirstName,LastName,loginId,Password,ParentEmail,kidsEmail,DateOfBirth,LastLogin)"
				+ "values(?,?,?,?,?,?,?,?)";
		
		jdbcTemplate.update(sql_kids, new Object[] { kid.getFirstName(), kid.getLastName(), kid.getLoginId(),kid.getPassword(),
				kid.getParentEmail(),kid.getKidsEmail(),kid.getDateOfBirth(),sqlDate});
		
	}

	@Override
	public List<Kids> returnListKids(String userName) {
		// TODO Auto-generated method stub
		String sql_listOfKids = "select * from Kids where parentEmail = '"+userName+"'"; 
		List<Kids> listKids = new ArrayList<Kids>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql_listOfKids);
		for(Map row:rows) {
			Kids kid = new Kids();
			kid.setFirstName(row.get("FirstName").toString());
			kid.setLastName(row.get("LastName").toString());
			kid.setLoginId(row.get("LoginId").toString());
			listKids.add(kid);
		}
		return listKids;
	}

	@Override
	public Kids returnUser(String loginid, String password) {
		// TODO Auto-generated method stub
		String sql_userKid = "select * from Kids where loginId = '"+loginid+"' and Password = '"
								+password+"'"; 
		Kids kids = jdbcTemplate.queryForObject(sql_userKid, new KidsMapper());
		
		return kids;
	}

}
