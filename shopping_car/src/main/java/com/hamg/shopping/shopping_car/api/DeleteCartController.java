package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.catalogue.Constants;
import com.hamg.shopping.shopping_car.core.service.DeleteCartService;
import com.hamg.shopping.shopping_car.errors.ResourceNotFoundException;

@RestController
public class DeleteCartController {
	
	@Autowired
	private DeleteCartService service;
	
	@RequestMapping( path="api/v1/deleteCart/{cartId}", method={RequestMethod.DELETE} )
	public String deleteCart(@PathVariable Integer cartId){
		
		Boolean resultDelete = service.deleteCart(cartId);
		if (!resultDelete) {
			throw new ResourceNotFoundException();
		}
		
		return (!Objects.isNull(resultDelete)) ? Constants.MSG_THE_RECORD_WITH_ID.concat(cartId.toString()).concat(Constants.MSG_SUCCESS_DELETE) : Constants.MSG_NOT_SUCCESS_DELETE;
	}

}
