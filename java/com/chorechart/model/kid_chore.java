package com.chorechart.model;

public class kid_chore {
	String kidLoginId;
	int ChoreId;
	String ChoreStatus;
	String Notes;
	Chores choreAssigned;
	int Points;
	
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}
	public Chores getChoreAssigned() {
		return choreAssigned;
	}
	public void setChoreAssigned(Chores choreAssigned) {
		this.choreAssigned = choreAssigned;
	}

	public String getKidLoginId() {
		return kidLoginId;
	}
	public void setKidLoginId(String kidLoginId) {
		this.kidLoginId = kidLoginId;
	}
	public int getChoreId() {
		return ChoreId;
	}
	public void setChoreId(int choreId) {
		ChoreId = choreId;
	}
	public String getChoreStatus() {
		return ChoreStatus;
	}
	public void setChoreStatus(String choreStatus) {
		ChoreStatus = choreStatus;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kidLoginId == null) ? 0 : kidLoginId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof kid_chore))
			return false;
		kid_chore other = (kid_chore) obj;
		if (ChoreId != other.ChoreId)
			return false;
		if (ChoreStatus == null) {
			if (other.ChoreStatus != null)
				return false;
		} else if (!ChoreStatus.equals(other.ChoreStatus))
			return false;
		if (Notes == null) {
			if (other.Notes != null)
				return false;
		} else if (!Notes.equals(other.Notes))
			return false;
		if (kidLoginId == null) {
			if (other.kidLoginId != null)
				return false;
		} else if (!kidLoginId.equals(other.kidLoginId))
			return false;
		return true;
	}
	
	
	
}


