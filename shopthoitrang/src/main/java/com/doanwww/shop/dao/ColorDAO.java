package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Color;

public interface ColorDAO {
	public void addColor(Color color);

	public void updateColor(Color color);

	public void deleteColor(Color color);

	public Color getbyID(int  id);

	public List<Color> getAllColor();
}
