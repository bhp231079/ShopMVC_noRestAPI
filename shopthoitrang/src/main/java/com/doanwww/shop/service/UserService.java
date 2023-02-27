package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.model.UserDTO;



public interface UserService {
	public void addUser(UserDTO user);

	public void updateUser(UserDTO user);

	public void deleteUser(UserDTO user);

	public UserDTO getbyID(int  id);

	public List<UserDTO> getAllUser();
	
	public UserDTO getbyUserName(String  username);
	
	
}
