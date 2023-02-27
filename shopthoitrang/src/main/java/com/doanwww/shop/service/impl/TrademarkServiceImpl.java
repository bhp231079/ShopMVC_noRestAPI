package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.TrademarkDAO;
import com.doanwww.shop.entity.Trademark;
import com.doanwww.shop.service.TrademarkService;
import com.doanwww.shop.model.TrademarkDTO;


@Service
public class TrademarkServiceImpl implements TrademarkService {
	@Autowired
	private TrademarkDAO trademarkDAO;
	@Override
	public void addTrademark(TrademarkDTO TrademarkDTO) {
		Trademark trademark = new Trademark();
		trademark.setName(TrademarkDTO.getName());
		trademarkDAO.addTrademark(trademark);
	}

	@Override
	public void updateTrademark(TrademarkDTO TrademarkDTO) {
		Trademark trademark = trademarkDAO.getbyID(TrademarkDTO.getId());
		if (trademark!=null) {
			trademark.setName(TrademarkDTO.getName());
			trademarkDAO.updateTrademark(trademark);
		}
		
	}

	@Override
	public void deleteTrademark(TrademarkDTO TrademarkDTO) {
		Trademark trademark = trademarkDAO.getbyID(TrademarkDTO.getId());
		if (trademark!=null) {
			trademarkDAO.deleteTrademark(trademark);
		}
	}

	@Override
	public TrademarkDTO getbyID(int id) {
		Trademark trademark = trademarkDAO.getbyID(id);
		TrademarkDTO TrademarkDTO = new TrademarkDTO();
		TrademarkDTO.setId(trademark.getId());
		TrademarkDTO.setName(trademark.getName());
		return TrademarkDTO;
	}

	@Override
	public List<TrademarkDTO> getAllTrademark() {
		List<Trademark> tradeMarks = trademarkDAO.getAllTrademark();
		List<TrademarkDTO> TrademarkDTOs = new ArrayList<TrademarkDTO>();	
		
		for (Trademark trademark : tradeMarks) {
			TrademarkDTO TrademarkDTO = new TrademarkDTO();
			TrademarkDTO.setId(trademark.getId());
			TrademarkDTO.setName(trademark.getName());
			TrademarkDTOs.add(TrademarkDTO);
			
		}
		return TrademarkDTOs;
	}

}
