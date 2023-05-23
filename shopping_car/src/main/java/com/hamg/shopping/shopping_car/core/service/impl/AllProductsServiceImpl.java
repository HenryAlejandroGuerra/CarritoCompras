package com.hamg.shopping.shopping_car.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.AllProductsService;

@Service
public class AllProductsServiceImpl implements AllProductsService {

	@Autowired
	AdapterConsumer consumer;
	
	@Override
	public List<Products> getProducts() {
		List<Products> listProducts = consumer.getAllProductsAPI();
		return listProducts;
	}

}
