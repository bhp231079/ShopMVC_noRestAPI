package com.doanwww.shop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doanwww.shop.model.OrderDTO;
import com.doanwww.shop.model.OrderItemDTO;
import com.doanwww.shop.model.ProductDTO;
import com.doanwww.shop.service.ProductService;

@Controller
@RequestMapping(value = {"/client"})
public class CartController {
	@Autowired
	ProductService productService;
	
	private float Sum=0;
	@RequestMapping(value = {"/product/add-to-cart"})
	public String cart(HttpServletRequest request, @RequestParam(name = "id") int id, HttpSession session) {
	 ProductDTO productDTO = productService.getbyID(id);
	
	
		if (session.getAttribute("cart") ==null) {
			 OrderItemDTO orderItemDTO = new OrderItemDTO();
			 OrderDTO orderDTO = new OrderDTO();
			 orderItemDTO.setNumber(1);
			 orderItemDTO.setProductDTO(productDTO);
			
			 List<OrderItemDTO> itemDTOs = new ArrayList<OrderItemDTO>();
			 itemDTOs.add(orderItemDTO);
			 orderDTO.setItemDTOs(itemDTOs);
			 session.setAttribute("cart", orderDTO);
		} else {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			 List<OrderItemDTO> itemDTOs = orderDTO.getItemDTOs();
			 boolean flag=false;
			 for (OrderItemDTO orderItemDTO : itemDTOs ) {
				 if (orderItemDTO.getProductDTO().getId()== productDTO.getId()) {
					 orderItemDTO.setNumber( orderItemDTO.getNumber() +1);
					 flag=true;
					
				 }   
			 } 
			 if (!flag) {
				 OrderItemDTO orderItemDTO = new OrderItemDTO();
				 orderItemDTO.setNumber(1);
				 orderItemDTO.setProductDTO(productDTO);
				 itemDTOs.add(orderItemDTO);
				 orderDTO.setItemDTOs(itemDTOs);
			 }
			 session.setAttribute("cart", orderDTO);
				
		}	
			
		
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
		request.setAttribute("user",session.getAttribute("user") );
		request.setAttribute("order", orderDTO);
		request.setAttribute("sum", orderDTO.getItemDTOs().size());
		return "/client/view/cart";
		
	}
	
	@RequestMapping(value = {"/view-to-cart"})
	public String cart(HttpServletRequest request,HttpSession session) {
		if (session.getAttribute("cart")!=null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			request.setAttribute("sum", orderDTO.getItemDTOs().size());
			request.setAttribute("order", orderDTO);
			
		}
		if (session.getAttribute("user")!=null)
		request.setAttribute("user",session.getAttribute("user") );
		return "/client/view/cart";
		
	}
	
	
	@RequestMapping(value = {"/delete-to-cart"})
	public String delete(HttpServletRequest request,HttpSession session,@RequestParam(name = "id") int id) {
		
		
		if (session.getAttribute("cart")!=null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			List<OrderItemDTO> itemDTOs = orderDTO.getItemDTOs();
			 boolean flag=false;
			Iterator<OrderItemDTO> iterator =itemDTOs.iterator();
			while(iterator.hasNext()) {
				if (iterator.next().getProductDTO().getId()==id)	 
				{
//					iterator.next().setNumber(iterator.next().getNumber()-1);
//					if (iterator.next().getNumber()==0) {
						iterator.remove();
						
//					}
				}
				
			}
		
				if (itemDTOs.isEmpty()) {
					session.removeAttribute("cart");
				}
				request.setAttribute("sum", orderDTO.getItemDTOs().size());
				request.setAttribute("order", orderDTO);
				request.setAttribute("user",session.getAttribute("user") );
				return "/client/view/cart";
		}
//		OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
		
		
		return null;
	}
	
	@RequestMapping(value = {"/product/update-to-cart"})
	public String update(HttpServletRequest request, @RequestParam(name = "id") int id, @RequestParam(name = "count") int count,HttpSession session) {
	 ProductDTO productDTO = productService.getbyID(id);
	
	
		if (session.getAttribute("cart") ==null) {
			 OrderItemDTO orderItemDTO = new OrderItemDTO();
			 OrderDTO orderDTO = new OrderDTO();
			 orderItemDTO.setNumber(count);
			 orderItemDTO.setProductDTO(productDTO);
			 List<OrderItemDTO> itemDTOs = new ArrayList<OrderItemDTO>();
			 itemDTOs.add(orderItemDTO);
			 orderDTO.setItemDTOs(itemDTOs);
			 session.setAttribute("cart", orderDTO);
		} else {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			 List<OrderItemDTO> itemDTOs = orderDTO.getItemDTOs();
			 boolean flag=false;
			 for (OrderItemDTO orderItemDTO : itemDTOs ) {
				 if (orderItemDTO.getProductDTO().getId()== productDTO.getId()) {
					 orderItemDTO.setNumber( orderItemDTO.getNumber() +count);
					 flag=true;
				 }   
			 } 
			 if (!flag) {
				 OrderItemDTO orderItemDTO = new OrderItemDTO();
				 orderItemDTO.setNumber(count);
				 orderItemDTO.setProductDTO(productDTO);
				 itemDTOs.add(orderItemDTO);
				 orderDTO.setItemDTOs(itemDTOs);
			 }
			 session.setAttribute("cart", orderDTO);
				
		}	
			
	
		OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
		
		request.setAttribute("order", orderDTO);
		request.setAttribute("sum", orderDTO.getItemDTOs().size());
		request.setAttribute("user",session.getAttribute("user") );
		return "/client/view/cart";
		
	}
		
	@RequestMapping(value = {"/payment"})
	public String payment(HttpServletRequest request,HttpSession session) {
		if (session.getAttribute("cart")!=null) {
			OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
			request.setAttribute("sum", orderDTO.getItemDTOs().size());
			request.setAttribute("order", orderDTO);
			List<OrderItemDTO> itemDTOs = orderDTO.getItemDTOs();
			for (OrderItemDTO orderItemDTO : itemDTOs) {
					Sum += orderItemDTO.getNumber() *orderItemDTO.getProductDTO().getPrice();
			}
			
		}
		if (session.getAttribute("user")== null) {
			request.setAttribute("error", null);
		} else 
			request.setAttribute("error", "100");
		request.setAttribute("user",session.getAttribute("user") );
		session.setAttribute("Tong", Sum);
		request.setAttribute("Tong",session.getAttribute("Tong"));
		System.out.println(Sum);
//		request.setAttribute("Max",Sum);
		return "/client/view/payment";
		
	}
}




