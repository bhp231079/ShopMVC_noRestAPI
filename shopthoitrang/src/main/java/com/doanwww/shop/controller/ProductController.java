package com.doanwww.shop.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.doanwww.shop.entity.User;
import com.doanwww.shop.model.CategoryDTO;
import com.doanwww.shop.model.ColorDTO;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.model.ProductDTO;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.model.TrademarkDTO;
import com.doanwww.shop.service.CategoryService;
import com.doanwww.shop.service.ColorService;
import com.doanwww.shop.service.GenderService;
import com.doanwww.shop.service.ProductService;
import com.doanwww.shop.service.SizeService;
import com.doanwww.shop.service.TrademarkService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private SizeService sizeService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TrademarkService trademarkService;

	@Autowired
	private GenderService genderService;
	
	@Autowired
	private ColorService colorService;
	
	@GetMapping(value = "/product/view")
	public String view(Model model , HttpServletRequest request) {
		
		UserDetails userDetails=         (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("list", productService.getAllProduct());
		List<SizeDTO> sizes = sizeService.getAllSize();
		List<GenderDTO> genders = genderService.getAllGender();
		List<TrademarkDTO> trds = trademarkService.getAllTrademark();
		List<CategoryDTO> ctgrs = categoryService.getAllCategory();
		List<ColorDTO> cls = colorService.getAllColor();
			
		request.setAttribute("sizes", sizes);
		request.setAttribute("genders", genders);
		request.setAttribute("trds", trds);
		request.setAttribute("ctgrs", ctgrs);
		request.setAttribute("cls", cls);
		return "admin/view/product";
		
	}
	
	@PostMapping(value = "/product/view")
	public String view(Model model , @ModelAttribute ProductDTO productDTO ,@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) {
		try {
			File newFile = new File(
					"C:\\Users\\bhphh\\Documents\\springtoolsuite\\shopthoitrang\\src\\main\\resources\\static\\imgSP\\" + file.getOriginalFilename());
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		String size = request.getParameter("size");
		String trademark = request.getParameter("trademark");
		String category = request.getParameter("category");
		String color = request.getParameter("color");
		ColorDTO colorDTO = colorService.getbyID(Integer.valueOf(color));
		TrademarkDTO tradeMarkDTO = trademarkService.getbyID(Integer.valueOf(trademark));
		GenderDTO genderDTO = genderService.getbyID(Integer.valueOf(gender));
		CategoryDTO categoryDTO = categoryService.getbyID(Integer.valueOf(category));
		SizeDTO sizeDTO = sizeService.getbyID(Integer.valueOf(size));
		productDTO.setImage(file.getOriginalFilename());
		productDTO.setGenderDTO(genderDTO);
		productDTO.setCategoryDTO(categoryDTO);
		productDTO.setSizeDTO(sizeDTO);
		productDTO.setTradeMarkDTO(tradeMarkDTO);
		productDTO.setColorDTO(colorDTO);
//		request.setAttribute("filename", file.getOriginalFilename());
		productService.addProduct(productDTO);
		return "redirect:/admin/product/view";
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
}
