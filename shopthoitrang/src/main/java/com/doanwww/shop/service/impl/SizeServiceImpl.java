package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.SizeDAO;
import com.doanwww.shop.entity.Size;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.service.SizeService;
@Service
public class SizeServiceImpl  implements SizeService{
	
	@Autowired
	private SizeDAO sizeDAO;
	
	@Override
	public void addSize(SizeDTO sizeDTO) {
		Size size = new Size();
		size.setName(sizeDTO.getName());
		sizeDAO.addSize(size);
		
	}

	@Override
	public void updateSize(SizeDTO sizeDTO) {
		Size size = sizeDAO.getbyID(sizeDTO.getId());
		if (size!=null) {
			size.setName(sizeDTO.getName());
		}
		sizeDAO.updateSize(size);
		
	}

	@Override
	public void deleteSize(SizeDTO sizeDTO) {
		Size size = sizeDAO.getbyID(sizeDTO.getId());
		if (size!=null) {
			sizeDAO.deleteSize(size);	
		}
	
		
	}

	@Override
	public SizeDTO getbyID(int id) {
		Size size = sizeDAO.getbyID(id);
		SizeDTO sizeDTO = new SizeDTO();
		sizeDTO.setId(size.getId());
		sizeDTO.setName(size.getName());
		
		
		return sizeDTO;
	}

	@Override
	public List<SizeDTO> getAllSize() {
		List<Size> sizes = sizeDAO.getAllSize();
		List<SizeDTO> sizeDTOs = new ArrayList<SizeDTO>();	
		
		for (Size size : sizes) {
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(size.getId());
			sizeDTO.setName(size.getName());
			sizeDTOs.add(sizeDTO);
			
		}
		return sizeDTOs;
	}

}
