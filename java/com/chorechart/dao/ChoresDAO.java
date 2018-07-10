package com.chorechart.dao;

import java.util.List;

import com.chorechart.model.Chores;
import com.chorechart.model.kid_chore;

public interface ChoresDAO {
	public void addChore(Chores newChore);
	public List<Chores> displayChores();
	public List<kid_chore> displayChoresOfUser(String loginid);
	public List<kid_chore> displayCompletedChoresOfUser(String loginid);
	public List<kid_chore> displayAssignedChoresOfUser(String loginid);
	public void assignChoreToKid(String loginId,int choreId,int points);
	public void setApproveStatus(String loginId,int choreId);
	public void setCompleteStatus(String loginId,int choreId);
	public void addAndAssignChoreToKid(String loginId,Chores newChore);

}
