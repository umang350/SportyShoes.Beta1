package com.umang.sporty.service;

import java.util.List;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Purchase;

public interface PurchaseService {
	
	public Purchase createPurchase(Purchase purchase);
	public List<Purchase> getPurchaseByPurchaseDate(java.sql.Date date) throws BusinessException;
	public List<Purchase> getPurchaseByCategory(String category) throws BusinessException;
	public List<Purchase> getAllPurchase() throws BusinessException;
	
}
