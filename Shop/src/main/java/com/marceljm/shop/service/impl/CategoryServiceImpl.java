package com.marceljm.shop.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.shop.entity.Category;
import com.marceljm.shop.persistence.CategoryDAO;
import com.marceljm.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> getCategoryList() {
		return categoryDAO.getCategoryList();
	}
}
