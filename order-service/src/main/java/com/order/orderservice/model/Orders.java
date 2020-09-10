package com.order.orderservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	private long id;
	private String customerName;
	private Date OrderDate;
	private String shippingAddress;
	private long orderItem;
	private int total;

	public Orders() {
	}

	public Orders(String customerName, Date orderDate, String shippingAddress, long orderItem, int total) {
		super();
		this.customerName = customerName;
		OrderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.orderItem = orderItem;
		this.total = total;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "customer_name", nullable = false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "order_date", nullable = false)
	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	@Column(name = "shipping_address", nullable = false)
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "order_item", nullable = false)
	public long getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(long orderItem) {
		this.orderItem = orderItem;
	}

	@Column(name = "total", nullable = false)
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setId(long id) {
		this.id = id;
	}
}
