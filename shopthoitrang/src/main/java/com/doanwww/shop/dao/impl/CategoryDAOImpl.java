package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.CategoryDAO;
import com.doanwww.shop.entity.Category;
@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	EntityManager entityManager;
	@Override
	public void addCategory(Category category) {
		entityManager.persist(category);
		
	}

	@Override
	public void updateCategory(Category category) {
		entityManager.merge(category);
		
	}

	@Override
	public void deleteCategory(Category category) {
		entityManager.remove(category);
		
	}

	@Override
	public Category getbyID(int id) {
		return entityManager.find(Category.class, id);
	}

	@Override
	public List<Category> getAllCategory() {
		String jql="SELECT c FROM Category c";
		return entityManager.createQuery(jql, Category.class).getResultList();
	}

}
