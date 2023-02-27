package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.User;
import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.entity.User;

public interface UserDAO {
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getbyID(int  id);

	public List<User> getAllUser();
	
	public User getbyUsername(String username);
}
