package com.doanwww.shop.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.doanwww.shop.dao.ProductDAO;
import com.doanwww.shop.entity.Product;
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		entityManager.remove(product);
		
		
	}

	@Override
	public Product getbyID(int id) {
		return entityManager.find(Product.class, id);
	
	}

	@Override
	public List<Product> getAllProduct() {
		String jql="SELECT p FROM Product p";
		return entityManager.createQuery(jql, Product.class).getResultList();
	
	}

	@Override
	public List<Product> getAllProductsbyDM(String dm) {
		String jql="SELECT p FROM Product p where p.category.name  like  :dm  ";
		
		return entityManager.createQuery(jql, Product.class).setParameter("dm","%"+dm+"%").getResultList();
	}

	@Override
	public List<Product> getAllProductsbyDM(String dm, int id,String tm) {
		String jql="SELECT p FROM Product p where p.category.name  like  :dm  and p.id != :id and p.trademark.name like   :tm";
		return entityManager.createQuery(jql, Product.class).setParameter("dm","%"+dm+"%").setParameter("id", id).setParameter("tm", "%"+tm+"%").setFirstResult(0).getResultList();
	}

	@Override
	public List<Product> getAllProductbySearch(String name) {	
		String jql="SELECT p FROM Product p where p.name  like  '%:name%' or p.price = :name";
		return entityManager.createQuery(jql, Product.class).setParameter("name",name).getResultList();
	}

	
}
