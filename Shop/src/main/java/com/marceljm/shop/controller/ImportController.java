package com.marceljm.shop.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.shop.entity.Product;
import com.marceljm.shop.service.impl.ProductServiceImpl;

@Controller
@Scope("singleton")
public class ImportController {

	@Inject
	private ProductServiceImpl productService;

	private List<Product> productList;

	@PostConstruct
	public void init() {
		setProductList(productService.productList());
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
