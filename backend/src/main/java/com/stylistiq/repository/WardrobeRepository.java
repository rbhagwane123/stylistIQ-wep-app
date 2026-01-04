package com.stylistiq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.model.entity.Wardrobe;

public interface WardrobeRepository extends JpaRepository<Wardrobe, Long> {

//	@Query("""
//			SELECT DISTINCT w FROM Wardrobe w
//			JOIN FETCH w.cloth c
//			JOIN FETCH c.clothImg ci
//			JOIN FETCH ci.imgAttribute
//			WHERE w.user.userId = :userId
//				""")
//	List<Wardrobe> findFullWardrobeByUserId(@Param("userId") Long userId);

	@Query("""
			SELECT w FROM Wardrobe w
			JOIN FETCH w.cloth c
			WHERE w.user.userId = :userId
			""")
	List<Wardrobe> findWardrobeWithCloth(Long userId);


}
