package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.BillDAO;
import com.doanwww.shop.dao.BillProductDAO;
import com.doanwww.shop.entity.Bill;
import com.doanwww.shop.entity.Billproduct;
import com.doanwww.shop.entity.BillproductPK;
import com.doanwww.shop.entity.Product;
import com.doanwww.shop.model.BillDTO;
import com.doanwww.shop.model.BillPKDTO;
import com.doanwww.shop.model.BillProductDTO;
import com.doanwww.shop.model.ProductDTO;
import com.doanwww.shop.service.BillProductService;

@Service
public class BillProductServiceImpl implements BillProductService {
	@Autowired
	BillProductDAO billProductDAO;
	@Override
	public void addBill(BillProductDTO detailbill) {
		Billproduct billproduct = new Billproduct();
		Bill  bill = new Bill();
		Product product = new Product();
		product.setId(detailbill.getProduct().getId());
		bill.setId(detailbill.getBill().getId());
		billproduct.setId(new BillproductPK(product.getId(),bill.getId()));
		billproduct.setProduct(product);
		billproduct.setBill(bill);
		billproduct.setQuantity(detailbill.getQuantity());
		billproduct.setUnitPrice(detailbill.getUnitPrice());
		billProductDAO.addBill(billproduct);
		
		
			
		
	}

	@Override
	public void updateBill(BillProductDTO detailbill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBill(BillProductDTO detailbill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BillProductDTO getbyID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BillProductDTO> getAllBill() {
		List<BillProductDTO> dtos = new ArrayList<BillProductDTO>();
		List<Billproduct> billproducts = billProductDAO.getAllBill();
		for (Billproduct billproduct : billproducts) {
			BillProductDTO dto = new BillProductDTO();
			ProductDTO productDTO = new ProductDTO();
			productDTO.setId(billproduct.getProduct().getId());
			productDTO.setName(billproduct.getProduct().getName());
			BillDTO billDTO = new BillDTO();
			BillPKDTO billPKDTO = new BillPKDTO();
			billPKDTO.setBillid(billproduct.getBill().getId());
			billPKDTO.setPrid(billproduct.getProduct().getId());
			dto.setId(billPKDTO);
			dto.setProduct(productDTO);
			dto.setBill(billDTO);
			dto.setQuantity(billproduct.getQuantity());
			dto.setUnitPrice(billproduct.getUnitPrice());
			dtos.add(dto);
			
			
			
			
		}
		return dtos;
	}

}
