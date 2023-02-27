package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Gender;

public interface GenderDAO {
	public void addGender(Gender gender);

	public void updateGender(Gender gender);

	public void deleteGender(Gender gender);

	public Gender getbyID(int  id);

	public List<Gender> getAllGender();
}
