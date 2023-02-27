package com.doanwww.shop.dao;

import java.util.List;

import com.doanwww.shop.entity.Category;

public interface CategoryDAO {
	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

	public Category getbyID(int  id);

	public List<Category> getAllCategory();
}
