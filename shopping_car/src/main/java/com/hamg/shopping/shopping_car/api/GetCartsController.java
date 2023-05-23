package com.hamg.shopping.shopping_car.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.service.AllCartsService;

@RestController
public class GetCartsController {
	
	@Autowired
	private AllCartsService service;
	
	@RequestMapping( value={"api/v1/allCarts"}, method={RequestMethod.GET} )
	public List<Carts> getAllCarts(){
		List<Carts> listCarts = service.getCarts();
		return listCarts;
	}

}
