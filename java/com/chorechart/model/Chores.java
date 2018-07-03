package com.chorechart.model;

public class Chores {
	  int ChoreId;
	  String ChoreDesc;
	  int ChorePoints;
	  int ChoreSuggestedAge;
	public int getChoreSuggestedAge() {
		return ChoreSuggestedAge;
	}
	public void setChoreSuggestedAge(int choreSuggestedAge) {
		ChoreSuggestedAge = choreSuggestedAge;
	}
	/**
	 * @return the choreId
	 */
	public int getChoreId() {
		return ChoreId;
	}
	/**
	 * @param choreId the choreId to set
	 */
	public void setChoreId(int choreId) {
		ChoreId = choreId;
	}
	/**
	 * @return the choreDesc
	 */
	public String getChoreDesc() {
		return ChoreDesc;
	}
	/**
	 * @param choreDesc the choreDesc to set
	 */
	public void setChoreDesc(String choreDesc) {
		ChoreDesc = choreDesc;
	}
	/**
	 * @return the chorePoints
	 */
	public int getChorePoints() {
		return ChorePoints;
	}
	/**
	 * @param chorePoints the chorePoints to set
	 */
	public void setChorePoints(int chorePoints) {
		ChorePoints = chorePoints;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ChoreDesc == null) ? 0 : ChoreDesc.hashCode());
		
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chores other = (Chores) obj;
		if (ChoreDesc == null) {
			if (other.ChoreDesc != null)
				return false;
		} else if (!ChoreDesc.equals(other.ChoreDesc))
			return false;
		if (ChoreId != other.ChoreId)
			return false;
		if (ChorePoints != other.ChorePoints)
			return false;
		if (ChoreSuggestedAge != other.ChoreSuggestedAge)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Chores [ChoreId=" + ChoreId + ", ChoreDesc=" + ChoreDesc + ", ChorePoints=" + ChorePoints
				+ ", ChoreSuggestedAge=" + ChoreSuggestedAge + "]";
	}
	
	

}
