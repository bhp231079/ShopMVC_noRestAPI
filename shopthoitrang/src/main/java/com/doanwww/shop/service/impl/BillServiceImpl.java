package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.BillDAO;
import com.doanwww.shop.dao.BillProductDAO;
import com.doanwww.shop.entity.Bill;
import com.doanwww.shop.entity.Product;
import com.doanwww.shop.entity.User;
import com.doanwww.shop.model.BillDTO;
import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.service.BillService;
@Service
public class BillServiceImpl  implements BillService{
	@Autowired
	BillDAO billDAO;
	@Override
	public void addBill(BillDTO billdto) {
		Bill  bill = new Bill();
		User user = new User();
		user.setId(billdto.getPerson().getId());
		bill.setUser(user);
		bill.setBuyDate(billdto.getBuyDate());
		bill.setDiscountPercent(0);
		bill.setPriceTotal(billdto.getPriceTotal());
		billDAO.addBill(bill);
	}

	@Override
	public void updateBill(BillDTO billdto) {

	}

	@Override
	public void deleteBill(BillDTO billdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BillDTO getbyID(int id) {
		Bill bill = billDAO.getbyID(id);
		BillDTO billDTO = new BillDTO();
		UserDTO  userDTO =  new UserDTO();
		userDTO.setId(bill.getUser().getId());
		userDTO.setName(bill.getUser().getName());
		userDTO.setAddress(bill.getUser().getAddress());
		userDTO.setPhone(bill.getUser().getPhone());
		userDTO.setEmail(bill.getUser().getEmail());
		billDTO.setPerson(userDTO);
		billDTO.setDiscountPercent(0);
		billDTO.setBuyDate(bill.getBuyDate());
		billDTO.setPriceTotal(bill.getPriceTotal());
		billDTO.setId(bill.getId());
		
		return billDTO;
	}

	@Override
	public List<BillDTO> getAllBill() {
			
			List<BillDTO> billDTOs = new ArrayList<BillDTO>();
			List<Bill> bills = billDAO.getAllBill();
			for (Bill bill : bills) {
				BillDTO  billDTO = new BillDTO();
				UserDTO userDTO = new UserDTO();
				userDTO.setId(bill.getUser().getId());
				userDTO.setName(bill.getUser().getName());
				userDTO.setEmail(bill.getUser().getEmail());
				billDTO.setId(bill.getId());
				billDTO.setPerson(userDTO);
				billDTO.setDiscountPercent(0);
				billDTO.setPriceTotal(bill.getDiscountPercent());
				billDTO.setBuyDate(bill.getBuyDate());
				billDTOs.add(billDTO);
				
				
			}
			return billDTOs;
	}

}
