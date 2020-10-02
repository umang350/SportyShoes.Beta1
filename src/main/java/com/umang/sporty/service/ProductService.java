package com.umang.sporty.service;

import java.util.List;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public List<Product> getAllProducts() throws BusinessException;
	public Product getProductById(int pid) throws BusinessException;
	public List<Product> getProductByName(String name) throws BusinessException;
	public List<Product> getProductByCategory(String category) throws BusinessException;
	public List<Product> getProductByPrice(double price) throws BusinessException;
	public List<Product> getProductByStock(int stock) throws BusinessException;
	
	public String deleteProduct(int pid) throws BusinessException;
	public Product updateProductCategoryById(int id, String category) throws BusinessException;
	public List<String> getAllCategory() throws BusinessException;

	
	
}
