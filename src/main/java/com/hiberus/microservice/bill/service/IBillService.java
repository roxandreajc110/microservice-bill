package com.hiberus.microservice.bill.service;

import com.hiberus.microservice.bill.models.entity.Order;
import com.hiberus.microservice.bill.util.ResponseGenerics;

/**
 * Interface Service Order
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */

public interface IBillService {

	/**
	 * Generate bill
	 * 
	 * @param Order
	 * @return ResponseGenerics
	 */
	ResponseGenerics generateBill(Order order);

}
