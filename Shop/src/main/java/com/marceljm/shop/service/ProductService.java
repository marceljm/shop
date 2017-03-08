package com.marceljm.shop.service;

import java.util.List;

import com.marceljm.shop.entity.Product;

public interface ProductService {

	List<Product> productList();

	List<String> brandList();

}
