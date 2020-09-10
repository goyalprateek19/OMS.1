package com.order.orderservice.service;

import java.util.List;

import com.order.orderservice.exception.OrderItemNotFoundException;
import com.order.orderservice.exception.OrderNotFoundException;
import com.order.orderservice.exception.RequiredParamNotFoundException;
import com.order.orderservice.model.Orders;
import com.order.orderservice.model.DTO.OrdersDTO;


public interface OrderService {

	public List<Orders> listAll();

	public Orders save(OrdersDTO ordersDTO) throws RequiredParamNotFoundException, OrderItemNotFoundException ;

	public Orders get(long orderId) throws OrderNotFoundException;
}
