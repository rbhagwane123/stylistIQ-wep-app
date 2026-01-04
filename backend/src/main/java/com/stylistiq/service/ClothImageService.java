package com.stylistiq.service;

import java.util.List;

import com.stylistiq.model.entity.ClothImage;

public interface ClothImageService {
	
	public ClothImage createClothImage(ClothImage clothImage);
	
	public List<ClothImage> findImagesByClothIds(List<Long> clothIds);

}
