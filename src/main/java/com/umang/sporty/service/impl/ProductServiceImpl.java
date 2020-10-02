package com.umang.sporty.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.umang.sporty.exceptionHandler.BusinessException;
import com.umang.sporty.model.Product;
import com.umang.sporty.repository.ProductRepository;
import com.umang.sporty.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product getProductById(int pid) throws BusinessException {
		Product product = null;
		try {
			if(pid<=0) {
				throw new BusinessException("Id cannot be negative or zero");
			}
			product = repository.findById(pid).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Product found with id = "+pid);
		}
		return product;
	}

	@Override
	public List<Product> getProductByName(String name) throws BusinessException {
		List<Product> listOfProducts = repository.findByProductName(name);
		if(listOfProducts.size()==0) {
			throw new BusinessException("No Product found with name = "+name);
	    }
		return listOfProducts;
	}

	@Override
	public List<Product> getProductByCategory(String category) throws BusinessException {
		List<Product> listOfProducts =  repository.findByCategory(category);
		if(listOfProducts.size()==0) {
			throw new BusinessException("No Product found with category = "+category);
	    }
		return listOfProducts;
	}

	@Override
	public List<Product> getProductByPrice(double price) throws BusinessException {
		List<Product> listOfProducts =  repository.findByPrice(price);
		if(listOfProducts.size()==0) {
			throw new BusinessException("No Product found with price = "+price);
	    }
		return listOfProducts;
	}

	@Override
	public List<Product> getProductByStock(int stock) throws BusinessException {
		List<Product> listOfProducts =  repository.findByStock(stock);
		if(listOfProducts.size()==0) {
			throw new BusinessException("No Product found with stock = "+stock);
	    }
		return listOfProducts;
	}


	@Override
	public Product updateProductCategoryById(int id, String category) throws BusinessException {
		Product product = null;
		try {
			if(id<=0) {
				throw new BusinessException("Id cannot be negative or zero");
			}
			repository.updateProductCategoryById(id,category);
			product = repository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No Product found with id = "+id);
		}
		return product;
	}

	@Override
	public List<String> getAllCategory() throws BusinessException {
		List<String> listOfCategory = repository.findAllCategory();
		if(listOfCategory.size()==0) {
			throw new BusinessException("No Category found.");
	    }
		return listOfCategory;
	}

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> listOfProducts = repository.findAll();
		if(listOfProducts.size()==0) {
			throw new BusinessException("No Products found.");
	    }
		return listOfProducts;
	}

	@Override
	public String deleteProduct(int pid) throws BusinessException {
		String output = null;
		try {
			if(pid<=0) {
				throw new BusinessException("Id cannot be negative or zero");
			}
			repository.deleteById(pid);
			output = "Successfully Deleted";
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("No Product found with id = "+pid);
		}
		return output;
	}

}
