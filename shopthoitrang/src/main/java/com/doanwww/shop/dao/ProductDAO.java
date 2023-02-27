package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Product;

public interface ProductDAO {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public Product getbyID(int id);

	public List<Product> getAllProduct();
	
	public List<Product> getAllProductsbyDM(String dm);
	
	public List<Product> getAllProductsbyDM(String dm,int id, String tm);
	
	public List<Product> getAllProductbySearch(String name);
	
}
