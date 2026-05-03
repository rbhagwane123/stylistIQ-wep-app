package com.stylistiq.repository;

import java.util.List;
import java.util.Optional;

import com.stylistiq.model.response.WardrobeResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stylistiq.model.entity.ClothImage;
import com.stylistiq.model.entity.ImageAttribute;
import com.stylistiq.model.entity.Wardrobe;

public interface WardrobeRepository extends JpaRepository<Wardrobe, Long> {

    @Query("""
            SELECT new com.stylistiq.model.response.WardrobeResponseDTO
            (
                w.wardrobeId,
                w.createdAt,
                c.description,
                ci.imageUrl,
                ia.primaryColor,
                ia.secondaryColor,
                ia.fabricType
            )
            FROM Wardrobe w
            JOIN w.cloth c
            JOIN c.clothImg ci
            JOIN ci.imgAttribute ia
            WHERE w.user.userId = :userId
            AND ci.imageId = (
                SELECT MAX(ci2.imageId)
                FROM ClothImage ci2
                WHERE ci2.cloth.clothId = c.clothId
            )
            AND ia.attributeId = (
                SELECT MIN(ia2.attributeId)
                FROM ImageAttribute ia2
                WHERE ia2.clothImage.imageId = ci.imageId
            )
            """)
    public List<WardrobeResponseDTO> findByUserId(@Param("userId") Long userId);


    @Query("SELECT COUNT(*) FROM Wardrobe w WHERE w.user.userId=:userId")
    public int findWardrobeCount(@Param("userId") Long userId);

}
