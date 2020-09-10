package com.order.orderservice.service.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "orderitemservice")
public interface OrderItemClient {

	@GetMapping(value= "/order/checkorderitem/{id}")
    public Boolean getOrderItemStatusById(@PathVariable(value = "id") long orderItemId);
}
