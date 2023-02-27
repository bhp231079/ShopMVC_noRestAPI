package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Size;

public interface SizeDAO {
	public void addSize(Size size);

	public void updateSize(Size size);

	public void deleteSize(Size size);

	public Size getbyID(int  id);

	public List<Size> getAllSize();
}
