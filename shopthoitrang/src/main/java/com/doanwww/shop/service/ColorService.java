package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.model.ColorDTO;

public interface ColorService {
	public void addColor(ColorDTO color);

	public void updateColor(ColorDTO  color);

	public void deleteColor(ColorDTO  color);

	public ColorDTO getbyID(int  id);

	public List<ColorDTO> getAllColor();
}
