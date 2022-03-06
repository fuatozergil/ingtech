package com.ingtech.productapi.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ingtech.productapi.model.Product;
import com.ingtech.productapi.services.ProductService;

/**
 * @author fuatozergil
 *
 */
@SpringBootTest
class TestAdvertServiceImpl {


	@Autowired
	ProductService productService;

	@Test
	void testAddProduct() {

		Product product = new Product();

		product.setActive(1);
		product.setContent("bulb");
		product.setName("bulb");
		product.setPrice(1);
		product.setUpdater(1);
		product.setVersion(1);

		assertNotNull(productService.addPruduct(product));
	}

	@Test
	void testGetAdvertById() {
		assertNotNull(productService.getProductById(1L));
	}

	@Test
	void testGetAllAdvert() {
		assertNotNull(productService.getAllProducts());
	}

	@Test
	void testUpdateAdvertStatus() {
		assertNotNull(productService.updateProductPrice(1L, 10));
	}

}
