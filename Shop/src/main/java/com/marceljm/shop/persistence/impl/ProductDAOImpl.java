package com.marceljm.shop.persistence.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private String FILE = "C:\\CSV\\shop.csv";

	@Override
	public List<Product> productList() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(FILE));
			String line;
			List<Product> productList = new ArrayList<Product>();
			while ((line = bf.readLine()) != null)
				productList.add(new Product(line));
			bf.close();
			return productList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
