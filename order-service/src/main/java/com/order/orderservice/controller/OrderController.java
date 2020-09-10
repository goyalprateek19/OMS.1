package com.order.orderservice.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.order.orderservice.exception.OrderItemNotFoundException;
import com.order.orderservice.exception.OrderNotFoundException;
import com.order.orderservice.exception.RequiredParamNotFoundException;
import com.order.orderservice.model.Orders;
import com.order.orderservice.model.DTO.OrdersDTO;
import com.order.orderservice.service.OrderService;

import feign.Response;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
    private OrderService orderService;

	@ApiOperation(value = "This is API is used for fetch Orders details",response = Response.class)
	@GetMapping("/orders")
	public List <Orders> getAllOrders() {
	    List<Orders> listProducts = orderService.listAll();
	    return listProducts;
	}
	
	@ApiOperation(value = "This is API is used for Create Order",response = Response.class)
	@PostMapping("/order")
    public Orders createOrder(@Valid @RequestBody OrdersDTO orderItem) throws RequiredParamNotFoundException, OrderItemNotFoundException {
        return orderService.save(orderItem);
    }
	
	@ApiOperation(value = "This is API is used for fetch Orders details By Order Id",response = Response.class)
	@GetMapping("/order/{id}")
    public ResponseEntity <Orders> getOrderById(@PathVariable(value = "id") Long orderId)
    throws OrderNotFoundException {
		logger.info("getOrderItemById called");
		final Orders order = orderService.get(orderId);
        return ResponseEntity.ok().body(order);
    }

}
