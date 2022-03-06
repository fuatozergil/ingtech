package com.ingtech.productapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingtech.productapi.model.Product;
import com.ingtech.productapi.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author fuatozergil
 *
 */
@RestController
@RequestMapping("/product")
@Api(tags = "Product Crud")
public class ProductController {

	// TODO Implement basic functions, for example: add-product, find-product,
	// change-price or others

	@Autowired
	ProductService productService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addProduct")
	@ApiOperation(value = "Adds Product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product,
			SecurityContextHolderAwareRequestWrapper requestWrapper) {

		return ResponseEntity.ok(productService.addPruduct(product));
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/findProduct")
	@ApiOperation(value = "Finds Product with parametersS")
	public ResponseEntity<Product> findProduct(@RequestParam String productName) {
		return ResponseEntity.ok(productService.findProductByName(productName));
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllProducts")
	@ApiOperation(value = "Get All Products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/changeProductPrice/{productId}/{price}")
	@ApiOperation(value = "Changes  Product s Price")
	public ResponseEntity<Product> changeProductPrice(@PathVariable(value = "productId") Long productId,
			@PathVariable(value = "price") int price) {
		return ResponseEntity.ok(productService.updateProductPrice(productId, price));
	}

}
