package com.doanwww.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.doanwww.shop.dao.UserDAO;
import com.doanwww.shop.entity.Trademark;
import com.doanwww.shop.entity.User;
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	EntityManager entityManager;

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
		
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
		
	}

	@Override
	public User getbyID(int id) {
		
		return entityManager.find(User.class,id);
	}

	@Override
	public List<User> getAllUser() {
		String jql="SELECT u FROM User u";
		return entityManager.createQuery(jql, User.class).getResultList();
	}

	@Override
	public User getbyUsername(String username) {
		String jql="SELECT u FROM User u where u.username = ?1";
		return entityManager.createQuery(jql, User.class).setParameter(1,username).getSingleResult();
	}



}
