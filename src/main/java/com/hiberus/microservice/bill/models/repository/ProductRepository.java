package com.hiberus.microservice.bill.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.hiberus.microservice.bill.models.entity.Product;

/**
 * Interface DAO extends of CrudRepository
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

public interface ProductRepository extends CrudRepository<Product, Long> {
	
}