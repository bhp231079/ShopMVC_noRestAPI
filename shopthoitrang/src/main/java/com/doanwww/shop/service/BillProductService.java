package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.entity.Bill;
import com.doanwww.shop.model.BillProductDTO;

public interface BillProductService {
	public void addBill(BillProductDTO bill);

	public void updateBill(BillProductDTO bill);

	public void deleteBill(BillProductDTO bill);

	public BillProductDTO getbyID(int  id);

	public List<BillProductDTO> getAllBill();
}
