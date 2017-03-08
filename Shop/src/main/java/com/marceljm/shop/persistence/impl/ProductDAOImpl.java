package com.marceljm.shop.persistence.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	private String FILE = "C:\\CSV\\shop.csv";

	private Set<String> brandSet = new HashSet<String>();

	@Override
	public List<Product> productList() {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(FILE), "UTF8"));
			String line;
			List<Product> productList = new ArrayList<Product>();
			while ((line = bf.readLine()) != null) {
				productList.add(new Product(line));
				brandSet.add(line.split(";")[4]);
			}
			bf.close();
			return productList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<String> brandList() {
		List<String> brandList = new ArrayList<String>(brandSet);
		Collections.sort(brandList);
		return brandList;
	}

}
