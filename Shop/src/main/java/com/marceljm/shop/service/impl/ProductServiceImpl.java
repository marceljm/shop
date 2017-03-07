package com.marceljm.shop.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.persistence.impl.ProductDAOImpl;
import com.marceljm.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDAOImpl productDAO;

	@Override
	public List<Product> productList() {
		return productDAO.productList();
	}

}
