package com.order.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Order Not Found")
public class OrderNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(long id){
		super("OrderNotFoundException with id =" + id);
	}

}
