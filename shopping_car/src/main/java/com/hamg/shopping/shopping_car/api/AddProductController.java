package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.catalogue.Constants;
import com.hamg.shopping.shopping_car.core.service.AddProductService;

@RestController
public class AddProductController {
	
	@Autowired
	private AddProductService service;
	
	@PostMapping( path="api/v1/addProduct", consumes=MediaType.APPLICATION_JSON_VALUE )
	public String addProduct(@RequestBody Products product){

		Products resultAdd = service.addProduct(product);
		
		return (!Objects.isNull(resultAdd)) ? Constants.MSG_SUCCESS_ADDED : Constants.MSG_NOT_SUCCESS_ADDED;
	}

}
