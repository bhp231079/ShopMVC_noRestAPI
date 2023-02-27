package com.doanwww.shop.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.GenderDAO;
import com.doanwww.shop.entity.Gender;
@Repository
@Transactional
public class GenderDAOImpl  implements GenderDAO{
	@Autowired
	EntityManager entityManager;

	@Override
	public void addGender(Gender gender) {
		entityManager.persist(gender);
		
	}

	@Override
	public void updateGender(Gender gender) {
		entityManager.merge(gender);
		
	}

	@Override
	public void deleteGender(Gender gender) {
		entityManager.remove(gender);
		
	}

	@Override
	public Gender getbyID(int id) {
		
		return entityManager.find(Gender.class, id);
	}

	@Override
	public List<Gender> getAllGender() {
		String jql="Select g from Gender g";
		
		return entityManager.createQuery(jql,Gender.class).getResultList();
	}
	
	
}
