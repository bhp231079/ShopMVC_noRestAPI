package com.doanwww.shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doanwww.shop.entity.Product;
import com.doanwww.shop.model.ProductDTO;
import com.doanwww.shop.service.ProductService;
import com.doanwww.shop.service.UserService;
@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ProductService productService;
	
	@Autowired UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest req, @RequestParam(name="e", required = false) String e) {
		if (e != null) {
			req.setAttribute("e", e);
		}
		return"/client/view/account/login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return"/client/view/account/register";
	}
	

	@RequestMapping("/product/{name}")
	public String product(@PathVariable(name = "name") String name, Model model, HttpSession session) {
		List<ProductDTO> products = productService.getAllProductsbyDM(name);
		model.addAttribute("list", products);
		model.addAttribute("sumsize", products.size());
		model.addAttribute("product", products.get(0));
		model.addAttribute("user",session.getAttribute("user") );
		return"/client/view/product/product";
	}
	@RequestMapping(value = "/download-file")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getParameter("image");
		String dataDirectory = 	"C:\\Users\\bhphh\\Documents\\springtoolsuite\\shopthoitrang\\src\\main\\resources\\static\\imgSP\\";
		Path file = Paths.get(dataDirectory, filename);
		if (Files.exists(file)) {
			response.setContentType("image/jpeg");
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	@RequestMapping("/product/detail")
	public String products(Model model , @RequestParam(name="id")int id ,@RequestParam(name = "name") String name, @RequestParam(name = "tm") String tm
			, HttpSession session) {
		ProductDTO productDTO = productService.getbyID(id);
			
		model.addAttribute("user",session.getAttribute("user") );
		model.addAttribute("product", productDTO);
		model.addAttribute("list", productService.getAllProductsbyDM(name, id, tm));
		return"/client/view/product/detail-prd";
	}
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam(name="name") String name, HttpSession session) {
		List<ProductDTO> products = productService.getAllProductbySearch(name);
		model.addAttribute("list", products);
		model.addAttribute("sumsize", products.size());
		model.addAttribute("product", products.get(0));
		model.addAttribute("user",session.getAttribute("user") );
		model.addAttribute("search", name);
		return "/client/view/product/search";
		
	}
	
}
