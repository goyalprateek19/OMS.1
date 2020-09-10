package com.orderitem.orderitemservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {

	private long id;
	private String productCode;
	private String productName;
	private int quantity;

	public OrderItem() {
	}
	
	public OrderItem(String productCode, String productName, int quantity) {
		this.productCode = productCode;
		this.productName = productName;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	@Column(name = "product_code", nullable = false)
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Column(name = "product_name", nullable = false)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setId(long id) {
		this.id = id;
	}

}
