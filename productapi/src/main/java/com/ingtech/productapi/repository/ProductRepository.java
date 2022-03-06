package com.ingtech.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ingtech.productapi.model.Product;

/**
 * @author fuatozergil
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT p FROM Product p where p.name like ?1")
	Product findProductByName(String name);

}
