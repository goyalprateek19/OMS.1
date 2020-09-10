package com.orderitem.orderitemservice.service;

import java.util.List;

import com.orderitem.orderitemservice.exception.OrderItemNotFoundException;
import com.orderitem.orderitemservice.exception.RequiredParamNotFoundException;
import com.orderitem.orderitemservice.model.OrderItem;
import com.orderitem.orderitemservice.model.DTO.OrderItemDTO;


public interface OrderItemService {

	public List<OrderItem> listAll() ;

	public OrderItem save(OrderItemDTO orderItemDTO) throws RequiredParamNotFoundException;

	public OrderItem get(long orderId) throws OrderItemNotFoundException;
}
