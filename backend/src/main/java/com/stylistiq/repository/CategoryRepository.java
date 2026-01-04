package com.stylistiq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stylistiq.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	public Category findByCategoryNameIgnoreCase(String categoryName);
	
	
	
//	@Query("SELECT c FROM category c WHERE c.category_name = :category_name")
//	public Category findCategoryByName(@Param("category_name")String categoryName);
}
