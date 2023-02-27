package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.BillProductDAO;
import com.doanwww.shop.entity.Billproduct;
@Repository
@Transactional
public class BillProductDAOImpl implements BillProductDAO{
	@Autowired
	EntityManager entityManager;
	@Override
	public void addBill(Billproduct bill) {
		entityManager.persist(bill);
		
	}

	@Override
	public void updateBill(Billproduct bill) {
		entityManager.merge(bill);
		
	}

	@Override
	public void deleteBill(Billproduct bill) {
		entityManager.remove(bill);
		
	}

	@Override
	public Billproduct getbyID(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Billproduct.class, id);
	}

	@Override
	public List<Billproduct> getAllBill() {
		String jpql="SELECT b FROM Billproduct b";
		return entityManager.createQuery(jpql, Billproduct.class).getResultList();
	}

}
