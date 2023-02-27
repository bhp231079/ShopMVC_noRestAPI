package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.GenderDAO;
import com.doanwww.shop.entity.Gender;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.service.GenderService;

@Service
public class GenderServiceImpl implements GenderService {
	@Autowired
	GenderDAO genderDAO;

	@Override
	public void addGender(GenderDTO genderDTO) {
		Gender gender = new Gender();
		gender.setName(genderDTO.getName());
		genderDAO.addGender(gender);
	}

	@Override
	public void updateGender(GenderDTO genderDTO) {
		Gender gender = genderDAO.getbyID(genderDTO.getId());
		if (gender != null) {
			gender.setName(genderDTO.getName());
		}
		genderDAO.updateGender(gender);
	}

	@Override
	public void deleteGender(GenderDTO genderDTO) {
		Gender gender = genderDAO.getbyID(genderDTO.getId());
		if (gender != null) {
			genderDAO.deleteGender(gender);
		}

	}

	@Override
	public GenderDTO getbyID(int id) {
		Gender gender = genderDAO.getbyID(id);
		GenderDTO genderDTO = new GenderDTO();
		genderDTO.setId(gender.getId());
		genderDTO.setName(gender.getName());
		return genderDTO;
	}

	@Override
	public List<GenderDTO> getAllGender() {
		List<Gender> lisGenders = genderDAO.getAllGender();
		List<GenderDTO> genderDTOs = new ArrayList<GenderDTO>();
		for (Gender gender : lisGenders) {
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setId(gender.getId());
			genderDTO.setName(gender.getName());
			genderDTOs.add(genderDTO);
		}

		return genderDTOs;
	}

}
