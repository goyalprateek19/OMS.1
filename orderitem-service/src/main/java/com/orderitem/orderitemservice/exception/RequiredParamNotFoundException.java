package com.orderitem.orderitemservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Required Param Not Found")
public class RequiredParamNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RequiredParamNotFoundException(String str){
		super("RequiredParamNotFoundException with field =" + str);
	}

}
