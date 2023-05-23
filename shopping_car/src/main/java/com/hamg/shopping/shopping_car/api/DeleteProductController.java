package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.core.service.DeleteProductService;
import com.hamg.shopping.shopping_car.errors.ResourceNotFoundException;

@RestController
public class DeleteProductController {
	
	@Autowired
	private DeleteProductService service;
	
	@RequestMapping( path="api/v1/deleteProduct/{productId}", method={RequestMethod.DELETE} )
	public String deleteProduct(@PathVariable Integer productId){
		
		Boolean resultDelete = service.deleteProduct(productId);
		if (!resultDelete) {
			throw new ResourceNotFoundException();
		}
		
		return (!Objects.isNull(resultDelete)) ? "The record with ID: "+productId+", has been deleted successfully." : "The record has not been deleted correctly";
	}

}
