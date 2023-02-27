package com.doanwww.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.service.GenderService;
import com.doanwww.shop.service.SizeService;

@Controller
@RequestMapping("/admin")
public class GenderController {
	@Autowired
	private GenderService genderService;
	@GetMapping(value = "/gender/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", genderService.getAllGender());
		return "/admin/view/gender";
		
	}
	
	@PostMapping(value = "/gender/view")
	public String view(Model model , @ModelAttribute GenderDTO genderDTO) {
		genderService.addGender(genderDTO);
		return "redirect:/admin/gender/view";
		
	}
}
