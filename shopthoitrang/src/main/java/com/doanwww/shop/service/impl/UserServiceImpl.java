package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.UserDAO;
import com.doanwww.shop.dao.UserDAO;
import com.doanwww.shop.entity.User;
import com.doanwww.shop.entity.User;
import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService  {
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void addUser(UserDTO Userdto) {
		User User = new User();
		User.setName(Userdto.getName());
		User.setAddress(Userdto.getAddress());
		User.setAge(Userdto.getAge());
		User.setEmail(Userdto.getEmail());
		User.setUsername(Userdto.getUsername());
		User.setPhone(Userdto.getPhone());
		User.setRole(Userdto.getRole());
		User.setGender(Userdto.getGender());
		User.setPassword(Userdto.getPassword());
		userDAO.addUser(User);
	}

	@Override
	public void updateUser(UserDTO Userdto) {
		User User = userDAO.getbyID(Userdto.getId());
		if (User != null ) {
			User.setName(Userdto.getName());
			User.setAddress(Userdto.getAddress());
			User.setAge(Userdto.getAge());
			User.setEmail(Userdto.getEmail());
			User.setUsername(Userdto.getUsername());
			User.setPhone(Userdto.getPhone());
			User.setRole(Userdto.getRole());
			User.setGender(Userdto.getGender());
			User.setPassword(Userdto.getPassword());
			userDAO.updateUser(User);
		}
		
	}

	@Override
	public void deleteUser(UserDTO Userdto) {
		User User = userDAO.getbyID(Userdto.getId());
		if (User != null ) { 
			userDAO.deleteUser(User);
		}
		
	}

	@Override
	public UserDTO getbyID(int id) {
		User user = userDAO.getbyID(id);
		UserDTO UserDTO = new UserDTO();
		UserDTO.setId(user.getId());
		UserDTO.setName(user.getName());
		UserDTO.setAddress(user.getAddress());
		UserDTO.setAge(user.getAge());
		UserDTO.setEmail(user.getEmail());
 
		UserDTO.setUsername(user.getUsername());
		UserDTO.setPhone(user.getPhone());
		UserDTO.setRole(user.getRole());
		UserDTO.setGender(user.getGender());
		UserDTO.setPassword(user.getPassword());
		
		return UserDTO;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> list = userDAO.getAllUser();
		List<UserDTO> UserDTOs = new ArrayList<UserDTO>();
		for (User User : list) {
			UserDTO UserDTO = new UserDTO();
			UserDTO.setId(User.getId());
			UserDTO.setName(User.getName());
			UserDTO.setAddress(User.getAddress());
			UserDTO.setAge(User.getAge());
			UserDTO.setEmail(User.getEmail());
			UserDTO.setUsername(User.getUsername());
			UserDTO.setPhone(User.getPhone());
			UserDTO.setRole(User.getRole());
			UserDTO.setGender(User.getGender());
			UserDTO.setPassword(User.getPassword());
			UserDTOs.add(UserDTO);
		}
		return UserDTOs;
	}
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.getbyUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException("no user");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		UserDetails details = new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		return details;
	}

	@Override
	public UserDTO getbyUserName(String username) {
		User user = userDAO.getbyUsername(username);
		UserDTO UserDTO = new UserDTO();
		UserDTO.setId(user.getId());
		UserDTO.setName(user.getName());
		UserDTO.setAddress(user.getAddress());
		UserDTO.setAge(user.getAge());
		UserDTO.setEmail(user.getEmail());
 
		UserDTO.setUsername(user.getUsername());
		UserDTO.setPhone(user.getPhone());
		UserDTO.setRole(user.getRole());
		UserDTO.setGender(user.getGender());
		UserDTO.setPassword(user.getPassword());
		
		return UserDTO;
	}
	
	

}
