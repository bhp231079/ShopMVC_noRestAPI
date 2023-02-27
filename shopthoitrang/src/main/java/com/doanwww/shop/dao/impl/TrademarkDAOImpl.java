package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.TrademarkDAO;
import com.doanwww.shop.entity.Trademark;

@Repository
@Transactional
public class TrademarkDAOImpl implements TrademarkDAO{
	@Autowired
	EntityManager entityManager;
	@Override
	public void addTrademark(Trademark trademark) {
		entityManager.persist(trademark);
		
	}

	@Override
	public void updateTrademark(Trademark trademark) {
		entityManager.merge(trademark);
		
	}

	@Override
	public void deleteTrademark(Trademark trademark) {
		// TODO Auto-generated method stub
		entityManager.remove(trademark);
	}

	@Override
	public Trademark getbyID(int id) {
		return entityManager.find(Trademark.class, id);
		 
	}

	@Override
	public List<Trademark> getAllTrademark() {
		String jql="SELECT t FROM Trademark t";
		return entityManager.createQuery(jql, Trademark.class).getResultList();
	}

}
