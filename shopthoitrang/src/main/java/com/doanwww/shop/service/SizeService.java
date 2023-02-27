package com.doanwww.shop.service;
import java.util.List;

import com.doanwww.shop.model.SizeDTO;



public interface SizeService {
	public void addSize(SizeDTO size);

	public void updateSize(SizeDTO  size);

	public void deleteSize(SizeDTO  size);

	public SizeDTO getbyID(int  id);

	public List<SizeDTO> getAllSize();
}
