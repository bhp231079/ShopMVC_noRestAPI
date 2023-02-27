package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Billproduct;



public interface BillProductDAO {
	public void addBill(Billproduct bill);

	public void updateBill(Billproduct bill);

	public void deleteBill(Billproduct bill);

	public Billproduct getbyID(int  id);

	public List<Billproduct> getAllBill();
}
