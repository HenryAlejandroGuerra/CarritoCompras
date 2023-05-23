package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.EditProductService;

@Service
public class EditProductServiceImpl implements EditProductService {

	@Autowired
	AdapterConsumer consumer;
	
	@Override
	public Products editProduct(Products product) {
		Products result = consumer.editProductAPI(product);
		return result;
	}

}
