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

	public List<Category> categoryList(String main, String sub, String third) {
		if (main.isEmpty())
			return categoryList;

		Category mainCategory = new Category(main, null);
		int index1 = categoryList.indexOf(mainCategory);

		if (sub.isEmpty())
			return categoryList.get(index1).getList();

		Category subCategory = new Category(sub, null);
		int index2 = categoryList.get(index1).getList().indexOf(subCategory);

		if (third.isEmpty())
			return categoryList.get(index1).getList().get(index2).getList();

		Category thirdCategory = new Category(third, null);
		int index3 = categoryList.get(index1).getList().get(index2).getList().indexOf(thirdCategory);
		return categoryList.get(index1).getList().get(index2).getList().get(index3).getList();
	}

	public boolean isFirstLevel(String main) {
		return main.isEmpty();
	}

}
