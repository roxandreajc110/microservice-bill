package com.hiberus.microservice.bill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.microservice.bill.models.entity.Order;
import com.hiberus.microservice.bill.service.IBillService;
import com.hiberus.microservice.bill.util.ResponseGenerics;

/**
 * Controller REST Bill
 *
 * @author Roxana Andrea Jaramillo Cobos
 */

@RestController
public class BillApiController implements BillApi {

	private IBillService billService;

	@Autowired
	public BillApiController(final IBillService billService) {
		this.billService = billService;
	}

	@Override
	public ResponseGenerics generateBill(Order order) {
		return billService.generateBill(order);
	}
}