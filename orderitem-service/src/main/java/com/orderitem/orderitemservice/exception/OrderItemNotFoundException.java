package com.orderitem.orderitemservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Order Item Not Found")
public class OrderItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OrderItemNotFoundException(long id){
		super("OrderItemNotFoundException with id =" + id);
	}
}
