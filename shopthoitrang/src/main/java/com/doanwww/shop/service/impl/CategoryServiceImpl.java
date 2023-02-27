package com.doanwww.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doanwww.shop.dao.CategoryDAO;
import com.doanwww.shop.entity.Category;
import com.doanwww.shop.model.CategoryDTO;
import com.doanwww.shop.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDAO;
	@Override
	public void addCategory(CategoryDTO categorydto) {
		Category category = new Category();
		category.setName(categorydto.getName());
		categoryDAO.addCategory(category);
	}

	@Override
	public void updateCategory(CategoryDTO categorydto) {
		Category category = categoryDAO.getbyID(categorydto.getId());
		if (category!=null) {
			category.setName(categorydto.getName());
		}
		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(CategoryDTO categorydto) {
		Category category = categoryDAO.getbyID(categorydto.getId());
		if (category!=null) {
			categoryDAO.deleteCategory(category);
		}
		
	}

	@Override
	public CategoryDTO getbyID(int id) {
		Category category = categoryDAO.getbyID(id);
		CategoryDTO dto = new CategoryDTO();
			dto.setId(category.getId());
			dto.setName(category.getName());
		return  dto;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryDAO.getAllCategory();
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		for (Category category : categories ) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setName(category.getName());
			dtos.add(categoryDTO);
		}
		return dtos;
	}

}
