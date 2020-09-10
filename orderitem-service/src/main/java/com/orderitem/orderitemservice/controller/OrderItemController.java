package com.orderitem.orderitemservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderitem.orderitemservice.exception.OrderItemNotFoundException;
import com.orderitem.orderitemservice.exception.RequiredParamNotFoundException;
import com.orderitem.orderitemservice.model.OrderItem;
import com.orderitem.orderitemservice.model.DTO.OrderItemDTO;
import com.orderitem.orderitemservice.service.OrderItemService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderItemController {

	private static final Logger logger = LoggerFactory.getLogger(OrderItemController.class);

	@Autowired
	private OrderItemService orderService;

	@ApiOperation(value = "This API is used for fetch All Order Items details")
	@GetMapping("/order")
	public List<OrderItem> getAllOrdersItem() {
		List<OrderItem> listProducts = orderService.listAll();
		return listProducts;
	}

	@ApiOperation(value = "This API is used for Create Order Items")
	@PostMapping("/order")
	public OrderItem createOrderItem(@RequestBody OrderItemDTO orderItem) throws RequiredParamNotFoundException {
		return orderService.save(orderItem);
	}

	@ApiOperation(value = "This API is used for fetch Order Items details by id")
	@GetMapping("/order/{id}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable(value = "id") long orderItemId)
			throws OrderItemNotFoundException, RequiredParamNotFoundException {
		logger.info("getOrderItemById called");
		if (orderItemId == 0)
			throw new RequiredParamNotFoundException("Order Item Id is 0");
		final OrderItem order = orderService.get(orderItemId);
		return ResponseEntity.ok().body(order);
	}

	@ApiOperation(value = "This API is used for check Order Items is Available or not by id")
	@GetMapping("/checkorderitem/{id}")
	public Boolean checkOrderItemById(@PathVariable(value = "id") long orderItemId)
			throws RequiredParamNotFoundException {
		logger.info("checkOrderItemById called");
		if (orderItemId <= 0)
			throw new RequiredParamNotFoundException("Order Item Id is : " + orderItemId);
		try {
			final OrderItem order = orderService.get(orderItemId);
			return (order != null ? Boolean.TRUE : Boolean.FALSE);
		} catch (OrderItemNotFoundException ex) {
			logger.error("OrderItemNotFoundException for orderItem : " + orderItemId);
			return Boolean.FALSE;
		}
	}
	
}
