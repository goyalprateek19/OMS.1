package com.order.orderservice.model.DTO;

public class OrdersDTO {

	private String customerName;
	private String shippingAddress;
	private long orderItem;
	private int total;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public long getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(long orderItem) {
		this.orderItem = orderItem;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
