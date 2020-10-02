package com.umang.sporty.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.umang.sporty.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findByProductName(String name);
	public List<Product> findByCategory(String category);
	public List<Product> findByPrice(double price);
	public List<Product> findByStock(int stock);
	
	@Query("SELECT DISTINCT category From Product")
	public List<String> findAllCategory();
	
	@Transactional
	@Modifying
	@Query("Update Product set category = (:category) where pid = (:pid)")
	public void updateProductCategoryById(@Param("pid") int pid,@Param("category") String category);
//	public Product namedQueryUpdateProductCategoryById(String category, int pid);


}
