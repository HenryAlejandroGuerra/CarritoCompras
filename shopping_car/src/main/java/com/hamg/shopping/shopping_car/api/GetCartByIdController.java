package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.service.CartByIdService;
import com.hamg.shopping.shopping_car.errors.ResourceNotFoundException;

@RestController
public class GetCartByIdController {
	
	@Autowired
	private CartByIdService service;
	
	@RequestMapping( value={"api/v1/allCarts/{cartId}"}, method={RequestMethod.GET} )
	public Carts getProduct(@PathVariable Integer cartId){
		
		Carts cart = service.getCartById(cartId);
		if (Objects.isNull(cart)) {
			throw new ResourceNotFoundException();
		}
		
		return cart;
	}

}
