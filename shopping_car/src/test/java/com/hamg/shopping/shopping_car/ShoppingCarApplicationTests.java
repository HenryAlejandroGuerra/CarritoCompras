package com.hamg.shopping.shopping_car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hamg.shopping.shopping_car.api.dto.Products;
import com.google.gson.Gson;
import com.hamg.shopping.shopping_car.api.dto.Carts;
import com.hamg.shopping.shopping_car.core.service.AddCartService;
import com.hamg.shopping.shopping_car.core.service.AddProductService;
import com.hamg.shopping.shopping_car.core.service.AllCartsService;
import com.hamg.shopping.shopping_car.core.service.AllProductsService;
import com.hamg.shopping.shopping_car.core.service.CartByIdService;
import com.hamg.shopping.shopping_car.core.service.DeleteCartService;
import com.hamg.shopping.shopping_car.core.service.DeleteProductService;
import com.hamg.shopping.shopping_car.core.service.EditCartService;
import com.hamg.shopping.shopping_car.core.service.EditProductService;
import com.hamg.shopping.shopping_car.core.service.ProductByIdService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ShoppingCarApplicationTests {

	@Autowired
	private AllProductsService allProducts;
	@Autowired
	private ProductByIdService productById;
	@Autowired
	private AddProductService addProduct;
	@Autowired
	private EditProductService editProduct;
	@Autowired
	private DeleteProductService deleteProduct;
	
	@Autowired
	private AllCartsService allCarts;
	@Autowired
	private CartByIdService cartById;
	@Autowired
	private AddCartService addCart;
	@Autowired
	private EditCartService editCart;
	@Autowired
	private DeleteCartService deleteCart;
	
	Integer idProductTest = 1;
	Integer idCartTest = 1;
	
	@Test
	void getAllProducts() {
		assertThatCode(()->allProducts.getProducts()).doesNotThrowAnyException();
		List<Products> listProducts = allProducts.getProducts();
		assertThat(listProducts).isNotNull();
		assert listProducts.size() > 0;
		log.info(listProducts.toString());
	}
	
	@Test
	void getProductById() {
		assertThatCode(()->productById.getProductById(idProductTest)).doesNotThrowAnyException();
		Products product = productById.getProductById(idProductTest);
		assertThat(product).isNotNull();
		assert !Objects.isNull(product.getId());
		log.info(product.toString());
	}
	
	@Test
	void addProducts() {
		String bodyRequest = "{\"title\":\"test product\",\"price\": 13.5,\"description\":\"lorem ipsum set\",\"image\":\"https://i.pravatar.cc\",\"acategory\":\"electronic\"}";
		Products product = new Gson().fromJson(bodyRequest, Products.class);
		assertThatCode(()->addProduct.addProduct(product)).doesNotThrowAnyException();
		Products resultProduct = addProduct.addProduct(product);
		assertThat(resultProduct).isNotNull();
		assert !Objects.isNull(resultProduct.getId());
		log.info(resultProduct.toString());
	}
	
	@Test
	void editProduct() {
		String bodyRequest = "{\"id\": 7,\"title\":\"test product\",\"price\": 13.5,\"description\":\"lorem ipsum set\",\"image\":\"https://i.pravatar.cc\",\"acategory\":\"electronic\"}";
		Products product = new Gson().fromJson(bodyRequest, Products.class);
		assertThatCode(()->editProduct.editProduct(product)).doesNotThrowAnyException();
		Products resultProduct = editProduct.editProduct(product);
		assertThat(resultProduct).isNotNull();
		assert !Objects.isNull(resultProduct.getId());
		log.info(resultProduct.toString());
	}
	
	@Test
	void deleteProduct() {
		assertThatCode(()->deleteProduct.deleteProduct(idProductTest)).doesNotThrowAnyException();
		Boolean resultDelete = deleteProduct.deleteProduct(idProductTest);
		assert resultDelete;
		log.info("Result Delete ".concat(resultDelete.toString()));
	}
	
	@Test
	void getAllCarts() {
		assertThatCode(()->allCarts.getCarts()).doesNotThrowAnyException();
		List<Carts> listCarts = allCarts.getCarts();
		assertThat(listCarts).isNotNull();
		
		assert listCarts.size() > 0;
		log.info(listCarts.toString());
	}
	
	@Test
	void getCartById() {
		Integer cartId = 1;
		assertThatCode(()->cartById.getCartById(cartId)).doesNotThrowAnyException();
		Carts cart = cartById.getCartById(cartId);
		assertThat(cart).isNotNull();
		
		assert cart.getId() != 0;
		log.info(cart.toString());
	}
	
	@Test
	void addCarts() {
		String bodyRequest = "{\"userId\": 5,\"date\": \"2020-02-03\",\"products\":[{\"productId\":5,\"quantity\":1},{\"productId\":1,\"quantity\":5}]}";
		Carts cart = new Gson().fromJson(bodyRequest, Carts.class);
		assertThatCode(()->addCart.addCart(cart)).doesNotThrowAnyException();
		Carts resultCart = addCart.addCart(cart);
		assertThat(resultCart).isNotNull();
		assert !Objects.isNull(resultCart.getId());
		log.info(resultCart.toString());
	}
	
	@Test
	void editCart() {
		String bodyRequest = "{\"id\": 7,\"userId\": 3,\"date\": \"2019-12-10\",\"products\":[{\"productId\":1,\"quantity\":3}]}";
		Carts cart = new Gson().fromJson(bodyRequest, Carts.class);
		assertThatCode(()->editCart.editCarts(cart)).doesNotThrowAnyException();
		Carts resultCart = editCart.editCarts(cart);
		assertThat(resultCart).isNotNull();
		assert !Objects.isNull(resultCart.getId());
		log.info(resultCart.toString());
	}
	
	@Test
	void deleteCart() {
		assertThatCode(()->deleteCart.deleteCart(idCartTest)).doesNotThrowAnyException();
		Boolean resultDelete = deleteCart.deleteCart(idCartTest);
		assert resultDelete;
		log.info("Result Delete ".concat(resultDelete.toString()));
	}

}
