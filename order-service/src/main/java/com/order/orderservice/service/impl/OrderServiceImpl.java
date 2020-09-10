package com.order.orderservice.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.order.orderservice.exception.OrderItemNotFoundException;
import com.order.orderservice.exception.OrderNotFoundException;
import com.order.orderservice.exception.RequiredParamNotFoundException;
import com.order.orderservice.model.Orders;
import com.order.orderservice.model.DTO.OrdersDTO;
import com.order.orderservice.model.repository.OrderRepository;
import com.order.orderservice.service.OrderService;
import com.order.orderservice.service.integration.OrderItemClient;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemClient orderItemClient;

	public List<Orders> listAll() {
		return orderRepository.findAll();
	}

	@Override
	public Orders save(OrdersDTO ordersDTO) throws RequiredParamNotFoundException, OrderItemNotFoundException {
		Orders order = new Orders();

		if (!orderItemClient.getOrderItemStatusById(ordersDTO.getOrderItem()))
			throw new OrderItemNotFoundException(ordersDTO.getOrderItem());
		order.setOrderItem(ordersDTO.getOrderItem());

		if (StringUtils.isEmpty(ordersDTO.getCustomerName()))
			throw new RequiredParamNotFoundException("Customer Name");
		order.setCustomerName(ordersDTO.getCustomerName());

		if (StringUtils.isEmpty(ordersDTO.getShippingAddress()))
			throw new RequiredParamNotFoundException("Shipping Address");
		order.setShippingAddress(ordersDTO.getShippingAddress());

		if (ordersDTO.getTotal() <= 0)
			throw new RequiredParamNotFoundException("Total");
		order.setTotal(ordersDTO.getTotal());

		order.setOrderDate(new Date());
		return orderRepository.save(order);
	}

	@Override
	public Orders get(long orderId) throws OrderNotFoundException {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
	}
}
