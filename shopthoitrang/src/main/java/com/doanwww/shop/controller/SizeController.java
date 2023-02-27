package com.doanwww.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.service.SizeService;

@Controller
@RequestMapping("/admin")
public class SizeController {
	@Autowired
	private SizeService sizeService;
	@GetMapping(value = "/size/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", sizeService.getAllSize());
		return "/admin/view/size";
		
	}
	
	@PostMapping(value = "/size/view")
	public String view(Model model , @ModelAttribute SizeDTO sizeDTO) {
		sizeService.addSize(sizeDTO);
		return "redirect:/admin/size/view";
		
	}
}
