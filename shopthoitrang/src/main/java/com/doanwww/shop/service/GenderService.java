package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.model.GenderDTO;

public interface GenderService {
	public void addGender(GenderDTO Gender);

	public void updateGender(GenderDTO  Gender);

	public void deleteGender(GenderDTO  Gender);

	public GenderDTO getbyID(int  id);

	public List<GenderDTO> getAllGender();
}
