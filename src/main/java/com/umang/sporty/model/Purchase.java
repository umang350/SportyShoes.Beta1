package com.umang.sporty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Purchase {
	@Id
	@GeneratedValue
	private int purchaseId;
	@Column(nullable = false)
	private int productId;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private int quantity;
	private java.sql.Date purchaseDate;
	
	public Purchase() {
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public java.sql.Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(java.sql.Date purchaseTime) {
		this.purchaseDate = purchaseTime;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", productId=" + productId + ", category=" + category
				+ ", amount=" + amount + ", quantity=" + quantity + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
