package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Bill;



public interface BillDAO {
	public void addBill(Bill bill);

	public void updateBill(Bill bill);

	public void deleteBill(Bill bill);

	public Bill getbyID(int  id);

	public List<Bill> getAllBill();
}
