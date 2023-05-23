package com.hamg.shopping.shopping_car.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.adapter.AdapterConsumer;
import com.hamg.shopping.shopping_car.core.service.AllCartsService;

@Service
public class AllCartsServiceImpl implements AllCartsService {
	
	@Autowired
	AdapterConsumer consumer;

	@Override
	public List<Carts> getCarts() {
		List<Carts> listCarts = consumer.getAllCartsAPI();
		return listCarts;
	}

}
