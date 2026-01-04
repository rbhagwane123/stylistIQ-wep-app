package com.stylistiq.service;

import java.util.List;

import com.stylistiq.model.entity.ImageAttribute;

public interface ImageAttributeService {

	public ImageAttribute createImageAttribute(ImageAttribute imageAttribute);

	public List<ImageAttribute> findAttributesByImageIds(List<Long> imageIds);
}
