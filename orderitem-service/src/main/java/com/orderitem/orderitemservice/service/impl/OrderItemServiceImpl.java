package com.orderitem.orderitemservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.orderitem.orderitemservice.exception.OrderItemNotFoundException;
import com.orderitem.orderitemservice.exception.RequiredParamNotFoundException;
import com.orderitem.orderitemservice.model.OrderItem;
import com.orderitem.orderitemservice.model.DTO.OrderItemDTO;
import com.orderitem.orderitemservice.model.repository.OrderItemRepository;
import com.orderitem.orderitemservice.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	private OrderItemRepository orderRepository;

	public List<OrderItem> listAll() {
		return orderRepository.findAll();
	}

	@Override
	public OrderItem save(OrderItemDTO orderItemDTO) throws RequiredParamNotFoundException {
		OrderItem orderItem = new OrderItem();
		if (StringUtils.isEmpty(orderItemDTO.getProductCode()))
			throw new RequiredParamNotFoundException("Product Code");
		orderItem.setProductCode(orderItemDTO.getProductCode());
		if (StringUtils.isEmpty(orderItemDTO.getProductName()))
			throw new RequiredParamNotFoundException("Product Name");
		orderItem.setProductName(orderItemDTO.getProductName());
		if (orderItemDTO.getQuantity() <= 0)
			throw new RequiredParamNotFoundException("Quantity");
		orderItem.setQuantity(orderItemDTO.getQuantity());
		return orderRepository.save(orderItem);
	}

	@Override
	public OrderItem get(long orderId) throws OrderItemNotFoundException {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderItemNotFoundException(orderId));
	}
}
