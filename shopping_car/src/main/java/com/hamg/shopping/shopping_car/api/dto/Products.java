package com.hamg.shopping.shopping_car.api.dto;

import lombok.Data;

@Data
public class Products {

	private Integer id;
	private String title;
	private Double price;
	private String category;
	private String description;
	private String image;
	private Rating rating;
	
}
