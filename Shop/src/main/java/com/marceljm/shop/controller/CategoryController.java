package com.marceljm.shop.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Category;
import com.marceljm.shop.service.CategoryService;

@Controller
@Scope("session")
public class CategoryController {

	@Inject
	private CategoryService categoryService;

	private List<Category> categoryList;

	@PostConstruct
	public void init() {
		categoryList = categoryService.getCategoryList();
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

}
