package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.catalogue.Constants;
import com.hamg.shopping.shopping_car.core.service.AddCartService;

@RestController
public class AddCartController {
	
	@Autowired
	private AddCartService service;
	
	@PostMapping( path="api/v1/addCart", consumes=MediaType.APPLICATION_JSON_VALUE )
	public String addProduct(@RequestBody Carts cart){

		Carts resultAdd = service.addCart(cart);
		
		return (!Objects.isNull(resultAdd)) ? Constants.MSG_SUCCESS_ADDED : Constants.MSG_NOT_SUCCESS_ADDED;
	}

}
