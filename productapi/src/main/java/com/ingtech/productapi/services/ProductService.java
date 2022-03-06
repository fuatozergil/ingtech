package com.ingtech.productapi.services;

import java.util.List;

import com.ingtech.productapi.model.Product;

/**
 * @author fuatozergil
 *
 */
public interface ProductService {


	/**
	 * @param product
	 * @return
	 */
	Product addPruduct(Product product);

	/**
	 * @param id
	 * @return
	 */
	Product getProductById(Long id);
	
	/**
	 * @param name
	 * @return
	 */
	Product findProductByName(String name);


	/**
	 * @return
	 */
	List<Product> getAllProducts();


	
	/**
	 * @param Product
	 * @param price
	 * @return
	 */
	Product updateProductPrice(Long id, int price);
}
