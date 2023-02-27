package com.doanwww.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doanwww.shop.model.CategoryDTO;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.service.CategoryService;
import com.doanwww.shop.service.GenderService;
import com.doanwww.shop.service.SizeService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping(value = "/category/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", categoryService.getAllCategory());
		return "/admin/view/category";
		
	}
	
	@PostMapping(value = "/category/view")
	public String view(Model model , @ModelAttribute CategoryDTO categoryDTO) {
		categoryService.addCategory(categoryDTO);
		return "redirect:/admin/category/view";
		
	}
}
