package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.AddProductService;

@Service
public class AddProductServiceImpl implements AddProductService {

	@Autowired
	AdapterConsumer consumer;
	
	@Override
	public Products addProduct(Products product) {
		Products result = consumer.addProductAPI(product);
		return result;
	}

}
