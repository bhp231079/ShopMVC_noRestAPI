package com.doanwww.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.service.ColorService;
import com.doanwww.shop.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping(value = "/admin/user/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", userService.getAllUser());
		return "/admin/view/user";
		
	}
	
	@PostMapping(value = "/user/view")
	public String view(HttpServletRequest req) {
		String username=req.getParameter("username");
		String pass=req.getParameter("pass");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setPassword(encoder.encode(pass));
		userDTO.setPhone(phone);
		userDTO.setRole("ROLE_USER");
		userDTO.setGender("");
		userDTO.setAge(0);
		userDTO.setUsername(username);
		userDTO.setEmail(email);
		userDTO.setAddress("");
		userService.addUser(userDTO);
		return "redirect:/client/login";
		
	}
	
	
}
