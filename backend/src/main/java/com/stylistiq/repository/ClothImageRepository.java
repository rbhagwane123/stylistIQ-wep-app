package com.stylistiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stylistiq.model.entity.ClothImage;

public interface ClothImageRepository extends JpaRepository<ClothImage, Long> {

	@Query("""
			SELECT ci FROM ClothImage ci
			WHERE ci.cloth.clothId IN :clothIds
			""")
	List<ClothImage> findImagesByClothIds(List<Long> clothIds);

}
