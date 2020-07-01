package com.hiberus.microservice.bill.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiberus.microservice.bill.models.entity.Order;
import com.hiberus.microservice.bill.util.ResponseGenerics;

import io.swagger.annotations.ApiOperation;

/**
 * Enpoint REST Bill
 *
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@CrossOrigin("*")
@RequestMapping("/bill")
public interface BillApi {

	/**
	 * Generate bill
	 * 
	 * @param Order
	 * @return ResponseGenerics
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generate", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Generate bill", notes = "Generate bill")
	ResponseGenerics generateBill(@RequestBody Order order);

}