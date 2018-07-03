package com.chorechart.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.chorechart.dao.ChoresDAO;
import com.chorechart.model.Chores;
import com.chorechart.model.Kids;
import com.chorechart.model.kid_chore;
@Service("ChoresDAO")
public class choresDAOImpl implements ChoresDAO {
	
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
	public void addChore(Chores newChore) {
		// TODO Auto-generated method stub
		Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		String sql_chores = "Insert into chores"+"(ChoreDesc,ChorePoints)"
				+ "values(?,?)";
		
		jdbcTemplate.update(sql_chores, new Object[] { newChore.getChoreDesc(),newChore.getChorePoints()});

	}

	@Override
	public List<Chores> displayChores() {
		// TODO Auto-generated method stub
		List<Chores> listChores = new ArrayList<Chores>();
		String sql_listOfChores ="select ChoreId,ChoreDesc,ChorePoints from Chores";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql_listOfChores);
		for(Map row:rows) {
			Chores chore = new Chores();
			chore.setChoreId((int)row.get("choreId"));
			chore.setChoreDesc(row.get("ChoreDesc").toString());
			chore.setChorePoints((int) row.get("chorePoints"));
			listChores.add(chore);
		}
		return listChores;
		
	}

	@Override
	public List<kid_chore> displayChoresOfUser(String loginid) {
		// TODO Auto-generated method stub
		List<kid_chore> listkidChores = new ArrayList<kid_chore>();
		String sql_listOfChoresofUser ="select ChoreId, ChoreStatus, Notes from kid_chore  where kidLoginId =  '"+
									loginid +"'";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql_listOfChoresofUser);
		for(Map row:rows) {
			kid_chore kidchores = new kid_chore();
			kidchores.setChoreId((int)row.get("ChoreId"));
			kidchores.setChoreStatus(row.get("ChoreStatus").toString());
			kidchores.setNotes(row.get("Notes").toString());

			listkidChores.add(kidchores);
		}
		return listkidChores;
		
	}

	@Override
	public void assignChoreToKid(String loginId, int choreId,int chorePoints) {
		// TODO Auto-generated method stub
		
		String sql_select_chores = "Select ChorePoints from chores where choreId = '"+choreId+"'";
		
		
		String sql_chores_kid = "Insert into kid_chore"+"(ChoreId,ChoreStatus,kidLoginId,Notes,Points)"
				+ "values(?,?,?,?,?)";
		
		jdbcTemplate.update(sql_chores_kid, new Object[] { choreId,"A",loginId,"Assigned",chorePoints});

		
	}

	@Override
	public List<kid_chore> displayCompletedChoresOfUser(String loginid) {
		// TODO Auto-generated method stub
		List<kid_chore> listkidChores = new ArrayList<kid_chore>();
		String sql_listOfCompletedChoresofUser ="select a.ChoreId,b.ChoreDesc,b.ChorePoints,a.ChoreStatus, a.Notes from kid_chore a join chores b on a.choreId = b.choreId where kidLoginId =  '"+
									loginid +"' and ChoreStatus = 'C'";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql_listOfCompletedChoresofUser);
		for(Map row:rows) {
			kid_chore kidchores = new kid_chore();
			kidchores.setChoreId((int)row.get("ChoreId"));
			kidchores.setChoreStatus(row.get("ChoreStatus").toString());
			kidchores.setNotes(row.get("Notes").toString());
			Chores choreDesc= new Chores();
			choreDesc.setChoreId((int)row.get("ChoreId"));
			choreDesc.setChoreDesc(row.get("ChoreDesc").toString());
			choreDesc.setChorePoints((int)row.get("ChorePoints"));
			kidchores.setChoreAssigned(choreDesc);
			listkidChores.add(kidchores);
		}
		return listkidChores;

		
	}

	@Override
	public List<kid_chore> displayAssignedChoresOfUser(String loginid) {
		// TODO Auto-generated method stub
		List<kid_chore> listkidChores = new ArrayList<kid_chore>();
//		String sql_listOfAssignedChoresofUser ="select ChoreId , ChoreStatus, Notes from kid_chore  where kidLoginId =  '"+
//									loginid +"' and ChoreStatus = 'A'";
		String sql_listOfAssignedChoresofUser = "SELECT a.ChoreId,b.ChoreDesc,b.ChorePoints,a.Notes,a.ChoreStatus  FROM chorechart.kid_chore a join chorechart.chores b"+
												" on  a.ChoreId = b.ChoreId where kidLoginId =  '"+ loginid +"' and ChoreStatus = 'A'";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql_listOfAssignedChoresofUser);
		for(Map row:rows) {
			//System.out.println("Row values "+row);
			kid_chore kidchores = new kid_chore();
			kidchores.setChoreId((int)row.get("ChoreId"));
			kidchores.setChoreStatus(row.get("ChoreStatus").toString());
			kidchores.setNotes(row.get("Notes").toString());
			Chores choreDesc= new Chores();
			choreDesc.setChoreId((int)row.get("ChoreId"));
			choreDesc.setChoreDesc(row.get("ChoreDesc").toString());
			choreDesc.setChorePoints((int)row.get("ChorePoints"));
			kidchores.setChoreAssigned(choreDesc);
			listkidChores.add(kidchores);
		}
	//	System.out.println("Kids Chore assignemnt "+listkidChores);
		return listkidChores;
	}

	@Override
	public void setApproveStatus(String loginId, int choreId) {
		// TODO Auto-generated method stub
		String sql_update_approve = "Update kid_chore set ChoreStatus = 'D' where kidLoginId = '"+loginId +
				"' and ChoreId = "+choreId;
		jdbcTemplate.update(sql_update_approve);
	}
	
	@Override
	public void setCompleteStatus(String loginId, int choreId) {
		// TODO Auto-generated method stub
		String sql_update_complete = "Update kid_chore set ChoreStatus = 'C' where kidLoginId = '"+loginId +
				"' and ChoreId = "+choreId;
		jdbcTemplate.update(sql_update_complete);
	}


}
