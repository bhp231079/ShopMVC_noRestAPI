package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.ColorDAO;
import com.doanwww.shop.entity.Color;

@Repository
@Transactional
public class ColorDAOImpl implements ColorDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public void addColor(Color color) {
		entityManager.persist(color);
		
	}

	@Override
	public void updateColor(Color color) {
		entityManager.merge(color);
		
	}

	@Override
	public void deleteColor(Color color) {
		entityManager.remove(color);
		
	}

	@Override
	public Color getbyID(int id) {
		return 	entityManager.find(Color.class, id);
	}

	@Override
	public List<Color> getAllColor() {
		String jql="SELECT c FROM Color c";
		return entityManager.createQuery(jql, Color.class).getResultList();
	}
	
	
}
