package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.EditCartService;

@Service
public class EditCartServiceImpl implements EditCartService {
	
	@Autowired
	AdapterConsumer consumer;

	@Override
	public Carts editCarts(Carts cart) {
		Carts result = consumer.editCartAPI(cart);
		return result;
	}

}
