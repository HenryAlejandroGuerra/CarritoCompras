package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.ProductByIdService;

@Service
public class ProductByIdServiceImpl implements ProductByIdService {

	@Autowired
	AdapterConsumer consumer;
	
	@Override
	public Products getProductById(Integer productId) {
		Products product = consumer.getProductByIdAPI(productId);
		return product;
	}

}
