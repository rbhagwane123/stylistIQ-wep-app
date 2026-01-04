package com.stylistiq.service;

import org.apache.coyote.BadRequestException;

import com.stylistiq.model.dto.request.UploadRequest;

public interface ClothesService {

	public Object createCloth(UploadRequest req) throws BadRequestException;

//	public Cloth findClothById(Long clothId);

//	public List<Cloth> findClothByCategory(String categoryName);

}
