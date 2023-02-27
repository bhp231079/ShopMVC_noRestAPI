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
import com.doanwww.shop.model.TrademarkDTO;
import com.doanwww.shop.service.GenderService;
import com.doanwww.shop.service.SizeService;
import com.doanwww.shop.service.TrademarkService;

@Controller
@RequestMapping("/admin")
public class TrademarkController {
	@Autowired
	private TrademarkService trademarkService;
	@GetMapping(value = "/trademark/view")
	public String view(Model model , HttpServletRequest request) {
		request.setAttribute("list", trademarkService.getAllTrademark());
		return "/admin/view/trademark";
		
	}
	
	@PostMapping(value = "/trademark/view")
	public String view(Model model , @ModelAttribute TrademarkDTO trademarkDTO) {
		trademarkService.addTrademark(trademarkDTO);
		return "redirect:/admin/trademark/view";
		
	}
}
