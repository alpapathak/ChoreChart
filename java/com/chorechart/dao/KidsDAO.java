package com.chorechart.dao;

import java.util.List;

import com.chorechart.model.Kids;

public interface KidsDAO {
	public void addKid(Kids kid);
	public List<Kids> returnListKids(String userName);
	public Kids returnUser(String loginid,String password);

}
