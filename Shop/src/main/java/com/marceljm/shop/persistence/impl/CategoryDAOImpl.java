package com.marceljm.shop.persistence.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.marceljm.shop.entity.Category;
import com.marceljm.shop.persistence.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private String FILE = "C:\\CSV\\categoryMap.csv";

	private List<Category> categoryList;

	@PostConstruct
	private void init() {
		categoryList = categoryList();
	}

	private List<Category> categoryList() {
		categoryList = new ArrayList<Category>();
		try {
			String line;
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF8"));
			while ((line = bf.readLine()) != null) {
				String field[] = line.split(";")[0].split(" / ");
				if (field.length > 0) {
					Category category1 = new Category(field[0], new ArrayList<Category>());
					if (categoryList.indexOf(category1) < 0)
						categoryList.add(category1);
					if (field.length > 1) {
						Category category2 = new Category(field[1], new ArrayList<Category>());
						int index1 = categoryList.indexOf(category1);
						if (categoryList.get(index1).getList().indexOf(category2) < 0)
							categoryList.get(index1).getList().add(category2);
						if (field.length > 2) {
							Category category3 = new Category(field[2], new ArrayList<Category>());
							int index2 = categoryList.get(index1).getList().indexOf(category2);
							if (categoryList.get(index1).getList().get(index2).getList().indexOf(category3) < 0)
								categoryList.get(index1).getList().get(index2).getList().add(category3);
						}
					}
				}
			}
			bf.close();
			return categoryList;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryList;
	}

}
