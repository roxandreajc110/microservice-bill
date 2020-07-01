package com.hiberus.microservice.bill.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.hiberus.microservice.bill.models.entity.Order;

/**
 * Interface DAO extends of CrudRepository
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

public interface OrderRepository extends CrudRepository<Order, Long> {
	
}