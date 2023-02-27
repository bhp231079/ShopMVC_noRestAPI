package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.model.BillDTO;
import com.doanwww.shop.model.BillProductDTO;

public interface BillService {
	public void addBill(BillDTO bill);

	public void updateBill(BillDTO bill);

	public void deleteBill(BillDTO bill);

	public BillDTO getbyID(int  id);

	public List<BillDTO> getAllBill();
}
