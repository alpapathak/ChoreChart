package com.chorechart.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.chorechart.dao.ParentsDAO;
import com.chorechart.mapper.ParentMapper;
import com.chorechart.model.Kids;
import com.chorechart.model.Parents;;

@Service("parentsDAO")
public class parentsDAOImpl implements ParentsDAO {
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
	public void addParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public Parents showParents(String userName, String password) {
		String sql_select = "select FirstName, LastName from Parents where UserName = '"+userName+
				"' and Password = '"+password+"'";
		
		Parents foundRow = jdbcTemplate.queryForObject(sql_select, new ParentMapper());
		return foundRow;
	}

	@Override
	public List<Kids> showAllKids(String parentsEmail) {
		// TODO Auto-generated method stub
		List<Kids> listKids = new ArrayList<Kids>();
		String sql_listOfKids ="select FirstName,LastName,LoginId from Kids where ParentEmail = '"+parentsEmail +"'";
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

}
