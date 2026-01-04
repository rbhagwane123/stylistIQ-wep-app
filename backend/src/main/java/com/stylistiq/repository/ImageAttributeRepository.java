package com.stylistiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stylistiq.model.entity.ImageAttribute;

public interface ImageAttributeRepository extends JpaRepository<ImageAttribute, Long> {

	@Query("""
			SELECT ia FROM ImageAttribute ia
			WHERE ia.clothImage.imageId IN :imageIds
			""")
	List<ImageAttribute> findAttributesByImageIds(@Param("imageIds") List<Long> imageIds);

}
