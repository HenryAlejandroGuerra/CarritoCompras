package com.hamg.shopping.shopping_car.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.CartByIdService;

@Service
public class CartByIdServiceImpl implements CartByIdService {
	
	@Autowired
	AdapterConsumer consumer;

	@Override
	public Carts getCartById(Integer cartId) {
		Carts cart = consumer.getCartByIdAPI(cartId);
		return cart;
	}

}
