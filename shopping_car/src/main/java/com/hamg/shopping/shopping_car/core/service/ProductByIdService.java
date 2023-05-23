package com.hamg.shopping.shopping_car.core.service;

import com.hamg.shopping.shopping_car.api.dto.Products;

public interface ProductByIdService {

	public Products getProductById(Integer productId);
	
}
