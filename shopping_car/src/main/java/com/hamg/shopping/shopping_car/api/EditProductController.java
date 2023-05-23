package com.hamg.shopping.shopping_car.api;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.catalogue.Constants;
import com.hamg.shopping.shopping_car.core.service.EditProductService;

@RestController
public class EditProductController {
	
	@Autowired
	private EditProductService service;
	
	@PutMapping( path="api/v1/editProduct", consumes=MediaType.APPLICATION_JSON_VALUE )
	public String editProduct(@RequestBody Products product){

		Products resultEdit = service.editProduct(product);
		
		return (!Objects.isNull(resultEdit)) ? Constants.MSG_THE_RECORD_WITH_ID.concat(resultEdit.getId().toString()).concat(Constants.MSG_SUCCESS_EDIT) : Constants.MSG_NOT_SUCCESS_EDIT;
	}

}
