package com.chorechart.dao;

import com.chorechart.model.Register;

public interface RegisterDAO {
	public void insertUser(Register registerUser);
	public Register findUser(String userName,String userPwd);

}
