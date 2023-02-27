package com.doanwww.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doanwww.shop.dao.ProductDAO;
import com.doanwww.shop.entity.Product;
import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.service.ProductService;
import com.doanwww.shop.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	@RequestMapping("/")
	public String home(Model model, HttpSession session) {
		UserDetails userDetails = null;
		Object b =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (b!="anonymousUser") {
			userDetails = (UserDetails) b;
		}
		if (userDetails != null) {
			session.setAttribute("user",userService.getbyUserName(userDetails.getUsername()));
			model.addAttribute("user", userService.getbyUserName(userDetails.getUsername()));
		}
//		if (userDetails != null) {
//			
//			model.addAttribute("user", userService.getbyUserName(userDetails.getUsername()));
//		}
//	List<Product> products=	  productDAO.getAllProductsbyDM("Ao khoac nam", 13, "OWEN");
//	for (Product product : products) {
//		System.out.println(product.getName());
		
//	}
		return"/client/view/index";
		
	
	}
	@GetMapping("/user/detail")
	public String detail(Model model , @RequestParam(name="id") int id) {
		model.addAttribute("user",userService.getbyID(id));
		return "client/view/account/detail";
		
	}
	@PostMapping("/user/detail")
	public String detail(Model model, @ModelAttribute(name="user") UserDTO userDTO ) {
		userService.updateUser(userDTO);
		
		
		return "client/view/account/detail";
		
	}
	
}
