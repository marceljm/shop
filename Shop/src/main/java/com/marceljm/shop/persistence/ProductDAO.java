package com.marceljm.shop.persistence;

import java.util.List;

import com.marceljm.shop.entity.Product;

public interface ProductDAO {

	List<Product> productList();

	List<String> brandList();

}
