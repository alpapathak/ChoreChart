package com.chorechart.model;

public class Rewards {
	int rewardId;
	String rewardsDesc;
	/**
	 * @return the rewardId
	 */
	public int getRewardId() {
		return rewardId;
	}
	/**
	 * @param rewardId the rewardId to set
	 */
	public void setRewardId(int rewardId) {
		this.rewardId = rewardId;
	}
	/**
	 * @return the rewardsDesc
	 */
	public String getRewardsDesc() {
		return rewardsDesc;
	}
	/**
	 * @param rewardsDesc the rewardsDesc to set
	 */
	public void setRewardsDesc(String rewardsDesc) {
		this.rewardsDesc = rewardsDesc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rewardId;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rewards)) {
			return false;
		}
		Rewards other = (Rewards) obj;
		if (rewardId != other.rewardId) {
			return false;
		}
		if (rewardsDesc == null) {
			if (other.rewardsDesc != null) {
				return false;
			}
		} else if (!rewardsDesc.equals(other.rewardsDesc)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rewards [rewardId=" + rewardId + ", " + (rewardsDesc != null ? "rewardsDesc=" + rewardsDesc : "") + "]";
	}
	
	

}
