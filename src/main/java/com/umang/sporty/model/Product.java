package com.umang.sporty.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
//@NamedQuery(name = "Product.namedQueryUpdateProductCategoryById", query = "Update Product set category = ?1 where pid = ?2")
public class Product {
	
	@Id
	@GeneratedValue
	private int pid;
	private String productName;
	private String category;
	private double price;
	private int stock;
	
	public Product() {
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
