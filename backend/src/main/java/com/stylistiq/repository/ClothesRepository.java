package com.stylistiq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stylistiq.model.entity.Category;
import com.stylistiq.model.entity.Cloth;

public interface ClothesRepository extends JpaRepository<Cloth, Long>{
	
//	public Cloth findClothById(Long id);
//	
//	public List<Cloth> findClothByCategory(String categoryName);
//	
//	public Optional<Category> findByNameIgnoreCase(String name);
}
