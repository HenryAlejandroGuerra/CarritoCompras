package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.DeleteProductService;

@Service
public class DeleteProductServiceImpl implements DeleteProductService {

	@Autowired
	AdapterConsumer consumer;
	
	@Override
	public Boolean deleteProduct(Integer productId) {
		Boolean result = consumer.deleteProductAPI(productId);
		return result;
	}

}
