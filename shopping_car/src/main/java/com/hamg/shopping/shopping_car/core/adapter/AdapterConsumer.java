package com.hamg.shopping.shopping_car.core.adapter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.api.dto.Products;
import com.hamg.shopping.shopping_car.catalogue.Constants;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AdapterConsumer {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Products> getAllProductsAPI() {
		
		Products[] p = restTemplate.getForObject(Constants.URL_API_PRODUCTS, Products[].class);
		List<Products> listProducts = Arrays.asList(p);
		log.info(listProducts.toString());
		
		return listProducts;
	}
	
	public Products getProductByIdAPI(Integer productId) {
		
		Products p = null;
		
		try {
			p = restTemplate.getForObject(Constants.URL_API_PRODUCTS.concat(productId.toString()), Products.class);
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return p;
	}
	
	public Products addProductAPI(Products product) {
		Products p = restTemplate.postForObject(Constants.URL_API_PRODUCTS, product, Products.class);
		return p;
	}
	
	public Products editProductAPI(Products product) {
		
		Products resultConsumer = null;;
		try {
			restTemplate.put(Constants.URL_API_PRODUCTS.concat(product.getId().toString()), product);
			resultConsumer = product;
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return resultConsumer;
	}
	
	public Boolean deleteProductAPI(Integer productId) {
		
		Boolean resultConsumer = false;;
		try {
			restTemplate.delete(Constants.URL_API_PRODUCTS.concat(productId.toString()));
			resultConsumer = true;
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return resultConsumer;
	}
	
	public List<Carts> getAllCartsAPI() {
		
		Carts[] c = restTemplate.getForObject(Constants.URL_API_CARTS, Carts[].class);
		List<Carts> listCarts = Arrays.asList(c);
		log.info(listCarts.toString());
		
		return listCarts;
	}
	
	public Carts getCartByIdAPI(Integer cartId) {
		
		Carts c = null;
		
		try {
			c = restTemplate.getForObject(Constants.URL_API_CARTS.concat(cartId.toString()), Carts.class);
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return c;
	}
	
	public Carts addCartAPI(Carts cart) {
		Carts c = restTemplate.postForObject(Constants.URL_API_CARTS, cart, Carts.class);
		return c;
	}
	
	public Carts editCartAPI(Carts cart) {
		
		Carts resultConsumer = null;;
		try {
			restTemplate.put(Constants.URL_API_CARTS.concat(cart.getId().toString()), cart);
			resultConsumer = cart;
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return resultConsumer;
	}
	
	public Boolean deleteCartAPI(Integer cartId) {
		
		Boolean resultConsumer = false;;
		try {
			restTemplate.delete(Constants.URL_API_CARTS.concat(cartId.toString()));
			resultConsumer = true;
		} catch (Exception e) {
			log.error(e.toString());
		}
		
		return resultConsumer;
	}
	
}
