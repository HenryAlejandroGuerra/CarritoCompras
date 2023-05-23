package com.hamg.shopping.shopping_car.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.service.AllProductsService;

@RestController
public class GetProductController {
	
	@Autowired
	private AllProductsService service;
	
	@RequestMapping( value={"api/v1/allProducts"}, method={RequestMethod.GET} )
	public List<Products> getAllProducts(){
		List<Products> listProducts = service.getProducts();
		return listProducts;
	}
	
}
