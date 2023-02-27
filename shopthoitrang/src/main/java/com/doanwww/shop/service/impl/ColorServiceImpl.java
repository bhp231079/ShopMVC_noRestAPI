package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.CategoryDAO;
import com.doanwww.shop.dao.ColorDAO;
import com.doanwww.shop.entity.Category;
import com.doanwww.shop.entity.Color;
import com.doanwww.shop.entity.Gender;
import com.doanwww.shop.model.ColorDTO;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.service.ColorService;
@Service
public class ColorServiceImpl implements  ColorService {
	
	@Autowired
	private ColorDAO colorDAO;
	
	@Override
	public void addColor(ColorDTO colorDTO) {
		Color color = new Color();
		color.setName(colorDTO.getName());
		colorDAO.addColor(color);
		
	}

	@Override
	public void updateColor(ColorDTO colorDTO) {
		Color color = colorDAO.getbyID(colorDTO.getId());
		if (color != null) {
			color.setName(colorDTO.getName());
		}
		colorDAO.updateColor(color);
		
	}

	@Override
	public void deleteColor(ColorDTO colorDTO) {
		Color color = colorDAO.getbyID(colorDTO.getId());
		if (color != null) {
			colorDAO.deleteColor(color);
		}
		
	}

	@Override
	public ColorDTO getbyID(int id) {
		Color color = colorDAO.getbyID(id);
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setId(color.getId());
		colorDTO.setName(color.getName());
		return colorDTO;
	}

	@Override
	public List<ColorDTO> getAllColor() {
		List<Color> listColors = colorDAO.getAllColor();
		List<ColorDTO> colorDTOs = new ArrayList<ColorDTO>();
		for (Color color : listColors) {
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(color.getId());
			colorDTO.setName(color.getName());
			colorDTOs.add(colorDTO);
		}

		return colorDTOs;
	}

}
