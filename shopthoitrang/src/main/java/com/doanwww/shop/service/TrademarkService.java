package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.model.TrademarkDTO;

public interface TrademarkService {
	public void addTrademark(TrademarkDTO trademarkdto);

	public void updateTrademark(TrademarkDTO trademarkdto);

	public void deleteTrademark(TrademarkDTO trademarkdto);

	public TrademarkDTO getbyID(int  id);

	public List<TrademarkDTO> getAllTrademark();
}
