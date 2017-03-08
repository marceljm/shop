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

	public List<Category> categoryList(String main) {
		if (main.isEmpty())
			return categoryList;

		Category mainCategory = new Category(main, null);
		int index = categoryList.indexOf(mainCategory);
		return categoryList.get(index).getList();
	}

	public boolean isFirstLevel(String main) {
		return main.isEmpty();
	}
}
