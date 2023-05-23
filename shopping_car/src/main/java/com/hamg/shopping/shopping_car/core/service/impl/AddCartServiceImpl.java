package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.AddCartService;

@Service
public class AddCartServiceImpl implements AddCartService {
	
	@Autowired
	AdapterConsumer consumer;

	@Override
	public Carts addCart(Carts cart) {
		Carts result = consumer.addCartAPI(cart);
		return result;
	}

}
