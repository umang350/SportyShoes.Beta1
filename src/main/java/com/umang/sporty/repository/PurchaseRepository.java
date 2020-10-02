package com.umang.sporty.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umang.sporty.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	public List<Purchase> findByPurchaseDate(java.sql.Date date);
	public List<Purchase> findByCategory(String category);
	
	
}
