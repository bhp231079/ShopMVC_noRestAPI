package com.doanwww.shop.service;

import java.util.List;

import com.doanwww.shop.entity.Product;
import com.doanwww.shop.model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO product);

	public void updateProduct(ProductDTO product);

	public void deleteProduct(ProductDTO product);

	public ProductDTO getbyID(int id);

	public List<ProductDTO> getAllProduct();
	
	public List<ProductDTO> getAllProductsbyDM(String dm);
	
	public List<ProductDTO> getAllProductsbyDM(String dm,int id, String tm);
	
	public List<ProductDTO> getAllProductbySearch(String name);
}
