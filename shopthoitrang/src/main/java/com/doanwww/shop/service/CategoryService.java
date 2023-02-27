package com.doanwww.shop.service;
import java.util.List;

import com.doanwww.shop.model.CategoryDTO;



public interface CategoryService {
	public void addCategory(CategoryDTO Category);

	public void updateCategory(CategoryDTO  Category);

	public void deleteCategory(CategoryDTO  Category);

	public CategoryDTO getbyID(int  id);

	public List<CategoryDTO> getAllCategory();
}
