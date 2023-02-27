package com.doanwww.shop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doanwww.shop.model.BillDTO;
import com.doanwww.shop.model.BillPKDTO;
import com.doanwww.shop.model.BillProductDTO;
import com.doanwww.shop.model.OrderDTO;
import com.doanwww.shop.model.OrderItemDTO;
import com.doanwww.shop.model.UserDTO;
import com.doanwww.shop.service.BillProductService;
import com.doanwww.shop.service.BillService;

@Controller
@RequestMapping("/client")
public class BillController {
	@Autowired
	BillService  billService;
	
	@Autowired
	BillProductService services;
	
	@PostMapping("/order")
	public String order(Model model, @RequestParam("id") int id, HttpSession session) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(id);
			BillDTO billDTO = new BillDTO();
			billDTO.setPerson(userDTO);
			billDTO.setPriceTotal(0);
			billDTO.setBuyDate(new Date());
			billService.addBill(billDTO);
			
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			List<OrderItemDTO> itemDTOs = orderDTO.getItemDTOs();
			for (OrderItemDTO orderItemDTO : itemDTOs) {
				BillProductDTO dto = new BillProductDTO();
				dto.setId(new BillPKDTO(orderItemDTO.getProductDTO().getId(),billDTO.getId()));
				dto.setBill(billDTO);
				
				dto.setProduct(orderItemDTO.getProductDTO());
				dto.setQuantity(orderItemDTO.getNumber());
				dto.setUnitPrice(orderItemDTO.getProductDTO().getPrice()*orderItemDTO.getNumber());
				services.addBill(dto);
			}
		return "redirect:/";
	}
}
