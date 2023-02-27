package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.BillDAO;
import com.doanwww.shop.entity.Bill;
@Repository
@Transactional
public class BillDAOImpl implements BillDAO{
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void addBill(Bill bill) {
		entityManager.persist(bill);
		
	}

	@Override
	public void updateBill(Bill bill) {
		// TODO Auto-generated method stub
		entityManager.merge(bill);
	}

	@Override
	public void deleteBill(Bill bill) {
		// TODO Auto-generated method stub
		entityManager.remove(bill);
		
	}

	@Override
	public Bill getbyID(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Bill.class, id);
	}

	@Override
	public List<Bill> getAllBill() {
		String jpql="SELECT b FROM Bill b";
		return entityManager.createQuery(jpql, Bill.class).getResultList();
	}

}
