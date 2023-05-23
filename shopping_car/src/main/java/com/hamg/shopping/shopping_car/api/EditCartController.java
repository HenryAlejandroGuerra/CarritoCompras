package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.service.EditCartService;

@RestController
public class EditCartController {
	
	@Autowired
	private EditCartService service;
	
	@PutMapping( path="api/v1/editCart", consumes=MediaType.APPLICATION_JSON_VALUE )
	public String editCart(@RequestBody Carts cart){

		Carts resultEdit = service.editCarts(cart);
		
		return (!Objects.isNull(resultEdit)) ? "The record with ID: "+resultEdit.getId()+", has been successfully updated." : "Registration was not updated successfully";
	}

}
