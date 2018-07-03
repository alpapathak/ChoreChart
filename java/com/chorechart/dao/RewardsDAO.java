package com.chorechart.dao;

import java.util.List;

import com.chorechart.model.Rewards;

public interface RewardsDAO {
	public void addReward(Rewards reward);
	public List<Rewards> rewardsAvailable();
	
}
