package com.umang.sporty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Product;
import com.umang.sporty.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	private MultiValueMap<String, String> errorMap;
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		try {
			return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		
		try {
			return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/name/{name}")
	public ResponseEntity<List<Product>> getAllProductByName(@PathVariable String name){
		try {
			return new ResponseEntity<>(service.getProductByName(name),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/category/{category}")
	public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable String category){
		try {
			return new ResponseEntity<>(service.getProductByCategory(category),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/product/{id}/category")
	public ResponseEntity<Product> updateCategoryById(@PathVariable int id,@RequestBody String category) {
		try {
			return new ResponseEntity<>(service.updateProductCategoryById(id,category),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/price/{price}")
	public ResponseEntity<List<Product>> getAllProductByPrice(@PathVariable double price){
		try {
			return new ResponseEntity<>(service.getProductByPrice(price),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/stock/{stock}")
	public ResponseEntity<List<Product>> getAllProductByStock(@PathVariable int stock){
		try {
			return new ResponseEntity<>(service.getProductByStock(stock),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/product/categoryAll")
	public ResponseEntity<List<String>> getAllCategory(){
		try {
			return new ResponseEntity<>(service.getAllCategory(),HttpStatus.OK);
		}catch(BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.deleteProduct(id),HttpStatus.OK);
		} catch (BusinessException e) {
			errorMap=new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null,errorMap,HttpStatus.NOT_FOUND);
		}
		
	}
}
