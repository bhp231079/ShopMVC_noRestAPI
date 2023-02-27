package com.doanwww.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doanwww.shop.model.ColorDTO;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.service.ColorService;
import com.doanwww.shop.service.GenderService;
import com.doanwww.shop.service.SizeService;

@Controller
@RequestMapping("/admin")
public class ColorController {
	@Autowired
	private ColorService colorService ;
	@GetMapping(value = "/color/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", colorService.getAllColor());
		return "/admin/view/color";
		
	}
	
	@PostMapping(value = "/color/view")
	public String view(Model model , @ModelAttribute ColorDTO colorDTO) {
		colorService.addColor(colorDTO);
		return "redirect:/admin/color/view";
		
	}
	
	
	@GetMapping(value = "/color/delete")
	public String delete(@RequestParam(name="id") int id) {
	    ColorDTO colorDTO = colorService.getbyID(id);
		colorService.deleteColor(colorDTO);
		return "redirect:/admin/color/view";
		
	}
}
