package com.ingtech.productapi.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ingtech.productapi.model.Product;
import com.ingtech.productapi.repository.ProductRepository;

/**
 * @author fuatozergil
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;


	@Override
	public Product addPruduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public Product findProductByName(String name) {
		return productRepository.findProductByName(name);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProductPrice(Long id, int price) {
		Product product =null;
		try {
			product =  productRepository.getById(id);
			product.setPrice(price);
		} catch (Exception e) {
			LOGGER.error("updateProductPrice exception : " + e);
		}
		return productRepository.save(product);
	}

}
