package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Trademark;



public interface TrademarkDAO {
	public void addTrademark(Trademark trademark);

	public void updateTrademark(Trademark trademark);

	public void deleteTrademark(Trademark trademark);

	public Trademark getbyID(int  id);

	public List<Trademark> getAllTrademark();
	
}
