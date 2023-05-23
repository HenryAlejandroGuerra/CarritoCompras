package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.service.ProductByIdService;
import com.hamg.shopping.shopping_car.errors.ResourceNotFoundException;

@RestController
public class GetProductByIdController {

	@Autowired
	private ProductByIdService service;
	
	@RequestMapping( value={"api/v1/allProducts/{productId}"}, method={RequestMethod.GET} )
	public Products getProduct(@PathVariable Integer productId){
		
		Products product = service.getProductById(productId);
		if (Objects.isNull(product)) {
			throw new ResourceNotFoundException();
		}
		
		return product;
	}
	
}
