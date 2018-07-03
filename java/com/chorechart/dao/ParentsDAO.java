package com.chorechart.dao;

import java.util.List;

import com.chorechart.model.Kids;
import com.chorechart.model.Parents;

public interface ParentsDAO {
	public void addParent();
	
	public Parents showParents(String userName,String password); 
	
	public List<Kids> showAllKids(String parentsEmail);
	
}
