package com.hamg.shopping.shopping_car.core.service;

import com.hamg.shopping.shopping_car.api.dto.Carts;

public interface CartByIdService {

	public Carts getCartById(Integer cartId);
	
}
