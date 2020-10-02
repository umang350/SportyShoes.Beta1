package com.umang.sporty.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Purchase;
import com.umang.sporty.service.PurchaseService;

@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService service;
	private MultiValueMap<String, String> errorMap;
	
	@GetMapping("/purchases")
	public ResponseEntity<List<Purchase>> getPurchases(){
		try {
			return new ResponseEntity<>(service.getAllPurchase(),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
		try {
			return new ResponseEntity<>(service.createPurchase(purchase),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/purchase/category/{category}")
	public ResponseEntity<List<Purchase>> getAllPurchaseByCategory(@PathVariable String category){
		try {
			return new ResponseEntity<>(service.getPurchaseByCategory(category),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/purchase/date/{date}/{month}/{year}")
	public ResponseEntity<List<Purchase>> getAllPurchaseByDate(@PathVariable String date,@PathVariable String month,@PathVariable String year){
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		String dateFormatNon = date+"-"+month+"-"+year;
		java.util.Date dateFormated;
		try {
			dateFormated = sdf1.parse(dateFormatNon);
			java.sql.Date sqlDate = new java.sql.Date(dateFormated.getTime());  
			return new ResponseEntity<>(service.getPurchaseByPurchaseDate(sqlDate),HttpStatus.OK);
		} catch (ParseException | BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
		
	}
}
