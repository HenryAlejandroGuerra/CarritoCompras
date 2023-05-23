package com.hamg.shopping.shopping_car.api.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Carts {
	
	private Integer id;
    private Integer userId;
    private Date date;
    private List<ProductsByCarts> products;

}
