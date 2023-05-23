package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.core.service.EditProductService;

@RestController
public class EditProductController {
	
	@Autowired
	private EditProductService service;
	
	@PutMapping( path="api/v1/editProduct", consumes=MediaType.APPLICATION_JSON_VALUE )
	public String editProduct(@RequestBody Products product){

		Products resultEdit = service.editProduct(product);
		
		return (!Objects.isNull(resultEdit)) ? "The record with ID: "+resultEdit.getId()+", has been successfully updated." : "Registration was not updated successfully";
	}

}
