  package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.ProductDAO;
import com.doanwww.shop.entity.Category;
import com.doanwww.shop.entity.Color;
import com.doanwww.shop.entity.Gender;
import com.doanwww.shop.entity.Product;
import com.doanwww.shop.entity.Size;
import com.doanwww.shop.entity.Trademark;
import com.doanwww.shop.model.CategoryDTO;
import com.doanwww.shop.model.ColorDTO;
import com.doanwww.shop.model.GenderDTO;
import com.doanwww.shop.model.ProductDTO;
import com.doanwww.shop.model.SizeDTO;
import com.doanwww.shop.model.TrademarkDTO;
import com.doanwww.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void addProduct(ProductDTO productdto) {
		Product product = new Product();
		Category category = new Category();
		category.setId(productdto.getCategoryDTO().getId());
		Trademark trademark = new Trademark();
		trademark.setId(productdto.getTradeMarkDTO().getId());
		Gender gender = new Gender();
		gender.setId(productdto.getGenderDTO().getId());
		Size size = new Size();
		size.setId(productdto.getSizeDTO().getId());
		Color color = new Color();
		color.setId(productdto.getColorDTO().getId());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setImage(productdto.getImage());
		product.setDescription(productdto.getDescription());
		product.setCategory(category);
		product.setGender(gender);
		product.setTrademark(trademark);
		product.setSize(size);
		product.setColor(color);
		product.setCount(productdto.getCount());
		productDAO.addProduct(product);

	}

	@Override
	public void updateProduct(ProductDTO productdto) {
		Category category = new Category();
		category.setId(productdto.getCategoryDTO().getId());
		Trademark trademark = new Trademark();
		trademark.setId(productdto.getTradeMarkDTO().getId());
		Gender gender = new Gender();
		gender.setId(productdto.getGenderDTO().getId());
		Size size = new Size();
		size.setId(productdto.getSizeDTO().getId());
		Color color = new Color();
		color.setId(productdto.getColorDTO().getId());
		Product product = productDAO.getbyID(productdto.getId());
		if (product != null) {
			product.setName(productdto.getName());
			product.setPrice(productdto.getPrice());
			product.setImage(productdto.getImage());
			product.setDescription(productdto.getDescription());
			product.setCategory(category);
			product.setGender(gender);
			product.setTrademark(trademark);
			product.setSize(size);
			product.setColor(color);
			product.setCount(productdto.getCount());
			productDAO.updateProduct(product);
		}

	}

	@Override
	public void deleteProduct(ProductDTO productdto) {
		Product product = productDAO.getbyID(productdto.getId());
		if (product != null ) { 
			productDAO.deleteProduct(product);
		}
	}

	@Override
	public ProductDTO getbyID(int id) {
		Product product = productDAO.getbyID(id);
		ProductDTO productDTO = new ProductDTO();
		CategoryDTO  categoryDTO = new CategoryDTO();
		categoryDTO.setId(product.getCategory().getId());
		categoryDTO.setName(product.getCategory().getName());
		GenderDTO genderDTO = new GenderDTO();
		genderDTO.setId(product.getGender().getId());
		genderDTO.setName(product.getGender().getName());
		TrademarkDTO TrademarkDTO = new TrademarkDTO();
		TrademarkDTO.setId(product.getTrademark().getId());
		TrademarkDTO.setName(product.getTrademark().getName());
		SizeDTO sizeDTO = new SizeDTO();
		sizeDTO.setId(product.getSize().getId());
		sizeDTO.setName(product.getSize().getName());
		ColorDTO colorDTO = new ColorDTO();
		colorDTO.setId(product.getColor().getId());
		colorDTO.setName(product.getColor().getName());
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setImage(product.getImage());
		productDTO.setCategoryDTO(categoryDTO);
		productDTO.setGenderDTO(genderDTO);
		productDTO.setSizeDTO(sizeDTO);
		productDTO.setColorDTO(colorDTO);
		productDTO.setTradeMarkDTO(TrademarkDTO);
		productDTO.setCount(product.getCount());
		productDTO.setPrice(product.getPrice());
		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> products = productDAO.getAllProduct();
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();	
		
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			CategoryDTO  categoryDTO = new CategoryDTO();
			categoryDTO.setId(product.getCategory().getId());
			categoryDTO.setName(product.getCategory().getName());
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setId(product.getGender().getId());
			genderDTO.setName(product.getGender().getName());
			TrademarkDTO TrademarkDTO = new TrademarkDTO();
			TrademarkDTO.setId(product.getTrademark().getId());
			TrademarkDTO.setName(product.getTrademark().getName());
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(product.getSize().getId());
			sizeDTO.setName(product.getSize().getName());
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(product.getColor().getId());
			colorDTO.setName(product.getColor().getName());
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setCategoryDTO(categoryDTO);
			productDTO.setGenderDTO(genderDTO);
			productDTO.setSizeDTO(sizeDTO);
			productDTO.setColorDTO(colorDTO);
			productDTO.setTradeMarkDTO(TrademarkDTO);
			productDTO.setCount(product.getCount());
			productDTO.setPrice(product.getPrice());
			productDTOs.add(productDTO);
			
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getAllProductsbyDM(String dm) {
		List<Product> products = productDAO.getAllProductsbyDM(dm);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();	
		
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			CategoryDTO  categoryDTO = new CategoryDTO();
			categoryDTO.setId(product.getCategory().getId());
			categoryDTO.setName(product.getCategory().getName());
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setId(product.getGender().getId());
			genderDTO.setName(product.getGender().getName());
			TrademarkDTO TrademarkDTO = new TrademarkDTO();
			TrademarkDTO.setId(product.getTrademark().getId());
			TrademarkDTO.setName(product.getTrademark().getName());
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(product.getSize().getId());
			sizeDTO.setName(product.getSize().getName());
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(product.getColor().getId());
			colorDTO.setName(product.getColor().getName());
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setCategoryDTO(categoryDTO);
			productDTO.setGenderDTO(genderDTO);
			productDTO.setSizeDTO(sizeDTO);
			productDTO.setColorDTO(colorDTO);
			productDTO.setTradeMarkDTO(TrademarkDTO);
			productDTO.setCount(product.getCount());
			productDTO.setPrice(product.getPrice());
			productDTOs.add(productDTO);
			
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getAllProductsbyDM(String dm, int id, String tm) {
		List<Product> products = productDAO.getAllProductsbyDM(dm,id,tm);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();	

		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			CategoryDTO  categoryDTO = new CategoryDTO();
			categoryDTO.setId(product.getCategory().getId());
			categoryDTO.setName(product.getCategory().getName());
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setId(product.getGender().getId());
			genderDTO.setName(product.getGender().getName());
			TrademarkDTO TrademarkDTO = new TrademarkDTO();
			TrademarkDTO.setId(product.getTrademark().getId());
			TrademarkDTO.setName(product.getTrademark().getName());
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(product.getSize().getId());
			sizeDTO.setName(product.getSize().getName());
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(product.getColor().getId());
			colorDTO.setName(product.getColor().getName());
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setCategoryDTO(categoryDTO);
			productDTO.setGenderDTO(genderDTO);
			productDTO.setSizeDTO(sizeDTO);
			productDTO.setColorDTO(colorDTO);
			productDTO.setTradeMarkDTO(TrademarkDTO);
			productDTO.setCount(product.getCount());
			productDTO.setPrice(product.getPrice());
			productDTOs.add(productDTO);
			
		}
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getAllProductbySearch(String name) {
		List<Product> products = productDAO.getAllProductbySearch(name);
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();	
		
		for (Product product : products) {
			ProductDTO productDTO = new ProductDTO();
			CategoryDTO  categoryDTO = new CategoryDTO();
			categoryDTO.setId(product.getCategory().getId());
			categoryDTO.setName(product.getCategory().getName());
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setId(product.getGender().getId());
			genderDTO.setName(product.getGender().getName());
			TrademarkDTO TrademarkDTO = new TrademarkDTO();
			TrademarkDTO.setId(product.getTrademark().getId());
			TrademarkDTO.setName(product.getTrademark().getName());
			SizeDTO sizeDTO = new SizeDTO();
			sizeDTO.setId(product.getSize().getId());
			sizeDTO.setName(product.getSize().getName());
			ColorDTO colorDTO = new ColorDTO();
			colorDTO.setId(product.getColor().getId());
			colorDTO.setName(product.getColor().getName());
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setDescription(product.getDescription());
			productDTO.setImage(product.getImage());
			productDTO.setCategoryDTO(categoryDTO);
			productDTO.setGenderDTO(genderDTO);
			productDTO.setSizeDTO(sizeDTO);
			productDTO.setColorDTO(colorDTO);
			productDTO.setTradeMarkDTO(TrademarkDTO);
			productDTO.setCount(product.getCount());
			productDTO.setPrice(product.getPrice());
			productDTOs.add(productDTO);
			
		}
		return productDTOs;
	}

}
