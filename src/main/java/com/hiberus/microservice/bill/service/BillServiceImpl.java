package com.hiberus.microservice.bill.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hiberus.microservice.bill.models.entity.Order;
import com.hiberus.microservice.bill.models.entity.OrderDetail;
import com.hiberus.microservice.bill.models.entity.Product;
import com.hiberus.microservice.bill.models.repository.OrderRepository;
import com.hiberus.microservice.bill.models.repository.ProductRepository;
import com.hiberus.microservice.bill.util.ResponseGenerics;

/**
 * Interface Implementation Bill
 * 
 * @author Roxana Andrea Jaramillo Cobos
 * @version 0.0.1
 */
@Service
public class BillServiceImpl implements IBillService {

	protected Logger logger = LogManager.getLogger(BillServiceImpl.class);
	private final ProductRepository productRepository;
	private final OrderRepository orderRepository;

	@Autowired
	public BillServiceImpl(ProductRepository productRepository, OrderRepository orderRepository) {
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
	}

	@Override
	public ResponseGenerics generateBill(Order order) {
		Long total = new Long(0);
		Long subtotal = new Long(0);
		Map<String, Object> data = new HashMap<>();
		List<OrderDetail> listOrdersDetails = order.getListOrdersDetails();
		try {
			for (OrderDetail orderDetail : listOrdersDetails) {
				Optional<Product> product = productRepository.findById(orderDetail.getProductId());
				if (product.isPresent()) {
					/* Calculate subtotals by product and invoice total*/
					subtotal = product.get().getPrice() * orderDetail.getQuantity();
					orderDetail.setTotal(subtotal);
					total += subtotal;
				} else {
					orderDetail.setTotal(null);
				}
			}
			order.setTotal(total);
			order.setCreationDate(new Date());
			/* If the product was not found, it is removed from the purchase order */
			listOrdersDetails = listOrdersDetails.stream().filter(o -> o.getTotal() != null)
					.collect(Collectors.toList());

			if (listOrdersDetails.size() > 0) {
				order.setListOrdersDetails(listOrdersDetails);
				/* Returns generated order id */
				Order result = orderRepository.save(order);
				data.put("idOrder", result.getId());
			} else {
				return new ResponseGenerics(HttpStatus.CONFLICT.toString(), "The order has non-existent products",
						null);
			}
		} catch (Exception ex) {
			logger.error("ERROR: " + Thread.currentThread().getStackTrace()[1].getMethodName() + ex.getMessage());
			return new ResponseGenerics(HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					"The operation could not be completed, contact your administrator", null);

		}
		return new ResponseGenerics(HttpStatus.OK.toString(), "The order was successfully created and invoiced", data);

	}
}
