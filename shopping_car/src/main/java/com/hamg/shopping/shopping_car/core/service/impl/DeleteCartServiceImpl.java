package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.DeleteCartService;

@Service
public class DeleteCartServiceImpl implements DeleteCartService{
	
	@Autowired
	AdapterConsumer consumer;

	@Override
	public Boolean deleteCart(Integer cartId) {
		Boolean result = consumer.deleteCartAPI(cartId);
		return result;
	}

}
