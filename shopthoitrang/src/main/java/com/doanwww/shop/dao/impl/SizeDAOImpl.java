package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.SizeDAO;
import com.doanwww.shop.entity.Size;

@Repository
@Transactional
public class SizeDAOImpl implements SizeDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addSize(Size size) {
		entityManager.persist(size);
	}

	@Override
	public void updateSize(Size size) {
		entityManager.merge(size);
		
	}

	@Override
	public void deleteSize(Size size) {
		entityManager.remove(size);
		
	}

	@Override
	public Size getbyID(int id) {
		return entityManager.find(Size.class, id);
	}

	@Override
	public List<Size> getAllSize() {
		String jql="SELECT s FROM Size s" ; 
		return entityManager.createQuery(jql,Size.class).getResultList();
	}

//	@Override
//	public Size getbySize(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
