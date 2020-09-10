package com.order.orderservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.orderservice.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}
