package com.umang.sporty.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Purchase;
import com.umang.sporty.repository.ProductRepository;
import com.umang.sporty.repository.PurchaseRepository;
import com.umang.sporty.service.PurchaseService;
@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Purchase createPurchase(Purchase purchase) throws BusinessException {
		purchase.setPurchaseDate(Date.valueOf(LocalDate.now()));
		int productId = purchase.getProductId();
		if(productRepository.findById(productId).isPresent() == false)
			throw new BusinessException("No Product found with Product Id = "+productId);
		return repository.save(purchase);
	}

	@Override
	public List<Purchase> getPurchaseByPurchaseDate(java.sql.Date date) throws BusinessException {
		List<Purchase> listOfPurchase =  repository.findByPurchaseDate(date);
		if(listOfPurchase.size()==0) {
			throw new BusinessException("No Purchase found with date = "+date);
	    }
		return listOfPurchase;
	}

	@Override
	public List<Purchase> getPurchaseByCategory(String category) throws BusinessException {
		List<Purchase> listOfPurchase =  repository.findByCategory(category);
		if(listOfPurchase.size()==0) {
			throw new BusinessException("No Purchase found with category = "+category);
	    }
		return listOfPurchase;
	}

	@Override
	public List<Purchase> getAllPurchase() throws BusinessException {
		List<Purchase> listOfPurchase =  repository.findAll();
		if(listOfPurchase.size()==0) {
			throw new BusinessException("No Purchases found.");
	    }
		return listOfPurchase;
	}

}
