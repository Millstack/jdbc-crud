package com.jsp.Dao;

import java.util.List;

import com.jsp.Dto.Cafe;

public interface CafeDao {
	
	boolean addCafe( Cafe cafe);
	boolean updateCafe (Cafe cafe);
	boolean deleteCcafe (int cafeID);
	Cafe searchCafeById (int cafeId);
	List<Cafe> getAllCafe();
}